package net.minedevhd.mineutil.command.impl;

import net.labymod.main.LabyMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.command.Command;

public class Step extends Command {

	public Step() {
		super("Step", "Step [Vanilla]", "Step blocks instantly", "step", Category.MOVEMENT);
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
		if(this.isActivated()) {
			if((mc.thePlayer.isCollidedHorizontally) && (mc.thePlayer.onGround)) {
				double x = mc.thePlayer.posX;
				double y = mc.thePlayer.posY;
				double z = mc.thePlayer.posZ;
				
				mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition(x, y + 0.42, z, mc.thePlayer.onGround));
				mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition(x, y + 0.72, z, mc.thePlayer.onGround));
				mc.thePlayer.stepHeight = 1.0F;
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
