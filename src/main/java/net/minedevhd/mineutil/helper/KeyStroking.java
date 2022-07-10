package net.minedevhd.mineutil.helper;

import org.lwjgl.input.Keyboard;

import net.labymod.utils.ModColor;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.MineUtil.CGui;
import net.minedevhd.mineutil.command.Command;
import net.minedevhd.mineutil.command.CommandManager;
import net.minedevhd.mineutil.command.impl.Help;
import net.minedevhd.mineutil.gui.cleanandcraft.*;
import net.minedevhd.mineutil.gui.cleanandcraft.ausrangiert.*;
import net.minedevhd.mineutil.utils.render.HeadOwnerUtil;

public class KeyStroking {

	private final MineUtil mineUtil = MineUtil.getUtilCore();
	private final Minecraft mc = mineUtil.getMCCore();
	
    @SubscribeEvent
    public void onKeyPress(final InputEvent.KeyInputEvent event) {
        if(mineUtil.getSettings().getModEnabled() && mineUtil.getSettings().getModMenuKey() != -1) {
	        if(Keyboard.isKeyDown((int) mineUtil.getSettings().getModMenuKey())) {
	        	switch(mineUtil.getSettings().getCurrentGuiPage()) {
				case 1:
					this.mc.displayGuiScreen(new CleanCraftOreGui());
					break;
				case 2:
					this.mc.displayGuiScreen(new CleanCraftStoneGui());
					break;
				case 3:
					this.mc.displayGuiScreen(new CleanCraftSandGui());
					break;
				case 4:
					this.mc.displayGuiScreen(new CleanCraftRedstoneGui());
					break;
				case 5:
					this.mc.displayGuiScreen(new CleanCraftNetherGui());
					break;
				case 6:
					this.mc.displayGuiScreen(new CleanCraftPrismarineGui());
					break;
				case 7:
					this.mc.displayGuiScreen(new CleanCraftOthersGui());
					break;
				case 8:
					this.mc.displayGuiScreen(new CleanCraftOthers2Gui());
					break;
//				case 9:
//					this.mc.displayGuiScreen(new CleanCraftGui9());
//					break;
//				case 10:
//					this.mc.displayGuiScreen(new CleanCraftGui10());
//					break;
				default:
					this.mc.displayGuiScreen(new CleanCraftOreGui());
					break;
				}
	        	CGui.setGUIToggled(!CGui.isGUIToggled());
	        }
	        else
	        	if(Keyboard.isKeyDown((int) mineUtil.getSettings().getModHeadOwnerKey())) {
                    final HeadOwnerUtil.Skull skull = HeadOwnerUtil.getSkullLooking();
                    final String name = skull.getCopy();
                    
                    try {
                    	mineUtil.getApi().displayMessageInChat(mineUtil.getSettings().getPrefix() + "§aKopfdaten wurden in die Zwischenablage kopiert.");
                    }
                    catch(Exception exception) {
                    	mineUtil.getApi().displayMessageInChat(mineUtil.getSettings().getPrefix() + "§cCan't modify clipboard :/");
                    }
                }
        }
    }
}
