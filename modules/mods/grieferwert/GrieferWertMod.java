package net.minedevhd.mineutil.modules.mods.grieferwert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.JsonElement;

import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.settings.UtilCore;
import net.minedevhd.mineutil.utils.IOUtil;

public class GrieferWertMod implements UtilCore {
	
	private static List<GWEntry> gwEntries = new ArrayList<>();
	
	public static void loadPrices() {
		IOUtil.request("http://server1.mysterymod.net:5600/api/v1/itemwert/griefergames").asJsonArray(array -> {
            for(JsonElement entry : array)
                gwEntries.add(new GWEntry(entry.getAsJsonObject()));
        }).orElse(error -> {
            gwEntries = null;
        });
	}
	
	@SubscribeEvent
	public void onEvent(ItemTooltipEvent event) {
		if(mineUtil.isOnGrieferGames() && mineUtil.getSettings().isModGrieferWert()) {
			if(gwEntries.isEmpty()) return;
			
			List<String> gwEntries = new ArrayList<>();
        	
        	this.gwEntries.stream()
        	.filter(g -> g.testItem(event.itemStack))
        	.map(GWEntry::toTooltipString)
        	.forEach(gwEntries::add);
        	
        	event.toolTip.add("§r");
        	event.toolTip.add("§7GrieferWert§8: §r");
        	event.toolTip.addAll(gwEntries);
		}
	}

}
