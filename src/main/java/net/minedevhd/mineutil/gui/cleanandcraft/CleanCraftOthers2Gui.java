package net.minedevhd.mineutil.gui.cleanandcraft;

import java.io.IOException;

import net.labymod.core.LabyModCore;
import net.labymod.utils.ModColor;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.MineUtil.CCGui;
import net.minedevhd.mineutil.gui.changelog.ChangelogGui;
import net.minedevhd.mineutil.gui.storageprices.TEDLagerPreisGui;
import net.minedevhd.mineutil.utils.ModButton;
import net.minedevhd.mineutil.utils.RenderUtils;

public class CleanCraftOthers2Gui extends GuiScreen {
	
	GuiButton cleanSpawnerButton,
			  cleanChestInventoryButton,
			  
			  craftShearsButton,
			  craftTorchButton,
			  craftPaperButton,
			  craftStickButton,
			  craftBowButton,
			  craftBookButton,
			  craftEyeOfEnderButton,
			  craftBlazePowderButton,
			  craftFlowerPotButton,
			  craftSlimeBlockButton,
			  craftHayBlockButton,
			  
			  pageNextButton,
			  pagePrevButton,
			  closeButton,
			  closeCraftButton,
			  deactivateButton,
			  changeLogButton;
	
	public CleanCraftOthers2Gui() {
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
    	MineUtil.getUtilCore().getSettings().setCurrentGuiPage(8);
    	this.drawCenteredString(this.fontRendererObj, "Cleaning and Crafting", this.width / 2, ModButton.API.getButtonYPos(0, true) + 5, ModButton.toRainbow(18));
        this.drawCenteredString(this.fontRendererObj, "- Page 8 of 13 -", this.width / 2, 18, 16777215);
        this.drawString(this.fontRendererObj, "Cleaning", ModButton.API.getButtonXPos(1, this.width) + 1, ModButton.API.getButtonYPos(1, true) + 8, 16777215);
        this.drawString(this.fontRendererObj, "Crafting - Others (2)", ModButton.API.getButtonXPos(1, this.width) + 1, ModButton.API.getButtonYPos(4, true) + 8, 16777215);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
	
	@Override
	public void initGui() {
		this.buttonList.add(this.cleanSpawnerButton = new ModButton(200, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(2), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Spawner: OFF"));
    	this.buttonList.add(this.cleanChestInventoryButton = new ModButton(210, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(2), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ChestInventory: OFF"));
    	
    	this.buttonList.add(this.craftShearsButton = new ModButton(300, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Shears: OFF"));
        this.buttonList.add(this.craftTorchButton = new ModButton(310, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Torch: OFF"));
        this.buttonList.add(this.craftPaperButton = new ModButton(320, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Paper: OFF"));
        this.buttonList.add(this.craftStickButton = new ModButton(330, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Stick: OFF"));
        this.buttonList.add(this.craftBowButton = new ModButton(340, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Bow: OFF"));
        this.buttonList.add(this.craftBookButton = new ModButton(350, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Book: OFF"));
        this.buttonList.add(this.craftEyeOfEnderButton = new ModButton(360, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "EyeOfEnder: OFF"));
        this.buttonList.add(this.craftBlazePowderButton = new ModButton(370, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "BlazePowder: OFF"));
        
        this.buttonList.add(this.craftFlowerPotButton = new ModButton(380, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "FlowerPot: OFF"));
        this.buttonList.add(this.craftSlimeBlockButton = new ModButton(390, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "SlimeBlock: OFF"));
        this.buttonList.add(this.craftHayBlockButton = new ModButton(400, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "HayBlock: OFF"));
        
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
			switch (button.id) {
			case 100: {
            	doAction = false;
                this.mc.displayGuiScreen(new CleanCraftOthersGui());
                break;
            }
            case 110: {
            	doAction = false;
                this.mc.displayGuiScreen(new CleanCraftWoolGui());
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
            	this.setSelection("Shears", true);
            	break;
            }
            case 310: {
            	this.setSelection("Torch", true);
            	break;
            }
            case 320: {
            	this.setSelection("Paper", true);
            	break;
            }
            case 330: {
            	this.setSelection("Stick", true);
            	break;
            }
            case 340: {
            	this.setSelection("Bow", true);
            	break;
            }
            case 350: {
            	this.setSelection("Book", true);
            	break;
            }
            case 360: {
            	this.setSelection("EyeOfEnder", true);
            	break;
            }
            case 370: {
            	this.setSelection("BlazePowder", true);
            	break;
            }
            case 380: {
            	this.setSelection("FlowerPot", true);
            	break;
            }
            case 390: {
            	this.setSelection("SlimeBlock", true);
            	break;
            }
            case 400: {
            	this.setSelection("HayBlock", true);
            	break;
            }
			default:
				break;
			}
            if(doAction) {
                this.updateButtons();
                super.actionPerformed(button);
            }
        }
        catch (Exception exception) {}
		super.actionPerformed(button);
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
        
        this.craftShearsButton.displayString = this.getButtonDisplayString(this.craftShearsButton.displayString, "Shears", true);
        this.craftTorchButton.displayString = this.getButtonDisplayString(this.craftTorchButton.displayString, "Torch", true);
        this.craftPaperButton.displayString = this.getButtonDisplayString(this.craftPaperButton.displayString, "Paper", true);
        this.craftStickButton.displayString = this.getButtonDisplayString(this.craftStickButton.displayString, "Stick", true);
        this.craftBowButton.displayString = this.getButtonDisplayString(this.craftBowButton.displayString, "Bow", true);
        this.craftBookButton.displayString = this.getButtonDisplayString(this.craftBookButton.displayString, "Book", true);
        this.craftEyeOfEnderButton.displayString = this.getButtonDisplayString(this.craftEyeOfEnderButton.displayString, "EyeOfEnder", true);
        this.craftBlazePowderButton.displayString = this.getButtonDisplayString(this.craftBlazePowderButton.displayString, "BlazePowder", true);
        this.craftFlowerPotButton.displayString = this.getButtonDisplayString(this.craftFlowerPotButton.displayString, "FlowerPot", true);
        this.craftSlimeBlockButton.displayString = this.getButtonDisplayString(this.craftSlimeBlockButton.displayString, "SlimeBlock", true);
        this.craftHayBlockButton.displayString = this.getButtonDisplayString(this.craftHayBlockButton.displayString, "HayBlock", true);
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
