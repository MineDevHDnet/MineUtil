package net.minedevhd.mineutil.modules;

import net.labymod.ingamegui.ModuleCategory;
import net.labymod.ingamegui.moduletypes.SimpleModule;
import net.labymod.settings.elements.ControlElement;
import net.labymod.utils.Material;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minedevhd.mineutil.settings.UtilCore;

public final class MiniMeModule extends SimpleModule implements UtilCore {

    @Override
    public String getDefaultValue() {
        return "Mini Me";
    }

    @Override
    public String getDisplayName() {
        return "Mini Me";
    }

    @Override
    public String getDisplayValue() {
        if (mc == null || mc.thePlayer == null) {
            return "";
        }

        final int x = (int) getLastX();
        final int y = (int) getLastY();
        GuiInventory.drawEntityOnScreen(x + 5, y + 60, 25, 2, 2, mc.thePlayer);
        return "";
    }

    @Override
    public String getDescription() {
        return "Display a mini version of your player skin.";
    }

    @Override
    public ControlElement.IconData getIconData() {
        return new ControlElement.IconData(Material.NAME_TAG);
    }

    @Override
    public String getSettingName() {
        return "Mini Me";
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
