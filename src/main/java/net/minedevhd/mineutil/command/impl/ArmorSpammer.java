package net.minedevhd.mineutil.command.impl;

import java.util.Random;

import net.labymod.main.LabyMod;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagDouble;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.play.client.C10PacketCreativeInventoryAction;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.command.Category;
import net.minedevhd.mineutil.command.Command;
import net.minedevhd.mineutil.command.CommandManager;

public class ArmorSpammer extends Command {

	public ArmorSpammer() {
		super("ArmorSpammer", "ArmorStand Spammer", "Spawn Armorstands at any position (Creative)", "armorspammer", Category.EXPLOIT);
	}
	
	/**
	 * 	TODO:
	 *   > Rardius einstellbar machen!
	 * */
	
	private boolean activated = false;

	@Override
	public void onCommand(String[] args, String command) {
		if(args.length >= 1) {
			if(!mineUtil.getMinecraft().playerController.isInCreativeMode()) {
	            mineUtil.getApi().displayMessageInChat(mineUtil.getSettings().getPrefix() + "§cYou must be in creative mode!");
				return;
			}
			
			if(args[0].equalsIgnoreCase("toggle")) {
				LabyMod.getInstance().displayMessageInChat(transformMessage(this.getName(), this.toggle()));
				return;
			}
		}
		else {
			LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() + "§cSyntax§8: §e" + CommandManager.getPrefix() + this.getSyntax() + " <toggle>");
		}
	}

	@Override
	public void update() {
		if(this.isActivated()) {
			try {
				final EntityPlayerSP sp = mineUtil.getMinecraft().thePlayer;
				
				final double x = (double) sp.getPosition().getX(),
							 y = (double) sp.getPosition().getY(),
							 z = (double) sp.getPosition().getZ();
				
				sp.sendQueue.addToSendQueue(new C10PacketCreativeInventoryAction(36, this.createHologramm(x, y, z)));
			} catch (Exception exception) {}
		}
	}

	@Override
	public boolean isActivated() {
		return this.activated;
	}
	
	private boolean toggle() {
		return this.activated = !this.activated;
	}
	
	private final double between(final Integer min, final Integer max) {
		Random rnd = new Random();
		int randomNum = rnd.nextInt((max - min) + 1) + min;
		return Double.valueOf(randomNum);
	}
	
	private final ItemStack createHologramm(final double x, final double y, final double z) {
		final ItemStack itm = new ItemStack(Items.armor_stand);
		final NBTTagCompound base = new NBTTagCompound();
		final NBTTagCompound entityTag = new NBTTagCompound();
		
		final NBTTagList pos = new NBTTagList();
		
		pos.appendTag(new NBTTagDouble(x + this.between(-20, 20)));
		pos.appendTag(new NBTTagDouble(y + this.between(-20, 20)));
		pos.appendTag(new NBTTagDouble(z + this.between(-20, 20)));
		
		entityTag.setTag("Pos", pos);
		
		base.setTag("EntityTag", entityTag);
		itm.setTagCompound(base);
		return itm;
	}

}
