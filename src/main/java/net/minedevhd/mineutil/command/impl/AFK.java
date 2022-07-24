package net.minedevhd.mineutil.command.impl;

import net.labymod.main.LabyMod;
import net.labymod.utils.ModColor;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.command.Command;

public class AFK extends Command {

	public AFK() {
		super("AFK", "AFK [Old]", "This command is disabled", "afk", Category.OTHER);
	}
	
	private boolean activated = false;

	@Override
	public void onCommand(String[] args, String command) {
		LabyMod.getInstance().displayMessageInChat(transformMessage(this.getName(), this.toggle()));
	}
	
	@Override
	public void update() {}
	
	private boolean toggle() {
		return this.activated = !this.activated;
	}
	
	@Override
	public boolean isActivated() {
		return this.activated;
	}

}
