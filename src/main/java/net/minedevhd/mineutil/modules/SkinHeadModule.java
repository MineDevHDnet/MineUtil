package net.minedevhd.mineutil.modules;

import java.awt.Color;
import java.util.UUID;

import com.mojang.authlib.GameProfile;

import net.labymod.ingamegui.ModuleCategory;
import net.labymod.ingamegui.ModuleCategoryRegistry;
import net.labymod.ingamegui.moduletypes.SimpleModule;
import net.labymod.main.LabyMod;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.ControlElement.IconData;
import net.labymod.utils.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.command.CommandManager;
import net.minedevhd.mineutil.helper.TrustedUserHelper;
import net.minedevhd.mineutil.utils.ModButton;
import net.minedevhd.mineutil.utils.RenderUtils;

public class SkinHeadModule extends SimpleModule {

	@Override
	public String getDefaultValue() {
		return "Skin Head";
	}

	@Override
	public String getDisplayName() {
		return "Skin Head";
	}

	@Override
	public String getDisplayValue() {
		try {
			final GameProfile profile = MineUtil.getUtilCore().getMCCore().getSession().getProfile();
			final int x = (int) getLastX(), y = (int) getLastY();
			
			LabyMod.getInstance().getDrawUtils().drawPlayerHead(profile, x, y, 25);
		} catch (Exception exception) {}
    	return "";
	}

	@Override
	public String getDescription() {
		return "Display your head from skin.";
	}

	@Override
	public ControlElement.IconData getIconData() {
		return new ControlElement.IconData(Material.NAME_TAG);
	}

	@Override
	public String getSettingName() {
		return "Skin Head";
	}

	@Override
	public int getSortingId() {
		return 0;
	}

	@Override
	public void loadSettings() {}
    
    public ModuleCategory getCategory() {
        return MineUtil.MINEUTIL_CATEGORY;
    }

}
