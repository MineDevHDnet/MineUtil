package net.minedevhd.mineutil.utils.discord;

//import net.arikia.dev.drpc.DiscordEventHandlers;
//import net.arikia.dev.drpc.DiscordRPC;
//import net.arikia.dev.drpc.DiscordRichPresence;
//import net.arikia.dev.drpc.DiscordUser;
//import net.arikia.dev.drpc.callbacks.ReadyCallback;
//import net.minedevhd.mineutil.MineUtil;

public class DiscordRP {
	
//	private boolean running = false;
//	private long created = 0;
//	
//	public void start() {
//		this.setCreated(System.currentTimeMillis());
//		
//		try {
//			DiscordEventHandlers handlers = new DiscordEventHandlers.Builder().setReadyEventHandler(new ReadyCallback() {
//				@Override
//				public void apply(DiscordUser user) {
//					update("Booting up...");
//				}
//			}).build();
//			
//			DiscordRPC.discordInitialize(MineUtil.getUtilCore().getDiscordAppId(), handlers, this.isRunning());
//			
//			new Thread() {
//				public void run() {
//					while(isRunning()) {
//						DiscordRPC.discordRunCallbacks();
//					}
//				};
//			}.start();
//		} catch (Exception exception) {}
//	}
//	
//	public void shutdown() {
//		this.setRunning(false);
//	}
//	
//	public void update(final String text) {
//		try {
//			DiscordRichPresence.Builder builder = new DiscordRichPresence.Builder("In Game");
//			builder.setBigImage("logo", "");
//			builder.setDetails(text);
//			builder.setStartTimestamps(this.getCreated());
//			
//			DiscordRPC.discordUpdatePresence(builder.build());
//		} catch (Exception exception) {}
//	}
//	
//	public final boolean isRunning() {
//		return this.running;
//	}
//	
//	public void setRunning(boolean running) {
//		this.running = running;
//	}
//	
//	public final long getCreated() {
//		return this.created;
//	}
//	
//	public void setCreated(long created) {
//		this.created = created;
//	}

}
