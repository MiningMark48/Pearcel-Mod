package com.miningmark48.pearcelmod.block;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockPearcelBeaconBase extends BlockPearcelMod{

    @Override
    public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon) {
        return true;
    }
}
