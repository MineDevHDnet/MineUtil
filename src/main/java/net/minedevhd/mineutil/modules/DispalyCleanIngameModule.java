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
import net.minedevhd.mineutil.utils.RenderUtils;

public class DispalyCleanIngameModule extends SimpleModule {

	@Override
	public String getDefaultValue() {
		return "Cleaner";
	}

	@Override
	public String getDisplayName() {
		return "Cleaner";
	}

	@Override
	public String getDisplayValue() {
		String selection = MineUtil.getUtilCore().getCleanSelection();
    	return (!selection.equals("") ? selection : "Nothing yet..");
	}

	@Override
	public String getDescription() {
		return "Display your currently cleaning selection.";
	}

	@Override
	public ControlElement.IconData getIconData() {
		return new ControlElement.IconData(Material.BUCKET);
	}

	@Override
	public String getSettingName() {
		return "Cleaner";
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
