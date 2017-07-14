package com.miningmark48.pearcelmod.init;

import com.google.common.eventbus.Subscribe;
import com.miningmark48.pearcelmod.reference.Reference;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.LinkedList;
import java.util.List;

public class ModSoundEvents {

    private static List<SoundEvent> soundsToRegister = new LinkedList<>();

    public static SoundEvent BLOCK_SUMMONER_LAUGH;
    public static SoundEvent MOB_PEARCEL_BOSS_LAUGH;

    public static void registerSounds(){
        BLOCK_SUMMONER_LAUGH = createSound("block.summoner.laugh");
        MOB_PEARCEL_BOSS_LAUGH = createSound("mob.pearcel_boss.laugh");

        registerSound(BLOCK_SUMMONER_LAUGH);
        registerSound(MOB_PEARCEL_BOSS_LAUGH);
    }

    private static SoundEvent createSound(String soundName){
        final ResourceLocation soundID = new ResourceLocation(Reference.MOD_ID, soundName);
        return new SoundEvent(soundID).setRegistryName(soundID);
    }

    private static void registerSound(SoundEvent event){
        soundsToRegister.add(event);
    }

    @SubscribeEvent
    public void registerSoundEvent(RegistryEvent.Register<SoundEvent> event){
        soundsToRegister.forEach(event.getRegistry()::register);
    }

}
