package net.minedevhd.mineutil.modules.griefergames;

import net.labymod.api.events.MessageSendEvent;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.settings.UtilCore;

public class EasyPaymentModule implements UtilCore {
	
	public static void initModule() {
		
		mineUtil.getApi().getEventManager().register(new MessageSendEvent() {
			
			@Override
			public boolean onSend(String message) {
				if(message.toLowerCase().startsWith("/pay ") || message.toLowerCase().startsWith("/bank ")) {
					try {
						String[] splitString = message.split(" ");
						String originalPayment = splitString[2].toLowerCase();
						
						if(originalPayment.endsWith("k")) {
							String amountWithoutLetters = originalPayment.replace("k", "").replace(",", ".");
							int amountToPay = (int) Math.floor(Float.parseFloat(amountWithoutLetters) * 1000);
							MineUtil.getCore().getMinecraft().thePlayer.sendChatMessage(splitString[0] + " " + splitString[1] + " " + amountToPay);
							return true;
						}
						if(originalPayment.endsWith("m") || originalPayment.endsWith("mio")) {
							String amountWithoutLetters = originalPayment.replace("m", "").replace("mio", "").replace(",", ".");
							int amountToPay = (int) Math.floor(Float.parseFloat(amountWithoutLetters) * 1000000);
							MineUtil.getCore().getMinecraft().thePlayer.sendChatMessage(splitString[0] + " " + splitString[1] + " " + amountToPay);
							return true;
						}
					} catch (Exception exception) {}
				}
				return false;
			}
		});
		
	}

}
