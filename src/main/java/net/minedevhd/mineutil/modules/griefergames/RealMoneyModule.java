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
						final String message = formatted;

						if(!unformatted.contains("»"))
							mineUtil.getApi().displayMessageInChat(message + " §a§l| " + settings.getModRealMoney_Real());
						else
							mineUtil.getApi().displayMessageInChat(message + " §c§l| " + settings.getModRealMoney_Fake());
						return true;
					}
				}
				return false;
			}
		});		
	}
	
}
