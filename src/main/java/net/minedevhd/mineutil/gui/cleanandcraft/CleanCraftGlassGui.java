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
import net.minedevhd.mineutil.utils.ModButton;
import net.minedevhd.mineutil.utils.ModButton.API;
import net.minedevhd.mineutil.utils.RenderUtils;

public class CleanCraftGlassGui extends GuiScreen {
	
    GuiButton cleanSpawnerButton,
    		  cleanChestInventoryButton,

			  craftGlassBlackButton,
			  craftGlassRedButton,
			  craftGlassGreenButton,
			  craftGlassBrownButton,
			  craftGlassBlueButton,
			  craftGlassVioletButton,
			  craftGlassTurquoiseButton,
			  craftGlassLightGreyButton,
			  craftGlassGreyButton,
			  craftGlassPinkButton,
			  craftGlassLightGreenButton,
			  craftGlassYellowButton,
			  craftGlassLightBlueButton,
			  craftGlassMagentaButton,
			  craftGlassOrangeButton,
			  craftGlassButton,

			  pageNextButton,
			  pagePrevButton,
			  closeButton,
			  closeCraftButton,
			  deactivateButton,
			  changeLogButton;
    
    public CleanCraftGlassGui() {
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
    	MineUtil.getUtilCore().getSettings().setCurrentGuiPage(10);
    	this.drawCenteredString(this.fontRendererObj, "Cleaning and Crafting", this.width / 2, ModButton.API.getButtonYPos(0, true) + 5, ModButton.toRainbow(18));
        this.drawCenteredString(this.fontRendererObj, "- Page 10 of 13 -", this.width / 2, 18, 16777215);
        this.drawString(this.fontRendererObj, "Cleaning", ModButton.API.getButtonXPos(1, this.width) + 1, ModButton.API.getButtonYPos(1, true) + 8, 16777215);
        this.drawString(this.fontRendererObj, "Crafting - Glass", ModButton.API.getButtonXPos(1, this.width) + 1, ModButton.API.getButtonYPos(4, true) + 8, 16777215);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
    
    @Override
    public void initGui() {
    	this.buttonList.add(this.cleanSpawnerButton = new ModButton(200, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(2), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Spawner: OFF"));
    	this.buttonList.add(this.cleanChestInventoryButton = new ModButton(210, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(2), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ChestInventory: OFF"));
        
    	this.buttonList.add(this.craftGlassBlackButton = new ModButton(300, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "GlassBlack: OFF"));
        this.buttonList.add(this.craftGlassRedButton = new ModButton(310, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "GlassRed: OFF"));
        this.buttonList.add(this.craftGlassGreenButton = new ModButton(320, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "GlassGreen: OFF"));
        this.buttonList.add(this.craftGlassBrownButton = new ModButton(330, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "GlassBrown: OFF"));
        this.buttonList.add(this.craftGlassBlueButton = new ModButton(340, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "GlassBlue: OFF"));
        this.buttonList.add(this.craftGlassVioletButton = new ModButton(350, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "GlassViolet: OFF"));
        this.buttonList.add(this.craftGlassTurquoiseButton = new ModButton(360, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "GlassTurquoise: OFF"));
        this.buttonList.add(this.craftGlassLightGreyButton = new ModButton(370, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "GlassLightGrey: OFF"));
        this.buttonList.add(this.craftGlassGreyButton = new ModButton(380, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "GlassGrey: OFF"));
        this.buttonList.add(this.craftGlassPinkButton = new ModButton(390, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "GlassPink: OFF"));
        this.buttonList.add(this.craftGlassLightGreenButton = new ModButton(400, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "GlassLightGreen: OFF"));
        this.buttonList.add(this.craftGlassYellowButton = new ModButton(410, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "GlassYellow: OFF"));
        this.buttonList.add(this.craftGlassLightBlueButton = new ModButton(420, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "GlassLightBlue: OFF"));
        this.buttonList.add(this.craftGlassMagentaButton = new ModButton(430, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "GlassMagenta: OFF"));
        this.buttonList.add(this.craftGlassOrangeButton = new ModButton(440, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "GlassOrange: OFF"));
        this.buttonList.add(this.craftGlassButton = new ModButton(450, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Glass: OFF"));
        
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
	                this.mc.displayGuiScreen(new CleanCraftWoolGui());
	                break;
	            }
	            case 110: {
	            	doAction = false;
	                this.mc.displayGuiScreen(new CleanCraftClayGui());
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
                    this.setSelection("GlassBlack", true);
                    break;
                }
                case 310: {
                    this.setSelection("GlassRed", true);
                    break;
                }
                case 320: {
                    this.setSelection("GlassGreen", true);
                    break;
                }
                case 330: {
                    this.setSelection("GlassBrown", true);
                    break;
                }
                case 340: {
                    this.setSelection("GlassbBlue", true);
                    break;
                }
                case 350: {
                    this.setSelection("GlassViolet", true);
                    break;
                }
                case 360: {
                    this.setSelection("GlassTurquoise", true);
                    break;
                }
                case 370: {
                    this.setSelection("GlassLightGrey", true);
                    break;
                }
                case 380: {
                    this.setSelection("GlassGrey", true);
                    break;
                }
                case 390: {
                    this.setSelection("GlassPink", true);
                    break;
                }
                case 400: {
                    this.setSelection("GlassLightGreen", true);
                    break;
                }
                case 410: {
                    this.setSelection("GlassYellow", true);
                    break;
                }
                case 420: {
                    this.setSelection("GlassLightblue", true);
                    break;
                }
                case 430: {
                    this.setSelection("GlassMagenta", true);
                    break;
                }
                case 440: {
                    this.setSelection("GlassOrange", true);
                    break;
                }
                case 450: {
                    this.setSelection("Glass", true);
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
//    	this.changeLogButton.enabled = false;
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
        
        this.craftGlassBlackButton.displayString = this.getButtonDisplayString(this.craftGlassBlackButton.displayString, "GlassBlack", true);
        this.craftGlassRedButton.displayString = this.getButtonDisplayString(this.craftGlassRedButton.displayString, "GlassRed", true);
        this.craftGlassGreenButton.displayString = this.getButtonDisplayString(this.craftGlassGreenButton.displayString, "GlassGreen", true);
        this.craftGlassBrownButton.displayString = this.getButtonDisplayString(this.craftGlassBrownButton.displayString, "GlassBrown", true);
        this.craftGlassBlueButton.displayString = this.getButtonDisplayString(this.craftGlassBlueButton.displayString, "GlassBlue", true);
        this.craftGlassVioletButton.displayString = this.getButtonDisplayString(this.craftGlassVioletButton.displayString, "GlassViolet", true);
        this.craftGlassTurquoiseButton.displayString = this.getButtonDisplayString(this.craftGlassTurquoiseButton.displayString, "GlassTurquoise", true);
        this.craftGlassLightGreyButton.displayString = this.getButtonDisplayString(this.craftGlassLightGreyButton.displayString, "GlassLightGrey", true);
        this.craftGlassGreyButton.displayString = this.getButtonDisplayString(this.craftGlassGreyButton.displayString, "GlassGrey", true);
        this.craftGlassPinkButton.displayString = this.getButtonDisplayString(this.craftGlassPinkButton.displayString, "GlassPink", true);
        this.craftGlassLightGreenButton.displayString = this.getButtonDisplayString(this.craftGlassLightGreenButton.displayString, "GlassLightGreen", true);
        this.craftGlassYellowButton.displayString = this.getButtonDisplayString(this.craftGlassYellowButton.displayString, "GlassYellow", true);
        this.craftGlassLightBlueButton.displayString = this.getButtonDisplayString(this.craftGlassLightBlueButton.displayString, "GlassLightBlue", true);
        this.craftGlassMagentaButton.displayString = this.getButtonDisplayString(this.craftGlassMagentaButton.displayString, "GlassMagenta", true);
        this.craftGlassOrangeButton.displayString = this.getButtonDisplayString(this.craftGlassOrangeButton.displayString, "GlassOrange", true);
        this.craftGlassButton.displayString = this.getButtonDisplayString(this.craftGlassButton.displayString, "Glass", true);
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
