package com.miningmark48.pearcelmod.block;

import com.miningmark48.pearcelmod.init.ModBlocks;
import com.mojang.authlib.GameProfile;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.util.FakePlayerFactory;

import java.util.UUID;

public class BlockPearcelSpike extends BlockPearcelMod{

    private FakePlayer fakePlayer;

    private float spike_damage;

    public BlockPearcelSpike(Float damage){
        setResistance(2.5F);
        setHardness(1.5F);
        setTickRandomly(true);
        spike_damage = damage;
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn)
    {
        if (entityIn instanceof EntityLivingBase){
            if (fakePlayer == null) {
                if (!worldIn.isRemote) {
                    fakePlayer = FakePlayerFactory.get((WorldServer) worldIn, new GameProfile(UUID.randomUUID(), ModBlocks.pearcel_spike.getLocalizedName()));
                }
            }

            if (!(entityIn instanceof EntityPlayer)) {
                ((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 20, 1));
                entityIn.attackEntityFrom(DamageSource.causePlayerDamage(fakePlayer), spike_damage);
            }

        }

        super.onEntityWalk(worldIn, pos, entityIn);

    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
        if (fakePlayer != null){
            fakePlayer.setDead();
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isFullCube(IBlockState state){
        return false;
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isOpaqueCube(IBlockState state){
        return false;
    }

    @Override
    public BlockRenderLayer getBlockLayer(){
        return BlockRenderLayer.CUTOUT;
    }

}
