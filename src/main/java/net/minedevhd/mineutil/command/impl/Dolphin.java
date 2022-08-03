package net.minedevhd.mineutil.command.impl;

import net.labymod.main.LabyMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.command.Category;
import net.minedevhd.mineutil.command.Command;

public class Dolphin extends Command {

	public Dolphin() {
		super("Dolphin", "Dolphin [Vanilla]", "Move in the water like a dolphin", "dolphin", Category.MOVEMENT);
	}

	private static final Minecraft mc =  mineUtil.getMinecraft();
	private static final GameSettings gameSettings = mc.gameSettings;
	
	private boolean activated = false;
	
	@Override
	public void onCommand(String[] args, String command) {
		LabyMod.getInstance().displayMessageInChat(transformMessage(this.getName(), this.toggle()));
	}
	
	@Override
	public void update() {
		if(this.isActivated()) {
			if(mc.thePlayer.isInWater()) {
				mc.thePlayer.motionY += 0.04;
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
