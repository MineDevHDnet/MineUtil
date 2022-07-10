package net.minedevhd.mineutil.command.impl;

import java.util.Objects;

import net.labymod.main.LabyMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.command.Command;

public class AutoRespawn extends Command {

	public AutoRespawn() {
		super("AutoRespawn", "AutoRespawn [Packets]", "Respawn automatically", "autorespawn");
	}

	private static final Minecraft mc = MineUtil.getUtilCore().getMCCore();
	
	private boolean activated = false;
	
	@Override
	public void onCommand(String[] args, String command) {
		LabyMod.getInstance().displayMessageInChat(transformMessage(this.getDisplayName(), this.toggle()));
	}
	
	@Override
	public void update() {
		if(this.isActivated() && mc.thePlayer.isDead) mc.thePlayer.respawnPlayer();	
	}
	
	public boolean toggle() {
		return this.activated = !this.activated;
	}

	@Override
	public boolean isActivated() {
		return this.activated;
	}

}
