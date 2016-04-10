package com.miningmark48.pearcelmod.event;

import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

public class EventLogInChat {

    @SubscribeEvent
    public void onJoin(PlayerEvent.PlayerLoggedInEvent e){
        if (!e.player.getEntityWorld().isRemote) {
            if (ConfigurationHandler.doChatLoginMessage) {
                e.player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GREEN + StatCollector.translateToLocal("chat.event.logIn.thanksUse")));
            }
        }
    }

}
