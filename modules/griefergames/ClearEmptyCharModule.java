package net.minedevhd.mineutil.modules.griefergames;

import net.labymod.api.events.MessageReceiveEvent;
import net.labymod.utils.ModColor;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.settings.UtilCore;

public class ClearEmptyCharModule implements UtilCore {
	
	public static void initModule() {
		mineUtil.getApi().getEventManager().register((MessageReceiveEvent) new MessageReceiveEvent() {
			@Override
			public boolean onReceive(String formatted, String unformatted) {
				if(mineUtil.getSettings().isModEnabled() && (mineUtil.isOnGrieferGames())) {
					if(mineUtil.getSettings().isModClearEmptyChar())
							if(unformatted.trim().isEmpty() || unformatted.isEmpty() || unformatted == "" || unformatted.equals("»"))
						return true;
				}
				return false;
			}
		});
	}
	
}
