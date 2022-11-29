package net.minedevhd.mineutil.modules.mods;

import java.util.ArrayList;
import java.util.List;

import joptsimple.internal.Strings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.init.Items;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemMap;
import net.minecraft.item.ItemStack;
import net.minecraft.world.storage.MapData;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.settings.ModSettings;

public class MapPreviewModule {
	
	private List<String> tooltip = new ArrayList<String>();
	
	private final ModSettings settings = MineUtil.getCore().getSettings();
	private final Minecraft mc = MineUtil.getCore().getMinecraft();
	
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public void onTooltip(ItemTooltipEvent event) {
		if(!settings.isModMapPreview() || !MineUtil.getCore().isOnGrieferGames() || !(event.itemStack.getItem() instanceof ItemMap))
			return;
		
		// Add space(s)
		final int lines = (int) Math.ceil(48 / (mc.fontRendererObj.FONT_HEIGHT + 1d));
		final int spaces = (int) Math.ceil(48 / (double) mc.fontRendererObj.getCharWidth(' '));
		
		for(int i = 0; i < lines; i++)
			event.toolTip.add(Strings.repeat(' ', spaces));
		
		tooltip = new ArrayList<>(event.toolTip);
	}
	
	@SubscribeEvent
	public void onRender(GuiScreenEvent.DrawScreenEvent.Post event) {
		if(!settings.isModMapPreview() || !MineUtil.getCore().isOnGrieferGames() || !(event.gui instanceof GuiContainer))
			return;
		
		//render map
		Slot slot = ((GuiContainer) event.gui).getSlotUnderMouse();
		
		if(slot == null || !slot.getHasStack())
			return;
		
		ItemStack stack = slot.getStack();
		
		if(!(stack.getItem() instanceof ItemMap))
			return;
		
		final MapData mapData = Items.filled_map.getMapData(stack, mc.theWorld);
		
		if(mapData == null)
			return;
		
		EntityRenderer renderer = mc.entityRenderer;
		
		// Enable lighting (otherwise it's darker than it should be)
		renderer.enableLightmap();
		this.renderMap(event.mouseX, event.mouseY, event.gui.width, event.gui.height, mc.fontRendererObj, mapData);
		renderer.disableLightmap();
	}
	
	/**
	 * Source of the code to calculate the position: {@link net.minecraftforge.fml.client.config.GuiUtils#drawHoveringText(List, int, int, int, int, int, FontRenderer) GuiUtils.drawHoveringText}
	 */
	private void renderMap(final Integer mouseX, final Integer mouseY, final Integer screenWidth, final Integer screenHeight, final FontRenderer font, final MapData mapData) {
		GlStateManager.disableRescaleNormal();
		RenderHelper.disableStandardItemLighting();
		GlStateManager.disableLighting();
		GlStateManager.disableDepth();
		
		int tooltipTextWidth = 0;
		
		for(String textLine : tooltip) {
			int textLineWidth = font.getStringWidth(textLine);
			
			if(textLineWidth > tooltipTextWidth)
				tooltipTextWidth = textLineWidth;
		}
		
		boolean needsWrap = false;
		
		int titleLinesCount = 1,
			tooltipX = mouseX + 12;
		
		if(tooltipX + tooltipTextWidth + 4 > screenWidth) {
			tooltipX = mouseX - 16 - tooltipTextWidth;
			
			if(tooltipX < 4) {
				if(mouseX > screenWidth / 2)
					tooltipTextWidth = mouseX - 12 - 8;
				else
					tooltipTextWidth = screenWidth - 16 - mouseX;
				
				needsWrap = true;
			}
		}
		
		if(needsWrap) {
			int wrappedTooltipWidth = 0;
			List<String> wrappedTextLines = new ArrayList<String>();
			
			for(int i = 0; i < tooltip.size(); i++) {
				String textLine = tooltip.get(i);
				List<String> wrappedLine = font.listFormattedStringToWidth(textLine, wrappedTooltipWidth);
				
				if(i == 0)
					titleLinesCount = wrappedLine.size();
					
				for(String line : wrappedLine) {
					int lineWidth = font.getStringWidth(line);
					
					if(lineWidth > wrappedTooltipWidth)
						wrappedTooltipWidth = lineWidth;
					
					wrappedTextLines.add(line);
				}
			}
			tooltipTextWidth = wrappedTooltipWidth;
			tooltip = wrappedTextLines;
			
			if(mouseX > screenWidth / 2)
				tooltipX = mouseX - 16 - tooltipTextWidth;
			else
				tooltipX = mouseX + 12;
		}
		
		int tooltipY = mouseY - 12;
		int tooltipHeight = 8;
		
		if(tooltip.size() > 1) {
			tooltipHeight += (tooltip.size() - 1) * 10;
			
			if(tooltip.size() > titleLinesCount)
				tooltipHeight += 2;
		}
		
		if(tooltipY + tooltipHeight + 6 > screenHeight)
			tooltipY = screenHeight - tooltipHeight - 6;
		
		for(int lineNumber = 0; lineNumber < tooltip.size(); ++lineNumber) {
			if(lineNumber + 1 == titleLinesCount)
				tooltipY += 2;
			tooltipY += 10;
		}
		
		GlStateManager.translate(tooltipX, tooltipY - 50, 1);

		double mapScale = 48 / 128d;
		GlStateManager.scale(mapScale, mapScale, 1);
		mc.entityRenderer.getMapItemRenderer().renderMap(mapData, false);

		GlStateManager.enableLighting();
		GlStateManager.enableDepth();
		RenderHelper.enableStandardItemLighting();
		GlStateManager.enableRescaleNormal();
	}

}
