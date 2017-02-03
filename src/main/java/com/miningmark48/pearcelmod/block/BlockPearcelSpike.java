package com.miningmark48.pearcelmod.block;

import com.miningmark48.pearcelmod.init.ModBlocks;
import com.mojang.authlib.GameProfile;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
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

    FakePlayer fakePlayer;

    public BlockPearcelSpike(){
        setResistance(2.5F);
        setHardness(1.5F);
        setTickRandomly(true);
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
            entityIn.attackEntityFrom(DamageSource.causePlayerDamage(fakePlayer), 2.5F);
        }

        super.onEntityWalk(worldIn, pos, entityIn);
    }

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
