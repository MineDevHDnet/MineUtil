package net.minedevhd.mineutil.command.impl;

import net.labymod.main.LabyMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.command.Command;

public class Sneak extends Command {

	public Sneak() {
		super("Sneak", "Sneak [Key]", "Sneaks automaticly", "sneak", Category.MOVEMENT);
	}

	private static final Minecraft mc =  MineUtil.getUtilCore().getMCCore();
	private static final GameSettings gameSettings = mc.gameSettings;
	
	private boolean activated = false;
	
	@Override
	public void onCommand(String[] args, String command) {
		KeyBinding.setKeyBindState(gameSettings.keyBindSneak.getKeyCode(), this.toggle());
		LabyMod.getInstance().displayMessageInChat(transformMessage(this.getDisplayName(), this.isActivated()));
	}
	
	@Override
	public void update() {
		if(activated && !mc.thePlayer.isSprinting()) 
			KeyBinding.setKeyBindState(gameSettings.keyBindSneak.getKeyCode(), true);
	}
	
	private boolean toggle() {
		return this.activated = !this.activated;
	}
	
	@Override
	public boolean isActivated() {
		return this.activated;
	}

}
