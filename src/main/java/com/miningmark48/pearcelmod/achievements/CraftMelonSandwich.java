package com.miningmark48.pearcelmod.achievements;

import com.miningmark48.pearcelmod.init.ModItems;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class CraftMelonSandwich {

    @SubscribeEvent
    public void onCraftMelonSandwich(PlayerEvent.ItemCraftedEvent e) {
        if (e.crafting.getItem().equals(ModItems.melonSandwich)) {
            e.player.addStat(Achievements.achievementMelonSandwich, 1);

        }
    }

}
