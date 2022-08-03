package net.minedevhd.mineutil.command.impl;

import net.labymod.main.LabyMod;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.command.Category;
import net.minedevhd.mineutil.command.Command;

public class MurderMystery extends Command {

	public MurderMystery() {
		super("MurderMystery", "MurderMystery [Packet]", "Find the killer in the game 'MurderMystery' on Hypixel", "murdermystery", Category.EXPLOIT);
	}

	private boolean activated = false;

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
					
					if(ep.getHeldItem().getItem().equals(Items.iron_sword)) {
						this.activated = false;
						LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() + "§7Player §e" + ep.getName() + "§7is the Murderer!");
						break;
					}
				}
			}
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
