package com.miningmark48.pearcelmod.achievements;

import com.miningmark48.pearcelmod.init.ModBlocks;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class CraftIVET {

    @SubscribeEvent
    public void onCraftIVET(PlayerEvent.ItemCraftedEvent e) {
        if (e.crafting.getItem().equals(ModBlocks.ivet)) {
            e.player.addStat(Achievements.achievementIVET, 1);
        }
    }

}
