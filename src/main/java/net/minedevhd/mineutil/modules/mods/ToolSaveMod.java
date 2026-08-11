package net.minedevhd.mineutil.modules.mods;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minedevhd.mineutil.settings.UtilCore;
import net.minedevhd.mineutil.utils.graf.DrawUtil;

public final class ToolSaveMod implements UtilCore {

    private static final int DAMAGE_THRESHOLD = 3;

    @SubscribeEvent
    public void onMouse(final MouseEvent event) {
        if (DAMAGE_THRESHOLD <= 0 || event == null) {
            return;
        }
        if ((event.button != 0 && event.button != 1) || !event.buttonstate) {
            return;
        }
        if (shouldCancel()) {
            event.setCanceled(true);
        }
    }

    private static boolean shouldCancel() {
        if (mineUtil == null || mineUtil.getMinecraft() == null) {
            return false;
        }

        final EntityPlayerSP player = mineUtil.getMinecraft().thePlayer;
        if (player == null) {
            return false;
        }

        final ItemStack heldItem = player.getHeldItem();
        if (heldItem == null || !heldItem.isItemStackDamageable()) {
            return false;
        }

        final int durabilityLeft = heldItem.getMaxDamage() - heldItem.getItemDamage();
        return durabilityLeft <= DAMAGE_THRESHOLD;
    }

    public static void saveTool() {
        if (DAMAGE_THRESHOLD <= 0 || !shouldCancel()) {
            return;
        }
        if (mineUtil.getMinecraft().gameSettings == null) {
            return;
        }

        KeyBinding.setKeyBindState(
                mineUtil.getMinecraft().gameSettings.keyBindUseItem.getKeyCode(),
                false
        );
        KeyBinding.setKeyBindState(
                mineUtil.getMinecraft().gameSettings.keyBindAttack.getKeyCode(),
                false
        );
        DrawUtil.drawTitleString("§4⚠ §6Warnung §4⚠", "§cDein Item geht gleich kaputt!");
    }

    public static boolean canBeRepaired(final ItemStack itemStack) {
        if (itemStack == null || !itemStack.isItemStackDamageable()) {
            return false;
        }

        final int xpCost = itemStack.getRepairCost()
                + (itemStack.getItemDamage() >= itemStack.getMaxDamage() / 4 ? 1 : 2);
        return xpCost < 40;
    }
}
