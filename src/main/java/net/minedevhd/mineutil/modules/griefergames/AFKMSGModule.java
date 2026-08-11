package net.minedevhd.mineutil.modules.griefergames;

import java.awt.Color;
import java.util.UUID;

import net.labymod.api.events.MessageReceiveEvent;
import net.labymod.utils.UUIDFetcher;
import net.minedevhd.mineutil.command.impl.AFK;
import net.minedevhd.mineutil.settings.UtilCore;
import net.minedevhd.mineutil.utils.discord.Discord;

public final class AFKMSGModule implements UtilCore {

    private static final String DEFAULT_AFK_MESSAGE = "Hey, Sorry. Ich bin gerade AFK!";

    private AFKMSGModule() {
    }

    public static void initModule() {
        mineUtil.getApi().getEventManager().register(new MessageReceiveEvent() {
            @Override
            public boolean onReceive(final String formatted, final String unformatted) {
                if (!mineUtil.getSettings().isModEnabled()
                        || !mineUtil.isOnGrieferGames()
                        || !new AFK().isActiv()
                        || formatted == null
                        || unformatted == null) {
                    return false;
                }

                if (!formatted.contains("§r§6[§r")
                        || !formatted.contains("§r§6 -> §r§cmir§r§6]")
                        || !formatted.endsWith("§r")) {
                    return false;
                }

                final String[] args = unformatted.trim().split("\\s+");
                if (args.length < 3) {
                    return false;
                }

                final String username = args[2];
                final StringBuilder receivedMessage = new StringBuilder();
                for (int i = 5; i < args.length; i++) {
                    if (receivedMessage.length() > 0) {
                        receivedMessage.append(' ');
                    }
                    receivedMessage.append(args[i]);
                }

                final String webhook = mineUtil.getSettings().getModGGAFKMSGWebhook();
                if (webhook != null && !webhook.trim().isEmpty() && !"null".equalsIgnoreCase(webhook.trim())) {
                    UUID uuid = null;
                    try {
                        uuid = new UUIDFetcher().getUUID(username);
                    } catch (final RuntimeException exception) {
                        System.err.println("[MineUtil] Could not resolve UUID for AFK sender " + username);
                    }
                    Discord.write(
                            webhook,
                            "/msg (" + username + ")",
                            "Message: " + receivedMessage,
                            uuid,
                            Color.WHITE
                    );
                }

                final String configuredMessage = mineUtil.getSettings().getModGGAFKMSGMessage();
                final String reply = configuredMessage == null || configuredMessage.trim().isEmpty()
                        ? DEFAULT_AFK_MESSAGE
                        : configuredMessage.trim();
                mineUtil.sendQueued("/msg " + username + " " + reply);
                return false;
            }
        });
    }
}
