package com.miningmark48.pearcelmod.achievements;

import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.utility.LogHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class CraftPearcelStaff {

    @SubscribeEvent
    public void onCraftPearcelStaff(PlayerEvent.ItemCraftedEvent e){
        if(e.crafting.getItem().equals(ModItems.pearcelStaff)){
            e.player.addStat(Achievements.achievementPearcelStaff, 1);

            LogHelper.info(e.player + " crafted a Pearcel Staff");
        }
    }

}
