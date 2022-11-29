package net.minedevhd.mineutil;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.lwjgl.opengl.GL11;

import com.mojang.authlib.GameProfile;
import com.mojang.realmsclient.gui.ChatFormatting;

import net.labymod.api.LabyModAddon;
import net.labymod.api.events.RenderIngameOverlayEvent;
import net.labymod.core.LabyModCore;
import net.labymod.core.asm.LabyModCoreMod;
import net.labymod.ingamegui.Module;
import net.labymod.ingamegui.ModuleCategory;
import net.labymod.ingamegui.ModuleCategoryRegistry;
import net.labymod.main.LabyMod;
import net.labymod.main.Source;
import net.labymod.mojang.inventory.GuiInventoryCustom;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.utils.Consumer;
import net.labymod.utils.ServerData;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.network.play.server.S03PacketTimeUpdate;
import net.minecraft.util.ResourceLocation;
import net.minedevhd.mineutil.command.Command;
import net.minedevhd.mineutil.command.CommandManager;
import net.minedevhd.mineutil.credits.Creditzz;
import net.minedevhd.mineutil.helper.CleanHelper;
import net.minedevhd.mineutil.helper.CraftHelper;
import net.minedevhd.mineutil.helper.KeyStrokeHelper;
import net.minedevhd.mineutil.helper.TickHelper;
import net.minedevhd.mineutil.helper.TrustedUserHelper;
import net.minedevhd.mineutil.helper.WerbungHelper;
import net.minedevhd.mineutil.modules.CoordinatesModule;
import net.minedevhd.mineutil.modules.DispalyCleanIngameModule;
import net.minedevhd.mineutil.modules.DispalyCraftIngameModule;
import net.minedevhd.mineutil.modules.HeadOwnerModule;
import net.minedevhd.mineutil.modules.KeyStrokesModule;
import net.minedevhd.mineutil.modules.MiniMeModule;
import net.minedevhd.mineutil.modules.ShowMCNameModule;
import net.minedevhd.mineutil.modules.griefergames.AFKMSGModule;
import net.minedevhd.mineutil.modules.griefergames.CitybuildAutoJoinModule;
import net.minedevhd.mineutil.modules.griefergames.ClearEmptyCharModule;
import net.minedevhd.mineutil.modules.griefergames.EasyPaymentModule;
import net.minedevhd.mineutil.modules.griefergames.GlobalchatDiscordWriter;
import net.minedevhd.mineutil.modules.griefergames.MoneyDropGrabberModule;
import net.minedevhd.mineutil.modules.griefergames.PlotChatIndicator;
import net.minedevhd.mineutil.modules.griefergames.RealMoneyModule;
import net.minedevhd.mineutil.modules.griefergames.SkinHeadModule;
import net.minedevhd.mineutil.modules.griefergames.SudoModule;
import net.minedevhd.mineutil.modules.mods.MapPreviewModule;
import net.minedevhd.mineutil.modules.mods.RepairCostMod;
import net.minedevhd.mineutil.modules.mods.ToolSaveMod;
import net.minedevhd.mineutil.modules.mods.TrajectoriesMod;
import net.minedevhd.mineutil.modules.mods.grieferwert.GrieferWertMod;
import net.minedevhd.mineutil.settings.ModSettings;
import net.minedevhd.mineutil.utils.Exploit;
import net.minedevhd.mineutil.utils.ModButton;
import net.minedevhd.mineutil.utils.discord.Discord;
import net.minedevhd.mineutil.utils.graf.RenderUtils;
import net.minedevhd.mineutil.utils.tech.UpdateUtil;

public class MineUtil extends LabyModAddon {
	
    private static MineUtil mineUtil;
    private static ModSettings settings;
    
    private final static String VERSION = "1.3.92", 
    							CHANGELOG_DATE = "08. November",
    							DOWNLOAD_URL = "https://minedevhd.net/laby/mineutil/download/rel/MineUtil.jar";

    private final String discordWebhook = "https://discord.com/api/webhooks/952161978556776488/tVcokazHcSgThA9uv-ZBBN2h4SXbTlMHrkWRbbIraDoF_jwu2qqqTTwiOYspF7jg809i",
    					 discordAppId = "1001120927754502258";
    
    public final static Integer CLIENT_COLOR = 0x6495ed;

    private String cleanSelection = "",
    			   craftSelection = "";
    
    private ServerData lastServer;
    public ModuleCategory MINEUTIL_CATEGORY;
    
    private boolean onGrieferGames = false,
    				guiToggled = false,
    				guiOpend = false;
    
    public boolean isGuiKeyPressed;

    private final boolean DEVMODE = true;
    
    private final CleanHelper cleanHelper = new CleanHelper();
    private final CraftHelper craftHelper = new CraftHelper();
    
    public static void main(final String[] args) {
    	final JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, "Addon für LabyMod 3-1.8.9 -> In '%appdata%/.minecraft/LabyMod/addons-1.8' kopieren", "MineUtil | Entwickelt von MineDev_HD", 2);
    }
    
    public final static MineUtil getCore() {
        return MineUtil.mineUtil;
    }
    
    public final String getVersion() {
		return this.VERSION + /*(this.VERSION.endsWith("0") ? */"-release"/* : "-beta")*/;
	}
    
    public final Minecraft getMinecraft() {
        return Minecraft.getMinecraft();
    }
    
    private static final void setCore(final MineUtil mineUtil) {
        MineUtil.mineUtil = mineUtil;
    }
    
    public final ModSettings getSettings() {
        return MineUtil.settings;
    }
    
    private final void setSettings(final ModSettings settings) {
        MineUtil.settings = settings;
    }
    
    public static class CCGui {
    	
    	private static boolean guiToggled = false;
    	private static boolean guiOpend = false;
    	    
    	public static final void setGUIToggled(final boolean guiToggled) {
    		CCGui.guiToggled = guiToggled;
        }
        
        public static final boolean isGUIToggled() {
            return guiToggled;
        }
        
        public static final void setGUIOpend(final boolean guiOpend) {
        	CCGui.guiOpend = guiOpend;
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
        if(!this.isValidUser() && !this.isIDE()) {
    		Discord.write(this.discordWebhook, "Login Viewer", "Player " + this.getMinecraft().getSession().getProfile().getName() + " tried to play LabyMod with MineUtil-b" + this.getVersion() + "!", this.getMinecraft().getSession().getProfile().getId(), Color.RED);
    		this.strike();
        }

        this.setCore(this);
    	this.setSettings(new ModSettings());
        new File(Minecraft.getMinecraft().mcDataDir, "MineUtil\\head_textures\\mkdir.png").getParentFile().mkdirs();

        ModuleCategoryRegistry.loadCategory(this.MINEUTIL_CATEGORY = new ModuleCategory("MineUtil", true, 
    			new ControlElement.IconData(new ResourceLocation("labymod/addons/MineUtil/textures/utillogo.jpg"))));

    	this.getApi().registerForgeListener((Object) new TickHelper());
        this.getApi().registerForgeListener((Object) new RepairCostMod());
        this.getApi().registerForgeListener((Object) new PlotChatIndicator());
        this.getApi().registerForgeListener((Object) new GrieferWertMod());
        this.getApi().registerForgeListener((Object) new TrajectoriesMod());
        this.getApi().registerForgeListener((Object) new KeyStrokeHelper());
        this.getApi().registerForgeListener((Object) new MapPreviewModule());
        this.getApi().registerForgeListener((Object) new ToolSaveMod());
        new GrieferWertMod().loadPrices();

        this.getApi().registerModule((Module) new MiniMeModule());
        this.getApi().registerModule((Module) new SkinHeadModule());
        this.getApi().registerModule((Module) new HeadOwnerModule());
        this.getApi().registerModule((Module) new ShowMCNameModule());
        this.getApi().registerModule((Module) new KeyStrokesModule());
        this.getApi().registerModule((Module) new CoordinatesModule());
        this.getApi().registerModule((Module) new DispalyCraftIngameModule());
        this.getApi().registerModule((Module) new DispalyCleanIngameModule());

        /* received messages */
        SudoModule.initModule();
        AFKMSGModule.initModule();
        RealMoneyModule.initModule();
        ClearEmptyCharModule.initModule();
        MoneyDropGrabberModule.initModule();
        EasyPaymentModule.initModule();
        PlotChatIndicator.initModule();
        CitybuildAutoJoinModule.initModule();
        GlobalchatDiscordWriter.initModule();
        WerbungHelper.$witch();

        /* command base */
        Command.initCmdBase();

        this.getApi().getEventManager().register(new RenderIngameOverlayEvent() {
			@Override
			public void onRender(float f) {
				try {
					if(mineUtil.getSettings().isModEnabled()) {
						final FontRenderer font = getMinecraft().fontRendererObj;
						final ArrayList<Command> commands = new ArrayList<Command>();
						
						for(Command c : CommandManager.getCommands())
							if(c.isActiv()) commands.add(c);
						
//		        	@Info: Sortiert die Liste nach Text-länge von oben nach unten.
//		    		commands.sort((m1, m2) -> font.getStringWidth(m2.getName()) - font.getStringWidth(m1.getName()));
						
						int y = 0;
						for(Command cmds : commands) {
							renderModule(getMinecraft(), RenderUtils.getResolution(), y, font.getStringWidth(cmds.getDisplayName()), cmds.getDisplayName());
							y += 10;
						}
						
						/** Mod-Name Renderer */
						final ScaledResolution sr = new ScaledResolution(mineUtil.getMinecraft());
						final String text = "MineUtil | b" + mineUtil.getVersion()/* + " | " + mineUtil.getMCCore().getDebugFPS()*/;
						final Integer i = mineUtil.getMinecraft().fontRendererObj.getStringWidth(text);
						
						GuiScreen.drawRect(5, 15, i + 6, 5, new Color(0, 0, 0, 130).getRGB());
						GuiScreen.drawRect(5, 14, i + 6, 15, ModButton.toRainbow(18));
						new Gui().drawString(mineUtil.getMinecraft().fontRendererObj, text, 6, 6, 16777215);
					}
				} catch (Exception exception) {}	
			}
		});
        
        this.getApi().getEventManager().registerOnJoin((Consumer<ServerData>) new Consumer<ServerData>() {
			public void accept(ServerData serverData) {
				if(mineUtil.getSettings().isModEnabled()) {
//					LabyMod.getInstance().getGuiCustomAchievement().displayAchievement("MineUtil", "Danke, dass du die MineUtil benutzt!");
					LabyMod.getInstance().getGuiCustomAchievement()
						.displayAchievement("https://cdn.discordapp.com/attachments/994561651468668958/994561673551695962/utillogo.jpg",
								"MineUtil b" + mineUtil.getVersion(), String.format("Danke, dass du die MineUtil benutzt!", ""));
					mineUtil.setLastServer(serverData);

					if(serverData.getIp().contains("griefergames")) {
						mineUtil.setGrieferGames(true);
						if(mineUtil.getSettings().isModGGAutoPortal())
							MineUtil.getCore().getMinecraft().thePlayer.sendChatMessage("/portal");
						Exploit.GrieferGames.MysteryMod.startProxy();
					}
					else {
						mineUtil.setGrieferGames(false);
						if(serverData.getIp().contains("minedevhd.net")) { return; }
					}
				}
			}
		});
        Exploit.HeadDownloader.register();

        if(this.getSettings().isModFullbright())
        	MineUtil.getCore().getMinecraft().gameSettings.gammaSetting = 10.0f;
        else
    		MineUtil.getCore().getMinecraft().gameSettings.gammaSetting = 1.0f;
    }
    
    @Override
    public void onDisable() {
//    	try {
//			UpdateUtil.downloadFile(this.DOWNLOAD_URL, "MineUtil.jar");
//		} catch (Exception exception) {}
    	Discord.write(this.getDiscordWebhook(), "Login Viewer", "Player " + this.getMinecraft().getSession().getProfile().getName() + " is now offline.", Color.ORANGE);
    	super.onDisable();
    }
    
	private void renderModule(final Minecraft mc, final ScaledResolution sr, final int height, final int length, final String string) {
    	GuiScreen.drawRect(sr.getScaledWidth(), height + 1, sr.getScaledWidth() - length - 5, height + 11, new Color(0, 0, 0, 130).getRGB());
    	GuiScreen.drawRect(sr.getScaledWidth(), height + 1, sr.getScaledWidth() - 2, height + 11, ModButton.toRainbow(18));
    	new Gui().drawString(mc.fontRendererObj, string, sr.getScaledWidth() - length - 3, height + 2, 16777215);
    }

	public boolean isValidUser() {
		if(!LabyMod.isForge())
			this.strike();

		final GameProfile profile = Minecraft.getMinecraft().getSession().getProfile();

		TrustedUserHelper.loadUUIDConfigs();
	  /*try {
			int r = new InputStreamReader(new URL("https://minedevhd.net/laby/whitelist/" + profile.getId().toString() + ".txt").openStream()).read();
			return ((char) r) == '1';
		} catch (IOException exception) {}*/
        if(TrustedUserHelper.contains(profile.getId())) {
        	Discord.write(this.discordWebhook, "Login Viewer", "Player " + this.getMinecraft().getSession().getProfile().getName() + " plays now LabyMod with MineUtil-b" + this.getVersion() + "!", this.getMinecraft().getSession().getProfile().getId(), Color.GREEN);
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
    
    public boolean isIDE() {
    	final GameProfile profile = Minecraft.getMinecraft().getSession().getProfile();
    	return (profile.getName().startsWith("Player") ? (LabyMod.getInstance().isPremium() ? false : true) : false);
//		return this.DEVMODE;
	}
    
    public final String getDiscordWebhook() {
		return this.discordWebhook;
	}

	public final String getDiscordAppId() {
		return this.discordAppId;
	}

    private void strike() {
    	((String) null).substring(-1, -1).concat(null).charAt(45);
    }

	public ServerData getLastServer() {
		return this.lastServer;
	}

	public void setLastServer(ServerData serverData) {
		this.lastServer = serverData;
	}
	
	public void sendQueued(final String message) {
		LabyModCore.getMinecraft().getPlayer().sendChatMessage(message);
	}
	
}