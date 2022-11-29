package net.minedevhd.mineutil.command.impl;

import java.util.Random;

import net.labymod.main.LabyMod;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagDouble;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.play.client.C10PacketCreativeInventoryAction;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.command.Category;
import net.minedevhd.mineutil.command.Command;
import net.minedevhd.mineutil.command.CommandManager;

public class Hologram extends Command {

	public Hologram() {
		super("Hologram", "Hologram Spammer", "Spawn any text at any position (Creative)", "holo", Category.EXPLOIT);
	}

	private boolean activated = false;
	private Integer radius;
	private String text = "";
	
	@Override
	public void onCommand(String[] args, String command) {
		if(args.length >= 1) {
			if(!mineUtil.getMinecraft().playerController.isInCreativeMode()) {
	            mineUtil.getApi().displayMessageInChat(mineUtil.getSettings().getPrefix() + "§cYou must be in creative mode!");
				return;
			}
			
			if(args[0].equalsIgnoreCase("toggle")) {
				try {
					if(this.radius == null) this.radius = 20;
					LabyMod.getInstance().displayMessageInChat(transformMessage(this.getName(), this.toggle()));
				} catch (Exception exception) {}
				return;
			}
			
			if(args[0].equalsIgnoreCase("radius")) {
				final Integer r = Integer.valueOf(args[1]);
				this.radius = r;
				LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() + "§aThe holo radius is now §e" + this.radius + " Blocks.");
				return;
			}
			
			this.text = "";
			
			for(int i = 0; i < args.length; i++) {
				this.text += args[i] + " ";
			}
			LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() + "§aThe holo text has been set to §e" + text.replace('&', '§'));
		}
		else {
			LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() + "§cSyntax§8: §e" + CommandManager.getPrefix() + this.getSyntax() + " <Text/radius/toggle>");
		}
	}

	@Override
	public void update() {
		if(this.isActiv()) {
			try {
				final EntityPlayerSP sp = mineUtil.getMinecraft().thePlayer;
				
				final double x = (double) sp.getPosition().getX(),
							 y = (double) sp.getPosition().getY(),
							 z = (double) sp.getPosition().getZ();
				
				sp.sendQueue.addToSendQueue(new C10PacketCreativeInventoryAction(36, this.createHologramm(this.text.replace('&', '§'), x, y, z)));
			} catch (Exception exception) {}
		}
	}

	@Override
	public boolean isActiv() {
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
	
	private final ItemStack createHologramm(final String text, final double x, final double y, final double z) {
		final ItemStack itm = new ItemStack(Items.armor_stand);
		final NBTTagCompound base = new NBTTagCompound();
		final NBTTagCompound entityTag = new NBTTagCompound();
		
		entityTag.setInteger("Invisible", 1);
		entityTag.setString("CustomName", text);
		entityTag.setInteger("CustomNameVisible", 1);
		entityTag.setInteger("NoGravity", 2);
		
		final NBTTagList pos = new NBTTagList();
		
		pos.appendTag(new NBTTagDouble(x + between(-this.radius, this.radius)));
		pos.appendTag(new NBTTagDouble(y + between(-this.radius, this.radius)));
		pos.appendTag(new NBTTagDouble(z + between(-this.radius, this.radius)));
		
		entityTag.setTag("Pos", pos);
		
		base.setTag("EntityTag", entityTag);
		itm.setTagCompound(base);
		return itm;
	}

}
