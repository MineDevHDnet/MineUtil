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
import net.minedevhd.mineutil.settings.UtilCore;
import net.minedevhd.mineutil.utils.ModButton;
import net.minedevhd.mineutil.utils.graf.RenderUtils;

public class MiniMeModule extends SimpleModule implements UtilCore {

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
		try {
			int x = (int) getLastX(), y = (int) getLastY();
			GuiInventory.drawEntityOnScreen(x + 5, y + 60, 25, 2, 2, mc.thePlayer);
		} catch (Exception exception) {}
    	return "";
	}

	@Override
	public String getDescription() {
		return "Display a cute mini me of your skin.";
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
	public void loadSettings() {}
    
    public ModuleCategory getCategory() {
        return mineUtil.MINEUTIL_CATEGORY;
    }

}
