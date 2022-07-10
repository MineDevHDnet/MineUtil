package net.minedevhd.mineutil.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Iterator;

import javax.imageio.ImageIO;

import org.lwjgl.input.Keyboard;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.authlib.properties.Property;

import net.labymod.api.events.MessageSendEvent;
import net.labymod.core.LabyModCore;
import net.labymod.main.LabyMod;
import net.labymod.utils.ModColor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MovingObjectPosition;
import net.minedevhd.mineutil.MineUtil;

public class HeadDownloaderUtil {
	
	static final MineUtil mineUtil = MineUtil.getUtilCore();
	
	public static final SimpleDateFormat fileformat;
	public static final JsonParser jsonParser;
	
	public static final void register() {
        LabyMod.getInstance().getEventManager().register((MessageSendEvent) new MessageSendEvent() {
            public boolean onSend(final String msg) {
                if(msg.startsWith("/mmucp_hod")) {
                    try {
                        final String[] parts = msg.split(" ");
                        final String action = parts[1];
                        final String filename = parts[2]/* + " " + parts[3]*/;
                        final File file = new File(Minecraft.getMinecraft().mcDataDir, "MineUtil\\head_textures\\" + filename + ".png");
                        final String s = action;
                        
                        if(s.equalsIgnoreCase("show")) {
                        	if(!openInExplorer(file.getCanonicalPath(), true)) {
                                LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() 
                                		+ "§4Fehler! §cBitte kontaktiere §eMineDev_HD §cund sende ihm den Fehler + Log-Datei!");
                            }
                        }
                        else
                        	if(s.equalsIgnoreCase("open")) {
                        		if(!openInExplorer(file.getCanonicalPath(), false)) {
                                    LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() 
                                    		+ "§4Fehler! §cBitte kontaktiere §eMineDev_HD §cund sende ihm den Fehler + Log-Datei!");
                                }
                            }
                            else
                            	if(s.equalsIgnoreCase("delete")) {
                            		if(!openInExplorer(file.getCanonicalPath(), false)) {
                            			file.delete();
                                        LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() 
                                        		+ "§aDie Datei wurde gel\u00f6scht.");
                                    }
                                }
                    } catch (Exception exception) {
                    	exception.printStackTrace();
                        LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() 
                        		+ "§4Fehler! §cBitte kontaktiere §eMineDev_HD §cund sende ihm den Fehler + Log-Datei!");
                    }
                    return true;
                }
                return false;
            }
        });
        LabyMod.getInstance().getLabyModAPI().registerForgeListener((Object) mineUtil);
    }
    
    public static final String buildClickable(final String display, final String hover, final String cmd) {
        return "{\"text\":\"" + display + "\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"" + cmd + "\"},\"hoverEvent\":{\"action\":\"show_text\",\"contents\":[{\"text\":\"" + hover + "\"}]}}";
    }
    
    private static boolean openInExplorer(final String path, final boolean select) {
        try {
            final String cmd = "explorer.exe " + (select ? "/select," : "") + "\"" + path + "\"";
            Runtime.getRuntime().exec(cmd);
            return true;
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
            return false;
        }
    }
    
    public static final TileEntity getTileEntityLooking() {
        try {
            final MovingObjectPosition movingObjectPosition = LabyModCore.getMinecraft().getPlayer().rayTrace(2000.0, 1.0f);
            if(movingObjectPosition == null) {
                return null;
            }
            final BlockPos blockPos = movingObjectPosition.getBlockPos();
            if(blockPos == null) {
                return null;
            }
            return LabyModCore.getMinecraft().getWorld().getTileEntity(blockPos);
        } catch (Exception exception) {
        	exception.printStackTrace();
            return null;
        }
    }
    
    public static final String getValueHovering() {
        try {
            final GuiContainer current = (GuiContainer) Minecraft.getMinecraft().currentScreen;
            final ItemStack item = current.getSlotUnderMouse().inventory/*field_75224_c*/.getStackInSlot(current.getSlotUnderMouse().getSlotIndex());
            final NBTTagCompound nbt = item.writeToNBT(new NBTTagCompound());
            try {
                return nbt.getCompoundTag("tag").getCompoundTag("SkullOwner").getCompoundTag("Properties").getTagList("textures", 10).getCompoundTagAt(0).getString("Value");
            } catch (Exception exception) {
                return "notex";
            }
        }
        catch (Exception exception) {
            return "null";
        }
    }
    
    public static final String getValueLooking() {
        final TileEntity tileEntity = getTileEntityLooking();
        if(!(tileEntity instanceof TileEntitySkull)) {
            return "null";
        }
        final TileEntitySkull tileEntitySkull = (TileEntitySkull) tileEntity;
        if(tileEntitySkull.getPlayerProfile() != null) {
            final Iterator<Property> propertyIterator = tileEntitySkull.getPlayerProfile().getProperties().get((String) "textures").iterator();
            if(propertyIterator.hasNext()) {
                return propertyIterator.next().getValue();
            }
        }
        return "notex";
    }
    
    public static final void onKeyPress() {
//		final int key = MineUtil.getMineUtil().getConfig().has("downloaderbutton") ? MineUtil.getMineUtil().getConfig().get("downloaderbutton").getAsInt() : 83;
    	if(Keyboard.isKeyDown(mineUtil.getSettings().getHeadDownloadKey()) != mineUtil.isGuiKeyPressed) {
            if(!(mineUtil.isGuiKeyPressed = Keyboard.isKeyDown(mineUtil.getSettings().getHeadDownloadKey()))) {
                return;
            }
            String value = HeadDownloaderUtil.getValueHovering();
            if(value.equals("null")) {
                value = HeadDownloaderUtil.getValueLooking();
            }
            final String s = value;
            if(s.equalsIgnoreCase("null")) {
            	LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() 
            			+ ModColor.cl('c') + "Bitte schaue auf einen Kopf!");
            	return;
            }
            else
            	if(s.equalsIgnoreCase("notex")) {
            		LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() 
            				+ ModColor.cl('c') + "Dieser Kopf hat keine Textur.");
                	return;
                }
            	else {
            		 try {
                         final JsonElement texElem = HeadDownloaderUtil.jsonParser.parse(new String(Base64.getDecoder().decode(value)));
                         if(!(texElem instanceof JsonObject)) {
                             LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() 
                            		 + ModColor.cl('c') + "Dieser Kopf hat keine Textur.");
                             return;
                         }
                         final JsonObject texJson = (JsonObject) texElem;
                         final String texURL = texJson.get("textures").getAsJsonObject().get("SKIN").getAsJsonObject().get("url").getAsString();
                         final BufferedImage texture = ImageIO.read(new URL(texURL));
                         final String filename = "mu_" + HeadDownloaderUtil.fileformat.format(new Date()).replace(" ", "_");
                         ImageIO.write(texture, "PNG", new File(Minecraft.getMinecraft().mcDataDir, "MineUtil\\head_textures\\" + filename + ".png"));
                         LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() 
                        		 + "§7Die Kopftextur wurde unter " + ModColor.cl('a') + filename + ".png" + ModColor.cl('7') + " gespeichert.");
                         final String json = "[\"" + mineUtil.getSettings().getPrefix() + "\"," + HeadDownloaderUtil.buildClickable(ModColor.cl('a') + "[Anzeigen]", ModColor.cl('f') + "Zeigt die Datei im Dateiexplorer an", "/mmucp_hod show " + filename) + ",\" \"," + HeadDownloaderUtil.buildClickable(ModColor.cl('e') + "[\u00d6ffnen]", ModColor.cl('f') + "\u00d6ffnet die Datei im Standardprogramm", "/mmucp_hod open " + filename) + ",\" \"," + HeadDownloaderUtil.buildClickable(ModColor.cl('c') + "[L\u00f6schen]", ModColor.cl('f') + "L\u00f6scht die Datei", "/mmucp_hod delete " + filename) + "]";
                         Minecraft.getMinecraft().thePlayer.addChatMessage(IChatComponent.Serializer.jsonToComponent(json));
                     } catch (Exception exception) {
                    	 exception.printStackTrace();
                         LabyMod.getInstance().displayMessageInChat(mineUtil.getSettings().getPrefix() 
                         		+ "§4Fehler! §cBitte kontaktiere §eMineDev_HD §cund sende ihm den Fehler + Log-Datei!");
                         return;
                     }
            	}
        }
    }
    
    static {
        fileformat = new SimpleDateFormat("dd.MM.yyyy HH-mm-ss-SSS");
        jsonParser = new JsonParser();
    }

}
