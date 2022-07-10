package net.minedevhd.mineutil.modules;

import java.awt.Color;

import com.mojang.authlib.GameProfile;

import net.labymod.gui.elements.CheckBox;
import net.labymod.gui.elements.ColorPicker;
import net.labymod.gui.elements.ColorPicker.DefaultColorCallback;
import net.labymod.ingamegui.ModuleCategory;
import net.labymod.ingamegui.ModuleCategoryRegistry;
import net.labymod.ingamegui.moduletypes.SimpleModule;
import net.labymod.main.LabyMod;
import net.labymod.settings.elements.ColorPickerCheckBoxBulkElement;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.ControlElement.IconData;
import net.labymod.utils.Consumer;
import net.labymod.utils.Material;
import net.labymod.utils.ModColor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.command.CommandManager;
import net.minedevhd.mineutil.helper.TrustedUserHelper;
import net.minedevhd.mineutil.utils.ModButton;
import net.minedevhd.mineutil.utils.RenderUtils;

public class NewHotbarModule extends SimpleModule {

	@Override
	public String getDefaultValue() {
		return "Hotbar";
	}

	@Override
	public String getDisplayName() {
		return "Hotbar";
	}

	@Override
	public String getDisplayValue() {
		try {
			final Gui gui = new Gui();

			GuiScreen.drawRect(0, RenderUtils.getResolution().getScaledHeight() - 23, RenderUtils.getResolution().getScaledWidth(), RenderUtils.getResolution().getScaledHeight(), new Color(0, 0, 0, 100).getRGB());
//			GuiScreen.drawRect(2, RenderUtils.getResolution().getScaledHeight() - 22, 4, RenderUtils.getResolution().getScaledHeight(), ModButton.toRainbow(18)); // Colors: https://html-color.codes/green
			GuiScreen.drawRect(0, RenderUtils.getResolution().getScaledHeight() - 23, RenderUtils.getResolution().getScaledWidth(), RenderUtils.getResolution().getScaledHeight() - 24, ModButton.toRainbow(18)); // Colors: https://html-color.codes/green
			
			final int x = mc.thePlayer.getPosition().getX();
			final int y = mc.thePlayer.getPosition().getY();
			final int z = mc.thePlayer.getPosition().getZ();
			
			int ping = 0;
			if(mc.isSingleplayer()) ping = 0;
			else ping = (int) mc.getCurrentServerData().pingToServer;
			
			final String ping2 = (ping == 0 ? "-1ms" : ping + "ms");
			final int x2 = 3; /*default: 7*/
			
			gui.drawString(mc.fontRendererObj, "Ping: " + ping2, x2, RenderUtils.getResolution().getScaledHeight() - 20, 16777215);
			gui.drawString(mc.fontRendererObj, "X: " + x + ", Y: " + y + ", Z: " + z, x2, RenderUtils.getResolution().getScaledHeight() - 10, 16777215);
		} catch (Exception exception) {}
    	return "";
	}

	@Override
	public String getDescription() {
		return "Shows a cool new hotbar.";
	}

	@Override
	public ControlElement.IconData getIconData() {
		return new ControlElement.IconData(Material.NAME_TAG);
	}

	@Override
	public String getSettingName() {
		return "Hotbar";
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
