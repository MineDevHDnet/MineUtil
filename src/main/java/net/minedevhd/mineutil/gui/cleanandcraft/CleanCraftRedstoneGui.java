package net.minedevhd.mineutil.gui.cleanandcraft;

import java.io.IOException;

import net.labymod.core.LabyModCore;
import net.labymod.utils.ModColor;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.init.Items;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.MineUtil.CCGui;
import net.minedevhd.mineutil.gui.changelog.ChangelogGui;
import net.minedevhd.mineutil.gui.storageprices.TEDLagerPreisGui;
import net.minedevhd.mineutil.utils.ModButton;
import net.minedevhd.mineutil.utils.ModButton.API;
import net.minedevhd.mineutil.utils.RenderUtils;

public class CleanCraftRedstoneGui extends GuiScreen {

    GuiButton cleanSpawnerButton,
    		  cleanChestInventoryButton,
    		  
    		  craftRedstoneLampButton,
    		  craftCompassButton,
    		  craftMapButton,
    		  craftRedstoneComperatorButton,
    		  craftRedstoneRepeaterButton,
    		  craftDispenserButton,
    		  craftDropperButton,
    		  craftHopperButton,
    		  craftRedstoneTorchButton,
    		  craftRedstoneChestButton,
    		  craftTripwireHookButton,
    		  craftPistonButton,
    		  craftStickyPistonButton,
    		  craftNoteblockButton,
    		  craftJukeboxButton,
    		  craftClockButton,
    		  
    		  pageNextButton,
    		  pagePrevButton,
    		  closeButton,
    		  closeCraftButton,
    		  deactivateButton,
    		  changeLogButton;
    
    public CleanCraftRedstoneGui() {
    /**
        Sort list:
          > Ore
          > Stone
          > Sand
          > Redstone
          > Nether
          > Prismarine
          > Others
          > Others2
          > Wool
          > Glass
          > Clay
          > Color
          > Food
    */
    }
    
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
    	RenderUtils.renderNewGuiBackground();
    	MineUtil.getUtilCore().getSettings().setCurrentGuiPage(4);
    	
    	this.drawCenteredString(this.fontRendererObj, "Cleaning and Crafting", this.width / 2, ModButton.API.getButtonYPos(0, true) + 5, ModButton.toRainbow(18));
        this.drawCenteredString(this.fontRendererObj, "- Page 4 of 13 -", this.width / 2, 18, 16777215);
        
        this.drawString(this.fontRendererObj, "Cleaning", ModButton.API.getButtonXPos(1, this.width) + 1, ModButton.API.getButtonYPos(1, true) + 8, 16777215);
        this.drawString(this.fontRendererObj, "Crafting - Redstone", ModButton.API.getButtonXPos(1, this.width) + 1, ModButton.API.getButtonYPos(4, true) + 8, 16777215);
    	super.drawScreen(mouseX, mouseY, partialTicks);
    }
    
    @Override
    public void initGui() {
    	/** Cat. Cleaning */
    	this.buttonList.add(this.cleanSpawnerButton = new ModButton(200, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(2), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Spawner: OFF"));
    	this.buttonList.add(this.cleanChestInventoryButton = new ModButton(210, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(2), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ChestInventory: OFF"));
    	
    	/** Cat. Crafting */
    	this.buttonList.add(this.craftRedstoneLampButton = new ModButton(300, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "RedstoneLamp: OFF"));
    	this.buttonList.add(this.craftCompassButton = new ModButton(310, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Compass: OFF"));
    	this.buttonList.add(this.craftRedstoneComperatorButton = new ModButton(320, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Comperator: OFF"));
    	this.buttonList.add(this.craftRedstoneRepeaterButton = new ModButton(330, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Repeater: OFF"));
    	this.buttonList.add(this.craftDispenserButton = new ModButton(340, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Dispenser: OFF"));
    	this.buttonList.add(this.craftDropperButton = new ModButton(350, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Dropper: OFF"));
    	this.buttonList.add(this.craftHopperButton = new ModButton(360, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Hopper: OFF"));
    	this.buttonList.add(this.craftRedstoneTorchButton = new ModButton(370, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "RedstoneTorch: OFF"));
    	this.buttonList.add(this.craftRedstoneChestButton = new ModButton(380, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "RedstoneChest: OFF"));
    	this.buttonList.add(this.craftTripwireHookButton = new ModButton(390, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "TripwireHook: OFF"));
    	this.buttonList.add(this.craftPistonButton = new ModButton(400, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Piston: OFF"));
    	this.buttonList.add(this.craftStickyPistonButton = new ModButton(410, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "StickyPiston: OFF"));
    	this.buttonList.add(this.craftNoteblockButton = new ModButton(420, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Noteblock: OFF"));
    	this.buttonList.add(this.craftJukeboxButton = new ModButton(430, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Jukebox: OFF"));
    	this.buttonList.add(this.craftClockButton = new ModButton(440, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Clock: OFF"));
    	this.buttonList.add(this.craftMapButton = new ModButton(450, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Map: OFF"));
        
    	/** Close, etc. */
    	this.buttonList.add(this.pagePrevButton = new ModButton(100, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(9), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "<< BACK"));
        this.buttonList.add(this.pageNextButton = new ModButton(110, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(9), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "FORWARD >>"));
        this.buttonList.add(this.closeCraftButton = new ModButton(120, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(11), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "CLOSE and CRAFT"));
        this.buttonList.add(this.deactivateButton = new ModButton(130, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(12), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "DISABLE"));
        this.buttonList.add(this.closeButton = new ModButton(140, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(12), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "CLOSE"));
        
//        this.buttonList.add(this.changeLogButton = new ModButton(150, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(12), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), ModColor.GOLD.toString() + "Changelog"));
//        this.buttonList.add(this.lagerPreisButton = new ModButton(160, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(12), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(),  ModColor.AQUA.toString() + "Lager Preise"));
        this.updateButtons();
    	super.initGui();
    }
    
    private final void addButton(GuiButton guiButton, final Integer buttonId, final Integer x, final Integer y, final String name) {
    	this.buttonList.add(guiButton = new ModButton(buttonId, ModButton.API.getButtonXPos(x, this.width), ModButton.API.getButtonYPos(y), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), name + ": OFF"));
    }
    
    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
    	try {
            boolean doAction = true;
            switch(button.id) {
	            case 100: {
	            	doAction = false;
	                this.mc.displayGuiScreen(new CleanCraftSandGui());
	                break;
	            }
	            case 110: {
	            	doAction = false;
	                this.mc.displayGuiScreen(new CleanCraftNetherGui());
	                break;
	            }
	            case 120: {
	            	doAction = false;
	            	this.mc.thePlayer.closeScreen();
	            	LabyModCore.getMinecraft().getPlayer().sendChatMessage("/craft");
	            	break;
	            }
	            case 130: {
	            	ModButton.API.a_617553_p(MineUtil.getUtilCore());
	                break;
	            }
	            case 140: {
	            	doAction = false;
	                this.mc.thePlayer.closeScreen();
	                break;
	            }
	            case 150: {
	            	doAction = false;
	            	this.mc.displayGuiScreen(new ChangelogGui());
	            	break;
	            }
	            case 160: {
	            	doAction = false;
	            	this.mc.displayGuiScreen(new TEDLagerPreisGui());
	            	break;
	            }
	            /** Cat. Cleaning */
                case 200: {
                    this.setSelection("Spawner", false);
                    break;
                }
                case 210: {
                    this.setSelection("ChestInventory", false);
                    break;
                }
	            /** Cat. Crafting */
                case 300: {
                    this.setSelection("RedstoneLamp", true);
                    break;
                }
                case 310: {
                    this.setSelection("Compass", true);
                	break;
                }
                case 320: {
                    this.setSelection("Comperator", true);
                    break;
                }
                case 330: {
                    this.setSelection("Repeater", true);
                    break;
                }
                case 340: {
                    this.setSelection("Dispenser", true);
                    break;
                }
                case 350: {
                    this.setSelection("Dropper", true);
                    break;
                }
                case 360: {
                    this.setSelection("Hopper", true);
                    break;
                }
                case 370: {
                    this.setSelection("RedstoneTorch", true);
                    break;
                }
                case 380: {
                    this.setSelection("RedstoneChest", true);
                    break;
                }
                case 390: {
                    this.setSelection("TripwireHook", true);
                    break;
                }
                case 400: {
                    this.setSelection("Piston", true);
                    break;
                }
                case 410: {
                    this.setSelection("StickyPiston", true);
                    break;
                }
                case 420: {
                    this.setSelection("Noteblock", true);
                    break;
                }
                case 430: {
                    this.setSelection("Jukebox", true);
                    break;
                }
                case 440: {
                    this.setSelection("Clock", true);
                    break;
                }
                case 450: {
                    this.setSelection("Map", true);
                    break;
                }
            }
            if(doAction) {
                this.updateButtons();
                super.actionPerformed(button);
            }
        } catch(Exception exception) {}
    }
    
    private String getButtonDisplayString(String displayString, final String type, final boolean crafting) {
        final String selection = crafting ? MineUtil.getUtilCore().getCraftSelection() : MineUtil.getUtilCore().getCleanSelection();
        displayString = displayString.replaceAll("(ON|OFF)", "") + (selection.equalsIgnoreCase(type) ? "ON" : "OFF");
        return displayString;
    }
    
    private void setSelection(final String type, final boolean crafting) {
        final String selection = crafting ? MineUtil.getUtilCore().getCraftSelection() : MineUtil.getUtilCore().getCleanSelection();
        final String setSel = selection.equalsIgnoreCase(type) ? "" : type;
        
        if(crafting) {
    		MineUtil.getUtilCore().setCraftSelection(setSel);
            if(setSel.length() > 0) {
            	final String sel = setSel.replace(": OFF", "").replace(": ON", "");
                MineUtil.getUtilCore().getApi().displayMessageInChat(MineUtil.getUtilCore().getSettings().getPrefix() 
                		+ "§7Module §eAutomatic Crafting §8(§7" + sel + "§8) §7has been §aactivated§7.");
            }
            else {
                MineUtil.getUtilCore().getApi().displayMessageInChat(MineUtil.getUtilCore().getSettings().getPrefix() 
                		+ "§7Module §eAutomatic Crafting §7has been §cdeactivated§7.");
            }
        }
        else {
            MineUtil.getUtilCore().setCleanSelection(setSel);
            if(setSel.length() > 0) {
            	final String sel = setSel.replace(": OFF", "").replace(": ON", "");
                MineUtil.getUtilCore().getApi().displayMessageInChat(MineUtil.getUtilCore().getSettings().getPrefix() 
                		+ "§7Module §eAutomatic Cleaning §8(§7" + sel + "§8) §7has been §aactivated§7.");
            }
            else {
                MineUtil.getUtilCore().getApi().displayMessageInChat(MineUtil.getUtilCore().getSettings().getPrefix() 
                		+ "§7Module §eAutomatic Cleaning §7has been §cdeactivated§7.");
            }
        }
    }
    
    private void updateButtons() {
//    	this.changeLogButton.enabled = true;
        if(MineUtil.getUtilCore().getCraftSelection().length() > 0 || MineUtil.getUtilCore().getCleanSelection().length() > 0) {
            this.deactivateButton.enabled = true;
            if(MineUtil.getUtilCore().getCraftSelection().length() > 0) {
            	this.closeCraftButton.enabled = true;
            }
        }
        else {
            this.deactivateButton.enabled = false;
            this.closeCraftButton.enabled = false;
        }

        this.cleanSpawnerButton.displayString = this.getButtonDisplayString(this.cleanSpawnerButton.displayString, "spawner", false);
        this.cleanChestInventoryButton.displayString = this.getButtonDisplayString(this.cleanChestInventoryButton.displayString, "ChestInventory", false);

        this.craftRedstoneLampButton.displayString = this.getButtonDisplayString(this.craftRedstoneLampButton.displayString, "RedstoneLamp", true);
        this.craftCompassButton.displayString = this.getButtonDisplayString(this.craftCompassButton.displayString, "Compass", true);
        this.craftRedstoneComperatorButton.displayString = this.getButtonDisplayString(this.craftRedstoneComperatorButton.displayString, "Comperator", true);
        this.craftRedstoneRepeaterButton.displayString = this.getButtonDisplayString(this.craftRedstoneRepeaterButton.displayString, "Repeater", true);
        this.craftDispenserButton.displayString = this.getButtonDisplayString(this.craftDispenserButton.displayString, "Dispenser", true);
        this.craftDropperButton.displayString = this.getButtonDisplayString(this.craftDropperButton.displayString, "Dropper", true);
        this.craftHopperButton.displayString = this.getButtonDisplayString(this.craftHopperButton.displayString, "Hopper", true);
        this.craftRedstoneTorchButton.displayString = this.getButtonDisplayString(this.craftRedstoneTorchButton.displayString, "RedstoneTorch", true);
        this.craftRedstoneChestButton.displayString = this.getButtonDisplayString(this.craftRedstoneChestButton.displayString, "RedstoneChest", true);
        this.craftTripwireHookButton.displayString = this.getButtonDisplayString(this.craftTripwireHookButton.displayString, "TripwireHook", true);
        this.craftPistonButton.displayString = this.getButtonDisplayString(this.craftPistonButton.displayString, "Piston", true);
        this.craftStickyPistonButton.displayString = this.getButtonDisplayString(this.craftStickyPistonButton.displayString, "StickyPiston", true);
        this.craftNoteblockButton.displayString = this.getButtonDisplayString(this.craftNoteblockButton.displayString, "Noteblock", true);
        this.craftJukeboxButton.displayString = this.getButtonDisplayString(this.craftJukeboxButton.displayString, "Jukebox", true);
        this.craftClockButton.displayString = this.getButtonDisplayString(this.craftClockButton.displayString, "Clock", true);
        this.craftMapButton.displayString = this.getButtonDisplayString(this.craftMapButton.displayString, "Map", true);
    }
    
    @Override
    public void onGuiClosed() {
    	CCGui.setGUIOpend(false);
        CCGui.setGUIToggled(false);
    	super.onGuiClosed();
    }
    
    @Override
    public boolean doesGuiPauseGame() {
    	return false;
    }
    
}
