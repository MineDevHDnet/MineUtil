package net.minedevhd.mineutil.helper;

import net.labymod.core.LabyModCore;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiDisconnected;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.MineUtil.CGui;
import net.minedevhd.mineutil.command.Command;
import net.minedevhd.mineutil.command.CommandManager;
import net.minedevhd.mineutil.gui.reconnect.ReconnectGui;
import net.minedevhd.mineutil.modules.KeyStrokesModule;
import net.minedevhd.mineutil.utils.Exploit;
import net.minedevhd.mineutil.utils.HeadDownloaderUtil;

public class TickHelper {
	
	private static final MineUtil mineUtil = MineUtil.getUtilCore();
	GuiScreen guiScreen;
	public static Integer secondsLeft = 6;
	private final TimeHelper time = new TimeHelper();
	
	@SubscribeEvent(priority = EventPriority.NORMAL)
    public void onTick(final TickEvent.ClientTickEvent event) throws InterruptedException {
        if(mineUtil.getSettings().getModEnabled()) {
            final EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;
            final PlayerControllerMP playerCtrl = Minecraft.getMinecraft().playerController;
            
            if(player != null && CGui.isGUIToggled() && !CGui.isGUIOpend()) {
            	CGui.setGUIOpend(true);
            }
            
            if(player != null) {
                final Container container = player.openContainer;
                
                if(!CGui.isGUIOpend()) {
                	if(container != null && container instanceof ContainerChest && mineUtil.getCleanSelection().length() > 0) {
                		final ContainerChest chest = (ContainerChest) container;
                		
                		if(mineUtil.getCleanSelection().toLowerCase().contains("cheststealer")) {
                			StealHelper.steal(player, playerCtrl, container);
                		}
                		else {
                			mineUtil.getCleanHelper().clean(mineUtil, player, playerCtrl, container);
                		}
                	}
                	
                	if(container != null && container instanceof ContainerWorkbench && mineUtil.getCraftSelection().length() > 0) {
                		mineUtil.getCraftHelper().craft(mineUtil, player, playerCtrl, container);
                	}
                }
                
                if(container != null && container instanceof ContainerChest) {
                	final ContainerChest chest = (ContainerChest) container;
                	
                	if(mineUtil.getSettings().isModGGAntiAFK()
                			&& chest.getLowerChestInventory().getName().toLowerCase().contains("afk")) {
                		Exploit.GrieferGames.AntiAFK.grabItem(chest, player, playerCtrl);
                	}
                }
            }
            HeadDownloaderUtil.onKeyPress();
            
            for(Command command : CommandManager.getCommands()) { command.update(); }
            
            KeyStrokesModule.canUse(mineUtil);
            
            if(guiScreen instanceof ReconnectGui && this.time.hasReached(20)) {
            	if(secondsLeft <= 6) {
            		secondsLeft--;
            	}
            	else
            		if(secondsLeft <= -1) {
            			secondsLeft = 6;
            		}
            	
            	switch (secondsLeft) {
            	case 6:
            		ReconnectGui.reconnectButton.displayString = "Reconnect in: §e" + secondsLeft + "s";
            		break;
            	case 5:
            	case 4:
            		ReconnectGui.reconnectButton.displayString = "Reconnect in: §6" + secondsLeft + "s";
            		break;
            	case 3:
            	case 2:
            	case 1:
            		ReconnectGui.reconnectButton.displayString = "Reconnect in: §c" + secondsLeft + "s";
            		break;
            	case 0:
            		ReconnectGui.reconnectButton.displayString = "Reconnect in: §4" + secondsLeft + "s";
            		break;
            	}
            	this.time.reset();
            }
            
        }
    }
		
}
