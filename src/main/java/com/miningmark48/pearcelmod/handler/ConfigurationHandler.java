package com.miningmark48.pearcelmod.handler;

import com.miningmark48.pearcelmod.reference.Reference;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

public class ConfigurationHandler {

    public static Configuration configuration;

    public static boolean doWorldGen;
    public static boolean doSpecialWorldGen;
    public static int torcherRange;
    public static int torcherFrequency;
    public static int sapDurability;
    public static int maxStaffFlyHeight;

    public static void init(File configFile){

        //Create the configuration object from the given configuration file
        if (configuration == null){
            configuration = new Configuration(configFile);
            loadConfiguration();
        }

    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event){

        if (event.modID.equalsIgnoreCase(Reference.MOD_ID)){
            loadConfiguration();
        }

    }

    private static void loadConfiguration(){

        doWorldGen = configuration.getBoolean(StatCollector.translateToLocal("config.doWorldGen.title"), Configuration.CATEGORY_GENERAL, true, StatCollector.translateToLocal("config.doWorldGen.desc"));
        doSpecialWorldGen = configuration.getBoolean(StatCollector.translateToLocal("config.doSpecialWorldGen.title"), Configuration.CATEGORY_GENERAL, true, StatCollector.translateToLocal("config.doSpecialWorldGen.desc"));
        torcherRange = configuration.getInt(StatCollector.translateToLocal("config.torcherRange.title"), Configuration.CATEGORY_GENERAL, 25, 1, Integer.MAX_VALUE, StatCollector.translateToLocal("config.torcherRange.desc"));
        torcherFrequency = configuration.getInt(StatCollector.translateToLocal("config.torcherFrequency.title"), Configuration.CATEGORY_GENERAL, 2, 2, Integer.MAX_VALUE, StatCollector.translateToLocal("config.torcherFrequency.desc"));
        sapDurability = configuration.getInt(StatCollector.translateToLocal("config.sapDurability.title"), Configuration.CATEGORY_GENERAL, 32, 1, Integer.MAX_VALUE, StatCollector.translateToLocal("config.sapDurability.desc"));
        maxStaffFlyHeight = configuration.getInt(StatCollector.translateToLocal("config.maxStaffFlyHeight.title"), Configuration.CATEGORY_GENERAL, 150, 1, 256, StatCollector.translateToLocal("config.maxStaffFlyHeight.desc"));

        if (configuration.hasChanged()){
            configuration.save();
        }

    }

}
