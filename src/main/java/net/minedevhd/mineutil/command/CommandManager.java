package net.minedevhd.mineutil.command;

import java.util.ArrayList;
import java.util.List;

import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.command.impl.*;

public class CommandManager {
	
	private static final List<Command> commands = new ArrayList<Command>();
	private static final String DEFAULT_PREFIX = ".";
	
	private static final MineUtil mineUtil = MineUtil.getUtilCore();
	
	public static final String getPrefix() {
		if(mineUtil.getSettings().getCommandPrefix() == "" 
				|| mineUtil.getSettings().getCommandPrefix() == null) {
			return DEFAULT_PREFIX;
		}
		return mineUtil.getSettings().getCommandPrefix();
	}
	
	public static final List<Command> getCommands() {
		return commands;
	}
	
	//TODO: changing help command & command-/module system
	public static void setup() {
		commands.clear();

		//OTHER
		commands.add(new Help());
		commands.add(new NBT());
		commands.add(new Join());
		commands.add(new Author());
		commands.add(new Reload());
		commands.add(new LabyNet());

//		commands.add(new CheckPlayers());
		
		//MOVEMENT
		commands.add(new Fly());
//		commands.add(new Step()); (cannot disable)
		commands.add(new Glide());
		commands.add(new Sneak());
		commands.add(new NoFall());
		commands.add(new Sprint());
		commands.add(new Parkour());
		commands.add(new Dolphin());
		commands.add(new Autowalk());
		
		//WORLD
		commands.add(new KillArmorStands());
		
		//FUN
		commands.add(new MoneyDropGrabber());
		
		//PLAYER
		commands.add(new AFK());
		commands.add(new Say());
//		commands.add(new FreeCam());
		commands.add(new AutoRespawn());
		
//		EXPLOIT
		commands.add(new Give());
		commands.add(new CmdBook());
//		commands.add(new Exploit()); /*(migrated crashskull + cickick into exploit command)*/
//		commands.add(new CheckCmd());
		commands.add(new Hologram());
		commands.add(new ArmorSpammer());
		commands.add(new MurderMystery());
	}
	
}
