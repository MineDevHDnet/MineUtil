package net.minedevhd.mineutil.modules.mods;

import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minedevhd.mineutil.settings.UtilCore;

public final class RepairCostMod implements UtilCore {

    @SubscribeEvent
    public void onEvent(final ItemTooltipEvent event) {
        if (event == null
                || event.itemStack == null
                || event.toolTip == null
                || mineUtil.getSettings() == null
                || !mineUtil.getSettings().isModShowRepairCosts()) {
            return;
        }

        final int cost = Math.max(0, event.itemStack.getRepairCost());
        event.toolTip.add("§r");
        event.toolTip.add("§7Repaircost§8: §r§" + getColor(cost) + cost + " Level");
    }

    /** 0 = green, 1-34 = yellow, 35+ = red. */
    private char getColor(final int cost) {
        if (cost < 1) {
            return 'a';
        }
        if (cost >= 35) {
            return 'c';
        }
        return 'e';
    }
}
