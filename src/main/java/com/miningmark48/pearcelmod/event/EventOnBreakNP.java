package com.miningmark48.pearcelmod.event;

import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.item.ItemNullificationPearcel;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


public class EventOnBreakNP {

    @SubscribeEvent
    public void onBreak(BlockEvent.HarvestDropsEvent e) {

        if (e.getHarvester() instanceof EntityPlayer) {

            Block block = e.getState().getBlock();
            EntityPlayer player = e.getHarvester();

            if (!player.isCreative()) {

                if (player.inventory.hasItemStack(new ItemStack(ModItems.nullification_pearcel))) {
                    ItemStack item = null;
                    for (int i = 0; i <= 8; i++) {
                        if (player.inventory.getStackInSlot(i) != null) {
                            if (player.inventory.getStackInSlot(i).getItem() instanceof ItemNullificationPearcel) {
                                item = player.inventory.getStackInSlot(i);
                            }
                        }
                    }

                    if (item != null) {
                        if (item.hasTagCompound()) {
                            if (block.toString().equalsIgnoreCase(item.getTagCompound().getString("nullBlock"))) {
                                e.getDrops().clear();
                            }
                        }
                    }
                }

            }
        }
    }

}
