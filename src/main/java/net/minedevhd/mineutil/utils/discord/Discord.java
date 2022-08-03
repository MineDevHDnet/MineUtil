package net.minedevhd.mineutil.utils.discord;

import java.awt.Color;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class Discord {
	
	public static final void writeMV(final String hook, final String title, final String message, final Color color) {
		DiscordWebhook webhook = new DiscordWebhook(hook);
	    webhook.setAvatarUrl("https://cdn.discordapp.com/attachments/994561651468668958/994561673551695962/utillogo.jpg");
	    webhook.setUsername("MineUtil Bot");
	    webhook.setTts(true);
	    webhook.addEmbed(new DiscordWebhook.EmbedObject()
	    .setTitle(title)
	    .setDescription(message)
        .setColor(color)
        .addField("Date", Discord.getFormat("dd.MM.yyyy"), true)
	    .addField("Time", Discord.getFormat("hh:mm:ss"), true));
//	    webhook.addEmbed(new DiscordWebhook.EmbedObject()
//	    .setDescription("Just another added embed object!"));
	    try {
			webhook.execute();
		} catch (IOException exception) {}
	}
	
	public static final void writeLV(final String hook, final String title, final String message, final UUID uuid, final Color color) {
		DiscordWebhook webhook = new DiscordWebhook(hook);
	    webhook.setAvatarUrl("https://cdn.discordapp.com/attachments/994561651468668958/994561673551695962/utillogo.jpg");
	    webhook.setUsername("MineUtil Bot");
	    webhook.setTts(true);
	    webhook.addEmbed(new DiscordWebhook.EmbedObject()
	    .setTitle(title)
	    .setDescription(message)
        .setColor(color)
        .addField("Date", Discord.getFormat("dd.MM.yyyy"), true)
	    .addField("Time", Discord.getFormat("hh:mm:ss"), true)
	    .setThumbnail("https://laby.net/texture/profile/head/" + uuid + ".png?size=50&overlay"));
//	    webhook.addEmbed(new DiscordWebhook.EmbedObject()
//	    .setDescription("Just another added embed object!"));
	    try {
			webhook.execute();
		} catch (IOException exception) {}
	}
	
	private static final String getFormat(final String format) {
		final DateFormat df = new SimpleDateFormat(format);
		final Date today = Calendar.getInstance().getTime();
		return df.format(today);
	}

}
