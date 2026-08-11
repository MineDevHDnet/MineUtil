package net.minedevhd.mineutil.helper;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

import org.lwjgl.input.Keyboard;

import net.labymod.main.LabyMod;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minedevhd.mineutil.MineUtil.CCGui;
import net.minedevhd.mineutil.games.GameGui;
import net.minedevhd.mineutil.gui.cleanandcraft.CleanCraftClayGui;
import net.minedevhd.mineutil.gui.cleanandcraft.CleanCraftColorGui;
import net.minedevhd.mineutil.gui.cleanandcraft.CleanCraftFoodGui;
import net.minedevhd.mineutil.gui.cleanandcraft.CleanCraftGlassGui;
import net.minedevhd.mineutil.gui.cleanandcraft.CleanCraftNetherGui;
import net.minedevhd.mineutil.gui.cleanandcraft.CleanCraftOreGui;
import net.minedevhd.mineutil.gui.cleanandcraft.CleanCraftOthers2Gui;
import net.minedevhd.mineutil.gui.cleanandcraft.CleanCraftOthersGui;
import net.minedevhd.mineutil.gui.cleanandcraft.CleanCraftPrismarineGui;
import net.minedevhd.mineutil.gui.cleanandcraft.CleanCraftRedstoneGui;
import net.minedevhd.mineutil.gui.cleanandcraft.CleanCraftSandGui;
import net.minedevhd.mineutil.gui.cleanandcraft.CleanCraftStoneGui;
import net.minedevhd.mineutil.gui.cleanandcraft.CleanCraftWoolGui;
import net.minedevhd.mineutil.gui.cleanandcraft.NextGenCraftGui;
import net.minedevhd.mineutil.settings.UtilCore;
import net.minedevhd.mineutil.utils.HeadOwnerUtil;

public final class KeyStrokeHelper implements UtilCore {

    @SubscribeEvent
    public void onKeyPress(final InputEvent.KeyInputEvent event) {
        if (!Keyboard.getEventKeyState()) {
            return;
        }

        final int pressedKey = Keyboard.getEventKey();
        if (pressedKey == Keyboard.KEY_NONE || mineUtil.getSettings() == null) {
            return;
        }

        if (matchesConfiguredKey(pressedKey, mineUtil.getSettings().getModMenuKey())) {
            openClassicMenu();
            return;
        }

        if (matchesConfiguredKey(pressedKey, mineUtil.getSettings().getModHeadOwnerKey())) {
            copyHeadOwnerData();
            return;
        }

        if (matchesConfiguredKey(pressedKey, mineUtil.getSettings().getModNGMenuKey())) {
            if (requireEnabled("§cThe addon is deactivated, so the next-gen crafter is unavailable!")) {
                getMinecraft().displayGuiScreen(new NextGenCraftGui());
            }
            return;
        }

        if (matchesConfiguredKey(pressedKey, mineUtil.getSettings().getGameGuiKey())) {
            if (requireEnabled("§cThe addon is deactivated, so the games are unavailable!")) {
                getMinecraft().displayGuiScreen(new GameGui());
            }
        }
    }

    private boolean matchesConfiguredKey(final int pressedKey, final Integer configuredKey) {
        return configuredKey != null && configuredKey != -1 && pressedKey == configuredKey;
    }

    private Minecraft getMinecraft() {
        return mineUtil.getMinecraft();
    }

    private boolean requireEnabled(final String disabledMessage) {
        if (mineUtil.getSettings().isModEnabled()) {
            return true;
        }
        LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() + disabledMessage);
        return false;
    }

    private void openClassicMenu() {
        if (!requireEnabled("§cThe addon is deactivated, so the crafter menus are unavailable!")) {
            return;
        }

        switch (mineUtil.getSettings().getCurrentGuiPage()) {
            case 1:
                getMinecraft().displayGuiScreen(new CleanCraftOreGui());
                break;
            case 2:
                getMinecraft().displayGuiScreen(new CleanCraftStoneGui());
                break;
            case 3:
                getMinecraft().displayGuiScreen(new CleanCraftSandGui());
                break;
            case 4:
                getMinecraft().displayGuiScreen(new CleanCraftRedstoneGui());
                break;
            case 5:
                getMinecraft().displayGuiScreen(new CleanCraftNetherGui());
                break;
            case 6:
                getMinecraft().displayGuiScreen(new CleanCraftPrismarineGui());
                break;
            case 7:
                getMinecraft().displayGuiScreen(new CleanCraftOthersGui());
                break;
            case 8:
                getMinecraft().displayGuiScreen(new CleanCraftOthers2Gui());
                break;
            case 9:
                getMinecraft().displayGuiScreen(new CleanCraftWoolGui());
                break;
            case 10:
                getMinecraft().displayGuiScreen(new CleanCraftGlassGui());
                break;
            case 11:
                getMinecraft().displayGuiScreen(new CleanCraftClayGui());
                break;
            case 12:
                getMinecraft().displayGuiScreen(new CleanCraftColorGui());
                break;
            case 13:
                getMinecraft().displayGuiScreen(new CleanCraftFoodGui());
                break;
            default:
                getMinecraft().displayGuiScreen(new CleanCraftOreGui());
                break;
        }
        CCGui.setGUIToggled(!CCGui.isGUIToggled());
    }

    private void copyHeadOwnerData() {
        if (!requireEnabled("§cThe addon is deactivated, so the head-owner module is unavailable!")) {
            return;
        }

        final HeadOwnerUtil.Skull skull = HeadOwnerUtil.getSkullLooking();
        if (skull == null || !skull.isShown()) {
            mineUtil.getApi().displayMessageInChat(
                    mineUtil.getSettings().getPrefix() + "§cNo player head is currently targeted."
            );
            return;
        }

        try {
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(
                    new StringSelection(skull.getCopy()),
                    null
            );
            mineUtil.getApi().displayMessageInChat(
                    mineUtil.getSettings().getPrefix() + "§aHead data copied to the clipboard."
            );
        } catch (final RuntimeException exception) {
            mineUtil.getApi().displayMessageInChat(
                    mineUtil.getSettings().getPrefix() + "§cCouldn't access the clipboard."
            );
        }
    }
}
