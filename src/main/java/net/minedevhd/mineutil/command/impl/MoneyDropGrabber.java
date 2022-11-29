package net.minedevhd.mineutil.command.impl;

import net.labymod.main.LabyMod;
import net.minedevhd.mineutil.command.Category;
import net.minedevhd.mineutil.command.Command;

public class MoneyDropGrabber extends Command {

	public MoneyDropGrabber() {
		super("MoneyDropGrabber", "Money-Drop Grabber", "Picks up every money drop", "mdg", Category.FUN);
	}
	
	private boolean activated = false;

	@Override
	public void onCommand(String[] args, String command) {
		LabyMod.getInstance().displayMessageInChat(transformMessage(this.getDisplayName(), this.toggle()));
	}
	
	@Override
	public void update() {}
	
	private boolean toggle() {
		return this.activated = !this.activated;
	}

	@Override
	public boolean isActiv() {
		return this.activated;
	}
	
}
