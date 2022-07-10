package net.minedevhd.mineutil.modules.griefergames;

import net.labymod.api.events.MessageReceiveEvent;
import net.labymod.core.LabyModCore;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.command.impl.AFK;
import net.minedevhd.mineutil.utils.discord.Discord;

public class AFKMSGModule {
	
	private static final AFK AFK = new AFK();
	
	public static void init(final MineUtil mineUtil) {
		mineUtil.getApi().getEventManager().register((MessageReceiveEvent) new MessageReceiveEvent() {
			@Override
			public boolean onReceive(String formatted, String unformatted) {
				if(mineUtil.getSettings().getModEnabled() && mineUtil.isOnGrieferGames()) {
					if(AFK.isActivated()) {
						if(formatted.startsWith("§r§6[§r") && formatted.contains("§r§6 -> §r§cmir§r§6] §r") && formatted.endsWith("§r")) {
							final String message = mineUtil.getSettings().getModGGAFKMSGMessage();
							final String webhook = mineUtil.getSettings().getModGGAFKMSGWebhook();
							
							LabyModCore.getMinecraft().getPlayer().sendChatMessage("/r " + (message != null ? message : "Hey, tut mir leid. Ich bin gerade AFK!"));
							Discord.write((webhook != null ? webhook : "null"), "Message incoming", unformatted);
						}
					}
				}
				return false;
			}
		});
	}
	
}
