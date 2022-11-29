package net.minedevhd.mineutil.command.impl;

import java.awt.Desktop;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import net.labymod.utils.ModColor;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.command.Category;
import net.minedevhd.mineutil.command.Command;

public class Vote extends Command {

	public Vote() {
		super("Vote", "Vote", "Open GrieferGames Votepage", "vote", Category.OTHER);
	}

	@Override
	public void onCommand(String[] args, String command) {
		try {
			try {
				final Desktop desktop = Desktop.getDesktop();
				desktop.browse(new URI("https://minecraft-server.eu/vote/index/1A73C/" + mineUtil.getMinecraft().thePlayer.getName()));
				desktop.browse(new URI("https://www.labymod.net/de/dashboard"));
			} catch (URISyntaxException exception) {
				LabyNet.sendBrowserErrorMessage(mineUtil);
			}
		} catch (IOException exception) {
			LabyNet.sendBrowserErrorMessage(mineUtil);
		}
	}
	
	@Override
	public void update() {}
	
	@Override
	public boolean isActiv() {
		return false;
	}
	
}
