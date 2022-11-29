package net.minedevhd.mineutil.modules.griefergames;

import java.lang.reflect.Array;
import java.util.HashMap;

import net.labymod.api.events.MessageReceiveEvent;
import net.labymod.ingamechat.GuiChatCustom;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S3FPacketCustomPayload;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.settings.UtilCore;
import net.minedevhd.mineutil.utils.tech.Reflection;

public class PlotChatIndicator implements UtilCore {

	private static MineUtil mineUtil = MineUtil.getCore();
	private static Minecraft mc = MineUtil.getCore().getMinecraft();
	private static final HashMap<String, Boolean> states = new HashMap<>();

	private static String server = "";
	private static boolean plotchatState = false,
						   reversePlotChat = false;
	
	public static void initModule() {
		mineUtil.getApi().getEventManager().register((MessageReceiveEvent) new MessageReceiveEvent() {
			@Override
			public boolean onReceive(String formatted, String unformatted) {
				if(mineUtil.isOnGrieferGames()) {
			        // Update plot chat state
			        if(formatted.matches("^§r§8\\[§r§6GrieferGames§r§8] §r§.Die Einstellung §r§.chat §r§.wurde (?:de)?aktiviert\\.§r$")) {
			            plotchatState = formatted.contains(" aktiviert");
			            if(reversePlotChat) {
			            	mineUtil.sendQueued("/plot chat");
			            	reversePlotChat = false;
			            }
						states.put(server, plotchatState);
			        }
			        if(unformatted.contains("Du bist im Portalraum. Wähle deinen Citybuild aus.")) {
			        	states.clear();
			        	plotchatState = false;
			        	server = "";
			        }
			        if(unformatted.contains("Deine Daten wurden vollständig heruntergeladen.")) {
			        	mineUtil.sendQueued("/plot chat");
			        	reversePlotChat = true;
			        	return true;
			        }
				}
				return false;
			}
		});
	}

	@SubscribeEvent
    public void onRender(RenderGameOverlayEvent.Post event) {
        if (!plotchatState)
            return;

        // Check if chat is open
	    if (event.type != RenderGameOverlayEvent.ElementType.CHAT)
			return;

	    GuiScreen gcc = mc.currentScreen;
	    if (!(gcc instanceof GuiChat))
	        return;
	    
	    int buttonWidth = (gcc instanceof GuiChatCustom ? Array.getLength(Reflection.get(gcc, "chatButtons")) * 14 : 0);
	    int color = 0xFFFFA126;

	    // Render frame
	    GuiScreen.drawRect(2, gcc.height - 14, gcc.width - 2 - buttonWidth, gcc.height - 2, 100 << 24);

	    GuiScreen.drawRect(1, gcc.height - 15, gcc.width - 1 - buttonWidth, gcc.height - 14, color);
	    GuiScreen.drawRect(1, gcc.height - 2, gcc.width - 1 - buttonWidth, gcc.height - 1, color);
	    GuiScreen.drawRect(1, gcc.height - 15, 2, gcc.height - 1, color);
	    GuiScreen.drawRect(gcc.width - 2 - buttonWidth, gcc.height - 15, gcc.width - 1 - buttonWidth, gcc.height - 1, color);
    }
	
}
