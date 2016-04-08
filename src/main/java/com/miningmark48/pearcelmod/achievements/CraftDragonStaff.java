package com.miningmark48.pearcelmod.achievements;

import com.miningmark48.pearcelmod.init.ModItems;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class CraftDragonStaff {

    @SubscribeEvent
    public void onCraftStaff(PlayerEvent.ItemCraftedEvent e) {
        if (e.crafting.getItem().equals(ModItems.dragonInfusedStaff)) {
            e.player.addStat(Achievements.achievementDragonStaff, 1);
        }
    }

}
