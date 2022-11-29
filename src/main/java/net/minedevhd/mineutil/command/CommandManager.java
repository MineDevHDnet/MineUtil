package net.minedevhd.mineutil.command;

import java.util.ArrayList;
import java.util.List;

import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.command.impl.*;
import net.minedevhd.mineutil.settings.UtilCore;

public class CommandManager implements UtilCore {
	
	private static final List<Command> commands = new ArrayList<Command>();
	private static final String DEFAULT_PREFIX = ".";
	
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
		commands.add(new Credits());
		commands.add(new Vote());
//		commands.add(new Werbung()); (it's a little bit buggy) ;§

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
		commands.add(new DlSkin());
		
		//PLAYER
		commands.add(new AFK());
		commands.add(new Say());
//		commands.add(new FreeCam()); (cannot move)
		commands.add(new AutoRespawn());
		commands.add(new Autobreak());
		commands.add(new AutouseItem());
		commands.add(new Spammer());
		
//		EXPLOIT
		commands.add(new Give());
		commands.add(new CmdBook());
//		commands.add(new Exploit()); /*(migrated crashskull + cickick into exploit command)*/
//		commands.add(new CheckCmd()); (sends invalid packet)
		commands.add(new Hologram());
		commands.add(new ArmorSpammer());
		commands.add(new MurderMystery());
	}
	
}
