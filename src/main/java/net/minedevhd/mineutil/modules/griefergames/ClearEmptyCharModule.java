package net.minedevhd.mineutil.modules.griefergames;

import net.labymod.api.events.MessageReceiveEvent;
import net.minedevhd.mineutil.settings.UtilCore;

public final class ClearEmptyCharModule implements UtilCore {

    private ClearEmptyCharModule() {
    }

    public static void initModule() {
        mineUtil.getApi().getEventManager().register(new MessageReceiveEvent() {
            @Override
            public boolean onReceive(final String formatted, final String unformatted) {
                if (!mineUtil.getSettings().isModEnabled()
                        || !mineUtil.isOnGrieferGames()
                        || !mineUtil.getSettings().isModClearEmptyChar()
                        || unformatted == null) {
                    return false;
                }

                final String message = unformatted.trim();
                return message.isEmpty() || "»".equals(message);
            }
        });
    }
}
