package net.minedevhd.mineutil.command.impl;

import net.labymod.core.LabyModCore;
import net.labymod.main.LabyMod;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.command.Category;
import net.minedevhd.mineutil.command.Command;

public class Say extends Command {

	public Say() {
		super("Say", "Say", "Sends addon commands to global chat", "say", Category.PLAYER);
	}

	@Override
	public void onCommand(String[] args, String command) {
		if(args.length >= 1) {
			String message = "";
			
			for(int i = 0; i < args.length; i++) {
				message += args[i] + " ";
			}
			MineUtil.getCore().getMinecraft().thePlayer.sendChatMessage(message);
		}
	}

	@Override
	public void update() {}

	@Override
	public boolean isActiv() {
		return false;
	}

}
