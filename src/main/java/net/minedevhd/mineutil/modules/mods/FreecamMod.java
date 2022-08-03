package net.minedevhd.mineutil.modules.mods;

import javax.vecmath.Vector2d;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.settings.UtilCore;

public class FreecamMod implements UtilCore {
	
	private static boolean activated = false;
	
	private static Minecraft mc = mineUtil.getMinecraft();
	private static EntityOtherPlayerMP cam = null;
	
	public static final void initCam() {
		if(isActivated()) {
			cam.rotationYaw = mc.thePlayer.rotationYaw;
			cam.rotationPitch = mc.thePlayer.rotationPitch;
			cam.rotationYawHead = mc.thePlayer.rotationYawHead;

//			Vector2d forwardBack = new Vector2d(Math.sin(-Math.toRadians(cam.rotationYaw)), Math.cos(-Math.toRadians(cam.rotationYaw)));
//			Vector2d leftRight = new Vector2d(Math.sin(-Math.toRadians(cam.rotationYaw + 98)), Math.cos(-Math.toRadians(cam.rotationYaw + 98)));
			
			if(mc.gameSettings.keyBindForward.isKeyDown()) {
//				cam.setPosition(cam.posX + 1 * forwardBack.x, cam.posY, cam.posZ + 1 * forwardBack.y);
	            cam.setPosition(cam.posX + Math.sin(-Math.toRadians(cam.rotationYaw)), cam.posY, cam.posZ + Math.cos(-Math.toRadians(cam.rotationYaw)));
			}
			
			if(mc.gameSettings.keyBindBack.isKeyDown()) {
//				cam.setPosition(cam.posX - forwardBack.x, cam.posY, cam.posZ - forwardBack.y);
	            cam.setPosition(cam.posX - Math.sin(-Math.toRadians(cam.rotationYaw)), cam.posY, cam.posZ - Math.cos(-Math.toRadians(cam.rotationYaw)));
			}
			
			if(mc.gameSettings.keyBindLeft.isKeyDown()) {
//				cam.setPosition(cam.posX - leftRight.x, cam.posY, cam.posZ - leftRight.y);
	            cam.setPosition(cam.posX + Math.sin(-Math.toRadians(cam.rotationYaw + 90)), cam.posY, cam.posZ + Math.cos(-Math.toRadians(cam.rotationYaw + 90)));
			}
			
			if(mc.gameSettings.keyBindRight.isKeyDown()) {
//				cam.setPosition(cam.posX + leftRight.x, cam.posY, cam.posZ + leftRight.y);
	            cam.setPosition(cam.posX - Math.sin(-Math.toRadians(cam.rotationYaw + 90)), cam.posY, cam.posZ - Math.cos(-Math.toRadians(cam.rotationYaw + 90)));
			}
			
			if(mc.gameSettings.keyBindSneak.isKeyDown()) {
				cam.setPosition(cam.posX, cam.posY - 1, cam.posZ);
	            cam.posY = cam.posY + 1;
			}
			
			if(mc.gameSettings.keyBindJump.isKeyDown()) {
				cam.setPosition(cam.posX, cam.posY + 1, cam.posZ);
	            cam.posY = cam.posY - 1;
			}
		}
	}
	
	private static EntityOtherPlayerMP getCam() {
		return cam;
	}
	
	private static void setCam(EntityOtherPlayerMP cam) {
		FreecamMod.cam = cam;
	}

	public static final boolean isActivated() {
		return activated;
	}

	public static final boolean setActivated(boolean activated) {
		FreecamMod.activated = activated;
		
		if(activated) {
			setCam(new EntityOtherPlayerMP(mc.theWorld, mc.thePlayer.getGameProfile()));
			mc.theWorld.addEntityToWorld(69428, getCam());
			mc.setRenderViewEntity(getCam());
			return true;
		}
		else {
			mc.setRenderViewEntity(mc.thePlayer);
			mc.theWorld.removeEntity(getCam());
			return true;
		}
	}

}
