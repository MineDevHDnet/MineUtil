package net.minedevhd.mineutil.utils.discord;

import java.awt.Color;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class Discord {

    private static final ThreadPoolExecutor EXECUTOR = new ThreadPoolExecutor(
            1,
            1,
            0L,
            TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<Runnable>(100),
            new ThreadFactory() {
                @Override
                public Thread newThread(final Runnable runnable) {
                    final Thread thread = new Thread(runnable, "MineUtil-Discord");
                    thread.setDaemon(true);
                    thread.setPriority(Thread.MIN_PRIORITY);
                    return thread;
                }
            },
            new ThreadPoolExecutor.DiscardOldestPolicy()
    );

    private Discord() {
    }

    public static void write(final String hook, final String title, final String message, final Color color) {
        final DiscordWebhook webhook = createWebhook(hook, title, message, null, color);
        if (webhook != null) {
            executeAsync(webhook);
        }
    }

    public static void write(final String hook, final String title, final String message,
                             final UUID uuid, final Color color) {
        final DiscordWebhook webhook = createWebhook(hook, title, message, uuid, color);
        if (webhook != null) {
            executeAsync(webhook);
        }
    }

    private static DiscordWebhook createWebhook(final String hook, final String title,
                                                 final String message, final UUID uuid,
                                                 final Color color) {
        if (hook == null) {
            return null;
        }

        final String trimmedHook = hook.trim();
        if (trimmedHook.isEmpty() || "null".equalsIgnoreCase(trimmedHook)) {
            return null;
        }

        final DiscordWebhook webhook = new DiscordWebhook(trimmedHook);
        webhook.setUsername("MineUtil");
        webhook.setTts(false);

        final DiscordWebhook.EmbedObject embed = new DiscordWebhook.EmbedObject()
                .setTitle(title == null ? "MineUtil" : title)
                .setDescription(message == null ? "" : message)
                .setColor(color == null ? Color.WHITE : color)
                .addField("Date", getFormat("dd.MM.yyyy"), true)
                .addField("Time", getFormat("HH:mm:ss"), true);

        if (uuid != null) {
            embed.setThumbnail("https://laby.net/texture/profile/head/" + uuid + ".png?size=50&overlay");
        }

        webhook.addEmbed(embed);
        return webhook;
    }

    private static void executeAsync(final DiscordWebhook webhook) {
        EXECUTOR.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    webhook.execute();
                } catch (final IOException | RuntimeException exception) {
                    System.err.println("[MineUtil] Discord webhook delivery failed: " + exception.getMessage());
                }
            }
        });
    }

    private static String getFormat(final String format) {
        final DateFormat dateFormat = new SimpleDateFormat(format, Locale.GERMANY);
        return dateFormat.format(new Date());
    }
}
