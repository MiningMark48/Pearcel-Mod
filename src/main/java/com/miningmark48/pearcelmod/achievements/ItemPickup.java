package com.miningmark48.pearcelmod.achievements;

import com.miningmark48.pearcelmod.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class ItemPickup {

    @SubscribeEvent
    public void onItemPickup(PlayerEvent.ItemPickupEvent e){
        ItemStack stack = e.pickedUp.getEntityItem();
        EntityPlayer player = e.player;

        if(stack.isItemEqual(new ItemStack(ModItems.pearcel_item))){
            player.addStat(Achievements.achievement_get_pearcel);
        }

    }

}
