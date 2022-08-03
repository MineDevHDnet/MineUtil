package net.minedevhd.mineutil.modules.mods;

import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.settings.UtilCore;
import net.minedevhd.mineutil.utils.graf.DrawUtil;

public class ToolSaveMod implements UtilCore {

	public static void saveTool(final PlayerControllerMP playerCtrl) {
		if(mineUtil.getMinecraft().thePlayer != null) {
        	if(mineUtil.getMinecraft().thePlayer.getHeldItem() != null) {
        		final ItemStack itm = mineUtil.getMinecraft().thePlayer.getHeldItem();
        		
        		final Integer duraLoosToDrop = mineUtil.getSettings().getModSaveItem();
        		
        		if(itm.getMaxDamage() != 0 && duraLoosToDrop < 1900)
        			if((itm.getMaxDamage() - (duraLoosToDrop + 1)) < itm.getItemDamage()) {
        				playerCtrl.sendPacketDropItem(itm);
        				mineUtil.getMinecraft().thePlayer.swingItem();
        				mineUtil.getMinecraft().thePlayer.dropOneItem(false);
        				DrawUtil.drawTitleString("§4⚠ §6Warnung §4⚠", "§cDein Item geht gleich kaputt!");
        			}
        	}
        }
	}
	
}
