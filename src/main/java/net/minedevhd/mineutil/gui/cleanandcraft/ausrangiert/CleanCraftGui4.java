package net.minedevhd.mineutil.gui.cleanandcraft.ausrangiert;

import java.io.IOException;
import java.net.URI;

import net.labymod.core.LabyModCore;
import net.labymod.utils.ModColor;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.MineUtil.CGui;
import net.minedevhd.mineutil.gui.changelog.ChangelogGui;
import net.minedevhd.mineutil.gui.storageprices.TEDLagerPreisGui;
import net.minedevhd.mineutil.utils.ModButton;
import net.minedevhd.mineutil.utils.ModButton.API;
import net.minedevhd.mineutil.utils.RenderUtils;

public class CleanCraftGui4 extends GuiScreen
{
    GuiButton cleanSpawnerButton;
    GuiButton craftMossyCobbleStoneButton;
    GuiButton craftPolishedAndesiteButton;
    GuiButton craftPolishedDioriteButton;
    GuiButton craftPolishedGraniteButton;
    GuiButton craftPaperButton;
    GuiButton craftCompassButton;
    GuiButton craftMapButton;
    GuiButton craftItemFrameButton;
    GuiButton craftBookButton;
    GuiButton craftBookShelfButton;
    GuiButton craftPistonButton;
    GuiButton craftStickyPistonButton;
    GuiButton craftFurnaceButton;
    GuiButton craftCauldronButton;
    GuiButton craftNoteblockButton;
    GuiButton craftJukeboxButton;
    GuiButton cleanChestInventoryButton;
    
    GuiButton pageNextButton;
    GuiButton pagePrevButton;
    GuiButton closeButton;
    GuiButton closeCraftButton;
    GuiButton deactivateButton;
    GuiButton changeLogButton;
    
    public CleanCraftGui4() {}
    
    @Override
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
    	RenderUtils.renderNewGuiBackground();
    	MineUtil.getUtilCore().getSettings().setCurrentGuiPage(4);
        this.drawCenteredString(this.fontRendererObj, "Cleaning and Crafting", this.width / 2, ModButton.API.getButtonYPos(0, true) + 5, ModButton.toRainbow(18));
        this.drawCenteredString(this.fontRendererObj, "- Page 4 of 10 -", this.width / 2, 18, 16777215);
        this.drawString(this.fontRendererObj, "Cleaning", ModButton.API.getButtonXPos(1, this.width) + 1, ModButton.API.getButtonYPos(1, true) + 8, 16777215);
        this.drawString(this.fontRendererObj, "Crafting", ModButton.API.getButtonXPos(1, this.width) + 1, ModButton.API.getButtonYPos(4, true) + 8, 16777215);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
    
    public void initGui() {
        this.buttonList.add(this.cleanSpawnerButton = new ModButton(271, ModButton.API.getButtonXPos(1,this.width), ModButton.API.getButtonYPos(2), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Spawner: OFF"));
        this.buttonList.add(this.cleanChestInventoryButton = new ModButton(222, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(2), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Chest-Inventory: OFF"));
        
        this.buttonList.add(this.craftMossyCobbleStoneButton = new ModButton(300, ModButton.API.getButtonXPos(1,this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "MossyCobbleStone: OFF"));
        this.buttonList.add(this.craftPolishedAndesiteButton = new ModButton(310, ModButton.API.getButtonXPos(2,this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "PolishedAndesite: OFF"));
        this.buttonList.add(this.craftPolishedDioriteButton = new ModButton(320, ModButton.API.getButtonXPos(3,this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "PolishedDiorite: OFF"));
        this.buttonList.add(this.craftPolishedGraniteButton = new ModButton(330, ModButton.API.getButtonXPos(4,this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "PolishedGranite: OFF"));
        this.buttonList.add(this.craftPaperButton = new ModButton(340, ModButton.API.getButtonXPos(1,this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Paper: OFF"));
        this.buttonList.add(this.craftCompassButton = new ModButton(350, ModButton.API.getButtonXPos(2,this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Compass: OFF"));
        this.buttonList.add(this.craftMapButton = new ModButton(360, ModButton.API.getButtonXPos(3,this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Map: OFF"));
        this.buttonList.add(this.craftItemFrameButton = new ModButton(370, ModButton.API.getButtonXPos(4,this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ItemFrame: OFF"));
        this.buttonList.add(this.craftBookButton = new ModButton(380, ModButton.API.getButtonXPos(1,this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Book: OFF"));
        this.buttonList.add(this.craftBookShelfButton = new ModButton(390, ModButton.API.getButtonXPos(2,this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "BookShelf: OFF"));
        this.buttonList.add(this.craftPistonButton = new ModButton(400, ModButton.API.getButtonXPos(3,this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Piston: OFF"));
        this.buttonList.add(this.craftStickyPistonButton = new ModButton(410, ModButton.API.getButtonXPos(4,this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "StickyPiston: OFF"));
        this.buttonList.add(this.craftFurnaceButton = new ModButton(420, ModButton.API.getButtonXPos(1,this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Furnace: OFF"));
        this.buttonList.add(this.craftCauldronButton = new ModButton(430, ModButton.API.getButtonXPos(2,this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Cauldron: OFF"));
        this.buttonList.add(this.craftNoteblockButton = new ModButton(440, ModButton.API.getButtonXPos(3,this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Noteblock: OFF"));
        this.buttonList.add(this.craftJukeboxButton = new ModButton(450, ModButton.API.getButtonXPos(4,this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Jukebox: OFF"));
        this.buttonList.add(this.pagePrevButton = new ModButton(160, ModButton.API.getButtonXPos(1,this.width), ModButton.API.getButtonYPos(9), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "<< BACK"));
        this.buttonList.add(this.pageNextButton = new ModButton(150, ModButton.API.getButtonXPos(4,this.width), ModButton.API.getButtonYPos(9), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "FORWARD >>"));
        this.buttonList.add(this.deactivateButton = new ModButton(120, ModButton.API.getButtonXPos(2,this.width), ModButton.API.getButtonYPos(12), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "DISABLE"));
        this.buttonList.add(this.closeButton = new ModButton(110, ModButton.API.getButtonXPos(3,this.width), ModButton.API.getButtonYPos(12), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "CLOSE"));
        this.buttonList.add(this.closeCraftButton = new ModButton(90, ModButton.API.getButtonXPos(3,this.width), ModButton.API.getButtonYPos(11), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "CLOSE and CRAFT"));
        
        this.buttonList.add(new ModButton(500, ModButton.API.getButtonXPos(4,this.width), ModButton.API.getButtonYPos(12), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), ModColor.AQUA.toString() + "Lager Preise"));
        this.buttonList.add(this.changeLogButton = new ModButton(501, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(12), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), ModColor.GOLD.toString() + "Changelog"));
        this.updateButtons();
        super.initGui();
    }
    
    @Override
    protected void actionPerformed(final GuiButton button) throws IOException {
        try {
            boolean doAction = true;
            switch (button.id) {
	            case 90: {
	            	this.mc.displayGuiScreen(null);
	            	doAction = false;
	            	LabyModCore.getMinecraft().getPlayer().sendChatMessage("/craft");
	            	break;
	            }
                case 110: {
                    this.mc.displayGuiScreen(null);
                    doAction = false;
                    break;
                }
                case 120: {
                	ModButton.API.a_617553_p(MineUtil.getUtilCore());
	                break;
                }
                case 160: {
                    this.mc.displayGuiScreen(new CleanCraftGui3());
                    doAction = false;
                    break;
                }
                case 150: {
                    this.mc.displayGuiScreen(new CleanCraftGui5());
                    doAction = false;
                    break;
                }
                case 222: {
                	this.setSelection("ChestInventory", false);
                	break;
                }
                case 271: {
                    this.setSelection("Spawner", false);
                    break;
                }
                case 300: {
                    this.setSelection("Mossycobblestone", true);
                    break;
                }
                case 310: {
                    this.setSelection("Polishedandesite", true);
                    break;
                }
                case 320: {
                    this.setSelection("Polisheddiorite", true);
                    break;
                }
                case 330: {
                    this.setSelection("Polishedgranite", true);
                    break;
                }
                case 340: {
                    this.setSelection("Paper", true);
                    break;
                }
                case 350: {
                    this.setSelection("Compass", true);
                    break;
                }
                case 360: {
                    this.setSelection("Map", true);
                    break;
                }
                case 370: {
                    this.setSelection("Itemframe", true);
                    break;
                }
                case 380: {
                    this.setSelection("Book", true);
                    break;
                }
                case 390: {
                    this.setSelection("Bookshelf", true);
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
                    this.setSelection("Furnace", true);
                    break;
                }
                case 430: {
                    this.setSelection("Cauldron", true);
                    break;
                }
                case 440: {
                    this.setSelection("Noteblock", true);
                    break;
                }
                case 450: {
                    this.setSelection("Jukebox", true);
                    break;
                }
                case 500: {
                	this.mc.displayGuiScreen(new TEDLagerPreisGui());
                	break;
                }
                case 501: {
                	this.mc.displayGuiScreen(new ChangelogGui());
                	break;
                }
            }
            if (doAction) {
                this.updateButtons();
                super.actionPerformed(button);
            }
        }
        catch (Exception exception) {}
    }
    
    private String getButtonDisplayString(String displayString, final String type, final boolean crafting) {
        final String selection = crafting ? MineUtil.getUtilCore().getCraftSelection() : MineUtil.getUtilCore().getCleanSelection();
        displayString = displayString.replaceAll("(ON|OFF)", "") + (selection.equalsIgnoreCase(type) ? "ON" : "OFF");
        return displayString;
    }
    
    private void setSelection(final String type, final boolean crafting) {
        final String selection = crafting ? MineUtil.getUtilCore().getCraftSelection() : MineUtil.getUtilCore().getCleanSelection();
        final String setSel = selection.equalsIgnoreCase(type) ? "" : type;
        if (crafting) {
            MineUtil.getUtilCore().setCraftSelection(setSel);
            if (setSel.length() > 0) {
                MineUtil.getUtilCore().getApi().displayMessageInChat(MineUtil.getUtilCore().getSettings().getPrefix() 
                		+ ModColor.cl("a") + "Auto. Crafting for " + ModColor.cl('e') + setSel + ModColor.cl('a') + " enabled!");
            }
            else {
                MineUtil.getUtilCore().getApi().displayMessageInChat(MineUtil.getUtilCore().getSettings().getPrefix() 
                		+ ModColor.cl("c") + "Auto. Crafting disabled!");
            }
        }
        else {
            MineUtil.getUtilCore().setCleanSelection(setSel);
            if (setSel.length() > 0) {
                MineUtil.getUtilCore().getApi().displayMessageInChat(MineUtil.getUtilCore().getSettings().getPrefix() 
                		+ ModColor.cl("a") + "Auto. Cleaning for " + ModColor.cl('e') + setSel + ModColor.cl('a') + " enabled!");
            }
            else {
                MineUtil.getUtilCore().getApi().displayMessageInChat(MineUtil.getUtilCore().getSettings().getPrefix() 
                		+ ModColor.cl("c") + "Auto. Cleaning disabled!");
            }
        }
    }
    
    public void updateButtons() {
        this.changeLogButton.enabled = false;
        if (MineUtil.getUtilCore().getCraftSelection().length() > 0 || MineUtil.getUtilCore().getCleanSelection().length() > 0) {
            this.deactivateButton.enabled = true;
            if(MineUtil.getUtilCore().getCraftSelection().length() > 0) {
            	this.closeCraftButton.enabled = true;
            }
        }
        else {
            this.deactivateButton.enabled = false;
            this.closeCraftButton.enabled = false;
            this.changeLogButton.enabled = false;
        }
        this.cleanSpawnerButton.displayString = this.getButtonDisplayString(this.cleanSpawnerButton.displayString, "spawner", false);
        this.cleanChestInventoryButton.displayString = this.getButtonDisplayString(this.cleanChestInventoryButton.displayString, "ChestInventory", false);
        this.craftMossyCobbleStoneButton.displayString = this.getButtonDisplayString(this.craftMossyCobbleStoneButton.displayString, "mossycobblestone", true);
        this.craftPolishedAndesiteButton.displayString = this.getButtonDisplayString(this.craftPolishedAndesiteButton.displayString, "polishedandesite", true);
        this.craftPolishedDioriteButton.displayString = this.getButtonDisplayString(this.craftPolishedDioriteButton.displayString, "polisheddiorite", true);
        this.craftPolishedGraniteButton.displayString = this.getButtonDisplayString(this.craftPolishedGraniteButton.displayString, "polishedgranite", true);
        this.craftPaperButton.displayString = this.getButtonDisplayString(this.craftPaperButton.displayString, "paper", true);
        this.craftCompassButton.displayString = this.getButtonDisplayString(this.craftCompassButton.displayString, "compass", true);
        this.craftMapButton.displayString = this.getButtonDisplayString(this.craftMapButton.displayString, "map", true);
        this.craftItemFrameButton.displayString = this.getButtonDisplayString(this.craftItemFrameButton.displayString, "itemframe", true);
        this.craftBookButton.displayString = this.getButtonDisplayString(this.craftBookButton.displayString, "book", true);
        this.craftBookShelfButton.displayString = this.getButtonDisplayString(this.craftBookShelfButton.displayString, "bookshelf", true);
        this.craftPistonButton.displayString = this.getButtonDisplayString(this.craftPistonButton.displayString, "Piston", true);
        this.craftStickyPistonButton.displayString = this.getButtonDisplayString(this.craftStickyPistonButton.displayString, "stickyPiston", true);
        this.craftFurnaceButton.displayString = this.getButtonDisplayString(this.craftFurnaceButton.displayString, "furnace", true);
        this.craftCauldronButton.displayString = this.getButtonDisplayString(this.craftCauldronButton.displayString, "cauldron", true);
        this.craftNoteblockButton.displayString = this.getButtonDisplayString(this.craftNoteblockButton.displayString, "noteblock", true);
        this.craftJukeboxButton.displayString = this.getButtonDisplayString(this.craftJukeboxButton.displayString, "jukebox", true);
    }
    
    public void onGuiClosed() {
    	CGui.setGUIOpend(false);
    	CGui.setGUIToggled(false);
        super.onGuiClosed();
    }
    
    public boolean doesGuiPauseGame() {
        return false;
    }
}
