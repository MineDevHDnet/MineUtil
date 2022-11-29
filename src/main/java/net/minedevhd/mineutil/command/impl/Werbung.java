package net.minedevhd.mineutil.command.impl;

import net.labymod.api.events.MessageReceiveEvent;
import net.labymod.main.LabyMod;
import net.minedevhd.mineutil.command.Category;
import net.minedevhd.mineutil.command.Command;
import net.minedevhd.mineutil.command.CommandManager;
import net.minedevhd.mineutil.settings.UtilCore;

public class Werbung extends Command implements UtilCore {

	public Werbung() {
		super("Werbung", "Werbung", "Runs on every Citybuild and post the /status-Message", "werbung", Category.OTHER);
	}
	
	private static String Citybuild = "none";
	public static Integer CB = 0;
	
	public static boolean activated,
						  running;

	@Override
	public void onCommand(String[] args, String command) {
		if(args.length >= 1) {
			final String endCb = args[0].toLowerCase();
			this.setCityBuild(endCb);
			this.setRunning(true);
			LabyMod.getInstance().displayMessageInChat(transformMessage(this.getName(), this.toggle()));
		}
		else {
			LabyMod.getInstance().displayMessageInChat(
					mineUtil.getSettings().getPrefix() + "§cSyntax§8: §e" 
							+ CommandManager.getPrefix() + this.getSyntax() + " <your current CB>");
		}
	}

	@Override
	public void update() {
		if(activated && isRunning() && CB != 0) {
			mineUtil.sendQueued("/switch cb1");
		}
	}
	
	public boolean toggle() {
		return this.activated = !this.activated;
	}

	@Override
	public boolean isActiv() {
		return this.activated;
	}
	
	public static boolean isRunning() {
		return running;
	}
	
	public static void setRunning(final boolean enable) {
		running = enable;
	}
	
	public static String getCityBuild() {
		return Citybuild;
	}
	
	public static void setCityBuild(final String cityBuild) {
		Citybuild = cityBuild;
	}
	
}
