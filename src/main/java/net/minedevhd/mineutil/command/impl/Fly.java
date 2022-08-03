package net.minedevhd.mineutil.command.impl;

import net.labymod.main.LabyMod;
import net.labymod.utils.ModColor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.command.Category;
import net.minedevhd.mineutil.command.Command;

public class Fly extends Command {

	public Fly() {
		super("Flight", "Flight [Vanilla]", "Toggles your Fly-Mode", "fly", Category.MOVEMENT);
	}

	private final Minecraft mc =  mineUtil.getMinecraft();
	private final GameSettings gameSettings = this.mc.gameSettings;
	
	@Override
	public void onCommand(String[] args, String command) {
		if(!this.isCreative()) {
			if(mc.thePlayer.capabilities.isFlying)
				mc.thePlayer.capabilities.isFlying = false;
			LabyMod.getInstance().displayMessageInChat(transformMessage(this.getName(), this.toggle()));
		}
		else {
			LabyMod.getInstance().displayMessageInChat(MineUtil.getCore().getSettings().getPrefix() + "§cBro.. you are in creative mode!");
		}
	}
	
	@Override
	public void update() {}
	
	private boolean toggle() {
		return mc.thePlayer.capabilities.allowFlying = !mc.thePlayer.capabilities.allowFlying;
	}

	@Override
	public boolean isActivated() {
		return (isCreative() ? false : mc.thePlayer.capabilities.allowFlying);
	}
	
	private boolean isCreative() {
		return this.mc.playerController.isInCreativeMode();
	}
	
}
