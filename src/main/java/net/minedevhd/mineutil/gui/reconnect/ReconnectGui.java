package net.minedevhd.mineutil.gui.reconnect;

import java.util.List;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiDisconnected;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.GuiConnecting;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.Timer;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.helper.TickHelper;
import net.minedevhd.mineutil.helper.TimeHelper;
import net.minedevhd.mineutil.utils.ModButton;
import scala.reflect.internal.Trees.This;

public class ReconnectGui extends GuiScreen {
	
	private final MineUtil mineUtil = MineUtil.getUtilCore();
//	private final GuiScreen parentScreen;
	
//	private static final String[] PARENT_SCREEN_MAPPINGS = new String[]{"h", "field_146307_h", "parentScreen"};
//	private static final String[] MESSAGE_MAPPINGS = new String[]{"f", "field_146304_f", "message"};
//	private static final String[] REASON_MAPPINGS = new String[]{"a", "field_146306_a", "reason"};

//	private ChatComponentText message;
	private String reason = "";

//	public ReconnectGui(GuiDisconnected guiDisconnected) throws IllegalAccessException {
//		
//		parentScreen = (GuiScreen) ReflectionHelper.findField(GuiDisconnected.class, PARENT_SCREEN_MAPPINGS).get(guiDisconnected);
//		try {
//			message = (ChatComponentText) ReflectionHelper.findField(GuiDisconnected.class, MESSAGE_MAPPINGS).get(guiDisconnected);
//		} catch (ClassCastException exception) {}
//		reason = (String) ReflectionHelper.findField(GuiDisconnected.class, REASON_MAPPINGS).get(guiDisconnected);
//
//		if(message.getUnformattedText().equals(I18n.format("disconnect.loginFailedInfo", I18n.format("disconnect" + ".loginFailedInfo.invalidSession")))) {
//			throw new IllegalStateException();
//		}
//		
//	}
	
	private TimeHelper time = new TimeHelper();

	public static GuiButton reconnectButton;
	
	private List<String> multilineMessage;
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		drawDefaultBackground();
		drawCenteredString(fontRendererObj, reason, width / 2, height / 2 - 10, 11184810);
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public void initGui() {
		buttonList.clear();
//		multilineMessage = this.fontRendererObj.listFormattedStringToWidth(message.getFormattedText(), width - 50);
//		reasonHeight = multilineMessage.size() * fontRendererObj.FONT_HEIGHT;

		buttonList.add(new ModButton(0, width / 2, height / 2 + fontRendererObj.FONT_HEIGHT, 125, 20, I18n.format("gui.toMenu")));
		buttonList.add(reconnectButton = new ModButton(1, width / 2 - 115, height / 2 + fontRendererObj.FONT_HEIGHT, 100, 20, "Reconnect in: §a" + TickHelper.secondsLeft + "s"));
		super.initGui();
	}

	@Override
	protected void actionPerformed(GuiButton button) {
		if(button.id == 0) {
			this.time.reset();
			mc.displayGuiScreen(new GuiMultiplayer(null));
		}

		if(button.id == 1) {
			this.time.reset();
			mineUtil.getMCCore().displayGuiScreen(new GuiConnecting(this, mineUtil.getMCCore(), mineUtil.getLastServer()));
		}
	}

	@Override
	public void onGuiClosed() {
		this.time.reset();
		super.onGuiClosed();
	}
	
}
