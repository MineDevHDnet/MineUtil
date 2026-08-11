package net.minedevhd.mineutil.helper;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minedevhd.mineutil.settings.UtilCore;

public final class CleanHelper implements UtilCore {

    private final TimeHelper actionDelay = new TimeHelper();

    public void clean(final EntityPlayerSP player,
                      final PlayerControllerMP playerController,
                      final Container container) {
        if (!(container instanceof ContainerChest)
                || player == null
                || playerController == null
                || mineUtil.getSettings() == null
                || !actionDelay.hasReached(Math.max(0, mineUtil.getSettings().getModCleanDelay()))) {
            return;
        }

        final ContainerChest chest = (ContainerChest) container;
        final String selection = mineUtil.getCleanSelection();
        if (selection == null || selection.isEmpty()) {
            return;
        }

        final boolean cleanEntireChest = "ChestInventory".equalsIgnoreCase(selection);
        final boolean cleanSpawner = "Spawner".equalsIgnoreCase(selection) && isAllowedSpawnerChest(chest);
        if (!cleanEntireChest && !cleanSpawner) {
            return;
        }

        final Set<Item> unwantedItems = cleanSpawner ? createSpawnerCleanSet() : null;
        for (int slot = 0; slot < chest.getLowerChestInventory().getSizeInventory(); slot++) {
            final ItemStack stack = chest.getLowerChestInventory().getStackInSlot(slot);
            if (stack == null) {
                continue;
            }
            if (unwantedItems != null && !unwantedItems.contains(stack.getItem())) {
                continue;
            }

            // mode 4 = drop; button 1 drops the complete stack.
            playerController.windowClick(chest.windowId, slot, 1, 4, player);
            actionDelay.reset();
            return;
        }
    }

    private boolean isAllowedSpawnerChest(final ContainerChest chest) {
        if (!mineUtil.getSettings().isModCleanOnlySpawner()) {
            return true;
        }
        final String name = chest.getLowerChestInventory().getName();
        return name != null && name.contains("Spawner - Lager");
    }

    private Set<Item> createSpawnerCleanSet() {
        final Set<Item> items = new HashSet<Item>();

        if (mineUtil.getSettings().isModCleanCobblestone()) {
            items.add(Item.getItemFromBlock(Blocks.cobblestone));
        }
        if (mineUtil.getSettings().isModCleanCoal()) {
            items.add(Items.coal);
            items.add(Item.getItemFromBlock(Blocks.coal_ore));
        }
        if (mineUtil.getSettings().isModCleanLapis()) {
            items.add(Items.dye);
            items.add(Item.getItemFromBlock(Blocks.lapis_ore));
        }
        if (mineUtil.getSettings().isModCleanRedstone()) {
            items.add(Items.redstone);
            items.add(Item.getItemFromBlock(Blocks.redstone_ore));
        }
        if (mineUtil.getSettings().isModCleanGold()) {
            items.add(Items.gold_ingot);
            items.add(Item.getItemFromBlock(Blocks.gold_ore));
        }
        if (mineUtil.getSettings().isModCleanIron()) {
            items.add(Items.iron_ingot);
            items.add(Item.getItemFromBlock(Blocks.iron_ore));
        }
        if (mineUtil.getSettings().isModCleanEmerald()) {
            items.add(Items.emerald);
            items.add(Item.getItemFromBlock(Blocks.emerald_ore));
        }
        if (mineUtil.getSettings().isModCleanDiamond()) {
            items.add(Items.diamond);
            items.add(Item.getItemFromBlock(Blocks.diamond_ore));
        }
        if (mineUtil.getSettings().isModCleanDirt()) {
            items.add(Item.getItemFromBlock(Blocks.dirt));
        }

        return items;
    }
}
