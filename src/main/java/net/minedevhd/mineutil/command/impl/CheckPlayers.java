package net.minedevhd.mineutil.command.impl;

import net.labymod.main.LabyMod;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.command.Command;
import net.minedevhd.mineutil.command.CommandManager;

public class CheckPlayers extends Command {

	public CheckPlayers() {
		super("CheckPlayers", "CheckPlayers [Packet]", "Checks all players in the area for players", "checkplayers", Category.WORLD);
	}

	private final MineUtil mineUtil = MineUtil.getUtilCore();
	
	private boolean activated = false;
	private String playerName = "";

	@Override
	public void onCommand(String[] args, String command) {
		LabyMod.getInstance().displayMessageInChat(transformMessage(this.getDisplayName(), this.toggle()));
	}

	@Override
	public void update() {
		if(this.isActivated()) {
			for(net.minecraft.entity.Entity entity : Minecraft.getMinecraft().theWorld.loadedEntityList) {
				if(entity instanceof EntityPlayer) {
					final EntityPlayer ep = (EntityPlayer) entity;
					
					if(!ep.getName().equals(mineUtil.getMCCore().thePlayer.getName())) {
						if(String.valueOf(ep.getDisplayName()).contains("Premium")) {
							LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() + "§6" + ep.getName());
						}
						else 
							if(String.valueOf(ep.getDisplayName()).contains("Spieler")) {
								LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() + "§a" + ep.getName());
							}
//						this.activated = false;
						this.playerName = ep.getName();
					}
				}
			}
			mineUtil.getMCCore().thePlayer.sendChatMessage("/plot kick " + playerName);
//			LabyMod.getInstance().displayMessageInChat(transformMessage(this.getDisplayName(), this.activated));
		}
	}
	
	private boolean toggle() {
		return this.activated = !this.activated;
	}

	@Override
	public boolean isActivated() {
		return this.activated;
	}

}
