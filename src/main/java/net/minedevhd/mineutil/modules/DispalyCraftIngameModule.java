package net.minedevhd.mineutil.modules;

import com.mojang.authlib.GameProfile;

import net.labymod.ingamegui.ModuleCategory;
import net.labymod.ingamegui.ModuleCategoryRegistry;
import net.labymod.ingamegui.moduletypes.SimpleModule;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.ControlElement.IconData;
import net.labymod.utils.Material;
import net.minecraft.client.Minecraft;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.command.Command;
import net.minedevhd.mineutil.command.CommandManager;

public class DispalyCraftIngameModule extends SimpleModule {

	@Override
	public String getDefaultValue() {
		return "Crafter";
	}

	@Override
	public String getDisplayName() {
		return "Crafter";
	}

	@Override
	public String getDisplayValue() {
		String selection = MineUtil.getUtilCore().getCraftSelection();
    	return (!selection.equals("") ? selection : "Nothing yet..");
	}

	@Override
	public String getDescription() {
		return "Display your currently crafting selection.";
	}

	@Override
	public ControlElement.IconData getIconData() {
		return new ControlElement.IconData(Material.WORKBENCH);
	}

	@Override
	public String getSettingName() {
		return "Crafter";
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
