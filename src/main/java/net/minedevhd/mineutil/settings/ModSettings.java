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
import net.minedevhd.mineutil.utils.render.TextElement;

public class ModSettings {
	
	/** TODO:
	 *  überarbeitung der ModSettings-Klasse!
	 * */
    
    private String commandPrefix = ".",
    			   modGGAFKMSGMessage = "Hey, tut mir leid. Ich bin gerade AFK!",
    			   modGGAFKMSGWebhook = "null",
    			   modRealMoney$real = "Real-Money",
    			   modRealMoney$fake = "Fake-Money";
    
    private Integer modMenuKey = 24, 
    				modCraftDelay = 200, 
    				modCleanDelay = 75, 
    				currentGuiPage = 1,
    				headDownloadKey = 83,
	    			modHeadOwnerKey = 75;

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
    				modHeadOwner = false;

///* christmas */ private final String CHRISTMAS_PREFIX = ModColor.DARK_GRAY + "[" + ModColor.RED + "Mi" + ModColor.WHITE + "ne" + ModColor.RED + "Ut" + ModColor.WHITE + "il" + ModColor.DARK_GRAY + "] " + ModColor.RESET;
///* halloween */ private final String HALLOWEEN_PREFIX = ModColor.DARK_GRAY + "[" + ModColor.GOLD + "Mi" + ModColor.GRAY + "ne" + ModColor.GOLD + "Ut" + ModColor.GRAY + "il" + ModColor.DARK_GRAY + "] " + ModColor.RESET;
///* easter */    private final String EASTER_PREFIX = ModColor.DARK_GRAY + "[" + ModColor.GREEN + "M" + ModColor.PINK + "i" + ModColor.AQUA + "n" + ModColor.YELLOW + "e" + ModColor.GREEN + "U" + ModColor.PINK + "t" + ModColor.AQUA + "i" + ModColor.YELLOW + "l" + ModColor.DARK_GRAY + "] " + ModColor.RESET;
///* default */   private final String DEFAULT_PREFIX = "§8[§6Mi§ene§6Ut§eil§8] §r";
    private final String DEFAULT_PREFIX = "§6•§e● §6Mi§ene§6Ut§eil§8│§r ";

    public final boolean getModEnabled() {
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

	public void loadConfig() {
		PreisInfos.loadPriceConfig();
		
		this.modEnabled = (MineUtil.getUtilCore().getConfig().has("modEnabled") ? MineUtil.getUtilCore().getConfig().get("modEnabled").getAsBoolean() : false);
        this.modMenuKey = (MineUtil.getUtilCore().getConfig().has("modMenuKey") ? MineUtil.getUtilCore().getConfig().get("modMenuKey").getAsInt() : 24);
        this.modCraftDelay = (MineUtil.getUtilCore().getConfig().has("modCraftDelay") ? MineUtil.getUtilCore().getConfig().get("modCraftDelay").getAsInt() : 200);
        this.modCleanDelay = (MineUtil.getUtilCore().getConfig().has("modCleanDelay") ? MineUtil.getUtilCore().getConfig().get("modCleanDelay").getAsInt() : 75);
        this.modCleanCobblestone = (MineUtil.getUtilCore().getConfig().has("modCleanCobblestone") ? MineUtil.getUtilCore().getConfig().get("modCleanCobblestone").getAsBoolean() : false);
        this.modCleanCoal = (MineUtil.getUtilCore().getConfig().has("modCleanCoal") ? MineUtil.getUtilCore().getConfig().get("modCleanCoal").getAsBoolean() : false);
        this.modCleanLapis = (MineUtil.getUtilCore().getConfig().has("modCleanLapis") ? MineUtil.getUtilCore().getConfig().get("modCleanLapis").getAsBoolean() : false);
        this.modCleanRedstone = (MineUtil.getUtilCore().getConfig().has("modCleanRedstone") ? MineUtil.getUtilCore().getConfig().get("modCleanRedstone").getAsBoolean() : false);
        this.modCleanGold = (MineUtil.getUtilCore().getConfig().has("modCleanGold") ? MineUtil.getUtilCore().getConfig().get("modCleanGold").getAsBoolean() : false);
        this.modCleanIron = (MineUtil.getUtilCore().getConfig().has("modCleanIron") ? MineUtil.getUtilCore().getConfig().get("modCleanIron").getAsBoolean() : false);
        this.modCleanEmerald = (MineUtil.getUtilCore().getConfig().has("modCleanEmerald") ? MineUtil.getUtilCore().getConfig().get("modCleanEmerald").getAsBoolean() : false);
        this.modCleanDiamond = (MineUtil.getUtilCore().getConfig().has("modCleanDiamond") ? MineUtil.getUtilCore().getConfig().get("modCleanDiamond").getAsBoolean() : false);
        this.modCleanDirt = (MineUtil.getUtilCore().getConfig().has("modCleanDirt") ? MineUtil.getUtilCore().getConfig().get("modCleanDirt").getAsBoolean() : false);
        this.modCleanOnlySpawner = (MineUtil.getUtilCore().getConfig().has("modCleanOnlySpawner") ? MineUtil.getUtilCore().getConfig().get("modCleanOnlySpawner").getAsBoolean() : false);
        this.mysteryModProxy = (MineUtil.getUtilCore().getConfig().has("mysteryModProxy") ? MineUtil.getUtilCore().getConfig().get("mysteryModProxy").getAsBoolean() : false);
        this.headDownloadKey = (MineUtil.getUtilCore().getConfig().has("headDownloadKey") ? MineUtil.getUtilCore().getConfig().get("headDownloadKey").getAsInt() : 83);
        this.modHeadOwnerKey = (MineUtil.getUtilCore().getConfig().has("modHeadOwnerKey") ? MineUtil.getUtilCore().getConfig().get("modHeadOwnerKey").getAsInt() : 75);
        this.modGGAntiAFK = (MineUtil.getUtilCore().getConfig().has("modGGAntiAFK") ? MineUtil.getUtilCore().getConfig().get("modGGAntiAFK").getAsBoolean() : false);
        this.modGGAutoPortal = (MineUtil.getUtilCore().getConfig().has("modGGAutoPortal") ? MineUtil.getUtilCore().getConfig().get("modGGAutoPortal").getAsBoolean() : false);
        this.modClearEmptyChar = (MineUtil.getUtilCore().getConfig().has("modClearEmptyChar") ? MineUtil.getUtilCore().getConfig().get("modClearEmptyChar").getAsBoolean() : false);
        this.modGGAntiMagicPrefix = (MineUtil.getUtilCore().getConfig().has("modGGAntiMagicPrefix") ? MineUtil.getUtilCore().getConfig().get("modGGAntiMagicPrefix").getAsBoolean() : false);
        this.modFullbright = (MineUtil.getUtilCore().getConfig().has("modFullbright") ? MineUtil.getUtilCore().getConfig().get("modFullbright").getAsBoolean() : false);
        this.modMoneyDropGrabber = (MineUtil.getUtilCore().getConfig().has("modMoneyDropGrabber") ? MineUtil.getUtilCore().getConfig().get("modMoneyDropGrabber").getAsBoolean() : false);
        this.modGGAutoStartKickNein = (MineUtil.getUtilCore().getConfig().has("modGGAutoStartKickNein") ? MineUtil.getUtilCore().getConfig().get("modGGAutoStartKickNein").getAsBoolean() : false);
        this.modCleanFish = (MineUtil.getUtilCore().getConfig().has("modCleanFish") ? MineUtil.getUtilCore().getConfig().get("modCleanFish").getAsBoolean() : false);
        this.modCleanCrystal = (MineUtil.getUtilCore().getConfig().has("modCleanCrystal") ? MineUtil.getUtilCore().getConfig().get("modCleanCrystal").getAsBoolean() : false);
        this.modCleanShard = (MineUtil.getUtilCore().getConfig().has("modCleanShard") ? MineUtil.getUtilCore().getConfig().get("modCleanShard").getAsBoolean() : false);
        this.modHeadOwner = (MineUtil.getUtilCore().getConfig().has("modHeadOwner") ? MineUtil.getUtilCore().getConfig().get("modHeadOwner").getAsBoolean() : false);
        this.modGGAFKMSGMessage = (MineUtil.getUtilCore().getConfig().has("modGGAFKMSGMessage") ? MineUtil.getUtilCore().getConfig().get("modGGAFKMSGMessage").getAsString() : "Hey, tut mir leid. Ich bin gerade AFK!");
        this.modGGAFKMSGManager = (MineUtil.getUtilCore().getConfig().has("modGGAFKMSGManager") ? MineUtil.getUtilCore().getConfig().get("modGGAFKMSGManager").getAsBoolean() : false);
        this.commandPrefix = (MineUtil.getUtilCore().getConfig().has("commandPrefix") ? MineUtil.getUtilCore().getConfig().get("commandPrefix").getAsString() : ".");
        this.modRealMoney$real = (MineUtil.getUtilCore().getConfig().has("modRealMoney_real") ? MineUtil.getUtilCore().getConfig().get("modRealMoney_real").getAsString() : "Real-Money");
        this.modRealMoney$fake = (MineUtil.getUtilCore().getConfig().has("modRealMoney_fake") ? MineUtil.getUtilCore().getConfig().get("modRealMoney_fake").getAsString() : "Fake-Money");
        this.modGGAFKMSGWebhook = (MineUtil.getUtilCore().getConfig().has("modGGAFKMSGWebhook") ? MineUtil.getUtilCore().getConfig().get("modGGAFKMSGWebhook").getAsString() : "null");
	}
    
    public void fillSettings(final List<SettingsElement> settings) {
        settings.add(new HeaderElement("Allgemeine Einstellungen"));
        final BooleanElement modEnabledBtn = new BooleanElement("Addon aktiviert", new ControlElement.IconData("labymod/textures/buttons/accept.png"), new Consumer<Boolean>() {
            public void accept(final Boolean modEnabled) {
                ModSettings.this.setModEnabled(modEnabled);
                MineUtil.getUtilCore().getConfig().addProperty("modEnabled", modEnabled);
                MineUtil.getUtilCore().saveConfig();
            }
        }, this.getModEnabled());
        settings.add(modEnabledBtn);
        
        settings.add(new HeaderElement(""));
        
        StringElement commandStringElement = new StringElement("Command Prefix", new ControlElement.IconData(Material.PAPER), this.commandPrefix, new Consumer<String>() {
            @Override
            public void accept(String accepted) {
            	ModSettings.this.setCommandPrefix(accepted);
                MineUtil.getUtilCore().getConfig().addProperty("commandPrefix", accepted);
                MineUtil.getUtilCore().saveConfig();
            }
        });
        settings.add(commandStringElement);
        
        final BooleanElement modClearEmptyChar = new BooleanElement("Leere Zeilen l\u00f6schen", new ControlElement.IconData("labymod/textures/buttons/hover_default.png"), new Consumer<Boolean>() {
            public void accept(final Boolean modClearEmptyChar) {
                ModSettings.this.setModClearEmptyChar(modClearEmptyChar);
                MineUtil.getUtilCore().getConfig().addProperty("modClearEmptyChar", modClearEmptyChar);
                MineUtil.getUtilCore().saveConfig();
            }
        }, this.isModClearEmptyChar());
        settings.add(modClearEmptyChar);
        
        final BooleanElement modFullbright = new BooleanElement("Fullbright", new ControlElement.IconData("labymod/textures/buttons/hover_default.png"), new Consumer<Boolean>() {
            public void accept(final Boolean modFullbright) {
                ModSettings.this.setModFullbright(modFullbright);
                MineUtil.getUtilCore().getConfig().addProperty("modFullbright", modFullbright);
                MineUtil.getUtilCore().saveConfig();
                if(ModSettings.this.isModFullbright()) {
                	MineUtil.getUtilCore().getMCCore().gameSettings.gammaSetting = 10.0f;
                }
                else {
            		MineUtil.getUtilCore().getMCCore().gameSettings.gammaSetting = 1.0f;
            	}
            }
        }, this.isModFullbright());
        settings.add(modFullbright);
        
        final KeyElement modHeadDLKeyElement = new KeyElement("Kopftextur Download-Hotkey", new ControlElement.IconData("labymod/textures/settings/modules/online_players.png"), (int)this.getHeadDownloadKey(), new Consumer<Integer>() {
            public void accept(final Integer modHeadDLKey) {
                ModSettings.this.setModHeadDownloadKey(modHeadDLKey);
                MineUtil.getUtilCore().getConfig().addProperty("downloaderbutton", (Number) modHeadDLKey);
                MineUtil.getUtilCore().saveConfig();
                if (modHeadDLKey == -1) {
                    return;
                }
            }
        });
        settings.add(modHeadDLKeyElement);
        
        final BooleanElement modHeadOwnerBtn = new BooleanElement("HeadOwner", new ControlElement.IconData("labymod/textures/buttons/hover_default.png"), new Consumer<Boolean>() {
            public void accept(final Boolean modHeadOwner) {
                ModSettings.this.setModHeadOwner(modHeadOwner);
                MineUtil.getUtilCore().getConfig().addProperty("modHeadOwner", modHeadOwner);
                MineUtil.getUtilCore().saveConfig();
            }
        }, this.isModHeadOwner());
        settings.add(modHeadOwnerBtn);
        
        //TODO: KeyStrokes : Begin
        final DropDownMenu<KeyStrokes.DropDown> alignmentDropDownMenu = new DropDownMenu<KeyStrokes.DropDown>("KeyStrokes Mod", 0, 0, 0, 0).fill(KeyStrokes.DropDown.values());
		DropDownElement<KeyStrokes.DropDown> alignmentDropDown = new DropDownElement<KeyStrokes.DropDown>("KeyStrokes Mod", alignmentDropDownMenu);
		alignmentDropDownMenu.setSelected(KeyStrokes.DropDown.DEFAULT);
		alignmentDropDown.setChangeListener(new Consumer<KeyStrokes.DropDown>() {
		    @Override
		    public void accept(KeyStrokes.DropDown alignment) {
		        System.out.println("New selected alignment: " + alignment.name());
		        KeyStrokes.setDDKeyStrokesValue(alignment);
		    }
		} );
		alignmentDropDownMenu.setEntryDrawer(new DropDownMenu.DropDownEntryDrawer() {
		    @Override
		    public void draw(Object object, int x, int y, String trimmedEntry) {
		        String entry = object.toString().toUpperCase();
		        LabyMod.getInstance().getDrawUtils().drawString(LanguageManager.translate(entry), x, y );
		    }
		} );
		settings.add(alignmentDropDown);
		//TODO: KeyStrokes : End
        
    	final ListContainerElement craftCategory = new ListContainerElement("Allgemein - Crafting", new ControlElement.IconData(Material.WORKBENCH));
        settings.add((SettingsElement) craftCategory);
        craftCategory.getSubSettings().add(new HeaderElement("Crafting Einstellungen"));
        
        final KeyElement modMenuKeyElement = new KeyElement("Men\u00fc-Hotkey", new ControlElement.IconData("labymod/textures/settings/settings/keymoduleeditor.png"), (int)this.getModMenuKey(), new Consumer<Integer>() {
            public void accept(final Integer modMenuKey) {
                ModSettings.this.setModMenuKey(modMenuKey);
                MineUtil.getUtilCore().getConfig().addProperty("modMenuKey", (Number)modMenuKey);
                MineUtil.getUtilCore().saveConfig();
                if (modMenuKey == -1) {
                    return;
                }
            }
        });
        craftCategory.getSubSettings().add(modMenuKeyElement);
        final NumberElement modCraftDelayField = new NumberElement("Cooldown in Millisekunden", new ControlElement.IconData("labymod/textures/settings/default/use_default_settings.png"), (int)this.getModCraftDelay());
        modCraftDelayField.setMinValue(50);
        modCraftDelayField.setMaxValue(500);
        modCraftDelayField.addCallback(new Consumer<Integer>() {
            public void accept(final Integer modCraftDelay) {
                ModSettings.this.setModCraftDelay(modCraftDelay);
                MineUtil.getUtilCore().getConfig().addProperty("modCraftDelay", (Number)modCraftDelay);
                MineUtil.getUtilCore().saveConfig();
            }
        });
        craftCategory.getSubSettings().add(modCraftDelayField);

    	final ListContainerElement ggCategory = new ListContainerElement("Allgemein - GrieferGames", new ControlElement.IconData(Material.STONE));
        settings.add((SettingsElement) ggCategory);
        ggCategory.getSubSettings().add(new HeaderElement("§lGrieferGames Einstellungen"));
        
        final BooleanElement mysteryModProxy = new BooleanElement("MysteryMod Proxy", new ControlElement.IconData("labymod/addons/MineUtil/textures/mysterymod.png"), new Consumer<Boolean>() {
            public void accept(final Boolean mysterymodproxy) {
                ModSettings.this.setMysteryModProxy(mysterymodproxy);
                MineUtil.getUtilCore().getConfig().addProperty("mysteryModProxy", mysterymodproxy);
                MineUtil.getUtilCore().saveConfig();
            }
        }, this.isMysteryModProxy());
        ggCategory.getSubSettings().add(mysteryModProxy);
        
        final BooleanElement modGGAntiAFK = new BooleanElement("Anti-AFK System", new ControlElement.IconData("labymod/textures/buttons/hover_default.png"), new Consumer<Boolean>() {
            public void accept(final Boolean modGGAntiAFK) {
                ModSettings.this.setModGGAntiAFK(modGGAntiAFK);
                MineUtil.getUtilCore().getConfig().addProperty("modGGAntiAFK", modGGAntiAFK);
                MineUtil.getUtilCore().saveConfig();
            }
        }, this.isModGGAntiAFK());
        ggCategory.getSubSettings().add(modGGAntiAFK);
        
        final BooleanElement modGGAutoPortal = new BooleanElement("Automatisch mit Portalraum verbinden", new ControlElement.IconData("labymod/textures/buttons/hover_default.png"), new Consumer<Boolean>() {
            public void accept(final Boolean modGGAutoPortal) {
                ModSettings.this.setModGGAutoPortal(modGGAutoPortal);
                MineUtil.getUtilCore().getConfig().addProperty("modGGAutoPortal", modGGAutoPortal);
                MineUtil.getUtilCore().saveConfig();
            }
        }, this.isModGGAutoPortal());
        ggCategory.getSubSettings().add(modGGAutoPortal);

        ggCategory.getSubSettings().add(new HeaderElement("AFK /msg-Beantworter"));
        
        StringElement afkStringElement = new StringElement("Nachricht", new ControlElement.IconData("labymod/textures/settings/modules/afk_timer.png"), this.getModGGAFKMSGMessage()/*"Hey, tut mir leid. Ich bin gerade AFK!"*/, new Consumer<String>() {
            @Override
            public void accept(String accepted) {
            	ModSettings.this.setModGGAFKMSGMessage(accepted);
                MineUtil.getUtilCore().getConfig().addProperty("modGGAFKMSGMessage", accepted);
                MineUtil.getUtilCore().saveConfig();
            }
        });
        ggCategory.getSubSettings().add(afkStringElement);
        
        StringElement dcWebhookStringElement = new StringElement("Discord Webhook", new ControlElement.IconData("labymod/textures/settings/settings/discordrichpresence.png"), this.getModGGAFKMSGWebhook()/*"null"*/, new Consumer<String>() {
            @Override
            public void accept(String accepted) {
            	ModSettings.this.setModGGAFKMSGWebhook(accepted);
                MineUtil.getUtilCore().getConfig().addProperty("modGGAFKMSGWebhook", accepted);
                MineUtil.getUtilCore().saveConfig();
            }
        });
        ggCategory.getSubSettings().add(dcWebhookStringElement);

        ggCategory.getSubSettings().add(new HeaderElement("Real-Money Checker"));
        
        StringElement realMoney$realStringElement = new StringElement("Real-Money Nachricht", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), this.getModRealMoney_Real()/*"Real-Money"*/, new Consumer<String>() {
            @Override
            public void accept(String accepted) {
            	ModSettings.this.setModRealMoney_Real(accepted);
                MineUtil.getUtilCore().getConfig().addProperty("modRealMoney_real", accepted);
                MineUtil.getUtilCore().saveConfig();
            }
        });
        ggCategory.getSubSettings().add(realMoney$realStringElement);
        
        StringElement realMoney$fakeStringElement = new StringElement("Real-Money Nachricht", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), this.getModRealMoney_Fake() /*"Fake-Money"*/, new Consumer<String>() {
            @Override
            public void accept(String accepted) {
            	ModSettings.this.setModRealMoney_Fake(accepted);
                MineUtil.getUtilCore().getConfig().addProperty("modRealMoney_fake", accepted);
                MineUtil.getUtilCore().saveConfig();
            }
        });
        ggCategory.getSubSettings().add(realMoney$fakeStringElement);
        
    	final ListContainerElement ggSpawnerCategory = new ListContainerElement("Cleaning - Spawner", new ControlElement.IconData(Material.MOB_SPAWNER));
    	settings.add((SettingsElement) ggSpawnerCategory);

    	ggSpawnerCategory.getSubSettings().add(new HeaderElement("Spawner - Einstellungen"));

		ggSpawnerCategory.getSubSettings().add(new HeaderElement("Cleaning Einstellungen"));
        final NumberElement modCleanDelayField = new NumberElement("Cooldown in Millisekunden", new ControlElement.IconData("labymod/textures/settings/default/use_default_settings.png"), (int)this.getModCleanDelay());
        modCleanDelayField.setMinValue(50);
        modCleanDelayField.setMaxValue(500);
        modCleanDelayField.addCallback(new Consumer<Integer>() {
            public void accept(final Integer modCleanDelay) {
                ModSettings.this.setModCleanDelay(modCleanDelay);
                MineUtil.getUtilCore().getConfig().addProperty("modCleanDelay", (Number)modCleanDelay);
                MineUtil.getUtilCore().saveConfig();
            }
        });
        ggSpawnerCategory.getSubSettings().add(modCleanDelayField);
        
    	ggSpawnerCategory.getSubSettings().add(new HeaderElement(""));
    	
    	ggSpawnerCategory.getSubSettings().add(new BooleanElement("Nur Spawner leeren", new ControlElement.IconData(Material.MOB_SPAWNER), new Consumer<Boolean>() {
            public void accept(final Boolean modCleanOnlySpawner) {
                ModSettings.this.setModCleanOnlySpawner(modCleanOnlySpawner);
                MineUtil.getUtilCore().getConfig().addProperty("modCleanOnlySpawner", modCleanOnlySpawner);
                MineUtil.getUtilCore().saveConfig();
            }
        }, this.isModCleanOnlySpawner()));
        ggSpawnerCategory.getSubSettings().add(new BooleanElement("Bruchstein droppen", new ControlElement.IconData(Material.COBBLESTONE), new Consumer<Boolean>() {
            public void accept(final Boolean modCleanCobblestone) {
                ModSettings.this.setModCleanCobblestone(modCleanCobblestone);
                MineUtil.getUtilCore().getConfig().addProperty("modCleanCobblestone", modCleanCobblestone);
                MineUtil.getUtilCore().saveConfig();
            }
        }, this.isModCleanCobblestone()));
        ggSpawnerCategory.getSubSettings().add(new BooleanElement("Erde droppen", new ControlElement.IconData(Material.DIRT), new Consumer<Boolean>() {
            public void accept(final Boolean modCleanDirt) {
                ModSettings.this.setModCleanDirt(modCleanDirt);
                MineUtil.getUtilCore().getConfig().addProperty("modCleanDirt", modCleanDirt);
                MineUtil.getUtilCore().saveConfig();
            }
        }, this.isModCleanDirt()));
        ggSpawnerCategory.getSubSettings().add(new BooleanElement("Kohle droppen", new ControlElement.IconData(Material.COAL_BLOCK), new Consumer<Boolean>() {
            public void accept(final Boolean modCleanCoal) {
                ModSettings.this.setModCleanCoal(modCleanCoal);
                MineUtil.getUtilCore().getConfig().addProperty("modCleanCoal", modCleanCoal);
                MineUtil.getUtilCore().saveConfig();
            }
        }, this.isModCleanCoal()));
        ggSpawnerCategory.getSubSettings().add(new BooleanElement("Lapislazuli droppen", new ControlElement.IconData(Material.LAPIS_BLOCK), new Consumer<Boolean>() {
            public void accept(final Boolean modCleanLapis) {
                ModSettings.this.setModCleanLapis(modCleanLapis);
                MineUtil.getUtilCore().getConfig().addProperty("modCleanLapis", modCleanLapis);
                MineUtil.getUtilCore().saveConfig();
            }
        }, this.isModCleanLapis()));
        ggSpawnerCategory.getSubSettings().add(new BooleanElement("Redstone droppen", new ControlElement.IconData(Material.REDSTONE_BLOCK), new Consumer<Boolean>() {
            public void accept(final Boolean modCleanRedstone) {
                ModSettings.this.setModCleanRedstone(modCleanRedstone);
                MineUtil.getUtilCore().getConfig().addProperty("modCleanRedstone", modCleanRedstone);
                MineUtil.getUtilCore().saveConfig();
            }
        }, this.isModCleanRedstone()));
        ggSpawnerCategory.getSubSettings().add(new BooleanElement("Gold droppen", new ControlElement.IconData(Material.GOLD_BLOCK), new Consumer<Boolean>() {
            public void accept(final Boolean modCleanGold) {
                ModSettings.this.setModCleanGold(modCleanGold);
                MineUtil.getUtilCore().getConfig().addProperty("modCleanGold", modCleanGold);
                MineUtil.getUtilCore().saveConfig();
            }
        }, this.isModCleanGold()));
        ggSpawnerCategory.getSubSettings().add(new BooleanElement("Eisen droppen", new ControlElement.IconData(Material.IRON_BLOCK), new Consumer<Boolean>() {
            public void accept(final Boolean modCleanIron) {
                ModSettings.this.setModCleanIron(modCleanIron);
                MineUtil.getUtilCore().getConfig().addProperty("modCleanIron", modCleanIron);
                MineUtil.getUtilCore().saveConfig();
            }
        }, this.isModCleanIron()));
        ggSpawnerCategory.getSubSettings().add(new BooleanElement("Smaragd droppen", new ControlElement.IconData(Material.EMERALD_BLOCK), new Consumer<Boolean>() {
            public void accept(final Boolean modCleanEmerald) {
                ModSettings.this.setModCleanEmerald(modCleanEmerald);
                MineUtil.getUtilCore().getConfig().addProperty("modCleanEmerald", modCleanEmerald);
                MineUtil.getUtilCore().saveConfig();
            }
        }, this.isModCleanEmerald()));
        ggSpawnerCategory.getSubSettings().add(new BooleanElement("Diamant droppen", new ControlElement.IconData(Material.DIAMOND_BLOCK), new Consumer<Boolean>() {
            public void accept(final Boolean modCleanDiamond) {
                ModSettings.this.setModCleanDiamond(modCleanDiamond);
                MineUtil.getUtilCore().getConfig().addProperty("modCleanDiamond", modCleanDiamond);
                MineUtil.getUtilCore().saveConfig();
            }
        }, this.isModCleanDiamond()));

        PreisInfos.fillPriceSettings(settings);
        settings.add(new TextElement("§7Version§8: §a" + MineUtil.getUtilCore().getVersion()));
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
