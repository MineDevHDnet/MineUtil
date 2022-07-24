package net.minedevhd.mineutil.command.impl;

import net.labymod.main.LabyMod;
import net.labymod.utils.ModColor;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.command.Command;
import net.minedevhd.mineutil.command.CommandManager;

public class Join extends Command {

	public Join() {
		super("Join", "Join", "Join the original server from developer", "join", Category.OTHER);
	}

	private final MineUtil mineUtil = MineUtil.getUtilCore();
	
	@Override
	public void onCommand(String[] args, String command) {
		if(args.length == 1) {
			final String p = mineUtil.getSettings().getPrefix();
			
			LabyMod.getInstance().displayMessageInChat(p + "§aResolving SRV...");
			LabyMod.getInstance().displayMessageInChat(p + "§aStarting Netty Connection...");
			LabyMod.getInstance().displayMessageInChat(p + "§aResolving IP...");
			LabyMod.getInstance().displayMessageInChat(p + "§aConnecting...");
			LabyMod.getInstance().displayMessageInChat(p + "§aSending Login Packet...");
			LabyMod.getInstance().displayMessageInChat(p + "§aWaiting for response...");
			LabyMod.getInstance().displayMessageInChat(p + "§aVerifying Session...");
			LabyMod.getInstance().displayMessageInChat(p + "§aEncrypting...");
			LabyMod.getInstance().displayMessageInChat(p + "§aSuccess!");
			LabyMod.getInstance().displayMessageInChat(p + "§7Connect to §e" + args[0] + "§7.");
			LabyMod.getInstance().switchServer(args[0], true);
		}
		else {
			LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() + "§cSyntax§8: §e" + CommandManager.getPrefix() + this.getSyntax() + " <server-adress>");
		}
	}
	
	@Override
	public void update() {}

	@Override
	public boolean isActivated() {
		return false;
	}
	
}
