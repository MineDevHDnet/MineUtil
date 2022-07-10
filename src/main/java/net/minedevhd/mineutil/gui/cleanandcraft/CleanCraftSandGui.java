package net.minedevhd.mineutil.gui.cleanandcraft;

import java.io.IOException;

import net.labymod.core.LabyModCore;
import net.labymod.utils.ModColor;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.init.Items;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.MineUtil.CGui;
import net.minedevhd.mineutil.gui.changelog.ChangelogGui;
import net.minedevhd.mineutil.gui.storageprices.TEDLagerPreisGui;
import net.minedevhd.mineutil.utils.ModButton;
import net.minedevhd.mineutil.utils.ModButton.API;
import net.minedevhd.mineutil.utils.RenderUtils;

public class CleanCraftSandGui extends GuiScreen {

    GuiButton cleanSpawnerButton,
    		  cleanChestInventoryButton,
    		  
    		  craftSandstoneButton,
    		  craftSandstoneSlabButton,
    		  craftSandstoneStairButton,
    		  craftSmoothSandstoneButton,
    		  craftChiseledSandstoneButton,
    		  craftRedSandstoneButton,
    		  craftRedSandstoneSlabButton,
    		  craftRedSandstoneStairButton,
    		  craftSmoothRedSandstoneButton,
    		  craftChiseledRedSandstoneButton,
    		  
    		  pageNextButton,
    		  pagePrevButton,
    		  closeButton,
    		  closeCraftButton,
    		  deactivateButton,
    		  changeLogButton,
    		  lagerPreisButton;
    
    public CleanCraftSandGui() {
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
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
    	RenderUtils.renderNewGuiBackground();
    	MineUtil.getUtilCore().getSettings().setCurrentGuiPage(3);
    	
    	this.drawCenteredString(this.fontRendererObj, "Cleaning and Crafting", this.width / 2, ModButton.API.getButtonYPos(0, true) + 5, ModButton.toRainbow(18));
        this.drawCenteredString(this.fontRendererObj, "- Page 3 of 8 -", this.width / 2, 18, 16777215);
        
        this.drawString(this.fontRendererObj, "Cleaning", ModButton.API.getButtonXPos(1, this.width) + 1, ModButton.API.getButtonYPos(1, true) + 8, 16777215);
        this.drawString(this.fontRendererObj, "Crafting - Sand", ModButton.API.getButtonXPos(1, this.width) + 1, ModButton.API.getButtonYPos(4, true) + 8, 16777215);
    	super.drawScreen(mouseX, mouseY, partialTicks);
    }
    
    @Override
    public void initGui() {
    	/** Cat. Cleaning */
    	this.buttonList.add(this.cleanSpawnerButton = new ModButton(200, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(2), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Spawner: OFF"));
    	this.buttonList.add(this.cleanChestInventoryButton = new ModButton(210, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(2), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ChestInventory: OFF"));
    	
    	/** Cat. Crafting */
    	this.buttonList.add(this.craftSandstoneButton = new ModButton(300, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Sandstone: OFF"));
    	this.buttonList.add(this.craftSandstoneSlabButton = new ModButton(310, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "SandstoneSlab: OFF"));
    	this.buttonList.add(this.craftSandstoneStairButton = new ModButton(320, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "§mSandstoneStair§r: OFF"));
    	this.buttonList.add(this.craftSmoothSandstoneButton = new ModButton(330, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "SmoothSandstone: OFF"));

    	this.buttonList.add(this.craftChiseledSandstoneButton = new ModButton(340, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ChiseledSandstone: OFF"));
    	this.buttonList.add(this.craftRedSandstoneButton = new ModButton(350, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "RedSandstone: OFF"));
    	this.buttonList.add(this.craftRedSandstoneSlabButton = new ModButton(360, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "RedSandstoneSlab: OFF"));
    	this.buttonList.add(this.craftRedSandstoneStairButton = new ModButton(370, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "§mRedSandstoneStair: OFF"));

    	this.buttonList.add(this.craftSmoothRedSandstoneButton = new ModButton(380, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "SmoothRedSandstone: OFF"));
    	this.buttonList.add(this.craftChiseledRedSandstoneButton = new ModButton(390, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ChiseledRedSandstone: OFF"));
    	
    	/** Close, etc. */
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
    protected void actionPerformed(GuiButton button) throws IOException {
    	try {
            boolean doAction = true;
            switch(button.id) {
	            case 100: {
	            	doAction = false;
	                this.mc.displayGuiScreen(new CleanCraftStoneGui());
	                break;
	            }
	            case 110: {
	            	doAction = false;
	                this.mc.displayGuiScreen(new CleanCraftRedstoneGui());
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
                    this.setSelection("Sandstone", true);
                    break;
                }
                case 310: {
                    this.setSelection("SandstoneSlab", true);
                	break;
                }
//                case 320: {
//                    this.setSelection("SandstoneStair", true);
//                    break;
//                }
                case 330: {
                    this.setSelection("SmoothSandstone", true);
                    break;
                }
                case 340: {
                    this.setSelection("ChiseledSandstone", true);
                    break;
                }
                case 350: {
                    this.setSelection("RedSandstone", true);
                    break;
                }
                case 360: {
                    this.setSelection("RedSandstoneSlab", true);
                    break;
                }
//                case 370: {
//                    this.setSelection("RedSandstoneStair", true);
//                    break;
//                }
                case 380: {
                    this.setSelection("SmoothRedSandstone", true);
                    break;
                }
                case 390: {
                    this.setSelection("ChiseledRedSandstone", true);
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
//    	this.changeLogButton.enabled = true;
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

        this.craftSandstoneButton.displayString = this.getButtonDisplayString(this.craftSandstoneButton.displayString, "Sandstone", true);
        this.craftSandstoneSlabButton.displayString = this.getButtonDisplayString(this.craftSandstoneSlabButton.displayString, "SandstoneSlab", true);
        this.craftSandstoneStairButton.displayString = this.getButtonDisplayString(this.craftSandstoneStairButton.displayString, "SandstoneStair", true);
        this.craftSmoothSandstoneButton.displayString = this.getButtonDisplayString(this.craftSmoothSandstoneButton.displayString, "SmoothSandstone", true);
        this.craftChiseledSandstoneButton.displayString = this.getButtonDisplayString(this.craftChiseledSandstoneButton.displayString, "ChiseledSandstone", true);
        this.craftRedSandstoneButton.displayString = this.getButtonDisplayString(this.craftRedSandstoneButton.displayString, "RedSandstone", true);
        this.craftRedSandstoneSlabButton.displayString = this.getButtonDisplayString(this.craftRedSandstoneSlabButton.displayString, "RedSandstoneSlab", true);
        this.craftRedSandstoneStairButton.displayString = this.getButtonDisplayString(this.craftRedSandstoneStairButton.displayString, "RedSandstoneStair", true);
        this.craftSmoothRedSandstoneButton.displayString = this.getButtonDisplayString(this.craftSmoothRedSandstoneButton.displayString, "SmoothRedSandstone", true);
        this.craftChiseledRedSandstoneButton.displayString = this.getButtonDisplayString(this.craftChiseledRedSandstoneButton.displayString, "ChiseledRedSandstone", true);
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
