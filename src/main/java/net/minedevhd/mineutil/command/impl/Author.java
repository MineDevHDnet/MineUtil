package net.minedevhd.mineutil.command.impl;

import java.awt.Desktop;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import net.labymod.utils.ModColor;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.command.Command;

public class Author extends Command {

	public Author() {
		super("Author", "Author", "Show the developer of MineUtil", "author", Category.OTHER);
	}

	@Override
	public void onCommand(String[] args, String command) {
		try {
			try {
				final Desktop desktop = Desktop.getDesktop();
				desktop.browse(new URI("https://laby.net/@MineDev_HD"));
			} catch (URISyntaxException exception) {
				LabyNet.sendBrowserErrorMessage(MineUtil.getUtilCore());
			}
		} catch (IOException exception) {
			LabyNet.sendBrowserErrorMessage(MineUtil.getUtilCore());
		}
	}
	
	@Override
	public void update() {}
	
	@Override
	public boolean isActivated() {
		return false;
	}
	
}
