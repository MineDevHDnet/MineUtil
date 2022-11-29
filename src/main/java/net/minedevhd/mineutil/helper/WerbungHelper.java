package net.minedevhd.mineutil.helper;

import net.labymod.api.events.MessageReceiveEvent;
import net.labymod.main.LabyMod;
import net.minedevhd.mineutil.command.impl.Werbung;
import net.minedevhd.mineutil.settings.UtilCore;

public class WerbungHelper implements UtilCore {
	
	private static final String TRIGGER_MESSAGE = "[GrieferGames] Daten heruntergeladen!";
	private static final String SWITCH_COMMAND = "/switch ";
	
	public static void $witch() {
		mineUtil.getApi().getEventManager().register((MessageReceiveEvent) new MessageReceiveEvent() {
			@Override
			public boolean onReceive(String formatted, String unformatted) {
				if(mineUtil.isOnGrieferGames()) {
					final Werbung werbung = new Werbung();
					
					if(werbung.activated && werbung.isRunning())
						if(unformatted.contains(TRIGGER_MESSAGE))
							switch (werbung.CB) {
							case 2:
								LabyMod.getInstance().displayMessageInChat(SWITCH_COMMAND + "cb" + werbung.CB);
								break;
							case 3:
								LabyMod.getInstance().displayMessageInChat(SWITCH_COMMAND + "cb" + werbung.CB);
								break;
							case 4:
								LabyMod.getInstance().displayMessageInChat(SWITCH_COMMAND + "cb" + werbung.CB);
								break;
							case 5:
								LabyMod.getInstance().displayMessageInChat(SWITCH_COMMAND + "cb" + werbung.CB);
								break;
							case 6:
								LabyMod.getInstance().displayMessageInChat(SWITCH_COMMAND + "cb" + werbung.CB);
								break;
							case 7:
								LabyMod.getInstance().displayMessageInChat(SWITCH_COMMAND + "cb" + werbung.CB);
								break;
							case 8:
								LabyMod.getInstance().displayMessageInChat(SWITCH_COMMAND + "cb" + werbung.CB);
								break;
							case 9:
								LabyMod.getInstance().displayMessageInChat(SWITCH_COMMAND + "cb" + werbung.CB);
								break;
							case 10:
								LabyMod.getInstance().displayMessageInChat(SWITCH_COMMAND + "cb" + werbung.CB);
								break;
							case 11:
								LabyMod.getInstance().displayMessageInChat(SWITCH_COMMAND + "cb" + werbung.CB);
								break;
							case 12:
								LabyMod.getInstance().displayMessageInChat(SWITCH_COMMAND + "cb" + werbung.CB);
								break;
							case 13:
								LabyMod.getInstance().displayMessageInChat(SWITCH_COMMAND + "cb" + werbung.CB);
								break;
							case 14:
								LabyMod.getInstance().displayMessageInChat(SWITCH_COMMAND + "cb" + werbung.CB);
								break;
							case 15:
								LabyMod.getInstance().displayMessageInChat(SWITCH_COMMAND + "cb" + werbung.CB);
								break;
							case 16:
								LabyMod.getInstance().displayMessageInChat(SWITCH_COMMAND + "cb" + werbung.CB);
								break;
							case 17:
								LabyMod.getInstance().displayMessageInChat(SWITCH_COMMAND + "cb" + werbung.CB);
								break;
							case 18:
								LabyMod.getInstance().displayMessageInChat(SWITCH_COMMAND + "cb" + werbung.CB);
								break;
							case 19:
								LabyMod.getInstance().displayMessageInChat(SWITCH_COMMAND + "cb" + werbung.CB);
								break;
							case 20:
								LabyMod.getInstance().displayMessageInChat(SWITCH_COMMAND + "cb" + werbung.CB);
								break;
							case 21:
								LabyMod.getInstance().displayMessageInChat(SWITCH_COMMAND + "cb" + werbung.CB);
								break;
							case 22:
								LabyMod.getInstance().displayMessageInChat(SWITCH_COMMAND + "cb" + werbung.CB);
								break;
							case 23:
								LabyMod.getInstance().displayMessageInChat(SWITCH_COMMAND + "nature");
								break;
							case 24:
								LabyMod.getInstance().displayMessageInChat(SWITCH_COMMAND + "extreme");
								break;
							case 25:
								werbung.setRunning(false);
								werbung.CB = 0;
								LabyMod.getInstance().displayMessageInChat(SWITCH_COMMAND + werbung.getCityBuild());
								werbung.setCityBuild("none");
								LabyMod.getInstance().displayMessageInChat(werbung.transformMessage("Werbung", werbung.activated));
								break;
							default:
								break;
							}
					werbung.CB++;
				}
				return false;
			}
		});
	}

}
