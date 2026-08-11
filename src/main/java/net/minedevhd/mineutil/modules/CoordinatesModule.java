package net.minedevhd.mineutil.modules;

import java.awt.Color;

import net.labymod.ingamegui.ModuleCategory;
import net.labymod.ingamegui.moduletypes.SimpleModule;
import net.labymod.settings.elements.ControlElement;
import net.labymod.utils.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minedevhd.mineutil.settings.UtilCore;
import net.minedevhd.mineutil.utils.ModButton;

public final class CoordinatesModule extends SimpleModule implements UtilCore {

    @Override
    public String getDefaultValue() {
        return "Coordinates";
    }

    @Override
    public String getDisplayName() {
        return "Coordinates";
    }

    @Override
    public String getDisplayValue() {
        final Minecraft minecraft = mineUtil.getMinecraft();
        if (minecraft == null || minecraft.fontRendererObj == null || minecraft.thePlayer == null) {
            return "";
        }

        final String text = "MineUtil | b" + mineUtil.getVersion();
        final int width = minecraft.fontRendererObj.getStringWidth(text);
        final EntityPlayerSP player = minecraft.thePlayer;

        GuiScreen.drawRect(5, 21, width + 6, 50, new Color(0, 0, 0, 90).getRGB());
        GuiScreen.drawRect(5, 49, width + 6, 50, ModButton.toRainbow(18));

        final Gui gui = new Gui();
        gui.drawString(minecraft.fontRendererObj, "X: " + player.getPosition().getX(), 7, 23, 0xFFFFFF);
        gui.drawString(minecraft.fontRendererObj, "Y: " + player.getPosition().getY(), 7, 32, 0xFFFFFF);
        gui.drawString(minecraft.fontRendererObj, "Z: " + player.getPosition().getZ(), 7, 41, 0xFFFFFF);
        return "";
    }

    @Override
    public String getDescription() {
        return "Display your coordinates.";
    }

    @Override
    public ControlElement.IconData getIconData() {
        return new ControlElement.IconData(Material.COMPASS);
    }

    @Override
    public String getSettingName() {
        return "Coordinates";
    }

    @Override
    public int getSortingId() {
        return 0;
    }

    @Override
    public void loadSettings() {
    }

    @Override
    public ModuleCategory getCategory() {
        return mineUtil.MINEUTIL_CATEGORY;
    }
}
