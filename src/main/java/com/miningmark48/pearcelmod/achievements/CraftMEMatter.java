package com.miningmark48.pearcelmod.achievements;

import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.utility.LogHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class CraftMEMatter {

    @SubscribeEvent
    public void onCraftMEMatter(PlayerEvent.ItemCraftedEvent e){
        if(e.crafting.getItem().equals(ModItems.meMatter)){
            e.player.addStat(Achievements.achievementMEMatter, 1);

            LogHelper.info(e.player + " crafted ME^Matter");
        }
    }

}
