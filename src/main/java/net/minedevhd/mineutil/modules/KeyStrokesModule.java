package net.minedevhd.mineutil.modules;

import java.awt.Color;

import net.labymod.ingamegui.ModuleCategory;
import net.labymod.ingamegui.moduletypes.SimpleModule;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.ControlElement.IconData;
import net.labymod.utils.Material;
import net.labymod.utils.ModColor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.settings.GameSettings;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.settings.ModSettings;
import net.minedevhd.mineutil.settings.ModSettings.KeyStrokes;
import net.minedevhd.mineutil.utils.ModButton;
import net.minedevhd.mineutil.utils.RenderUtils;

public class KeyStrokesModule extends SimpleModule {
	
	private final MineUtil mineUtil = MineUtil.getUtilCore();
	private final Minecraft mc = mineUtil.getMCCore();
	
	private final ModSettings settings = mineUtil.getSettings();
	
	private final Integer blue = new Color(75, 63, 178).getRGB(), 
			  			  gray = new Color(61, 60, 76).getRGB(), 
			  			  dark_gray = new Color(40, 39, 49).getRGB(),
	  					  pressed = new Color(167, 158, 242).getRGB(),
	  					  unpressed = new Color(183, 182, 188).getRGB();
	
	public static boolean forward_pressed = false, 
						  left_pressed = false, 
						  right_pressed = false, 
						  back_pressed = false,
						  space_pressed = false,
						  lmb_pressed = false,
						  rmb_pressed = false;
	
	private final Integer vector = 65;
	
	@Override
	public String getDefaultValue() {
		return "KeyStrokes";
	}

	@Override
	public String getDisplayName() {
		return "KeyStrokes";
	}

	@Override
	public String getDisplayValue() {
		final int x = ((int) getLastX() - vector) + 12, 
				  y = (int) getLastY() - vector,
				  forward = (forward_pressed ? 1/*buffer*/ : 0),
				  left = (left_pressed ? 1/*buffer*/ : 0),
				  right = (right_pressed ? 1/*buffer*/ : 0),
				  back = (back_pressed ? 1/*buffer*/ : 0),
				  space = (space_pressed ? 1/*buffer*/ : 0),
				  lmb = (lmb_pressed ? 1/*buffer*/ : 0),
				  rmb = (rmb_pressed ? 1/*buffer*/ : 0);
		
	    /** BACKGROUND */
		/*Forward Button*/ RenderUtils.drawRoundedRect((x+75), (y+80), (x+100), (y+105), 25/*the radius*/, (forward_pressed ? dark_gray : gray));
		/*Left    Button*/ RenderUtils.drawRoundedRect((x+45), (y+110), (x+70), (y+135), 25/*the radius*/, (left_pressed ? dark_gray : gray));
		/*Right   Button*/ RenderUtils.drawRoundedRect((x+105), (y+110), (x+130), (y+135), 25/*the radius*/, (right_pressed ? dark_gray : gray));
		/*Back    Button*/ RenderUtils.drawRoundedRect((x+75), (y+110), (x+100), (y+135), 25/*the radius*/, (back_pressed ? dark_gray : gray));
		
		if(KeyStrokes.getEns().equalsIgnoreCase("WITH_SPACEBAR")) {
			/*Space   Button*/ RenderUtils.drawRoundedRect((x+45), (y+140), (x+130), (y+165), 25/*the radius*/, (space_pressed ? dark_gray : gray));
		}
		else
			if(KeyStrokes.getEns().equalsIgnoreCase("WITH_MOUSE_BUTTONS")) {
				/*LMB     Button*/ RenderUtils.drawRoundedRect((x+45), (y+140), (x+85), (y+165), 25/*the radius*/, (lmb_pressed ? dark_gray : gray));
				/*LMB     Button*/ RenderUtils.drawRoundedRect((x+90), (y+140), (x+130), (y+165), 25/*the radius*/, (rmb_pressed ? dark_gray : gray));
			}
			else
				if(KeyStrokes.getEns().equalsIgnoreCase("WITH_MOUSE_BUTTONS_AND_SPACEBAR")) {
					/*Space   Button*/ RenderUtils.drawRoundedRect((x+45), (y+140), (x+130), (y+165), 25/*the radius*/, (space_pressed ? dark_gray : gray));
					/*LMB     Button*/ RenderUtils.drawRoundedRect((x+45), (y+170), (x+85), (y+195), 25/*the radius*/, (lmb_pressed ? dark_gray : gray));
					/*LMB     Button*/ RenderUtils.drawRoundedRect((x+90), (y+170), (x+130), (y+195), 25/*the radius*/, (rmb_pressed ? dark_gray : gray));
				}
		
		/** FOREGROUND */
		/*Forward Button*/ RenderUtils.drawRoundedRect((x+75) - forward, (y+80) - forward, (x+100) - forward, (y+105) - forward, 25/*the radius*/, (forward_pressed ? blue : gray));
		/*Left    Button*/ RenderUtils.drawRoundedRect((x+45) - left, (y+110) - left, (x+70) - left, (y+135) - left, 25/*the radius*/, (left_pressed ? blue : gray));
		/*Right   Button*/ RenderUtils.drawRoundedRect((x+105) - right, (y+110) - right, (x+130) - right, (y+135) - right, 25/*the radius*/, (right_pressed ? blue : gray));
		/*Back    Button*/ RenderUtils.drawRoundedRect((x+75) - back, (y+110) - back, (x+100) - back, (y+135) - back, 25/*the radius*/, (back_pressed ? blue : gray));
		
		if(KeyStrokes.getEns().equalsIgnoreCase("WITH_SPACEBAR")) {
		/*Space   Button*/ RenderUtils.drawRoundedRect((x+45) - space, (y+140) - space, (x+130) - space, (y+165) - space, 25/*the radius*/, (space_pressed ? blue : gray));
		}
		else
			if(KeyStrokes.getEns().equalsIgnoreCase("WITH_MOUSE_BUTTONS")) {
				/*Space   Button*/ RenderUtils.drawRoundedRect((x+45) - lmb, (y+140) - lmb, (x+85) - lmb, (y+165) - lmb, 25/*the radius*/, (lmb_pressed ? blue : gray));
				/*Space   Button*/ RenderUtils.drawRoundedRect((x+90) - rmb, (y+140) - rmb, (x+130) - rmb, (y+165) - rmb, 25/*the radius*/, (rmb_pressed ? blue : gray));
			}
			else
				if(KeyStrokes.getEns().equalsIgnoreCase("WITH_MOUSE_BUTTONS_AND_SPACEBAR")) {
					/*Space   Button*/ RenderUtils.drawRoundedRect((x+45) - space, (y+140) - space, (x+130) - space, (y+165) - space, 25/*the radius*/, (space_pressed ? blue : gray));
					/*Space   Button*/ RenderUtils.drawRoundedRect((x+45) - lmb, (y+170) - lmb, (x+85) - lmb, (y+195) - lmb, 25/*the radius*/, (lmb_pressed ? blue : gray));
					/*Space   Button*/ RenderUtils.drawRoundedRect((x+90) - rmb, (y+170) - rmb, (x+130) - rmb, (y+195) - rmb, 25/*the radius*/, (rmb_pressed ? blue : gray));
				}
		
		/** TEXT */
		/*Forward String*/ mc.fontRendererObj.drawStringWithShadow("W", (x+85) - forward, (y+88) - forward, (forward_pressed ? pressed : unpressed));
		/*Left    String*/ mc.fontRendererObj.drawStringWithShadow("A", (x+55) - left, (y+118) - left, (left_pressed ? pressed : unpressed));
		/*Right   String*/ mc.fontRendererObj.drawStringWithShadow("D", (x+115) - right, (y+118) - right, (right_pressed ? pressed : unpressed));
		/*Back    String*/ mc.fontRendererObj.drawStringWithShadow("S", (x+85) - back, (y+118) - back, (back_pressed ? pressed : unpressed));
		
		if(KeyStrokes.getEns().equalsIgnoreCase("WITH_SPACEBAR")) {
			/*Space   String*/ mc.fontRendererObj.drawStringWithShadow(ModColor.STRIKETHROUGH + "         ", (x+70) - space, (y+149) - space, (space_pressed ? pressed : unpressed));
		}
		else
			if(KeyStrokes.getEns().equalsIgnoreCase("WITH_MOUSE_BUTTONS")) {
				/*Back    String*/ mc.fontRendererObj.drawStringWithShadow("LMB", (x+57) - lmb, (y+149) - lmb, (lmb_pressed ? pressed : unpressed));
				/*Back    String*/ mc.fontRendererObj.drawStringWithShadow("RMB", (x+102) - rmb, (y+149) - rmb, (rmb_pressed ? pressed : unpressed));
			}
			else
				if(KeyStrokes.getEns().equalsIgnoreCase("WITH_MOUSE_BUTTONS_AND_SPACEBAR")) {
					/*Space   String*/ mc.fontRendererObj.drawStringWithShadow(ModColor.STRIKETHROUGH + "         ", (x+70) - space, (y+149) - space, (space_pressed ? pressed : unpressed));
					/*Back    String*/ mc.fontRendererObj.drawStringWithShadow("LMB", (x+57) - lmb, (y+178) - lmb, (lmb_pressed ? pressed : unpressed));
					/*Back    String*/ mc.fontRendererObj.drawStringWithShadow("RMB", (x+102) - rmb, (y+178) - rmb, (rmb_pressed ? pressed : unpressed));
				}
		return "";
	}

	@Override
	public String getDescription() {
		return "New KeyStrokes Mod";
	}

	@Override
	public IconData getIconData() {
		return new ControlElement.IconData(Material.STONE_BUTTON);
	}

	@Override
	public String getSettingName() {
		return "KeyStrokes";
	}

	@Override
	public int getSortingId() {
		return 0;
	}

	@Override
	public void loadSettings() {}
	
    public ModuleCategory getCategory() {
        return MineUtil.MINEUTIL_CATEGORY;
    }
    
    public static void canUse(final MineUtil mineUtil) {
    	final GameSettings gs = mineUtil.getMCCore().gameSettings;

    	forward_pressed = gs.keyBindForward.isKeyDown();
    	left_pressed = gs.keyBindLeft.isKeyDown();
        right_pressed = gs.keyBindRight.isKeyDown();
        back_pressed = gs.keyBindBack.isKeyDown();
        space_pressed = gs.keyBindJump.isKeyDown();
        lmb_pressed = gs.keyBindAttack.isKeyDown();
        rmb_pressed = gs.keyBindUseItem.isKeyDown();
    }

}
