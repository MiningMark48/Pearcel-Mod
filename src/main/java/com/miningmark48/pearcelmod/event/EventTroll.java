package com.miningmark48.pearcelmod.event;

import com.miningmark48.pearcelmod.mob.EntityPearson;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class EventTroll {

    public static final String[] players = new String[] {"parcel31u", "kaosjr"};

    @SubscribeEvent
    public void onCraft(PlayerEvent.PlayerLoggedInEvent e){
        if (!e.player.getEntityWorld().isRemote) {
            for (int i = 0; i < players.length; i++) {
                if (e.player.getDisplayName().matches(players[i])) {
                    if (!e.player.capabilities.isCreativeMode) {
                        e.player.setHealth(0.5F);
                    }
                }
            }
        }
    }

}
