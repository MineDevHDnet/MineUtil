package net.minedevhd.mineutil.modules.mods;

import javax.vecmath.Vector2d;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minedevhd.mineutil.MineUtil;

public class FreeCamMod {
	
	private static boolean activated = false;
	
	private static Minecraft mc = MineUtil.getUtilCore().getMCCore();
	private static EntityOtherPlayerMP cam = null;
	
	public static final void initCam() {
		if(isActivated()) {
			getCam().rotationYaw = mc.thePlayer.rotationYaw;
			getCam().rotationPitch = mc.thePlayer.rotationPitch;
			getCam().rotationYawHead = mc.thePlayer.rotationYawHead;

			Vector2d forwardBack = new Vector2d(Math.sin(-Math.toRadians(getCam().rotationYaw)), Math.cos(-Math.toRadians(getCam().rotationYaw)));
			Vector2d leftRight = new Vector2d(Math.sin(-Math.toRadians(getCam().rotationYaw + 98)), Math.cos(-Math.toRadians(getCam().rotationYaw + 98)));
			
			if(mc.gameSettings.keyBindForward.isKeyDown()) {
				getCam().setPosition(getCam().posX + 1 * forwardBack.x, getCam().posY, getCam().posZ + 1 * forwardBack.y);
			}
			
			if(mc.gameSettings.keyBindBack.isKeyDown()) {
				getCam().setPosition(getCam().posX - forwardBack.x, getCam().posY, getCam().posZ - forwardBack.y);
			}
			
			if(mc.gameSettings.keyBindLeft.isKeyDown()) {
				getCam().setPosition(getCam().posX - leftRight.x, getCam().posY, getCam().posZ - leftRight.y);
			}
			
			if(mc.gameSettings.keyBindRight.isKeyDown()) {
				getCam().setPosition(getCam().posX + leftRight.x, getCam().posY, getCam().posZ + leftRight.y);	
			}
			
			if(mc.gameSettings.keyBindSneak.isKeyDown()) {
				getCam().setPosition(getCam().posX, getCam().posY - 1, getCam().posZ);	
			}
			
			if(mc.gameSettings.keyBindJump.isKeyDown()) {
				getCam().setPosition(getCam().posX, getCam().posY + 1, getCam().posZ);	
			}
		}
	}
	
	private static EntityOtherPlayerMP getCam() {
		return cam;
	}
	
	private static void setCam(EntityOtherPlayerMP cam) {
		FreeCamMod.cam = cam;
	}

	public static final boolean isActivated() {
		return activated;
	}

	public static final boolean setActivated(boolean activated) {
		FreeCamMod.activated = activated;
		
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
