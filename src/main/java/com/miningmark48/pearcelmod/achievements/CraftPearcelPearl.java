package com.miningmark48.pearcelmod.achievements;

import com.miningmark48.pearcelmod.init.ModItems;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class CraftPearcelPearl {

    @SubscribeEvent
    public void onCraftPearcelPearl(PlayerEvent.ItemCraftedEvent e){
        if(e.crafting.getItem().equals(ModItems.pearcelPearl)){
            e.player.addStat(Achievements.achievementPearcelPearl, 1);
        }
    }

}
