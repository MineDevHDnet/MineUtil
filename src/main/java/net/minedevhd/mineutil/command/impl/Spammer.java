package net.minedevhd.mineutil.command.impl;

import java.util.Timer;
import java.util.TimerTask;

import net.labymod.main.LabyMod;
import net.minedevhd.mineutil.command.Category;
import net.minedevhd.mineutil.command.Command;
import net.minedevhd.mineutil.command.CommandManager;
import net.minedevhd.mineutil.settings.UtilCore;
import net.minedevhd.mineutil.settings.ModSettings.Citybuilds;
import net.minedevhd.mineutil.utils.CbAutoJoin;

public class Spammer extends Command implements UtilCore {

	public Spammer() {
		super("Spammer", "Spammer [Singletake]", "Automatically buys items from a bot of your choice", "spammer", Category.PLAYER);
	}
	
	private Timer timer;
	
	private Integer secondsLeft;
	private static Integer delay = 80;
	
	private boolean activated = false;
	
	private String spamMessage = "";

	@Override
	public void onCommand(String[] args, String command) {
		if(args.length < 2) {
			if(!this.spamMessage.isEmpty()) {
				if(this.delay != null || this.delay != 0) {
					LabyMod.getInstance().displayMessageInChat(transformMessage(this.getDisplayName(), this.toggle()));
				}
				else {
					LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() + "§cYou must first specify a delay (80 is default).");
					LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() + "§cSyntax§8: §e" + CommandManager.getPrefix() + this.getSyntax() + " setdelay <Delay>");
				}
			}
			else {
				LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() + "§cYou must first specify a command.");
				LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() + "§cSyntax§8: §e" + CommandManager.getPrefix() + this.getSyntax() + " setmessage <Command>");
			}
		}
		else
			if(args.length >= 2) {
				if(args[0].equalsIgnoreCase("setmessage")) {
					if(command.split(" ").length > 0) {
						this.spamMessage = command.substring(19);
						LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() + "§7Spam-Message set to §e" + this.spamMessage);
					}
				}
				else
					if(args[0].equalsIgnoreCase("setdelay")) {
						try {
							this.delay = Integer.valueOf(args[1]);
							if(this.delay > 0 && this.delay < 400)
								LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() + "§7Spam-Delay set to §e" + this.delay + (this.delay == 80 ? " (default)" : ""));
							else
								LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() + "§cThe Number specified must be between §e1 and 399§7!");
						} catch (Exception exception) {}
					}
					else {
						LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() + "§cSyntax§8: §e" + CommandManager.getPrefix() + this.getSyntax() + " setmessage <Command>");
						LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() + "§cSyntax§8: §e" + CommandManager.getPrefix() + this.getSyntax() + " setdelay <Delay>");
					}
			}
	}

	@Override
	public void update() {
		if(!this.isActiv()) return;
		
		if(secondsLeft == null) secondsLeft = delay;
		
		(timer = new Timer()).schedule(new TimerTask() {
			@Override
			public void run() {
				secondsLeft--;
				switch (secondsLeft) {
				case 0:
					mineUtil.sendQueued(spamMessage);
					secondsLeft = delay;
					break;
				default:
					break;
				}
			}
		}, 10L);
	}
	
	private boolean toggle() {
		return this.activated = !this.activated;
	}

	@Override
	public boolean isActiv() {
		return this.activated;
	}

}
