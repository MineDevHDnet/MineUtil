package net.minedevhd.mineutil.helper;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.item.ItemStack;
import net.minedevhd.mineutil.settings.UtilCore;

public final class StealHelper implements UtilCore {

    private static final TimeHelper ACTION_DELAY = new TimeHelper();
    private static final long DELAY_MS = 75L;

    private StealHelper() {
    }

    public static void drop(final EntityPlayerSP player,
                            final PlayerControllerMP playerController,
                            final Container container) {
        if (!(container instanceof ContainerChest)
                || player == null
                || playerController == null
                || !ACTION_DELAY.hasReached(DELAY_MS)) {
            return;
        }

        final ContainerChest chest = (ContainerChest) container;
        for (int slot = 0; slot < chest.getLowerChestInventory().getSizeInventory(); slot++) {
            final ItemStack stack = chest.getLowerChestInventory().getStackInSlot(slot);
            if (stack == null) {
                continue;
            }

            // mode 4 = drop; button 1 drops the complete stack.
            playerController.windowClick(chest.windowId, slot, 1, 4, player);
            ACTION_DELAY.reset();
            return;
        }
    }

    public static void steal(final EntityPlayerSP player,
                             final PlayerControllerMP playerController,
                             final Container container) {
        if (!(container instanceof ContainerChest)
                || player == null
                || playerController == null
                || !ACTION_DELAY.hasReached(DELAY_MS)) {
            return;
        }

        final ContainerChest chest = (ContainerChest) container;
        for (int slot = 0; slot < chest.getLowerChestInventory().getSizeInventory(); slot++) {
            final ItemStack stack = chest.getLowerChestInventory().getStackInSlot(slot);
            if (stack == null) {
                continue;
            }

            // mode 1 = shift-click into the player inventory.
            playerController.windowClick(chest.windowId, slot, 0, 1, player);
            ACTION_DELAY.reset();
            return;
        }
    }
}
