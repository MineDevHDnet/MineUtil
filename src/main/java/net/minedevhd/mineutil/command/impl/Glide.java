package net.minedevhd.mineutil.command.impl;

import net.labymod.main.LabyMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.command.Category;
import net.minedevhd.mineutil.command.Command;

public class Glide extends Command {

	public Glide() {
		super("Glide", "Glide [Vanilla]", "Glide in the air like a god", "glide", Category.MOVEMENT);
	}

	private static final Minecraft mc =  mineUtil.getMinecraft();
	private static final GameSettings gameSettings = mc.gameSettings;
	
	private boolean activated = false,
					activ = false;
	
	@Override
	public void onCommand(String[] args, String command) {
		LabyMod.getInstance().displayMessageInChat(transformMessage(this.getName(), this.toggle()));
	}
	
	@Override
	public void update() {
		if(this.isActivated()) {
			try {
				final double oldY = mc.thePlayer.motionY;
				final float oldJ = mc.thePlayer.jumpMovementFactor;

				if((mc.thePlayer.motionY < 0.0D) 
						&& (mc.thePlayer.isAirBorne) 
						&& (!mc.thePlayer.isInWater()) 
						&& (!mc.thePlayer.isInLava()) 
						&& (!mc.thePlayer.isOnLadder())) {
					mc.thePlayer.motionY = -.125D;
					mc.thePlayer.jumpMovementFactor *= 1.12337F;
				}
				else {
					mc.thePlayer.motionY = oldY;
					mc.thePlayer.jumpMovementFactor = oldJ;
				}
			} catch (Exception exception) {}
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
