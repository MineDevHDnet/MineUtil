package net.minedevhd.mineutil.settings;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import net.labymod.gui.elements.DropDownMenu;
import net.labymod.ingamegui.enums.EnumModuleAlignment;
import net.labymod.main.LabyMod;
import net.labymod.main.lang.LanguageManager;
import net.labymod.settings.elements.BooleanElement;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.DropDownElement;
import net.labymod.settings.elements.HeaderElement;
import net.labymod.settings.elements.KeyElement;
import net.labymod.settings.elements.ListContainerElement;
import net.labymod.settings.elements.NumberElement;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.settings.elements.StringElement;
import net.labymod.utils.Consumer;
import net.labymod.utils.Material;
import net.labymod.utils.ModColor;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.gui.storageprices.PreisInfos;
import net.minedevhd.mineutil.utils.tech.TextElement;

public class ModSettings implements UtilCore {
	
	/** TODO:
	 *  überarbeitung der ModSettings-Klasse!
	 * */
    
    private String commandPrefix = ".",
    			   modGGAFKMSGMessage = "Hey, tut mir leid. Ich bin gerade AFK!",
    			   modGGAFKMSGWebhook = "null",
    			   modRealMoney$real = "Real-Money",
    			   modRealMoney$fake = "Fake-Money";
    
    private Integer modMenuKey = 24,
    				modNGMenuKey = 52, 
    				modCraftDelay = 200, 
    				modCleanDelay = 75, 
    				currentGuiPage = 1,
    				headDownloadKey = 83,
	    			modHeadOwnerKey = 75,
	    			gameGuiKey = 0,
	    			modSaveItem = 5;

    private boolean modEnabled = true,

    				modCleanCobblestone = true,
    				modCleanCoal = false,
    				modCleanLapis = false,
    				modCleanRedstone = false,
    				modCleanGold = false,
    				modCleanIron = false,
    				modCleanEmerald = false,
    				modCleanDiamond = false,
    				modCleanDirt = true,
    				modCleanOnlySpawner = false,
    				modCleanCrystal = false,
    				modCleanShard = false,
    				modCleanFish = false,

    				modGGAntiAFK = false,
    				modGGAutoPortal = false,
    				modGGAntiMagicPrefix = false,
    				modGGAutoStartKickNein = false,
    				modGGAFKMSGManager = false,

    				modClearEmptyChar = false,
    				mysteryModProxy = false,
    				modFullbright = true,
    				modMoneyDropGrabber = false,
    				modHeadOwner = false,
    				modShowRepairCosts = false,
    				modTrajectories = false,
    				testModVPN = false;

///* christmas */ private final String CHRISTMAS_PREFIX = "§c•§f● §cMi§fne§cUt§fil§8│§r ";
///* halloween */ private final String HALLOWEEN_PREFIX = "§6•§7● §6Mi§7ne§6Ut§7il§8│§r ";
///* easter */    private final String EASTER_PREFIX = "§2•§a● §2M§di§bn§ee§2U§dt§bi§el§8│§r ";
    private final String DEFAULT_PREFIX = "§b•§3● §e§lM§c§li§b§ln§a§le§d§lU§6§lt§a§li§c§ll§8│§r ";
//    private final String DEFAULT_PREFIX = "§6•§e● §6Mi§ene§6Ut§eil§8│§r ";

    public final boolean isModEnabled() {
        return this.modEnabled;
    }
    
    private final void setModEnabled(final boolean modEnabled) {
        this.modEnabled = modEnabled;
    }
    
	public final String getPrefix() {
		return this.DEFAULT_PREFIX;
	}
    
    public final int getCurrentGuiPage() {
		return this.currentGuiPage;
	}
    
    public final void setCurrentGuiPage(int currentGuiPage) {
		this.currentGuiPage = currentGuiPage;
	}
    
	public final String getCommandPrefix() {
		return this.commandPrefix;
	}

	public final void setCommandPrefix(String commandPrefix) {
		this.commandPrefix = commandPrefix;
	}

	public final String getModGGAFKMSGMessage() {
		return this.modGGAFKMSGMessage;
	}

	public final void setModGGAFKMSGMessage(String modGGAFKMSGMessage) {
		this.modGGAFKMSGMessage = modGGAFKMSGMessage;
	}

	public final Integer getModMenuKey() {
		return this.modMenuKey;
	}

	public final void setModMenuKey(Integer modMenuKey) {
		this.modMenuKey = modMenuKey;
	}

	public final Integer getModCraftDelay() {
		return this.modCraftDelay;
	}

	public final void setModCraftDelay(Integer modCraftDelay) {
		this.modCraftDelay = modCraftDelay;
	}

	public final Integer getModCleanDelay() {
		return this.modCleanDelay;
	}

	public final void setModCleanDelay(Integer modCleanDelay) {
		this.modCleanDelay = modCleanDelay;
	}

	public final Integer getHeadDownloadKey() {
		return this.headDownloadKey;
	}

	public final void setModHeadDownloadKey(Integer headDownloadKey) {
		this.headDownloadKey = headDownloadKey;
	}

	public final Integer getModHeadOwnerKey() {
		return this.modHeadOwnerKey;
	}

	public final void setModHeadOwnerKey(Integer modHeadOwnerKey) {
		this.modHeadOwnerKey = modHeadOwnerKey;
	}

	public final boolean isModCleanCobblestone() {
		return this.modCleanCobblestone;
	}

	public final void setModCleanCobblestone(boolean modCleanCobblestone) {
		this.modCleanCobblestone = modCleanCobblestone;
	}

	public final boolean isModCleanCoal() {
		return this.modCleanCoal;
	}

	public final void setModCleanCoal(boolean modCleanCoal) {
		this.modCleanCoal = modCleanCoal;
	}

	public final boolean isModCleanLapis() {
		return this.modCleanLapis;
	}

	public final void setModCleanLapis(boolean modCleanLapis) {
		this.modCleanLapis = modCleanLapis;
	}

	public final boolean isModCleanRedstone() {
		return this.modCleanRedstone;
	}

	public final void setModCleanRedstone(boolean modCleanRedstone) {
		this.modCleanRedstone = modCleanRedstone;
	}

	public final boolean isModCleanGold() {
		return this.modCleanGold;
	}

	public final void setModCleanGold(boolean modCleanGold) {
		this.modCleanGold = modCleanGold;
	}

	public final boolean isModCleanIron() {
		return this.modCleanIron;
	}

	public final void setModCleanIron(boolean modCleanIron) {
		this.modCleanIron = modCleanIron;
	}

	public final boolean isModCleanEmerald() {
		return this.modCleanEmerald;
	}

	public final void setModCleanEmerald(boolean modCleanEmerald) {
		this.modCleanEmerald = modCleanEmerald;
	}

	public final boolean isModCleanDiamond() {
		return this.modCleanDiamond;
	}

	public final void setModCleanDiamond(boolean modCleanDiamond) {
		this.modCleanDiamond = modCleanDiamond;
	}

	public final boolean isModCleanDirt() {
		return this.modCleanDirt;
	}

	public final void setModCleanDirt(boolean modCleanDirt) {
		this.modCleanDirt = modCleanDirt;
	}

	public final boolean isModCleanOnlySpawner() {
		return this.modCleanOnlySpawner;
	}

	public final void setModCleanOnlySpawner(boolean modCleanOnlySpawner) {
		this.modCleanOnlySpawner = modCleanOnlySpawner;
	}

	public final boolean isModCleanCrystal() {
		return this.modCleanCrystal;
	}

	public final void setModCleanCrystal(boolean modCleanCrystal) {
		this.modCleanCrystal = modCleanCrystal;
	}

	public final boolean isModCleanShard() {
		return this.modCleanShard;
	}

	public final void setModCleanShard(boolean modCleanShard) {
		this.modCleanShard = modCleanShard;
	}

	public final boolean isModCleanFish() {
		return this.modCleanFish;
	}

	public final void setModCleanFish(boolean modCleanFish) {
		this.modCleanFish = modCleanFish;
	}

	public final boolean isModGGAntiAFK() {
		return this.modGGAntiAFK;
	}

	public final void setModGGAntiAFK(boolean modGGAntiAFK) {
		this.modGGAntiAFK = modGGAntiAFK;
	}

	public final boolean isModGGAutoPortal() {
		return this.modGGAutoPortal;
	}

	public final void setModGGAutoPortal(boolean modGGAutoPortal) {
		this.modGGAutoPortal = modGGAutoPortal;
	}

	public final boolean isModGGAntiMagicPrefix() {
		return this.modGGAntiMagicPrefix;
	}

	public final void setModGGAntiMagicPrefix(boolean modGGAntiMagicPrefix) {
		this.modGGAntiMagicPrefix = modGGAntiMagicPrefix;
	}

	public final boolean isModGGAutoStartKickNein() {
		return this.modGGAutoStartKickNein;
	}

	public final void setModGGAutoStartKickNein(boolean modGGAutoStartKickNein) {
		this.modGGAutoStartKickNein = modGGAutoStartKickNein;
	}

	public final boolean isModGGAFKMSGManager() {
		return this.modGGAFKMSGManager;
	}

	public final void setModGGAFKMSGManager(boolean modGGAFKMSGManager) {
		this.modGGAFKMSGManager = modGGAFKMSGManager;
	}

	public final boolean isModClearEmptyChar() {
		return this.modClearEmptyChar;
	}

	public final void setModClearEmptyChar(boolean modClearEmptyChar) {
		this.modClearEmptyChar = modClearEmptyChar;
	}

	public final boolean isMysteryModProxy() {
		return this.mysteryModProxy;
	}

	public final void setMysteryModProxy(boolean mysteryModProxy) {
		this.mysteryModProxy = mysteryModProxy;
	}

	public final boolean isModFullbright() {
		return this.modFullbright;
	}

	public final void setModFullbright(boolean modFullbright) {
		this.modFullbright = modFullbright;
	}

	public final boolean isModMoneyDropGrabber() {
		return this.modMoneyDropGrabber;
	}

	public final void setModMoneyDropGrabber(boolean modMoneyDropGrabber) {
		this.modMoneyDropGrabber = modMoneyDropGrabber;
	}

	public final boolean isModHeadOwner() {
		return this.modHeadOwner;
	}

	public final void setModHeadOwner(boolean modHeadOwner) {
		this.modHeadOwner = modHeadOwner;
	}
	
	public final String getModRealMoney_Real() {
		return this.modRealMoney$real;
	}

	public final void setModRealMoney_Real(String modRealMoney$real) {
		this.modRealMoney$real = modRealMoney$real;
	}

	public final String getModRealMoney_Fake() {
		return this.modRealMoney$fake;
	}

	public final void setModRealMoney_Fake(String modRealMoney$fake) {
		this.modRealMoney$fake = modRealMoney$fake;
	}

	public final String getModGGAFKMSGWebhook() {
		return this.modGGAFKMSGWebhook;
	}

	public final void setModGGAFKMSGWebhook(String modGGAFKMSGWebhook) {
		this.modGGAFKMSGWebhook = modGGAFKMSGWebhook;
	}
	
	public final boolean isTestModVPN() {
		return this.testModVPN;
	}

	public final void setTestModVPN(boolean testModVPN) {
		this.testModVPN = testModVPN;
	}
	
	public final Integer getModNGMenuKey() {
		return this.modNGMenuKey;
	}

	public final void setModNGMenuKey(Integer modNGMenuKey) {
		this.modNGMenuKey = modNGMenuKey;
	}

	public final Integer getGameGuiKey() {
		return this.gameGuiKey;
	}

	public final void setGameGuiKey(Integer gameGuiKey) {
		this.gameGuiKey = gameGuiKey;
	}
	
	public final Integer getModSaveItem() {
		return this.modSaveItem;
	}

	public final void setModSaveItem(Integer modSaveItem) {
		this.modSaveItem = modSaveItem;
	}

	public final boolean isModShowRepairCosts() {
		return modShowRepairCosts;
	}

	public final void setModShowRepairCosts(boolean modShowRepairCosts) {
		this.modShowRepairCosts = modShowRepairCosts;
	}

	public final boolean isModTrajectories() {
		return modTrajectories;
	}

	public final void setModTrajectories(boolean modTrajectories) {
		this.modTrajectories = modTrajectories;
	}

	public void loadConfig() {
		PreisInfos.loadPriceConfig();
		
		this.modEnabled = (mineUtil.getConfig().has("modEnabled") ? mineUtil.getConfig().get("modEnabled").getAsBoolean() : false);
        this.modMenuKey = (mineUtil.getConfig().has("modMenuKey") ? mineUtil.getConfig().get("modMenuKey").getAsInt() : 24);
        this.modCraftDelay = (mineUtil.getConfig().has("modCraftDelay") ? mineUtil.getConfig().get("modCraftDelay").getAsInt() : 200);
        this.modCleanDelay = (mineUtil.getConfig().has("modCleanDelay") ? mineUtil.getConfig().get("modCleanDelay").getAsInt() : 75);
        this.modCleanCobblestone = (mineUtil.getConfig().has("modCleanCobblestone") ? mineUtil.getConfig().get("modCleanCobblestone").getAsBoolean() : false);
        this.modCleanCoal = (mineUtil.getConfig().has("modCleanCoal") ? mineUtil.getConfig().get("modCleanCoal").getAsBoolean() : false);
        this.modCleanLapis = (mineUtil.getConfig().has("modCleanLapis") ? mineUtil.getConfig().get("modCleanLapis").getAsBoolean() : false);
        this.modCleanRedstone = (mineUtil.getConfig().has("modCleanRedstone") ? mineUtil.getConfig().get("modCleanRedstone").getAsBoolean() : false);
        this.modCleanGold = (mineUtil.getConfig().has("modCleanGold") ? mineUtil.getConfig().get("modCleanGold").getAsBoolean() : false);
        this.modCleanIron = (mineUtil.getConfig().has("modCleanIron") ? mineUtil.getConfig().get("modCleanIron").getAsBoolean() : false);
        this.modCleanEmerald = (mineUtil.getConfig().has("modCleanEmerald") ? mineUtil.getConfig().get("modCleanEmerald").getAsBoolean() : false);
        this.modCleanDiamond = (mineUtil.getConfig().has("modCleanDiamond") ? mineUtil.getConfig().get("modCleanDiamond").getAsBoolean() : false);
        this.modCleanDirt = (mineUtil.getConfig().has("modCleanDirt") ? mineUtil.getConfig().get("modCleanDirt").getAsBoolean() : false);
        this.modCleanOnlySpawner = (mineUtil.getConfig().has("modCleanOnlySpawner") ? mineUtil.getConfig().get("modCleanOnlySpawner").getAsBoolean() : false);
        this.mysteryModProxy = (mineUtil.getConfig().has("mysteryModProxy") ? mineUtil.getConfig().get("mysteryModProxy").getAsBoolean() : false);
        this.headDownloadKey = (mineUtil.getConfig().has("headDownloadKey") ? mineUtil.getConfig().get("headDownloadKey").getAsInt() : 83);
        this.modHeadOwnerKey = (mineUtil.getConfig().has("modHeadOwnerKey") ? mineUtil.getConfig().get("modHeadOwnerKey").getAsInt() : 75);
        this.modGGAntiAFK = (mineUtil.getConfig().has("modGGAntiAFK") ? mineUtil.getConfig().get("modGGAntiAFK").getAsBoolean() : false);
        this.modGGAutoPortal = (mineUtil.getConfig().has("modGGAutoPortal") ? mineUtil.getConfig().get("modGGAutoPortal").getAsBoolean() : false);
        this.modClearEmptyChar = (mineUtil.getConfig().has("modClearEmptyChar") ? mineUtil.getConfig().get("modClearEmptyChar").getAsBoolean() : false);
        this.modGGAntiMagicPrefix = (mineUtil.getConfig().has("modGGAntiMagicPrefix") ? mineUtil.getConfig().get("modGGAntiMagicPrefix").getAsBoolean() : false);
        this.modFullbright = (mineUtil.getConfig().has("modFullbright") ? mineUtil.getConfig().get("modFullbright").getAsBoolean() : false);
        this.modMoneyDropGrabber = (mineUtil.getConfig().has("modMoneyDropGrabber") ? mineUtil.getConfig().get("modMoneyDropGrabber").getAsBoolean() : false);
        this.modGGAutoStartKickNein = (mineUtil.getConfig().has("modGGAutoStartKickNein") ? mineUtil.getConfig().get("modGGAutoStartKickNein").getAsBoolean() : false);
        this.modCleanFish = (mineUtil.getConfig().has("modCleanFish") ? mineUtil.getConfig().get("modCleanFish").getAsBoolean() : false);
        this.modCleanCrystal = (mineUtil.getConfig().has("modCleanCrystal") ? mineUtil.getConfig().get("modCleanCrystal").getAsBoolean() : false);
        this.modCleanShard = (mineUtil.getConfig().has("modCleanShard") ? mineUtil.getConfig().get("modCleanShard").getAsBoolean() : false);
        this.modHeadOwner = (mineUtil.getConfig().has("modHeadOwner") ? mineUtil.getConfig().get("modHeadOwner").getAsBoolean() : false);
        this.modGGAFKMSGMessage = (mineUtil.getConfig().has("modGGAFKMSGMessage") ? mineUtil.getConfig().get("modGGAFKMSGMessage").getAsString() : "Hey, tut mir leid. Ich bin gerade AFK!");
        this.modGGAFKMSGManager = (mineUtil.getConfig().has("modGGAFKMSGManager") ? mineUtil.getConfig().get("modGGAFKMSGManager").getAsBoolean() : false);
        this.commandPrefix = (mineUtil.getConfig().has("commandPrefix") ? mineUtil.getConfig().get("commandPrefix").getAsString() : ".");
        this.modRealMoney$real = (mineUtil.getConfig().has("modRealMoney_real") ? mineUtil.getConfig().get("modRealMoney_real").getAsString() : "Real-Money");
        this.modRealMoney$fake = (mineUtil.getConfig().has("modRealMoney_fake") ? mineUtil.getConfig().get("modRealMoney_fake").getAsString() : "Fake-Money");
        this.modGGAFKMSGWebhook = (mineUtil.getConfig().has("modGGAFKMSGWebhook") ? mineUtil.getConfig().get("modGGAFKMSGWebhook").getAsString() : "null");
        this.testModVPN = (mineUtil.getConfig().has("VirtualPrivateNetwork") ? mineUtil.getConfig().get("VirtualPrivateNetwork").getAsBoolean() : false);
        this.modNGMenuKey = (mineUtil.getConfig().has("modNGMenuKey") ? mineUtil.getConfig().get("modNGMenuKey").getAsInt() : 52);
        this.gameGuiKey = (mineUtil.getConfig().has("gameGuiKey") ? mineUtil.getConfig().get("gameGuiKey").getAsInt() : 0);
        this.modSaveItem = (mineUtil.getConfig().has("modSaveItem") ? mineUtil.getConfig().get("modSaveItem").getAsInt() : 5);
        this.modShowRepairCosts = (mineUtil.getConfig().has("modShowRepairCosts") ? mineUtil.getConfig().get("modShowRepairCosts").getAsBoolean() : false);
        this.modTrajectories = (mineUtil.getConfig().has("Trajectories") ? mineUtil.getConfig().get("Trajectories").getAsBoolean() : false);
	}
    
    public void fillSettings(final List<SettingsElement> settings) {
        settings.add(new HeaderElement("General Settings"));
        
        final BooleanElement modEnabledBtn = new BooleanElement("Addon enabled?", new ControlElement.IconData("labymod/textures/buttons/accept.png"), new Consumer<Boolean>() {
            public void accept(final Boolean modEnabled) {
                ModSettings.this.setModEnabled(modEnabled);
                mineUtil.getConfig().addProperty("modEnabled", modEnabled);
                mineUtil.saveConfig();
            }
        }, this.isModEnabled());
        settings.add(modEnabledBtn);

        settings.add(new HeaderElement(""));
        settings.add(new HeaderElement("Virtual Private Network (VPN) | (betamode)"));
        
        final BooleanElement modVPNBtn = new BooleanElement("VPN enabled?", new ControlElement.IconData("labymod/addons/MineUtil/textures/vpnicon.png"), new Consumer<Boolean>() {
            public void accept(final Boolean modVPN) {
                ModSettings.this.setTestModVPN(modVPN);
                mineUtil.getConfig().addProperty("VirtualPrivateNetwork", modVPN);
                mineUtil.saveConfig();
            }
        }, this.isTestModVPN());
        settings.add(modVPNBtn);
        
        settings.add(new HeaderElement(""));
        
    	final ListContainerElement headOwnerCategory = new ListContainerElement("General - HeadOwner", new ControlElement.IconData("labymod/addons/MineUtil/textures/mchead.png"));
    	headOwnerCategory.getSubSettings().add(new HeaderElement("HeadOwner Settings"));
        
        final KeyElement modHeadDLKeyElement = new KeyElement("Skin Download-Hotkey", new ControlElement.IconData("labymod/textures/settings/modules/online_players.png"), (int)this.getHeadDownloadKey(), new Consumer<Integer>() {
            public void accept(final Integer modHeadDLKey) {
                ModSettings.this.setModHeadDownloadKey(modHeadDLKey);
                mineUtil.getConfig().addProperty("downloaderbutton", (Number) modHeadDLKey);
                mineUtil.saveConfig();
                if(modHeadDLKey == -1) return;
            }
        });
        headOwnerCategory.getSubSettings().add(modHeadDLKeyElement);
        
        final BooleanElement modHeadOwnerBtn = new BooleanElement("HeadOwner", new ControlElement.IconData("labymod/textures/buttons/hover_default.png"), new Consumer<Boolean>() {
            public void accept(final Boolean modHeadOwner) {
                ModSettings.this.setModHeadOwner(modHeadOwner);
                mineUtil.getConfig().addProperty("modHeadOwner", modHeadOwner);
                mineUtil.saveConfig();
            }
        }, this.isModHeadOwner());
        headOwnerCategory.getSubSettings().add(modHeadOwnerBtn);
    	settings.add(headOwnerCategory);
        
    	final ListContainerElement genCategory = new ListContainerElement("General - Settings", new ControlElement.IconData(Material.COMMAND));
        genCategory.getSubSettings().add(new HeaderElement("General Addon Settings"));
    	
    	StringElement commandStringElement = new StringElement("Command Prefix", new ControlElement.IconData(Material.PAPER), this.commandPrefix, new Consumer<String>() {
            @Override
            public void accept(String accepted) {
            	ModSettings.this.setCommandPrefix(accepted);
                mineUtil.getConfig().addProperty("commandPrefix", accepted);
                mineUtil.saveConfig();
            }
        });
        genCategory.getSubSettings().add(commandStringElement);
        
        final BooleanElement modClearEmptyChar = new BooleanElement("Clear empty chars", new ControlElement.IconData("labymod/textures/buttons/hover_default.png"), new Consumer<Boolean>() {
            public void accept(final Boolean modClearEmptyChar) {
                ModSettings.this.setModClearEmptyChar(modClearEmptyChar);
                mineUtil.getConfig().addProperty("modClearEmptyChar", modClearEmptyChar);
                mineUtil.saveConfig();
            }
        }, this.isModClearEmptyChar());
        genCategory.getSubSettings().add(modClearEmptyChar);
        
        final BooleanElement modFullbright = new BooleanElement("Fullbright", new ControlElement.IconData("labymod/textures/buttons/hover_default.png"), new Consumer<Boolean>() {
            public void accept(final Boolean modFullbright) {
                ModSettings.this.setModFullbright(modFullbright);
                mineUtil.getConfig().addProperty("modFullbright", modFullbright);
                mineUtil.saveConfig();
                if(ModSettings.this.isModFullbright())
                	mineUtil.getMinecraft().gameSettings.gammaSetting = 10.0f;
                else
            		mineUtil.getMinecraft().gameSettings.gammaSetting = 1.0f;
            }
        }, this.isModFullbright());
        genCategory.getSubSettings().add(modFullbright);
        
        final BooleanElement modShowRepairCosts = new BooleanElement("Show Item Repaircosts", new ControlElement.IconData("labymod/textures/buttons/hover_default.png"), new Consumer<Boolean>() {
            public void accept(final Boolean val) {
                ModSettings.this.setModShowRepairCosts(val);
                mineUtil.getConfig().addProperty("modShowRepairCosts", val);
                mineUtil.saveConfig();
            }
        }, this.isModShowRepairCosts());
        genCategory.getSubSettings().add(modShowRepairCosts);
        
        final BooleanElement modTrajectories = new BooleanElement("Show Trajectories", new ControlElement.IconData("labymod/textures/buttons/hover_default.png"), new Consumer<Boolean>() {
            public void accept(final Boolean val) {
                ModSettings.this.setModTrajectories(val);
                mineUtil.getConfig().addProperty("modTrajectories", val);
                mineUtil.saveConfig();
            }
        }, this.isModTrajectories());
        genCategory.getSubSettings().add(modTrajectories);
        
        final NumberElement modSaveItemField = new NumberElement("Save Item with Dura", new ControlElement.IconData(Material.DIAMOND_PICKAXE), (int)this.getModSaveItem());
        modSaveItemField.setMinValue(0);
        modSaveItemField.setMaxValue(1900);
        modSaveItemField.addCallback(new Consumer<Integer>() {
            public void accept(final Integer modSaveItem) {
                ModSettings.this.setModSaveItem(modSaveItem);
                mineUtil.getConfig().addProperty("modSaveItem", (Number)modSaveItem);
                mineUtil.saveConfig();
            }
        });
        genCategory.getSubSettings().add(modSaveItemField);
        
        final KeyElement modGameLibMenuKeyElement = new KeyElement("Game Library-Hotkey", new ControlElement.IconData("labymod/textures/settings/settings/keymoduleeditor.png"), (int)this.getGameGuiKey(), new Consumer<Integer>() {
            public void accept(final Integer modGameLibMenuKey) {
                ModSettings.this.setGameGuiKey(modGameLibMenuKey);
                mineUtil.getConfig().addProperty("gameGuiKey", (Number)modGameLibMenuKey);
                mineUtil.saveConfig();
                if(modGameLibMenuKey == -1) return;
            }
        });
        genCategory.getSubSettings().add(modGameLibMenuKeyElement);
    	
    	//KeyStrokes : Begin
    	final DropDownMenu<KeyStrokes.DropDown> keyStrokesMenu = new DropDownMenu<KeyStrokes.DropDown>("KeyStrokes Mod", 0, 0, 0, 0).fill(KeyStrokes.DropDown.values());
    	DropDownElement<KeyStrokes.DropDown> keyStrokesMod = new DropDownElement<KeyStrokes.DropDown>("KeyStrokes Mod", keyStrokesMenu);
    	keyStrokesMenu.setSelected(KeyStrokes.DropDown.DEFAULT);
    	keyStrokesMod.setChangeListener(new Consumer<KeyStrokes.DropDown>() {
    		@Override
    		public void accept(KeyStrokes.DropDown alignment) {
    			System.out.println("New selected alignment: " + alignment.name());
    			KeyStrokes.setDDKeyStrokesValue(alignment);
    		}
    	} );
    	keyStrokesMenu.setEntryDrawer(new DropDownMenu.DropDownEntryDrawer() {
    		@Override
    		public void draw(Object object, int x, int y, String trimmedEntry) {
    			String entry = object.toString().toUpperCase();
    			LabyMod.getInstance().getDrawUtils().drawString(LanguageManager.translate(entry), x, y );
    		}
    	} );
    	//KeyStrokes : End
    	genCategory.getSubSettings().add(keyStrokesMod);
    	settings.add(genCategory);
        
    	final ListContainerElement craftCategory = new ListContainerElement("General - Crafting", new ControlElement.IconData(Material.WORKBENCH));
        settings.add((SettingsElement) craftCategory);
        craftCategory.getSubSettings().add(new HeaderElement("Crafting Settings"));
        
        final KeyElement modMenuKeyElement = new KeyElement("Menu-Hotkey", new ControlElement.IconData("labymod/textures/settings/settings/keymoduleeditor.png"), (int)this.getModMenuKey(), new Consumer<Integer>() {
            public void accept(final Integer modMenuKey) {
                ModSettings.this.setModMenuKey(modMenuKey);
                mineUtil.getConfig().addProperty("modMenuKey", (Number)modMenuKey);
                mineUtil.saveConfig();
                if(modMenuKey == -1) return;
            }
        });
        craftCategory.getSubSettings().add(modMenuKeyElement);
        
        final KeyElement modNextGenMenuKeyElement = new KeyElement("NextGen Menu-Hotkey", new ControlElement.IconData("labymod/textures/settings/settings/keymoduleeditor.png"), (int)this.getModNGMenuKey(), new Consumer<Integer>() {
            public void accept(final Integer modNGMenuKey) {
                ModSettings.this.setModNGMenuKey(modNGMenuKey);
                mineUtil.getConfig().addProperty("modNGMenuKey", (Number)modNGMenuKey);
                mineUtil.saveConfig();
                if(modNGMenuKey == -1) return;
            }
        });
        craftCategory.getSubSettings().add(modNextGenMenuKeyElement);

        final NumberElement modCraftDelayField = new NumberElement("Cooldown in Milliseconds", new ControlElement.IconData("labymod/textures/settings/default/use_default_settings.png"), (int)this.getModCraftDelay());
        modCraftDelayField.setMinValue(50);
        modCraftDelayField.setMaxValue(500);
        modCraftDelayField.addCallback(new Consumer<Integer>() {
            public void accept(final Integer modCraftDelay) {
                ModSettings.this.setModCraftDelay(modCraftDelay);
                mineUtil.getConfig().addProperty("modCraftDelay", (Number)modCraftDelay);
                mineUtil.saveConfig();
            }
        });
        craftCategory.getSubSettings().add(modCraftDelayField);

    	final ListContainerElement ggCategory = new ListContainerElement("General - GrieferGames", new ControlElement.IconData(Material.STONE));
        settings.add((SettingsElement) ggCategory);
        ggCategory.getSubSettings().add(new HeaderElement("§lGrieferGames Settings"));
        
        final BooleanElement mysteryModProxy = new BooleanElement("MysteryMod Proxy", new ControlElement.IconData("labymod/addons/MineUtil/textures/mysterymod.png"), new Consumer<Boolean>() {
            public void accept(final Boolean mysterymodproxy) {
                ModSettings.this.setMysteryModProxy(mysterymodproxy);
                mineUtil.getConfig().addProperty("mysteryModProxy", mysterymodproxy);
                mineUtil.saveConfig();
            }
        }, this.isMysteryModProxy());
        ggCategory.getSubSettings().add(mysteryModProxy);
        
        final BooleanElement modGGAntiAFK = new BooleanElement("Anti-AFK System", new ControlElement.IconData("labymod/textures/buttons/hover_default.png"), new Consumer<Boolean>() {
            public void accept(final Boolean modGGAntiAFK) {
                ModSettings.this.setModGGAntiAFK(modGGAntiAFK);
                mineUtil.getConfig().addProperty("modGGAntiAFK", modGGAntiAFK);
                mineUtil.saveConfig();
            }
        }, this.isModGGAntiAFK());
        ggCategory.getSubSettings().add(modGGAntiAFK);
        
        final BooleanElement modGGAutoPortal = new BooleanElement("Connect directly with Portalroom", new ControlElement.IconData("labymod/textures/buttons/hover_default.png"), new Consumer<Boolean>() {
            public void accept(final Boolean modGGAutoPortal) {
                ModSettings.this.setModGGAutoPortal(modGGAutoPortal);
                mineUtil.getConfig().addProperty("modGGAutoPortal", modGGAutoPortal);
                mineUtil.saveConfig();
            }
        }, this.isModGGAutoPortal());
        ggCategory.getSubSettings().add(modGGAutoPortal);

        ggCategory.getSubSettings().add(new HeaderElement("AFK /msg-Answerer"));
        
        StringElement afkStringElement = new StringElement("AFK-Message", new ControlElement.IconData("labymod/textures/settings/modules/afk_timer.png"), this.getModGGAFKMSGMessage()/*"Hey, tut mir leid. Ich bin gerade AFK!"*/, new Consumer<String>() {
            @Override
            public void accept(String accepted) {
            	ModSettings.this.setModGGAFKMSGMessage(accepted);
                mineUtil.getConfig().addProperty("modGGAFKMSGMessage", accepted);
                mineUtil.saveConfig();
            }
        });
        ggCategory.getSubSettings().add(afkStringElement);
        
        StringElement dcWebhookStringElement = new StringElement("Discord Webhook", new ControlElement.IconData("labymod/textures/settings/settings/discordrichpresence.png"), this.getModGGAFKMSGWebhook()/*"null"*/, new Consumer<String>() {
            @Override
            public void accept(String accepted) {
            	ModSettings.this.setModGGAFKMSGWebhook(accepted);
                mineUtil.getConfig().addProperty("modGGAFKMSGWebhook", accepted);
                mineUtil.saveConfig();
            }
        });
        ggCategory.getSubSettings().add(dcWebhookStringElement);

        ggCategory.getSubSettings().add(new HeaderElement("Real-Money Checker"));
        
        StringElement realMoney$realStringElement = new StringElement("Real-Money Message", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), this.getModRealMoney_Real()/*"Real-Money"*/, new Consumer<String>() {
            @Override
            public void accept(String accepted) {
            	ModSettings.this.setModRealMoney_Real(accepted);
                mineUtil.getConfig().addProperty("modRealMoney_real", accepted);
                mineUtil.saveConfig();
            }
        });
        ggCategory.getSubSettings().add(realMoney$realStringElement);
        
        StringElement realMoney$fakeStringElement = new StringElement("Real-Money Message", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), this.getModRealMoney_Fake() /*"Fake-Money"*/, new Consumer<String>() {
            @Override
            public void accept(String accepted) {
            	ModSettings.this.setModRealMoney_Fake(accepted);
                mineUtil.getConfig().addProperty("modRealMoney_fake", accepted);
                mineUtil.saveConfig();
            }
        });
        ggCategory.getSubSettings().add(realMoney$fakeStringElement);
        
    	final ListContainerElement ggSpawnerCategory = new ListContainerElement("Cleaning - Spawner", new ControlElement.IconData(Material.MOB_SPAWNER));
    	settings.add((SettingsElement) ggSpawnerCategory);

		ggSpawnerCategory.getSubSettings().add(new HeaderElement("Cleaning Settings"));
        final NumberElement modCleanDelayField = new NumberElement("Cooldown in Milliseconds", new ControlElement.IconData("labymod/textures/settings/default/use_default_settings.png"), (int)this.getModCleanDelay());
        modCleanDelayField.setMinValue(50);
        modCleanDelayField.setMaxValue(500);
        modCleanDelayField.addCallback(new Consumer<Integer>() {
            public void accept(final Integer modCleanDelay) {
                ModSettings.this.setModCleanDelay(modCleanDelay);
                mineUtil.getConfig().addProperty("modCleanDelay", (Number)modCleanDelay);
                mineUtil.saveConfig();
            }
        });
        ggSpawnerCategory.getSubSettings().add(modCleanDelayField);
        
    	ggSpawnerCategory.getSubSettings().add(new HeaderElement(""));
    	ggSpawnerCategory.getSubSettings().add(new HeaderElement("Clean-Spawner Settings"));
    	
    	ggSpawnerCategory.getSubSettings().add(new BooleanElement("Only Spawner", new ControlElement.IconData(Material.MOB_SPAWNER), new Consumer<Boolean>() {
            public void accept(final Boolean modCleanOnlySpawner) {
                ModSettings.this.setModCleanOnlySpawner(modCleanOnlySpawner);
                mineUtil.getConfig().addProperty("modCleanOnlySpawner", modCleanOnlySpawner);
                mineUtil.saveConfig();
            }
        }, this.isModCleanOnlySpawner()));
        ggSpawnerCategory.getSubSettings().add(new BooleanElement("Drop Cobblestone", new ControlElement.IconData(Material.COBBLESTONE), new Consumer<Boolean>() {
            public void accept(final Boolean modCleanCobblestone) {
                ModSettings.this.setModCleanCobblestone(modCleanCobblestone);
                mineUtil.getConfig().addProperty("modCleanCobblestone", modCleanCobblestone);
                mineUtil.saveConfig();
            }
        }, this.isModCleanCobblestone()));
        ggSpawnerCategory.getSubSettings().add(new BooleanElement("Drop Dirt", new ControlElement.IconData(Material.DIRT), new Consumer<Boolean>() {
            public void accept(final Boolean modCleanDirt) {
                ModSettings.this.setModCleanDirt(modCleanDirt);
                mineUtil.getConfig().addProperty("modCleanDirt", modCleanDirt);
                mineUtil.saveConfig();
            }
        }, this.isModCleanDirt()));
        ggSpawnerCategory.getSubSettings().add(new BooleanElement("Drop Coal", new ControlElement.IconData(Material.COAL_BLOCK), new Consumer<Boolean>() {
            public void accept(final Boolean modCleanCoal) {
                ModSettings.this.setModCleanCoal(modCleanCoal);
                mineUtil.getConfig().addProperty("modCleanCoal", modCleanCoal);
                mineUtil.saveConfig();
            }
        }, this.isModCleanCoal()));
        ggSpawnerCategory.getSubSettings().add(new BooleanElement("Drop Lapislazuli", new ControlElement.IconData(Material.LAPIS_BLOCK), new Consumer<Boolean>() {
            public void accept(final Boolean modCleanLapis) {
                ModSettings.this.setModCleanLapis(modCleanLapis);
                mineUtil.getConfig().addProperty("modCleanLapis", modCleanLapis);
                mineUtil.saveConfig();
            }
        }, this.isModCleanLapis()));
        ggSpawnerCategory.getSubSettings().add(new BooleanElement("Drop Redstone", new ControlElement.IconData(Material.REDSTONE_BLOCK), new Consumer<Boolean>() {
            public void accept(final Boolean modCleanRedstone) {
                ModSettings.this.setModCleanRedstone(modCleanRedstone);
                mineUtil.getConfig().addProperty("modCleanRedstone", modCleanRedstone);
                mineUtil.saveConfig();
            }
        }, this.isModCleanRedstone()));
        ggSpawnerCategory.getSubSettings().add(new BooleanElement("Drop Gold", new ControlElement.IconData(Material.GOLD_BLOCK), new Consumer<Boolean>() {
            public void accept(final Boolean modCleanGold) {
                ModSettings.this.setModCleanGold(modCleanGold);
                mineUtil.getConfig().addProperty("modCleanGold", modCleanGold);
                mineUtil.saveConfig();
            }
        }, this.isModCleanGold()));
        ggSpawnerCategory.getSubSettings().add(new BooleanElement("Drop Iron", new ControlElement.IconData(Material.IRON_BLOCK), new Consumer<Boolean>() {
            public void accept(final Boolean modCleanIron) {
                ModSettings.this.setModCleanIron(modCleanIron);
                mineUtil.getConfig().addProperty("modCleanIron", modCleanIron);
                mineUtil.saveConfig();
            }
        }, this.isModCleanIron()));
        ggSpawnerCategory.getSubSettings().add(new BooleanElement("Drop Emerald", new ControlElement.IconData(Material.EMERALD_BLOCK), new Consumer<Boolean>() {
            public void accept(final Boolean modCleanEmerald) {
                ModSettings.this.setModCleanEmerald(modCleanEmerald);
                mineUtil.getConfig().addProperty("modCleanEmerald", modCleanEmerald);
                mineUtil.saveConfig();
            }
        }, this.isModCleanEmerald()));
        ggSpawnerCategory.getSubSettings().add(new BooleanElement("Drop Diamond", new ControlElement.IconData(Material.DIAMOND_BLOCK), new Consumer<Boolean>() {
            public void accept(final Boolean modCleanDiamond) {
                ModSettings.this.setModCleanDiamond(modCleanDiamond);
                mineUtil.getConfig().addProperty("modCleanDiamond", modCleanDiamond);
                mineUtil.saveConfig();
            }
        }, this.isModCleanDiamond()));

//        PreisInfos.fillPriceSettings(settings);
        settings.add(new TextElement("§7Version§8: §a" + mineUtil.getVersion()));
    }
    
    public SettingsElement getSettingsElement() {
    	List<SettingsElement> settings = new ArrayList<SettingsElement>();
    	return (SettingsElement) settings;
    }
    
    public static class KeyStrokes {
    	public static String ens = "default";
    	
    	public static enum DropDown {
        	DEFAULT,
        	WITH_SPACEBAR,
        	WITH_MOUSE_BUTTONS,
        	WITH_MOUSE_BUTTONS_AND_SPACEBAR;
        }
        
        public static void setDDKeyStrokesValue(DropDown dropDownValue) {
        	ens = dropDownValue.name();
        }
        
        public static String getEns() {
        	return ens;
        }
    }
    
}
