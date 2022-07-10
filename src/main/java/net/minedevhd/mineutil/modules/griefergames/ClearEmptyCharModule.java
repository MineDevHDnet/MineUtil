package net.minedevhd.mineutil.modules.griefergames;

import net.labymod.api.events.MessageReceiveEvent;
import net.labymod.utils.ModColor;
import net.minedevhd.mineutil.MineUtil;

public class ClearEmptyCharModule {
	
	public static void init(final MineUtil mineUtil) {
		mineUtil.getApi().getEventManager().register((MessageReceiveEvent) new MessageReceiveEvent() {
			@Override
			public boolean onReceive(String formatted, String unformatted) {
				if(mineUtil.getSettings().getModEnabled() && (mineUtil.isOnGrieferGames())) {
					if(mineUtil.getSettings().isModClearEmptyChar() && (unformatted.trim().isEmpty())) {
						return true;
					}
				}
				return false;
			}
		});
	}
	
}
