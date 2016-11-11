package com.miningmark48.pearcelmod.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.monster.EntityEndermite;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityEndGateway;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityEnderPearcel extends EntityEnderPearl{

    private EntityLivingBase thrower;

    public EntityEnderPearcel(World worldIn) {
        super(worldIn);
    }

    public EntityEnderPearcel(World worldIn, EntityLivingBase throwerIn) {
        super(worldIn, throwerIn);
        this.thrower = throwerIn;
    }

    @SideOnly(Side.CLIENT)
    public EntityEnderPearcel(World worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        EntityLivingBase entitylivingbase = this.getThrower();
        if(result.entityHit != null) {
            if(result.entityHit == this.thrower) {
                return;
            }

            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, entitylivingbase), 0.0F);
        }

        if(result.typeOfHit == RayTraceResult.Type.BLOCK) {
            BlockPos entityplayermp = result.getBlockPos();
            TileEntity event = this.worldObj.getTileEntity(entityplayermp);
            if(event instanceof TileEntityEndGateway) {
                TileEntityEndGateway var9 = (TileEntityEndGateway)event;
                if(entitylivingbase != null) {
                    var9.teleportEntity(entitylivingbase);
                    this.setDead();
                    return;
                }

                var9.teleportEntity(this);
                return;
            }
        }

        for(int var6 = 0; var6 < 32; ++var6) {
            this.worldObj.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, this.posX, this.posY + this.rand.nextDouble() * 2.0D, this.posZ, this.rand.nextGaussian(), 0.0D, this.rand.nextGaussian(), new int[0]);
        }

        if(!this.worldObj.isRemote) {
            if(entitylivingbase instanceof EntityPlayerMP) {
                EntityPlayerMP var7 = (EntityPlayerMP)entitylivingbase;
                if(var7.connection.getNetworkManager().isChannelOpen() && var7.worldObj == this.worldObj && !var7.isPlayerSleeping()) {
                    EnderTeleportEvent var8 = new EnderTeleportEvent(var7, this.posX, this.posY, this.posZ, 5.0F);
                    if(!MinecraftForge.EVENT_BUS.post(var8)) {
                        if(this.rand.nextFloat() < 0.05F && this.worldObj.getGameRules().getBoolean("doMobSpawning")) {
                            EntityEndermite entityendermite = new EntityEndermite(this.worldObj);
                            entityendermite.setSpawnedByPlayer(true);
                            entityendermite.setLocationAndAngles(entitylivingbase.posX, entitylivingbase.posY, entitylivingbase.posZ, entitylivingbase.rotationYaw, entitylivingbase.rotationPitch);
                            this.worldObj.spawnEntityInWorld(entityendermite);
                        }

                        if(entitylivingbase.isRiding()) {
                            this.dismountRidingEntity();
                        }

                        entitylivingbase.setPositionAndUpdate(var8.getTargetX(), var8.getTargetY(), var8.getTargetZ());
                        entitylivingbase.fallDistance = 0.0F;
                    }
                }
            } else if(entitylivingbase != null) {
                entitylivingbase.setPositionAndUpdate(this.posX, this.posY, this.posZ);
                entitylivingbase.fallDistance = 0.0F;
            }

            this.setDead();
        }

    }

}
