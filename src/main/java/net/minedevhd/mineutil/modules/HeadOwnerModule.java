package net.minedevhd.mineutil.modules;

import net.labymod.ingamegui.ModuleCategory;
import net.labymod.ingamegui.moduletypes.SimpleModule;
import net.labymod.settings.elements.ControlElement;
import net.labymod.utils.Material;
import net.minedevhd.mineutil.settings.UtilCore;
import net.minedevhd.mineutil.utils.HeadOwnerUtil;

public final class HeadOwnerModule extends SimpleModule implements UtilCore {

    @Override
    public String getDisplayName() {
        return "HeadOwner";
    }

    @Override
    public String getDisplayValue() {
        final HeadOwnerUtil.Skull skull = HeadOwnerUtil.getSkullLooking();
        return skull == null ? "?" : skull.getDisplay();
    }

    @Override
    public String getDefaultValue() {
        return "?";
    }

    @Override
    public ControlElement.IconData getIconData() {
        return new ControlElement.IconData(Material.SKULL_ITEM);
    }

    @Override
    public void loadSettings() {
    }

    @Override
    public String getSettingName() {
        return "HeadOwner";
    }

    @Override
    public String getDescription() {
        return "Shows the owner of the head you're looking at.";
    }

    @Override
    public int getSortingId() {
        return 200;
    }

    @Override
    public ModuleCategory getCategory() {
        return mineUtil.MINEUTIL_CATEGORY;
    }

    @Override
    public boolean isShown() {
        final HeadOwnerUtil.Skull skull = HeadOwnerUtil.getSkullLooking();
        return skull != null && skull.isShown();
    }
}
