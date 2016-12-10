package com.miningmark48.pearcelmod.event;

import com.miningmark48.pearcelmod.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class EventOnCraftBlood {

    @SubscribeEvent
    public void onItemCraft(PlayerEvent.ItemCraftedEvent e) {
        ItemStack stack = e.crafting;
        EntityPlayer player = e.player;

        if (stack.isItemEqual(new ItemStack(ModItems.blood_drop))){
            player.attackEntityFrom(DamageSource.outOfWorld, 10.0F);
        }

    }
}
