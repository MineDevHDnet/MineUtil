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

public class CleanCraftGui6 extends GuiScreen
{
    GuiButton cleanSpawnerButton;
    GuiButton craftColorRedButton;
    GuiButton craftColorYellowButton;
    GuiButton craftColorPinkButton;
    GuiButton craftColorMagentaButton;
    GuiButton craftColorOrangeButton;
    GuiButton craftColorLightGreyButton;
    GuiButton craftColorVioletButton;
    GuiButton craftColorTurquoiseButton;
    GuiButton craftColorGreyButton;
    GuiButton craftColorLightGreenButton;
    GuiButton craftColorLightBlueButton;
    GuiButton craftColorWhiteButton;
    GuiButton cleanChestInventoryButton;
    
    GuiButton pageNextButton;
    GuiButton pagePrevButton;
    GuiButton closeButton;
    GuiButton closeCraftButton;
    GuiButton deactivateButton;
    GuiButton changeLogButton;
    
    public CleanCraftGui6() {}
    
    @Override
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
    	RenderUtils.renderNewGuiBackground();
    	MineUtil.getUtilCore().getSettings().setCurrentGuiPage(6);
        this.drawCenteredString(this.fontRendererObj, "Cleaning and Crafting", this.width / 2, ModButton.API.getButtonYPos(0, true) + 5, ModButton.toRainbow(18));
        this.drawCenteredString(this.fontRendererObj, "- Page 6 of 10 -", this.width / 2, 18, 16777215);
        this.drawString(this.fontRendererObj, "Cleaning", ModButton.API.getButtonXPos(1, this.width) + 1, ModButton.API.getButtonYPos(1, true) + 8, 16777215);
        this.drawString(this.fontRendererObj, "Crafting", ModButton.API.getButtonXPos(1, this.width) + 1, ModButton.API.getButtonYPos(4, true) + 8, 16777215);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
    
    public void initGui() {
        this.buttonList.add(this.cleanSpawnerButton = new ModButton(271, ModButton.API.getButtonXPos(1,this.width), ModButton.API.getButtonYPos(2), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Spawner: OFF"));
        this.buttonList.add(this.cleanChestInventoryButton = new ModButton(222, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(2), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Chest-Inventory: OFF"));
        
        this.buttonList.add(this.craftColorRedButton = new ModButton(620, ModButton.API.getButtonXPos(1,this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ColorRed: OFF"));
        this.buttonList.add(this.craftColorYellowButton = new ModButton(630, ModButton.API.getButtonXPos(2,this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ColorYellow: OFF"));
        this.buttonList.add(this.craftColorPinkButton = new ModButton(640, ModButton.API.getButtonXPos(3,this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ColorPink: OFF"));
        this.buttonList.add(this.craftColorMagentaButton = new ModButton(650, ModButton.API.getButtonXPos(4,this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ColorMagenta: OFF"));
        this.buttonList.add(this.craftColorOrangeButton = new ModButton(660, ModButton.API.getButtonXPos(1,this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ColorOrange: OFF"));
        this.buttonList.add(this.craftColorLightGreyButton = new ModButton(670, ModButton.API.getButtonXPos(2,this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ColorLightGrey: OFF"));
        this.buttonList.add(this.craftColorVioletButton = new ModButton(680, ModButton.API.getButtonXPos(3,this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ColorViolet: OFF"));
        this.buttonList.add(this.craftColorTurquoiseButton = new ModButton(690, ModButton.API.getButtonXPos(4,this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ColorTurquoise: OFF"));
        this.buttonList.add(this.craftColorGreyButton = new ModButton(700, ModButton.API.getButtonXPos(1,this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ColorGrey: OFF"));
        this.buttonList.add(this.craftColorLightGreenButton = new ModButton(710, ModButton.API.getButtonXPos(2,this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ColorLightGreen: OFF"));
        this.buttonList.add(this.craftColorLightBlueButton = new ModButton(720, ModButton.API.getButtonXPos(3,this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ColorLightBlue: OFF"));
        this.buttonList.add(this.craftColorWhiteButton = new ModButton(730, ModButton.API.getButtonXPos(4,this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ColorWhite: OFF"));
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
                    this.mc.displayGuiScreen(new CleanCraftGui5());
                    doAction = false;
                    break;
                }
                case 150: {
                    this.mc.displayGuiScreen(new CleanCraftGui7());
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
                case 620: {
                    this.setSelection("ColorRed", true);
                    break;
                }
                case 630: {
                    this.setSelection("ColorYellow", true);
                    break;
                }
                case 640: {
                    this.setSelection("ColorPink", true);
                    break;
                }
                case 650: {
                    this.setSelection("ColorMagenta", true);
                    break;
                }
                case 660: {
                    this.setSelection("ColorOrange", true);
                    break;
                }
                case 670: {
                    this.setSelection("ColorLightgrey", true);
                    break;
                }
                case 680: {
                    this.setSelection("ColorViolet", true);
                    break;
                }
                case 690: {
                    this.setSelection("ColorTurquoise", true);
                    break;
                }
                case 700: {
                    this.setSelection("ColorGrey", true);
                    break;
                }
                case 710: {
                    this.setSelection("ColorLightgreen", true);
                    break;
                }
                case 720: {
                    this.setSelection("ColorLightblue", true);
                    break;
                }
                case 730: {
                    this.setSelection("ColorWhite", true);
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
        this.craftColorRedButton.displayString = this.getButtonDisplayString(this.craftColorRedButton.displayString, "colorred", true);
        this.craftColorYellowButton.displayString = this.getButtonDisplayString(this.craftColorYellowButton.displayString, "coloryellow", true);
        this.craftColorPinkButton.displayString = this.getButtonDisplayString(this.craftColorPinkButton.displayString, "colorpink", true);
        this.craftColorMagentaButton.displayString = this.getButtonDisplayString(this.craftColorMagentaButton.displayString, "colormagenta", true);
        this.craftColorOrangeButton.displayString = this.getButtonDisplayString(this.craftColorOrangeButton.displayString, "colororange", true);
        this.craftColorLightGreyButton.displayString = this.getButtonDisplayString(this.craftColorLightGreyButton.displayString, "colorlightgrey", true);
        this.craftColorVioletButton.displayString = this.getButtonDisplayString(this.craftColorVioletButton.displayString, "colorviolet", true);
        this.craftColorTurquoiseButton.displayString = this.getButtonDisplayString(this.craftColorTurquoiseButton.displayString, "colorturquoise", true);
        this.craftColorGreyButton.displayString = this.getButtonDisplayString(this.craftColorGreyButton.displayString, "colorgrey", true);
        this.craftColorLightGreenButton.displayString = this.getButtonDisplayString(this.craftColorLightGreenButton.displayString, "colorlightgreen", true);
        this.craftColorLightBlueButton.displayString = this.getButtonDisplayString(this.craftColorLightBlueButton.displayString, "colorlightblue", true);
        this.craftColorWhiteButton.displayString = this.getButtonDisplayString(this.craftColorWhiteButton.displayString, "colorwhite", true);
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
