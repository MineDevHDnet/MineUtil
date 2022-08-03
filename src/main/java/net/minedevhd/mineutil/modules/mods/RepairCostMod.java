package net.minedevhd.mineutil.modules.mods;

import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.settings.UtilCore;

public class RepairCostMod implements UtilCore {
	
	@SubscribeEvent
	public void onEvent(ItemTooltipEvent event) {
		if(mineUtil.getSettings().isModShowRepairCosts()) {
			event.toolTip.add("§r");
			final int cost = event.itemStack.getRepairCost();
			
			event.toolTip.add("§r§7Repaircost§8: §r§" + this.getColor(cost) + cost + " Level");
		}
	}
	
	/**
	 *    0   - Green
	 * 1-34 - Yellow
	 * ≥ 35 - Red
	 */
	private char getColor(int cost) {
		if(cost < 1) return 'a';
		if(cost > 35) return 'c';
		return 'e';
	}

}
