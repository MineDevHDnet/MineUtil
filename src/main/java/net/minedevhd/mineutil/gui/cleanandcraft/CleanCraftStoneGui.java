package net.minedevhd.mineutil.gui.cleanandcraft;

import java.io.IOException;

import net.labymod.core.LabyModCore;
import net.labymod.utils.ModColor;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.init.Items;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.MineUtil.CCGui;
import net.minedevhd.mineutil.gui.changelog.ChangelogGui;
import net.minedevhd.mineutil.gui.storageprices.TEDLagerPreisGui;
import net.minedevhd.mineutil.settings.UtilCore;
import net.minedevhd.mineutil.utils.ModButton;
import net.minedevhd.mineutil.utils.ModButton.API;
import net.minedevhd.mineutil.utils.graf.RenderUtils;

public class CleanCraftStoneGui extends GuiScreen implements UtilCore {

    GuiButton cleanSpawnerButton,
    		  cleanChestInventoryButton,
    		  
    		  craftBrickBlockButton,
    		  craftPolishedAndesiteButton,
    		  craftPolishedDioriteButton,
    		  craftPolishedGraniteButton,
    		  craftStoneBrickButton,
    		  craftStoneBrickSlabButton,
    		  craftStoneBrickStairButton,
    		  craftChiseledStoneBrickButton,
    		  craftMossyCobbleStoneButton,
    		  craftMossyStoneBrickButton,
    		  
    		  pageNextButton,
    		  pagePrevButton,
    		  closeButton,
    		  closeCraftButton,
    		  deactivateButton,
    		  changeLogButton;
    
    public CleanCraftStoneGui() {
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
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
    	RenderUtils.renderNewGuiBackground();
    	mineUtil.getSettings().setCurrentGuiPage(2);
    	
    	this.drawCenteredString(this.fontRendererObj, "Cleaning and Crafting", this.width / 2, ModButton.API.getButtonYPos(0, true) + 5, ModButton.toRainbow(18));
        this.drawCenteredString(this.fontRendererObj, "- Page 2 of 13 -", this.width / 2, 18, 16777215);
        
        this.drawString(this.fontRendererObj, "Cleaning", ModButton.API.getButtonXPos(1, this.width) + 1, ModButton.API.getButtonYPos(1, true) + 8, 16777215);
        this.drawString(this.fontRendererObj, "Crafting - Stone", ModButton.API.getButtonXPos(1, this.width) + 1, ModButton.API.getButtonYPos(4, true) + 8, 16777215);
    	super.drawScreen(mouseX, mouseY, partialTicks);
    }
    
    @Override
    public void initGui() {
    	/** Cat. Cleaning */
    	this.buttonList.add(this.cleanSpawnerButton = new ModButton(200, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(2), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Spawner: OFF"));
    	this.buttonList.add(this.cleanChestInventoryButton = new ModButton(210, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(2), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ChestInventory: OFF"));
    	
    	/** Cat. Crafting */
    	this.buttonList.add(this.craftBrickBlockButton = new ModButton(300, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "BrickBlock: OFF"));
    	this.buttonList.add(this.craftPolishedAndesiteButton = new ModButton(310, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "PolishedAndesite: OFF"));
    	this.buttonList.add(this.craftPolishedDioriteButton = new ModButton(320, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "PolishedDiorite: OFF"));
    	this.buttonList.add(this.craftPolishedGraniteButton = new ModButton(330, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "PolishedGranite: OFF"));
    	this.buttonList.add(this.craftStoneBrickButton = new ModButton(340, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "StoneBrick: OFF"));
    	this.buttonList.add(this.craftStoneBrickSlabButton = new ModButton(350, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "StoneBrickSlab: OFF"));
    	this.buttonList.add(this.craftStoneBrickStairButton = new ModButton(360, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "StoneBrickStair: OFF"));
    	this.buttonList.add(this.craftChiseledStoneBrickButton = new ModButton(370, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ChiseledStoneBrick: OFF"));
    	this.buttonList.add(this.craftMossyCobbleStoneButton = new ModButton(380, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "MossyCobbleStone: OFF"));
    	this.buttonList.add(this.craftMossyStoneBrickButton = new ModButton(390, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "MossyStoneBrick: OFF"));
    	
    	/** Close, etc. */
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
    protected void actionPerformed(GuiButton button) throws IOException {
    	try {
            boolean doAction = true;
            switch(button.id) {
	            case 100: {
	            	doAction = false;
	                this.mc.displayGuiScreen(new CleanCraftOreGui());
	                break;
	            }
	            case 110: {
	            	doAction = false;
	                this.mc.displayGuiScreen(new CleanCraftSandGui());
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
                    this.setSelection("BrickBlock", true);
                    break;
                }
                case 310: {
                    this.setSelection("PolishedAndesite", true);
                	break;
                }
                case 320: {
                    this.setSelection("PolishedDiorite", true);
                    break;
                }
                case 330: {
                    this.setSelection("PolishedGranite", true);
                    break;
                }
                case 340: {
                    this.setSelection("StoneBrick", true);
                    break;
                }
                case 350: {
                    this.setSelection("StoneBrickSlab", true);
                    break;
                }
                case 360: {
                    this.setSelection("StoneBrickStair", true);
                    break;
                }
                case 370: {
                    this.setSelection("ChiseledStoneBrick", true);
                    break;
                }
                case 380: {
                    this.setSelection("MossyCobbleStone", true);
                    break;
                }
                case 390: {
                    this.setSelection("MossyStoneBrick", true);
                    break;
                }
            }
            if(doAction) {
                this.updateButtons();
                super.actionPerformed(button);
            }
        } catch(Exception exception) {}
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
//    	this.changeLogButton.enabled = true;
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

        this.craftBrickBlockButton.displayString = this.getButtonDisplayString(this.craftBrickBlockButton.displayString, "BrickBlock", true);
        this.craftPolishedAndesiteButton.displayString = this.getButtonDisplayString(this.craftPolishedAndesiteButton.displayString, "PolishedAndesite", true);
        this.craftPolishedDioriteButton.displayString = this.getButtonDisplayString(this.craftPolishedDioriteButton.displayString, "PolishedDiorite", true);
        this.craftPolishedGraniteButton.displayString = this.getButtonDisplayString(this.craftPolishedGraniteButton.displayString, "PolishedGranite", true);
        this.craftStoneBrickButton.displayString = this.getButtonDisplayString(this.craftStoneBrickButton.displayString, "StoneBrick", true);
        this.craftStoneBrickSlabButton.displayString = this.getButtonDisplayString(this.craftStoneBrickSlabButton.displayString, "StoneBrickSlab", true);
        this.craftStoneBrickStairButton.displayString = this.getButtonDisplayString(this.craftStoneBrickStairButton.displayString, "StoneBrickStair", true);
        this.craftChiseledStoneBrickButton.displayString = this.getButtonDisplayString(this.craftChiseledStoneBrickButton.displayString, "ChiseledStoneBrick", true);
        this.craftMossyCobbleStoneButton.displayString = this.getButtonDisplayString(this.craftMossyCobbleStoneButton.displayString, "MossyCobbleStone", true);
        this.craftMossyStoneBrickButton.displayString = this.getButtonDisplayString(this.craftMossyStoneBrickButton.displayString, "MossyStoneBrick", true);
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
