package net.minedevhd.mineutil.modules.griefergames;

import java.util.Locale;
import java.util.Random;

import net.labymod.api.events.MessageReceiveEvent;
import net.labymod.core.LabyModCore;
import net.minedevhd.mineutil.command.impl.MoneyDropGrabber;
import net.minedevhd.mineutil.settings.UtilCore;

public final class MoneyDropGrabberModule implements UtilCore {

    private static final MoneyDropGrabber GRABBER = new MoneyDropGrabber();
    private static final Random RANDOM = new Random();
    private static final String[] REPLIES = {
            "Ich <3 #geier",
            "Ich Bitte ;)",
            "Ich ;)"
    };

    private MoneyDropGrabberModule() {
    }

    public static void initModule() {
        mineUtil.getApi().getEventManager().register(new MessageReceiveEvent() {
            @Override
            public boolean onReceive(final String formatted, final String unformatted) {
                if (!mineUtil.getSettings().isModEnabled()
                        || !mineUtil.isOnGrieferGames()
                        || !GRABBER.isActiv()
                        || unformatted == null) {
                    return false;
                }

                final String message = unformatted.toLowerCase(Locale.GERMAN);
                final boolean asksWhoWants = message.contains("wer will") || message.contains("wer möchte");
                final boolean mentionsMoney = message.contains("k") || message.contains("$");
                final boolean asksForMoney = message.contains("mir geben");

                if (asksWhoWants && mentionsMoney && !asksForMoney) {
                    LabyModCore.getMinecraft().getPlayer().sendChatMessage(getGrabberMessage());
                }
                return false;
            }
        });
    }

    private static String getGrabberMessage() {
        return REPLIES[RANDOM.nextInt(REPLIES.length)];
    }
}
