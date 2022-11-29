package net.minedevhd.mineutil.command.impl;

import net.labymod.main.LabyMod;
import net.labymod.utils.ModColor;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.command.Category;
import net.minedevhd.mineutil.command.Command;
import net.minedevhd.mineutil.modules.mods.FreecamMod;

public class FreeCam extends Command {

	public FreeCam() {
		super("FreeCam", "FreeCam", "Toggles your FreeCam-Mode", "freecam", Category.PLAYER);
	}

	@Override
	public void onCommand(String[] args, String command) {
		FreecamMod.setActivated(!FreecamMod.isActivated());
		LabyMod.getInstance().displayMessageInChat(transformMessage(this.getDisplayName(), FreecamMod.isActivated()));
	}
	
	@Override
	public void update() {}
	
	@Override
	public boolean isActiv() {
		return FreecamMod.isActivated();
	}

}
