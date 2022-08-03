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

public class CleanCraftColorGui extends GuiScreen implements UtilCore {
	
    GuiButton cleanSpawnerButton,
    		  cleanChestInventoryButton,

			  craftColorRedButton,
			  craftColorYellowButton,
			  craftColorPinkButton,
			  craftColorMagentaButton,
			  craftColorOrangeButton,
			  craftColorLightGreyButton,
			  craftColorVioletButton,
			  craftColorTurquoiseButton,
			  craftColorGreyButton,
			  craftColorLightGreenButton,
			  craftColorLightBlueButton,
			  craftColorWhiteButton,

			  pageNextButton,
			  pagePrevButton,
			  closeButton,
			  closeCraftButton,
			  deactivateButton,
			  changeLogButton;
    
    public CleanCraftColorGui() {
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
    	mineUtil.getSettings().setCurrentGuiPage(12);
    	this.drawCenteredString(this.fontRendererObj, "Cleaning and Crafting", this.width / 2, ModButton.API.getButtonYPos(0, true) + 5, ModButton.toRainbow(18));
        this.drawCenteredString(this.fontRendererObj, "- Page 12 of 13 -", this.width / 2, 18, 16777215);
        this.drawString(this.fontRendererObj, "Cleaning", ModButton.API.getButtonXPos(1, this.width) + 1, ModButton.API.getButtonYPos(1, true) + 8, 16777215);
        this.drawString(this.fontRendererObj, "Crafting - Color", ModButton.API.getButtonXPos(1, this.width) + 1, ModButton.API.getButtonYPos(4, true) + 8, 16777215);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
    
    @Override
    public void initGui() {
    	this.buttonList.add(this.cleanSpawnerButton = new ModButton(200, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(2), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Spawner: OFF"));
    	this.buttonList.add(this.cleanChestInventoryButton = new ModButton(210, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(2), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ChestInventory: OFF"));
        
        this.buttonList.add(this.craftColorRedButton = new ModButton(300, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ColorRed: OFF"));
        this.buttonList.add(this.craftColorYellowButton = new ModButton(310, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ColorYellow: OFF"));
        this.buttonList.add(this.craftColorPinkButton = new ModButton(320, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ColorPink: OFF"));
        this.buttonList.add(this.craftColorMagentaButton = new ModButton(330, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ColorMagenta: OFF"));
        this.buttonList.add(this.craftColorOrangeButton = new ModButton(340, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ColorOrange: OFF"));
        this.buttonList.add(this.craftColorLightGreyButton = new ModButton(350, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ColorLightGrey: OFF"));
        this.buttonList.add(this.craftColorVioletButton = new ModButton(360, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ColorViolet: OFF"));
        this.buttonList.add(this.craftColorTurquoiseButton = new ModButton(370, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ColorTurquoise: OFF"));
        this.buttonList.add(this.craftColorGreyButton = new ModButton(380, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ColorGrey: OFF"));
        this.buttonList.add(this.craftColorLightGreenButton = new ModButton(390, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ColorLightGreen: OFF"));
        this.buttonList.add(this.craftColorLightBlueButton = new ModButton(400, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ColorLightBlue: OFF"));
        this.buttonList.add(this.craftColorWhiteButton = new ModButton(410, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ColorWhite: OFF"));
        
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
	                this.mc.displayGuiScreen(new CleanCraftClayGui());
	                break;
	            }
	            case 110: {
	            	doAction = false;
	                this.mc.displayGuiScreen(new CleanCraftFoodGui());
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
                    this.setSelection("ColorRed", true);
                    break;
                }
                case 310: {
                    this.setSelection("ColorYellow", true);
                    break;
                }
                case 320: {
                    this.setSelection("ColorPink", true);
                    break;
                }
                case 330: {
                    this.setSelection("GlassbBlue", true);
                    break;
                }
                case 340: {
                    this.setSelection("ColorOrange", true);
                    break;
                }
                case 350: {
                    this.setSelection("ColorLightGrey", true);
                    break;
                }
                case 360: {
                    this.setSelection("ColorViolet", true);
                    break;
                }
                case 370: {
                    this.setSelection("ColorTurquoise", true);
                    break;
                }
                case 380: {
                    this.setSelection("ColorGrey", true);
                    break;
                }
                case 390: {
                    this.setSelection("ColorLightGreen", true);
                    break;
                }
                case 400: {
                    this.setSelection("ColorLightBlue", true);
                    break;
                }
                case 410: {
                    this.setSelection("ColorWhite", true);
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
        
        this.craftColorRedButton.displayString = this.getButtonDisplayString(this.craftColorRedButton.displayString, "ColorRed", true);
        this.craftColorYellowButton.displayString = this.getButtonDisplayString(this.craftColorYellowButton.displayString, "ColorYellow", true);
        this.craftColorPinkButton.displayString = this.getButtonDisplayString(this.craftColorPinkButton.displayString, "ColorPink", true);
        this.craftColorMagentaButton.displayString = this.getButtonDisplayString(this.craftColorMagentaButton.displayString, "ColorMagenta", true);
        this.craftColorOrangeButton.displayString = this.getButtonDisplayString(this.craftColorOrangeButton.displayString, "ColorOrange", true);
        this.craftColorLightGreyButton.displayString = this.getButtonDisplayString(this.craftColorLightGreyButton.displayString, "ColorLightGrey", true);
        this.craftColorVioletButton.displayString = this.getButtonDisplayString(this.craftColorVioletButton.displayString, "ColorViolet", true);
        this.craftColorTurquoiseButton.displayString = this.getButtonDisplayString(this.craftColorTurquoiseButton.displayString, "ColorTurquoise", true);
        this.craftColorGreyButton.displayString = this.getButtonDisplayString(this.craftColorGreyButton.displayString, "ColorGrey", true);
        this.craftColorLightGreenButton.displayString = this.getButtonDisplayString(this.craftColorLightGreenButton.displayString, "ColorLightGreen", true);
        this.craftColorLightBlueButton.displayString = this.getButtonDisplayString(this.craftColorLightBlueButton.displayString, "ColorLightBlue", true);
        this.craftColorWhiteButton.displayString = this.getButtonDisplayString(this.craftColorWhiteButton.displayString, "ColorWhite", true);
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
