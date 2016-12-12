package com.miningmark48.pearcelmod.init;

import com.miningmark48.pearcelmod.reference.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModSoundEvents {

    public static SoundEvent BLOCK_SUMMONER_LAUGH;
    public static SoundEvent MOB_PEARCEL_BOSS_LAUGH;

    public static void registerSounds(){
        BLOCK_SUMMONER_LAUGH = registerSound("block.summoner.laugh");
        MOB_PEARCEL_BOSS_LAUGH = registerSound("mob.pearcel_boss.laugh");
    }

    private static SoundEvent registerSound(String soundName){
        final ResourceLocation soundID = new ResourceLocation(Reference.MOD_ID, soundName);
        return GameRegistry.register(new SoundEvent(soundID).setRegistryName(soundID));
    }

}
