package net.minedevhd.mineutil.command.impl;

public class CheckPlayers {

//	public CheckPlayers() {
//		super("CheckPlayers", "CheckPlayers [Packet]", "Checks all players in the area for players", "checkplayers", Category.WORLD);
//	}
//	
//	private boolean activated = false;
//	private String playerName = "";
//
//	@Override
//	public void onCommand(String[] args, String command) {
//		LabyMod.getInstance().displayMessageInChat(transformMessage(this.getDisplayName(), this.toggle()));
//	}
//
//	@Override
//	public void update() {
//		if(this.isActivated()) {
//			for(net.minecraft.entity.Entity entity : Minecraft.getMinecraft().theWorld.loadedEntityList) {
//				if(entity instanceof EntityPlayer) {
//					final EntityPlayer ep = (EntityPlayer) entity;
//					
//					if(!ep.getName().equals(mineUtil.getMinecraft().thePlayer.getName())) {
//						if(String.valueOf(ep.getDisplayName()).contains("Premium")) {
//							LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() + "§6" + ep.getName());
//						}
//						else 
//							if(String.valueOf(ep.getDisplayName()).contains("Spieler")) {
//								LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() + "§a" + ep.getName());
//							}
////						this.activated = false;
//						this.playerName = ep.getName();
//					}
//				}
//			}
//			mineUtil.getMinecraft().thePlayer.sendChatMessage("/plot kick " + playerName);
////			LabyMod.getInstance().displayMessageInChat(transformMessage(this.getDisplayName(), this.activated));
//		}
//	}
//	
//	private boolean toggle() {
//		return this.activated = !this.activated;
//	}
//
//	@Override
//	public boolean isActivated() {
//		return this.activated;
//	}

}
