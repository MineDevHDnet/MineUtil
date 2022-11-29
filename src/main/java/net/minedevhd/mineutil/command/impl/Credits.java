package net.minedevhd.mineutil.command.impl;

import net.labymod.main.LabyMod;
import net.minedevhd.mineutil.command.Category;
import net.minedevhd.mineutil.command.Command;
import net.minedevhd.mineutil.credits.Creditzz;

public class Credits extends Command {
	
	private final Creditzz creditzz = new Creditzz();

	public Credits() {
		super("Credits", "Credits", "Get all credits", "credits", Category.OTHER);
	}

	@Override
	public void onCommand(String[] args, String command) {
		this.creditzz.clearList().setNLM("Bro Code", "BroCodez", "Game : Snake");
		LabyMod.getInstance().displayMessageInChat(this.creditzz.drawString(true));
		this.creditzz.clearList().setNLM("Bro Code", "BroCodez", "Game : TicTacToe");
		LabyMod.getInstance().displayMessageInChat(this.creditzz.drawString(true));
		this.creditzz.clearList().setNLM("Bro Code", "BroCodez", "Game : Pong");
		LabyMod.getInstance().displayMessageInChat(this.creditzz.drawString(true));
//		this.creditzz.clearList().setNLM("Bro Code", "BroCodez", "Game : Puzzle");
//		LabyMod.getInstance().displayMessageInChat(this.creditzz.drawString(true));

		this.creditzz.clearList().setNLM("L3g7", "N/A", "MysteryMod Proxy");
		LabyMod.getInstance().displayMessageInChat(this.creditzz.drawString(true));
		this.creditzz.clearList().setNLM("L3g7", "N/A", "Repaircost-Info");
		LabyMod.getInstance().displayMessageInChat(this.creditzz.drawString(true));
		
		this.creditzz.clearList().setNLM("CCBlueX", "CCBlueX", "Trajectories");
		LabyMod.getInstance().displayMessageInChat(this.creditzz.drawString(true));

		this.creditzz.clearList().setNLM("wuzlwuz", "N/A", "Crafter");
		LabyMod.getInstance().displayMessageInChat(this.creditzz.drawString(true));
	}

	@Override
	public void update() {}

	@Override
	public boolean isActiv() {
		return false;
	}

}
