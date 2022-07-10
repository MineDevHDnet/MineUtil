package net.minedevhd.mineutil.modules.griefergames;

import com.mojang.authlib.GameProfile;

import net.labymod.api.events.MessageReceiveEvent;
import net.labymod.core.LabyModCore;
import net.labymod.utils.ModColor;
import net.minecraft.client.Minecraft;
import net.minedevhd.mineutil.MineUtil;

public class CleanSpawnerErrorModule {
	
	public static void init(final MineUtil mineUtil) {
		mineUtil.getApi().getEventManager().register((MessageReceiveEvent) new MessageReceiveEvent() {
			@Override
			public boolean onReceive(String formatted, String unformatted) {
				if(mineUtil.getSettings().getModEnabled() && (mineUtil.isOnGrieferGames())) {
					if(unformatted.contains("Du hast keinen freien Platz im Inventar.")) {
						mineUtil.getMCCore().thePlayer.closeScreen();
						mineUtil.getApi().displayMessageInChat(mineUtil.getSettings().getPrefix() + "§cKeinen freien Platz im Inventar!");
						return true;
					}
				}
				return false;
			}
		});
	}

}
