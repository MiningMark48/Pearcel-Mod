package com.miningmark48.pearcelmod.achievements;

import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.utility.LogHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

/**
 * Created by MarkA on 2/6/2015.
 */
public class CraftSugarCookie {

    @SubscribeEvent
    public void onCraftSugarCookie(PlayerEvent.ItemCraftedEvent e) {
        if (e.crafting.getItem().equals(ModItems.sugarCookie)) {
            e.player.addStat(Achievements.achievementSugarCookie, 1);

        }
    }

}
