package com.miningmark48.pearcelmod.entity;

import com.miningmark48.pearcelmod.item.ItemThrowPearcel;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

public class EntityThrowPearcel extends EntityThrowable implements IEntityAdditionalSpawnData{

    public ItemThrowPearcel.TYPE type;
    private BlockPos originPos;

    public EntityThrowPearcel(World worldIn) {
        super(worldIn);
    }

    public EntityThrowPearcel(World worldIn, double x, double y, double z){
        super(worldIn, x, y, z);
    }

    public EntityThrowPearcel(World worldIn, EntityLivingBase throwerIn, ItemThrowPearcel.TYPE type){
        super(worldIn, throwerIn);
        this.type = type;
        originPos = throwerIn.getPosition();
    }

    @Override
    public void onEntityUpdate() {
        if (!worldObj.isRemote){
            worldObj.spawnParticle(EnumParticleTypes.CLOUD, getPosition().getX() + 0.5, getPosition().getY() + 0.5, getPosition().getZ() + 0.5, 0, 0.0D, 0.0D);
        }
    }

    @Override
    protected void onImpact(@Nonnull RayTraceResult result) {
        if (type != null){
            switch (type){
                case EXPLOSIVE:
                    doExplosion(6F);
                    break;
                case ENTITY_TP:
                    doTP(result);
                    break;
                default:
                    break;
            }
        }

        if (!this.getEntityWorld().isRemote){
            this.setDead();
        }
    }

    private void doExplosion(float strength){
        if (!getEntityWorld().isRemote){
            worldObj.createExplosion(null, posX, posY, posZ, strength, true);
        }
    }

    private void doTP(RayTraceResult result) {
        if(!getEntityWorld().isRemote) {
            if(result.entityHit != null) {
                result.entityHit.setPosition((double) originPos.getX(), (double) originPos.getY(), (double) originPos.getZ());
            }
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        ensureType();
        compound.setInteger("type", type.ordinal());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        type = ItemThrowPearcel.TYPE.values()[compound.getInteger("type")];
        ensureType();
    }

    @Override
    public void writeSpawnData(ByteBuf buffer) {
        ensureType();
        buffer.writeInt(type.ordinal());
    }

    @Override
    public void readSpawnData(ByteBuf additionalData) {
        type = ItemThrowPearcel.TYPE.values()[additionalData.readInt()];
        ensureType();
    }

    private void ensureType(){
        if (type == null){
            type = ItemThrowPearcel.TYPE.EXPLOSIVE;
        }
    }
}
