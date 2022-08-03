package net.minedevhd.mineutil.command.impl;

import net.labymod.main.LabyMod;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.command.Category;
import net.minedevhd.mineutil.command.Command;
import net.minedevhd.mineutil.command.CommandManager;

public class NBT extends Command {

	public NBT() {
		super("NBT", "NBT", "Shows/Copies the NBT data of an item", "nbt", Category.OTHER);
	}
	
	@Override
	public void onCommand(String[] args, String command) {
		final ItemStack itemStack = Minecraft.getMinecraft().thePlayer.inventory.getCurrentItem();
		if(itemStack == null) {
			LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix()+ "§cYou have to hold an item in your hand!");
			return;
		}
		final NBTTagCompound nbtTagCompound = itemStack.getTagCompound();
		final String nbt = nbtTagCompound == null ? "" : nbtTagCompound.toString();
		
		if(!nbt.isEmpty()) {
			if(args.length == 1) {
				if(args[0].equalsIgnoreCase("details")) {
					final String name = itemStack.getDisplayName();
					final int repairLvl = nbt.indexOf("repairCosts");
					String repairLvlString = "";
					
					if(repairLvl >= 63) repairLvlString = "To Expensive";
					LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() + "§7Please hold the line O.o");
					return;
				}
				LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() + "§fNBT§7: §f" + nbt);
			} else {
				LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() + "§cSyntax§8: §e" + CommandManager.getPrefix() + this.getSyntax() + " <details>");
			}
		} else {
			LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix()+ "§cNo NBT data was found! §8(§7The item was never changed§8)");
		}
	}

	@Override
	public void update() {}

	@Override
	public boolean isActivated() {
		return false;
	}
	
}
