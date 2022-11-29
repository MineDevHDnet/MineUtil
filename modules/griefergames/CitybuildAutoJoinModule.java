package net.minedevhd.mineutil.modules.griefergames;

import java.util.Timer;
import java.util.TimerTask;

import net.labymod.api.events.MessageReceiveEvent;
import net.minecraft.client.settings.KeyBinding;
import net.minedevhd.mineutil.settings.ModSettings.Citybuilds;
import net.minedevhd.mineutil.settings.UtilCore;
import net.minedevhd.mineutil.utils.CbAutoJoin;

public class CitybuildAutoJoinModule implements UtilCore {
	
	private static Timer timer;
	
	public static void initModule() {
		mineUtil.getApi().getEventManager().register((MessageReceiveEvent) new MessageReceiveEvent() {
			Integer secondsLeft = 20;

			@Override
			public boolean onReceive(String formatted, String unformatted) {
				if(mineUtil.isOnGrieferGames() && mineUtil.getSettings().isModGGAutoJoinCB()) {
					if(unformatted.contains("[GrieferGames] Du bist im Portalraum. Wähle deinen Citybuild aus.")) {
						(timer = new Timer()).schedule(new TimerTask() {
							@Override
							public void run() {
								secondsLeft--;
								if(Citybuilds.getTTCB().equalsIgnoreCase("cb2"))
									CbAutoJoin.Script.CB2.init(mineUtil.getMinecraft().gameSettings, secondsLeft, timer);
							}
						}, 900L, 900L);
					}
					else 
						if(unformatted.contains("[Switcher] Lade Daten herunter!")) {
							KeyBinding.setKeyBindState(mineUtil.getMinecraft().gameSettings.keyBindForward.getKeyCode(), false);
							KeyBinding.setKeyBindState(mineUtil.getMinecraft().gameSettings.keyBindJump.getKeyCode(), false);
							KeyBinding.setKeyBindState(mineUtil.getMinecraft().gameSettings.keyBindLeft.getKeyCode(), false);
							KeyBinding.setKeyBindState(mineUtil.getMinecraft().gameSettings.keyBindRight.getKeyCode(), false);
						}
				}
				return false;
			}
		});
	}

}
