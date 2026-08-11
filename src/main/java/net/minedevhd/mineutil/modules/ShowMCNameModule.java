package net.minedevhd.mineutil.modules;

import com.mojang.authlib.GameProfile;

import net.labymod.ingamegui.ModuleCategory;
import net.labymod.ingamegui.moduletypes.SimpleModule;
import net.labymod.settings.elements.ControlElement;
import net.labymod.utils.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Session;
import net.minedevhd.mineutil.settings.UtilCore;

public final class ShowMCNameModule extends SimpleModule implements UtilCore {

    @Override
    public String getDefaultValue() {
        return "Name";
    }

    @Override
    public String getDisplayName() {
        return "Name";
    }

    @Override
    public String getDisplayValue() {
        final Minecraft minecraft = mineUtil.getMinecraft();
        if (minecraft == null || minecraft.getSession() == null) {
            return "Unknown session";
        }

        final GameProfile profile = minecraft.getSession().getProfile();
        if (profile == null || profile.getName() == null || profile.getName().trim().isEmpty()) {
            return "Unknown session";
        }
        return profile.getName();
    }

    @Override
    public String getDescription() {
        return "Displays your current Minecraft name.";
    }

    @Override
    public ControlElement.IconData getIconData() {
        return new ControlElement.IconData(Material.NAME_TAG);
    }

    @Override
    public String getSettingName() {
        return "Name";
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
