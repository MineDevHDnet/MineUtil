package net.minedevhd.mineutil;

import java.awt.Color;
import java.io.File;
import java.util.List;
import java.util.Locale;

import net.labymod.api.LabyModAddon;
import net.labymod.api.events.RenderIngameOverlayEvent;
import net.labymod.core.LabyModCore;
import net.labymod.ingamegui.Module;
import net.labymod.ingamegui.ModuleCategory;
import net.labymod.ingamegui.ModuleCategoryRegistry;
import net.labymod.main.LabyMod;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.utils.Consumer;
import net.labymod.utils.ServerData;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import net.minedevhd.mineutil.command.Command;
import net.minedevhd.mineutil.command.CommandManager;
import net.minedevhd.mineutil.helper.CleanHelper;
import net.minedevhd.mineutil.helper.CraftHelper;
import net.minedevhd.mineutil.helper.KeyStrokeHelper;
import net.minedevhd.mineutil.helper.TickHelper;
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
import net.minedevhd.mineutil.utils.graf.RenderUtils;

public class MineUtil extends LabyModAddon {

    private static final String VERSION = "1.4.0";
    private static final String CHANGELOG_DATE = "11. August 2026";

    public static final Integer CLIENT_COLOR = 0x6495ed;

    private static MineUtil mineUtil;
    private static ModSettings settings;

    private final CleanHelper cleanHelper;
    private final CraftHelper craftHelper;

    private String cleanSelection = "";
    private String craftSelection = "";
    private ServerData lastServer;
    private boolean onGrieferGames;
    private Float previousGamma;

    public ModuleCategory MINEUTIL_CATEGORY;
    public boolean isGuiKeyPressed;

    public MineUtil() {
        // Set the singleton before helper/settings classes can resolve UtilCore.mineUtil.
        setCore(this);
        setSettings(new ModSettings());
        this.cleanHelper = new CleanHelper();
        this.craftHelper = new CraftHelper();
        this.isGuiKeyPressed = false;
    }

    public static MineUtil getCore() {
        return mineUtil;
    }

    private static void setCore(final MineUtil core) {
        mineUtil = core;
    }

    public String getVersion() {
        return VERSION + "-release";
    }

    public Minecraft getMinecraft() {
        return Minecraft.getMinecraft();
    }

    public ModSettings getSettings() {
        return settings;
    }

    private void setSettings(final ModSettings modSettings) {
        settings = modSettings;
    }

    public static final class CCGui {
        private static boolean guiToggled;
        private static boolean guiOpend;

        private CCGui() {
        }

        public static void setGUIToggled(final boolean toggled) {
            guiToggled = toggled;
        }

        public static boolean isGUIToggled() {
            return guiToggled;
        }

        public static void setGUIOpend(final boolean opened) {
            guiOpend = opened;
        }

        public static boolean isGUIOpend() {
            return guiOpend;
        }
    }

    @Override
    public void onEnable() {
        final File textureDirectory = new File(getMinecraft().mcDataDir, "MineUtil/head_textures");
        if (!textureDirectory.exists() && !textureDirectory.mkdirs()) {
            System.err.println("[MineUtil] Could not create head texture directory: " + textureDirectory);
        }

        MINEUTIL_CATEGORY = new ModuleCategory(
                "MineUtil",
                true,
                new ControlElement.IconData(new ResourceLocation("labymod/addons/MineUtil/textures/utillogo.jpg"))
        );
        ModuleCategoryRegistry.loadCategory(MINEUTIL_CATEGORY);

        getApi().registerForgeListener(new TickHelper());
        getApi().registerForgeListener(new RepairCostMod());
        getApi().registerForgeListener(new PlotChatIndicator());

        final GrieferWertMod grieferWertMod = new GrieferWertMod();
        getApi().registerForgeListener(grieferWertMod);
        grieferWertMod.loadPrices();

        getApi().registerForgeListener(new TrajectoriesMod());
        getApi().registerForgeListener(new KeyStrokeHelper());
        getApi().registerForgeListener(new MapPreviewModule());
        getApi().registerForgeListener(new ToolSaveMod());

        getApi().registerModule((Module) new MiniMeModule());
        getApi().registerModule((Module) new SkinHeadModule());
        getApi().registerModule((Module) new HeadOwnerModule());
        getApi().registerModule((Module) new ShowMCNameModule());
        getApi().registerModule((Module) new KeyStrokesModule());
        getApi().registerModule((Module) new CoordinatesModule());
        getApi().registerModule((Module) new DispalyCraftIngameModule());
        getApi().registerModule((Module) new DispalyCleanIngameModule());

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

        Command.initCmdBase();
        registerOverlayRenderer();
        registerJoinListener();
        Exploit.HeadDownloader.register();

        previousGamma = getMinecraft().gameSettings.gammaSetting;
        if (getSettings().isModFullbright()) {
            getMinecraft().gameSettings.gammaSetting = 10.0F;
        }
    }

    private void registerOverlayRenderer() {
        getApi().getEventManager().register(new RenderIngameOverlayEvent() {
            @Override
            public void onRender(final float partialTicks) {
                if (getSettings() == null || !getSettings().isModEnabled()) {
                    return;
                }

                final Minecraft minecraft = getMinecraft();
                if (minecraft == null || minecraft.fontRendererObj == null) {
                    return;
                }

                final FontRenderer font = minecraft.fontRendererObj;
                int y = 0;
                for (final Command command : CommandManager.getCommands()) {
                    if (!command.isActiv()) {
                        continue;
                    }

                    final String displayName = command.getDisplayName();
                    renderModule(minecraft, RenderUtils.getResolution(), y, font.getStringWidth(displayName), displayName);
                    y += 10;
                }

                final String text = "MineUtil | b" + getVersion();
                final int width = font.getStringWidth(text);
                GuiScreen.drawRect(5, 5, width + 6, 15, new Color(0, 0, 0, 130).getRGB());
                GuiScreen.drawRect(5, 14, width + 6, 15, ModButton.toRainbow(18));
                new Gui().drawString(font, text, 6, 6, 0xFFFFFF);
            }
        });
    }

    private void registerJoinListener() {
        getApi().getEventManager().registerOnJoin(new Consumer<ServerData>() {
            @Override
            public void accept(final ServerData serverData) {
                setLastServer(serverData);

                if (getSettings() == null || !getSettings().isModEnabled()) {
                    setGrieferGames(false);
                    return;
                }

                LabyMod.getInstance().getGuiCustomAchievement().displayAchievement(
                        "MineUtil",
                        "MineUtil b" + getVersion() + " ist aktiv."
                );

                if (serverData == null || serverData.getIp() == null) {
                    setGrieferGames(false);
                    return;
                }

                final String ip = serverData.getIp().toLowerCase(Locale.ROOT);
                final boolean grieferGames = ip.contains("griefergames");
                setGrieferGames(grieferGames);

                if (!grieferGames) {
                    return;
                }

                if (getSettings().isModGGAutoPortal() && getMinecraft().thePlayer != null) {
                    getMinecraft().thePlayer.sendChatMessage("/portal");
                }

                if (getSettings().isMysteryModProxy()) {
                    Exploit.GrieferGames.MysteryMod.startProxy();
                }
            }
        });
    }

    @Override
    public void onDisable() {
        if (previousGamma != null && getMinecraft() != null && getMinecraft().gameSettings != null) {
            getMinecraft().gameSettings.gammaSetting = previousGamma;
        }
        super.onDisable();
    }

    private void renderModule(final Minecraft minecraft, final ScaledResolution resolution,
                              final int height, final int length, final String text) {
        final int right = resolution.getScaledWidth();
        final int left = right - length - 5;
        GuiScreen.drawRect(left, height + 1, right, height + 11, new Color(0, 0, 0, 130).getRGB());
        GuiScreen.drawRect(right - 2, height + 1, right, height + 11, ModButton.toRainbow(18));
        new Gui().drawString(minecraft.fontRendererObj, text, right - length - 3, height + 2, 0xFFFFFF);
    }

    public boolean isOnGrieferGames() {
        return onGrieferGames;
    }

    public void setGrieferGames(final boolean value) {
        onGrieferGames = value;
    }

    public CleanHelper getCleanHelper() {
        return cleanHelper;
    }

    public CraftHelper getCraftHelper() {
        return craftHelper;
    }

    public String getCleanSelection() {
        return cleanSelection;
    }

    public void setCleanSelection(final String selection) {
        cleanSelection = selection == null ? "" : selection;
    }

    public String getCraftSelection() {
        return craftSelection;
    }

    public void setCraftSelection(final String selection) {
        craftSelection = selection == null ? "" : selection;
    }

    @Override
    public void loadConfig() {
        getSettings().loadConfig();
    }

    @Override
    protected void fillSettings(final List<SettingsElement> settingsElements) {
        getSettings().fillSettings(settingsElements);
    }

    public String getChangelogDate() {
        return CHANGELOG_DATE;
    }

    public ServerData getLastServer() {
        return lastServer;
    }

    public void setLastServer(final ServerData serverData) {
        lastServer = serverData;
    }

    public void sendQueued(final String message) {
        if (message == null || message.trim().isEmpty()) {
            return;
        }
        LabyModCore.getMinecraft().getPlayer().sendChatMessage(message);
    }
}
