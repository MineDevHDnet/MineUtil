package net.minedevhd.mineutil.modules.griefergames;

import java.util.Random;

import net.labymod.api.events.MessageReceiveEvent;
import net.labymod.core.LabyModCore;
import net.labymod.main.LabyMod;
import net.minedevhd.mineutil.MineUtil;

public class MysteryModModule {
	
	public static void register(final MineUtil mineUtil) {
		mineUtil.getApi().getEventManager().register((MessageReceiveEvent) new MessageReceiveEvent() {
			@Override
			public boolean onReceive(String formatted, String unformatted) {
				if(mineUtil.getSettings().getModEnabled() && (mineUtil.isOnGrieferGames())) {
					if(formatted.contains("Wir haben erkannt, dass du MysteryMod benutzt!")) {
						LabyMod.getInstance().getGuiCustomAchievement().displayAchievement("GrieferGames", "MysteryMod-Proxy ist aktiv!");
						return true;
					}
					
					if(formatted.contains("+ MysteryMod Moneydrop Bonus") 
							|| formatted.contains("+ MysteryMod Kristalle Bonus")) {
						return true;
					}
					
					if(formatted.contains("Ohje, du benutzt noch kein MysteryMod!")) {
						LabyMod.getInstance().getGuiCustomAchievement().displayAchievement("GrieferGames", "MysteryMod-Proxy ist inaktiv!");
						return true;
					}
				}
				return false;
			}
		});
	}

}
