package net.minedevhd.mineutil.modules.griefergames;

import com.mojang.authlib.GameProfile;

import net.labymod.api.events.MessageReceiveEvent;
import net.labymod.core.LabyModCore;
import net.labymod.utils.ModColor;
import net.minecraft.client.Minecraft;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.settings.UtilCore;

public class CleanSpawnerErrorModule implements UtilCore {
	
	public static void initModule() {
		mineUtil.getApi().getEventManager().register((MessageReceiveEvent) new MessageReceiveEvent() {
			@Override
			public boolean onReceive(String formatted, String unformatted) {
				if(mineUtil.getSettings().isModEnabled() && (mineUtil.isOnGrieferGames())) {
					if(unformatted.contains("Du hast keinen freien Platz im Inventar.")) {
						mineUtil.getMinecraft().thePlayer.closeScreen();
						mineUtil.getApi().displayMessageInChat(mineUtil.getSettings().getPrefix() + "§cKeinen freien Platz im Inventar!");
						return true;
					}
				}
				return false;
			}
		});
	}

}
