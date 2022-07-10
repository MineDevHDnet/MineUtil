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

public class CleanCraftGui7 extends GuiScreen
{
    GuiButton cleanSpawnerButton;
    GuiButton craftClayBlackButton;
    GuiButton craftClayRedButton;
    GuiButton craftClayGreenButton;
    GuiButton craftClayBrownButton;
    GuiButton craftClayBlueButton;
    GuiButton craftClayVioletButton;
    GuiButton craftClayTurquoiseButton;
    GuiButton craftClayLightGreyButton;
    GuiButton craftClayGreyButton;
    GuiButton craftClayPinkButton;
    GuiButton craftClayLightGreenButton;
    GuiButton craftClayYellowButton;
    GuiButton craftClayLightBlueButton;
    GuiButton craftClayMagentaButton;
    GuiButton craftClayOrangeButton;
    GuiButton craftClayWhiteButton;
    GuiButton craftClayBlockButton;
    GuiButton cleanChestInventoryButton;
    
    GuiButton pageNextButton;
    GuiButton pagePrevButton;
    GuiButton closeButton;
    GuiButton closeCraftButton;
    GuiButton deactivateButton;
    GuiButton changeLogButton;
    
    public CleanCraftGui7() {}
    
    @Override
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
    	RenderUtils.renderNewGuiBackground();
    	MineUtil.getUtilCore().getSettings().setCurrentGuiPage(7);
        this.drawCenteredString(this.fontRendererObj, "Cleaning and Crafting", this.width / 2, ModButton.API.getButtonYPos(0, true) + 5, ModButton.toRainbow(18));
        this.drawCenteredString(this.fontRendererObj, "- Page 7 of 10 -", this.width / 2, 18, 16777215);
        this.drawString(this.fontRendererObj, "Cleaning", ModButton.API.getButtonXPos(1, this.width) + 1, ModButton.API.getButtonYPos(1, true) + 8, 16777215);
        this.drawString(this.fontRendererObj, "Crafting", ModButton.API.getButtonXPos(1, this.width) + 1, ModButton.API.getButtonYPos(4, true) + 8, 16777215);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
    
    public void initGui() {
        this.buttonList.add(this.cleanSpawnerButton = new ModButton(271, ModButton.API.getButtonXPos(1,this.width), ModButton.API.getButtonYPos(2), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Spawner: OFF"));
        this.buttonList.add(this.cleanChestInventoryButton = new ModButton(222, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(2), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Chest-Inventory: OFF"));
        
        this.buttonList.add(this.craftClayBlackButton = new ModButton(730, ModButton.API.getButtonXPos(1,this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ClayBlack: OFF"));
        this.buttonList.add(this.craftClayRedButton = new ModButton(740, ModButton.API.getButtonXPos(2,this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ClayRed: OFF"));
        this.buttonList.add(this.craftClayGreenButton = new ModButton(750, ModButton.API.getButtonXPos(3,this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ClayGreen: OFF"));
        this.buttonList.add(this.craftClayBrownButton = new ModButton(760, ModButton.API.getButtonXPos(4,this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ClayBrown: OFF"));
        this.buttonList.add(this.craftClayBlueButton = new ModButton(770, ModButton.API.getButtonXPos(1,this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ClayBlue: OFF"));
        this.buttonList.add(this.craftClayVioletButton = new ModButton(780, ModButton.API.getButtonXPos(2,this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ClayViolet: OFF"));
        this.buttonList.add(this.craftClayTurquoiseButton = new ModButton(790, ModButton.API.getButtonXPos(3,this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ClayTurquoise: OFF"));
        this.buttonList.add(this.craftClayLightGreyButton = new ModButton(800, ModButton.API.getButtonXPos(4,this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ClayLightGrey: OFF"));
        this.buttonList.add(this.craftClayGreyButton = new ModButton(810, ModButton.API.getButtonXPos(1,this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ClayGrey: OFF"));
        this.buttonList.add(this.craftClayPinkButton = new ModButton(820, ModButton.API.getButtonXPos(2,this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ClayPink: OFF"));
        this.buttonList.add(this.craftClayLightGreenButton = new ModButton(830, ModButton.API.getButtonXPos(3,this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ClayLightGreen: OFF"));
        this.buttonList.add(this.craftClayYellowButton = new ModButton(840, ModButton.API.getButtonXPos(4,this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ClayYellow: OFF"));
        this.buttonList.add(this.craftClayLightBlueButton = new ModButton(850, ModButton.API.getButtonXPos(1,this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ClayLightBlue: OFF"));
        this.buttonList.add(this.craftClayMagentaButton = new ModButton(860, ModButton.API.getButtonXPos(2,this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ClayMagenta: OFF"));
        this.buttonList.add(this.craftClayOrangeButton = new ModButton(870, ModButton.API.getButtonXPos(3,this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ClayOrange: OFF"));
        this.buttonList.add(this.craftClayWhiteButton = new ModButton(880, ModButton.API.getButtonXPos(4,this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ClayWhite: OFF"));
        this.buttonList.add(this.craftClayBlockButton = new ModButton(890, ModButton.API.getButtonXPos(2,this.width), ModButton.API.getButtonYPos(9), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ClayBlock: OFF"));
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
                    this.mc.displayGuiScreen(new CleanCraftGui6());
                    doAction = false;
                    break;
                }
                case 150: {
                    this.mc.displayGuiScreen(new CleanCraftGui8());
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
                case 730: {
                    this.setSelection("ClayBlack", true);
                    break;
                }
                case 740: {
                    this.setSelection("ClayRed", true);
                    break;
                }
                case 750: {
                    this.setSelection("ClayGreen", true);
                    break;
                }
                case 760: {
                    this.setSelection("ClayBrown", true);
                    break;
                }
                case 770: {
                    this.setSelection("ClayBlue", true);
                    break;
                }
                case 780: {
                    this.setSelection("ClayViolet", true);
                    break;
                }
                case 790: {
                    this.setSelection("ClayTurquoise", true);
                    break;
                }
                case 800: {
                    this.setSelection("ClayLightgrey", true);
                    break;
                }
                case 810: {
                    this.setSelection("ClayGrey", true);
                    break;
                }
                case 820: {
                    this.setSelection("ClayPink", true);
                    break;
                }
                case 830: {
                    this.setSelection("ClayLightgreen", true);
                    break;
                }
                case 840: {
                    this.setSelection("ClayYellow", true);
                    break;
                }
                case 850: {
                    this.setSelection("ClayLightblue", true);
                    break;
                }
                case 860: {
                    this.setSelection("ClayMagenta", true);
                    break;
                }
                case 870: {
                    this.setSelection("ClayOrange", true);
                    break;
                }
                case 880: {
                    this.setSelection("ClayWhite", true);
                    break;
                }
                case 890: {
                    this.setSelection("Clayblock", true);
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
        this.craftClayBlackButton.displayString = this.getButtonDisplayString(this.craftClayBlackButton.displayString, "clayblack", true);
        this.craftClayRedButton.displayString = this.getButtonDisplayString(this.craftClayRedButton.displayString, "clayred", true);
        this.craftClayGreenButton.displayString = this.getButtonDisplayString(this.craftClayGreenButton.displayString, "claygreen", true);
        this.craftClayBrownButton.displayString = this.getButtonDisplayString(this.craftClayBrownButton.displayString, "claybrown", true);
        this.craftClayBlueButton.displayString = this.getButtonDisplayString(this.craftClayBlueButton.displayString, "clayblue", true);
        this.craftClayVioletButton.displayString = this.getButtonDisplayString(this.craftClayVioletButton.displayString, "clayviolet", true);
        this.craftClayTurquoiseButton.displayString = this.getButtonDisplayString(this.craftClayTurquoiseButton.displayString, "clayturquoise", true);
        this.craftClayLightGreyButton.displayString = this.getButtonDisplayString(this.craftClayLightGreyButton.displayString, "claylightgrey", true);
        this.craftClayGreyButton.displayString = this.getButtonDisplayString(this.craftClayGreyButton.displayString, "claygrey", true);
        this.craftClayPinkButton.displayString = this.getButtonDisplayString(this.craftClayPinkButton.displayString, "claypink", true);
        this.craftClayLightGreenButton.displayString = this.getButtonDisplayString(this.craftClayLightGreenButton.displayString, "claylightgreen", true);
        this.craftClayYellowButton.displayString = this.getButtonDisplayString(this.craftClayYellowButton.displayString, "clayyellow", true);
        this.craftClayLightBlueButton.displayString = this.getButtonDisplayString(this.craftClayLightBlueButton.displayString, "claylightblue", true);
        this.craftClayMagentaButton.displayString = this.getButtonDisplayString(this.craftClayMagentaButton.displayString, "claymagenta", true);
        this.craftClayOrangeButton.displayString = this.getButtonDisplayString(this.craftClayOrangeButton.displayString, "clayorange", true);
        this.craftClayWhiteButton.displayString = this.getButtonDisplayString(this.craftClayWhiteButton.displayString, "claywhite", true);
        this.craftClayBlockButton.displayString = this.getButtonDisplayString(this.craftClayBlockButton.displayString, "clayblock", true);
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
