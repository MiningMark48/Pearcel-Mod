package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class ItemReinforcedPearcelPickaxe extends ItemPickaxe {
    public ItemReinforcedPearcelPickaxe(ToolMaterial material) {
        super(material);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving)
    {
        if ((double)state.getBlockHardness(worldIn, pos) != 0.0D)
        {
            stack.damageItem(1, entityLiving);

            if(state.getBlockHardness(worldIn, pos) >= ConfigurationHandler.rifPPickBaseHardness){
                state.getBlock().dropBlockAsItem(worldIn, pos, state, 10);
                worldIn.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, pos.getX(), pos.getY() + 1, pos.getZ(), 0.0D, 0.0125D, 0.0D);
            }

        }

        return true;
    }
}
