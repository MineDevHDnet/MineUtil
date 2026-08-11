package net.minedevhd.mineutil.helper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minedevhd.mineutil.MineUtil.CCGui;
import net.minedevhd.mineutil.command.Command;
import net.minedevhd.mineutil.command.CommandManager;
import net.minedevhd.mineutil.modules.KeyStrokesModule;
import net.minedevhd.mineutil.modules.mods.ToolSaveMod;
import net.minedevhd.mineutil.settings.UtilCore;
import net.minedevhd.mineutil.utils.Exploit;
import net.minedevhd.mineutil.utils.HeadDownloaderUtil;

public final class TickHelper implements UtilCore {

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void onTick(final TickEvent.ClientTickEvent event) {
        if (event == null || event.phase != TickEvent.Phase.END) {
            return;
        }

        if (mineUtil.getSettings() == null || !mineUtil.getSettings().isModEnabled()) {
            return;
        }

        final Minecraft minecraft = mineUtil.getMinecraft();
        if (minecraft == null) {
            return;
        }

        final EntityPlayerSP player = minecraft.thePlayer;
        final PlayerControllerMP playerController = minecraft.playerController;

        if (player != null && playerController != null) {
            if (CCGui.isGUIToggled() && !CCGui.isGUIOpend()) {
                CCGui.setGUIOpend(true);
            }

            final Container container = player.openContainer;
            if (!CCGui.isGUIOpend()) {
                handleCleanAndCraft(player, playerController, container);
            }

            if (container instanceof ContainerChest && mineUtil.getSettings().isModGGAntiAFK()) {
                final ContainerChest chest = (ContainerChest) container;
                if (chest.getLowerChestInventory() != null
                        && chest.getLowerChestInventory().getName() != null
                        && chest.getLowerChestInventory().getName().toLowerCase().contains("afk")) {
                    Exploit.GrieferGames.AntiAFK.grabItem(chest, player, playerController);
                }
            }
        }

        HeadDownloaderUtil.onKeyPress();

        for (final Command command : CommandManager.getCommands()) {
            try {
                command.update();
            } catch (final RuntimeException exception) {
                System.err.println("[MineUtil] Tick update failed for command " + command.getName());
                exception.printStackTrace();
            }
        }

        ToolSaveMod.saveTool();
        KeyStrokesModule.canUse(mineUtil);
    }

    private void handleCleanAndCraft(final EntityPlayerSP player,
                                     final PlayerControllerMP playerController,
                                     final Container container) {
        if (container instanceof ContainerChest && !mineUtil.getCleanSelection().isEmpty()) {
            if (mineUtil.getCleanSelection().toLowerCase().contains("cheststealer")) {
                StealHelper.steal(player, playerController, container);
            } else {
                mineUtil.getCleanHelper().clean(player, playerController, container);
            }
        }

        if (container instanceof ContainerWorkbench && !mineUtil.getCraftSelection().isEmpty()) {
            mineUtil.getCraftHelper().craft(player, playerController, container);
        }
    }
}
