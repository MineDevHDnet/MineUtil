package net.minedevhd.mineutil.modules.griefergames;

import java.awt.Color;

import net.labymod.api.events.MessageReceiveEvent;
import net.labymod.core.LabyModCore;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.command.impl.AFK;
import net.minedevhd.mineutil.settings.UtilCore;
import net.minedevhd.mineutil.utils.discord.Discord;

public class AFKMSGModule implements UtilCore {
	
	private static final AFK AFK = new AFK();
	
	public static void initModule() {
		mineUtil.getApi().getEventManager().register((MessageReceiveEvent) new MessageReceiveEvent() {
			@Override
			public boolean onReceive(String formatted, String unformatted) {
				if(mineUtil.getSettings().isModEnabled() && mineUtil.isOnGrieferGames()) {
					if(AFK.isActivated()) {
						if(formatted.startsWith("§r§6[§r") && formatted.contains("§r§6 -> §r§cmir§r§6] §r")/* && formatted.endsWith("§r")*/) {
							final String message = mineUtil.getSettings().getModGGAFKMSGMessage(),
										 webhook = mineUtil.getSettings().getModGGAFKMSGWebhook();
							
							LabyModCore.getMinecraft().getPlayer().sendChatMessage("/r " + (message != null ? message : "Hey, tut mir leid. Ich bin gerade AFK!"));
							try {
								if(!webhook.equals("null"))
									Discord.writeMV((webhook != null ? webhook : "null"), "Message incoming", unformatted, Color.WHITE);
							} catch (Exception exception) {}
						}
					}
				}
				return false;
			}
		});
	}
	
}
