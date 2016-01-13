package com.miningmark48.pearcelmod.handler;

import java.io.File;
import java.util.concurrent.locks.Condition;

import com.miningmark48.pearcelmod.reference.Reference;
import com.miningmark48.pearcelmod.utility.LogHelper;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.config.Configuration;

public class ConfigurationHandler {

    public static Configuration configuration;

    public static boolean addPearcelStaff;
    public static boolean useFlightItemParticle;
    public static boolean specialDice;
    public static boolean useMEMatter;
    public static boolean flightItemExhaustion;
    public static int torcherRange;
    public static int torcherFrequency;
    public static int summonerRange;
    public static int sapDurability;
    public static int maxStaffFlyHeight;
    public static int minPearcelLightning;
    public static int maxPearcelLightning;


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

        addPearcelStaff = configuration.getBoolean(StatCollector.translateToLocal("config.addPearcelStaff.title"), Configuration.CATEGORY_GENERAL, true, StatCollector.translateToLocal("config.addPearcelStaff.desc"));
        useFlightItemParticle = configuration.getBoolean(StatCollector.translateToLocal("config.useFlightItemParticle.title"), Configuration.CATEGORY_GENERAL, true, StatCollector.translateToLocal("config.useFlightItemParticle.desc"));
        flightItemExhaustion = configuration.getBoolean(StatCollector.translateToLocal("config.flightItemExhaustion.title"), Configuration.CATEGORY_GENERAL, true, StatCollector.translateToLocal("config.flightItemExhaustion.desc"));
        specialDice = configuration.getBoolean(StatCollector.translateToLocal("config.specialDice.title"), Configuration.CATEGORY_GENERAL, true, StatCollector.translateToLocal("config.specialDice.desc"));
        useMEMatter = configuration.getBoolean(StatCollector.translateToLocal("config.useMEMatter.title"), Configuration.CATEGORY_GENERAL, true, StatCollector.translateToLocal("config.useMEMatter.desc"));
        torcherRange = configuration.getInt(StatCollector.translateToLocal("config.torcherRange.title"), Configuration.CATEGORY_GENERAL, 25, 1, 500, StatCollector.translateToLocal("config.torcherRange.desc"));
        torcherFrequency = configuration.getInt(StatCollector.translateToLocal("config.torcherFrequency.title"), Configuration.CATEGORY_GENERAL, 2, 50, 2, StatCollector.translateToLocal("config.torcherFrequency.desc"));
        summonerRange = configuration.getInt(StatCollector.translateToLocal("config.summonerRange.title"), Configuration.CATEGORY_GENERAL, 3, 1, 25, StatCollector.translateToLocal("config.summonerRange.desc"));
        sapDurability = configuration.getInt(StatCollector.translateToLocal("config.sapDurability.title"), Configuration.CATEGORY_GENERAL, 20, 1, 100, StatCollector.translateToLocal("config.sapDurability.desc"));
        maxStaffFlyHeight = configuration.getInt(StatCollector.translateToLocal("config.maxStaffFlyHeight.title"), Configuration.CATEGORY_GENERAL, 150, 1, 256, StatCollector.translateToLocal("config.maxStaffFlyHeight.desc"));
        minPearcelLightning = configuration.getInt(StatCollector.translateToLocal("config.minPearcelLightning.title"), Configuration.CATEGORY_GENERAL, 2, 0, 99, StatCollector.translateToLocal("config.minPearcelLightning.desc"));
        maxPearcelLightning = configuration.getInt(StatCollector.translateToLocal("config.maxPearcelLightning.title"), Configuration.CATEGORY_GENERAL, 5, 1, 100, StatCollector.translateToLocal("config.maxPearcelLightning.desc"));


        if (configuration.hasChanged()){
            configuration.save();
        }

    }
	
}
