package net.minedevhd.mineutil.command.impl;

import net.labymod.main.LabyMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.command.Command;

public class Parkour extends Command {

	public Parkour() {
		super("Parkour", "Parkour [Vanilla]", "Jumps automaticly", "parkour", Category.MOVEMENT);
	}

	private static final Minecraft mc =  MineUtil.getUtilCore().getMCCore();
	private static final GameSettings gameSettings = mc.gameSettings;
	
	private boolean activated = false;
	
	@Override
	public void onCommand(String[] args, String command) {
		LabyMod.getInstance().displayMessageInChat(transformMessage(this.getDisplayName(), this.toggle()));
	}
	
	@Override
	public void update() {
		if(activated) {
			if(mc.thePlayer.onGround 
					&& !mc.thePlayer.isSneaking() 
					&& !mc.gameSettings.keyBindSneak.isPressed() 
					&& mc.theWorld.getCollidingBoundingBoxes((Entity) mc.thePlayer, 
							mc.thePlayer.getEntityBoundingBox().offset(0.0D, -0.5D, 0.0D).expand(-0.001D, 0.0D, -0.001D)).isEmpty()) {
				mc.thePlayer.jump();
			}
		}
	}
	
	private boolean toggle() {
		return this.activated = !this.activated;
	}

	@Override
	public boolean isActivated() {
		return this.activated;
	}

}
