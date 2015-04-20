package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.init.ModFluids;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemBucketMilk;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
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
