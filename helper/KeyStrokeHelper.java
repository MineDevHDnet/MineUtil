package net.minedevhd.mineutil.helper;

import org.lwjgl.input.Keyboard;

import net.labymod.main.LabyMod;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.MineUtil.CCGui;
import net.minedevhd.mineutil.games.GameGui;
import net.minedevhd.mineutil.games.pong.PongGameFrame;
import net.minedevhd.mineutil.games.pong.PongGame;
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

public class KeyStrokeHelper implements UtilCore {

	private final Minecraft mc = mineUtil.getMinecraft();
	
    @SubscribeEvent
    public void onKeyPress(final InputEvent.KeyInputEvent event) {
        if(mineUtil.getSettings().getModMenuKey() != -1) {
	        if(Keyboard.isKeyDown((int) mineUtil.getSettings().getModMenuKey())) {
	        	if(mineUtil.getSettings().isModEnabled()) {
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
					case 9:
						this.mc.displayGuiScreen(new CleanCraftWoolGui());
						break;
					case 10:
						this.mc.displayGuiScreen(new CleanCraftGlassGui());
						break;
					case 11:
						this.mc.displayGuiScreen(new CleanCraftClayGui());
						break;
					case 12:
						this.mc.displayGuiScreen(new CleanCraftColorGui());
						break;
					case 13:
						this.mc.displayGuiScreen(new CleanCraftFoodGui());
						break;
					default:
						this.mc.displayGuiScreen(new CleanCraftOreGui());
						break;
					}
	        		CCGui.setGUIToggled(!CCGui.isGUIToggled());
	        	}
	        	else
		        	LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() 
		        			+ "§cThe addon is deactivated also the crafter (guis) is not availabe!");
        	}
	        else
	        	if(Keyboard.isKeyDown((int) mineUtil.getSettings().getModHeadOwnerKey())) {
	                final HeadOwnerUtil.Skull skull = HeadOwnerUtil.getSkullLooking();
	                final String name = skull.getCopy();
	                
	                if(mineUtil.getSettings().isModEnabled())
	                	LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() 
	    	        			+ "§cThe addon is deactivated also the headowner mod is not availabe!");
	                else
		                try {
		                	mineUtil.getApi().displayMessageInChat(mineUtil.getSettings().getPrefix() + "§aHeader data has been copied to the clipboard.");
		                } catch(Exception exception) {
		                	mineUtil.getApi().displayMessageInChat(mineUtil.getSettings().getPrefix() + "§cCan't modify clipboard :/");
		                }
		        }
	        	else
		    		if(Keyboard.isKeyDown((int) mineUtil.getSettings().getModNGMenuKey())) {
		    			if(mineUtil.getSettings().isModEnabled())
		    				this.mc.displayGuiScreen(new NextGenCraftGui());
		    			else
		    				LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() 
		    	        			+ "§cThe addon is deactivated also the next-gen crafter (guis) is not availabe!");
			        }
		    		else
			    		if(Keyboard.isKeyDown((int) mineUtil.getSettings().getGameGuiKey())) {
							if(mineUtil.getSettings().isModEnabled())
								this.mc.displayGuiScreen(new GameGui());
							else
								LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() 
					        			+ "§cThe addon is deactivated also all games are not availabe!");
				        }
        }
        
    }
}
