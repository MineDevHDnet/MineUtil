package net.minedevhd.mineutil.command.impl;

import net.labymod.main.LabyMod;
import net.labymod.utils.ModColor;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.command.Command;
import net.minedevhd.mineutil.modules.mods.FreeCamMod;

public class FreeCam extends Command {

	public FreeCam() {
		super("FreeCam", "FreeCam", "Toggles your FreeCam-Mode", "freecam");
	}

	@Override
	public void onCommand(String[] args, String command) {
		FreeCamMod.setActivated(!FreeCamMod.isActivated());
		LabyMod.getInstance().displayMessageInChat(transformMessage(this.getDisplayName(), FreeCamMod.isActivated()));
	}
	
	@Override
	public void update() {}
	
	@Override
	public boolean isActivated() {
		return FreeCamMod.isActivated();
	}

}
