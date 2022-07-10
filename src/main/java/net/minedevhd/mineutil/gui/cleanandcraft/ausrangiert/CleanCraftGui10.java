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

public class CleanCraftGui10 extends GuiScreen
{
	GuiButton cleanSpawnerButton;
	GuiButton craftBreadButton;
	GuiButton craftCakeButton;
	GuiButton craftCookieButton;
	GuiButton craftGoldenAppleButton;
	GuiButton craftOPGoldenAppleButton;
	GuiButton craftGoldenCarrotButton;
	GuiButton craftPumpkinPieButton;
	GuiButton craftMushroomStewButton;
	GuiButton craftRabbitStewButton;
	GuiButton craftGoldenMelonButton;
    GuiButton craftMelonButton;
    GuiButton craftHayBlockButton;
    GuiButton craftBowlButton;
    GuiButton cleanChestInventoryButton;
	
    GuiButton pageNextButton;
    GuiButton pagePrevButton;
    GuiButton closeButton;
    GuiButton closeCraftButton;
    GuiButton deactivateButton;
    GuiButton changeLogButton;
    
    public CleanCraftGui10() {}
    
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
    	RenderUtils.renderNewGuiBackground();
    	MineUtil.getUtilCore().getSettings().setCurrentGuiPage(10);
        this.drawCenteredString(this.fontRendererObj, "Cleaning and Crafting", this.width / 2, ModButton.API.getButtonYPos(0, true) + 5, ModButton.toRainbow(18));
        this.drawCenteredString(this.fontRendererObj, "- Page 10 of 10 -", this.width / 2, 18, 16777215);
        this.drawString(this.fontRendererObj, "Cleaning", ModButton.API.getButtonXPos(1, this.width) + 1, ModButton.API.getButtonYPos(1, true) + 8, 16777215);
        this.drawString(this.fontRendererObj, "Crafting", ModButton.API.getButtonXPos(1, this.width) + 1, ModButton.API.getButtonYPos(4, true) + 8, 16777215);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
    
    @Override
    public void initGui() {
    	this.buttonList.add(this.cleanSpawnerButton = new ModButton(271, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(2), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Spawner: OFF"));
    	this.buttonList.add(this.cleanChestInventoryButton = new ModButton(222, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(2), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Chest-Inventory: OFF"));
        
    	this.buttonList.add(this.craftBreadButton = new ModButton(300, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Bread: OFF"));
    	this.buttonList.add(this.craftCakeButton = new ModButton(310, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Cake: OFF"));
    	this.buttonList.add(this.craftCookieButton = new ModButton(320, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Cookie: OFF"));
    	this.buttonList.add(this.craftGoldenAppleButton = new ModButton(330, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(5), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "GoldenApple: OFF"));
    	this.buttonList.add(this.craftOPGoldenAppleButton = new ModButton(340, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "OPGoldenApple: OFF"));
    	this.buttonList.add(this.craftGoldenCarrotButton = new ModButton(350, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "GoldenCarrot: OFF"));
    	this.buttonList.add(this.craftPumpkinPieButton = new ModButton(370, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "PumpkinPie: OFF"));
    	this.buttonList.add(this.craftMushroomStewButton = new ModButton(360, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(6), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "MushroomStew: OFF"));
    	this.buttonList.add(this.craftRabbitStewButton = new ModButton(380, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "RabbitStew: OFF"));
    	this.buttonList.add(this.craftGoldenMelonButton = new ModButton(390, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "GoldenMelon: OFF"));
        this.buttonList.add(this.craftMelonButton = new ModButton(400, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Melon: OFF"));
        this.buttonList.add(this.craftHayBlockButton = new ModButton(410, ModButton.API.getButtonXPos(4, this.width), ModButton.API.getButtonYPos(7), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "HayBlock: OFF"));
        this.buttonList.add(this.craftBowlButton = new ModButton(420, ModButton.API.getButtonXPos(1, this.width), ModButton.API.getButtonYPos(8), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Bowl: OFF"));
    	
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
    protected void actionPerformed(GuiButton button) throws IOException {
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
                case 222: {
                	this.setSelection("ChestInventory", false);
                	break;
                }
	            case 271: {
	                this.setSelection("Spawner", false);
	                break;
	            }
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
	            case 370: {
	            	this.setSelection("PumpkinPie", true);
	            	break;
	            }
	            case 360: {
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
                    this.setSelection("Hayblock", true);
                    break;
                }
                case 420: {
                    this.setSelection("Bowl", true);
                    break;
                }
	            case 160: {
	                this.mc.displayGuiScreen(new CleanCraftGui9());
	                doAction = false;
	                break;
	            }
	            case 150: {
	                this.mc.displayGuiScreen(new CleanCraftOreGui());
	                doAction = false;
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
        catch (Exception exception) {};
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
                		+ ModColor.cl("a") + "Auto. Crafting for " + ModColor.cl('e') + setSel.replace(": OFF", "").replace(": ON", "") + ModColor.cl('a') + " enabled!");
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
                		+ ModColor.cl("a") + "Auto. Cleaning for " + ModColor.cl('e') + setSel.replace(": OFF", "").replace(": ON", "") + ModColor.cl('a') + " enabled!");
            }
            else {
                MineUtil.getUtilCore().getApi().displayMessageInChat(MineUtil.getUtilCore().getSettings().getPrefix() 
                		+ ModColor.cl("c") + "Auto. Cleaning disabled!");
            }
        }
    }
    
    private void updateButtons() {
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
        }
        this.cleanSpawnerButton.displayString = this.getButtonDisplayString(this.cleanSpawnerButton.displayString, "Spawner", false);
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
        this.craftMelonButton.displayString = this.getButtonDisplayString(this.craftMelonButton.displayString, "melon", true);
        this.craftHayBlockButton.displayString = this.getButtonDisplayString(this.craftHayBlockButton.displayString, "hayblock", true);
        this.craftBowlButton.displayString = this.getButtonDisplayString(this.craftBowlButton.displayString, "Bowl", true);
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
