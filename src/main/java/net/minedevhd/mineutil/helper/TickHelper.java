package net.minedevhd.mineutil.helper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.MineUtil.CCGui;
import net.minedevhd.mineutil.command.Command;
import net.minedevhd.mineutil.command.CommandManager;
import net.minedevhd.mineutil.modules.KeyStrokesModule;
import net.minedevhd.mineutil.modules.mods.ToolSaveMod;
import net.minedevhd.mineutil.settings.UtilCore;
import net.minedevhd.mineutil.utils.Exploit;
import net.minedevhd.mineutil.utils.HeadDownloaderUtil;

public class TickHelper implements UtilCore {
	
	private final TimeHelper time = new TimeHelper();
	
	@SubscribeEvent(priority = EventPriority.NORMAL)
    public void onTick(final TickEvent.ClientTickEvent event) throws InterruptedException {
        if(mineUtil.getSettings().isModEnabled()) {
            final EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;
            final PlayerControllerMP playerCtrl = Minecraft.getMinecraft().playerController;
            
            if(player != null) {
            	if(CCGui.isGUIToggled() && !CCGui.isGUIOpend())	CCGui.setGUIOpend(true);
            	
                final Container container = player.openContainer;
                
                if(!CCGui.isGUIOpend()) {
                	if(container != null && container instanceof ContainerChest && mineUtil.getCleanSelection().length() > 0) {
                		final ContainerChest chest = (ContainerChest) container;
                		
                		if(mineUtil.getCleanSelection().toLowerCase().contains("cheststealer"))
                			StealHelper.steal(player, playerCtrl, container);
                		else
                			mineUtil.getCleanHelper().clean(player, playerCtrl, container);
                	}
                	
                	if(container != null && container instanceof ContainerWorkbench && mineUtil.getCraftSelection().length() > 0)
                		mineUtil.getCraftHelper().craft(player, playerCtrl, container);
                }
                
                if(container != null && container instanceof ContainerChest) {
                	final ContainerChest chest = (ContainerChest) container;
                	
                	if(mineUtil.getSettings().isModGGAntiAFK()
                			&& chest.getLowerChestInventory().getName().toLowerCase().contains("afk"))
                		Exploit.GrieferGames.AntiAFK.grabItem(chest, player, playerCtrl);
                }
            }
            HeadDownloaderUtil.onKeyPress();
            
            for(Command command : CommandManager.getCommands()) { command.update(); }
            
            ToolSaveMod.saveTool(playerCtrl);
            
            KeyStrokesModule.canUse(mineUtil);
        }
    }
		
}
