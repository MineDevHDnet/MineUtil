package net.minedevhd.mineutil.modules.griefergames;

import java.util.Timer;
import java.util.TimerTask;
import java.awt.Color;

import net.labymod.api.events.MessageReceiveEvent;
import net.labymod.utils.UUIDFetcher;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.KeyBinding;
import net.minedevhd.mineutil.settings.UtilCore;
import net.minedevhd.mineutil.settings.ModSettings.Citybuilds;
import net.minedevhd.mineutil.utils.CbAutoJoin;
import net.minedevhd.mineutil.utils.discord.Discord;
import scala.actors.threadpool.Arrays;

public class GlobalchatDiscordWriter implements UtilCore {
	
	public static void initModule() {
		mineUtil.getApi().getEventManager().register((MessageReceiveEvent) new MessageReceiveEvent() {

			@Override
			public boolean onReceive(String formatted, String unformatted) {
				if(mineUtil.isOnGrieferGames() && mineUtil.getSettings().isModGGGlobalchatWriter()) {
					if(unformatted.startsWith("@")) {
						final String webhook = mineUtil.getSettings().getModGGGlobalchatWriterWebhook();
						
						String msg = "",
							   username = "";
						String[] args = unformatted.split(" ");
						
						for(int i = 5; i < args.length; i++)
							msg += args[i] + " ";
						
						for(int i = 0; i < args.length; i++) {
							username = args[3];
						}
						
						if(!webhook.equals("null")) {
							final UUIDFetcher uuidFetcher = new UUIDFetcher();
							Discord.write(webhook, "Globalchat (" + username + ")", "Message: " + msg, uuidFetcher.getUUID(username), Color.WHITE);
						}
					}
				}
				return false;
			}
		});
	}

}
