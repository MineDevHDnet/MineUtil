package net.minedevhd.mineutil.modules.griefergames;

import java.lang.reflect.Array;

import net.labymod.api.events.MessageReceiveEvent;
import net.labymod.ingamechat.GuiChatCustom;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minedevhd.mineutil.settings.UtilCore;
import net.minedevhd.mineutil.utils.tech.Reflection;

public final class PlotChatIndicator implements UtilCore {

    private static boolean plotChatState;
    private static boolean reversePlotChat;

    public static void initModule() {
        mineUtil.getApi().getEventManager().register(new MessageReceiveEvent() {
            @Override
            public boolean onReceive(final String formatted, final String unformatted) {
                if (!mineUtil.isOnGrieferGames()) {
                    return false;
                }

                if (formatted != null && formatted.matches(
                        "^§r§8\\[§r§6GrieferGames§r§8] §r§.Die Einstellung §r§.chat §r§.wurde (?:de)?aktiviert\\.§r$")) {
                    plotChatState = formatted.contains(" aktiviert");
                    if (reversePlotChat) {
                        mineUtil.sendQueued("/plot chat");
                        reversePlotChat = false;
                    }
                }

                if (unformatted == null) {
                    return false;
                }

                if (unformatted.contains("Du bist im Portalraum. Wähle deinen Citybuild aus.")) {
                    plotChatState = false;
                    reversePlotChat = false;
                    return false;
                }

                if (unformatted.contains("Deine Daten wurden vollständig heruntergeladen.")) {
                    // Probe the current plot-chat state once. When the server answers,
                    // reversePlotChat restores the original value immediately.
                    mineUtil.sendQueued("/plot chat");
                    reversePlotChat = true;
                    return true;
                }

                return false;
            }
        });
    }

    @SubscribeEvent
    public void onRender(final RenderGameOverlayEvent.Post event) {
        if (!plotChatState || event == null || event.type != RenderGameOverlayEvent.ElementType.CHAT) {
            return;
        }

        final Minecraft minecraft = mineUtil.getMinecraft();
        if (minecraft == null || !(minecraft.currentScreen instanceof GuiChat)) {
            return;
        }

        final GuiScreen chatScreen = minecraft.currentScreen;
        final int buttonWidth = getChatButtonWidth(chatScreen);
        final int color = 0xFFFFA126;
        final int right = Math.max(3, chatScreen.width - 2 - buttonWidth);

        GuiScreen.drawRect(2, chatScreen.height - 14, right, chatScreen.height - 2, 100 << 24);
        GuiScreen.drawRect(1, chatScreen.height - 15, right + 1, chatScreen.height - 14, color);
        GuiScreen.drawRect(1, chatScreen.height - 2, right + 1, chatScreen.height - 1, color);
        GuiScreen.drawRect(1, chatScreen.height - 15, 2, chatScreen.height - 1, color);
        GuiScreen.drawRect(right, chatScreen.height - 15, right + 1, chatScreen.height - 1, color);
    }

    private int getChatButtonWidth(final GuiScreen screen) {
        if (!(screen instanceof GuiChatCustom)) {
            return 0;
        }

        try {
            final Object chatButtons = Reflection.get(screen, "chatButtons");
            if (chatButtons == null || !chatButtons.getClass().isArray()) {
                return 0;
            }
            return Array.getLength(chatButtons) * 14;
        } catch (final RuntimeException exception) {
            return 0;
        }
    }
}
