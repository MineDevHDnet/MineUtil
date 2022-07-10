package net.minedevhd.mineutil.command.impl;

import net.labymod.main.LabyMod;
import net.labymod.utils.ModColor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.command.Command;
import net.minedevhd.mineutil.command.CommandManager;

public class Reload extends Command {

	public Reload() {
		super("Reload", "Reload", "Reload all Commands", "reload");
	}

	private static final MineUtil mineUtil =  MineUtil.getUtilCore();

	@Override
	public void onCommand(String[] args, String command) {
		CommandManager.setup();
		LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() + "§bAll commands has been reloaded.");
	}
	
	@Override
	public void update() {}

	@Override
	public boolean isActivated() {
		return false;
	}

}
