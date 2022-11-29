package net.minedevhd.mineutil.command.impl;

import net.labymod.main.LabyMod;
import net.labymod.utils.ModColor;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.command.Category;
import net.minedevhd.mineutil.command.Command;

public class AutouseItem extends Command {

	public AutouseItem() {
		super("AutouseItem", "AutouseItem", "useItems automaticly", "autouseItem", Category.PLAYER);
	}

	private static final GameSettings gameSettings = mineUtil.getMinecraft().gameSettings;
	
	private boolean activated = false;
	
	@Override
	public void onCommand(String[] args, String command) {
		KeyBinding.setKeyBindState(this.gameSettings.keyBindUseItem.getKeyCode(), this.toggle());
		LabyMod.getInstance().displayMessageInChat(transformMessage(this.getDisplayName(), this.isActiv()));
	}
	
	@Override
	public void update() {
		if(this.isActiv()) KeyBinding.setKeyBindState(this.gameSettings.keyBindUseItem.getKeyCode(), true);
	}
	
	private boolean toggle() {
		return this.activated = !this.activated;
	}

	@Override
	public boolean isActiv() {
		return this.activated;
	}

}
