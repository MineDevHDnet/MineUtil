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

public class CoordinatesModule extends SimpleModule implements UtilCore {

	@Override
	public String getDefaultValue() {
		return "Coordinates";
	}

	@Override
	public String getDisplayName() {
		return "Coordinates";
	}
	
	private final Minecraft mc = mineUtil.getMinecraft();

	@Override
	public String getDisplayValue() {
		try {
        	final String text = "MineUtil | b" + mineUtil.getVersion()/* + " | " + this.mc.getDebugFPS()*/;
        	final Integer i = this.mc.fontRendererObj.getStringWidth(text);
        	
			GuiScreen.drawRect(5, 21, i + 6, 50, new Color(0, 0, 0, 90).getRGB());
        	GuiScreen.drawRect(5, 49, i + 6, 50, ModButton.toRainbow(18));
        	
        	final EntityPlayerSP sp = this.mc.thePlayer;
        	
        	new Gui().drawString(this.mc.fontRendererObj, "X: " + sp.getPosition().getX(), 7, 23, 16777215);
        	new Gui().drawString(this.mc.fontRendererObj, "Y: " + sp.getPosition().getY(), 7, 32, 16777215);
        	new Gui().drawString(this.mc.fontRendererObj, "Z: " + sp.getPosition().getZ(), 7, 41, 16777215);
		} catch (Exception exception) {}
    	return "";
	}

	@Override
	public String getDescription() {
		return "Display your coordinates.";
	}

	@Override
	public ControlElement.IconData getIconData() {
		return new ControlElement.IconData(Material.COMPASS);
	}

	@Override
	public String getSettingName() {
		return "Coordinates";
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
