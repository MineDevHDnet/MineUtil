package net.minedevhd.mineutil.utils;

import java.awt.Color;
import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.GlStateManager;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.command.Command;
import net.minedevhd.mineutil.command.CommandManager;

public class RenderUtils {
	
	public static void setColor(int color) {
        float a = (color >> 24 & 0xFF) / 255.0F;
        float r = (color >> 16 & 0xFF) / 255.0F;
        float g = (color >> 8 & 0xFF) / 255.0F;
        float b = (color & 0xFF) / 255.0F;
        GL11.glColor4f(r, g, b, a);
    }
    
	public static void fillRect(final double x, final double y, final double width, final double height, int color) {
		GL11.glPushMatrix();
		GL11.glPushAttrib(1048575);
		GL11.glDisable(2929);
		GL11.glDisable(3553);
		GL11.glEnable(2848);
		GL11.glEnable(3042);
		GL11.glBlendFunc(770, 771);

        setColor(color);

		GL11.glBegin(GL11.GL_QUADS);

		GL11.glVertex2d(x, y + height);
		GL11.glVertex2d(x + width, y + height);
		GL11.glVertex2d(x + width, y);
		GL11.glVertex2d(x, y);
		GL11.glEnd();

		GL11.glDisable(3042);
		GL11.glEnable(3553);
		GL11.glEnable(2929);
		GL11.glDisable(2848);
		GL11.glDisable(3042);
		GL11.glPopAttrib();
		GL11.glPopMatrix();
	}
    
    public static void drawRoundedRect(double x, double y, double x1, double y1, double radius, int color) {
    	GL11.glPushAttrib(0);
        GL11.glScaled(0.5D, 0.5D, 0.5D);
        x *= 2.0D;
        y *= 2.0D;
        x1 *= 2.0D;
        y1 *= 2.0D;
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        setColor(color);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        GL11.glBegin(GL11.GL_POLYGON);
        int i;
        for (i = 0; i <= 90; i += 3)
        	GL11.glVertex2d(x + radius + Math.sin(i * Math.PI / 180.0D) * radius * -1.0D, y + radius + Math.cos(i * Math.PI / 180.0D) * radius * -1.0D); 
        for (i = 90; i <= 180; i += 3)
          GL11.glVertex2d(x + radius + Math.sin(i * Math.PI / 180.0D) * radius * -1.0D, y1 - radius + Math.cos(i * Math.PI / 180.0D) * radius * -1.0D); 
        for (i = 0; i <= 90; i += 3)
        	GL11.glVertex2d(x1 - radius + Math.sin(i * Math.PI / 180.0D) * radius, y1 - radius + Math.cos(i * Math.PI / 180.0D) * radius); 
        for (i = 90; i <= 180; i += 3)
        	GL11.glVertex2d(x1 - radius + Math.sin(i * Math.PI / 180.0D) * radius, y + radius + Math.cos(i * Math.PI / 180.0D) * radius); 
        GL11.glEnd();
        GL11.glBegin(GL11.GL_LINE_LOOP);
        for (i = 0; i <= 90; i += 3)
        	GL11.glVertex2d(x + radius + Math.sin(i * Math.PI / 180.0D) * radius * -1.0D, y + radius + Math.cos(i * Math.PI / 180.0D) * radius * -1.0D); 
        for (i = 90; i <= 180; i += 3)
        	GL11.glVertex2d(x + radius + Math.sin(i * Math.PI / 180.0D) * radius * -1.0D, y1 - radius + Math.cos(i * Math.PI / 180.0D) * radius * -1.0D); 
        for (i = 0; i <= 90; i += 3)
        	GL11.glVertex2d(x1 - radius + Math.sin(i * Math.PI / 180.0D) * radius, y1 - radius + Math.cos(i * Math.PI / 180.0D) * radius); 
        for (i = 90; i <= 180; i += 3)
          GL11.glVertex2d(x1 - radius + Math.sin(i * Math.PI / 180.0D) * radius, y + radius + Math.cos(i * Math.PI / 180.0D) * radius); 
        GL11.glEnd();
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_LINE_SMOOTH);
        GL11.glDisable(GL11.GL_LINE_SMOOTH);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glScaled(2.0D, 2.0D, 2.0D);
        GL11.glPopAttrib();
        GL11.glLineWidth(1);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.disableBlend();
    }
    
    public static void drawUnderRoundedRect(double x, double y, double x1, double y1, double radius, int color) {
    	GL11.glPushAttrib(0);
        GL11.glScaled(0.5D, 0.5D, 0.5D);
        x *= 2.0D;
        y *= 2.0D;
        x1 *= 2.0D;
        y1 *= 2.0D;
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        setColor(color);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        GL11.glBegin(GL11.GL_POLYGON);
        int i;
        for (i = 0; i <= 90; i += 3)
        	GL11.glVertex2d(x + 0 + Math.sin(i * Math.PI / 180.0D) * 0 * -1.0D, y + 0 + Math.cos(i * Math.PI / 180.0D) * 0 * -1.0D); 
        for (i = 90; i <= 180; i += 3)
          GL11.glVertex2d(x + radius + Math.sin(i * Math.PI / 180.0D) * radius * -1.0D, y1 - radius + Math.cos(i * Math.PI / 180.0D) * radius * -1.0D); 
        for (i = 0; i <= 90; i += 3)
        	GL11.glVertex2d(x1 - radius + Math.sin(i * Math.PI / 180.0D) * radius, y1 - radius + Math.cos(i * Math.PI / 180.0D) * radius); 
        for (i = 90; i <= 180; i += 3)
        	GL11.glVertex2d(x1 - 0 + Math.sin(i * Math.PI / 180.0D) * 0, y + 0 + Math.cos(i * Math.PI / 180.0D) * 0); 
        GL11.glEnd();
        GL11.glBegin(GL11.GL_LINE_LOOP);
        for (i = 0; i <= 90; i += 3)
        	GL11.glVertex2d(x + 0 + Math.sin(i * Math.PI / 180.0D) * 0 * -1.0D, y + 0 + Math.cos(i * Math.PI / 180.0D) * 0 * -1.0D); 
        for (i = 90; i <= 180; i += 3)
        	GL11.glVertex2d(x + radius + Math.sin(i * Math.PI / 180.0D) * radius * -1.0D, y1 - radius + Math.cos(i * Math.PI / 180.0D) * radius * -1.0D); 
        for (i = 0; i <= 90; i += 3)
        	GL11.glVertex2d(x1 - radius + Math.sin(i * Math.PI / 180.0D) * radius, y1 - radius + Math.cos(i * Math.PI / 180.0D) * radius); 
        for (i = 90; i <= 180; i += 3)
          GL11.glVertex2d(x1 - 0 + Math.sin(i * Math.PI / 180.0D) * 0, y + 0 + Math.cos(i * Math.PI / 180.0D) * 0); 
        GL11.glEnd();
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_LINE_SMOOTH);
        GL11.glDisable(GL11.GL_LINE_SMOOTH);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glScaled(2.0D, 2.0D, 2.0D);
        GL11.glPopAttrib();
        GL11.glLineWidth(1);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.disableBlend();
    }

    public static void enableGL2D() {
    	GL11.glDisable(2929);
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glDepthMask(true);
        GL11.glEnable(2848);
        GL11.glHint(3154, 4354);
        GL11.glHint(3155, 4354);
    }

    public static void disableGL2D() {
    	GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glEnable(2929);
        GL11.glDisable(2848);
        GL11.glHint(3154, 4352);
        GL11.glHint(3155, 4352);
    }
    
    public static void renderNewGuiBackground() {
    	ScaledResolution sr = new ScaledResolution(MineUtil.getUtilCore().getMCCore());
    	RenderUtils.drawRoundedRect(sr.getScaledWidth() / 2 - 230, 30, sr.getScaledWidth() / 2 + 230, 288, 18, new Color(10, 10, 10, 100).getRGB());
    	RenderUtils.drawRoundedRect(sr.getScaledWidth() / 2 - 230, 6, sr.getScaledWidth() / 2 + 230, 29, 18, new Color(10, 10, 10, 100).getRGB());
    }
    
    public static final ScaledResolution getResolution() {
    	return (ScaledResolution) new ScaledResolution(MineUtil.getUtilCore().getMCCore());
    }

}
