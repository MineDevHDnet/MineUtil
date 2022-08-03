package net.minedevhd.mineutil.command.impl;

import net.labymod.main.LabyMod;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.network.play.client.C10PacketCreativeInventoryAction;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.command.Category;
import net.minedevhd.mineutil.command.Command;
import net.minedevhd.mineutil.command.CommandManager;

public class CmdBook extends Command {

	public CmdBook() {
		super("CmdBook", "CmdBook", "Gives you a special command book to annoy players (Creative)", "cmdbook", Category.EXPLOIT);
	}

	@Override
	public void onCommand(String[] args, String command) {
		if(args.length >= 1) {
			if(!mineUtil.getMinecraft().playerController.isInCreativeMode()) {
	            mineUtil.getApi().displayMessageInChat(mineUtil.getSettings().getPrefix() + "§cYou must be in creative mode!");
				return;
			}
			
			String bookCmd = "";
			
			for(int i = 0; i < args.length; i++) {
				bookCmd += args[i] + " ";
			}
			
			if(bookCmd.isEmpty()) {
				LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() + "§cSyntax§8: §e" + CommandManager.getPrefix() + this.getSyntax() + " <Command>");
				return;
			}
			
			final ItemStack item = new ItemStack(Items.written_book);
			final NBTTagCompound base = new NBTTagCompound();
			final NBTTagList list = new NBTTagList();
			
			String spaces = "";
			for(int i = 0; i < 500; i++) {
				spaces += " ";
			}
			list.appendTag(new NBTTagString("{\"clickEvent\":{\"action\":\"run_command\",\"value\":\"%COMMAND%\"},\"hoverEvent\":{\"action\":\"show_text\",\"value\":{\"text\":\"%HOVERTEXT%\"}},\"text\":\"%TEXT%\"}".replace("%COMMAND%", bookCmd).replace("%HOVERTEXT%", "§eJ§ba§d, §ck§6l§ai§bc§ck §dm§ea§6l §ah§bi§ce§6r§e!").replace("%TEXT%", spaces)));
			base.setTag("pages", list);
			base.setString("author", "§4Admin");
			base.setByte("resolved", (byte) 1);
			base.setString("title", "§aG§eA§cM§bE §dB§6O§aO§eK");
			item.setTagCompound(base);
			Minecraft.getMinecraft().thePlayer.sendQueue.addToSendQueue(new C10PacketCreativeInventoryAction(8, item));
			LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() + "§fDu hast ein §eBefehlsbuch §ferstellt. Guck an deine Schuhe!");
		}
		else {
			LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() + "§cSyntax§8: §e" + CommandManager.getPrefix() + this.getSyntax() + " <Command>");
		}
	}

	@Override
	public void update() {}

	@Override
	public boolean isActivated() {
		return false;
	}

}
