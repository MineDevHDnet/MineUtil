package net.minedevhd.mineutil.modules.griefergames;

import java.util.Random;

import net.labymod.api.events.MessageReceiveEvent;
import net.labymod.core.LabyModCore;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.command.impl.MoneyDropGrabber;

public class MoneyDropGrabberModule {
	
	private static final MoneyDropGrabber GRABBER = new MoneyDropGrabber();
	
	public static void init(final MineUtil mineUtil) {
		mineUtil.getApi().getEventManager().register((MessageReceiveEvent) new MessageReceiveEvent() {
			@Override
			public boolean onReceive(String formatted, String unformatted) {
				if(mineUtil.getSettings().getModEnabled() && (mineUtil.isOnGrieferGames())) {
					if(GRABBER.isActivated()) {
						if((formatted.toLowerCase().contains("wer") && (formatted.contains("will") || (formatted.contains("m\u00f6chte") || formatted.contains("möchte")))) 
							&& ((formatted.contains("k") || formatted.contains("$"))) && !formatted.contains("mir geben")) {
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
