package net.minedevhd.mineutil.command.impl;

import io.netty.buffer.Unpooled;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.C17PacketCustomPayload;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.command.Category;
import net.minedevhd.mineutil.command.Command;

public class CheckCmd extends Command {

	public CheckCmd() {
		super("CheckCmd", "CheckCmd", "Check if Commandblocks are enabled on the Server", "checkcmd", Category.EXPLOIT);
	}

	@Override
	public void onCommand(String[] args, String command) {
		if(!mineUtil.getMinecraft().isSingleplayer()) {
			final PacketBuffer buffer = new PacketBuffer(Unpooled.buffer());
			buffer.writeString("Check");
			mineUtil.getMinecraft().thePlayer.sendQueue.addToSendQueue(new C17PacketCustomPayload("mc|AdvCdm", buffer));
		}
	}

	@Override
	public void update() {}

	@Override
	public boolean isActivated() {
		return false;
	}

}
