package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.init.ModBlocks;
import net.minecraft.item.ItemBucket;
import net.minecraft.world.World;

public class ItemPearcelJuice extends ItemBucket {

    public ItemPearcelJuice() {
        super(ModBlocks.pearcelFluid);
    }

    @Override
    public boolean tryPlaceContainedLiquid(World world, int x, int y, int z){

        if (!world.isAirBlock(x, y, z)){
            return false;
        }else{
            world.setBlock(x, y, z, ModBlocks.pearcelFluid, 0, 3);
            return true;
        }

    }

}
