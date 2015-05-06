package com.miningmark48.pearcelmod.achievements;

import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.utility.LogHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class CraftPearcelCookie9 {

    @SubscribeEvent
    public void onCraftPearcelCookie9(PlayerEvent.ItemCraftedEvent e){
        if(e.crafting.getItem().equals(ModItems.pearcelCookie9)){
            e.player.addStat(Achievements.achievementPearcelCookie9, 1);

            LogHelper.info(e.player + " crafted a Pearcel Cookie (9)");
        }
    }

}
