package net.minedevhd.mineutil.command.impl;

import net.labymod.main.LabyMod;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.C10PacketCreativeInventoryAction;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.command.Category;
import net.minedevhd.mineutil.command.Command;
import net.minedevhd.mineutil.command.CommandManager;

public class Give extends Command {

	public Give() {
		super("Give", "Give", "Gives you all of items such as Commandblock (Creative)", "give", Category.EXPLOIT);
	}

	@Override
	public void onCommand(String[] args, String command) {
		if(args.length == 1) {
			final EntityPlayerSP ep = mineUtil.getMinecraft().thePlayer;
			final boolean creative = mineUtil.getMinecraft().playerController.isInCreativeMode();
			
			if(creative) {
				final ItemStack itm = new ItemStack(Item.getByNameOrId(args[0]));
				
				ep.sendQueue.addToSendQueue(new C10PacketCreativeInventoryAction(8, itm));
				LabyMod.getInstance().displayMessageInChat(MineUtil.getCore().getSettings().getPrefix() + "§fLook at your shoes...");
			}
			else {
	            mineUtil.getApi().displayMessageInChat(mineUtil.getSettings().getPrefix() + "§cYou must be in creative mode!");
			}
		}
		else {
			LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() + "§cSyntax§8: §e" + CommandManager.getPrefix() + this.getSyntax() + " <Blockname or Id>");
		}
	}

	@Override
	public void update() {}

	@Override
	public boolean isActiv() {
		return false;
	}

}
