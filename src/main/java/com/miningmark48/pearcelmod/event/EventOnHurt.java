package com.miningmark48.pearcelmod.event;

import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.utility.Translate;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventOnHurt {

    @SubscribeEvent
    public void onPlayerHurt(LivingHurtEvent e){

        if (e.getEntity() instanceof EntityPlayer){
            EntityPlayer player = (EntityPlayer) e.getEntity();

            if (!player.isCreative() && player.getHealth() - e.getAmount() <= 0) {
                if (player.inventory.hasItemStack(new ItemStack(ModItems.sacrificial_pearcel))) {
                    player.inventory.removeStackFromSlot(player.inventory.getSlotFor(new ItemStack(ModItems.sacrificial_pearcel)));

                    if (!player.getEntityWorld().isRemote){
                        player.sendMessage(new TextComponentString(TextFormatting.GOLD + Translate.toLocal("chat.event.onDie.1")));
                    }

                    player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 60, 0));

                    e.setCanceled(true);

                }
            }

        }

    }

}
