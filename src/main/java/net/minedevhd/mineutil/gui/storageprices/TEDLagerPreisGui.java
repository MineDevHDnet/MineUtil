package net.minedevhd.mineutil.gui.storageprices;

import java.awt.*;
import java.io.IOException;

import net.labymod.utils.ModColor;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.resources.I18n;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.MineUtil.CCGui;
import net.minedevhd.mineutil.gui.cleanandcraft.CleanCraftOreGui;
import net.minedevhd.mineutil.utils.ModButton;
import net.minedevhd.mineutil.utils.RenderUtils;

public class TEDLagerPreisGui extends GuiScreen {
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
    	final ScaledResolution sr = new ScaledResolution(mc);
    	RenderUtils.drawRoundedRect(sr.getScaledWidth() / 2 - 230, 6, sr.getScaledWidth() / 2 + 230, 29, 18, new Color(10, 10, 10, 100).getRGB()); // Titel
    	RenderUtils.drawRoundedRect(sr.getScaledWidth() / 2 - 230, 30, sr.getScaledWidth() / 2 + 230, 288, 18, new Color(10, 10, 10, 100).getRGB());
    	
		this.drawCenteredString(this.fontRendererObj, ModColor.BOLD.toString() + ModColor.UNDERLINE.toString() + "The Expendables - Lager Verkauf-Preise", this.width / 2, 13, ModButton.toRainbow(18));
		
		int color = new Color(225, 225, 225).getRGB();
        /* -- Block A - Start -- */
		this.drawString(this.fontRendererObj, "Eichenholz" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getEICHENHOLZ() + "$", sr.getScaledWidth() / 2 - 225, 35, 16777215);
        this.drawString(this.fontRendererObj, "Birkenholz" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getBIRKENHOLZ() + "$", sr.getScaledWidth() / 2 - 225, 45, color);
        this.drawString(this.fontRendererObj, "Fichtenholz" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getFICHTENHOLZ() + "$", sr.getScaledWidth() / 2 - 225, 55, 16777215);
        this.drawString(this.fontRendererObj, "Tropenholz" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getJUNGELHOLZ() + "$", sr.getScaledWidth() / 2 - 225, 65, color);
        this.drawString(this.fontRendererObj, "Akazienholz" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getAKAZIENHOLZ() + "$", sr.getScaledWidth() / 2 - 225, 75, 16777215);
        this.drawString(this.fontRendererObj, "Schwarzeichenholz" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getSCHWARZEICHENHOLZ() + "$", sr.getScaledWidth() / 2 - 225, 85, color);

        this.drawString(this.fontRendererObj, "Eichenlaub" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getEICHENLAUB() + "$", sr.getScaledWidth() / 2 - 225, 105, 16777215);
        this.drawString(this.fontRendererObj, "Birkenlaub" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getBIRKENLAUB() + "$", sr.getScaledWidth() / 2 - 225, 115, color);
        this.drawString(this.fontRendererObj, "Fichtenlaub" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getFICHTENLAUB() + "$", sr.getScaledWidth() / 2 - 225, 125, 16777215);
        this.drawString(this.fontRendererObj, "Tropenlaub" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getJUNGELLAUB() + "$", sr.getScaledWidth() / 2 - 225, 135, color);
        this.drawString(this.fontRendererObj, "Akazienlaub" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getAKAZIENLAUB() + "$", sr.getScaledWidth() / 2 - 225, 145, 16777215);
        this.drawString(this.fontRendererObj, "Schwarzeichenlaub" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getSCHWARZEICHENLAUB() + "$", sr.getScaledWidth() / 2 - 225, 155, color);

        this.drawString(this.fontRendererObj, "Sand" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getSAND() + "$", sr.getScaledWidth() / 2 - 225, 175, 16777215);
        this.drawString(this.fontRendererObj, "Sandstein" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getSANDSTEIN() + "$", sr.getScaledWidth() / 2 - 225, 185, color);
        this.drawString(this.fontRendererObj, "Roter Sand" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getROTER_SAND() + "$", sr.getScaledWidth() / 2 - 225, 195, 16777215);
        this.drawString(this.fontRendererObj, "Roter Sandstein" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getROTER_SANDSTEIN() + "$", sr.getScaledWidth() / 2 - 225, 205, color);

        this.drawString(this.fontRendererObj, "Netherstein" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getNETHERSTEIN() + "$", sr.getScaledWidth() / 2 - 225, 225, 16777215);
        this.drawString(this.fontRendererObj, "Netherziegel" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getNETHERZIEGEL() + "$", sr.getScaledWidth() / 2 - 225, 235, color);
        this.drawString(this.fontRendererObj, "Quarzblock" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getQUARZBLOCK() + "$", sr.getScaledWidth() / 2 - 225, 245, 16777215);
        this.drawString(this.fontRendererObj, "Glowstoneblock" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getGLOWSTONE() + "$", sr.getScaledWidth() / 2 - 225, 255, color);
        this.drawString(this.fontRendererObj, "Seelensand" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getSEELATERNEN() + "$", sr.getScaledWidth() / 2 - 225, 265, 16777215);
        this.drawString(this.fontRendererObj, "Obsidian" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getOBSIDIAN() + "$", sr.getScaledWidth() / 2 - 225, 275, color);
		/* -- Block A - Ende -- */
        
        /* -- Block B - Start -- */
        this.drawString(this.fontRendererObj, "Diorit" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getDIORIT() + "$", sr.getScaledWidth() / 2 - 71, 35, 16777215);
        this.drawString(this.fontRendererObj, "Granit" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getGRANIT() + "$", sr.getScaledWidth() / 2 - 71, 45, color);
        this.drawString(this.fontRendererObj, "Andesit" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getANDESIT() + "$", sr.getScaledWidth() / 2 - 71, 55, 16777215);
        this.drawString(this.fontRendererObj, "Kies" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getKIES() + "$", sr.getScaledWidth() / 2 - 71, 65, color);
        this.drawString(this.fontRendererObj, "Myzel" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getMYZEL() + "$", sr.getScaledWidth() / 2 - 71, 75, 16777215);
        this.drawString(this.fontRendererObj, "Podsol" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getPODSOL() + "$", sr.getScaledWidth() / 2 - 71, 85, color);
        this.drawString(this.fontRendererObj, "Ziegelstein" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getZIEGELSTEIN() + "$", sr.getScaledWidth() / 2 - 71, 95, 16777215);
        this.drawString(this.fontRendererObj, "Flusston" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getFLUSSTON() + "$", sr.getScaledWidth() / 2 - 71, 105, color);

        this.drawString(this.fontRendererObj, "Eis" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getEIS() + "$", sr.getScaledWidth() / 2 - 71, 125, 16777215);
        this.drawString(this.fontRendererObj, "Packeis" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getPACKEIS() + "$", sr.getScaledWidth() / 2 - 71, 135, color);
        this.drawString(this.fontRendererObj, "Schnee" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getSCHNEE() + "$", sr.getScaledWidth() / 2 - 71, 145, 16777215);

        this.drawString(this.fontRendererObj, "Kohleblock" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getKOHLEBLOCK() + "$", sr.getScaledWidth() / 2 - 71, 165, 16777215);
        this.drawString(this.fontRendererObj, "Eisenblock" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getEISENBLOCK() + "$", sr.getScaledWidth() / 2 - 71, 175, color);
        this.drawString(this.fontRendererObj, "Lapisblock" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getLAPISBLOCK() + "$", sr.getScaledWidth() / 2 - 71, 185, 16777215);
        this.drawString(this.fontRendererObj, "Redstoneblock" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getREDSTONEBLOCK() + "$", sr.getScaledWidth() / 2 - 71, 195, color);
        this.drawString(this.fontRendererObj, "Goldblock" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getGOLDBLOCK() + "$", sr.getScaledWidth() / 2 - 71, 205, 16777215);
        this.drawString(this.fontRendererObj, "Diamantblock" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getDIAMANTBLOCK() + "$", sr.getScaledWidth() / 2 - 71, 215, color);
        this.drawString(this.fontRendererObj, "Smaragdblock" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getSMARAGDBLOCK() + "$", sr.getScaledWidth() / 2 - 71, 225, 16777215);
        
        this.drawString(this.fontRendererObj, "Grasblock" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getGRASBLOCK() + "$", sr.getScaledWidth() / 2 - 71, 245, 16777215);
        this.drawString(this.fontRendererObj, "Steinziegel" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getSTEINZIEGEL() + "$", sr.getScaledWidth() / 2 - 71, 255, color);
        this.drawString(this.fontRendererObj, "Rissiger Steinziegel" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getRISSIGER_STEINZIEGEL() + "$", sr.getScaledWidth() / 2 - 71, 265, 16777215);
        this.drawString(this.fontRendererObj, "Bemooster Steinziegel" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getBEMOOSTER_STEINZIEGEL() + "$", sr.getScaledWidth() / 2 - 71, 275, color);
        /* -- Block B - Ende -- */
        
        /* -- Block C - Start -- */
        this.drawString(this.fontRendererObj, "Weisse Wolle" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getWEISSE_WOLLE() + "$", sr.getScaledWidth() / 2 + 97, 35, 16777215);
        this.drawString(this.fontRendererObj, "Farbige Wolle" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getFARBIGE_WOLLE() + "$", sr.getScaledWidth() / 2 + 97, 45, color);

        this.drawString(this.fontRendererObj, "Gebrannter Ton" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getGEBRANNTER_TON() + "$", sr.getScaledWidth() / 2 + 97, 65, 16777215);
        this.drawString(this.fontRendererObj, "Farbiger Ton" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getFARBIGER_TON() + "$", sr.getScaledWidth() / 2 + 97, 75, color);

        this.drawString(this.fontRendererObj, "Glas" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getGLAS_BLOCK() + "$", sr.getScaledWidth() / 2 + 97, 95, 16777215);
        this.drawString(this.fontRendererObj, "Farbiges Glas" + ModColor.DARK_GRAY + " - " + ModColor.RESET + PreisInfos.getFARBIGES_GLAS() + "$", sr.getScaledWidth() / 2 + 97, 105, color);
        /* -- Block C - Ende -- */
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public void initGui() {
        this.buttonList.add(new ModButton(0, this.width / 2 - 45, this.height - 45, 110, 20, "Back"));
		super.initGui();
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		try {
			switch (button.id) {
			case 0:
				this.mc.displayGuiScreen(new CleanCraftOreGui());
				break;
			default:
				break;
			}
			super.actionPerformed(button);
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

}
