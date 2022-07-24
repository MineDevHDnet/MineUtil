package net.minedevhd.mineutil.command.impl;

import net.labymod.main.LabyMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.command.Command;

public class Sprint extends Command {

	public Sprint() {
		super("Sprint", "Sprint [Vanilla]", "Sprints automaticly", "sprint", Category.MOVEMENT);
	}

	private static final Minecraft mc =  MineUtil.getUtilCore().getMCCore();
	private static final GameSettings gameSettings = mc.gameSettings;
	
	private boolean activated = false;
	
	@Override
	public void onCommand(String[] args, String command) {
		KeyBinding.setKeyBindState(gameSettings.keyBindSprint.getKeyCode(), this.toggle());
		LabyMod.getInstance().displayMessageInChat(transformMessage(this.getDisplayName(), this.isActivated()));
	}
	
	@Override
	public void update() {
		if(activated && !mc.thePlayer.isSprinting()) 
			KeyBinding.setKeyBindState(gameSettings.keyBindSprint.getKeyCode(), true);
	}
	
	private boolean toggle() {
		return this.activated = !this.activated;
	}
	
	@Override
	public boolean isActivated() {
		return this.activated;
	}

}
