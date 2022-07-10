package net.minedevhd.mineutil;

import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.swing.JOptionPane;

import com.mojang.authlib.GameProfile;

import io.netty.buffer.Unpooled;
import net.labymod.api.LabyModAddon;
import net.labymod.api.events.MessageModifyChatEvent;
import net.labymod.api.events.MessageReceiveEvent;
import net.labymod.api.events.MessageSendEvent;
import net.labymod.api.events.RenderIngameOverlayEvent;
import net.labymod.core.LabyModCore;
import net.labymod.ingamegui.Module;
import net.labymod.ingamegui.ModuleCategory;
import net.labymod.ingamegui.ModuleCategoryRegistry;
import net.labymod.main.LabyMod;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.utils.Consumer;
import net.labymod.utils.Material;
import net.labymod.utils.ModColor;
import net.labymod.utils.ServerData;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.C17PacketCustomPayload;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minedevhd.mineutil.command.Command;
import net.minedevhd.mineutil.command.CommandManager;
import net.minedevhd.mineutil.command.impl.AutoRespawn;
import net.minedevhd.mineutil.command.impl.Autowalk;
import net.minedevhd.mineutil.command.impl.Sprint;
import net.minedevhd.mineutil.gui.cleanandcraft.ausrangiert.CleanCraftGui;
import net.minedevhd.mineutil.gui.reconnect.ReconnectListener;
import net.minedevhd.mineutil.gui.storageprices.TEDLagerPreisGui;
import net.minedevhd.mineutil.helper.CleanHelper;
import net.minedevhd.mineutil.helper.CraftHelper;
import net.minedevhd.mineutil.helper.KeyStroking;
import net.minedevhd.mineutil.helper.StealHelper;
import net.minedevhd.mineutil.helper.TickHelper;
import net.minedevhd.mineutil.helper.TimeHelper;
import net.minedevhd.mineutil.helper.TrustedUserHelper;
import net.minedevhd.mineutil.modules.DispalyCleanIngameModule;
import net.minedevhd.mineutil.modules.DispalyCraftIngameModule;
import net.minedevhd.mineutil.modules.FlightStatusModule;
import net.minedevhd.mineutil.modules.HeadOwnerModule;
import net.minedevhd.mineutil.modules.KeyStrokesModule;
import net.minedevhd.mineutil.modules.MiniMeModule;
import net.minedevhd.mineutil.modules.NewHotbarModule;
import net.minedevhd.mineutil.modules.ShowMCNameModule;
import net.minedevhd.mineutil.modules.SkinHeadModule;
import net.minedevhd.mineutil.modules.griefergames.AFKMSGModule;
import net.minedevhd.mineutil.modules.griefergames.CleanSpawnerErrorModule;
import net.minedevhd.mineutil.modules.griefergames.ClearEmptyCharModule;
import net.minedevhd.mineutil.modules.griefergames.MoneyDropGrabberModule;
import net.minedevhd.mineutil.modules.griefergames.RealMoneyModule;
import net.minedevhd.mineutil.modules.griefergames.SudoModule;
import net.minedevhd.mineutil.modules.mods.FreeCamMod;
import net.minedevhd.mineutil.settings.ModSettings;
import net.minedevhd.mineutil.utils.Exploit;
import net.minedevhd.mineutil.utils.HeadDownloaderUtil;
import net.minedevhd.mineutil.utils.ModButton;
import net.minedevhd.mineutil.utils.RenderUtils;
import net.minedevhd.mineutil.utils.discord.Discord;

public class MineUtil extends LabyModAddon {
	
    private static MineUtil mineUtil;
    private static ModSettings settings;
    
    private final static String VERSION = "1.3.4", 
    							CHANGELOG_DATE = "10. July";

    public static ModuleCategory MINEUTIL_CATEGORY;
    
    private String cleanSelection = "", 
    			   craftSelection = "";
    
    private net.minecraft.client.multiplayer.ServerData lastServer;

    private final String discordWebhook = "https://discord.com/api/webhooks/952161978556776488/tVcokazHcSgThA9uv-ZBBN2h4SXbTlMHrkWRbbIraDoF_jwu2qqqTTwiOYspF7jg809i";

    private boolean onGrieferGames = false, 
    				guiToggled = false, 
    				guiOpend = false;
    
    private final boolean DEVMODE = false;
    
    public boolean isGuiKeyPressed;
    
    private final CleanHelper cleanHelper = new CleanHelper();
    private final CraftHelper craftHelper = new CraftHelper();
    
    public static void main(final String[] args) {
        JOptionPane.showMessageDialog(null, "Addon für LabyMod 3-1.8.9 -> In '%appdata%/.minecraft/LabyMod/addons-1.8' kopieren", "MineUtil | Entwickelt von MineDev_HD", 2);
    }
    
    public final static MineUtil getUtilCore() {
        return MineUtil.mineUtil;
    }
    
    public final String getVersion() {
		return this.VERSION + (this.VERSION.endsWith("0") ? "-release" : "-beta");
	}
    
    public final Minecraft getMCCore() {
        return Minecraft.getMinecraft();
    }
    
    private static final void setUtilCore(final MineUtil mineUtil) {
        MineUtil.mineUtil = mineUtil;
    }
    
    public final ModSettings getSettings() {
        return MineUtil.settings;
    }
    
    private final void setSettings(final ModSettings settings) {
        MineUtil.settings = settings;
    }
    
    public static class CGui {
    	
    	private static boolean guiToggled = false;
    	private static boolean guiOpend = false;
    	    
    	public static final void setGUIToggled(final boolean guiToggled) {
    		CGui.guiToggled = guiToggled;
        }
        
        public static final boolean isGUIToggled() {
            return guiToggled;
        }
        
        public static final void setGUIOpend(final boolean guiOpend) {
        	CGui.guiOpend = guiOpend;
        }
        
        public static final boolean isGUIOpend() {
            return guiOpend;
        }
    	
    }
    
    public boolean isOnGrieferGames() {
		return this.onGrieferGames;
	}
    
    public void setGrieferGames(boolean onGrieferGames) {
		this.onGrieferGames = onGrieferGames;
	}
    
    public final CleanHelper getCleanHelper() {
		return this.cleanHelper;
	}
    
    public final CraftHelper getCraftHelper() {
		return this.craftHelper;
	}
    
    public final String getCleanSelection() {
        return this.cleanSelection;
    }
    
    public final void setCleanSelection(final String cleanSelection) {
        this.cleanSelection = cleanSelection;
    }
    
    public final String getCraftSelection() {
        return this.craftSelection;
    }
    
    public final void setCraftSelection(final String craftSelection) {
        this.craftSelection = craftSelection;
    }
    
    public MineUtil() {
        this.isGuiKeyPressed = false;
    }
    
    public void onEnable() {
        if(!this.isValidUser()) {
        	if(!this.isDevmode()) {
        		Discord.write(this.discordWebhook, "Login Viewer", "Player " + this.getMCCore().getSession().getProfile().getName() + " tried to play LabyMod with MineUtil-b" + this.getVersion() + "!");
        		this.strike();
            }
        }
    	
    	this.setUtilCore(this);
    	this.setSettings(new ModSettings());
        new File(Minecraft.getMinecraft().mcDataDir, "MineUtil\\head_textures\\mkdir.png").getParentFile().mkdirs();
        
    	ModuleCategoryRegistry.loadCategory(this.MINEUTIL_CATEGORY = new ModuleCategory("MineUtil", true, 
    			new ControlElement.IconData(new ResourceLocation("labymod/addons/MineUtil/textures/utillogo.jpg"))));

        this.getApi().registerForgeListener((Object) new TickHelper());
        this.getApi().registerForgeListener((Object) new KeyStroking());
//        this.getApi().registerForgeListener((Object) new ReconnectListener());
        
        this.getApi().registerModule((Module) new DispalyCraftIngameModule());
        this.getApi().registerModule((Module) new DispalyCleanIngameModule());
        this.getApi().registerModule((Module) new NewHotbarModule());
        this.getApi().registerModule((Module) new MiniMeModule());
        this.getApi().registerModule((Module) new SkinHeadModule());
        this.getApi().registerModule((Module) new HeadOwnerModule());
        this.getApi().registerModule((Module) new FlightStatusModule());
        this.getApi().registerModule((Module) new ShowMCNameModule());
        this.getApi().registerModule((Module) new KeyStrokesModule());
        
        /* received messages */
        CleanSpawnerErrorModule.init(this.getUtilCore());
        ClearEmptyCharModule.init(this.getUtilCore());
        MoneyDropGrabberModule.init(this.getUtilCore());
        AFKMSGModule.init(this.getUtilCore());
        RealMoneyModule.init(this.getUtilCore());
        SudoModule.init(this.getUtilCore());
        
        /* command base */
        Command.init();
        
        this.getApi().getEventManager().register(new RenderIngameOverlayEvent() {
			@Override
			public void onRender(float f) {
				try {
		    		final FontRenderer font = getMCCore().fontRendererObj;
		    		final ArrayList<Command> commands = new ArrayList<Command>();
		        	
		        	for(Command c : CommandManager.getCommands())
		        		if(c.isActivated()) commands.add(c);
		        
//		        	@Info: Sortiert die Liste nach Text-länge von oben nach unten.
//		    		commands.sort((m1, m2) -> font.getStringWidth(m2.getName()) - font.getStringWidth(m1.getName()));
		        	
		        	int y = 0;
		        	for(Command cmds : commands) {
		        		renderModule(getMCCore(), RenderUtils.getResolution(), y, font.getStringWidth(cmds.getDisplayName()), cmds.getDisplayName());
		        		y += 10;
		        	}
				} catch (Exception exception) {}	
			}
		});
        
        this.getApi().getEventManager().registerOnJoin((Consumer<ServerData>) new Consumer<ServerData>() {
			public void accept(ServerData args) {
				if(mineUtil.getSettings().getModEnabled()) {
					LabyMod.getInstance().getGuiCustomAchievement().displayAchievement("MineUtil", "Danke, dass du die MineUtil benutzt!");
					
					if(args.getIp().contains("griefergames")) {
						if(mineUtil.getSettings().isModGGAutoPortal())
							MineUtil.getUtilCore().getMCCore().thePlayer.sendChatMessage("/portal");
						Exploit.GrieferGames.MysteryMod.startProxy();
						mineUtil.setGrieferGames(true);
					}
				}
			}
		});
        Exploit.HeadDownloader.register();
        
        if(this.getSettings().isModFullbright()) {
        	MineUtil.getUtilCore().getMCCore().gameSettings.gammaSetting = 10.0f;
        }
        else {
    		MineUtil.getUtilCore().getMCCore().gameSettings.gammaSetting = 1.0f;
    	}
    }
	
	private void renderModule(final Minecraft mc, final ScaledResolution sr, final int height, final int length, final String string) {
    	GuiScreen.drawRect(sr.getScaledWidth(), height + 1, sr.getScaledWidth() - length - 5, height + 11, new Color(0, 0, 0, 130).getRGB());
    	GuiScreen.drawRect(sr.getScaledWidth(), height + 1, sr.getScaledWidth() - 2, height + 11, ModButton.toRainbow(18));
    	new Gui().drawString(mc.fontRendererObj, string, sr.getScaledWidth() - length - 3, height + 2, 16777215);
    }
    
	public boolean isValidUser() {
		final GameProfile profile = Minecraft.getMinecraft().getSession().getProfile();

		TrustedUserHelper.loadUUIDConfigs();
	  /*try {
			int r = new InputStreamReader(new URL("https://minedevhd.net/laby/whitelist/" + profile.getId().toString() + ".txt").openStream()).read();
			return ((char) r) == '1';
		} catch (IOException exception) {}*/
        if(TrustedUserHelper.contains(profile.getId())) {
        	Discord.write(this.discordWebhook, "Protocol", "Player " + this.getMCCore().getSession().getProfile().getName() + " plays now LabyMod with MineUtil-b" + this.getVersion() + "!");
            return true;
        }
        return false;
    }
    
    public void loadConfig() {
        this.getSettings().loadConfig();
    }
    
    protected void fillSettings(final List<SettingsElement> settings) {
        this.getSettings().fillSettings(settings);
    }
    
    public final String getChangelogDate() {
    	return this.CHANGELOG_DATE;
    }
    
    public boolean isDevmode() {
		return this.DEVMODE;
	}
    
    public final String getDiscordWebhook() {
		return this.discordWebhook;
	}
    
    public void strike() {
    	((String) null).substring(-1, -1).concat(null).charAt(45);
    }

	public net.minecraft.client.multiplayer.ServerData getLastServer() {
		return null;
	}

	public void setLastServer(net.minecraft.client.multiplayer.ServerData lastServer) {
		this.lastServer = lastServer;
	}
    
}