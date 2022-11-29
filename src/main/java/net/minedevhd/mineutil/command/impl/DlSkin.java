package net.minedevhd.mineutil.command.impl;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

import net.labymod.main.LabyMod;
import net.labymod.utils.UUIDFetcher;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.command.Category;
import net.minedevhd.mineutil.command.Command;
import net.minedevhd.mineutil.command.CommandManager;
import net.minedevhd.mineutil.settings.UtilCore;

public class DlSkin extends Command implements UtilCore {

	public DlSkin() {
		super("DlSkin", "DownloadSkin", "Download current skin from players", "dlskin", Category.FUN);
	}
	
	@Override
	public void onCommand(String[] args, String command) {
		if(args.length >= 1) {
			try {
				try {
					final String uuid = UUIDFetcher.getUUID(args[0]).toString();
					LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() + "§7Fetching §athe UUID §7from Player §e" + args[0] + "§7...");
//					LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() + "§7The UUID from Player §e" + args[0] + " §7was found §8(§7" + uuid + "§8)§7! Now i can download his Skin...");
					
					final Desktop desktop = Desktop.getDesktop();
					desktop.browse(new URI("https://minotar.net/download/" + uuid));
					LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() + "§7Skin has been saved at your default download Folder!");
				} catch (URISyntaxException exception) {
					LabyNet.sendBrowserErrorMessage(MineUtil.getCore());
				}
			} catch (IOException exception) {
				LabyNet.sendBrowserErrorMessage(MineUtil.getCore());
			}
		}
		else {
			LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() + "§cSyntax§8: §e" + CommandManager.getPrefix() + this.getSyntax() + " <Name>");
		}
	}

	@Override
	public void update() {}

	@Override
	public boolean isActiv() {
		return false;
	}
	
}
