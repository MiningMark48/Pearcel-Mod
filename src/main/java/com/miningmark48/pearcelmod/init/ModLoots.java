package com.miningmark48.pearcelmod.init;

import com.miningmark48.pearcelmod.entity.EntityPearcelBoss;
import net.minecraft.world.storage.loot.LootTableList;

public class ModLoots {

    public static void init(){
        LootTableList.register(EntityPearcelBoss.loot_tabel);
    }

}
