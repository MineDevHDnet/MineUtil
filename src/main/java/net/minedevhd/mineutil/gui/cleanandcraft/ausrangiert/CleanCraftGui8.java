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

public class CleanCraftGui8 extends GuiScreen
{
    GuiButton cleanSpawnerButton;
    GuiButton craftWoolBlackButton;
    GuiButton craftWoolRedButton;
    GuiButton craftWoolGreenButton;
    GuiButton craftWoolBrownButton;
    GuiButton craftWoolBlueButton;
    GuiButton craftWoolVioletButton;
    GuiButton craftWoolTurquoiseButton;
    GuiButton craftWoolLightGreyButton;
    GuiButton craftWoolGreyButton;
    GuiButton craftWoolPinkButton;
    GuiButton craftWoolLightGreenButton;
    GuiButton craftWoolYellowButton;
    GuiButton craftWoolLightBlueButton;
    GuiButton craftWoolMagentaButton;
    GuiButton craftWoolOrangeButton;
    GuiButton craftWoolButton;
    GuiButton cleanChestInventoryButton;
    
    GuiButton pageNextButton;
    GuiButton pagePrevButton;
    GuiButton closeButton;
    GuiButton closeCraftButton;
    GuiButton deactivateButton;
    GuiButton changeLogButton;
    
    public CleanCraftGui8() {}
    
    @Override
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
    	RenderUtils.renderNewGuiBackground();
    	MineUtil.getUtilCore().getSettings().setCurrentGuiPage(8);
        this.drawCenteredString(this.fontRendererObj, "Cleaning and Crafting", this.width / 2, ModButton.API.getButtonYPos(0, true) + 5, ModButton.toRainbow(18));
        this.drawCenteredString(this.fontRendererObj, "- Page 8 of 10 -", this.width / 2, 18, 16777215);
        this.drawString(this.fontRendererObj, "Cleaning", ModButton.API.getButtonXPos(1, this.width) + 1, ModButton.API.getButtonYPos(1, true) + 8, 16777215);
        this.drawString(this.fontRendererObj, "Crafting - Wool", ModButton.API.getButtonXPos(1, this.width) + 1, ModButton.API.getButtonYPos(4, true) + 8, 16777215);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    public void initGui() {
        this.buttonList.add(this.cleanSpawnerButton = new ModButton(271, ModButton.API.getButtonXPos(1,this.width), ModButton.API.getButtonYPos(2), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Spawner: OFF"));
        this.buttonList.add(this.cleanChestInventoryButton = new ModButton(222, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(2), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Chest-Inventory: OFF"));
        
        this.buttonList.add(this.craftWoolBlackButton = new ModButton(890, ModButton.API.getButtonXPos(1,this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "WoolBlack: OFF"));
        this.buttonList.add(this.craftWoolRedButton = new ModButton(900, ModButton.API.getButtonXPos(2,this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "WoolRed: OFF"));
        this.buttonList.add(this.craftWoolGreenButton = new ModButton(910, ModButton.API.getButtonXPos(3,this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "WoolGreen: OFF"));
        this.buttonList.add(this.craftWoolBrownButton = new ModButton(920, ModButton.API.getButtonXPos(4,this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "WoolBrown: OFF"));
        this.buttonList.add(this.craftWoolBlueButton = new ModButton(930, ModButton.API.getButtonXPos(1,this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "WoolBlue: OFF"));
        this.buttonList.add(this.craftWoolVioletButton = new ModButton(940, ModButton.API.getButtonXPos(2,this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "WoolViolet: OFF"));
        this.buttonList.add(this.craftWoolTurquoiseButton = new ModButton(950, ModButton.API.getButtonXPos(3,this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "WoolTurquoise: OFF"));
        this.buttonList.add(this.craftWoolLightGreyButton = new ModButton(960, ModButton.API.getButtonXPos(4,this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "WoolLightGrey: OFF"));
        this.buttonList.add(this.craftWoolGreyButton = new ModButton(970, ModButton.API.getButtonXPos(1,this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "WoolGrey: OFF"));
        this.buttonList.add(this.craftWoolPinkButton = new ModButton(980, ModButton.API.getButtonXPos(2,this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "WoolPink: OFF"));
        this.buttonList.add(this.craftWoolLightGreenButton = new ModButton(990, ModButton.API.getButtonXPos(3,this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "WoolLightGreen: OFF"));
        this.buttonList.add(this.craftWoolYellowButton = new ModButton(1000, ModButton.API.getButtonXPos(4,this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "WoolYellow: OFF"));
        this.buttonList.add(this.craftWoolLightBlueButton = new ModButton(1010, ModButton.API.getButtonXPos(1,this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "WoolLightBlue: OFF"));
        this.buttonList.add(this.craftWoolMagentaButton = new ModButton(1020, ModButton.API.getButtonXPos(2,this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "WoolMagenta: OFF"));
        this.buttonList.add(this.craftWoolOrangeButton = new ModButton(1030, ModButton.API.getButtonXPos(3,this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "WoolOrange: OFF"));
        this.buttonList.add(this.craftWoolButton = new ModButton(1380, ModButton.API.getButtonXPos(4,this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Wool: OFF"));
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
                    this.mc.displayGuiScreen(new CleanCraftGui7());
                    doAction = false;
                    break;
                }
                case 150: {
                    this.mc.displayGuiScreen(new CleanCraftGui9());
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
                case 890: {
                    this.setSelection("WoolBlack", true);
                    break;
                }
                case 900: {
                    this.setSelection("WoolRed", true);
                    break;
                }
                case 910: {
                    this.setSelection("WoolGreen", true);
                    break;
                }
                case 920: {
                    this.setSelection("WoolBrown", true);
                    break;
                }
                case 930: {
                    this.setSelection("WoolbBlue", true);
                    break;
                }
                case 940: {
                    this.setSelection("WoolViolet", true);
                    break;
                }
                case 950: {
                    this.setSelection("WoolTurquoise", true);
                    break;
                }
                case 960: {
                    this.setSelection("WoolLightgrey", true);
                    break;
                }
                case 970: {
                    this.setSelection("WoolGrey", true);
                    break;
                }
                case 980: {
                    this.setSelection("WoolPink", true);
                    break;
                }
                case 990: {
                    this.setSelection("WoolLightgreen", true);
                    break;
                }
                case 1000: {
                    this.setSelection("WoolYellow", true);
                    break;
                }
                case 1010: {
                    this.setSelection("WoolLightblue", true);
                    break;
                }
                case 1020: {
                    this.setSelection("WoolMagenta", true);
                    break;
                }
                case 1030: {
                    this.setSelection("WoolOrange", true);
                    break;
                }
                case 1380: {
                	this.setSelection("Wool", true);
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
        this.craftWoolBlackButton.displayString = this.getButtonDisplayString(this.craftWoolBlackButton.displayString, "woolblack", true);
        this.craftWoolRedButton.displayString = this.getButtonDisplayString(this.craftWoolRedButton.displayString, "woolred", true);
        this.craftWoolGreenButton.displayString = this.getButtonDisplayString(this.craftWoolGreenButton.displayString, "woolgreen", true);
        this.craftWoolBrownButton.displayString = this.getButtonDisplayString(this.craftWoolBrownButton.displayString, "woolbrown", true);
        this.craftWoolBlueButton.displayString = this.getButtonDisplayString(this.craftWoolBlueButton.displayString, "woolblue", true);
        this.craftWoolVioletButton.displayString = this.getButtonDisplayString(this.craftWoolVioletButton.displayString, "woolviolet", true);
        this.craftWoolTurquoiseButton.displayString = this.getButtonDisplayString(this.craftWoolTurquoiseButton.displayString, "woolturquoise", true);
        this.craftWoolLightGreyButton.displayString = this.getButtonDisplayString(this.craftWoolLightGreyButton.displayString, "woollightgrey", true);
        this.craftWoolGreyButton.displayString = this.getButtonDisplayString(this.craftWoolGreyButton.displayString, "woolgrey", true);
        this.craftWoolPinkButton.displayString = this.getButtonDisplayString(this.craftWoolPinkButton.displayString, "woolpink", true);
        this.craftWoolLightGreenButton.displayString = this.getButtonDisplayString(this.craftWoolLightGreenButton.displayString, "woollightgreen", true);
        this.craftWoolYellowButton.displayString = this.getButtonDisplayString(this.craftWoolYellowButton.displayString, "woolyellow", true);
        this.craftWoolLightBlueButton.displayString = this.getButtonDisplayString(this.craftWoolLightBlueButton.displayString, "woollightblue", true);
        this.craftWoolMagentaButton.displayString = this.getButtonDisplayString(this.craftWoolMagentaButton.displayString, "woolmagenta", true);
        this.craftWoolOrangeButton.displayString = this.getButtonDisplayString(this.craftWoolOrangeButton.displayString, "woolorange", true);
        this.craftWoolButton.displayString = this.getButtonDisplayString(this.craftWoolButton.displayString, "wool", true);
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
