package com.miningmark48.pearcelmod.event;

import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.init.ModItems;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.FillBucketEvent;

public class EventFillBucket {

    @SubscribeEvent
    public void tryToFillBucket(FillBucketEvent event){
        if (event.current.getItem() != Items.bucket){
            return;
        }

        ItemStack bucketFilled = getLiquid(event.world, event.target);

        if (bucketFilled == null){
            return;
        }

        event.world.setBlockToAir(event.target.blockX, event.target.blockY, event.target.blockZ);
        event.result = bucketFilled;
        event.setResult(Event.Result.ALLOW);
    }

    private ItemStack getLiquid(World world, MovingObjectPosition pos){
        Block block = world.getBlock(pos.blockX, pos.blockY, pos.blockZ);
        if (block == ModBlocks.pearcelFluid){
            return new ItemStack(ModItems.pearcelJuice);
        }

        return null;
    }

}
