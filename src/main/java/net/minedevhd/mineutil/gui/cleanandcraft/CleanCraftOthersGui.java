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

public class CleanCraftOthersGui extends GuiScreen {
	
	GuiButton cleanSpawnerButton,
			  cleanChestInventoryButton,
			  
			  craftBucketButton,
			  craftItemFrameButton,
			  craftArmorStandButton,
			  craftBookShelfButton,
			  craftBrewingStandButton,
			  craftTNTButton,
			  craftFurnanceButton,
			  craftWoodButton,
			  craftChestButton,
			  craftEnderchestButton,
			  craftCauldronButton,
			  craftBeaconButton,
			  craftEnchantingTableButton,
			  craftCraftingTableButton,
			  craftAnvilButton,
			  
			  pageNextButton,
			  pagePrevButton,
			  closeButton,
			  closeCraftButton,
			  deactivateButton,
			  changeLogButton;
	
	public CleanCraftOthersGui() {
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
    	MineUtil.getUtilCore().getSettings().setCurrentGuiPage(7);
    	this.drawCenteredString(this.fontRendererObj, "Cleaning and Crafting", this.width / 2, ModButton.API.getButtonYPos(0, true) + 5, ModButton.toRainbow(18));
        this.drawCenteredString(this.fontRendererObj, "- Page 7 of 13 -", this.width / 2, 18, 16777215);
        this.drawString(this.fontRendererObj, "Cleaning", ModButton.API.getButtonXPos(1, this.width) + 1, ModButton.API.getButtonYPos(1, true) + 8, 16777215);
        this.drawString(this.fontRendererObj, "Crafting - Others (1)", ModButton.API.getButtonXPos(1, this.width) + 1, ModButton.API.getButtonYPos(4, true) + 8, 16777215);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
	
	@Override
	public void initGui() {
		this.buttonList.add(this.cleanSpawnerButton = new ModButton(200, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(2), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Spawner: OFF"));
    	this.buttonList.add(this.cleanChestInventoryButton = new ModButton(210, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(2), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ChestInventory: OFF"));
    	
    	this.buttonList.add(this.craftBucketButton = new ModButton(300, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Bucket: OFF"));
        this.buttonList.add(this.craftItemFrameButton = new ModButton(310, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ItemFrame: OFF"));
        this.buttonList.add(this.craftArmorStandButton = new ModButton(320, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ArmorStand: OFF"));
        this.buttonList.add(this.craftBookShelfButton = new ModButton(330, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "BookShelf: OFF"));
        this.buttonList.add(this.craftBrewingStandButton = new ModButton(340, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "BrewingStand: OFF"));
        this.buttonList.add(this.craftTNTButton = new ModButton(350, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "TNT: OFF"));
        this.buttonList.add(this.craftFurnanceButton = new ModButton(360, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Furnace: OFF"));
        this.buttonList.add(this.craftWoodButton = new ModButton(370, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Wood: OFF"));
        
        this.buttonList.add(this.craftChestButton = new ModButton(380, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Chest: OFF"));
        this.buttonList.add(this.craftEnderchestButton = new ModButton(390, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Enderchest: OFF"));
        this.buttonList.add(this.craftCauldronButton = new ModButton(400, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Cauldron: OFF"));
        this.buttonList.add(this.craftBeaconButton = new ModButton(410, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Beacon: OFF"));
        this.buttonList.add(this.craftEnchantingTableButton = new ModButton(420, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "EnchantingTable: OFF"));
        this.buttonList.add(this.craftCraftingTableButton = new ModButton(430, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "CraftingTable: OFF"));
        this.buttonList.add(this.craftAnvilButton = new ModButton(440, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Anvil: OFF"));
        
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
                this.mc.displayGuiScreen(new CleanCraftPrismarineGui());
                break;
            }
            case 110: {
            	doAction = false;
                this.mc.displayGuiScreen(new CleanCraftOthers2Gui());
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
            	this.setSelection("Bucket", true);
            	break;
            }
            case 310: {
            	this.setSelection("ItemFrame", true);
            	break;
            }
            case 320: {
            	this.setSelection("ArmorStand", true);
            	break;
            }
            case 330: {
            	this.setSelection("BookShelf", true);
            	break;
            }
            case 340: {
            	this.setSelection("BrewingStand", true);
            	break;
            }
            case 350: {
            	this.setSelection("TNT", true);
            	break;
            }
            case 360: {
            	this.setSelection("Furnace", true);
            	break;
            }
            case 370: {
            	this.setSelection("Wood", true);
            	break;
            }
            case 380: {
            	this.setSelection("Chest", true);
            	break;
            }
            case 390: {
            	this.setSelection("Enderchest", true);
            	break;
            }
            case 400: {
            	this.setSelection("Cauldron", true);
            	break;
            }
            case 410: {
            	this.setSelection("Beacon", true);
            	break;
            }
            case 420: {
            	this.setSelection("EnchantingTable", true);
            	break;
            }
            case 430: {
            	this.setSelection("CraftingTable", true);
            	break;
            }
            case 440: {
            	this.setSelection("Anvil", true);
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
        
        this.craftBucketButton.displayString = this.getButtonDisplayString(this.craftBucketButton.displayString, "bucket", true);
        this.craftItemFrameButton.displayString = this.getButtonDisplayString(this.craftItemFrameButton.displayString, "itemframe", true);
        this.craftArmorStandButton.displayString = this.getButtonDisplayString(this.craftArmorStandButton.displayString, "armorstand", true);
        this.craftBookShelfButton.displayString = this.getButtonDisplayString(this.craftBookShelfButton.displayString, "bookshelf", true);
        this.craftBrewingStandButton.displayString = this.getButtonDisplayString(this.craftBrewingStandButton.displayString, "brewingstand", true);
        this.craftTNTButton.displayString = this.getButtonDisplayString(this.craftTNTButton.displayString, "tnt", true);
        this.craftFurnanceButton.displayString = this.getButtonDisplayString(this.craftFurnanceButton.displayString, "furnace", true);
        this.craftWoodButton.displayString = this.getButtonDisplayString(this.craftWoodButton.displayString, "wood", true);
        this.craftChestButton.displayString = this.getButtonDisplayString(this.craftChestButton.displayString, "chest", true);
        this.craftEnderchestButton.displayString = this.getButtonDisplayString(this.craftEnderchestButton.displayString, "enderchest", true);
        this.craftCauldronButton.displayString = this.getButtonDisplayString(this.craftCauldronButton.displayString, "cauldron", true);
        this.craftBeaconButton.displayString = this.getButtonDisplayString(this.craftBeaconButton.displayString, "beacon", true);
        this.craftEnchantingTableButton.displayString = this.getButtonDisplayString(this.craftEnchantingTableButton.displayString, "enchantingtable", true);
        this.craftCraftingTableButton.displayString = this.getButtonDisplayString(this.craftCraftingTableButton.displayString, "craftingtable", true);
        this.craftAnvilButton.displayString = this.getButtonDisplayString(this.craftAnvilButton.displayString, "anvil", true);
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
