package com.miningmark48.pearcelmod.event;

import com.miningmark48.pearcelmod.achievements.Achievements;
import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import com.miningmark48.pearcelmod.init.ModItems;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.event.entity.item.ItemEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import sun.security.krb5.Config;

public class EventFlight {

    @SubscribeEvent
    public void tickPlayerEvent(TickEvent.PlayerTickEvent event) {
        if (!ConfigurationHandler.flightItemDisable) {
            if (event.player.inventory.hasItemStack(new ItemStack(ModItems.flightItem)) || event.player.capabilities.isCreativeMode){
                event.player.capabilities.allowFlying = true;
                if (event.player.capabilities.isFlying && !event.player.capabilities.isCreativeMode) {
                    if (ConfigurationHandler.useFlightItemParticle) {
                        double x = event.player.posX;
                        double y = event.player.posY;
                        double z = event.player.posZ;
                        event.player.getEntityWorld().spawnParticle("cloud", x, y - 1.5, z, 0, -0.05, 0);
                        event.player.getEntityWorld().spawnParticle("cloud", x + 0.25, y - 1.5, z, 0, -0.01, 0);
                        event.player.getEntityWorld().spawnParticle("cloud", x, y - 1.5, z + 0.25, 0, -0.01, 0);
                        event.player.getEntityWorld().spawnParticle("cloud", x - 0.25, y - 1.5, z, 0, -0.01, 0);
                        event.player.getEntityWorld().spawnParticle("cloud", x, y - 1.5, z - 0.25, 0, -0.01, 0);
                    }
                    if (ConfigurationHandler.flightItemExhaustion) {
                        event.player.addExhaustion(0.0075F);
                    }

                    event.player.addStat(Achievements.achievementFlight, 1);
                }
            }
            if (!event.player.capabilities.isCreativeMode){
                if (event.player.inventory.inventoryChanged && !event.player.inventory.hasItemStack(new ItemStack(ModItems.flightItem))) {
                    event.player.capabilities.allowFlying = false;
                }
            }

        }
    }
}