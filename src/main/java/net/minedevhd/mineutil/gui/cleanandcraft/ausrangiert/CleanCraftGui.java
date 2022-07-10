package net.minedevhd.mineutil.gui.cleanandcraft.ausrangiert;

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
import net.minedevhd.mineutil.command.Command;
import net.minedevhd.mineutil.gui.changelog.ChangelogGui;
import net.minedevhd.mineutil.gui.storageprices.TEDLagerPreisGui;
import net.minedevhd.mineutil.helper.StealHelper;
import net.minedevhd.mineutil.utils.ModButton;
import net.minedevhd.mineutil.utils.ModButton.API;
import net.minedevhd.mineutil.utils.RenderUtils;

public class CleanCraftGui extends GuiScreen
{
    GuiButton cleanSpawnerButton;
    GuiButton craftCoalBlockButton;
    GuiButton craftLapisBlockButton;
    GuiButton craftRedstoneBlockButton;
    GuiButton craftIronBlockButton;
    GuiButton craftGoldIngotButton;
    GuiButton craftGoldBlockButton;
    GuiButton craftDiamondBlockButton;
    GuiButton craftEmeraldBlockButton;
    GuiButton craftSlimeBlockButton;
    GuiButton craftSnowBlockButton;
    GuiButton craftBrickBlockButton;
    GuiButton craftGlowstoneButton;
    GuiButton craftRedstoneLampButton;
    GuiButton craftSeaLanternButton;
    GuiButton cleanChestInventoryButton;
    
    GuiButton pageNextButton;
    GuiButton pagePrevButton;
    GuiButton closeButton;
    GuiButton closeCraftButton;
    GuiButton deactivateButton;
    GuiButton changeLogButton;
    
    public CleanCraftGui() {}
    
    @Override
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
    	RenderUtils.renderNewGuiBackground();
    	MineUtil.getUtilCore().getSettings().setCurrentGuiPage(1);
    	this.drawCenteredString(this.fontRendererObj, "Cleaning and Crafting", this.width / 2, ModButton.API.getButtonYPos(0, true) + 5, ModButton.toRainbow(18));
        this.drawCenteredString(this.fontRendererObj, "- Page 1 of 10 -", this.width / 2, 18, 16777215);
        this.drawString(this.fontRendererObj, "Cleaning", ModButton.API.getButtonXPos(1, this.width) + 1, ModButton.API.getButtonYPos(1, true) + 8, 16777215);
        this.drawString(this.fontRendererObj, "Crafting", ModButton.API.getButtonXPos(1, this.width) + 1, ModButton.API.getButtonYPos(4, true) + 8, 16777215);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
    
    @Override
    public void initGui() {
    	this.buttonList.add(this.cleanSpawnerButton = new ModButton(271, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(2), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Spawner: OFF"));
    	this.buttonList.add(this.cleanChestInventoryButton = new ModButton(222, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(2), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Chest-Inventory: OFF"));
        
        this.buttonList.add(this.craftCoalBlockButton = new ModButton(300, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "CoalBlock: OFF"));
        this.buttonList.add(this.craftLapisBlockButton = new ModButton(310, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "LapisBlock: OFF"));
        this.buttonList.add(this.craftRedstoneBlockButton = new ModButton(320, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "RedstoneBlock: OFF"));
        this.buttonList.add(this.craftIronBlockButton = new ModButton(330, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "IronBlock: OFF"));
        this.buttonList.add(this.craftGoldIngotButton = new ModButton(340, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "GoldIngot: OFF"));
        this.buttonList.add(this.craftGoldBlockButton = new ModButton(350, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "GoldBlock: OFF"));
        this.buttonList.add(this.craftDiamondBlockButton = new ModButton(360, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "DiamondBlock: OFF"));
        this.buttonList.add(this.craftEmeraldBlockButton = new ModButton(370, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "EmeraldBlock: OFF"));
        this.buttonList.add(this.craftSlimeBlockButton = new ModButton(390, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "SlimeBlock: OFF"));
        this.buttonList.add(this.craftSnowBlockButton = new ModButton(410, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "SnowBlock: OFF"));
        this.buttonList.add(this.craftSeaLanternButton = new ModButton(450, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "SeaLantern: OFF"));
        this.buttonList.add(this.craftBrickBlockButton = new ModButton(420, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "BrickBlock: OFF"));
        this.buttonList.add(this.craftGlowstoneButton = new ModButton(430, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Glowstone: OFF"));
        this.buttonList.add(this.craftRedstoneLampButton = new ModButton(440, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "RedstoneLamp: OFF"));
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
                    this.mc.thePlayer.closeScreen();
                    doAction = false;
                    break;
                }
                case 120: {
                	ModButton.API.a_617553_p(MineUtil.getUtilCore());
                    break;
                }
                case 160: {
                    this.mc.displayGuiScreen(new CleanCraftGui10());
                    doAction = false;
                    break;
                }
                case 150: {
                    this.mc.displayGuiScreen(new CleanCraftGui2());
                    doAction = false;
                    break;
                }
                case 271: {
                    this.setSelection("Spawner", false);
                    break;
                }
                case 222: {
                	this.setSelection("ChestInventory", false);
                	break;
                }
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
                case 390: {
                    this.setSelection("Slimeblock", true);
                    break;
                }
                case 410: {
                    this.setSelection("Snowblock", true);
                    break;
                }
                case 420: {
                    this.setSelection("Brickblock", true);
                    break;
                }
                case 430: {
                    this.setSelection("Glowstone", true);
                    break;
                }
                case 440: {
                    this.setSelection("Redstonelamp", true);
                    break;
                }
                case 450: {
                    this.setSelection("Sealantern", true);
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
                LabyMod.getInstance().displayMessageInChat(Command.transformMessage("Automatic Crafting " 
                		+ ModColor.DARK_GRAY + "(" + ModColor.GRAY + setSel.replace(": OFF", "").replace(": ON", "") 
                		+ ModColor.DARK_GRAY + ")", true));
            }
            else {
                LabyMod.getInstance().displayMessageInChat(Command.transformMessage("Automatic Crafting", false));
            }
        }
        else {
            MineUtil.getUtilCore().setCleanSelection(setSel);
            if (setSel.length() > 0) {
            	LabyMod.getInstance().displayMessageInChat(Command.transformMessage("Automatic Cleaning " 
            			+ ModColor.DARK_GRAY + "(" + ModColor.GRAY + setSel.replace(": OFF", "").replace(": ON", "") 
            			+ ModColor.DARK_GRAY + ")", true));
            }
            else {
                LabyMod.getInstance().displayMessageInChat(Command.transformMessage("Automatic Cleaning", false));
            }
        }
    }
    
    private void updateButtons() {
    	this.changeLogButton.enabled = true;
        if (MineUtil.getUtilCore().getCraftSelection().length() > 0 || MineUtil.getUtilCore().getCleanSelection().length() > 0) {
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
        this.craftSlimeBlockButton.displayString = this.getButtonDisplayString(this.craftSlimeBlockButton.displayString, "slimeblock", true);
        this.craftSnowBlockButton.displayString = this.getButtonDisplayString(this.craftSnowBlockButton.displayString, "snowblock", true);
        this.craftBrickBlockButton.displayString = this.getButtonDisplayString(this.craftBrickBlockButton.displayString, "brickblock", true);
        this.craftGlowstoneButton.displayString = this.getButtonDisplayString(this.craftGlowstoneButton.displayString, "glowstone", true);
        this.craftRedstoneLampButton.displayString = this.getButtonDisplayString(this.craftRedstoneLampButton.displayString, "redstonelamp", true);
        this.craftSeaLanternButton.displayString = this.getButtonDisplayString(this.craftSeaLanternButton.displayString, "sealantern", true);
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
