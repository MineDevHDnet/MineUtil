package net.minedevhd.mineutil.modules;

import net.labymod.ingamegui.ModuleCategory;
import net.labymod.ingamegui.ModuleCategoryRegistry;
import net.labymod.ingamegui.moduletypes.SimpleModule;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.ControlElement.IconData;
import net.labymod.utils.Material;
import net.minedevhd.mineutil.MineUtil;

public class FlightStatusModule extends SimpleModule {

	@Override
	public String getDefaultValue() {
		return "Flight";
	}
	
	@Override
	public String getDisplayName() {
		return "FlightStatus";
	}
	
	@Override
	public String getDisplayValue() {
		if(MineUtil.getUtilCore().getMCCore().thePlayer != null) {
			return MineUtil.getUtilCore().getMCCore().thePlayer.capabilities.allowFlying ? "On" : "Off";
		}
		return "?";
	}

	@Override
	public String getDescription() {
		return "Shows if you're permitted for flight.";
	}

	@Override
	public ControlElement.IconData getIconData() {
		return new ControlElement.IconData(Material.FEATHER);
	}

	@Override
	public String getSettingName() {
		return "FlightStatus";
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
