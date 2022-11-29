package net.minedevhd.mineutil.modules.mods;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Cylinder;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemEgg;
import net.minecraft.item.ItemEnderPearl;
import net.minecraft.item.ItemFishingRod;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemSnowball;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minedevhd.mineutil.MineUtil;
import net.minedevhd.mineutil.settings.UtilCore;
import net.minedevhd.mineutil.utils.tech.Reflection;

public class TrajectoriesMod implements UtilCore {

    private enum TrajectoriesMode {

        DISABLED("Aus"), TRAIL("Trail"), DOT("Punkt");

        private final String name;

        TrajectoriesMode(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }

    /**
     *
     * Copyright (C) LiquidBounce 2020, GNU General Public License v3.0
     * See https://github.com/CCBlueX/LiquidBounce/blob/9c546f0598843e315f26f35c6e0c31d211f55276/shared/main/java/net/ccbluex/liquidbounce/features/module/modules/render/Projectiles.kt
     *
     * converted to Java, added mode checks, removed colorMode
     *
     */
    @SubscribeEvent
    public void onRender(RenderWorldLastEvent event) {
        if(mineUtil.getSettings().isModEnabled() && mineUtil.getSettings().isModTrajectories()) {
        	final EntityPlayerSP player = mineUtil.getMinecraft().thePlayer;
            if(player == null) return;
            
            if(player.getHeldItem() != null) {
                ItemStack heldItem = player.getHeldItem();
                if(heldItem == null)
                    return;

                Item item = heldItem.getItem();
                RenderManager renderManager = mineUtil.getMinecraft().getRenderManager();
                boolean isBow = false;
                float motionFactor = 1.5F;
                float motionSlowdown = 0.99F;
                float gravity, size, power;
                if(item instanceof ItemBow) {
                    if(!player.isUsingItem())
                        return;

                    isBow = true;
                    gravity = 0.05F;
                    size = 0.3F;
                    int duration = player.getItemInUseDuration();

                    power = (float) duration / 20.0F;
                    power = (power * power + power * 2.0F) / 3.0F;

                    if(power < 0.1F)
                        return;

                    motionFactor = Math.min(power, 1.0F) * 3.0F;
                } else if(item instanceof ItemFishingRod) {
                    gravity = 0.04F;
                    size = 0.25F;
                    motionSlowdown = 0.92F;
                } else if(item instanceof ItemPotion && ItemPotion.isSplash(heldItem.getItemDamage())) {
                    gravity = 0.05F;
                    size = 0.25F;
                    motionFactor = 0.5F;
                } else if(item instanceof ItemSnowball || item instanceof ItemEnderPearl || item instanceof ItemEgg) {
                    gravity = 0.03F;
                    size = 0.25F;
                } else
                    return;

                float pitch;
                double posX, posY, posZ;
                double motionX;
                byte pitchOffset;
                power = Minecraft.getMinecraft().thePlayer.rotationYaw;
                pitch = Minecraft.getMinecraft().thePlayer.rotationPitch;
                posX = (double) Reflection.get(renderManager, "renderPosX", "field_78725_b", "o") - (double) (MathHelper.cos(power / 180.0F * (float) Math.PI) * 0.16F);
                posY = (double) Reflection.get(renderManager, "renderPosY", "field_78726_c", "p") + (double) Minecraft.getMinecraft().thePlayer.getEyeHeight() - 0.10000000149011612D;
                posZ = (double) Reflection.get(renderManager, "renderPosZ", "field_78723_d", "q") - (double) (MathHelper.sin(power / 180.0F * (float) Math.PI) * 0.16F);
                motionX = (double) (-MathHelper.sin(power / 180.0F * 3.1415927F) * MathHelper.cos(pitch / 180.0F * 3.1415927F)) * (isBow ? 1.0D : 0.4D);
                if(item instanceof ItemPotion && ItemPotion.isSplash(heldItem.getItemDamage()))
                    pitchOffset = -20;
                else
                    pitchOffset = 0;

                double motionY = (double) (-MathHelper.sin((pitch + (float) pitchOffset) / 180.0F * 3.1415927F)) * (isBow ? 1.0D : 0.4D);
                double motionZ = (double) (MathHelper.cos(power / 180.0F * 3.1415927F) * MathHelper.cos(pitch / 180.0F * 3.1415927F)) * (isBow ? 1.0D : 0.4D);
                float distance = MathHelper.sqrt_double(motionX * motionX + motionY * motionY + motionZ * motionZ);
                motionX /= distance;
                motionY /= distance;
                motionZ /= distance;
                motionX *= motionFactor;
                motionY *= motionFactor;
                motionZ *= motionFactor;
                MovingObjectPosition landingPosition = null;
                boolean hasLanded = false;
                boolean hitEntity = false;
                WorldRenderer worldRenderer = Tessellator.getInstance().getWorldRenderer();

                GL11.glDepthMask(false);
                GL11.glEnable(3042);
                GL11.glEnable(2848);
                GL11.glDisable(2929);
                GL11.glDisable(3008);
                GL11.glDisable(3553);
                GL11.glBlendFunc(770, 771);
                GL11.glHint(3154, 4354);
                GL11.glColor4f(0, 160f / 255f, 1, 1); // i think is light blue
                GL11.glLineWidth(2.0F);
                worldRenderer.begin(3, DefaultVertexFormats.POSITION);

                while (!hasLanded && posY > 0.0D) {
                    Vec3 posBefore = new Vec3(posX, posY, posZ);
                    Vec3 posAfter = new Vec3(posX + motionX, posY + motionY, posZ + motionZ);
                    landingPosition = Minecraft.getMinecraft().theWorld.rayTraceBlocks(posBefore, posAfter, false, true, false);
                    posBefore = new Vec3(posX, posY, posZ);
                    posAfter = new Vec3(posX + motionX, posY + motionY, posZ + motionZ);
                    if(landingPosition != null) {
                        hasLanded = true;
                        posAfter = new Vec3(landingPosition.hitVec.xCoord, landingPosition.hitVec.yCoord, landingPosition.hitVec.zCoord);
                    }

                    AxisAlignedBB arrowBox = (new AxisAlignedBB(posX - (double) size, posY - (double) size, posZ - (double) size, posX + (double) size, posY + (double) size, posZ + (double) size)).addCoord(motionX, motionY, motionZ).expand(1.0D, 1.0D, 1.0D);
                    int chunkMinX = MathHelper.floor_double((arrowBox.minX - 2.0D) / 16.0D);
                    int chunkMaxX = MathHelper.floor_double((arrowBox.maxX + 2.0D) / 16.0D);
                    int chunkMinZ = MathHelper.floor_double((arrowBox.minZ - 2.0D) / 16.0D);
                    int chunkMaxZ = MathHelper.floor_double((arrowBox.maxZ + 2.0D) / 16.0D);
                    List<Entity> collidedEntities = new ArrayList<>();
                    int x = chunkMinX;
                    
                    if(chunkMinX <= chunkMaxX) {
                        while (true) {
                            int z = chunkMinZ;
                            if(chunkMinZ <= chunkMaxZ) {
                                while (true) {
                                    Minecraft.getMinecraft().theWorld.getChunkFromChunkCoords(x, z).getEntitiesWithinAABBForEntity(Minecraft.getMinecraft().thePlayer, arrowBox, collidedEntities, null);
                                    if(z == chunkMaxZ)
                                        break;

                                    ++z;
                                }
                            }

                            if(x == chunkMaxX)
                                break;

                            ++x;
                        }
                    }

                    for(Entity possibleEntity : collidedEntities) {
                        if(possibleEntity.canBeCollidedWith() && possibleEntity != Minecraft.getMinecraft().thePlayer) {
                            AxisAlignedBB possibleEntityBoundingBox = possibleEntity.getEntityBoundingBox().expand(size, size, size);
                            MovingObjectPosition movingObjectPosition = possibleEntityBoundingBox.calculateIntercept(posBefore, posAfter);
                            if(movingObjectPosition != null) {
                                hitEntity = true;
                                hasLanded = true;
                                landingPosition = movingObjectPosition;
                            }
                        }
                    }

                    posX += motionX;
                    posY += motionY;
                    posZ += motionZ;
                    IBlockState blockState = Minecraft.getMinecraft().theWorld.getBlockState(new BlockPos(posX, posY, posZ));
                    Block block = blockState.getBlock();
                    
                    if(block.getMaterial() == net.minecraft.block.material.Material.water) {
                        motionX *= 0.6D;
                        motionY *= 0.6D;
                        motionZ *= 0.6D;
                    } else {
                        motionX *= motionSlowdown;
                        motionY *= motionSlowdown;
                        motionZ *= motionSlowdown;
                    }

                    motionY -= gravity;
                    worldRenderer.pos(posX - (double) Reflection.get(renderManager, "renderPosX", "field_78725_b", "o"), posY - (double) Reflection.get(renderManager, "renderPosY", "field_78726_c", "p"), posZ - (double) Reflection.get(renderManager, "renderPosZ", "field_78723_d", "q")).endVertex();
                }

                Tessellator.getInstance().draw();
                GL11.glPushMatrix();
                GL11.glTranslated(posX - (double) Reflection.get(renderManager, "renderPosX", "field_78725_b", "o"), posY - (double) Reflection.get(renderManager, "renderPosY", "field_78726_c", "p"),
                        posZ - (double) Reflection.get(renderManager, "renderPosZ", "field_78723_d", "q"));
                if(landingPosition != null) {
                    EnumFacing facing = landingPosition.sideHit;
                    switch (facing.getAxis().ordinal()) {
                        case 0:
                            GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
                        case 1:
                        default:
                            break;
                        case 2:
                            GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
                    }

                    if(hitEntity) GL11.glColor4f(1, 0, 0, 150f / 255f); //red
                }

                GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
                Cylinder cylinder = new Cylinder();
                cylinder.setDrawStyle(100011);
                cylinder.draw(0.2F, 0.0F, 0.0F, 60, 1);
                GL11.glPopMatrix();
                GL11.glDepthMask(true);
                GL11.glDisable(3042);
                GL11.glDisable(2848);
                GL11.glEnable(2929);
                GL11.glEnable(3008);
                GL11.glEnable(3553);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F); // i don't know witch color it is...
            }        	
        }
    }
}
