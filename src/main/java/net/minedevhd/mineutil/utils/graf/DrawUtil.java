package net.minedevhd.mineutil.utils.graf;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.GuiScreen;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.settings.UtilCore;

public class DrawUtil implements UtilCore {
	
	public static void drawSizedString(final GuiScreen screen, final String text, final int x, final int y, final boolean center, final int color) {
		GL11.glPushMatrix();
        GL11.glScalef(2.0F, 2.0F, 2.0F);
        screen.drawCenteredString(MineUtil.getCore().getMinecraft().fontRendererObj, text, (center ? screen.width / 4 : x), y, color);
        GL11.glPopMatrix();
	}
	
	public static void drawTitleString(final String firstLine, final String secondLine) {
		mineUtil.getMinecraft().ingameGUI.displayTitle(firstLine, null, -1, -1, -1);
		mineUtil.getMinecraft().ingameGUI.displayTitle(null, secondLine, -1, -1, -1);
		mineUtil.getMinecraft().ingameGUI.displayTitle(null, null, 0, 36, 37);
	}
	
}
