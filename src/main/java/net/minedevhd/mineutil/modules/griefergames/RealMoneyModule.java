package net.minedevhd.mineutil.modules.griefergames;

import net.labymod.api.events.MessageReceiveEvent;
import net.minedevhd.mineutil.settings.UtilCore;

public final class RealMoneyModule implements UtilCore {

    private RealMoneyModule() {
    }

    public static void initModule() {
        mineUtil.getApi().getEventManager().register(new MessageReceiveEvent() {
            @Override
            public boolean onReceive(final String formatted, final String unformatted) {
                if (!mineUtil.getSettings().isModEnabled()
                        || !mineUtil.isOnGrieferGames()
                        || formatted == null
                        || unformatted == null
                        || !formatted.contains("§r§ahat dir $")
                        || !formatted.endsWith("gegeben.§r")) {
                    return false;
                }

                final boolean looksFake = unformatted.contains("»") || unformatted.contains(":");
                final String configuredSuffix = looksFake
                        ? mineUtil.getSettings().getModRealMoney_Fake()
                        : mineUtil.getSettings().getModRealMoney_Real();
                final String suffix = configuredSuffix == null ? "" : configuredSuffix.replace("&l", "§l");

                mineUtil.getApi().displayMessageInChat(
                        formatted + (looksFake ? " §c" : " §a") + suffix
                );
                return true;
            }
        });
    }
}
