package net.minedevhd.mineutil.gui.cleanandcraft.ausrangiert;

import java.io.IOException;
import java.net.URI;

import net.labymod.core.LabyModCore;
import net.labymod.utils.ModColor;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.MineUtil.CGui;
import net.minedevhd.mineutil.gui.changelog.ChangelogGui;
import net.minedevhd.mineutil.gui.storageprices.TEDLagerPreisGui;
import net.minedevhd.mineutil.utils.ModButton;
import net.minedevhd.mineutil.utils.ModButton.API;
import net.minedevhd.mineutil.utils.RenderUtils;

public class CleanCraftGui5 extends GuiScreen
{
    GuiButton cleanSpawnerButton;
    GuiButton craftBucketButton;
    GuiButton craftBeaconButton;
    GuiButton craftAnvilButton;
    GuiButton craftBowButton;
    GuiButton craftNetherBrickButton;
    GuiButton craftEnchantingTableButton;
    GuiButton craftCraftingTableButton;
    GuiButton craftTNTButton;
    GuiButton craftBrewingStandButton;
    GuiButton craftShearsButton;
    GuiButton craftEyeOfEnderButton;
    GuiButton craftBlazePowderButton;
    GuiButton craftClockButton;
    GuiButton craftArmorStand;
    GuiButton cleanChestInventoryButton;
    
    GuiButton pageNextButton;
    GuiButton pagePrevButton;
    GuiButton closeButton;
    GuiButton closeCraftButton;
    GuiButton deactivateButton;
    GuiButton changeLogButton;
    
    public CleanCraftGui5() {}
    
    @Override
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
    	RenderUtils.renderNewGuiBackground();
    	MineUtil.getUtilCore().getSettings().setCurrentGuiPage(5);
        this.drawCenteredString(this.fontRendererObj, "Cleaning and Crafting", this.width / 2, ModButton.API.getButtonYPos(0, true) + 5, ModButton.toRainbow(18));
        this.drawCenteredString(this.fontRendererObj, "- Page 5 of 10 -", this.width / 2, 18, 16777215);
        this.drawString(this.fontRendererObj, "Cleaning", ModButton.API.getButtonXPos(1, this.width) + 1, ModButton.API.getButtonYPos(1, true) + 8, 16777215);
        this.drawString(this.fontRendererObj, "Crafting", ModButton.API.getButtonXPos(1, this.width) + 1, ModButton.API.getButtonYPos(4, true) + 8, 16777215);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
    
    public void initGui() {
        this.buttonList.add(this.cleanSpawnerButton = new ModButton(271, ModButton.API.getButtonXPos(1,this.width), ModButton.API.getButtonYPos(2), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Spawner: OFF"));
        this.buttonList.add(this.cleanChestInventoryButton = new ModButton(222, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(2), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Chest-Inventory: OFF"));
        
        this.buttonList.add(this.craftBucketButton = new ModButton(300, ModButton.API.getButtonXPos(1,this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Bucket: OFF"));
        this.buttonList.add(this.craftBeaconButton = new ModButton(310, ModButton.API.getButtonXPos(2,this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Beacon: OFF"));
        this.buttonList.add(this.craftAnvilButton = new ModButton(320, ModButton.API.getButtonXPos(3,this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Anvil: OFF"));
        this.buttonList.add(this.craftBowButton = new ModButton(330, ModButton.API.getButtonXPos(4,this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Bow: OFF"));
        this.buttonList.add(this.craftNetherBrickButton = new ModButton(340, ModButton.API.getButtonXPos(1,this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "NetherBrick: OFF"));
        this.buttonList.add(this.craftEyeOfEnderButton = new ModButton(430, ModButton.API.getButtonXPos(2,this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "EyeOfEnder: OFF"));
        this.buttonList.add(this.craftEnchantingTableButton = new ModButton(350, ModButton.API.getButtonXPos(3,this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "EnchantingTable: OFF"));
        this.buttonList.add(this.craftCraftingTableButton = new ModButton(360, ModButton.API.getButtonXPos(4,this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "CraftingTable: OFF"));
        this.buttonList.add(this.craftTNTButton = new ModButton(370, ModButton.API.getButtonXPos(1,this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "TNT: OFF"));
        this.buttonList.add(this.craftBrewingStandButton = new ModButton(410, ModButton.API.getButtonXPos(2,this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "BrewingStand: OFF"));
        this.buttonList.add(this.craftShearsButton = new ModButton(420, ModButton.API.getButtonXPos(3,this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Shears: OFF"));
        this.buttonList.add(this.craftBlazePowderButton = new ModButton(440, ModButton.API.getButtonXPos(4,this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "BlazePowder: OFF"));
        this.buttonList.add(this.craftClockButton = new ModButton(450, ModButton.API.getButtonXPos(1,this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Clock: OFF"));
        this.buttonList.add(this.craftArmorStand = new ModButton(460, ModButton.API.getButtonXPos(2,this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ArmorStand: OFF"));
        
        this.buttonList.add(this.pagePrevButton = new ModButton(160, ModButton.API.getButtonXPos(1,this.width), ModButton.API.getButtonYPos(9), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "<< BACK"));
        this.buttonList.add(this.pageNextButton = new ModButton(150, ModButton.API.getButtonXPos(4,this.width), ModButton.API.getButtonYPos(9), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "FORWARD >>"));
        this.buttonList.add(this.deactivateButton = new ModButton(120, ModButton.API.getButtonXPos(2,this.width), ModButton.API.getButtonYPos(12), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "DISABLE"));
        this.buttonList.add(this.closeButton = new ModButton(110, ModButton.API.getButtonXPos(3,this.width), ModButton.API.getButtonYPos(12), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "CLOSE"));
        this.buttonList.add(this.closeCraftButton = new ModButton(90, ModButton.API.getButtonXPos(3,this.width), ModButton.API.getButtonYPos(11), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "CLOSE and CRAFT"));
        
        this.buttonList.add(new ModButton(500, ModButton.API.getButtonXPos(4,this.width), ModButton.API.getButtonYPos(12), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), ModColor.AQUA.toString() + "Lager Preise"));
        this.buttonList.add(this.changeLogButton = new ModButton(501, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(12), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), ModColor.GOLD.toString() + "Changelog"));
        this.updateButtons();
        super.initGui();
    }
    
    @Override
    protected void actionPerformed(final GuiButton button) throws IOException {
        try {
            boolean doAction = true;
            switch (button.id) {
	            case 90: {
	            	this.mc.displayGuiScreen(null);
	            	doAction = false;
	            	LabyModCore.getMinecraft().getPlayer().sendChatMessage("/craft");
	            	break;
	            }
                case 110: {
                    this.mc.displayGuiScreen(null);
                    doAction = false;
                    break;
                }
                case 120: {
                	ModButton.API.a_617553_p(MineUtil.getUtilCore());
	                break;
                }
                case 160: {
                    this.mc.displayGuiScreen(new CleanCraftGui4());
                    doAction = false;
                    break;
                }
                case 150: {
                    this.mc.displayGuiScreen(new CleanCraftGui6());
                    doAction = false;
                    break;
                }
                case 222: {
                	this.setSelection("ChestInventory", false);
                	break;
                }
                case 271: {
                    this.setSelection("Spawner", false);
                    break;
                }
                case 300: {
                    this.setSelection("Bucket", true);
                    break;
                }
                case 310: {
                    this.setSelection("Beacon", true);
                    break;
                }
                case 320: {
                    this.setSelection("Anvil", true);
                    break;
                }
                case 330: {
                    this.setSelection("Bow", true);
                    break;
                }
                case 340: {
                    this.setSelection("Netherbrick", true);
                    break;
                }
                case 350: {
                    this.setSelection("Enchantingtable", true);
                    break;
                }
                case 360: {
                    this.setSelection("Craftingtable", true);
                    break;
                }
                case 370: {
                    this.setSelection("TNT", true);
                    break;
                }
                case 410: {
                    this.setSelection("Brewingstand", true);
                    break;
                }
                case 420: {
                    this.setSelection("Shears", true);
                    break;
                }
                case 430: {
                    this.setSelection("EyeOfEnder", true);
                    break;
                }
                case 440: {
                    this.setSelection("Blazepowder", true);
                    break;
                }
                case 450: {
                    this.setSelection("Clock", true);
                    break;
                }
                case 460: {
                    this.setSelection("ArmorStand", true);
                    break;
                }
                case 500: {
                	this.mc.displayGuiScreen(new TEDLagerPreisGui());
                	break;
                }
                case 501: {
                	this.mc.displayGuiScreen(new ChangelogGui());
                	break;
                }
            }
            if (doAction) {
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
        if (crafting) {
            MineUtil.getUtilCore().setCraftSelection(setSel);
            if (setSel.length() > 0) {
                MineUtil.getUtilCore().getApi().displayMessageInChat(MineUtil.getUtilCore().getSettings().getPrefix() 
                		+ ModColor.cl("a") + "Auto. Crafting for " + ModColor.cl('e') + setSel + ModColor.cl('a') + " enabled!");
            }
            else {
                MineUtil.getUtilCore().getApi().displayMessageInChat(MineUtil.getUtilCore().getSettings().getPrefix() 
                		+ ModColor.cl("c") + "Auto. Crafting disabled!");
            }
        }
        else {
            MineUtil.getUtilCore().setCleanSelection(setSel);
            if (setSel.length() > 0) {
                MineUtil.getUtilCore().getApi().displayMessageInChat(MineUtil.getUtilCore().getSettings().getPrefix() 
                		+ ModColor.cl("a") + "Auto. Cleaning for " + ModColor.cl('e') + setSel + ModColor.cl('a') + " enabled!");
            }
            else {
                MineUtil.getUtilCore().getApi().displayMessageInChat(MineUtil.getUtilCore().getSettings().getPrefix() 
                		+ ModColor.cl("c") + "Auto. Cleaning disabled!");
            }
        }
    }
    
    public void updateButtons() {
        this.changeLogButton.enabled = false;
        if (MineUtil.getUtilCore().getCraftSelection().length() > 0 || MineUtil.getUtilCore().getCleanSelection().length() > 0) {
            this.deactivateButton.enabled = true;
            if(MineUtil.getUtilCore().getCraftSelection().length() > 0) {
            	this.closeCraftButton.enabled = true;
            }
        }
        else {
            this.deactivateButton.enabled = false;
            this.closeCraftButton.enabled = false;
            this.changeLogButton.enabled = false;
        }
        this.cleanSpawnerButton.displayString = this.getButtonDisplayString(this.cleanSpawnerButton.displayString, "spawner", false);
        this.cleanChestInventoryButton.displayString = this.getButtonDisplayString(this.cleanChestInventoryButton.displayString, "ChestInventory", false);
        this.craftBucketButton.displayString = this.getButtonDisplayString(this.craftBucketButton.displayString, "bucket", true);
        this.craftBeaconButton.displayString = this.getButtonDisplayString(this.craftBeaconButton.displayString, "beacon", true);
        this.craftAnvilButton.displayString = this.getButtonDisplayString(this.craftAnvilButton.displayString, "anvil", true);
        this.craftBowButton.displayString = this.getButtonDisplayString(this.craftBowButton.displayString, "bow", true);
        this.craftNetherBrickButton.displayString = this.getButtonDisplayString(this.craftNetherBrickButton.displayString, "netherbrick", true);
        this.craftEnchantingTableButton.displayString = this.getButtonDisplayString(this.craftEnchantingTableButton.displayString, "enchantingtable", true);
        this.craftCraftingTableButton.displayString = this.getButtonDisplayString(this.craftCraftingTableButton.displayString, "craftingtable", true);
        this.craftTNTButton.displayString = this.getButtonDisplayString(this.craftTNTButton.displayString, "tnt", true);
        this.craftBrewingStandButton.displayString = this.getButtonDisplayString(this.craftBrewingStandButton.displayString, "brewingstand", true);
        this.craftShearsButton.displayString = this.getButtonDisplayString(this.craftShearsButton.displayString, "shears", true);
        this.craftEyeOfEnderButton.displayString = this.getButtonDisplayString(this.craftEyeOfEnderButton.displayString, "eyeofender", true);
        this.craftBlazePowderButton.displayString = this.getButtonDisplayString(this.craftBlazePowderButton.displayString, "blazepowder", true);
        this.craftClockButton.displayString = this.getButtonDisplayString(this.craftClockButton.displayString, "clock", true);
        this.craftArmorStand.displayString = this.getButtonDisplayString(this.craftArmorStand.displayString, "armorstand", true);
    }
    
    public void onGuiClosed() {
    	CGui.setGUIOpend(false);
    	CGui.setGUIToggled(false);
        super.onGuiClosed();
    }
    
    public boolean doesGuiPauseGame() {
        return false;
    }
}
