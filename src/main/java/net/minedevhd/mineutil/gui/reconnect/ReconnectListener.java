package net.minedevhd.mineutil.gui.reconnect;

import net.labymod.core.LabyModCore;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiDisconnected;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.GuiConnecting;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minedevhd.mineutil.MineUtil;

public class ReconnectListener {
	
	private final MineUtil mineUtil = MineUtil.getUtilCore();
	
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public void onGuiOpen(GuiOpenEvent event) {
		GuiScreen guiScreen = LabyModCore.getForge().getGuiOpenEventGui(event);
		
		if(guiScreen instanceof GuiConnecting) {
			mineUtil.setLastServer(mineUtil.getMCCore().getCurrentServerData());
		}

		if(guiScreen instanceof GuiDisconnected && mineUtil.getSettings().getModEnabled()) {
			try {
				guiScreen = new ReconnectGui();
			} catch (IllegalStateException exception) {}
		}
		LabyModCore.getForge().setGuiOpenEventGui(event, guiScreen);
	}

}
