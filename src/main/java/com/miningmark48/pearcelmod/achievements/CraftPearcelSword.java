package com.miningmark48.pearcelmod.achievements;

import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.utility.LogHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;


public class CraftPearcelSword {

    @SubscribeEvent
    public void onCraftPearcelSword(PlayerEvent.ItemCraftedEvent e){
        if(e.crafting.getItem().equals(ModItems.pearcelSword)){
            e.player.addStat(Achievements.achievementPearcelSword, 1);

            LogHelper.info(e.player + " crafted a Pearcel Sword");
        }
    }

}