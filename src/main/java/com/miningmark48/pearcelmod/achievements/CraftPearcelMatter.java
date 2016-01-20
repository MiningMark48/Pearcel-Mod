package com.miningmark48.pearcelmod.achievements;

import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.utility.LogHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class CraftPearcelMatter {

    @SubscribeEvent
    public void onCraftPearcelMatter(PlayerEvent.ItemCraftedEvent e){
        if(e.crafting.getItem().equals(ModItems.pearcelMatter)){
            e.player.addStat(Achievements.achievementPearcelMatter, 1);
        }
    }

}
