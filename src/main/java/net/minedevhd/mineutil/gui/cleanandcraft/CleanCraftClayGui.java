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

public class CleanCraftClayGui extends GuiScreen implements UtilCore {
	
    GuiButton cleanSpawnerButton,
    		  cleanChestInventoryButton,

			  craftClayBlackButton,
			  craftClayRedButton,
			  craftClayGreenButton,
			  craftClayBrownButton,
			  craftClayBlueButton,
			  craftClayVioletButton,
			  craftClayTurquoiseButton,
			  craftClayLightGreyButton,
			  craftClayGreyButton,
			  craftClayPinkButton,
			  craftClayLightGreenButton,
			  craftClayYellowButton,
			  craftClayLightBlueButton,
			  craftClayMagentaButton,
			  craftClayOrangeButton,
			  craftClayWhiteButton,
			  craftClayBlockButton,

			  pageNextButton,
			  pagePrevButton,
			  closeButton,
			  closeCraftButton,
			  deactivateButton,
			  changeLogButton;
    
    public CleanCraftClayGui() {
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
    	mineUtil.getSettings().setCurrentGuiPage(11);
    	this.drawCenteredString(this.fontRendererObj, "Cleaning and Crafting", this.width / 2, ModButton.API.getButtonYPos(0, true) + 5, ModButton.toRainbow(18));
        this.drawCenteredString(this.fontRendererObj, "- Page 11 of 13 -", this.width / 2, 18, 16777215);
        this.drawString(this.fontRendererObj, "Cleaning", ModButton.API.getButtonXPos(1, this.width) + 1, ModButton.API.getButtonYPos(1, true) + 8, 16777215);
        this.drawString(this.fontRendererObj, "Crafting - Clay", ModButton.API.getButtonXPos(1, this.width) + 1, ModButton.API.getButtonYPos(4, true) + 8, 16777215);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
    
    @Override
    public void initGui() {
    	this.buttonList.add(this.cleanSpawnerButton = new ModButton(200, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(2), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Spawner: OFF"));
    	this.buttonList.add(this.cleanChestInventoryButton = new ModButton(210, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(2), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ChestInventory: OFF"));
        
    	this.buttonList.add(this.craftClayBlackButton = new ModButton(300, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ClayBlack: OFF"));
        this.buttonList.add(this.craftClayRedButton = new ModButton(310, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ClayRed: OFF"));
        this.buttonList.add(this.craftClayGreenButton = new ModButton(320, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ClayGreen: OFF"));
        this.buttonList.add(this.craftClayBrownButton = new ModButton(330, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ClayBrown: OFF"));
        this.buttonList.add(this.craftClayBlueButton = new ModButton(340, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ClayBlue: OFF"));
        this.buttonList.add(this.craftClayVioletButton = new ModButton(350, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ClayViolet: OFF"));
        this.buttonList.add(this.craftClayTurquoiseButton = new ModButton(360, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ClayTurquoise: OFF"));
        this.buttonList.add(this.craftClayLightGreyButton = new ModButton(370, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ClayLightGrey: OFF"));
        this.buttonList.add(this.craftClayGreyButton = new ModButton(380, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ClayGrey: OFF"));
        this.buttonList.add(this.craftClayPinkButton = new ModButton(390, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ClayPink: OFF"));
        this.buttonList.add(this.craftClayLightGreenButton = new ModButton(400, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ClayLightGreen: OFF"));
        this.buttonList.add(this.craftClayYellowButton = new ModButton(410, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ClayYellow: OFF"));
        this.buttonList.add(this.craftClayLightBlueButton = new ModButton(420, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ClayLightBlue: OFF"));
        this.buttonList.add(this.craftClayMagentaButton = new ModButton(430, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ClayMagenta: OFF"));
        this.buttonList.add(this.craftClayOrangeButton = new ModButton(440, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ClayOrange: OFF"));
        this.buttonList.add(this.craftClayWhiteButton = new ModButton(450, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ClayWhite: OFF"));
        this.buttonList.add(this.craftClayBlockButton = new ModButton(460, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(9), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ClayBlock: OFF"));
        
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
	                this.mc.displayGuiScreen(new CleanCraftGlassGui());
	                break;
	            }
	            case 110: {
	            	doAction = false;
	                this.mc.displayGuiScreen(new CleanCraftColorGui());
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
                    this.setSelection("ClayBlack", true);
                    break;
                }
                case 310: {
                    this.setSelection("ClayRed", true);
                    break;
                }
                case 320: {
                    this.setSelection("ClayGreen", true);
                    break;
                }
                case 330: {
                    this.setSelection("ClayBrown", true);
                    break;
                }
                case 340: {
                    this.setSelection("GlassbBlue", true);
                    break;
                }
                case 350: {
                    this.setSelection("ClayViolet", true);
                    break;
                }
                case 360: {
                    this.setSelection("ClayTurquoise", true);
                    break;
                }
                case 370: {
                    this.setSelection("ClayLightGrey", true);
                    break;
                }
                case 380: {
                    this.setSelection("ClayGrey", true);
                    break;
                }
                case 390: {
                    this.setSelection("ClayPink", true);
                    break;
                }
                case 400: {
                    this.setSelection("ClayLightGreen", true);
                    break;
                }
                case 410: {
                    this.setSelection("ClayYellow", true);
                    break;
                }
                case 420: {
                    this.setSelection("ClayLightBlue", true);
                    break;
                }
                case 430: {
                    this.setSelection("ClayMagenta", true);
                    break;
                }
                case 440: {
                    this.setSelection("ClayOrange", true);
                    break;
                }
                case 450: {
                    this.setSelection("ClayWhite", true);
                    break;
                }
                case 460: {
                	this.setSelection("ClayBlock", true);
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
        
        this.craftClayBlackButton.displayString = this.getButtonDisplayString(this.craftClayBlackButton.displayString, "ClayBlack", true);
        this.craftClayRedButton.displayString = this.getButtonDisplayString(this.craftClayRedButton.displayString, "ClayRed", true);
        this.craftClayGreenButton.displayString = this.getButtonDisplayString(this.craftClayGreenButton.displayString, "ClayGreen", true);
        this.craftClayBrownButton.displayString = this.getButtonDisplayString(this.craftClayBrownButton.displayString, "ClayBrown", true);
        this.craftClayBlueButton.displayString = this.getButtonDisplayString(this.craftClayBlueButton.displayString, "ClayBlue", true);
        this.craftClayVioletButton.displayString = this.getButtonDisplayString(this.craftClayVioletButton.displayString, "ClayViolet", true);
        this.craftClayTurquoiseButton.displayString = this.getButtonDisplayString(this.craftClayTurquoiseButton.displayString, "ClayTurquoise", true);
        this.craftClayLightGreyButton.displayString = this.getButtonDisplayString(this.craftClayLightGreyButton.displayString, "ClayLightGrey", true);
        this.craftClayGreyButton.displayString = this.getButtonDisplayString(this.craftClayGreyButton.displayString, "ClayGrey", true);
        this.craftClayPinkButton.displayString = this.getButtonDisplayString(this.craftClayPinkButton.displayString, "ClayPink", true);
        this.craftClayLightGreenButton.displayString = this.getButtonDisplayString(this.craftClayLightGreenButton.displayString, "ClayLightGreen", true);
        this.craftClayYellowButton.displayString = this.getButtonDisplayString(this.craftClayYellowButton.displayString, "ClayYellow", true);
        this.craftClayLightBlueButton.displayString = this.getButtonDisplayString(this.craftClayLightBlueButton.displayString, "ClayLightBlue", true);
        this.craftClayMagentaButton.displayString = this.getButtonDisplayString(this.craftClayMagentaButton.displayString, "ClayMagenta", true);
        this.craftClayOrangeButton.displayString = this.getButtonDisplayString(this.craftClayOrangeButton.displayString, "ClayOrange", true);
        this.craftClayWhiteButton.displayString = this.getButtonDisplayString(this.craftClayWhiteButton.displayString, "ClayWhite", true);
        this.craftClayBlockButton.displayString = this.getButtonDisplayString(this.craftClayBlockButton.displayString, "ClayBlock", true);
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
