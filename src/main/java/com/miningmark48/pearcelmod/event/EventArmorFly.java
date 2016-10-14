package com.miningmark48.pearcelmod.event;

import com.miningmark48.pearcelmod.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class EventArmorFly {

    ItemStack helmet;
    ItemStack chestplate;
    ItemStack leggings;
    ItemStack boots;

    Item flyHelmet = ModItems.rif_pearcel_helmet;
    Item flyChestplate = ModItems.rif_pearcel_chestplate;
    Item flyLeggings = ModItems.rif_pearcel_leggings;
    Item flyBoots = ModItems.rif_pearcel_boots;

    //TODO: Add config setting to disable flight
    //TODO: PROPER FIX (NOT JUST DISABLE)

//    @SubscribeEvent
//    public void armorTick(TickEvent.PlayerTickEvent e){
//        EntityPlayer player = e.player;
//
//        if (!player.worldObj.isRemote) {
//            if (!player.isCreative()) {
//                if (player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(0) != null) {
//                    helmet = player.inventory.armorItemInSlot(3);
//                    chestplate = player.inventory.armorItemInSlot(2);
//                    leggings = player.inventory.armorItemInSlot(1);
//                    boots = player.inventory.armorItemInSlot(0);
//
//                    if (helmet.getItem() == flyHelmet && chestplate.getItem() == flyChestplate && leggings.getItem() == flyLeggings && boots.getItem() == flyBoots) {
//                        player.capabilities.allowFlying = true;
//                        player.fallDistance = 0.0f;
//                    } else {
//                        player.capabilities.allowFlying = false;
//                        player.capabilities.isFlying = false;
//                    }
//                } else {
//                    player.capabilities.allowFlying = false;
//                    player.capabilities.isFlying = false;
//                }
//            }
//        }
//    }

}
