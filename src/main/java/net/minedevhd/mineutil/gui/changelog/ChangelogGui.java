package net.minedevhd.mineutil.gui.changelog;

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
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.ScaledResolution;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.MineUtil.CCGui;
import net.minedevhd.mineutil.gui.storageprices.PreisInfos;
import net.minedevhd.mineutil.gui.storageprices.TEDLagerPreisGui;
import net.minedevhd.mineutil.helper.StealHelper;
import net.minedevhd.mineutil.utils.ModButton;
import net.minedevhd.mineutil.utils.RenderUtils;

public class ChangelogGui extends GuiScreen
{

    GuiButton closeButton;
    
    public ChangelogGui() {}
    
    private Integer crafter_y = 35, command_y = 35, design_y = 75, function_y = 155, sonstiges_y = 35;
    
    @Override
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
    	final Integer color = new Color(10, 10, 10, 100).getRGB();
    	final ScaledResolution sr = new ScaledResolution(this.mc);
    	
    	RenderUtils.drawRoundedRect(sr.getScaledWidth() / 2 - 230, 6, sr.getScaledWidth() / 2 + 230, 29, 18, color);
    	RenderUtils.drawRoundedRect(sr.getScaledWidth() / 2 - 230, 30, sr.getScaledWidth() / 2 + 230, 288, 18, new Color(10, 10, 10, 100).getRGB());
    	
    	final String date = MineUtil.getUtilCore().getChangelogDate();
		this.drawCenteredString(this.fontRendererObj, "§lChangelog§r - [" + date + "]", this.width / 2, 13, ModButton.toRainbow(18));
		
		this.draw(0, "Added", sr.getScaledWidth() - 60, 10);
		this.draw(1, "Removed", sr.getScaledWidth() - 60, 20);
		this.draw(2, "Changed", sr.getScaledWidth() - 60, 30);
		this.draw(3, "Nothing", sr.getScaledWidth() - 60, 40);
		
		final String commandPrefix = MineUtil.getUtilCore().getSettings().getCommandPrefix();
		
		this.drawString(this.fontRendererObj, ModColor.BOLD + "Crafter", sr.getScaledWidth() / 2 - 225, getCrafterY(), 16777215);
		this.draw(0, "Wooden Trapdoor", sr.getScaledWidth() / 2 - 220, getCrafterY() + 10);
		this.draw(0, "Iron Trapdoor", sr.getScaledWidth() / 2 - 220, getCrafterY() + 20);
		
		this.drawString(this.fontRendererObj, ModColor.BOLD + "Commands", sr.getScaledWidth() / 2 - 105, getCommandY(), 16777215);
		this.draw(2, commandPrefix + "help", sr.getScaledWidth() / 2 - 100, getCommandY() + 10);
		
//		this.drawString(this.fontRendererObj, ModColor.BOLD + "Designs", sr.getScaledWidth() / 2 - 225, getDesignY(), 16777215);
//		this.draw(0, "GUI-Category", sr.getScaledWidth() / 2 - 220, getDesignY() + 10);
		
//		this.drawString(this.fontRendererObj, ModColor.BOLD + "Functions", sr.getScaledWidth() / 2 - 225, getFunctionY(), 16777215);
//		this.draw(2, "FreeCam Rotating", sr.getScaledWidth() / 2 - 220, getFunctionY() + 10);
		
//		this.drawString(this.fontRendererObj, ModColor.BOLD + "Other", sr.getScaledWidth() / 2 - 105, getSonstigesY(), 16777215);
//		this.draw(3, "Nichts", sr.getScaledWidth() / 2 - 100, getSonstigesY() + 10);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
    
    @Override
    public void initGui() {
    	this.buttonList.add(this.closeButton = new ModButton(500, this.width / 2 - 100, 265, "Close"));
        super.initGui();
    }
    
    @Override
    protected void actionPerformed(final GuiButton button) throws IOException {
        try {
            boolean doAction = true;
            switch (button.id) {
                case 500: {
                	doAction = false;
                	this.mc.thePlayer.closeScreen();
                	break;
                }
            }
            if (doAction) {
                super.actionPerformed(button);
            }
        } catch (Exception exception) {}
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
    
    private final void draw(final Integer val, final String content, final Integer xPos, final Integer yPos) {
    	switch (val) {
		case 0:
			this.drawString(this.fontRendererObj, "§2§l+ §a" + content, xPos, yPos, 16777215);
			break;
		case 1:
	    	this.drawString(this.fontRendererObj, "§4§l- §c" + content, xPos, yPos, 16777215);
			break;
		case 2:
	    	this.drawString(this.fontRendererObj, "§6§l/ §e" + content, xPos, yPos, 16777215);
			break;
		case 3:
			this.drawString(this.fontRendererObj, "§9§l* §b" + content, xPos, yPos, 16777215);
			break;
		default:
			break;
		}
    }
    
    private final Integer getCrafterY() {
    	return this.crafter_y;
    }
    
    private final Integer getCommandY() {
    	return this.command_y;
    }
    
    public final Integer getDesignY() {
		return this.design_y;
	}
    
    public final Integer getFunctionY() {
		return this.function_y;
	}
    
    public final Integer getSonstigesY() {
		return this.sonstiges_y;
	}
    
}
