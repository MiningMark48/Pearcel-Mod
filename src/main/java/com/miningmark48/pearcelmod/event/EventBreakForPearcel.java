package com.miningmark48.pearcelmod.event;

import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import com.miningmark48.pearcelmod.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

public class EventBreakForPearcel {

    @SubscribeEvent
    public void onBreak(BlockEvent.BreakEvent e){
        EntityPlayer player = e.getPlayer();
        World world = e.getWorld();
        BlockPos pos = e.getPos();
        Block block = world.getBlockState(pos).getBlock();

        if (!player.isCreative()) {
            if (block == Blocks.LEAVES || block == Blocks.TALLGRASS) {
                EntityItem entityItem = new EntityItem(world);
                entityItem.setEntityItemStack(new ItemStack(ModItems.pearcel_item));
                entityItem.setPosition(pos.getX(), pos.getY(), pos.getZ());

                Random rand = new Random();
                int r;

                if(player.getHeldItemMainhand() != null) {
                    if (player.getHeldItemMainhand().getItem() == ModItems.pearcel_crook) {
                        r = 1;
                    }else {
                        r = rand.nextInt(100 / ConfigurationHandler.pearcelDropChance) + 1;
                    }
                }else {
                    r = rand.nextInt(100 / ConfigurationHandler.pearcelDropChance) + 1;
                }

                if (r == 1){
                    world.spawnEntityInWorld(entityItem);
                }
            }
        }


    }

}
