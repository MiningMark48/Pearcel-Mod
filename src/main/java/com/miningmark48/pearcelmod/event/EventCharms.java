package com.miningmark48.pearcelmod.event;

import com.miningmark48.pearcelmod.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventCharms {

    @SubscribeEvent
    public void onPlayerHurt(LivingHurtEvent e){
        if (e.getEntity() instanceof EntityPlayer){
            EntityPlayer player = (EntityPlayer) e.getEntity();
            if (e.getSource() == DamageSource.fall){
                if (player.inventory.hasItemStack(new ItemStack(ModItems.charmed_pearcel))){
                    for (int i = 0; i <= player.inventory.getSizeInventory(); i++){
                        if (player.inventory.getStackInSlot(i) != null){
                            if (player.inventory.getStackInSlot(i).getItem() == ModItems.charmed_pearcel) {
                                if (player.inventory.getStackInSlot(i).hasTagCompound()) {
                                    if (player.inventory.getStackInSlot(i).getTagCompound().getString("type").equalsIgnoreCase("fall")) {
                                        e.setCanceled(true);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
