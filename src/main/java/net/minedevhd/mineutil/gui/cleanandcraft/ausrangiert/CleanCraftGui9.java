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

public class CleanCraftGui9 extends GuiScreen
{
    GuiButton cleanSpawnerButton;
    GuiButton craftGlassBlackButton;
    GuiButton craftGlassRedButton;
    GuiButton craftGlassGreenButton;
    GuiButton craftGlassBrownButton;
    GuiButton craftGlassBlueButton;
    GuiButton craftGlassVioletButton;
    GuiButton craftGlassTurquoiseButton;
    GuiButton craftGlassLightGreyButton;
    GuiButton craftGlassGreyButton;
    GuiButton craftGlassPinkButton;
    GuiButton craftGlassLightGreenButton;
    GuiButton craftGlassYellowButton;
    GuiButton craftGlassLightBlueButton;
    GuiButton craftGlassMagentaButton;
    GuiButton craftGlassOrangeButton;
    GuiButton craftGlassWhiteButton;
    GuiButton cleanChestInventoryButton;
    
    GuiButton pageNextButton;
    GuiButton pagePrevButton;
    GuiButton closeButton;
    GuiButton closeCraftButton;
    GuiButton deactivateButton;
    GuiButton changeLogButton;
    
    public CleanCraftGui9() {}
    
    @Override
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
    	RenderUtils.renderNewGuiBackground();
    	MineUtil.getUtilCore().getSettings().setCurrentGuiPage(9);
        this.drawCenteredString(this.fontRendererObj, "Cleaning and Crafting", this.width / 2, ModButton.API.getButtonYPos(0, true) + 5, ModButton.toRainbow(18));
        this.drawCenteredString(this.fontRendererObj, "- Page 9 of 10 -", this.width / 2, 18, 16777215);
        this.drawString(this.fontRendererObj, "Cleaning", ModButton.API.getButtonXPos(1, this.width) + 1, ModButton.API.getButtonYPos(1, true) + 8, 16777215);
        this.drawString(this.fontRendererObj, "Crafting", ModButton.API.getButtonXPos(1, this.width) + 1, ModButton.API.getButtonYPos(4, true) + 8, 16777215);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
    
    public void initGui() {
        this.buttonList.add(this.cleanSpawnerButton = new ModButton(271, ModButton.API.getButtonXPos(1,this.width), ModButton.API.getButtonYPos(2), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Spawner: OFF"));
        this.buttonList.add(this.cleanChestInventoryButton = new ModButton(222, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(2), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Chest-Inventory: OFF"));
        
        this.buttonList.add(this.craftGlassBlackButton = new ModButton(730, ModButton.API.getButtonXPos(1,this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "GlassBlack: OFF"));
        this.buttonList.add(this.craftGlassRedButton = new ModButton(740, ModButton.API.getButtonXPos(2,this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "GlassRed: OFF"));
        this.buttonList.add(this.craftGlassGreenButton = new ModButton(750, ModButton.API.getButtonXPos(3,this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "GlassGreen: OFF"));
        this.buttonList.add(this.craftGlassBrownButton = new ModButton(760, ModButton.API.getButtonXPos(4,this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "GlassBrown: OFF"));
        this.buttonList.add(this.craftGlassBlueButton = new ModButton(770, ModButton.API.getButtonXPos(1,this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "GlassBlue: OFF"));
        this.buttonList.add(this.craftGlassVioletButton = new ModButton(780, ModButton.API.getButtonXPos(2,this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "GlassViolet: OFF"));
        this.buttonList.add(this.craftGlassTurquoiseButton = new ModButton(790, ModButton.API.getButtonXPos(3,this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "GlassTurquoise: OFF"));
        this.buttonList.add(this.craftGlassLightGreyButton = new ModButton(800, ModButton.API.getButtonXPos(4,this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "GlassLightGrey: OFF"));
        this.buttonList.add(this.craftGlassGreyButton = new ModButton(810, ModButton.API.getButtonXPos(1,this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "GlassGrey: OFF"));
        this.buttonList.add(this.craftGlassPinkButton = new ModButton(820, ModButton.API.getButtonXPos(2,this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "GlassPink: OFF"));
        this.buttonList.add(this.craftGlassLightGreenButton = new ModButton(830, ModButton.API.getButtonXPos(3,this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "GlassLightGreen: OFF"));
        this.buttonList.add(this.craftGlassYellowButton = new ModButton(840, ModButton.API.getButtonXPos(4,this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "GlassYellow: OFF"));
        this.buttonList.add(this.craftGlassLightBlueButton = new ModButton(850, ModButton.API.getButtonXPos(1,this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "GlassLightBlue: OFF"));
        this.buttonList.add(this.craftGlassMagentaButton = new ModButton(860, ModButton.API.getButtonXPos(2,this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "GlassMagenta: OFF"));
        this.buttonList.add(this.craftGlassOrangeButton = new ModButton(870, ModButton.API.getButtonXPos(3,this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "GlassOrange: OFF"));
        this.buttonList.add(this.craftGlassWhiteButton = new ModButton(880, ModButton.API.getButtonXPos(4,this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "GlassWhite: OFF"));
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
                    this.mc.displayGuiScreen(new CleanCraftGui8());
                    doAction = false;
                    break;
                }
                case 150: {
                    this.mc.displayGuiScreen(new CleanCraftGui10());
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
                    this.setSelection("GlassBlack", true);
                    break;
                }
                case 740: {
                    this.setSelection("GlassRed", true);
                    break;
                }
                case 750: {
                    this.setSelection("GlassGreen", true);
                    break;
                }
                case 760: {
                    this.setSelection("GlassBrown", true);
                    break;
                }
                case 770: {
                    this.setSelection("GlassBlue", true);
                    break;
                }
                case 780: {
                    this.setSelection("GlassViolet", true);
                    break;
                }
                case 790: {
                    this.setSelection("GlassTurquoise", true);
                    break;
                }
                case 800: {
                    this.setSelection("GlassLightgrey", true);
                    break;
                }
                case 810: {
                    this.setSelection("GlassGrey", true);
                    break;
                }
                case 820: {
                    this.setSelection("GlassPink", true);
                    break;
                }
                case 830: {
                    this.setSelection("GlassLightgreen", true);
                    break;
                }
                case 840: {
                    this.setSelection("GlassYellow", true);
                    break;
                }
                case 850: {
                    this.setSelection("GlassLightblue", true);
                    break;
                }
                case 860: {
                    this.setSelection("GlassMagenta", true);
                    break;
                }
                case 870: {
                    this.setSelection("GlassOrange", true);
                    break;
                }
                case 880: {
                    this.setSelection("GlassWhite", true);
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
        this.craftGlassBlackButton.displayString = this.getButtonDisplayString(this.craftGlassBlackButton.displayString, "glassblack", true);
        this.craftGlassRedButton.displayString = this.getButtonDisplayString(this.craftGlassRedButton.displayString, "glassred", true);
        this.craftGlassGreenButton.displayString = this.getButtonDisplayString(this.craftGlassGreenButton.displayString, "glassgreen", true);
        this.craftGlassBrownButton.displayString = this.getButtonDisplayString(this.craftGlassBrownButton.displayString, "glassbrown", true);
        this.craftGlassBlueButton.displayString = this.getButtonDisplayString(this.craftGlassBlueButton.displayString, "glassblue", true);
        this.craftGlassVioletButton.displayString = this.getButtonDisplayString(this.craftGlassVioletButton.displayString, "glassviolet", true);
        this.craftGlassTurquoiseButton.displayString = this.getButtonDisplayString(this.craftGlassTurquoiseButton.displayString, "glassturquoise", true);
        this.craftGlassLightGreyButton.displayString = this.getButtonDisplayString(this.craftGlassLightGreyButton.displayString, "glasslightgrey", true);
        this.craftGlassGreyButton.displayString = this.getButtonDisplayString(this.craftGlassGreyButton.displayString, "glassgrey", true);
        this.craftGlassPinkButton.displayString = this.getButtonDisplayString(this.craftGlassPinkButton.displayString, "glasspink", true);
        this.craftGlassLightGreenButton.displayString = this.getButtonDisplayString(this.craftGlassLightGreenButton.displayString, "glasslightgreen", true);
        this.craftGlassYellowButton.displayString = this.getButtonDisplayString(this.craftGlassYellowButton.displayString, "glassyellow", true);
        this.craftGlassLightBlueButton.displayString = this.getButtonDisplayString(this.craftGlassLightBlueButton.displayString, "glasslightblue", true);
        this.craftGlassMagentaButton.displayString = this.getButtonDisplayString(this.craftGlassMagentaButton.displayString, "glassmagenta", true);
        this.craftGlassOrangeButton.displayString = this.getButtonDisplayString(this.craftGlassOrangeButton.displayString, "glassorange", true);
        this.craftGlassWhiteButton.displayString = this.getButtonDisplayString(this.craftGlassWhiteButton.displayString, "glasswhite", true);
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
