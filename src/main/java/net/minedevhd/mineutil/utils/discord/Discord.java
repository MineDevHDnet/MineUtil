package net.minedevhd.mineutil.utils.discord;

import java.awt.Color;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Discord {
	
	public static final void write(final String hook, final String title, final String message) {
		DiscordWebhook webhook = new DiscordWebhook(hook);
//	    webhook.setContent("Any message!");
	    webhook.setAvatarUrl("https://cdn-icons-png.flaticon.com/512/6455/6455719.png");
	    webhook.setUsername("MineUtil Bot");
	    webhook.setTts(true);
	    webhook.addEmbed(new DiscordWebhook.EmbedObject()
	    .setTitle(title)
	    .setDescription(message)
        .setColor(Color.RED)
//      .addField("1st Field", "Inline", true)
//	    .addField("2nd Field", "Inline", true)
//	    .addField("3rd Field", "No-Inline", false)
//	    .setThumbnail("https://th.bing.com/th/id/OIP.HTMhlLBiOsDf8KtbJoRr7QHaEK?pid=ImgDet&rs=1")
	    .setFooter("Date: " + getFormat("dd.MM.yyyy") + " at " + getFormat("hh:mm:ss"), null));
//	    .setImage("https://th.bing.com/th/id/OIP.HTMhlLBiOsDf8KtbJoRr7QHaEK?pid=ImgDet&rs=1")
//	    .setAuthor("Author Name", "https://kryptongta.com", "https://th.bing.com/th/id/OIP.HTMhlLBiOsDf8KtbJoRr7QHaEK?pid=ImgDet&rs=1")
//	    .setUrl("https://kryptongta.com"));
//	    webhook.addEmbed(new DiscordWebhook.EmbedObject()
//	    .setDescription("Just another added embed object!"));
	    try {
			webhook.execute(); //Handle exception
		} catch (IOException exception) {}
	}
	
//	private static final String getDate() {
//		final DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
//		final Date today = Calendar.getInstance().getTime();
//		return df.format(today);
//	}
	
//	private static final String getTime() {
//		final DateFormat df = new SimpleDateFormat("hh:mm:ss");
//		final Date today = Calendar.getInstance().getTime();
//		return df.format(today);
//	}
	
	private static final String getFormat(final String format) {
		final DateFormat df = new SimpleDateFormat(format);
		final Date today = Calendar.getInstance().getTime();
		return df.format(today);
	}

}
