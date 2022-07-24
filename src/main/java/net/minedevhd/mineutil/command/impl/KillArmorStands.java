package net.minedevhd.mineutil.command.impl;

import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.command.Command;

public class KillArmorStands extends Command {

	public KillArmorStands() {
		super("KillArmorStands", "KillArmorStands", "Kills all armorstands on the world", "kas", Category.WORLD);
	}

	@Override
	public void onCommand(String[] args, String command) {
		if(args.length >= 0) {
			MineUtil.getUtilCore().getMCCore().thePlayer.sendChatMessage("/kill @e[type=ArmorStand]");
		}
	}

	@Override
	public void update() {}

	@Override
	public boolean isActivated() {
		return false;
	}

}
