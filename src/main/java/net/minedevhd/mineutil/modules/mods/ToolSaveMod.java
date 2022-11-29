package net.minedevhd.mineutil.modules.mods;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.settings.UtilCore;
import net.minedevhd.mineutil.utils.graf.DrawUtil;

public class ToolSaveMod implements UtilCore {
	
	private static final EntityPlayerSP player = mineUtil.getMinecraft().thePlayer;
	
	private static final Integer DAMAGE = 3;
	
	@SubscribeEvent
	public void onMouse(MouseEvent event) {
		if(this.DAMAGE == 0) return;
		if((event.button != 0 && event.button != 1) || !event.buttonstate) return;
		if(this.shouldCancle()) event.setCanceled(true);
	}
	
	private static boolean shouldCancle() {
		if(player == null) return false;
		
		final ItemStack heldItem = player.getHeldItem();
		if(heldItem == null || !heldItem.isItemStackDamageable()) return false;

		return DAMAGE > heldItem.getMaxDamage() - heldItem.getItemDamage();
	}
	
	public static void saveTool() {
		if(DAMAGE == 0) return;
		if(!shouldCancle()) return;
		KeyBinding.setKeyBindState(mineUtil.getMinecraft().gameSettings.keyBindUseItem.getKeyCode(), false);
		KeyBinding.setKeyBindState(mineUtil.getMinecraft().gameSettings.keyBindAttack.getKeyCode(), false);
		DrawUtil.drawTitleString("§4⚠ §6Warnung §4⚠", "§cDein Item geht gleich kaputt!");
	}
	
	public static boolean canBeRepaired(final ItemStack itemStack) {
		// The repair cost of the item (Source: ContainerRepair.updateRepairOutput())
		// If the item is only damaged 1/4, you can repair it with a single material of the same type (i.e. a diamond), thus costing only 1 level
		// more than the repair value. Otherwise, it can be repaired with another item of the same type (i.e. a diamond sword), costing 2 levels more.
		final Integer XP_COST = itemStack.getRepairCost() + (itemStack.getItemDamage() >= itemStack.getMaxDamage() / 4 ? 1 : 2);
		return XP_COST < 40;
	}

//	public static void saveTool(final PlayerControllerMP playerCtrl) {
//		if(mineUtil.getMinecraft().thePlayer != null) {
//        	if(mineUtil.getMinecraft().thePlayer.getHeldItem() != null) {
//        		final ItemStack itm = mineUtil.getMinecraft().thePlayer.getHeldItem();
//        		
//        		final Integer duraLoosToDrop = mineUtil.getSettings().getModSaveItem();
//        		
//        		if(itm.getMaxDamage() != 0 && duraLoosToDrop < 1900)
//        			if((itm.getMaxDamage() - (duraLoosToDrop + 1)) < itm.getItemDamage()) {
//        				playerCtrl.sendPacketDropItem(itm);
//        				mineUtil.getMinecraft().thePlayer.swingItem();
//        				mineUtil.getMinecraft().thePlayer.dropOneItem(false);
//        				DrawUtil.drawTitleString("§4⚠ §6Warnung §4⚠", "§cDein Item geht gleich kaputt!");
//        			}
//        	}
//        }
//	}
	
}
