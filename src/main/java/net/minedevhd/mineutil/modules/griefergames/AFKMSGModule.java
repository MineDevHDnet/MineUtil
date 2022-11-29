package net.minedevhd.mineutil.modules.griefergames;

import java.awt.Color;

import net.labymod.api.events.MessageReceiveEvent;
import net.labymod.core.LabyModCore;
import net.labymod.utils.UUIDFetcher;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.command.impl.AFK;
import net.minedevhd.mineutil.settings.UtilCore;
import net.minedevhd.mineutil.utils.discord.Discord;

public class AFKMSGModule implements UtilCore {
	
	public static void initModule() {
		mineUtil.getApi().getEventManager().register((MessageReceiveEvent) new MessageReceiveEvent() {
			@Override
			public boolean onReceive(String formatted, String unformatted) {
				final AFK AFK = new AFK();
				if(mineUtil.getSettings().isModEnabled() && mineUtil.isOnGrieferGames() && AFK.isActiv()) {
					if(formatted.contains("§r§6[§r") && formatted.contains("§r§6 -> §r§cmir§r§6]") && formatted.endsWith("§r")) {
						final String message = mineUtil.getSettings().getModGGAFKMSGMessage();
						final String webhook = mineUtil.getSettings().getModGGAFKMSGWebhook();

						String msg = "",
							   username = "";
						String[] args = unformatted.split(" ");
						
						for(int i = 5; i < args.length; i++)
							msg += args[i] + " ";
						
						for(int i = 0; i < args.length; i++) {
							username = args[2];
						}
						
						if(!webhook.equals("null")) {
							final UUIDFetcher uuidFetcher = new UUIDFetcher();
							Discord.write(webhook, "/msg (" + username + ")", "Message: " + msg, uuidFetcher.getUUID(username), Color.WHITE);
						}
						mineUtil.sendQueued("/msg " + username + " " + (message.isEmpty() || message != null ? message : "Hey, Sorry. Ich bin gerade AFK!"));
					}
				}
				return false;
			}
		});
	}
	
}
