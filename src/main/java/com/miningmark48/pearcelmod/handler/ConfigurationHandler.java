package com.miningmark48.pearcelmod.handler;

import com.miningmark48.pearcelmod.reference.Reference;
import com.miningmark48.pearcelmod.utility.Translate;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

public class ConfigurationHandler {

    public static Configuration configuration;

    public static boolean doWorldGen;
    public static boolean doSpecialWorldGen;
    public static boolean doEnderPearcelCooldown;
    public static int torcherRange;
    public static int torcherFrequency;
    public static int maxStaffFlyHeight;
    public static int enderPearcelCooldownTime;
    public static int pearcelDropChance;
    public static float enderPearcelVelocity;

    public static void init(File configFile){

        //Create the configuration object from the given configuration file
        if (configuration == null){
            configuration = new Configuration(configFile);
            loadConfiguration();
        }

    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event){

        if (event.getModID().equalsIgnoreCase(Reference.MOD_ID)){
            loadConfiguration();
        }

    }

    private static void loadConfiguration(){

        configuration.addCustomCategoryComment(Translate.toLocal("config.category.enderPearcel.title"), Translate.toLocal("config.category.enderPearcel.desc"));
        configuration.addCustomCategoryComment(Translate.toLocal("config.category.torcher.title"), Translate.toLocal("config.category.torcher.desc"));
        configuration.addCustomCategoryComment(Translate.toLocal("config.category.worldGen.title"), Translate.toLocal("config.category.worldGen.desc"));

        maxStaffFlyHeight = configuration.getInt(Translate.toLocal("config.maxStaffFlyHeight.title"), Configuration.CATEGORY_GENERAL, 150, 1, 256, Translate.toLocal("config.maxStaffFlyHeight.desc"));
        pearcelDropChance = configuration.getInt(Translate.toLocal("config.pearcelDropChance.title"), Configuration.CATEGORY_GENERAL, 20, 1, 100, Translate.toLocal("config.pearcelDropChance.desc"));

        //Ender Pearcel
        enderPearcelVelocity = configuration.getFloat(Translate.toLocal("config.enderPearcelVelocity.title"), Translate.toLocal("config.category.enderPearcel.title"), 3.0F, 1, Float.MAX_VALUE, Translate.toLocal("config.enderPearcelVelocity.desc"));
        doEnderPearcelCooldown = configuration.getBoolean(Translate.toLocal("config.doEnderPearcelCooldown.title"), Translate.toLocal("config.category.enderPearcel.title"), true, Translate.toLocal("config.doEnderPearcelCooldown.desc"));
        enderPearcelCooldownTime = configuration.getInt(Translate.toLocal("config.enderPearcelCooldownTime.title"), Translate.toLocal("config.category.enderPearcel.title"), 1, 1, Integer.MAX_VALUE, Translate.toLocal("config.enderPearcelCooldownTime.desc"));

        //Torcher
        torcherRange = configuration.getInt(Translate.toLocal("config.torcherRange.title"), Translate.toLocal("config.category.torcher.title"), 25, 1, Integer.MAX_VALUE, Translate.toLocal("config.torcherRange.desc"));
        torcherFrequency = configuration.getInt(Translate.toLocal("config.torcherFrequency.title"), Translate.toLocal("config.category.torcher.title"), 2, 2, Integer.MAX_VALUE, Translate.toLocal("config.torcherFrequency.desc"));

        //World Gen
        doWorldGen = configuration.getBoolean(Translate.toLocal("config.doWorldGen.title"), Translate.toLocal("config.category.worldGen.title"), true, Translate.toLocal("config.doWorldGen.desc"));
        doSpecialWorldGen = configuration.getBoolean(Translate.toLocal("config.doSpecialWorldGen.title"), Translate.toLocal("config.category.worldGen.title"), true, Translate.toLocal("config.doSpecialWorldGen.desc"));

        if (configuration.hasChanged()){
            configuration.save();
        }

    }

}
