package net.minedevhd.mineutil.modules;

import net.labymod.ingamegui.ModuleCategory;
import net.labymod.ingamegui.ModuleCategoryRegistry;
import net.labymod.ingamegui.moduletypes.SimpleModule;
import net.labymod.settings.elements.ControlElement;
import net.labymod.utils.Material;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.settings.UtilCore;
import net.minedevhd.mineutil.utils.HeadOwnerUtil;
import net.minedevhd.mineutil.utils.HeadOwnerUtil.Skull;

public class HeadOwnerModule extends SimpleModule implements UtilCore {
	
    public String getDisplayName() {
        return "HeadOwner";
    }
	
    public String getDisplayValue() {
        final HeadOwnerUtil.Skull skull = HeadOwnerUtil.getSkullLooking();
        return skull.getDisplay();
    }
    
    public String getDefaultValue() {
        return "?";
    }
    
    public ControlElement.IconData getIconData() {
        return new ControlElement.IconData(Material.SKULL_ITEM);
    }
    
    public void loadSettings() {}
    
    public String getSettingName() {
        return "HeadOwner";
    }
    
    public String getDescription() {
        return "Shows the owner of the head you're looking at.";
    }
    
    public int getSortingId() {
        return 200;
    }
    
    public ModuleCategory getCategory() {
        return mineUtil.MINEUTIL_CATEGORY;
    }
    
    public boolean isShown() {
        final HeadOwnerUtil.Skull skull = HeadOwnerUtil.getSkullLooking();
        return skull.isShown();
    }

}
