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

@SuppressWarnings("null")
public class ShowMCNameModule extends SimpleModule {

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
    	GameProfile profile = Minecraft.getMinecraft().getSession().getProfile();
    	
    	if(profile == null && profile.getName() == null) {
    		return "Unknown minecraft Session (Please restart the Game)!";
    	}
    	return profile.getName();
	}

	@Override
	public String getDescription() {
		return "Display your currently minecraft name.";
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
	public void loadSettings() {}
    
    public ModuleCategory getCategory() {
        return MineUtil.MINEUTIL_CATEGORY;
    }

}
