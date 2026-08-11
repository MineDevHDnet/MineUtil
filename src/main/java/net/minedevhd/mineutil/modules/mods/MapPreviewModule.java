package net.minedevhd.mineutil.modules.mods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
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

public final class MapPreviewModule {

    private static final int PREVIEW_SIZE = 48;
    private static final int MAP_SIZE = 128;

    private List<String> tooltip = Collections.emptyList();

    private final ModSettings settings = MineUtil.getCore().getSettings();
    private final Minecraft minecraft = MineUtil.getCore().getMinecraft();

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onTooltip(final ItemTooltipEvent event) {
        if (!isEnabled()
                || event == null
                || event.itemStack == null
                || !(event.itemStack.getItem() instanceof ItemMap)
                || event.toolTip == null
                || minecraft.fontRendererObj == null) {
            tooltip = Collections.emptyList();
            return;
        }

        final FontRenderer font = minecraft.fontRendererObj;
        final int lines = (int) Math.ceil(PREVIEW_SIZE / (font.FONT_HEIGHT + 1D));
        final int spaceWidth = Math.max(1, font.getCharWidth(' '));
        final int spaces = (int) Math.ceil(PREVIEW_SIZE / (double) spaceWidth);
        final String spacer = repeat(' ', spaces);

        for (int i = 0; i < lines; i++) {
            event.toolTip.add(spacer);
        }
        tooltip = new ArrayList<String>(event.toolTip);
    }

    @SubscribeEvent
    public void onRender(final GuiScreenEvent.DrawScreenEvent.Post event) {
        if (!isEnabled()
                || event == null
                || !(event.gui instanceof GuiContainer)
                || minecraft.theWorld == null
                || minecraft.entityRenderer == null) {
            return;
        }

        final Slot slot = ((GuiContainer) event.gui).getSlotUnderMouse();
        if (slot == null || !slot.getHasStack()) {
            return;
        }

        final ItemStack stack = slot.getStack();
        if (stack == null || !(stack.getItem() instanceof ItemMap)) {
            return;
        }

        final MapData mapData = Items.filled_map.getMapData(stack, minecraft.theWorld);
        if (mapData == null) {
            return;
        }

        final EntityRenderer renderer = minecraft.entityRenderer;
        renderer.enableLightmap();
        try {
            renderMap(event.mouseX, event.mouseY, event.gui.width, event.gui.height,
                    minecraft.fontRendererObj, mapData);
        } finally {
            renderer.disableLightmap();
        }
    }

    private boolean isEnabled() {
        return settings != null && settings.isModMapPreview() && MineUtil.getCore().isOnGrieferGames();
    }

    private void renderMap(final int mouseX, final int mouseY,
                           final int screenWidth, final int screenHeight,
                           final FontRenderer font, final MapData mapData) {
        if (font == null) {
            return;
        }

        int tooltipTextWidth = PREVIEW_SIZE;
        for (final String line : tooltip) {
            if (line != null) {
                tooltipTextWidth = Math.max(tooltipTextWidth, font.getStringWidth(line));
            }
        }

        int tooltipX = mouseX + 12;
        if (tooltipX + tooltipTextWidth + 4 > screenWidth) {
            tooltipX = mouseX - 16 - tooltipTextWidth;
        }
        tooltipX = Math.max(4, Math.min(tooltipX, Math.max(4, screenWidth - PREVIEW_SIZE - 4)));

        int tooltipY = mouseY - 12;
        int tooltipHeight = 8;
        if (tooltip.size() > 1) {
            tooltipHeight += (tooltip.size() - 1) * 10 + 2;
        }
        if (tooltipY + tooltipHeight + 6 > screenHeight) {
            tooltipY = screenHeight - tooltipHeight - 6;
        }

        int previewY = tooltipY + Math.max(0, tooltipHeight - PREVIEW_SIZE);
        previewY = Math.max(4, Math.min(previewY, Math.max(4, screenHeight - PREVIEW_SIZE - 4)));

        GlStateManager.pushMatrix();
        try {
            GlStateManager.disableRescaleNormal();
            RenderHelper.disableStandardItemLighting();
            GlStateManager.disableLighting();
            GlStateManager.disableDepth();

            GlStateManager.translate(tooltipX, previewY, 300.0F);
            final double mapScale = PREVIEW_SIZE / (double) MAP_SIZE;
            GlStateManager.scale(mapScale, mapScale, 1.0D);
            minecraft.entityRenderer.getMapItemRenderer().renderMap(mapData, false);
        } finally {
            GlStateManager.enableDepth();
            GlStateManager.enableLighting();
            RenderHelper.enableStandardItemLighting();
            GlStateManager.enableRescaleNormal();
            GlStateManager.popMatrix();
        }
    }

    private static String repeat(final char character, final int count) {
        if (count <= 0) {
            return "";
        }
        final StringBuilder builder = new StringBuilder(count);
        for (int i = 0; i < count; i++) {
            builder.append(character);
        }
        return builder.toString();
    }
}
