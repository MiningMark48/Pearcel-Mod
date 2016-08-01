package com.miningmark48.pearcelmod.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

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

            if(state.getBlockHardness(worldIn, pos) >= 50.0D){ //TODO: Make Config Setting
                state.getBlock().dropBlockAsItem(worldIn, pos, state, 10); //TODO: Make Config Setting
            }

        }

        return true;
    }
}
