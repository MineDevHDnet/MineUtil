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
import net.minedevhd.mineutil.MineUtil.CGui;
import net.minedevhd.mineutil.gui.changelog.ChangelogGui;
import net.minedevhd.mineutil.gui.storageprices.TEDLagerPreisGui;
import net.minedevhd.mineutil.helper.StealHelper;
import net.minedevhd.mineutil.utils.ModButton;
import net.minedevhd.mineutil.utils.ModButton.API;
import net.minedevhd.mineutil.utils.RenderUtils;

public class CleanCraftOreGui extends GuiScreen {
	
    GuiButton cleanSpawnerButton,
    		  cleanChestInventoryButton,
    		  
    		  craftCoalBlockButton,
    		  craftLapisBlockButton,
    		  craftRedstoneBlockButton,
    		  craftIronBlockButton,
    		  craftGoldIngotButton,
    		  craftGoldBlockButton,
    		  craftDiamondBlockButton,
    		  craftEmeraldBlockButton,
    		  
    		  craftCoalButton,
    		  craftLapisButton,
    		  craftRedstoneButton,
    		  craftIronButton,
    		  craftGoldNuggetButton,
    		  craftGoldButton,
    		  craftDiamondButton,
    		  craftEmeraldButton,
	  
			  pageNextButton,
			  pagePrevButton,
			  closeButton,
			  closeCraftButton,
			  deactivateButton,
			  changeLogButton,
			  lagerPreisButton;
    
    public CleanCraftOreGui() {
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
    */
    }
    
    @Override
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
    	RenderUtils.renderNewGuiBackground();
    	MineUtil.getUtilCore().getSettings().setCurrentGuiPage(1);
    	this.drawCenteredString(this.fontRendererObj, "Cleaning and Crafting", this.width / 2, ModButton.API.getButtonYPos(0, true) + 5, ModButton.toRainbow(18));
        this.drawCenteredString(this.fontRendererObj, "- Page 1 of 8 -", this.width / 2, 18, 16777215);
        this.drawString(this.fontRendererObj, "Cleaning", ModButton.API.getButtonXPos(1, this.width) + 1, ModButton.API.getButtonYPos(1, true) + 8, 16777215);
        this.drawString(this.fontRendererObj, "Crafting - Ore", ModButton.API.getButtonXPos(1, this.width) + 1, ModButton.API.getButtonYPos(4, true) + 8, 16777215);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
    
    @Override
    public void initGui() {
    	this.buttonList.add(this.cleanSpawnerButton = new ModButton(200, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(2), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Spawner: OFF"));
    	this.buttonList.add(this.cleanChestInventoryButton = new ModButton(210, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(2), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Chest-Inventory: OFF"));
        
    	this.buttonList.add(this.craftCoalBlockButton = new ModButton(300, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "CoalBlock: OFF"));
        this.buttonList.add(this.craftLapisBlockButton = new ModButton(310, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "LapisBlock: OFF"));
        this.buttonList.add(this.craftRedstoneBlockButton = new ModButton(320, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "RedstoneBlock: OFF"));
        this.buttonList.add(this.craftIronBlockButton = new ModButton(330, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "IronBlock: OFF"));
        this.buttonList.add(this.craftGoldIngotButton = new ModButton(340, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "GoldIngot: OFF"));
        this.buttonList.add(this.craftGoldBlockButton = new ModButton(350, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "GoldBlock: OFF"));
        this.buttonList.add(this.craftDiamondBlockButton = new ModButton(360, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "DiamondBlock: OFF"));
        this.buttonList.add(this.craftEmeraldBlockButton = new ModButton(370, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "EmeraldBlock: OFF"));
        
        this.buttonList.add(this.craftCoalButton = new ModButton(380, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Coal: OFF"));
        this.buttonList.add(this.craftLapisButton = new ModButton(390, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Lapis: OFF"));
        this.buttonList.add(this.craftRedstoneButton = new ModButton(400, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Redstone: OFF"));
        this.buttonList.add(this.craftIronButton = new ModButton(410, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Iron: OFF"));
        this.buttonList.add(this.craftGoldNuggetButton = new ModButton(420, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "GoldNugget: OFF"));
        this.buttonList.add(this.craftGoldButton = new ModButton(430, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Gold: OFF"));
        this.buttonList.add(this.craftDiamondButton = new ModButton(440, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Diamond: OFF"));
        this.buttonList.add(this.craftEmeraldButton = new ModButton(450, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Emerald: OFF"));
        
        this.buttonList.add(this.pagePrevButton = new ModButton(100, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(9), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "<< BACK"));
        this.buttonList.add(this.pageNextButton = new ModButton(110, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(9), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "FORWARD >>"));
        this.buttonList.add(this.closeCraftButton = new ModButton(120, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(11), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "CLOSE and CRAFT"));
        this.buttonList.add(this.deactivateButton = new ModButton(130, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(12), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "DISABLE"));
        this.buttonList.add(this.closeButton = new ModButton(140, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(12), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "CLOSE"));
        
//        this.buttonList.add(this.changeLogButton = new ModButton(150, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(12), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), ModColor.GOLD.toString() + "Changelog"));
        this.buttonList.add(this.lagerPreisButton = new ModButton(160, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(12), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(),  ModColor.AQUA.toString() + "Lager Preise"));
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
	                this.mc.displayGuiScreen(new CleanCraftStoneGui());
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
                    this.setSelection("Coalblock", true);
                    break;
                }
                case 310: {
                    this.setSelection("Lapisblock", true);
                    break;
                }
                case 320: {
                    this.setSelection("Redstoneblock", true);
                    break;
                }
                case 330: {
                    this.setSelection("Ironblock", true);
                    break;
                }
                case 340: {
                    this.setSelection("Goldingot", true);
                    break;
                }
                case 350: {
                    this.setSelection("Goldblock", true);
                    break;
                }
                case 360: {
                    this.setSelection("Diamondblock", true);
                    break;
                }
                case 370: {
                    this.setSelection("Emeraldblock", true);
                    break;
                }
	            /** Cat. Crafting */
                case 380: {
                    this.setSelection("Coal", true);
                    break;
                }
                case 390: {
                    this.setSelection("Lapis", true);
                    break;
                }
                case 400: {
                    this.setSelection("Redstone", true);
                    break;
                }
                case 410: {
                    this.setSelection("Iron", true);
                    break;
                }
                case 420: {
                    this.setSelection("GoldNugget", true);
                    break;
                }
                case 430: {
                    this.setSelection("Gold", true);
                    break;
                }
                case 440: {
                    this.setSelection("Diamond", true);
                    break;
                }
                case 450: {
                    this.setSelection("Emerald", true);
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
        
        this.craftCoalBlockButton.displayString = this.getButtonDisplayString(this.craftCoalBlockButton.displayString, "coalblock", true);
        this.craftLapisBlockButton.displayString = this.getButtonDisplayString(this.craftLapisBlockButton.displayString, "lapisblock", true);
        this.craftRedstoneBlockButton.displayString = this.getButtonDisplayString(this.craftRedstoneBlockButton.displayString, "redstoneblock", true);
        this.craftIronBlockButton.displayString = this.getButtonDisplayString(this.craftIronBlockButton.displayString, "ironblock", true);
        this.craftGoldIngotButton.displayString = this.getButtonDisplayString(this.craftGoldIngotButton.displayString, "goldingot", true);
        this.craftGoldBlockButton.displayString = this.getButtonDisplayString(this.craftGoldBlockButton.displayString, "goldblock", true);
        this.craftDiamondBlockButton.displayString = this.getButtonDisplayString(this.craftDiamondBlockButton.displayString, "diamondblock", true);
        this.craftEmeraldBlockButton.displayString = this.getButtonDisplayString(this.craftEmeraldBlockButton.displayString, "emeraldblock", true);

        this.craftCoalButton.displayString = this.getButtonDisplayString(this.craftCoalButton.displayString, "coal", true);
        this.craftLapisButton.displayString = this.getButtonDisplayString(this.craftLapisButton.displayString, "lapis", true);
        this.craftRedstoneButton.displayString = this.getButtonDisplayString(this.craftRedstoneButton.displayString, "redstone", true);
        this.craftIronButton.displayString = this.getButtonDisplayString(this.craftIronButton.displayString, "iron", true);
        this.craftGoldNuggetButton.displayString = this.getButtonDisplayString(this.craftGoldNuggetButton.displayString, "goldnugget", true);
        this.craftGoldButton.displayString = this.getButtonDisplayString(this.craftGoldButton.displayString, "gold", true);
        this.craftDiamondButton.displayString = this.getButtonDisplayString(this.craftDiamondButton.displayString, "diamond", true);
        this.craftEmeraldButton.displayString = this.getButtonDisplayString(this.craftEmeraldButton.displayString, "emerald", true);
    }
    
    @Override
    public void onGuiClosed() {
        CGui.setGUIOpend(false);
        CGui.setGUIToggled(false);
        super.onGuiClosed();
    }
    
    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
    
}
