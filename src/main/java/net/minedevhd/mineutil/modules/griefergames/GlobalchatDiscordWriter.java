package net.minedevhd.mineutil.modules.griefergames;

import java.awt.Color;
import java.util.UUID;

import net.labymod.api.events.MessageReceiveEvent;
import net.labymod.utils.UUIDFetcher;
import net.minedevhd.mineutil.settings.UtilCore;
import net.minedevhd.mineutil.utils.discord.Discord;

public final class GlobalchatDiscordWriter implements UtilCore {

    private GlobalchatDiscordWriter() {
    }

    public static void initModule() {
        mineUtil.getApi().getEventManager().register(new MessageReceiveEvent() {
            @Override
            public boolean onReceive(final String formatted, final String unformatted) {
                if (!mineUtil.isOnGrieferGames()
                        || !mineUtil.getSettings().isModGGGlobalchatWriter()
                        || unformatted == null
                        || !unformatted.startsWith("@")) {
                    return false;
                }

                final String webhook = mineUtil.getSettings().getModGGGlobalchatWriterWebhook();
                if (webhook == null || webhook.trim().isEmpty() || "null".equalsIgnoreCase(webhook.trim())) {
                    return false;
                }

                final String[] args = unformatted.trim().split("\\s+");
                if (args.length < 4) {
                    return false;
                }

                final String username = args[3];
                final StringBuilder message = new StringBuilder();
                for (int i = 5; i < args.length; i++) {
                    if (message.length() > 0) {
                        message.append(' ');
                    }
                    message.append(args[i]);
                }

                UUID uuid = null;
                try {
                    uuid = new UUIDFetcher().getUUID(username);
                } catch (final RuntimeException exception) {
                    System.err.println("[MineUtil] Could not resolve UUID for global chat user " + username);
                }

                Discord.write(
                        webhook,
                        "Globalchat (" + username + ")",
                        "Message: " + message,
                        uuid,
                        Color.WHITE
                );
                return false;
            }
        });
    }
}
