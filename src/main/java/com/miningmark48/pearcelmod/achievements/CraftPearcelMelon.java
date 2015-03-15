package com.miningmark48.pearcelmod.achievements;

import com.miningmark48.pearcelmod.init.ModItems;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class CraftPearcelMelon {

    @SubscribeEvent
    public void onCraftSugarCookie(PlayerEvent.ItemCraftedEvent e) {
        if (e.crafting.getItem().equals(ModItems.pearcelMelon)) {
            e.player.addStat(Achievements.achievementPearcelMelon, 1);

        }
    }

}
