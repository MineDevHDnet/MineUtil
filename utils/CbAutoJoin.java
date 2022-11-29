package net.minedevhd.mineutil.utils;

import java.util.Timer;

import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minedevhd.mineutil.MineUtil;

public class CbAutoJoin {
	
	public static class Script {
		
		public static class CB2 {
			
			public static void init(GameSettings gSettings, Integer secondsLeft, Timer timer) {
				switch(secondsLeft) {
				case 0:
					KeyBinding.setKeyBindState(gSettings.keyBindForward.getKeyCode(), false);
					KeyBinding.setKeyBindState(gSettings.keyBindJump.getKeyCode(), false);
					timer.cancel();
					secondsLeft = 20;
					break;
				case 6:
					KeyBinding.setKeyBindState(gSettings.keyBindJump.getKeyCode(), true);
					break;
				case 7:
					KeyBinding.setKeyBindState(gSettings.keyBindForward.getKeyCode(), true);
					break;
				case 8:
					KeyBinding.setKeyBindState(gSettings.keyBindLeft.getKeyCode(), false);
					break;
				case 16:
					KeyBinding.setKeyBindState(gSettings.keyBindLeft.getKeyCode(), true);
					KeyBinding.setKeyBindState(gSettings.keyBindForward.getKeyCode(), false);
					break;
				case 19:
					KeyBinding.setKeyBindState(gSettings.keyBindForward.getKeyCode(), true);
					break;
				default:
					break;
				}
			}
			
		}
		
	}

}
