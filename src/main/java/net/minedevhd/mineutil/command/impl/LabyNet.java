package net.minedevhd.mineutil.command.impl;

import net.labymod.main.LabyMod;
import net.labymod.utils.ModColor;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.command.Category;
import net.minedevhd.mineutil.command.Command;
import net.minedevhd.mineutil.command.CommandManager;

import java.awt.*;
import java.net.URI;

public class LabyNet extends Command {

	public LabyNet() {
		super("LabyNet", "LabyNet", "You can provide a profile", "labynet", Category.OTHER);
	}
	
	@Override
	public void onCommand(String[] args, String command) {
		if(args.length == 1) {
			try {
				if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
	                Desktop.getDesktop().browse(new URI("https://laby.net/@" + args[0]));
	                LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() + ModColor.YELLOW + args[0] + ModColor.GRAY + "'s profile has been opened in your browser.");
	            }
				else {
					this.sendBrowserErrorMessage(mineUtil);
				}
			} catch (Exception exception) {
				this.sendBrowserErrorMessage(mineUtil);
			}
		}
		else {
			LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() + "§cSyntax§8: §e" + CommandManager.getPrefix() + this.getSyntax() + " <username>");
		}
	}
	
	@Override
	public void update() {}
	
	@Override
	public boolean isActivated() {
		return false;
	}
	
	public static void sendBrowserErrorMessage(MineUtil mineUtil) {
		mineUtil.getApi().displayMessageInChat(mineUtil.getSettings().getPrefix() + "§cThe browser could not be opened!");
	}

}
