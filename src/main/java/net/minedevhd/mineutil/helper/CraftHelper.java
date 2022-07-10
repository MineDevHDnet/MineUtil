package net.minedevhd.mineutil.helper;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minedevhd.mineutil.MineUtil;

public class CraftHelper {
	
	private TimeHelper time = new TimeHelper();
	
	public void craft(final MineUtil mineUtil, final EntityPlayerSP player, final PlayerControllerMP playerCtrl, final Container container) {
		final ContainerWorkbench workbench = (ContainerWorkbench) container;
        final ItemStack result = workbench.getSlot(0).getStack();
        Item compressItem = null;
        
        if(mineUtil.getCraftSelection().equalsIgnoreCase("GoldIngot")) {
            this.craftItem(null, new Object[] { Items.gold_nugget, Items.gold_nugget, Items.gold_nugget, Items.gold_nugget, Items.gold_nugget, Items.gold_nugget, Items.gold_nugget, Items.gold_nugget, Items.gold_nugget });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.gold_ingot)) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("GoldBlock")) {
            this.craftItem(null, new Object[] { Items.gold_ingot, Items.gold_ingot, Items.gold_ingot, Items.gold_ingot, Items.gold_ingot, Items.gold_ingot, Items.gold_ingot, Items.gold_ingot, Items.gold_ingot });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.gold_block))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("TNT")) {
            this.craftItem(null, new Object[] { Items.gunpowder, Blocks.sand, Items.gunpowder, Blocks.sand, Items.gunpowder, Blocks.sand, Items.gunpowder, Blocks.sand, Items.gunpowder });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.tnt))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("SeaLantern")) {
            this.craftItem(null, new Object[] { Items.prismarine_shard, Items.prismarine_crystals, Items.prismarine_shard, Items.prismarine_crystals, Items.prismarine_crystals, Items.prismarine_crystals, Items.prismarine_shard, Items.prismarine_crystals, Items.prismarine_shard });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.sea_lantern))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("RedstoneBlock")) {
            this.craftItem(null, new Object[] { Items.redstone, Items.redstone, Items.redstone, Items.redstone, Items.redstone, Items.redstone, Items.redstone, Items.redstone, Items.redstone });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.redstone_block))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("Glowstone")) {
            this.craftItem(null, new Object[] { Items.glowstone_dust, Items.glowstone_dust, null, Items.glowstone_dust, Items.glowstone_dust, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.glowstone))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("Prismarine")) {
            this.craftItem(null, new Object[] { Items.prismarine_shard, Items.prismarine_shard, null, Items.prismarine_shard, Items.prismarine_shard, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.prismarine))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("PrismarineBrick")) {
            this.craftItem(null, new Object[] { Items.prismarine_shard, Items.prismarine_shard, Items.prismarine_shard, Items.prismarine_shard, Items.prismarine_shard, Items.prismarine_shard, Items.prismarine_shard, Items.prismarine_shard, Items.prismarine_shard });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.prismarine))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("DarkPrismarine")) {
            this.craftItem(null, new Object[] { Items.prismarine_shard, Items.prismarine_shard, Items.prismarine_shard, Items.prismarine_shard, Items.dye, Items.prismarine_shard, Items.prismarine_shard, Items.prismarine_shard, Items.prismarine_shard });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.prismarine))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("Paper")) {
            this.craftItem(null, new Object[] { Items.reeds, Items.reeds, Items.reeds, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.paper)) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("QuartzBlock")) {
            this.craftItem(null, new Object[] { Items.quartz, Items.quartz, null, Items.quartz, Items.quartz, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.quartz_block)) && result.getMetadata() == 0) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("QuartzPillar")) {
			this.craftItem(new Object[] { null, null, null, null, 0, null, null, 0, null }, new Object[] {
					null, null, null, null,
					Item.getItemFromBlock(Blocks.quartz_block), null, null, Item.getItemFromBlock(Blocks.quartz_block), null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.quartz_block)) && result.getMetadata() == 2) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("QuartzSlab")) {
            this.craftItem(new Object[] { null, null, null, 0, 0, 0, null, null, null }, new Object[] { null, null, null, Item.getItemFromBlock(Blocks.quartz_block), Item.getItemFromBlock(Blocks.quartz_block), Item.getItemFromBlock(Blocks.quartz_block), null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.stone_slab)) && result.getMetadata() == 7) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("ChiseledQuartz")) {
            this.craftItem(new Object[] { null, null, null, null, 7, null, null, 7, null }, new Object[] { null, null, null, null, Item.getItemFromBlock(Blocks.stone_slab), null, null, Item.getItemFromBlock(Blocks.stone_slab), null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.quartz_block)) && result.getMetadata() == 1) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("NetherBrick")) {
            this.craftItem(null, new Object[] { Items.netherbrick, Items.netherbrick, null, Items.netherbrick, Items.netherbrick, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.nether_brick))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("BrickBlock")) {
            this.craftItem(null, new Object[] { Items.brick, Items.brick, null, Items.brick, Items.brick, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.brick_block))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("DiamondBlock")) {
            this.craftItem(null, new Object[] { Items.diamond, Items.diamond, Items.diamond, Items.diamond, Items.diamond, Items.diamond, Items.diamond, Items.diamond, Items.diamond });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.diamond_block))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("IronBlock")) {
            this.craftItem(null, new Object[] { Items.iron_ingot, Items.iron_ingot, Items.iron_ingot, Items.iron_ingot, Items.iron_ingot, Items.iron_ingot, Items.iron_ingot, Items.iron_ingot, Items.iron_ingot });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.iron_block))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("EmeraldBlock")) {
            this.craftItem(null, new Object[] { Items.emerald, Items.emerald, Items.emerald, Items.emerald, Items.emerald, Items.emerald, Items.emerald, Items.emerald, Items.emerald });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.emerald_block))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("SlimeBlock")) {
            this.craftItem(null, new Object[] { Items.slime_ball, Items.slime_ball, Items.slime_ball, Items.slime_ball, Items.slime_ball, Items.slime_ball, Items.slime_ball, Items.slime_ball, Items.slime_ball });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.slime_block))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("SnowBlock")) {
            this.craftItem(null, new Object[] { Items.snowball, Items.snowball, null, Items.snowball, Items.snowball, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.snow))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("ClayBlock")) {
            this.craftItem(null, new Object[] { Items.clay_ball, Items.clay_ball, null, Items.clay_ball, Items.clay_ball, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.clay))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("HayBlock")) {
            this.craftItem(null, new Object[] { Items.wheat, Items.wheat, Items.wheat, Items.wheat, Items.wheat, Items.wheat, Items.wheat, Items.wheat, Items.wheat });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.hay_block))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("Wool")) {
            this.craftItem(null, new Object[] { Items.string, Items.string, null, Items.string, Items.string, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.wool))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("RedstoneLamp")) {
            this.craftItem(null, new Object[] { null, Items.redstone, null, Items.redstone, Item.getItemFromBlock(Blocks.glowstone), Items.redstone, null, Items.redstone, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.redstone_lamp))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("CoalBlock")) {
            this.craftItem(new Object[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, new Object[] { Items.coal, Items.coal, Items.coal, Items.coal, Items.coal, Items.coal, Items.coal, Items.coal, Items.coal });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.coal_block))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("LapisBlock")) {
            this.craftItem(new Object[] { 4, 4, 4, 4, 4, 4, 4, 4, 4 }, new Object[] { Items.dye, Items.dye, Items.dye, Items.dye, Items.dye, Items.dye, Items.dye, Items.dye, Items.dye });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.lapis_block))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("ItemFrame")) {
            this.craftItem(null, new Object[] { Items.stick, Items.stick, Items.stick, Items.stick, Items.leather, Items.stick, Items.stick, Items.stick, Items.stick });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.item_frame)) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("Compass")) {
            this.craftItem(null, new Object[] { null, Items.iron_ingot, null, Items.iron_ingot, Items.redstone, Items.iron_ingot, null, Items.iron_ingot, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.compass)) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("Map")) {
            this.craftItem(null, new Object[] { Items.paper, Items.paper, Items.paper, Items.paper, Items.compass, Items.paper, Items.paper, Items.paper, Items.paper });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.map)) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("Melon")) {
            this.craftItem(null, new Object[] { Items.melon, Items.melon, Items.melon, Items.melon, Items.melon, Items.melon, Items.melon, Items.melon, Items.melon });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.melon_block))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("StoneBrick")) {
            this.craftItem(null, new Object[] { Item.getItemFromBlock(Blocks.stone), Item.getItemFromBlock(Blocks.stone), null, Item.getItemFromBlock(Blocks.stone), Item.getItemFromBlock(Blocks.stone), null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.stonebrick)) && result.getMetadata() == 0) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("StoneBrickSlab")) {
            this.craftItem(new Object[] { null, null, null, 0, 0, 0, null, null, null }, new Object[] { null, null, null, Item.getItemFromBlock(Blocks.stonebrick), Item.getItemFromBlock(Blocks.stonebrick), Item.getItemFromBlock(Blocks.stonebrick), null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.stone_slab)) && result.getMetadata() == 5) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("ChiseledStoneBrick")) {
            this.craftItem(new Object[] { null, null, null, null, 5, null, null, 5, null }, new Object[] { null, null, null, null, Item.getItemFromBlock(Blocks.stone_slab), null, null, Item.getItemFromBlock(Blocks.stone_slab), null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.stonebrick)) && result.getMetadata() == 3) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("BookShelf")) {
            this.craftItem(null, new Object[] { Item.getItemFromBlock(Blocks.planks), Item.getItemFromBlock(Blocks.planks), Item.getItemFromBlock(Blocks.planks), Items.book, Items.book, Items.book, Item.getItemFromBlock(Blocks.planks), Item.getItemFromBlock(Blocks.planks), Item.getItemFromBlock(Blocks.planks) });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.bookshelf))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("MossyCobbleStone")) {
            this.craftItem(null, new Object[] { Item.getItemFromBlock(Blocks.cobblestone), Item.getItemFromBlock(Blocks.vine), null, null, null, null, null, null, null });
            if(result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.mossy_cobblestone))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("MossyStoneBrick")) {
            this.craftItem(new Object[] { 0, null, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.stonebrick), Item.getItemFromBlock(Blocks.vine), null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.stonebrick))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("Anvil")) {
            this.craftItem(null, new Object[] { Item.getItemFromBlock(Blocks.iron_block), Item.getItemFromBlock(Blocks.iron_block), Item.getItemFromBlock(Blocks.iron_block), null, Items.iron_ingot, null, Items.iron_ingot, Items.iron_ingot, Items.iron_ingot });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.anvil))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("RedstoneComperator")) {
            this.craftItem(null, new Object[] { null, Item.getItemFromBlock(Blocks.redstone_torch), null, Item.getItemFromBlock(Blocks.redstone_torch), Items.quartz, Item.getItemFromBlock(Blocks.redstone_torch), Item.getItemFromBlock(Blocks.stone), Item.getItemFromBlock(Blocks.stone), Item.getItemFromBlock(Blocks.stone) });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.comparator)) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("RedstoneRepeater")) {
            this.craftItem(null, new Object[] { null, null, null, Item.getItemFromBlock(Blocks.redstone_torch), Items.redstone, Item.getItemFromBlock(Blocks.redstone_torch), Item.getItemFromBlock(Blocks.stone), Item.getItemFromBlock(Blocks.stone), Item.getItemFromBlock(Blocks.stone) });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.repeater)) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("Dispenser")) {
            this.craftItem(null, new Object[] { Item.getItemFromBlock(Blocks.cobblestone), Item.getItemFromBlock(Blocks.cobblestone), Item.getItemFromBlock(Blocks.cobblestone), Item.getItemFromBlock(Blocks.cobblestone), Items.bow, Item.getItemFromBlock(Blocks.cobblestone), Item.getItemFromBlock(Blocks.cobblestone), Items.redstone, Item.getItemFromBlock(Blocks.cobblestone) });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.dispenser))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("Dropper")) {
            this.craftItem(null, new Object[] { Item.getItemFromBlock(Blocks.cobblestone), Item.getItemFromBlock(Blocks.cobblestone), Item.getItemFromBlock(Blocks.cobblestone), Item.getItemFromBlock(Blocks.cobblestone), null, Item.getItemFromBlock(Blocks.cobblestone), Item.getItemFromBlock(Blocks.cobblestone), Items.redstone, Item.getItemFromBlock(Blocks.cobblestone) });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.dropper))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("Bow")) {
            this.craftItem(null, new Object[] { null, Items.stick, Items.string, Items.stick, null, Items.string, null, Items.stick, Items.string });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.bow)) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("Hopper")) {
            this.craftItem(null, new Object[] { Items.iron_ingot, null, Items.iron_ingot, Items.iron_ingot, Item.getItemFromBlock(Blocks.chest), Items.iron_ingot, null, Items.iron_ingot, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.hopper))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
            this.craftItem(null, new Object[] { Items.iron_ingot, null, Items.iron_ingot, Items.iron_ingot, Item.getItemFromBlock(Blocks.trapped_chest), Items.iron_ingot, null, Items.iron_ingot, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.hopper))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("RedstoneTorch")) {
            this.craftItem(null, new Object[] { null, null, null, null, Items.redstone, null, null, Items.stick, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.redstone_torch))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("Torch")) {
            this.craftItem(null, new Object[] { null, null, null, null, Items.coal, null, Items.stick, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.torch))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("Sandstone")) {
            this.craftItem(new Object[] { 0, 0, null, 0, 0, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.sand), Item.getItemFromBlock(Blocks.sand), null, Item.getItemFromBlock(Blocks.sand), Item.getItemFromBlock(Blocks.sand), null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.sandstone)) && result.getMetadata() == 0) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("SmoothSandstone")) {
            this.craftItem(new Object[] { 0, 0, null, 0, 0, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.sandstone), Item.getItemFromBlock(Blocks.sandstone), null, Item.getItemFromBlock(Blocks.sandstone), Item.getItemFromBlock(Blocks.sandstone), null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.sandstone)) && result.getMetadata() == 2) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("SandstoneSlab")) {
            this.craftItem(new Object[] { null, null, null, 0, 0, 0, null, null, null }, new Object[] { null, null, null, Item.getItemFromBlock(Blocks.sandstone), Item.getItemFromBlock(Blocks.sandstone), Item.getItemFromBlock(Blocks.sandstone), null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.stone_slab)) && result.getMetadata() == 1) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("ChiseledSandstone")) {
            this.craftItem(new Object[] { null, null, null, null, 1, null, null, 1, null }, new Object[] { null, null, null, null, Item.getItemFromBlock(Blocks.stone_slab), null, null, Item.getItemFromBlock(Blocks.stone_slab), null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.sandstone)) && result.getMetadata() == 1) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("RedSandstone")) {
            this.craftItem(new Object[] { 1, 1, null, 1, 1, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.sand), Item.getItemFromBlock(Blocks.sand), null, Item.getItemFromBlock(Blocks.sand), Item.getItemFromBlock(Blocks.sand), null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.red_sandstone)) && result.getMetadata() == 0) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("SmoothRedSandstone")) {
            this.craftItem(new Object[] { 0, 0, null, 0, 0, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.red_sandstone), Item.getItemFromBlock(Blocks.red_sandstone), null, Item.getItemFromBlock(Blocks.red_sandstone), Item.getItemFromBlock(Blocks.red_sandstone), null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.red_sandstone)) && result.getMetadata() == 2) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("RedSandstoneSlab")) {
            this.craftItem(new Object[] { null, null, null, 0, 0, 0, null, null, null }, new Object[] { null, null, null, Item.getItemFromBlock(Blocks.red_sandstone), Item.getItemFromBlock(Blocks.red_sandstone), Item.getItemFromBlock(Blocks.red_sandstone), null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.stone_slab2)) && result.getMetadata() == 0) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("ChiseledRedSandstone")) {
            this.craftItem(new Object[] { null, null, null, null, 0, null, null, 0, null }, new Object[] { null, null, null, null, Item.getItemFromBlock(Blocks.stone_slab2), null, null, Item.getItemFromBlock(Blocks.stone_slab2), null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.red_sandstone)) && result.getMetadata() == 1) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("ColorRed")) {
            this.craftItem(new Object[] { 0, null, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.red_flower), null, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.dye) && result.getMetadata() == 1) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
            this.craftItem(new Object[] { 4, null, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.red_flower), null, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.dye) && result.getMetadata() == 1) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
            this.craftItem(new Object[] { 4, null, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.double_plant), null, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.dye) && result.getMetadata() == 1) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("ColorYellow")) {
            this.craftItem(null, new Object[] { Item.getItemFromBlock(Blocks.yellow_flower), null, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.dye) && result.getMetadata() == 11) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
            this.craftItem(new Object[] { 0, null, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.double_plant), null, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.dye) && result.getMetadata() == 11) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("ColorPink")) {
            this.craftItem(new Object[] { 4, null, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.red_flower), null, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.dye) && result.getMetadata() == 9) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
            this.craftItem(new Object[] { 5, null, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.double_plant), null, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.dye) && result.getMetadata() == 9) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
            this.craftItem(new Object[] { 1, 15, null, null, null, null, null, null, null }, new Object[] { Items.dye, Items.dye, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.dye) && result.getMetadata() == 9) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("ColorMagenta")) {
            this.craftItem(new Object[] { 2, null, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.red_flower), null, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.dye) && result.getMetadata() == 13) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
            this.craftItem(new Object[] { 1, null, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.double_plant), null, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.dye) && result.getMetadata() == 13) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("ColorOrange")) {
            this.craftItem(new Object[] { 5, null, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.red_flower), null, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.dye) && result.getMetadata() == 14) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
            this.craftItem(new Object[] { 1, 11, null, null, null, null, null, null, null }, new Object[] { Items.dye, Items.dye, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.dye) && result.getMetadata() == 14) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("ColorLightGrey")) {
            this.craftItem(new Object[] { 3, null, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.red_flower), null, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.dye) && result.getMetadata() == 7) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
            this.craftItem(new Object[] { 6, null, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.red_flower), null, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.dye) && result.getMetadata() == 7) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
            this.craftItem(new Object[] { 8, null, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.red_flower), null, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.dye) && result.getMetadata() == 7) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
            this.craftItem(new Object[] { 8, 15, null, null, null, null, null, null, null }, new Object[] { Items.dye, Items.dye, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.dye) && result.getMetadata() == 7) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("ColorViolet")) {
            this.craftItem(new Object[] { 4, 1, null, null, null, null, null, null, null }, new Object[] { Items.dye, Items.dye, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.dye) && result.getMetadata() == 5) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("ColorTurquoise")) {
            this.craftItem(new Object[] { 4, 2, null, null, null, null, null, null, null }, new Object[] { Items.dye, Items.dye, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.dye) && result.getMetadata() == 6) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("ColorGrey")) {
            this.craftItem(new Object[] { 0, 15, null, null, null, null, null, null, null }, new Object[] { Items.dye, Items.dye, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.dye) && result.getMetadata() == 8) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("ColorLightGreen")) {
            this.craftItem(new Object[] { 2, 15, null, null, null, null, null, null, null }, new Object[] { Items.dye, Items.dye, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.dye) && result.getMetadata() == 10) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("ColorLightBlue")) {
            this.craftItem(new Object[] { 1, null, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.red_flower), null, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.dye) && result.getMetadata() == 12) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
            this.craftItem(new Object[] { 4, 15, null, null, null, null, null, null, null }, new Object[] { Items.dye, Items.dye, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.dye) && result.getMetadata() == 12) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("ColorWhite")) {
            this.craftItem(null, new Object[] { Items.bone, null, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.dye) && result.getMetadata() == 15) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("WoolBlack")) {
            this.craftItem(new Object[] { 0, 0, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.wool), Items.dye, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.wool)) && result.getMetadata() == 15) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("WoolRed")) {
            this.craftItem(new Object[] { 0, 1, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.wool), Items.dye, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.wool)) && result.getMetadata() == 14) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("WoolGreen")) {
            this.craftItem(new Object[] { 0, 2, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.wool), Items.dye, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.wool)) && result.getMetadata() == 13) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("WoolBrown")) {
            this.craftItem(new Object[] { 0, 3, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.wool), Items.dye, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.wool)) && result.getMetadata() == 12) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("WoolBlue")) {
            this.craftItem(new Object[] { 0, 4, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.wool), Items.dye, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.wool)) && result.getMetadata() == 11) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("WoolViolet")) {
            this.craftItem(new Object[] { 0, 5, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.wool), Items.dye, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.wool)) && result.getMetadata() == 10) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("WoolTurquoise")) {
            this.craftItem(new Object[] { 0, 6, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.wool), Items.dye, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.wool)) && result.getMetadata() == 9) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("WoolLightGrey")) {
            this.craftItem(new Object[] { 0, 7, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.wool), Items.dye, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.wool)) && result.getMetadata() == 8) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("WoolGrey")) {
            this.craftItem(new Object[] { 0, 8, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.wool), Items.dye, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.wool)) && result.getMetadata() == 7) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("WoolPink")) {
            this.craftItem(new Object[] { 0, 9, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.wool), Items.dye, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.wool)) && result.getMetadata() == 6) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("WoolLightGreen")) {
            this.craftItem(new Object[] { 0, 10, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.wool), Items.dye, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.wool)) && result.getMetadata() == 5) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("WoolYellow")) {
            this.craftItem(new Object[] { 0, 11, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.wool), Items.dye, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.wool)) && result.getMetadata() == 4) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("WoolLightBlue")) {
            this.craftItem(new Object[] { 0, 12, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.wool), Items.dye, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.wool)) && result.getMetadata() == 3) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("WoolMagenta")) {
            this.craftItem(new Object[] { 0, 13, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.wool), Items.dye, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.wool)) && result.getMetadata() == 2) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("WoolOrange")) {
            this.craftItem(new Object[] { 0, 14, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.wool), Items.dye, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.wool)) && result.getMetadata() == 1) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("ClayBlack")) {
            this.craftItem(new Object[] { null, 0, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Items.dye, Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay) });
            if(result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.stained_hardened_clay)) && result.getMetadata() == 15) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("ClayRed")) {
            this.craftItem(new Object[] { null, 1, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Items.dye, Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay) });
            if(result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.stained_hardened_clay)) && result.getMetadata() == 14) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("ClayGreen")) {
            this.craftItem(new Object[] { null, 2, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Items.dye, Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay) });
            if(result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.stained_hardened_clay)) && result.getMetadata() == 13) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("ClayBrown")) {
            this.craftItem(new Object[] { null, 3, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Items.dye, Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay) });
            if(result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.stained_hardened_clay)) && result.getMetadata() == 12) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("ClayBlue")) {
            this.craftItem(new Object[] { null, 4, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Items.dye, Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay) });
            if(result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.stained_hardened_clay)) && result.getMetadata() == 11) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("ClayViolet")) {
            this.craftItem(new Object[] { null, 5, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Items.dye, Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay) });
            if(result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.stained_hardened_clay)) && result.getMetadata() == 10) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("ClayTurquoise")) {
            this.craftItem(new Object[] { null, 6, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Items.dye, Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay) });
            if(result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.stained_hardened_clay)) && result.getMetadata() == 9) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("ClayLightGrey")) {
            this.craftItem(new Object[] { null, 7, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Items.dye, Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay) });
            if(result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.stained_hardened_clay)) && result.getMetadata() == 8) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("ClayGrey")) {
            this.craftItem(new Object[] { null, 8, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Items.dye, Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay) });
            if(result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.stained_hardened_clay)) && result.getMetadata() == 7) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("ClayPink")) {
            this.craftItem(new Object[] { null, 9, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Items.dye, Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay) });
            if(result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.stained_hardened_clay)) && result.getMetadata() == 6) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("ClayLightGreen")) {
            this.craftItem(new Object[] { null, 10, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Items.dye, Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay) });
            if(result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.stained_hardened_clay)) && result.getMetadata() == 5) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("ClayYellow")) {
            this.craftItem(new Object[] { null, 11, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Items.dye, Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay) });
            if(result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.stained_hardened_clay)) && result.getMetadata() == 4) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("ClayLightBlue")) {
            this.craftItem(new Object[] { null, 12, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Items.dye, Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay) });
            if(result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.stained_hardened_clay)) && result.getMetadata() == 3) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("ClayMagenta")) {
            this.craftItem(new Object[] { null, 13, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Items.dye, Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay) });
            if(result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.stained_hardened_clay)) && result.getMetadata() == 2) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("ClayOrange")) {
            this.craftItem(new Object[] { null, 14, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Items.dye, Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay) });
            if(result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.stained_hardened_clay)) && result.getMetadata() == 1) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("ClayWhite")) {
            this.craftItem(new Object[] { null, 15, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Items.dye, Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay), Item.getItemFromBlock(Blocks.hardened_clay) });
            if(result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.stained_hardened_clay)) && result.getMetadata() == 0) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("GlassBlack")) {
            this.craftItem(new Object[] { null, 0, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Items.dye, Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass) });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.stained_glass)) && result.getMetadata() == 15) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("GlassRed")) {
            this.craftItem(new Object[] { null, 1, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Items.dye, Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass) });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.stained_glass)) && result.getMetadata() == 14) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("GlassGreen")) {
            this.craftItem(new Object[] { null, 2, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Items.dye, Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass) });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.stained_glass)) && result.getMetadata() == 13) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("GlassBrown")) {
            this.craftItem(new Object[] { null, 3, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Items.dye, Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass) });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.stained_glass)) && result.getMetadata() == 12) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("GlassBlue")) {
            this.craftItem(new Object[] { null, 4, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Items.dye, Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass) });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.stained_glass)) && result.getMetadata() == 11) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("GlassViolet")) {
            this.craftItem(new Object[] { null, 5, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Items.dye, Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass) });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.stained_glass)) && result.getMetadata() == 10) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("GlassTurquoise")) {
            this.craftItem(new Object[] { null, 6, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Items.dye, Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass) });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.stained_glass)) && result.getMetadata() == 9) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("GlassLightGrey")) {
            this.craftItem(new Object[] { null, 7, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Items.dye, Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass) });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.stained_glass)) && result.getMetadata() == 8) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("GlassGrey")) {
            this.craftItem(new Object[] { null, 8, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Items.dye, Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass) });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.stained_glass)) && result.getMetadata() == 7) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("GlassPink")) {
            this.craftItem(new Object[] { null, 9, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Items.dye, Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass) });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.stained_glass)) && result.getMetadata() == 6) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("GlassLightGreen")) {
            this.craftItem(new Object[] { null, 10, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Items.dye, Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass) });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.stained_glass)) && result.getMetadata() == 5) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("GlassYellow")) {
            this.craftItem(new Object[] { null, 11, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Items.dye, Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass) });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.stained_glass)) && result.getMetadata() == 4) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("GlassLightBlue")) {
            this.craftItem(new Object[] { null, 12, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Items.dye, Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass) });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.stained_glass)) && result.getMetadata() == 3) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("GlassMagenta")) {
            this.craftItem(new Object[] { null, 13, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Items.dye, Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass) });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.stained_glass)) && result.getMetadata() == 2) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("GlassOrange")) {
            this.craftItem(new Object[] { null, 14, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Items.dye, Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass) });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.stained_glass)) && result.getMetadata() == 1) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("GlassWhite")) {
            this.craftItem(new Object[] { null, 15, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Items.dye, Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass) });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.stained_glass)) && result.getMetadata() == 0) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("wood")) {
            this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.log), null, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.planks))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
            this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.log2), null, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.planks))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("chest")) {
            this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.planks), Item.getItemFromBlock(Blocks.planks), Item.getItemFromBlock(Blocks.planks), Item.getItemFromBlock(Blocks.planks), null, Item.getItemFromBlock(Blocks.planks), Item.getItemFromBlock(Blocks.planks), Item.getItemFromBlock(Blocks.planks), Item.getItemFromBlock(Blocks.planks) });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.chest)) && result.getMetadata() == 0) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("redstonechest")) {
            this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.chest), Item.getItemFromBlock(Blocks.tripwire_hook), null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.trapped_chest)) && result.getMetadata() == 0) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("enderchest")) {
            this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.obsidian), Item.getItemFromBlock(Blocks.obsidian), Item.getItemFromBlock(Blocks.obsidian), Item.getItemFromBlock(Blocks.obsidian), Items.ender_eye, Item.getItemFromBlock(Blocks.obsidian), Item.getItemFromBlock(Blocks.obsidian), Item.getItemFromBlock(Blocks.obsidian), Item.getItemFromBlock(Blocks.obsidian), Item.getItemFromBlock(Blocks.obsidian) });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.ender_chest)) && result.getMetadata() == 0) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("tripwirehook")) {
            this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { Items.iron_ingot, null, null, Items.stick, null, null, Item.getItemFromBlock(Blocks.planks), null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.tripwire_hook)) && result.getMetadata() == 0) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("stick")) {
            this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.planks), null, null, Item.getItemFromBlock(Blocks.planks), null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.stick) && result.getMetadata() == 0) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("PolishedAndesite")) {
            this.craftItem(new Object[] { null, null, null, 5, 5, null, 5, 5, null }, new Object[] { null, null, null, Item.getItemFromBlock(Blocks.stone), Item.getItemFromBlock(Blocks.stone), null, Item.getItemFromBlock(Blocks.stone), Item.getItemFromBlock(Blocks.stone), null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.stone)) && result.getMetadata() == 6) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("PolishedDiorite")) {
            this.craftItem(new Object[] { null, null, null, 3, 3, null, 3, 3, null }, new Object[] { null, null, null, Item.getItemFromBlock(Blocks.stone), Item.getItemFromBlock(Blocks.stone), null, Item.getItemFromBlock(Blocks.stone), Item.getItemFromBlock(Blocks.stone), null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.stone)) && result.getMetadata() == 4) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("PolishedGranite")) {
            this.craftItem(new Object[] { null, null, null, 1, 1, null, 1, 1, null }, new Object[] { null, null, null, Item.getItemFromBlock(Blocks.stone), Item.getItemFromBlock(Blocks.stone), null, Item.getItemFromBlock(Blocks.stone), Item.getItemFromBlock(Blocks.stone), null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.stone)) && result.getMetadata() == 2) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("book")) {
            this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { null, null, null, Items.paper, Items.paper, null, Items.paper, Items.leather, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.book)) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("Piston")) {
            this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.planks), Item.getItemFromBlock(Blocks.planks), Item.getItemFromBlock(Blocks.planks), Item.getItemFromBlock(Blocks.cobblestone), Items.iron_ingot, Item.getItemFromBlock(Blocks.cobblestone), Item.getItemFromBlock(Blocks.cobblestone), Items.redstone, Item.getItemFromBlock(Blocks.cobblestone) });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.piston))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("stickyPiston")) {
            this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { null, null, null, null, Items.slime_ball, null, null, Item.getItemFromBlock(Blocks.piston), null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.sticky_piston))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("Furnace")) {
            this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.cobblestone), Item.getItemFromBlock(Blocks.cobblestone), Item.getItemFromBlock(Blocks.cobblestone), Item.getItemFromBlock(Blocks.cobblestone), null, Item.getItemFromBlock(Blocks.cobblestone), Item.getItemFromBlock(Blocks.cobblestone), Item.getItemFromBlock(Blocks.cobblestone), Item.getItemFromBlock(Blocks.cobblestone) });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.furnace))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("Cauldron")) {
            this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { Items.iron_ingot, null, Items.iron_ingot, Items.iron_ingot, null, Items.iron_ingot, Items.iron_ingot, Items.iron_ingot, Items.iron_ingot });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.cauldron))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("noteblock")) {
            this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.planks), Item.getItemFromBlock(Blocks.planks), Item.getItemFromBlock(Blocks.planks), Item.getItemFromBlock(Blocks.planks), Items.redstone, Item.getItemFromBlock(Blocks.planks), Item.getItemFromBlock(Blocks.planks), Item.getItemFromBlock(Blocks.planks), Item.getItemFromBlock(Blocks.planks) });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.noteblock))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("jukebox")) {
            this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.planks), Item.getItemFromBlock(Blocks.planks), Item.getItemFromBlock(Blocks.planks), Item.getItemFromBlock(Blocks.planks), Items.diamond, Item.getItemFromBlock(Blocks.planks), Item.getItemFromBlock(Blocks.planks), Item.getItemFromBlock(Blocks.planks), Item.getItemFromBlock(Blocks.planks) });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.jukebox))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("Bucket")) {
            this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { null, null, null, Items.iron_ingot, null, Items.iron_ingot, null, Items.iron_ingot, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.dye)) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("Beacon")) {
            this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.glass), Items.nether_star, Item.getItemFromBlock(Blocks.glass), Item.getItemFromBlock(Blocks.obsidian), Item.getItemFromBlock(Blocks.obsidian), Item.getItemFromBlock(Blocks.obsidian) });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.beacon))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("EnchantingTable")) {
            this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { null, Items.book, null, Items.diamond, Item.getItemFromBlock(Blocks.obsidian), Items.diamond, Item.getItemFromBlock(Blocks.obsidian), Item.getItemFromBlock(Blocks.obsidian), Item.getItemFromBlock(Blocks.obsidian) });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.enchanting_table))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("CraftingTable")) {
            this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { null, null, null, Item.getItemFromBlock(Blocks.planks), Item.getItemFromBlock(Blocks.planks), null, Item.getItemFromBlock(Blocks.planks), Item.getItemFromBlock(Blocks.planks), null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.crafting_table))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("BrewingStand")) {
            this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { null, null, null, null, Items.blaze_rod, null, Item.getItemFromBlock(Blocks.cobblestone), Item.getItemFromBlock(Blocks.cobblestone), Item.getItemFromBlock(Blocks.cobblestone) });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemFromBlock(Blocks.brewing_stand))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("Shears")) {
            this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { null, null, null, null, Items.iron_ingot, null, Items.iron_ingot, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.shears)) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("EyeOfEnder")) {
            this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { null, null, null, null, Items.ender_pearl, null, null, Items.blaze_powder, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.ender_eye)) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("BlazePowder")) {
            this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { null, null, null, null, Items.blaze_rod, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.blaze_powder)) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("Bread")) {
            this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { Items.wheat, Items.wheat, Items.wheat, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.bread)) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("Cake")) {
            this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { Items.milk_bucket, Items.milk_bucket, Items.milk_bucket, Items.sugar, Items.egg, Items.sugar, Items.wheat, Items.wheat, Items.wheat });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.cake)) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("Cookie")) {
            this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { Items.wheat, Items.dye, Items.wheat, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.cookie)) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("GoldenApple")) {
            this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { Items.gold_ingot, Items.gold_ingot, Items.gold_ingot, Items.gold_ingot, Items.apple, Items.gold_ingot, Items.gold_ingot, Items.gold_ingot, Items.gold_ingot });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.golden_apple)) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("OPGoldenApple")) {
            this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.gold_block), Item.getItemFromBlock(Blocks.gold_block), Item.getItemFromBlock(Blocks.gold_block), Item.getItemFromBlock(Blocks.gold_block), Items.apple, Item.getItemFromBlock(Blocks.gold_block), Item.getItemFromBlock(Blocks.gold_block), Item.getItemFromBlock(Blocks.gold_block), Item.getItemFromBlock(Blocks.gold_block) });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.golden_apple)) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("GoldenCarrot")) {
            this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { Items.gold_nugget, Items.gold_nugget, Items.gold_nugget, Items.gold_nugget, Items.carrot, Items.gold_nugget, Items.gold_nugget, Items.gold_nugget, Items.gold_nugget });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.golden_carrot)) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("PumpkinPie")) {
            this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.pumpkin), Items.sugar, Items.egg, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.pumpkin_pie)) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("MushroomStew")) {
            this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { Item.getItemById(39), Item.getItemById(40), Item.getItemById(281), null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemById(282))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("RabbitStew")) {
            this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { null, Item.getItemById(412), null, Item.getItemById(40), Item.getItemById(393), Item.getItemById(391), null, Item.getItemById(281), null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemById(413))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("Bowl")) {
            this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { Item.getItemFromBlock(Blocks.planks), null, Item.getItemFromBlock(Blocks.planks), null, Item.getItemFromBlock(Blocks.planks), null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.bowl)) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("GoldenMelon")) {
            this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { Items.gold_nugget, Items.gold_nugget, Items.gold_nugget, Items.gold_nugget, Items.melon, Items.gold_nugget, Items.gold_nugget, Items.gold_nugget, Items.gold_nugget });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.speckled_melon)) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("Clock")) {
            this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { null, Items.gold_ingot, null, Items.gold_ingot, Items.redstone, Items.gold_ingot, null, Items.gold_ingot, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.clock)) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("ArmorStand")) {
            this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { Items.stick, Items.stick, Items.stick, null, Items.stick, null, Items.stick, Item.getItemFromBlock(Blocks.stone_slab), Items.stick });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.armor_stand)) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("WoodTrapdoor")) {
            this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { Item.getItemById(5), Item.getItemById(5), Item.getItemById(5), Item.getItemById(5), Item.getItemById(5), Item.getItemById(5), null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemById(96))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("IronTrapdoor")) {
            this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { Item.getItemById(265), Item.getItemById(265), null, Item.getItemById(265), Item.getItemById(265), null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemById(167))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("Coal")) {
            this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { Item.getItemById(173), null, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemById(263))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("Lapis")) {
            this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { Item.getItemById(22), null, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemById(351))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("Redstone")) {
            this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { Item.getItemById(152), null, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemById(331))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("Iron")) {
            this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { Item.getItemById(42), null, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemById(265))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("GoldNugget")) {
            this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { Item.getItemById(266), null, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemById(371))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("Gold")) {
            this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { Item.getItemById(41), null, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemById(266))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("Diamond")) {
            this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { Item.getItemById(57), null, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemById(264))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("Emerald")) {
            this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { Item.getItemById(133), null, null, null, null, null, null, null, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Item.getItemById(388))) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
        
        /** CURRENTLY NOT IMPLEMENTED */
        else if(mineUtil.getCraftSelection().equalsIgnoreCase("FlowerPot")) {
            this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { null, null, null, Items.brick, null, Items.brick, null, Items.brick, null });
            if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.flower_pot)) {
                playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
                time.reset();
            }
        }
//        else if(mineUtil.getCraftSelection().equalsIgnoreCase("fireworkstar")) {
//        	this.craftItem(new Object[] { null, null, null, null, null, null, null, null, null }, new Object[] { Items.dye, Items.dye, Items.dye, Items.dye, Items.diamond, Items.glowstone_dust, Items.gunpowder, Items.fire_charge, null });
//        	if(time.hasReached(mineUtil.getSettings().getModCraftDelay()) && result != null && result.getItem().equals(Items.firework_charge)) {
//        		playerCtrl.windowClick(workbench.windowId, 0, 1, 1, player);
//        		time.reset();
//        	}
//        }
	}
	
//	15 = black / 0 = white
//	private final ItemStack getColor(int subId) {
//		ItemStack itm = new ItemStack(Items.dye);
//		if(itm.getItem() == Items.dye && itm.getMetadata() == subId) {
//			return itm;
//		}
//		return null;
//	}
	
	private void craftItem(final Object[] subTypes, final Object[] neededItems) {
        final EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;
        final PlayerControllerMP playerCtrl = Minecraft.getMinecraft().playerController;
        final ContainerWorkbench workbench = (ContainerWorkbench)player.openContainer;
        for (int i = 1; i <= 9; ++i) {
            final ItemStack craftingCurrent = workbench.getSlot(i).getStack();
            if(craftingCurrent == null) {
                for (int pis = 10; pis <= 45; ++pis) {
                    final ItemStack currentInPI = workbench.getSlot(pis).getStack();
                    if(currentInPI != null && neededItems[i - 1] != null) {
                        if(neededItems[i - 1] instanceof Item && currentInPI.getItem().equals(neededItems[i - 1])) {
                            boolean pickItem = false;
                            if(currentInPI.getHasSubtypes() && subTypes != null && subTypes[i - 1] != null) {
                                if(subTypes[i - 1] instanceof Integer && currentInPI.getMetadata() == (Integer) subTypes[i - 1]) {
                                    pickItem = true;
                                }
                            }
                            else {
                                pickItem = true;
                            }
                            if(this.time.hasReached(MineUtil.getUtilCore().getSettings().getModCraftDelay()) && pickItem) {
                                playerCtrl.windowClick(workbench.windowId, pis, 0, 0, player);
                                playerCtrl.windowClick(workbench.windowId, i, 0, 0, player);
                                this.time.reset();
                            }
                        }
                        else if(neededItems[i - 1] instanceof Block && currentInPI.getItem().equals(Item.getItemFromBlock((Block) neededItems[i - 1])) && this.time.hasReached(MineUtil.getUtilCore().getSettings().getModCraftDelay())) {
                            boolean pickItem = false;
                            if(currentInPI.getHasSubtypes() && subTypes != null && subTypes[i - 1] != null) {
                                if(subTypes[i - 1] instanceof Integer && currentInPI.getMetadata() == (Integer)subTypes[i - 1]) {
                                    pickItem = true;
                                }
                            }
                            else {
                                pickItem = true;
                            }
                            if(this.time.hasReached(MineUtil.getUtilCore().getSettings().getModCraftDelay()) && pickItem) {
                                playerCtrl.windowClick(workbench.windowId, pis, 0, 0, player);
                                playerCtrl.windowClick(workbench.windowId, i, 0, 0, player);
                                this.time.reset();
                            }
                        }
                    }
                }
            }
        }
    }
}
