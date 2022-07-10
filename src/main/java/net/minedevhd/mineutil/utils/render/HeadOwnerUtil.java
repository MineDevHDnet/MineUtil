package net.minedevhd.mineutil.utils.render;

import java.util.Iterator;
import java.util.UUID;

import org.lwjgl.input.Keyboard;

import com.mojang.authlib.properties.Property;

import net.labymod.core.LabyModCore;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minedevhd.mineutil.MineUtil;

public class HeadOwnerUtil {
	
    public static Skull getSkullLooking() {
        final TileEntity tileEntity = getTileEntityLooking();
        return new Skull(tileEntity);
    }
    
    private static TileEntity getTileEntityLooking() {
        try {
            final MovingObjectPosition movingObjectPosition = LabyModCore.getMinecraft().getPlayer().rayTrace((double) 10/*search distance*/, 1.0f);
            if(movingObjectPosition == null) { return null; }
            
            final BlockPos blockPos = movingObjectPosition.getBlockPos();
            if(blockPos == null) { return null; }
            
            return LabyModCore.getMinecraft().getWorld().getTileEntity(blockPos);
        } catch (Exception exception) { return null; }
    }
    
    public static class Skull {
        private int type;
        private String username;
        private UUID uuid;
        private String value;
        
        public Skull(final TileEntity tileEntity) {
            this.type = -1;
            this.username = null;
            this.uuid = null;
            this.value = null;
            if(!(tileEntity instanceof TileEntitySkull)) {
                return;
            }
            final TileEntitySkull tileEntitySkull = (TileEntitySkull) tileEntity;
            this.type = tileEntitySkull.getBlockMetadata();
            if(tileEntitySkull.getPlayerProfile() != null) {
                this.username = tileEntitySkull.getPlayerProfile().getName();
                this.uuid = tileEntitySkull.getPlayerProfile().getId();
                final Iterator<Property> propertyIterator = tileEntitySkull.getPlayerProfile().getProperties().get((String) "textures").iterator();
                while(propertyIterator.hasNext()) {
                    this.value = propertyIterator.next().getValue();
                }
            }
        }
        
        private String getSkullTypeName() {
            switch(this.type) {
                case 0: {
                    return "skeleton skull";
                }
                case 1: {
                    return "wither skeleton skull";
                }
                case 2: {
                    return "zombie head";
                }
                case 3: {
                    return "player head";
                }
                case 4: {
                    return "creeper head";
                }
                case 5: {
                    return "dragon head";
                }
                default: {
                    return "unknown skull type: " + this.type;
                }
            }
        }
        
        public String getDisplay() {
            if(this.username != null) {
                return this.username;
            }
            if(this.value == null) {
                return this.getSkullTypeName();
            }
            if(MineUtil.getUtilCore().getSettings().getModHeadOwnerKey() != -1) {
//                return "unknown head (created by texture value, press " + Keyboard.getKeyName(MineUtil.getMineUtil().getSettings().getModHeadOwnerKey()) + " to copy skull data)";
                return "unknown head (created by texture value)";
            }
            return "unknown head (created by texture value)";
        }
        
        public String getCopy() {
            final String uuid = (this.uuid == null) ? "unknown" : this.uuid.toString();
            final String username = (this.username == null) ? "unknown" : this.username;
            final String value = (this.value == null) ? "unknown" : this.value;
            final String type = this.getSkullTypeName();
            final StringBuilder resultBuilder = new StringBuilder();
            resultBuilder.append("skull type: " + type + " (" + this.type + ")");
            resultBuilder.append(", ");
            resultBuilder.append("username: " + username);
            resultBuilder.append(", ");
            resultBuilder.append("uuid: " + uuid);
            resultBuilder.append(", ");
            resultBuilder.append("texture value: " + value);
            return resultBuilder.toString();
        }
        
        public boolean isShown() {
            return this.type != -1;
        }
    }

}
