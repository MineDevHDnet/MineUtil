package net.minedevhd.mineutil.gui.cleanandcraft;

import java.io.IOException;
import java.net.URI;
import java.util.Locale;

import java.awt.Color;

import net.labymod.core.LabyModCore;
import net.labymod.main.LabyMod;
import net.labymod.utils.ModColor;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.MineUtil.CCGui;
import net.minedevhd.mineutil.gui.changelog.ChangelogGui;
import net.minedevhd.mineutil.gui.storageprices.TEDLagerPreisGui;
import net.minedevhd.mineutil.helper.StealHelper;
import net.minedevhd.mineutil.settings.UtilCore;
import net.minedevhd.mineutil.utils.ModButton;
import net.minedevhd.mineutil.utils.ModButton.API;
import net.minedevhd.mineutil.utils.graf.RenderUtils;

public class CleanCraftWoolGui extends GuiScreen implements UtilCore {
	
    GuiButton cleanSpawnerButton,
    		  cleanChestInventoryButton,

			  craftWoolBlackButton,
			  craftWoolRedButton,
			  craftWoolGreenButton,
			  craftWoolBrownButton,
			  craftWoolBlueButton,
			  craftWoolVioletButton,
			  craftWoolTurquoiseButton,
			  craftWoolLightGreyButton,
			  craftWoolGreyButton,
			  craftWoolPinkButton,
			  craftWoolLightGreenButton,
			  craftWoolYellowButton,
			  craftWoolLightBlueButton,
			  craftWoolMagentaButton,
			  craftWoolOrangeButton,
			  craftWoolButton,

			  pageNextButton,
			  pagePrevButton,
			  closeButton,
			  closeCraftButton,
			  deactivateButton,
			  changeLogButton;
    
    public CleanCraftWoolGui() {
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
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
    	RenderUtils.renderNewGuiBackground();
    	mineUtil.getSettings().setCurrentGuiPage(9);
    	this.drawCenteredString(this.fontRendererObj, "Cleaning and Crafting", this.width / 2, ModButton.API.getButtonYPos(0, true) + 5, ModButton.toRainbow(18));
        this.drawCenteredString(this.fontRendererObj, "- Page 9 of 13 -", this.width / 2, 18, 16777215);
        this.drawString(this.fontRendererObj, "Cleaning", ModButton.API.getButtonXPos(1, this.width) + 1, ModButton.API.getButtonYPos(1, true) + 8, 16777215);
        this.drawString(this.fontRendererObj, "Crafting - Wool", ModButton.API.getButtonXPos(1, this.width) + 1, ModButton.API.getButtonYPos(4, true) + 8, 16777215);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
    
    @Override
    public void initGui() {
    	this.buttonList.add(this.cleanSpawnerButton = new ModButton(200, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(2), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Spawner: OFF"));
    	this.buttonList.add(this.cleanChestInventoryButton = new ModButton(210, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(2), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ChestInventory: OFF"));
        
    	this.buttonList.add(this.craftWoolBlackButton = new ModButton(300, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "WoolBlack: OFF"));
        this.buttonList.add(this.craftWoolRedButton = new ModButton(310, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "WoolRed: OFF"));
        this.buttonList.add(this.craftWoolGreenButton = new ModButton(320, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "WoolGreen: OFF"));
        this.buttonList.add(this.craftWoolBrownButton = new ModButton(330, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "WoolBrown: OFF"));
        this.buttonList.add(this.craftWoolBlueButton = new ModButton(340, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "WoolBlue: OFF"));
        this.buttonList.add(this.craftWoolVioletButton = new ModButton(350, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "WoolViolet: OFF"));
        this.buttonList.add(this.craftWoolTurquoiseButton = new ModButton(360, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "WoolTurquoise: OFF"));
        this.buttonList.add(this.craftWoolLightGreyButton = new ModButton(370, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "WoolLightGrey: OFF"));
        this.buttonList.add(this.craftWoolGreyButton = new ModButton(380, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "WoolGrey: OFF"));
        this.buttonList.add(this.craftWoolPinkButton = new ModButton(390, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "WoolPink: OFF"));
        this.buttonList.add(this.craftWoolLightGreenButton = new ModButton(400, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "WoolLightGreen: OFF"));
        this.buttonList.add(this.craftWoolYellowButton = new ModButton(410, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "WoolYellow: OFF"));
        this.buttonList.add(this.craftWoolLightBlueButton = new ModButton(420, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "WoolLightBlue: OFF"));
        this.buttonList.add(this.craftWoolMagentaButton = new ModButton(430, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "WoolMagenta: OFF"));
        this.buttonList.add(this.craftWoolOrangeButton = new ModButton(440, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "WoolOrange: OFF"));
        this.buttonList.add(this.craftWoolButton = new ModButton(450, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Wool: OFF"));
        
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
    
    @Override
    protected void actionPerformed(final GuiButton button) throws IOException {
        try {
            boolean doAction = true;
            switch (button.id) {
	            case 100: {
	            	doAction = false;
	                this.mc.displayGuiScreen(new CleanCraftOthers2Gui());
	                break;
	            }
	            case 110: {
	            	doAction = false;
	                this.mc.displayGuiScreen(new CleanCraftGlassGui());
	                break;
	            }
	            case 120: {
	            	doAction = false;
	            	this.mc.thePlayer.closeScreen();
	            	LabyModCore.getMinecraft().getPlayer().sendChatMessage("/craft");
	            	break;
	            }
	            case 130: {
	            	ModButton.API.a_617553_p(mineUtil);
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
                    this.setSelection("WoolBlack", true);
                    break;
                }
                case 310: {
                    this.setSelection("WoolRed", true);
                    break;
                }
                case 320: {
                    this.setSelection("WoolGreen", true);
                    break;
                }
                case 330: {
                    this.setSelection("WoolBrown", true);
                    break;
                }
                case 340: {
                    this.setSelection("WoolbBlue", true);
                    break;
                }
                case 350: {
                    this.setSelection("WoolViolet", true);
                    break;
                }
                case 360: {
                    this.setSelection("WoolTurquoise", true);
                    break;
                }
                case 370: {
                    this.setSelection("WoolLightgrey", true);
                    break;
                }
                case 380: {
                    this.setSelection("WoolGrey", true);
                    break;
                }
                case 390: {
                    this.setSelection("WoolPink", true);
                    break;
                }
                case 400: {
                    this.setSelection("WoolLightgreen", true);
                    break;
                }
                case 410: {
                    this.setSelection("WoolYellow", true);
                    break;
                }
                case 420: {
                    this.setSelection("WoolLightblue", true);
                    break;
                }
                case 430: {
                    this.setSelection("WoolMagenta", true);
                    break;
                }
                case 440: {
                    this.setSelection("WoolOrange", true);
                    break;
                }
                case 450: {
                    this.setSelection("Wool", true);
                    break;
                }
            }
            if(doAction) {
                this.updateButtons();
                super.actionPerformed(button);
            }
        }
        catch (Exception exception) {}
    }
    
    private String getButtonDisplayString(String displayString, final String type, final boolean crafting) {
        final String selection = crafting ? mineUtil.getCraftSelection() : mineUtil.getCleanSelection();
        displayString = displayString.replaceAll("(ON|OFF)", "") + (selection.equalsIgnoreCase(type) ? "ON" : "OFF");
        return displayString;
    }
    
    private void setSelection(final String type, final boolean crafting) {
        final String selection = crafting ? mineUtil.getCraftSelection() : mineUtil.getCleanSelection();
        final String setSel = selection.equalsIgnoreCase(type) ? "" : type;
        
    	if(crafting) {
    		mineUtil.setCraftSelection(setSel);
            if(setSel.length() > 0) {
            	final String sel = setSel.replace(": OFF", "").replace(": ON", "");
                mineUtil.getApi().displayMessageInChat(mineUtil.getSettings().getPrefix() 
                		+ "§7Module §eAutomatic Crafting §8(§7" + sel + "§8) §7has been §aactivated§7.");
            }
            else {
                mineUtil.getApi().displayMessageInChat(mineUtil.getSettings().getPrefix() 
                		+ "§7Module §eAutomatic Crafting §7has been §cdeactivated§7.");
            }
        }
        else {
            mineUtil.setCleanSelection(setSel);
            if(setSel.length() > 0) {
            	final String sel = setSel.replace(": OFF", "").replace(": ON", "");
                mineUtil.getApi().displayMessageInChat(mineUtil.getSettings().getPrefix() 
                		+ "§7Module §eAutomatic Cleaning §8(§7" + sel + "§8) §7has been §aactivated§7.");
            }
            else {
                mineUtil.getApi().displayMessageInChat(mineUtil.getSettings().getPrefix() 
                		+ "§7Module §eAutomatic Cleaning §7has been §cdeactivated§7.");
            }
        }
    }
    
    private void updateButtons() {
//    	this.changeLogButton.enabled = false;
        if(mineUtil.getCraftSelection().length() > 0 || mineUtil.getCleanSelection().length() > 0) {
            this.deactivateButton.enabled = true;
            if(mineUtil.getCraftSelection().length() > 0) {
            	this.closeCraftButton.enabled = true;
            }
        }
        else {
            this.deactivateButton.enabled = false;
            this.closeCraftButton.enabled = false;
        }
        
        this.cleanSpawnerButton.displayString = this.getButtonDisplayString(this.cleanSpawnerButton.displayString, "spawner", false);
        this.cleanChestInventoryButton.displayString = this.getButtonDisplayString(this.cleanChestInventoryButton.displayString, "ChestInventory", false);
        
        this.craftWoolBlackButton.displayString = this.getButtonDisplayString(this.craftWoolBlackButton.displayString, "WoolBlack", true);
        this.craftWoolRedButton.displayString = this.getButtonDisplayString(this.craftWoolRedButton.displayString, "WoolRed", true);
        this.craftWoolGreenButton.displayString = this.getButtonDisplayString(this.craftWoolGreenButton.displayString, "WoolGreen", true);
        this.craftWoolBrownButton.displayString = this.getButtonDisplayString(this.craftWoolBrownButton.displayString, "WoolBrown", true);
        this.craftWoolBlueButton.displayString = this.getButtonDisplayString(this.craftWoolBlueButton.displayString, "WoolBlue", true);
        this.craftWoolVioletButton.displayString = this.getButtonDisplayString(this.craftWoolVioletButton.displayString, "WoolViolet", true);
        this.craftWoolTurquoiseButton.displayString = this.getButtonDisplayString(this.craftWoolTurquoiseButton.displayString, "WoolTurquoise", true);
        this.craftWoolLightGreyButton.displayString = this.getButtonDisplayString(this.craftWoolLightGreyButton.displayString, "WoolLightGrey", true);
        this.craftWoolGreyButton.displayString = this.getButtonDisplayString(this.craftWoolGreyButton.displayString, "WoolGrey", true);
        this.craftWoolPinkButton.displayString = this.getButtonDisplayString(this.craftWoolPinkButton.displayString, "WoolPink", true);
        this.craftWoolLightGreenButton.displayString = this.getButtonDisplayString(this.craftWoolLightGreenButton.displayString, "WoolLightGreen", true);
        this.craftWoolYellowButton.displayString = this.getButtonDisplayString(this.craftWoolYellowButton.displayString, "WoolYellow", true);
        this.craftWoolLightBlueButton.displayString = this.getButtonDisplayString(this.craftWoolLightBlueButton.displayString, "WoolLightBlue", true);
        this.craftWoolMagentaButton.displayString = this.getButtonDisplayString(this.craftWoolMagentaButton.displayString, "WoolMagenta", true);
        this.craftWoolOrangeButton.displayString = this.getButtonDisplayString(this.craftWoolOrangeButton.displayString, "WoolOrange", true);
        this.craftWoolButton.displayString = this.getButtonDisplayString(this.craftWoolButton.displayString, "Wool", true);
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
