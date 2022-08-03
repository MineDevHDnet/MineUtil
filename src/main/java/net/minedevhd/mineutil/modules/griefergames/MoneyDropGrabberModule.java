package net.minedevhd.mineutil.modules.griefergames;

import java.util.Random;

import net.labymod.api.events.MessageReceiveEvent;
import net.labymod.core.LabyModCore;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.command.impl.MoneyDropGrabber;
import net.minedevhd.mineutil.settings.UtilCore;

public class MoneyDropGrabberModule implements UtilCore {
	
	private static final MoneyDropGrabber GRABBER = new MoneyDropGrabber();
	
	public static void initModule() {
		mineUtil.getApi().getEventManager().register((MessageReceiveEvent) new MessageReceiveEvent() {
			@Override
			public boolean onReceive(String formatted, String unformatted) {
				if(mineUtil.getSettings().isModEnabled() && (mineUtil.isOnGrieferGames())) {
					if(GRABBER.isActivated()) {
						if((unformatted.toLowerCase().contains("wer") && (unformatted.contains("will") || unformatted.contains("möchte")))
							&& ((unformatted.contains("k") || unformatted.contains("$"))) && !unformatted.contains("mir geben")) {
							LabyModCore.getMinecraft().getPlayer().sendChatMessage(this.getGrabberMessage());
						}
			        }
				}
				return false;
			}
			
			public String getGrabberMessage() {
				int rnd = new Random().nextInt(1);
				return (rnd > 1 ? "Ich <3 #geier" : (rnd < 0 ? "Ich Bitte ;)" : "Ich ;)"));
			}

		});
	}

}
