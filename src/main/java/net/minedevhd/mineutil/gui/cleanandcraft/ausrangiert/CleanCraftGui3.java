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

public class CleanCraftGui3 extends GuiScreen
{
    GuiButton cleanSpawnerButton;
    GuiButton craftQuartzBlockButton;
    GuiButton craftQuartzPillarButton;
    GuiButton craftQuartzSlabButton;
    GuiButton craftChiseledQuartzButton;
    GuiButton craftSandstoneButton;
    GuiButton craftSmoothSandstoneButton;
    GuiButton craftSandstoneSlabButton;
    GuiButton craftChiseledSandstoneButton;
    GuiButton craftRedSandstoneButton;
    GuiButton craftSmoothRedSandstoneButton;
    GuiButton craftRedSandstoneSlabButton;
    GuiButton craftChiseledRedSandstoneButton;
    GuiButton craftStoneBrickButton;
    GuiButton craftStoneBrickSlabButton;
    GuiButton craftChiseledStoneBrickButton;
    GuiButton craftMossyStoneBrickButton;
    GuiButton cleanChestInventoryButton;
    
    GuiButton pageNextButton;
    GuiButton pagePrevButton;
    GuiButton closeButton;
    GuiButton closeCraftButton;
    GuiButton deactivateButton;
    GuiButton changeLogButton;
    
    public CleanCraftGui3() {}
    
    @Override
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
    	RenderUtils.renderNewGuiBackground();
    	MineUtil.getUtilCore().getSettings().setCurrentGuiPage(3);
        this.drawCenteredString(this.fontRendererObj, "Cleaning and Crafting", this.width / 2, ModButton.API.getButtonYPos(0, true) + 5, ModButton.toRainbow(18));
        this.drawCenteredString(this.fontRendererObj, "- Page 3 of 10 -", this.width / 2, 18, 16777215);
        this.drawString(this.fontRendererObj, "Cleaning", ModButton.API.getButtonXPos(1, this.width) + 1, ModButton.API.getButtonYPos(1, true) + 8, 16777215);
        this.drawString(this.fontRendererObj, "Crafting", ModButton.API.getButtonXPos(1, this.width) + 1, ModButton.API.getButtonYPos(4, true) + 8, 16777215);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
    
    public void initGui() {
        this.buttonList.add(this.cleanSpawnerButton = new ModButton(271, ModButton.API.getButtonXPos(1,this.width), ModButton.API.getButtonYPos(2), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Spawner: OFF"));
        this.buttonList.add(this.cleanChestInventoryButton = new ModButton(222, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(2), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Chest-Inventory: OFF"));
        
        this.buttonList.add(this.craftQuartzBlockButton = new ModButton(300, ModButton.API.getButtonXPos(1,this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "QuartzBlock: OFF"));
        this.buttonList.add(this.craftQuartzPillarButton = new ModButton(310, ModButton.API.getButtonXPos(2,this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "QuartzPillar: OFF"));
        this.buttonList.add(this.craftQuartzSlabButton = new ModButton(320, ModButton.API.getButtonXPos(3,this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "QuartzSlab: OFF"));
        this.buttonList.add(this.craftChiseledQuartzButton = new ModButton(330, ModButton.API.getButtonXPos(4,this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ChiseledQuartz: OFF"));
        this.buttonList.add(this.craftSandstoneButton = new ModButton(340, ModButton.API.getButtonXPos(1,this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Sandstone: OFF"));
        this.buttonList.add(this.craftSmoothSandstoneButton = new ModButton(350, ModButton.API.getButtonXPos(2,this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "SmoothSandstone: OFF"));
        this.buttonList.add(this.craftSandstoneSlabButton = new ModButton(360, ModButton.API.getButtonXPos(3,this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "SandstoneSlab: OFF"));
        this.buttonList.add(this.craftChiseledSandstoneButton = new ModButton(370, ModButton.API.getButtonXPos(4,this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ChiseledSandstone: OFF"));
        this.buttonList.add(this.craftRedSandstoneButton = new ModButton(380, ModButton.API.getButtonXPos(1,this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "RedSandstone: OFF"));
        this.buttonList.add(this.craftSmoothRedSandstoneButton = new ModButton(390, ModButton.API.getButtonXPos(2,this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "SmoothRedSandstone: OFF"));
        this.buttonList.add(this.craftRedSandstoneSlabButton = new ModButton(400, ModButton.API.getButtonXPos(3,this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "RedSandstoneSlab: OFF"));
        this.buttonList.add(this.craftChiseledRedSandstoneButton = new ModButton(410, ModButton.API.getButtonXPos(4,this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ChiseledRedSandstone: OFF"));
        this.buttonList.add(this.craftStoneBrickButton = new ModButton(420, ModButton.API.getButtonXPos(1,this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "StoneBrick: OFF"));
        this.buttonList.add(this.craftStoneBrickSlabButton = new ModButton(430, ModButton.API.getButtonXPos(2,this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "StoneBrickSlab: OFF"));
        this.buttonList.add(this.craftChiseledStoneBrickButton = new ModButton(440, ModButton.API.getButtonXPos(3,this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "ChiseledStoneBrick: OFF"));
        this.buttonList.add(this.craftMossyStoneBrickButton = new ModButton(450, ModButton.API.getButtonXPos(4,this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "MossyStoneBrick: OFF"));
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
                    this.mc.displayGuiScreen(new CleanCraftGui2());
                    doAction = false;
                    break;
                }
                case 150: {
                    this.mc.displayGuiScreen(new CleanCraftGui4());
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
                    this.setSelection("Quartzblock", true);
                    break;
                }
                case 310: {
                    this.setSelection("Quartzpillar", true);
                    break;
                }
                case 320: {
                    this.setSelection("QuartzSlab", true);
                    break;
                }
                case 330: {
                    this.setSelection("Chiseledquartz", true);
                    break;
                }
                case 340: {
                    this.setSelection("Sandstone", true);
                    break;
                }
                case 350: {
                    this.setSelection("Smoothsandstone", true);
                    break;
                }
                case 360: {
                    this.setSelection("SandstoneSlab", true);
                    break;
                }
                case 370: {
                    this.setSelection("Chiseledsandstone", true);
                    break;
                }
                case 380: {
                    this.setSelection("Redsandstone", true);
                    break;
                }
                case 390: {
                    this.setSelection("Smoothredsandstone", true);
                    break;
                }
                case 400: {
                    this.setSelection("RedsandstoneSlab", true);
                    break;
                }
                case 410: {
                    this.setSelection("Chiseledredsandstone", true);
                    break;
                }
                case 420: {
                    this.setSelection("Stonebrick", true);
                    break;
                }
                case 430: {
                    this.setSelection("StonebrickSlab", true);
                    break;
                }
                case 440: {
                    this.setSelection("Chiseledstonebrick", true);
                    break;
                }
                case 450: {
                    this.setSelection("Mossystonebrick", true);
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
        this.craftQuartzBlockButton.displayString = this.getButtonDisplayString(this.craftQuartzBlockButton.displayString, "quartzblock", true);
        this.craftQuartzPillarButton.displayString = this.getButtonDisplayString(this.craftQuartzPillarButton.displayString, "quartzpillar", true);
        this.craftQuartzSlabButton.displayString = this.getButtonDisplayString(this.craftQuartzSlabButton.displayString, "quartzSlab", true);
        this.craftChiseledQuartzButton.displayString = this.getButtonDisplayString(this.craftChiseledQuartzButton.displayString, "chiseledquartz", true);
        this.craftSandstoneButton.displayString = this.getButtonDisplayString(this.craftSandstoneButton.displayString, "sandstone", true);
        this.craftSmoothSandstoneButton.displayString = this.getButtonDisplayString(this.craftSmoothSandstoneButton.displayString, "smoothsandstone", true);
        this.craftSandstoneSlabButton.displayString = this.getButtonDisplayString(this.craftSandstoneSlabButton.displayString, "sandstoneSlab", true);
        this.craftChiseledSandstoneButton.displayString = this.getButtonDisplayString(this.craftChiseledSandstoneButton.displayString, "chiseledsandstone", true);
        this.craftRedSandstoneButton.displayString = this.getButtonDisplayString(this.craftRedSandstoneButton.displayString, "redsandstone", true);
        this.craftSmoothRedSandstoneButton.displayString = this.getButtonDisplayString(this.craftSmoothRedSandstoneButton.displayString, "smoothredsandstone", true);
        this.craftRedSandstoneSlabButton.displayString = this.getButtonDisplayString(this.craftRedSandstoneSlabButton.displayString, "redsandstoneSlab", true);
        this.craftChiseledRedSandstoneButton.displayString = this.getButtonDisplayString(this.craftChiseledRedSandstoneButton.displayString, "chiseledredsandstone", true);
        this.craftStoneBrickButton.displayString = this.getButtonDisplayString(this.craftStoneBrickButton.displayString, "stonebrick", true);
        this.craftStoneBrickSlabButton.displayString = this.getButtonDisplayString(this.craftStoneBrickSlabButton.displayString, "stonebrickSlab", true);
        this.craftChiseledStoneBrickButton.displayString = this.getButtonDisplayString(this.craftChiseledStoneBrickButton.displayString, "chiseledstonebrick", true);
        this.craftMossyStoneBrickButton.displayString = this.getButtonDisplayString(this.craftMossyStoneBrickButton.displayString, "mossystonebrick", true);
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
