package net.minedevhd.mineutil.command.impl;

import net.labymod.main.LabyMod;
import net.labymod.utils.ModColor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.command.Category;
import net.minedevhd.mineutil.command.Command;

public class NoFall extends Command {

	public NoFall() {
		super("NoFall", "NoFall [Vanilla]", "No longer take fall damage", "nofall", Category.MOVEMENT);
	}

	private static final Minecraft mc =  mineUtil.getMinecraft();
	private static final GameSettings gameSettings = mc.gameSettings;
	
	private boolean activated = false;
	
	@Override
	public void onCommand(String[] args, String command) {
		if(!this.isCreative()) {
			LabyMod.getInstance().displayMessageInChat(transformMessage(this.getName(), this.toggle()));
		}
		else {
			LabyMod.getInstance().displayMessageInChat(MineUtil.getCore().getSettings().getPrefix() + "§cBro.. you are in creative mode!");
		}
	}
	
	@Override
	public void update() {
		if(this.isActiv()) {
			if(mc.thePlayer.fallDistance > 2F) {
				mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer(true));
			}
		}
	}
	
	private boolean toggle() {
		return this.activated = !this.activated;
	}

	@Override
	public boolean isActiv() {
		return this.activated;
	}
	
	private boolean isCreative() {
		return this.mc.playerController.isInCreativeMode();
	}

}
