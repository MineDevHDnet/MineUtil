package net.minedevhd.mineutil.utils;

import java.awt.Color;

import net.labymod.utils.ModColor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.settings.UtilCore;
import net.minedevhd.mineutil.utils.graf.RenderUtils;

public class ModButton extends GuiButton implements UtilCore {
	
    public ModButton(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText) {
        super(buttonId, x, y, widthIn, heightIn, buttonText);
    }

    public ModButton(int buttonId, int x, int y, String buttonText) {
        super(buttonId, x, y, buttonText);
    }

	int animatedHeight = 0;
	int buttonDesign = 0;
	
	//TODO: Make it editable via LM-Settings
	private Integer getBtnId() {
		return 2;
	}

    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY) {
        if(this.visible) {
        	FontRenderer fontrenderer = mc.fontRendererObj;
        	int j = 0;
        	
        	switch (this.getBtnId()) {
			case 0: {
				mc.getTextureManager().bindTexture(buttonTextures);
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
                int i = this.getHoverState(this.hovered);
                GlStateManager.enableBlend();
                GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
                GlStateManager.blendFunc(770, 771);
                Gui.drawRect(this.xPosition, this.yPosition, this.xPosition + this.width, this.yPosition + this.height, new Color(0, 0, 0, 110).getRGB());
                this.mouseDragged(mc, mouseX, mouseY);
                j = 14737632;

                if(!this.enabled) {
                    j = 10526880;
                }
                else if(this.hovered) {
                    j = 16777120;
                    Gui.drawRect(this.xPosition, this.yPosition, this.xPosition + this.width, this.yPosition + this.height, new Color(255, 255, 255, 85).getRGB());
                }
				break;
        	}
			case 1: {
				this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
            	
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                if(this.buttonDesign == 1) {
                	this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
                	
                	if(this.hovered) {
                		animatedHeight++;
                		if(animatedHeight > this.height) {
                			animatedHeight = height;
                		}
                	}
                	else {
                		animatedHeight--;
                		if(animatedHeight < 0) {
                			animatedHeight = 0;
                		}
                	}
                }
                
                int color = new Color(243, 245, 249, 75).getRGB();
                if(this.buttonDesign == 1) {
    	            this.drawRect(this.xPosition, this.yPosition, this.xPosition + this.width, this.yPosition + this.height, new Color(0, 0, 0, 110).getRGB());
    	            this.drawRect(this.xPosition, this.yPosition, this.xPosition + this.width, this.yPosition + this.animatedHeight, new Color(255, 255, 255, 85).getRGB());
                }
                this.mouseDragged(mc, mouseX, mouseY);
                j = 14737632;
                
                if(!this.enabled) {
                    j = 10526880;
                }
                else 
                	if(this.hovered) {
                		j = 16777120;
                		color = new Color(173, 175, 179, 75).getRGB();
                	}
                if(buttonDesign == 0) {
                	RenderUtils.drawRoundedRect(this.xPosition, this.yPosition, this.xPosition + this.width, this.yPosition + this.height, 20, color);
                }
				break;
			}
			case 2: {
				mc.getTextureManager().bindTexture(buttonTextures);
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
                int i = this.getHoverState(this.hovered);
                GlStateManager.enableBlend();
                GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
                GlStateManager.blendFunc(770, 771);
                Gui.drawRect(this.xPosition, this.yPosition, this.xPosition + this.width, this.yPosition + this.height, new Color(10, 35, 55, 200).getRGB());
                this.mouseDragged(mc, mouseX, mouseY);
                j = 14737632;

                if(!this.enabled) {
                    j = 10526880;
                }
                else if(this.hovered) {
                    j = 16777120;
                    Gui.drawRect(this.xPosition, this.yPosition, this.xPosition + this.width, this.yPosition + this.height, new Color(205, 205, 205, 80).getRGB());
                }
                Gui.drawRect(this.xPosition + this.width , this.yPosition + 19, this.xPosition, this.yPosition + 20, ModButton.toRainbow(18));
				break;
			}
			default:
				break;
			}
            this.drawCenteredString(fontrenderer, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, j);
        }
    }

//    public boolean isInside(int mouseX, int mouseY, double x, double y, double x2, double y2) {
//        return (mouseX > x && mouseX < x2) && (mouseY > y && mouseY < y2);
//    }
    
    public final static Integer toRainbow(final Integer delay) {
		double rainbowState = Math.ceil((System.currentTimeMillis() + delay) / 20.0);
		return Color.getHSBColor((float) ((rainbowState %= 360) / 360.0f), 0.5f, 1f).getRGB(); 
	}
    
    public static class API {
    	
    	private static final int buttonWidth = 110, buttonWidthSpace = 4, buttonHeight = 20, buttonHeightSpace = 2;
        
        public static Integer getButtonHeight() {
            return buttonHeight;
        }
        
        public static Integer getButtonWidth() {
            return buttonWidth;
        }
        
        public static Integer getButtonYPos(final Integer pos) {
            return (getButtonHeight() + buttonHeightSpace) * pos;
        }
        
        public static Integer getButtonYPos(final Integer pos, final boolean isLabel) {
            if (isLabel) {
                return getButtonYPos(pos) + buttonHeightSpace * 2;
            }
            return getButtonYPos(pos);
        }
        
        public static Integer getButtonXPos(final Integer pos, final int width) {
            switch (pos) {
                case 1: {
                    return width / 2 - (getButtonWidth() + buttonWidthSpace) * 2 + buttonWidthSpace / 2;
                }
                case 2: {
                    return width / 2 - getButtonWidth() - buttonWidthSpace / 2;
                }
                case 3: {
                    return width / 2 + buttonWidthSpace / 2;
                }
                case 4: {
                    return width / 2 + getButtonWidth() + buttonWidthSpace * 2 - buttonWidthSpace / 2;
                }
                default: {
                    return 0;
                }
            }
        }
        
        public static void a_617553_p(MineUtil mineUtil) {
        	if(!mineUtil.getCleanSelection().equals("") && mineUtil.getCraftSelection().equals("")) {
        		mineUtil.setCleanSelection("");
                mineUtil.getApi().displayMessageInChat(mineUtil.getSettings().getPrefix() 
                		+ "§7Module §eAutomatic Cleaning §7has been §cdeactivated§7.");
        	}
        	else
        		if(!mineUtil.getCraftSelection().equals("") && mineUtil.getCleanSelection().equals("")) {
            		mineUtil.setCraftSelection("");
                    mineUtil.getApi().displayMessageInChat(mineUtil.getSettings().getPrefix() 
                    		+ "§7Module §eAutomatic Crafting §7has been §cdeactivated§7.");
            	}
        		else
        			if(!mineUtil.getCleanSelection().equals("") && !mineUtil.getCraftSelection().equals("")) {
                		mineUtil.setCleanSelection("");
        				mineUtil.setCraftSelection("");
                        mineUtil.getApi().displayMessageInChat(mineUtil.getSettings().getPrefix() 
                        		+ "§7Module §eAutom. Crafting and Cleaning §7has been §cdeactivated§7.");
        			}
        }
    	
    }

}
