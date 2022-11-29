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

public class CleanCraftFoodGui extends GuiScreen implements UtilCore {
	
    GuiButton cleanSpawnerButton,
    		  cleanChestInventoryButton,

			  craftBreadButton,
			  craftCakeButton,
			  craftCookieButton,
			  craftGoldenAppleButton,
			  craftOPGoldenAppleButton,
			  craftGoldenCarrotButton,
			  craftPumpkinPieButton,
			  craftMushroomStewButton,
			  craftRabbitStewButton,
			  craftGoldenMelonButton,
			  craftMelonButton,
			  craftHayBlockButton,
			  craftBowlButton,

			  pageNextButton,
			  pagePrevButton,
			  closeButton,
			  closeCraftButton,
			  deactivateButton,
			  changeLogButton;
    
    public CleanCraftFoodGui() {
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
    	mineUtil.getSettings().setCurrentGuiPage(13);
    	this.drawCenteredString(this.fontRendererObj, "Cleaning and Crafting", this.width / 2, ModButton.API.getButtonYPos(0, true) + 5, ModButton.toRainbow(18));
        this.drawCenteredString(this.fontRendererObj, "- Page 13 of 13 -", this.width / 2, 18, 16777215);
        this.drawString(this.fontRendererObj, "Cleaning", ModButton.API.getButtonXPos(1, this.width) + 1, ModButton.API.getButtonYPos(1, true) + 8, 16777215);
        this.drawString(this.fontRendererObj, "Crafting - Food", ModButton.API.getButtonXPos(1, this.width) + 1, ModButton.API.getButtonYPos(4, true) + 8, 16777215);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
    
    @Override
    public void initGui() {
    	this.buttonList.add(this.cleanSpawnerButton = new ModButton(200, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(2), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Spawner: OFF"));
    	this.buttonList.add(this.cleanChestInventoryButton = new ModButton(210, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(2), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ChestInventory: OFF"));
        
    	this.buttonList.add(this.craftBreadButton = new ModButton(300, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Bread: OFF"));
        this.buttonList.add(this.craftCakeButton = new ModButton(310, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Cake: OFF"));
        this.buttonList.add(this.craftCookieButton = new ModButton(320, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Cookie: OFF"));
        this.buttonList.add(this.craftGoldenAppleButton = new ModButton(330, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "GoldenApple: OFF"));
        this.buttonList.add(this.craftOPGoldenAppleButton = new ModButton(340, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "OPGoldenApple: OFF"));
        this.buttonList.add(this.craftGoldenCarrotButton = new ModButton(350, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "GoldenCarrot: OFF"));
        this.buttonList.add(this.craftPumpkinPieButton = new ModButton(360, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "PumpkinPie: OFF"));
        this.buttonList.add(this.craftMushroomStewButton = new ModButton(370, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "MushroomStew: OFF"));
        this.buttonList.add(this.craftRabbitStewButton = new ModButton(380, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "RabbitStew: OFF"));
        this.buttonList.add(this.craftGoldenMelonButton = new ModButton(390, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "GoldenMelon: OFF"));
        this.buttonList.add(this.craftMelonButton = new ModButton(400, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Melon: OFF"));
        this.buttonList.add(this.craftHayBlockButton = new ModButton(410, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "HayBlock: OFF"));
        this.buttonList.add(this.craftBowlButton = new ModButton(420, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Bowl: OFF"));
        
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
	                this.mc.displayGuiScreen(new CleanCraftColorGui());
	                break;
	            }
	            case 110: {
	            	doAction = false;
	                this.mc.displayGuiScreen(new CleanCraftOreGui());
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
                    this.setSelection("Bread", true);
                    break;
                }
                case 310: {
                    this.setSelection("Cake", true);
                    break;
                }
                case 320: {
                    this.setSelection("Cookie", true);
                    break;
                }
                case 330: {
                    this.setSelection("GoldenApple", true);
                    break;
                }
                case 340: {
                    this.setSelection("OPGoldenApple", true);
                    break;
                }
                case 350: {
                    this.setSelection("GoldenCarrot", true);
                    break;
                }
                case 360: {
                    this.setSelection("PumpkinPie", true);
                    break;
                }
                case 370: {
                    this.setSelection("MushroomStew", true);
                    break;
                }
                case 380: {
                    this.setSelection("RabbitStew", true);
                    break;
                }
                case 390: {
                    this.setSelection("GoldenMelon", true);
                    break;
                }
                case 400: {
                    this.setSelection("Melon", true);
                    break;
                }
                case 410: {
                    this.setSelection("HayBlock", true);
                    break;
                }
                case 420: {
                    this.setSelection("Bowl", true);
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
        
        this.craftBreadButton.displayString = this.getButtonDisplayString(this.craftBreadButton.displayString, "Bread", true);
        this.craftCakeButton.displayString = this.getButtonDisplayString(this.craftCakeButton.displayString, "Cake", true);
        this.craftCookieButton.displayString = this.getButtonDisplayString(this.craftCookieButton.displayString, "Cookie", true);
        this.craftGoldenAppleButton.displayString = this.getButtonDisplayString(this.craftGoldenAppleButton.displayString, "GoldenApple", true);
        this.craftOPGoldenAppleButton.displayString = this.getButtonDisplayString(this.craftOPGoldenAppleButton.displayString, "OPGoldenApple", true);
        this.craftGoldenCarrotButton.displayString = this.getButtonDisplayString(this.craftGoldenCarrotButton.displayString, "GoldenCarrot", true);
        this.craftPumpkinPieButton.displayString = this.getButtonDisplayString(this.craftPumpkinPieButton.displayString, "PumpkinPie", true);
        this.craftMushroomStewButton.displayString = this.getButtonDisplayString(this.craftMushroomStewButton.displayString, "MushroomStew", true);
        this.craftRabbitStewButton.displayString = this.getButtonDisplayString(this.craftRabbitStewButton.displayString, "RabbitStew", true);
        this.craftGoldenMelonButton.displayString = this.getButtonDisplayString(this.craftGoldenMelonButton.displayString, "GoldenMelon", true);
        this.craftMelonButton.displayString = this.getButtonDisplayString(this.craftMelonButton.displayString, "Melon", true);
        this.craftHayBlockButton.displayString = this.getButtonDisplayString(this.craftHayBlockButton.displayString, "HayBlock", true);
        this.craftBowlButton.displayString = this.getButtonDisplayString(this.craftBowlButton.displayString, "Bowl", true);
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
