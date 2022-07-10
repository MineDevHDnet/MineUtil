package net.minedevhd.mineutil.utils.render;
import net.labymod.settings.elements.*;
import net.labymod.utils.ModColor;
import net.labymod.main.*;
import java.util.*;

public class TextElement extends SettingsElement {
	
    private final int FONT_HEIGHT;
    private List<String> rows;
    private String textAlignment;
    
    public TextElement(final String text, final String textAlignment) {
        super(text, (String)null);
        this.FONT_HEIGHT = LabyMod.getInstance().getDrawUtils().getFontRenderer().FONT_HEIGHT;
        this.rows = new ArrayList<String>();
        for (final String row : text.split("\n")) {
            this.rows.addAll(LabyMod.getInstance().getDrawUtils().listFormattedStringToWidth(row, 200));
        }
        this.textAlignment = textAlignment;
    }
    
    public TextElement(final String text) {
        this(text, "left");
    }
    
    public void init() {}
    
    public void draw(final int x, final int y, final int maxX, final int maxY, final int mouseX, final int mouseY) {
        super.draw(x, y, maxX, maxY, mouseX, mouseY);
        final int absoluteY = y + 7;
        for (int i = 0; i < this.rows.size(); ++i) {
            final String element = this.rows.get(i);
            final String colorCodes = (i != 0) ? this.getLastColors(this.rows.get(i - 1)) : "";
            final int textWidth = LabyMod.getInstance().getDrawUtils().getFontRenderer().getStringWidth(element);
            final String textAlignment = this.textAlignment;
            int xOffset = 0;
            
            if(textAlignment.equals("center")) {
            	xOffset = 100 - textWidth / 2;
            }
            else
            	if(textAlignment.equals("right")) {
            		 xOffset = 200 - textWidth;
            	}
            	else {
            		xOffset = 0;
            	}
            LabyMod.getInstance().getDrawUtils().drawString(colorCodes + element, (double)(x + xOffset), (double)(absoluteY + i * this.FONT_HEIGHT));
        }
    }
    
    public int getEntryHeight() {
        return 22 + (this.rows.size() - 1) * this.FONT_HEIGHT;
    }
    
    public void drawDescription(final int x, final int y, final int screenWidth) {}
    
    public void mouseClicked(final int mouseX, final int mouseY, final int mouseButton) {}
    
    public void keyTyped(final char typedChar, final int keyCode) {}
    
    public void mouseRelease(final int mouseX, final int mouseY, final int mouseButton) {}
    
    public void mouseClickMove(final int mouseX, final int mouseY, final int mouseButton) {}
    
    public void unfocus(final int mouseX, final int mouseY, final int mouseButton) {}
    
    public void setText(final String text) {
        super.setDescriptionText(text);
        this.rows.clear();
        for (final String row : text.split("\n")) {
            this.rows.addAll(LabyMod.getInstance().getDrawUtils().listFormattedStringToWidth(row, 200));
        }
    }
    
    public void setTextAlignment(final String textAlignment) {
        this.textAlignment = textAlignment;
    }
    
    private String getLastColors(final String input) {
        String result = "";
        final int length = input.length();
        for (int index = length - 1; index > -1; --index) {
            final char section = input.charAt(index);
            if (index < length - 1) {
                final char c = input.charAt(index + 1);
                if ("0123456789abcdef".indexOf(c) != -1) {
                    result = c + result;
                    break;
                }
                if ("klmno".indexOf(c) != -1) {
                    result = c + result;
                }
            }
        }
        return result;
    }
}
