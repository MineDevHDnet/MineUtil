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
import net.minedevhd.mineutil.gui.cleanandcraft.CleanCraftOreGui;
import net.minedevhd.mineutil.gui.storageprices.TEDLagerPreisGui;
import net.minedevhd.mineutil.utils.ModButton;
import net.minedevhd.mineutil.utils.ModButton.API;
import net.minedevhd.mineutil.utils.RenderUtils;

public class CleanCraftGui2 extends GuiScreen
{
    GuiButton cleanSpawnerButton;
    GuiButton craftWoodButton;
    GuiButton craftStickButton;
    GuiButton craftTripwireHookButton;
    GuiButton craftChestButton;
    GuiButton craftRedstoneChestButton;
    GuiButton craftEnderChestButton;
    GuiButton craftHopperButton;
    GuiButton craftDispenserButton;
    GuiButton craftDropperButton;
    GuiButton craftTorchButton;
    GuiButton craftRedstoneTorchButton;
    GuiButton craftRedstoneComperatorButton;
    GuiButton craftRedstoneRepeaterButton;
    GuiButton craftPrismarineButton;
    GuiButton craftPrismarineBrickButton;
    GuiButton craftWoodTrapdoorButton;
    GuiButton craftIronTrapdoorButton;
    GuiButton craftDarkPrismarineButton;
    GuiButton cleanChestInventoryButton;
    
    GuiButton pageNextButton;
    GuiButton pagePrevButton;
    GuiButton closeButton;
    GuiButton closeCraftButton;
    GuiButton deactivateButton;
    GuiButton changeLogButton;
    
    public CleanCraftGui2() {}
    
    @Override
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
    	RenderUtils.renderNewGuiBackground();
    	MineUtil.getUtilCore().getSettings().setCurrentGuiPage(2);
        this.drawCenteredString(this.fontRendererObj, "Cleaning and Crafting", this.width / 2, ModButton.API.getButtonYPos(0, true) + 5, ModButton.toRainbow(18));
        this.drawCenteredString(this.fontRendererObj, "- Page 2 of 10 -", this.width / 2, 18, 16777215);
        this.drawString(this.fontRendererObj, "Cleaning", ModButton.API.getButtonXPos(1, this.width) + 1, ModButton.API.getButtonYPos(1, true) + 8, 16777215);
        this.drawString(this.fontRendererObj, "Crafting", ModButton.API.getButtonXPos(1, this.width) + 1, ModButton.API.getButtonYPos(4, true) + 8, 16777215);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
    
    public void initGui() {
        this.buttonList.add(this.cleanSpawnerButton = new ModButton(271, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(2), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Spawner: OFF"));
        this.buttonList.add(this.cleanChestInventoryButton = new ModButton(222, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(2), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Chest-Inventory: OFF"));
        
        this.buttonList.add(this.craftWoodButton = new ModButton(300, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Wood: OFF"));
        this.buttonList.add(this.craftStickButton = new ModButton(310, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Stick: OFF"));
        this.buttonList.add(this.craftTripwireHookButton = new ModButton(320, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "TripwireHook: OFF"));
        this.buttonList.add(this.craftChestButton = new ModButton(330, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Chest: OFF"));
        this.buttonList.add(this.craftRedstoneChestButton = new ModButton(340, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "RedstoneChest: OFF"));
        this.buttonList.add(this.craftEnderChestButton = new ModButton(350, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "EnderChest: OFF"));
        this.buttonList.add(this.craftHopperButton = new ModButton(360, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Hopper: OFF"));
        this.buttonList.add(this.craftDispenserButton = new ModButton(370, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Dispenser: OFF"));
        this.buttonList.add(this.craftDropperButton = new ModButton(380, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Dropper: OFF"));
        this.buttonList.add(this.craftTorchButton = new ModButton(390, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Torch: OFF"));
        this.buttonList.add(this.craftRedstoneTorchButton = new ModButton(400, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "RedstoneTorch: OFF"));
        this.buttonList.add(this.craftRedstoneComperatorButton = new ModButton(410, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "RedstoneComperator: OFF"));
        this.buttonList.add(this.craftRedstoneRepeaterButton = new ModButton(420, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "RedstoneRepeater: OFF"));
        this.buttonList.add(this.craftPrismarineButton = new ModButton(430, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Prismarine: OFF"));
        this.buttonList.add(this.craftPrismarineBrickButton = new ModButton(440, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "PrismarineBrick: OFF"));
        this.buttonList.add(this.craftDarkPrismarineButton = new ModButton(450, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "DarkPrismarine: OFF"));
        this.buttonList.add(this.craftWoodTrapdoorButton = new ModButton(460, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(9), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "WoodTrapdoor: OFF"));
        this.buttonList.add(this.craftIronTrapdoorButton = new ModButton(470, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(9), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "IronTrapdoor: OFF"));

        this.buttonList.add(this.pagePrevButton = new ModButton(160, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(9), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "<< BACK"));
        this.buttonList.add(this.pageNextButton = new ModButton(150, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(9), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "FORWARD >>"));
        this.buttonList.add(this.deactivateButton = new ModButton(120, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(12), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "DISABLE"));
        this.buttonList.add(this.closeButton = new ModButton(110, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(12), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "CLOSE"));
        this.buttonList.add(this.closeCraftButton = new ModButton(90, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(11), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "CLOSE and CRAFT"));
        
        this.buttonList.add(new ModButton(500, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(12), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), ModColor.AQUA.toString() + "Lager Preise"));
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
                    this.mc.displayGuiScreen(new CleanCraftOreGui());
                    doAction = false;
                    break;
                }
                case 150: {
                    this.mc.displayGuiScreen(new CleanCraftGui3());
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
                    this.setSelection("Wood", true);
                    break;
                }
                case 310: {
                    this.setSelection("Stick", true);
                    break;
                }
                case 320: {
                    this.setSelection("Tripwirehook", true);
                    break;
                }
                case 330: {
                    this.setSelection("Chest", true);
                    break;
                }
                case 340: {
                    this.setSelection("Redstonechest", true);
                    break;
                }
                case 350: {
                    this.setSelection("Enderchest", true);
                    break;
                }
                case 360: {
                    this.setSelection("Hopper", true);
                    break;
                }
                case 370: {
                    this.setSelection("Dispenser", true);
                    break;
                }
                case 380: {
                    this.setSelection("dDropper", true);
                    break;
                }
                case 390: {
                    this.setSelection("Torch", true);
                    break;
                }
                case 400: {
                    this.setSelection("Redstonetorch", true);
                    break;
                }
                case 410: {
                    this.setSelection("Redstonecomperator", true);
                    break;
                }
                case 420: {
                    this.setSelection("Redstonerepeater", true);
                    break;
                }
                case 430: {
                    this.setSelection("Prismarine", true);
                    break;
                }
                case 440: {
                    this.setSelection("Prismarinebrick", true);
                    break;
                }
                case 450: {
                    this.setSelection("Darkprismarine", true);
                    break;
                }
                case 460: {
                	this.setSelection("WoodTrapdoor", true);
                	break;
                }
                case 470: {
                	this.setSelection("IronTrapdoor", true);
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
        this.craftTorchButton.enabled = false;
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
        this.craftWoodButton.displayString = this.getButtonDisplayString(this.craftWoodButton.displayString, "wood", true);
        this.craftStickButton.displayString = this.getButtonDisplayString(this.craftStickButton.displayString, "stick", true);
        this.craftTripwireHookButton.displayString = this.getButtonDisplayString(this.craftTripwireHookButton.displayString, "tripwirehook", true);
        this.craftChestButton.displayString = this.getButtonDisplayString(this.craftChestButton.displayString, "chest", true);
        this.craftRedstoneChestButton.displayString = this.getButtonDisplayString(this.craftRedstoneChestButton.displayString, "redstonechest", true);
        this.craftEnderChestButton.displayString = this.getButtonDisplayString(this.craftEnderChestButton.displayString, "enderchest", true);
        this.craftHopperButton.displayString = this.getButtonDisplayString(this.craftHopperButton.displayString, "hopper", true);
        this.craftDispenserButton.displayString = this.getButtonDisplayString(this.craftDispenserButton.displayString, "dispenser", true);
        this.craftDropperButton.displayString = this.getButtonDisplayString(this.craftDropperButton.displayString, "dropper", true);
        this.craftTorchButton.displayString = this.getButtonDisplayString(this.craftTorchButton.displayString, "torch", true);
        this.craftRedstoneTorchButton.displayString = this.getButtonDisplayString(this.craftRedstoneTorchButton.displayString, "redstonetorch", true);
        this.craftRedstoneComperatorButton.displayString = this.getButtonDisplayString(this.craftRedstoneComperatorButton.displayString, "redstonecomperator", true);
        this.craftRedstoneRepeaterButton.displayString = this.getButtonDisplayString(this.craftRedstoneRepeaterButton.displayString, "redstonerepeater", true);
        this.craftPrismarineButton.displayString = this.getButtonDisplayString(this.craftPrismarineButton.displayString, "prismarine", true);
        this.craftPrismarineBrickButton.displayString = this.getButtonDisplayString(this.craftPrismarineBrickButton.displayString, "prismarinebrick", true);
        this.craftDarkPrismarineButton.displayString = this.getButtonDisplayString(this.craftDarkPrismarineButton.displayString, "darkprismarine", true);
        this.craftWoodTrapdoorButton.displayString = this.getButtonDisplayString(this.craftWoodTrapdoorButton.displayString, "woodtrapdoor", true);
        this.craftIronTrapdoorButton.displayString = this.getButtonDisplayString(this.craftIronTrapdoorButton.displayString, "irontrapdoor", true);
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
