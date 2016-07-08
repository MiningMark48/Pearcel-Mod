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

        doWorldGen = configuration.getBoolean(Translate.toLocal("config.doWorldGen.title"), Configuration.CATEGORY_GENERAL, true, Translate.toLocal("config.doWorldGen.desc"));
        doSpecialWorldGen = configuration.getBoolean(Translate.toLocal("config.doSpecialWorldGen.title"), Configuration.CATEGORY_GENERAL, true, Translate.toLocal("config.doSpecialWorldGen.desc"));
        torcherRange = configuration.getInt(Translate.toLocal("config.torcherRange.title"), Configuration.CATEGORY_GENERAL, 25, 1, Integer.MAX_VALUE, Translate.toLocal("config.torcherRange.desc"));
        torcherFrequency = configuration.getInt(Translate.toLocal("config.torcherFrequency.title"), Configuration.CATEGORY_GENERAL, 2, 2, Integer.MAX_VALUE, Translate.toLocal("config.torcherFrequency.desc"));
        maxStaffFlyHeight = configuration.getInt(Translate.toLocal("config.maxStaffFlyHeight.title"), Configuration.CATEGORY_GENERAL, 150, 1, 256, Translate.toLocal("config.maxStaffFlyHeight.desc"));
        enderPearcelVelocity = configuration.getFloat(Translate.toLocal("config.enderPearcelVelocity.title"), Configuration.CATEGORY_GENERAL, 3.0F, 1, Float.MAX_VALUE, Translate.toLocal("config.enderPearcelVelocity.desc"));
        doEnderPearcelCooldown = configuration.getBoolean(Translate.toLocal("config.doEnderPearcelCooldown.title"), Configuration.CATEGORY_GENERAL, true, Translate.toLocal("config.doEnderPearcelCooldown.desc"));
        enderPearcelCooldownTime = configuration.getInt(Translate.toLocal("config.enderPearcelCooldownTime.title"), Configuration.CATEGORY_GENERAL, 1, 1, Integer.MAX_VALUE, Translate.toLocal("config.enderPearcelCooldownTime.desc"));

        if (configuration.hasChanged()){
            configuration.save();
        }

    }

}
