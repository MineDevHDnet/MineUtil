package net.minedevhd.mineutil.gui.storageprices;

import java.util.List;

import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.HeaderElement;
import net.labymod.settings.elements.ListContainerElement;
import net.labymod.settings.elements.NumberElement;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.utils.Consumer;
import net.labymod.utils.Material;
import net.labymod.utils.ModColor;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.settings.ModSettings;
import net.minedevhd.mineutil.settings.UtilCore;

public class PreisInfos implements UtilCore {
	
	private static Integer EICHENHOLZ = 2800,
						   BIRKENHOLZ = 2800,
						   FICHTENHOLZ = 2800,
						   AKAZIENHOLZ = 3200,
						   JUNGELHOLZ = 2800,
						   SCHWARZEICHENHOLZ = 2500,

						   EICHENLAUB = 2500,
						   BIRKENLAUB = 2500,
						   FICHTENLAUB = 2500,
						   AKAZIENLAUB = 2500,
						   JUNGELLAUB = 2500,
						   SCHWARZEICHENLAUB = 2500,

						   SAND = 1500,
						   SANDSTEIN = 2000,
						   ROTER_SAND = 4000,
						   ROTER_SANDSTEIN = 16000,
    
						   NETHERSTEIN = 1000,
						   NETHERZIEGEL = 5500,
						   QUARZBLOCK = 15000,
						   GLOWSTONE = 6000,
						   SEELATERNEN = 1500,
						   OBSIDIAN = 12000,
    
						   DIORIT = 4500,
						   GRANIT = 4500,
						   ANDESIT = 4500,
						   KIES = 2500,
						   MYZEL = 3000,
						   PODSOL = 4000,
						   ZIEGELSTEIN = 15000,
						   FLUSSTON = 14000,
	    
						   EIS = 4000,
						   PACKEIS = 4500,
						   SCHNEE = 4000,
   
						   KOHLEBLOCK = 4500,
						   EISENBLOCK = 18000,
						   LAPISBLOCK = 6000,
						   REDSTONEBLOCK = 4500,
						   GOLDBLOCK = 13500,
						   DIAMANTBLOCK = 28000,
						   SMARAGDBLOCK = 28000,
	    
						   GRASBLOCK = 2000,
						   STEINZIEGEL = 2500,
						   RISSIGER_STEINZIEGEL = 3500,
						   BEMOOSTER_STEINZIEGEL = 4500,

						   WEISSE_WOLLE = 2500,
						   FARBIGE_WOLLE = 3000,
					    
						   GEBRANNTER_TON = 2500,
						   FARBIGER_TON = 3000,

						   GLAS_BLOCK = 2500,
						   FARBIGES_GLAS = 3000;
	
	public static final Integer getEICHENHOLZ() {
		return EICHENHOLZ;
	}

	private static final void setEICHENHOLZ(Integer eICHENHOLZ) {
		EICHENHOLZ = eICHENHOLZ;
	}

	public static final Integer getBIRKENHOLZ() {
		return BIRKENHOLZ;
	}

	private static final void setBIRKENHOLZ(Integer bIRKENHOLZ) {
		BIRKENHOLZ = bIRKENHOLZ;
	}

	public static final Integer getFICHTENHOLZ() {
		return FICHTENHOLZ;
	}

	private static final void setFICHTENHOLZ(Integer fICHTENHOLZ) {
		FICHTENHOLZ = fICHTENHOLZ;
	}

	public static final Integer getAKAZIENHOLZ() {
		return AKAZIENHOLZ;
	}

	private static final void setAKAZIENHOLZ(Integer aKAZIENHOLZ) {
		AKAZIENHOLZ = aKAZIENHOLZ;
	}

	public static final Integer getJUNGELHOLZ() {
		return JUNGELHOLZ;
	}

	private static final void setJUNGELHOLZ(Integer jUNGELHOLZ) {
		JUNGELHOLZ = jUNGELHOLZ;
	}

	public static final Integer getSCHWARZEICHENHOLZ() {
		return SCHWARZEICHENHOLZ;
	}

	private static final void setSCHWARZEICHENHOLZ(Integer sCHWARZEICHENHOLZ) {
		SCHWARZEICHENHOLZ = sCHWARZEICHENHOLZ;
	}

	public static final Integer getEICHENLAUB() {
		return EICHENLAUB;
	}

	private static final void setEICHENLAUB(Integer eICHENLAUB) {
		EICHENLAUB = eICHENLAUB;
	}

	public static final Integer getBIRKENLAUB() {
		return BIRKENLAUB;
	}

	private static final void setBIRKENLAUB(Integer bIRKENLAUB) {
		BIRKENLAUB = bIRKENLAUB;
	}

	public static final Integer getFICHTENLAUB() {
		return FICHTENLAUB;
	}

	private static final void setFICHTENLAUB(Integer fICHTENLAUB) {
		FICHTENLAUB = fICHTENLAUB;
	}

	public static final Integer getAKAZIENLAUB() {
		return AKAZIENLAUB;
	}

	private static final void setAKAZIENLAUB(Integer aKAZIENLAUB) {
		AKAZIENLAUB = aKAZIENLAUB;
	}

	public static final Integer getJUNGELLAUB() {
		return JUNGELLAUB;
	}

	private static final void setJUNGELLAUB(Integer jUNGELLAUB) {
		JUNGELLAUB = jUNGELLAUB;
	}

	public static final Integer getSCHWARZEICHENLAUB() {
		return SCHWARZEICHENLAUB;
	}

	private static final void setSCHWARZEICHENLAUB(Integer sCHWARZEICHENLAUB) {
		SCHWARZEICHENLAUB = sCHWARZEICHENLAUB;
	}

	public static final Integer getSAND() {
		return SAND;
	}

	private static final void setSAND(Integer sAND) {
		SAND = sAND;
	}

	public static final Integer getSANDSTEIN() {
		return SANDSTEIN;
	}

	private static final void setSANDSTEIN(Integer sANDSTEIN) {
		SANDSTEIN = sANDSTEIN;
	}

	public static final Integer getROTER_SAND() {
		return ROTER_SAND;
	}

	private static final void setROTER_SAND(Integer rOTER_SAND) {
		ROTER_SAND = rOTER_SAND;
	}

	public static final Integer getROTER_SANDSTEIN() {
		return ROTER_SANDSTEIN;
	}

	private static final void setROTER_SANDSTEIN(Integer rOTER_SANDSTEIN) {
		ROTER_SANDSTEIN = rOTER_SANDSTEIN;
	}

	public static final Integer getNETHERSTEIN() {
		return NETHERSTEIN;
	}

	private static final void setNETHERSTEIN(Integer nETHERSTEIN) {
		NETHERSTEIN = nETHERSTEIN;
	}

	public static final Integer getNETHERZIEGEL() {
		return NETHERZIEGEL;
	}

	private static final void setNETHERZIEGEL(Integer nETHERZIEGEL) {
		NETHERZIEGEL = nETHERZIEGEL;
	}

	public static final Integer getQUARZBLOCK() {
		return QUARZBLOCK;
	}

	private static final void setQUARZBLOCK(Integer qUARZBLOCK) {
		QUARZBLOCK = qUARZBLOCK;
	}

	public static final Integer getGLOWSTONE() {
		return GLOWSTONE;
	}

	private static final void setGLOWSTONE(Integer gLOWSTONE) {
		GLOWSTONE = gLOWSTONE;
	}

	public static final Integer getSEELATERNEN() {
		return SEELATERNEN;
	}

	private static final void setSEELATERNEN(Integer sEELATERNEN) {
		SEELATERNEN = sEELATERNEN;
	}

	public static final Integer getOBSIDIAN() {
		return OBSIDIAN;
	}

	private static final void setOBSIDIAN(Integer oBSIDIAN) {
		OBSIDIAN = oBSIDIAN;
	}

	public static final Integer getDIORIT() {
		return DIORIT;
	}

	private static final void setDIORIT(Integer dIORIT) {
		DIORIT = dIORIT;
	}

	public static final Integer getGRANIT() {
		return GRANIT;
	}

	private static final void setGRANIT(Integer gRANIT) {
		GRANIT = gRANIT;
	}

	public static final Integer getANDESIT() {
		return ANDESIT;
	}

	private static final void setANDESIT(Integer aNDESIT) {
		ANDESIT = aNDESIT;
	}

	public static final Integer getKIES() {
		return KIES;
	}

	private static final void setKIES(Integer kIES) {
		KIES = kIES;
	}

	public static final Integer getMYZEL() {
		return MYZEL;
	}

	private static final void setMYZEL(Integer mYZEL) {
		MYZEL = mYZEL;
	}

	public static final Integer getPODSOL() {
		return PODSOL;
	}

	private static final void setPODSOL(Integer pODSOL) {
		PODSOL = pODSOL;
	}

	public static final Integer getZIEGELSTEIN() {
		return ZIEGELSTEIN;
	}

	private static final void setZIEGELSTEIN(Integer zIEGELSTEIN) {
		ZIEGELSTEIN = zIEGELSTEIN;
	}

	public static final Integer getFLUSSTON() {
		return FLUSSTON;
	}

	private static final void setFLUSSTON(Integer fLUSSTON) {
		FLUSSTON = fLUSSTON;
	}

	public static final Integer getEIS() {
		return EIS;
	}

	private static final void setEIS(Integer eIS) {
		EIS = eIS;
	}

	public static final Integer getPACKEIS() {
		return PACKEIS;
	}

	private static final void setPACKEIS(Integer pACKEIS) {
		PACKEIS = pACKEIS;
	}

	public static final Integer getSCHNEE() {
		return SCHNEE;
	}

	private static final void setSCHNEE(Integer sCHNEE) {
		SCHNEE = sCHNEE;
	}

	public static final Integer getKOHLEBLOCK() {
		return KOHLEBLOCK;
	}

	private static final void setKOHLEBLOCK(Integer kOHLEBLOCK) {
		KOHLEBLOCK = kOHLEBLOCK;
	}

	public static final Integer getEISENBLOCK() {
		return EISENBLOCK;
	}

	private static final void setEISENBLOCK(Integer eISENBLOCK) {
		EISENBLOCK = eISENBLOCK;
	}

	public static final Integer getLAPISBLOCK() {
		return LAPISBLOCK;
	}

	private static final void setLAPISBLOCK(Integer lAPISBLOCK) {
		LAPISBLOCK = lAPISBLOCK;
	}

	public static final Integer getREDSTONEBLOCK() {
		return REDSTONEBLOCK;
	}

	private static final void setREDSTONEBLOCK(Integer rEDSTONEBLOCK) {
		REDSTONEBLOCK = rEDSTONEBLOCK;
	}

	public static final Integer getGOLDBLOCK() {
		return GOLDBLOCK;
	}

	private static final void setGOLDBLOCK(Integer gOLDBLOCK) {
		GOLDBLOCK = gOLDBLOCK;
	}

	public static final Integer getDIAMANTBLOCK() {
		return DIAMANTBLOCK;
	}

	private static final void setDIAMANTBLOCK(Integer dIAMANTBLOCK) {
		DIAMANTBLOCK = dIAMANTBLOCK;
	}

	public static final Integer getSMARAGDBLOCK() {
		return SMARAGDBLOCK;
	}

	private static final void setSMARAGDBLOCK(Integer sMARAGDBLOCK) {
		SMARAGDBLOCK = sMARAGDBLOCK;
	}

	public static final Integer getGRASBLOCK() {
		return GRASBLOCK;
	}

	private static final void setGRASBLOCK(Integer gRASBLOCK) {
		GRASBLOCK = gRASBLOCK;
	}

	public static final Integer getSTEINZIEGEL() {
		return STEINZIEGEL;
	}

	private static final void setSTEINZIEGEL(Integer sTEINZIEGEL) {
		STEINZIEGEL = sTEINZIEGEL;
	}

	public static final Integer getRISSIGER_STEINZIEGEL() {
		return RISSIGER_STEINZIEGEL;
	}

	private static final void setRISSIGER_STEINZIEGEL(Integer rISSIGER_STEINZIEGEL) {
		RISSIGER_STEINZIEGEL = rISSIGER_STEINZIEGEL;
	}

	public static final Integer getBEMOOSTER_STEINZIEGEL() {
		return BEMOOSTER_STEINZIEGEL;
	}

	private static final void setBEMOOSTER_STEINZIEGEL(Integer bEMOOSTER_STEINZIEGEL) {
		BEMOOSTER_STEINZIEGEL = bEMOOSTER_STEINZIEGEL;
	}

	public static final Integer getWEISSE_WOLLE() {
		return WEISSE_WOLLE;
	}

	private static final void setWEISSE_WOLLE(Integer wEISSE_WOLLE) {
		WEISSE_WOLLE = wEISSE_WOLLE;
	}

	public static final Integer getFARBIGE_WOLLE() {
		return FARBIGE_WOLLE;
	}

	private static final void setFARBIGE_WOLLE(Integer fARBIGE_WOLLE) {
		FARBIGE_WOLLE = fARBIGE_WOLLE;
	}

	public static final Integer getGEBRANNTER_TON() {
		return GEBRANNTER_TON;
	}

	private static final void setGEBRANNTER_TON(Integer gEBRANNTER_TON) {
		GEBRANNTER_TON = gEBRANNTER_TON;
	}

	public static final Integer getFARBIGER_TON() {
		return FARBIGER_TON;
	}

	private static final void setFARBIGER_TON(Integer fARBIGER_TON) {
		FARBIGER_TON = fARBIGER_TON;
	}

	public static final Integer getGLAS_BLOCK() {
		return GLAS_BLOCK;
	}

	private static final void setGLAS_BLOCK(Integer gLAS_BLOCK) {
		GLAS_BLOCK = gLAS_BLOCK;
	}

	public static final Integer getFARBIGES_GLAS() {
		return FARBIGES_GLAS;
	}

	private static final void setFARBIGES_GLAS(Integer fARBIGES_GLAS) {
		FARBIGES_GLAS = fARBIGES_GLAS;
	}
	
	public static final void loadPriceConfig() {
        EICHENHOLZ = (mineUtil.getConfig().has("Eichenholz") ? mineUtil.getConfig().get("Eichenholz").getAsInt() : 2800);
        BIRKENHOLZ = (mineUtil.getConfig().has("Birkenholz") ? mineUtil.getConfig().get("Birkenholz").getAsInt() : 2800);
        FICHTENHOLZ = (mineUtil.getConfig().has("Fichtenholz") ? mineUtil.getConfig().get("Fichtenholz").getAsInt() : 2800);
        AKAZIENHOLZ = (mineUtil.getConfig().has("Akazienholz") ? mineUtil.getConfig().get("Akazienholz").getAsInt() : 2800);
        JUNGELHOLZ = (mineUtil.getConfig().has("Jungelholz") ? mineUtil.getConfig().get("Jungelholz").getAsInt() : 2800);
        SCHWARZEICHENHOLZ = (mineUtil.getConfig().has("Schwarzeichenholz") ? mineUtil.getConfig().get("Schwarzeichenholz").getAsInt() : 2800);

        EICHENLAUB = (mineUtil.getConfig().has("Eichenlaub") ? mineUtil.getConfig().get("Eichenlaub").getAsInt() : 2500);
        BIRKENLAUB = (mineUtil.getConfig().has("Birkenlaub") ? mineUtil.getConfig().get("Birkenlaub").getAsInt() : 2500);
        FICHTENLAUB = (mineUtil.getConfig().has("Fichtenlaub") ? mineUtil.getConfig().get("Fichtenlaub").getAsInt() : 2500);
        AKAZIENLAUB = (mineUtil.getConfig().has("Akazienlaub") ? mineUtil.getConfig().get("Akazienlaub").getAsInt() : 2500);
        JUNGELLAUB = (mineUtil.getConfig().has("Jungellaub") ? mineUtil.getConfig().get("Jungellaub").getAsInt() : 2500);
        SCHWARZEICHENLAUB = (mineUtil.getConfig().has("Schwarzeichenlaub") ? mineUtil.getConfig().get("Schwarzeichenlaub").getAsInt() : 2500);

        SAND = (mineUtil.getConfig().has("Sand") ? mineUtil.getConfig().get("Sand").getAsInt() : 1500);
        SANDSTEIN = (mineUtil.getConfig().has("Sandstein") ? mineUtil.getConfig().get("Sandstein").getAsInt() : 2000);
        ROTER_SAND = (mineUtil.getConfig().has("RoterSand") ? mineUtil.getConfig().get("RoterSand").getAsInt() : 4000);
        ROTER_SANDSTEIN = (mineUtil.getConfig().has("RoterSandstein") ? mineUtil.getConfig().get("RoterSandstein").getAsInt() : 16000);

        NETHERSTEIN = (mineUtil.getConfig().has("Netherstein") ? mineUtil.getConfig().get("Netherstein").getAsInt() : 1000);
        NETHERZIEGEL = (mineUtil.getConfig().has("Netherziegel") ? mineUtil.getConfig().get("Netherziegel").getAsInt() : 5500);
        QUARZBLOCK = (mineUtil.getConfig().has("Quarzblock") ? mineUtil.getConfig().get("Quarzblock").getAsInt() : 15000);
        GLOWSTONE = (mineUtil.getConfig().has("Glowstone") ? mineUtil.getConfig().get("Glowstone").getAsInt() : 6000);
        SEELATERNEN = (mineUtil.getConfig().has("Seelaternen") ? mineUtil.getConfig().get("Seelaternen").getAsInt() : 1500);
        OBSIDIAN = (mineUtil.getConfig().has("Obsidian") ? mineUtil.getConfig().get("Obsidian").getAsInt() : 12000);

        DIORIT = (mineUtil.getConfig().has("Diorit") ? mineUtil.getConfig().get("Diorit").getAsInt() : 4500);
        GRANIT = (mineUtil.getConfig().has("Granit") ? mineUtil.getConfig().get("Granit").getAsInt() : 4500);
        ANDESIT = (mineUtil.getConfig().has("Andesit") ? mineUtil.getConfig().get("Andesit").getAsInt() : 4500);
        KIES = (mineUtil.getConfig().has("Kies") ? mineUtil.getConfig().get("Kies").getAsInt() : 2500);
        MYZEL = (mineUtil.getConfig().has("Myzel") ? mineUtil.getConfig().get("Myzel").getAsInt() : 3000);
        PODSOL = (mineUtil.getConfig().has("Podsol") ? mineUtil.getConfig().get("Podsol").getAsInt() : 4000);
        ZIEGELSTEIN = (mineUtil.getConfig().has("Ziegelstein") ? mineUtil.getConfig().get("Ziegelstein").getAsInt() : 15000);
        FLUSSTON = (mineUtil.getConfig().has("Flusston") ? mineUtil.getConfig().get("Flusston").getAsInt() : 14000);

        EIS = (mineUtil.getConfig().has("Eis") ? mineUtil.getConfig().get("Eis").getAsInt() : 4000);
        PACKEIS = (mineUtil.getConfig().has("Packeis") ? mineUtil.getConfig().get("Packeis").getAsInt() : 4500);
        SCHNEE = (mineUtil.getConfig().has("Schnee") ? mineUtil.getConfig().get("Schnee").getAsInt() : 4000);

        KOHLEBLOCK = (mineUtil.getConfig().has("Kohleblock") ? mineUtil.getConfig().get("Kohleblock").getAsInt() : 4500);
        EISENBLOCK = (mineUtil.getConfig().has("Eisenblock") ? mineUtil.getConfig().get("Eisenblock").getAsInt() : 18000);
        LAPISBLOCK = (mineUtil.getConfig().has("Lapisblock") ? mineUtil.getConfig().get("Lapisblock").getAsInt() : 6000);
        REDSTONEBLOCK = (mineUtil.getConfig().has("Redstoneblock") ? mineUtil.getConfig().get("Redstoneblock").getAsInt() : 4500);
        GOLDBLOCK = (mineUtil.getConfig().has("Goldblock") ? mineUtil.getConfig().get("Goldblock").getAsInt() : 13500);
        DIAMANTBLOCK = (mineUtil.getConfig().has("Diamantblock") ? mineUtil.getConfig().get("Diamantblock").getAsInt() : 28000);
        SMARAGDBLOCK = (mineUtil.getConfig().has("Smaragdblock") ? mineUtil.getConfig().get("Smaragdblock").getAsInt() : 28000);

        GRASBLOCK = (mineUtil.getConfig().has("Grasblock") ? mineUtil.getConfig().get("Grasblock").getAsInt() : 2000);
        STEINZIEGEL = (mineUtil.getConfig().has("Steinziegel") ? mineUtil.getConfig().get("Steinziegel").getAsInt() : 2500);
        RISSIGER_STEINZIEGEL = (mineUtil.getConfig().has("Rissiger_Steinziegel") ? mineUtil.getConfig().get("Rissiger_Steinziegel").getAsInt() : 3500);
        BEMOOSTER_STEINZIEGEL = (mineUtil.getConfig().has("Bemooster_Steinziegel") ? mineUtil.getConfig().get("Bemooster_Steinziegel").getAsInt() : 4500);

        WEISSE_WOLLE = (mineUtil.getConfig().has("WeisseWolle") ? mineUtil.getConfig().get("WeisseWolle").getAsInt() : 2500);
        FARBIGE_WOLLE = (mineUtil.getConfig().has("FarbigeWolle") ? mineUtil.getConfig().get("FarbigeWolle").getAsInt() : 3000);

        GEBRANNTER_TON = (mineUtil.getConfig().has("GebrannterTon") ? mineUtil.getConfig().get("GebrannterTon").getAsInt() : 2500);
        FARBIGER_TON = (mineUtil.getConfig().has("FarbigerTon") ? mineUtil.getConfig().get("FarbigerTon").getAsInt() : 3000);

        GLAS_BLOCK = (mineUtil.getConfig().has("Glasblock") ? mineUtil.getConfig().get("Glasblock").getAsInt() : 2500);
        FARBIGES_GLAS = (mineUtil.getConfig().has("FarbigesGlas") ? mineUtil.getConfig().get("FarbigesGlas").getAsInt() : 3000);
	}

	public static final void fillPriceSettings(final List<SettingsElement> settings) {
		final ListContainerElement priceCategory = new ListContainerElement("Allgemein - Preis Einstellungen", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"));
        settings.add((SettingsElement) priceCategory);
        priceCategory.getSubSettings().add(new HeaderElement("§lTED-Preis Einstellungen"));
        
        priceCategory.getSubSettings().add(new HeaderElement("Holz"));
		final NumberElement numberElement1 = new NumberElement("Eichenholz", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getEICHENHOLZ());
		numberElement1.setMinValue(0);
		numberElement1.setMaxValue(50000);
		numberElement1.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setEICHENHOLZ(itemPrice);
                mineUtil.getConfig().addProperty("Eichenholz", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement1);
		final NumberElement numberElement2 = new NumberElement("Birkenholz", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getBIRKENHOLZ());
		numberElement2.setMinValue(0);
		numberElement2.setMaxValue(50000);
		numberElement2.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setBIRKENHOLZ(itemPrice);
                mineUtil.getConfig().addProperty("Birkenholz", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement2);
		final NumberElement numberElement3 = new NumberElement("Fichtenholz", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getFICHTENHOLZ());
		numberElement3.setMinValue(0);
		numberElement3.setMaxValue(50000);
		numberElement3.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setFICHTENHOLZ(itemPrice);
                mineUtil.getConfig().addProperty("Fichtenholz", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement3);
		final NumberElement numberElement4 = new NumberElement("Akazienholz", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getAKAZIENHOLZ());
		numberElement4.setMinValue(0);
		numberElement4.setMaxValue(50000);
		numberElement4.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setAKAZIENHOLZ(itemPrice);
                mineUtil.getConfig().addProperty("Akazienholz", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement4);
		final NumberElement numberElement5 = new NumberElement("Jungelholz", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getJUNGELHOLZ());
		numberElement5.setMinValue(0);
		numberElement5.setMaxValue(50000);
		numberElement5.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setJUNGELHOLZ(itemPrice);
                mineUtil.getConfig().addProperty("Jungelholz", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement5);
		final NumberElement numberElement6 = new NumberElement("Schwarzeichenholz", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getSCHWARZEICHENHOLZ());
		numberElement6.setMinValue(0);
		numberElement6.setMaxValue(50000);
		numberElement6.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setSCHWARZEICHENHOLZ(itemPrice);
                mineUtil.getConfig().addProperty("Schwarzeichenholz", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement6);
        
        priceCategory.getSubSettings().add(new HeaderElement("Laub"));
		final NumberElement numberElement7 = new NumberElement("Eichenlaub", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getEICHENLAUB());
		numberElement7.setMinValue(0);
		numberElement7.setMaxValue(50000);
		numberElement7.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setSCHWARZEICHENHOLZ(itemPrice);
                mineUtil.getConfig().addProperty("Eichenlaub", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement7);
		final NumberElement numberElement8 = new NumberElement("Birkenlaub", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getBIRKENLAUB());
		numberElement8.setMinValue(0);
		numberElement8.setMaxValue(50000);
		numberElement8.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setBIRKENLAUB(itemPrice);
                mineUtil.getConfig().addProperty("Birkenlaub", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement8);
		final NumberElement numberElement9 = new NumberElement("Fichtenlaub", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getFICHTENLAUB());
		numberElement9.setMinValue(0);
		numberElement9.setMaxValue(50000);
		numberElement9.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setFICHTENLAUB(itemPrice);
                mineUtil.getConfig().addProperty("Fichtenlaub", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement9);
		final NumberElement numberElement10 = new NumberElement("Akazienlaub", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getAKAZIENLAUB());
		numberElement10.setMinValue(0);
		numberElement10.setMaxValue(50000);
		numberElement10.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setAKAZIENLAUB(itemPrice);
                mineUtil.getConfig().addProperty("Akazienlaub", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement10);
		final NumberElement numberElement12 = new NumberElement("Schwarzeichenlaub", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getSCHWARZEICHENLAUB());
		numberElement12.setMinValue(0);
		numberElement12.setMaxValue(50000);
		numberElement12.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setSCHWARZEICHENLAUB(itemPrice);
                mineUtil.getConfig().addProperty("Schwarzeichenlaub", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement12);
        
        priceCategory.getSubSettings().add(new HeaderElement("Sand"));
		final NumberElement numberElement13 = new NumberElement("Sand", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getSAND());
		numberElement13.setMinValue(0);
		numberElement13.setMaxValue(50000);
		numberElement13.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setSAND(itemPrice);
                mineUtil.getConfig().addProperty("Sand", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement13);
		final NumberElement numberElement14 = new NumberElement("Sandstein", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getSANDSTEIN());
		numberElement14.setMinValue(0);
		numberElement14.setMaxValue(50000);
		numberElement14.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setSANDSTEIN(itemPrice);
                mineUtil.getConfig().addProperty("Sandstein", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement14);
		final NumberElement numberElement15 = new NumberElement("Roter Sand", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getROTER_SAND());
		numberElement15.setMinValue(0);
		numberElement15.setMaxValue(50000);
		numberElement15.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setROTER_SAND(itemPrice);
                mineUtil.getConfig().addProperty("RoterSand", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement15);
		final NumberElement numberElement16 = new NumberElement("Roter Sandstein", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getROTER_SANDSTEIN());
		numberElement16.setMinValue(0);
		numberElement16.setMaxValue(50000);
		numberElement16.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setROTER_SANDSTEIN(itemPrice);
                mineUtil.getConfig().addProperty("RoterSandstein", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement16);
        
        priceCategory.getSubSettings().add(new HeaderElement("Nether"));
		final NumberElement numberElement17 = new NumberElement("Netherstein", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getNETHERSTEIN());
		numberElement17.setMinValue(0);
		numberElement17.setMaxValue(50000);
		numberElement17.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setNETHERSTEIN(itemPrice);
                mineUtil.getConfig().addProperty("Netherstein", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement17);
		final NumberElement numberElement18 = new NumberElement("Netherziegel", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getNETHERZIEGEL());
		numberElement18.setMinValue(0);
		numberElement18.setMaxValue(50000);
		numberElement18.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setNETHERZIEGEL(itemPrice);
                mineUtil.getConfig().addProperty("Netherziegel", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement18);
		final NumberElement numberElement19 = new NumberElement("Quarzblock", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getQUARZBLOCK());
		numberElement19.setMinValue(0);
		numberElement19.setMaxValue(50000);
		numberElement19.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setQUARZBLOCK(itemPrice);
                mineUtil.getConfig().addProperty("Quarzblock", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement19);
		final NumberElement numberElement20 = new NumberElement("Glowstone", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getGLOWSTONE());
		numberElement20.setMinValue(0);
		numberElement20.setMaxValue(50000);
		numberElement20.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setGLOWSTONE(itemPrice);
                mineUtil.getConfig().addProperty("Glowstone", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement20);
		final NumberElement numberElement21 = new NumberElement("Seelaternen", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getSEELATERNEN());
		numberElement21.setMinValue(0);
		numberElement21.setMaxValue(50000);
		numberElement21.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setSEELATERNEN(itemPrice);
                mineUtil.getConfig().addProperty("Seelaternen", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement21);
		final NumberElement numberElement22 = new NumberElement("Obsidian", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getOBSIDIAN());
		numberElement22.setMinValue(0);
		numberElement22.setMaxValue(50000);
		numberElement22.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setOBSIDIAN(itemPrice);
                mineUtil.getConfig().addProperty("Obsidian", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement22);
        
        priceCategory.getSubSettings().add(new HeaderElement("Gestein"));
		final NumberElement numberElement23 = new NumberElement("Diorit", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getDIORIT());
		numberElement23.setMinValue(0);
		numberElement23.setMaxValue(50000);
		numberElement23.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setDIORIT(itemPrice);
                mineUtil.getConfig().addProperty("Diorit", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement23);
		final NumberElement numberElement24 = new NumberElement("Granit", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getGRANIT());
		numberElement24.setMinValue(0);
		numberElement24.setMaxValue(50000);
		numberElement24.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setGRANIT(itemPrice);
                mineUtil.getConfig().addProperty("Granit", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement24);
		final NumberElement numberElement25 = new NumberElement("Andesit", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getGRANIT());
		numberElement25.setMinValue(0);
		numberElement25.setMaxValue(50000);
		numberElement25.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setGRANIT(itemPrice);
                mineUtil.getConfig().addProperty("Andesit", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement25);
		final NumberElement numberElement26 = new NumberElement("Kies", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getKIES());
		numberElement26.setMinValue(0);
		numberElement26.setMaxValue(50000);
		numberElement26.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setKIES(itemPrice);
                mineUtil.getConfig().addProperty("Kies", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement26);
		final NumberElement numberElement27 = new NumberElement("Myzel", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getMYZEL());
		numberElement27.setMinValue(0);
		numberElement27.setMaxValue(50000);
		numberElement27.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setMYZEL(itemPrice);
                mineUtil.getConfig().addProperty("Myzel", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement27);
		final NumberElement numberElement28 = new NumberElement("Podsol", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getPODSOL());
		numberElement28.setMinValue(0);
		numberElement28.setMaxValue(50000);
		numberElement28.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setPODSOL(itemPrice);
                mineUtil.getConfig().addProperty("Podsol", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement28);
		final NumberElement numberElement29 = new NumberElement("Ziegelstein", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getZIEGELSTEIN());
		numberElement29.setMinValue(0);
		numberElement29.setMaxValue(50000);
		numberElement29.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setZIEGELSTEIN(itemPrice);
                mineUtil.getConfig().addProperty("Ziegelstein", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement29);
        
        priceCategory.getSubSettings().add(new HeaderElement("Eis"));
		final NumberElement numberElement31 = new NumberElement("Eis", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getEIS());
		numberElement31.setMinValue(0);
		numberElement31.setMaxValue(50000);
		numberElement31.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setEIS(itemPrice);
                mineUtil.getConfig().addProperty("Eis", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement31);
		final NumberElement numberElement32 = new NumberElement("Packeis", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getPACKEIS());
		numberElement32.setMinValue(0);
		numberElement32.setMaxValue(50000);
		numberElement32.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setPACKEIS(itemPrice);
                mineUtil.getConfig().addProperty("Packeis", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement32);
		final NumberElement numberElement33 = new NumberElement("Schnee", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getSCHNEE());
		numberElement33.setMinValue(0);
		numberElement33.setMaxValue(50000);
		numberElement33.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setSCHNEE(itemPrice);
                mineUtil.getConfig().addProperty("Schnee", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement33);
        
        priceCategory.getSubSettings().add(new HeaderElement("Erze"));
		final NumberElement numberElement34 = new NumberElement("Kohleblock", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getKOHLEBLOCK());
		numberElement34.setMinValue(0);
		numberElement34.setMaxValue(50000);
		numberElement34.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setKOHLEBLOCK(itemPrice);
                mineUtil.getConfig().addProperty("Kohleblock", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement34);
		final NumberElement numberElement35 = new NumberElement("Eisenblock", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getEISENBLOCK());
		numberElement35.setMinValue(0);
		numberElement35.setMaxValue(50000);
		numberElement35.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setEISENBLOCK(itemPrice);
                mineUtil.getConfig().addProperty("Eisenblock", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement35);
		final NumberElement numberElement36 = new NumberElement("Lapisblock", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getLAPISBLOCK());
		numberElement36.setMinValue(0);
		numberElement36.setMaxValue(50000);
		numberElement36.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setLAPISBLOCK(itemPrice);
                mineUtil.getConfig().addProperty("Lapisblock", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement36);
		final NumberElement numberElement37 = new NumberElement("Redstoneblock", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getREDSTONEBLOCK());
		numberElement37.setMinValue(0);
		numberElement37.setMaxValue(50000);
		numberElement37.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setREDSTONEBLOCK(itemPrice);
                mineUtil.getConfig().addProperty("Redstoneblock", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement37);
		final NumberElement numberElement38 = new NumberElement("Goldblock", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getGOLDBLOCK());
		numberElement38.setMinValue(0);
		numberElement38.setMaxValue(50000);
		numberElement38.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setGOLDBLOCK(itemPrice);
                mineUtil.getConfig().addProperty("Goldblock", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement38);
		final NumberElement numberElement39 = new NumberElement("Diamantblock", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getDIAMANTBLOCK());
		numberElement39.setMinValue(0);
		numberElement39.setMaxValue(50000);
		numberElement39.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setDIAMANTBLOCK(itemPrice);
                mineUtil.getConfig().addProperty("Diamantblock", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement39);
		final NumberElement numberElement40 = new NumberElement("Smaragdblock", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getSMARAGDBLOCK());
		numberElement40.setMinValue(0);
		numberElement40.setMaxValue(50000);
		numberElement40.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setSMARAGDBLOCK(itemPrice);
                mineUtil.getConfig().addProperty("Smaragdblock", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement40);
        
        priceCategory.getSubSettings().add(new HeaderElement("Sonstiges"));
		final NumberElement numberElement41 = new NumberElement("Grasblock", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getGRASBLOCK());
		numberElement41.setMinValue(0);
		numberElement41.setMaxValue(50000);
		numberElement41.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setGRASBLOCK(itemPrice);
                mineUtil.getConfig().addProperty("Grasblock", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement41);
		final NumberElement numberElement42 = new NumberElement("Steinziegel", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getSTEINZIEGEL());
		numberElement42.setMinValue(0);
		numberElement42.setMaxValue(50000);
		numberElement42.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setSTEINZIEGEL(itemPrice);
                mineUtil.getConfig().addProperty("Steinziegel", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement42);
		final NumberElement numberElement43 = new NumberElement("Rissiger Steinziegel", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getRISSIGER_STEINZIEGEL());
		numberElement43.setMinValue(0);
		numberElement43.setMaxValue(50000);
		numberElement43.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setRISSIGER_STEINZIEGEL(itemPrice);
                mineUtil.getConfig().addProperty("RissigerSteinziegel", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement43);
		final NumberElement numberElement44 = new NumberElement("Bemooster Steinziegel", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getBEMOOSTER_STEINZIEGEL());
		numberElement44.setMinValue(0);
		numberElement44.setMaxValue(50000);
		numberElement44.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setBEMOOSTER_STEINZIEGEL(itemPrice);
                mineUtil.getConfig().addProperty("BemoosterSteinziegel", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement44);
		final NumberElement numberElement45 = new NumberElement("Weisse Wolle", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getWEISSE_WOLLE());
		numberElement45.setMinValue(0);
		numberElement45.setMaxValue(50000);
		numberElement45.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setWEISSE_WOLLE(itemPrice);
                mineUtil.getConfig().addProperty("WeisseWolle", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement45);
		final NumberElement numberElement46 = new NumberElement("Farbige Wolle", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getFARBIGE_WOLLE());
		numberElement46.setMinValue(0);
		numberElement46.setMaxValue(50000);
		numberElement46.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setFARBIGE_WOLLE(itemPrice);
                mineUtil.getConfig().addProperty("FarbigeWolle", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement46);
		final NumberElement numberElement47 = new NumberElement("Gebrannter Ton", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getGEBRANNTER_TON());
		numberElement47.setMinValue(0);
		numberElement47.setMaxValue(50000);
		numberElement47.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setGEBRANNTER_TON(itemPrice);
                mineUtil.getConfig().addProperty("GebrannterTon", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement47);
		final NumberElement numberElement48 = new NumberElement("Farbiger Ton", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getFARBIGER_TON());
		numberElement48.setMinValue(0);
		numberElement48.setMaxValue(50000);
		numberElement48.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setFARBIGER_TON(itemPrice);
                mineUtil.getConfig().addProperty("FarbigerTon", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement48);
		final NumberElement numberElement49 = new NumberElement("Glasblock", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getGLAS_BLOCK());
		numberElement49.setMinValue(0);
		numberElement49.setMaxValue(50000);
		numberElement49.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setGLAS_BLOCK(itemPrice);
                mineUtil.getConfig().addProperty("Glasblock", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement49);
		final NumberElement numberElement50 = new NumberElement("Farbiges Glas", new ControlElement.IconData("labymod/textures/misc/economy_cash.png"), (int) getFARBIGES_GLAS());
		numberElement50.setMinValue(0);
		numberElement50.setMaxValue(50000);
		numberElement50.addCallback(new Consumer<Integer>() {
            public void accept(final Integer itemPrice) {
                setFARBIGES_GLAS(itemPrice);
                mineUtil.getConfig().addProperty("FarbigesGlas", (Number) itemPrice);
                mineUtil.saveConfig();
            }
        });
        priceCategory.getSubSettings().add(numberElement50);
	}

}
