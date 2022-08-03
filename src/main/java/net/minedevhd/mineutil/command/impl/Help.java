package net.minedevhd.mineutil.command.impl;

import net.labymod.api.LabyModAPI;
import net.labymod.utils.ModColor;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.command.Category;
import net.minedevhd.mineutil.command.Command;
import net.minedevhd.mineutil.command.CommandManager;
import net.minedevhd.mineutil.utils.discord.Discord;

public class Help extends Command {
	
	public Help() {
		super("Help", "Help", "Show Command help", "help", Category.OTHER);
	}
	
	public final LabyModAPI API = MineUtil.getCore().getApi();
	
	public final String TITLE = "§8§m----§r§8[ §6Help-Center §8]§m----§r";
	
	public Integer count = 0;
	
	@Override
	public void onCommand(String[] args, String command) {
		this.API.displayMessageInChat(this.TITLE);
		
		this.count = 0;
		for(Command cmds : CommandManager.getCommands()) {
			if(!cmds.getName().contains("Flight")) {
				this.draw(cmds.getSyntax(), cmds.getDescription());
			}
		}
	}
	
	@Override
	public void update() {}
	
	@Override
	public boolean isActivated() {
		return false;
	}
	
	public void draw(String mod, String desc) {
		this.count++;
		this.API.displayMessageInChat("§8[§b" + count + "§8] §e§l" + CommandManager.getPrefix() + mod + " §8- §7" + desc + ".");
	}

}
