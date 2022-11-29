package net.minedevhd.mineutil.modules.griefergames;

import net.labymod.api.events.MessageReceiveEvent;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.settings.ModSettings;
import net.minedevhd.mineutil.settings.UtilCore;

public class RealMoneyModule implements UtilCore {

	private static final ModSettings settings = mineUtil.getSettings();
	
	public static void initModule() {
		mineUtil.getApi().getEventManager().register((MessageReceiveEvent) new MessageReceiveEvent() {
			@Override
			public boolean onReceive(String formatted, String unformatted) {
				if(mineUtil.getSettings().isModEnabled() && (mineUtil.isOnGrieferGames())) {
					if(formatted.contains("§r§ahat dir $") && formatted.endsWith("gegeben.§r")) {
						if(!unformatted.contains("»") && !unformatted.contains(":"))
							mineUtil.getApi().displayMessageInChat(formatted + " §a" + settings.getModRealMoney_Real().replace("&l", "§l"));
						else
							mineUtil.getApi().displayMessageInChat(formatted + " §c" + settings.getModRealMoney_Fake().replace("&l", "§l"));
						return true;
					}
				}
				return false;
			}
		});		
	}
	
}
