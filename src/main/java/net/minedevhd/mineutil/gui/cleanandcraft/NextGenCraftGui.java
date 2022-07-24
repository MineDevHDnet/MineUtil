package net.minedevhd.mineutil.gui.cleanandcraft;

import java.io.IOException;

import org.lwjgl.input.Keyboard;

import net.labymod.core.LabyModCore;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.MineUtil.CCGui;
import net.minedevhd.mineutil.gui.changelog.ChangelogGui;
import net.minedevhd.mineutil.gui.storageprices.TEDLagerPreisGui;
import net.minedevhd.mineutil.utils.ModButton;
import net.minedevhd.mineutil.utils.RenderUtils;

public class NextGenCraftGui extends GuiScreen {
	
	private final MineUtil mineUtil = MineUtil.getUtilCore();
	
	private String[] AvailableItems = { "GoldIngot", "GoldBlock", "TNT", "SeaLantern", "RedstoneBlock", "Glowstone", "Prismarine", "PrismarineBrick", "DarkPrismarine", "Paper", "QuartzBlock", "QuartzPillar", "QuartzSlab", "ChiseledQuartz", "NetherBrick", "BrickBlock", "DiamondBlock", "IronBlock", "EmeraldBlock", "SlimeBlock", "SnowBlock", "ClayBlock", "HayBlock", "Wool", "RedstoneLamp", "CoalBlock", "LapisBlock", "ItemFrame", "Compass", "Map", "Melon", "StoneBrick", "StoneBrickSlab", "ChiseledStoneBrick", "BookShelf", "MossyCobbleStone", "MossyStoneBrick", "Anvil", "RedstoneComperator", "RedstoneRepeater", "Dispenser", "Dropper", "Bow", "Hopper", "RedstoneTorch", "Torch", "Sandstone", "SmoothSandstone", "SandstoneSlab", "ChiseledSandstone", "RedSandstone", "SmoothRedSandstone", "RedSandstoneSlab", "ChiseledRedSandstone", "ColorRed", "ColorYellow", "ColorPink", "ColorMagenta", "ColorOrange", "ColorLightGrey", "ColorViolet", "ColorTurquoise", "ColorGrey", "ColorLightGreen", "ColorLightBlue", "ColorWhite", "WoolBlack", "WoolRed", "WoolGreen", "WoolBrown", "WoolBlue", "WoolViolet", "WoolTurquoise", "WoolLightGrey", "WoolGrey", "WoolPink", "WoolLightGreen", "WoolYellow", "WoolLightBlue", "WoolMagenta", "WoolOrange", "ClayBlack", "ClayRed", "ClayGreen", "ClayBrown", "ClayBlue", "ClayViolet", "ClayTurquoise", "ClayLightGrey", "ClayGrey", "ClayPink", "ClayLightGreen", "ClayYellow", "ClayLightBlue", "ClayMagenta", "ClayOrange", "ClayWhite", "GlassBlack", "GlassRed", "GlassGreen", "GlassBrown", "GlassBlue", "GlassViolet", "GlassTurquoise", "GlassLightGrey", "GlassGrey", "GlassPink", "GlassLightGreen", "GlassYellow", "GlassLightBlue", "GlassMagenta", "GlassOrange", "GlassWhite", "wood", "chest", "redstonechest", "enderchest", "tripwirehook", "stick", "PolishedAndesite", "PolishedDiorite", "PolishedGranite", "book", "Piston", "stickyPiston", "Furnace", "Cauldron", "noteblock", "jukebox", "Bucket", "Beacon", "EnchantingTable", "CraftingTable", "BrewingStand", "Shears", "EyeOfEnder", "BlazePowder", "Bread", "Cake", "Cookie", "GoldenApple", "OPGoldenApple", "GoldenCarrot", "PumpkinPie", "MushroomStew", "RabbitStew", "Bowl", "GoldenMelon", "Clock", "ArmorStand", "WoodTrapdoor", "IronTrapdoor", "Coal", "Lapis", "Redstone", "Iron", "GoldNugget", "Gold", "Diamond", "Emerald" };
	
	GuiButton doneButton,
			  closeButton,
			  closeCraftButton,
			  deactivateButton;
	
	private GuiTextField textField;
	
	private String itemName = "";
	
	private boolean visible = false,
					error = false;
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		RenderUtils.renderNewGuiBackground();
		RenderUtils.drawSizedString(this, "NextGen - Crafting", -1, 5, true, MineUtil.CLIENT_COLOR);
//		this.drawCenteredString(this.fontRendererObj, "NextGen - Crafting", this.width / 2, ModButton.API.getButtonYPos(0, true) + 5, ModButton.toRainbow(18));
//        this.drawCenteredString(this.fontRendererObj, "This Function is in development (betamode)", this.width / 2, 18, 16777215);
        this.drawCenteredString(this.fontRendererObj, (this.error ? "§4§lError!" : ""), this.width / 2, 45, 16777215);
        this.drawCenteredString(this.fontRendererObj, (this.error ? "§c§lThe Item §6§l" + this.textField.getText() + " §c§lcannot be found!" : ""), this.width / 2, 55, 16777215);
        this.drawCenteredString(this.fontRendererObj, "§aEnter the Itemname I need to craft here;", this.width / 2 - 9, 77, 16777215);
        this.drawCenteredString(this.fontRendererObj, "§abtw. " + AvailableItems.length + " Items are craftable!", this.width / 2 - 38, 110, 16777215);
        this.drawCenteredString(this.fontRendererObj, (mineUtil.getCraftSelection().isEmpty() ? "" : "§3§o» §b§o" + mineUtil.getCraftSelection()), this.width / 2, 126, 16777215);
        
    	this.textField.drawTextBox();
    	this.textField.updateCursorCounter();
    	
    	if(this.textField.getText().isEmpty() && this.doneButton.enabled)
    		this.doneButton.enabled = false;
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public void initGui() {
		this.textField = new GuiTextField(0, mc.fontRendererObj, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(4), 225, ModButton.API.getButtonHeight());
		this.textField.setFocused(true);
		this.textField.setMaxStringLength(32);
		this.textField.setCanLoseFocus(false);
		this.textField.setEnabled(true);
		
		this.buttonList.add(this.deactivateButton = new ModButton(130, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(11), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "DISABLE"));
		this.buttonList.add(this.closeCraftButton = new ModButton(120, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(11), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "CLOSE and CRAFT"));
        this.buttonList.add(this.doneButton = new ModButton(110, ModButton.API.getButtonXPos(2, this.width), ModButton.API.getButtonYPos(12), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "Done"));
        this.buttonList.add(this.closeButton = new ModButton(140, ModButton.API.getButtonXPos(3, this.width), ModButton.API.getButtonYPos(12), ModButton.API.getButtonWidth(), ModButton.API.getButtonHeight(), "CLOSE"));
        this.updateButtons();
        super.initGui();
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		try {
            boolean doAction = true;
            switch (button.id) {
	            case 110: {
	            	this.logItem();
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
            }
            if(doAction) {
                this.updateButtons();
                super.actionPerformed(button);
            }
        }
        catch (Exception exception) {}
	}
	
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		this.textField.textboxKeyTyped(typedChar, keyCode);
		if(!this.textField.getText().isEmpty()) {
			if(!this.doneButton.enabled)
				this.doneButton.enabled = true;
		}
		if(this.error)
			this.error = false;
		super.keyTyped(typedChar, keyCode);
	}
	
	private void setSelection(final String setSel) {
		mineUtil.setCraftSelection(setSel);
        if(setSel.length() > 0) {
            mineUtil.getApi().displayMessageInChat(mineUtil.getSettings().getPrefix() 
            		+ "§7Module §eAutomatic Crafting §8(§7" + setSel + "§8) §7has been §aactivated§7.");
        }
        else {
            mineUtil.getApi().displayMessageInChat(mineUtil.getSettings().getPrefix() 
            		+ "§7Module §eAutomatic Crafting §7has been §cdeactivated§7.");
        }
    }
	
	private void updateButtons() {
        if(mineUtil.getCraftSelection().length() > 0) {
            this.deactivateButton.enabled = true;
            this.closeCraftButton.enabled = true;
        }
        else {
            this.deactivateButton.enabled = false;
            this.closeCraftButton.enabled = false;
        }
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
    
    private void logItem() {
    	for(String s : this.AvailableItems) {
    		if(this.textField.getText().equalsIgnoreCase(s)) {
    			this.error = false;
    			this.itemName = this.textField.getText().toLowerCase();
    			this.setSelection(this.itemName);
    			break;
    		}
    		else {
    			this.error = true;
    		}
    	}
    }

}
