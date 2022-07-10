package net.minedevhd.mineutil.modules.griefergames;

import net.labymod.api.events.MessageReceiveEvent;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.settings.ModSettings;

public class RealMoneyModule {

	private static final ModSettings settings = MineUtil.getUtilCore().getSettings();
	
	public static void init(final MineUtil mineUtil) {
		mineUtil.getApi().getEventManager().register((MessageReceiveEvent) new MessageReceiveEvent() {
			@Override
			public boolean onReceive(String formatted, String unformatted) {
				if(mineUtil.getSettings().getModEnabled() && (mineUtil.isOnGrieferGames())) {
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
