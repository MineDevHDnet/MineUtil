package net.minedevhd.mineutil.helper;

import java.util.ArrayList;
import java.util.List;

import net.labymod.utils.ModColor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minedevhd.mineutil.MineUtil;

public class CleanHelper {
	
	private TimeHelper time = new TimeHelper();
	
	public void clean(final MineUtil mineUtil, final EntityPlayerSP player, final PlayerControllerMP playerCtrl, final Container container) {
		final ContainerChest chest = (ContainerChest) container;
		
		for (int i = 0; i < chest.getLowerChestInventory().getSizeInventory(); ++i) {
            if(chest.getLowerChestInventory().getStackInSlot(i) != null && this.time.hasReached(mineUtil.getSettings().getModCleanDelay())) {
                final ItemStack itemStack = chest.getLowerChestInventory().getStackInSlot(i);
                if(itemStack != null) {
                    final Item item = itemStack.getItem();
                    if(mineUtil.getCleanSelection().equalsIgnoreCase("Spawner")
            				&& (!mineUtil.getSettings().isModCleanOnlySpawner() 
            						|| chest.getLowerChestInventory().getName().contains("Spawner - Lager"))) {
                        final List<Item> cleanList = new ArrayList<Item>();
                        if(mineUtil.getSettings().isModCleanCobblestone()) {
                        	cleanList.add(Item.getItemFromBlock(Blocks.cobblestone));
                        }
                        if(mineUtil.getSettings().isModCleanCoal()) {
                        	cleanList.add(Items.coal);
                        	cleanList.add(Item.getItemFromBlock(Blocks.coal_ore));
                        }
                        if(mineUtil.getSettings().isModCleanLapis()) {
                        	cleanList.add(Items.dye);
                        	cleanList.add(Item.getItemFromBlock(Blocks.lapis_ore));
                        }
                        if(mineUtil.getSettings().isModCleanRedstone()) {
                        	cleanList.add(Items.redstone);
                        	cleanList.add(Item.getItemFromBlock(Blocks.redstone_ore));
                        }
                        if(mineUtil.getSettings().isModCleanGold()) {
                        	cleanList.add(Items.gold_ingot);
                        	cleanList.add(Item.getItemFromBlock(Blocks.gold_ore));
                        }
                        if(mineUtil.getSettings().isModCleanIron()) {
                        	cleanList.add(Items.iron_ingot);
                        	cleanList.add(Item.getItemFromBlock(Blocks.iron_ore));
                        }
                        if(mineUtil.getSettings().isModCleanEmerald()) {
                        	cleanList.add(Items.emerald);
                        	cleanList.add(Item.getItemFromBlock(Blocks.emerald_ore));
                        }
                        if(mineUtil.getSettings().isModCleanDiamond()) {
                        	cleanList.add(Items.diamond);
                        	cleanList.add(Item.getItemFromBlock(Blocks.diamond_ore));
                        }
                        if(mineUtil.getSettings().isModCleanDirt()) {
                        	cleanList.add(Item.getItemFromBlock(Blocks.dirt));
                        }
                        if(!cleanList.contains(item)) {
                            continue;
                        }
                        playerCtrl.windowClick(chest.windowId, i, 2, 4, player);
                    }
                    else
                    	if(mineUtil.getCleanSelection().equalsIgnoreCase("ChestInventory")) {
                            if(itemStack != null) {
                                playerCtrl.windowClick(chest.windowId, i, 2, 4, player);
                            }
                            this.time.reset();
                    	}
                }
                this.time.reset();
            }
        }
	}

}
