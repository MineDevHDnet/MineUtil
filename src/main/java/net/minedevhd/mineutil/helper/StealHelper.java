package net.minedevhd.mineutil.helper;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.settings.UtilCore;

public class StealHelper implements UtilCore {
	
	private static TimeHelper time = new TimeHelper();
	
	public static void drop(final EntityPlayerSP player, final PlayerControllerMP playerCtrl, final Container container) {
		final ContainerChest chest = (ContainerChest) container;
		
		for (int i = 0; i < chest.getLowerChestInventory().getSizeInventory(); ++i) {
            if(chest.getLowerChestInventory().getStackInSlot(i) != null && time.hasReached(75L)) {
                final ItemStack itemStack = chest.getLowerChestInventory().getStackInSlot(i);
                if(itemStack != null) {
                    playerCtrl.windowClick(chest.windowId, i, 2, 4, player);
                }
                time.reset();
            }
        }
	}
	
	public static void steal(final EntityPlayerSP player, final PlayerControllerMP playerCtrl, final Container container) {
		final ContainerChest chest = (ContainerChest) container;
		
		for (int i = 0; i < chest.getLowerChestInventory().getSizeInventory(); ++i) {
            if(chest.getLowerChestInventory().getStackInSlot(i) != null && time.hasReached(75L)) {
                final ItemStack itemStack = chest.getLowerChestInventory().getStackInSlot(i);
                if(itemStack != null) {
                    playerCtrl.windowClick(chest.windowId, i, 0, 1, player);
                }
                time.reset();
            }
        }
	}

}
