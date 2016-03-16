package com.miningmark48.pearcelmod.event;

import com.miningmark48.pearcelmod.achievements.Achievements;
import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import com.miningmark48.pearcelmod.init.ModItems;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.event.entity.item.ItemEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import sun.security.krb5.Config;

public class EventFlight {

    @SubscribeEvent
    public void tickPlayerEvent(LivingEvent.LivingUpdateEvent event) {
        if (!ConfigurationHandler.flightItemDisable) {
            //TODO: Get working right!
        }
    }
}

/*
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
 */