package net.minedevhd.mineutil.modules.griefergames;

import java.util.Random;

import net.labymod.api.events.MessageReceiveEvent;
import net.labymod.core.LabyModCore;
import net.labymod.main.LabyMod;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.settings.UtilCore;

public class MysteryModModule implements UtilCore {
	
	public static void initModule() {
		mineUtil.getApi().getEventManager().register((MessageReceiveEvent) new MessageReceiveEvent() {
			@Override
			public boolean onReceive(String formatted, String unformatted) {
				if(mineUtil.getSettings().isModEnabled() && (mineUtil.isOnGrieferGames())) {
					if(unformatted.contains("[MysteryMod] Wir haben erkannt, dass du MysteryMod benutzt!")
							|| unformatted.contains("[MysteryMod] + MysteryMod Moneydrop Bonus")
							|| unformatted.contains("[MysteryMod] + MysteryMod Kristalle Bonus")) {
						LabyMod.getInstance().getGuiCustomAchievement().displayAchievement("GrieferGames", "MysteryMod-Proxy ist aktiv!");
						return true;
					}
					
					if(formatted.contains("[MysteryMod] Ohje, du benutzt noch kein MysteryMod!")) {
						LabyMod.getInstance().getGuiCustomAchievement().displayAchievement("GrieferGames", "MysteryMod-Proxy ist inaktiv!");
						return true;
					}
					
					if(unformatted.contains("[MysteryMod] Du hast")
							&& unformatted.contains("Kristalle erhalten, weil MysteryMod benutzt und")) {
						LabyMod.getInstance().getGuiCustomAchievement().displayAchievement("GrieferGames", "+" + unformatted.charAt(21) + " Kristalle erhalten!");
						return true;
					}
				}
				return false;
			}
		});
	}

}
