package net.minedevhd.mineutil.command.impl;

import net.labymod.main.LabyMod;
import net.labymod.utils.ModColor;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.command.Command;

public class Autowalk extends Command {

	public Autowalk() {
		super("Autowalk", "Autowalk", "Walks automaticly", "autowalk");
	}

	private static final GameSettings gameSettings = MineUtil.getUtilCore().getMCCore().gameSettings;
	
	private boolean activated = false;
	
	@Override
	public void onCommand(String[] args, String command) {
		KeyBinding.setKeyBindState(this.gameSettings.keyBindForward.getKeyCode(), this.toggle());
		LabyMod.getInstance().displayMessageInChat(transformMessage(this.getDisplayName(), this.isActivated()));
	}
	
	@Override
	public void update() {
		if(this.isActivated()) KeyBinding.setKeyBindState(this.gameSettings.keyBindForward.getKeyCode(), true);
	}
	
	private boolean toggle() {
		return this.activated = !this.activated;
	}

	@Override
	public boolean isActivated() {
		return this.activated;
	}

}
