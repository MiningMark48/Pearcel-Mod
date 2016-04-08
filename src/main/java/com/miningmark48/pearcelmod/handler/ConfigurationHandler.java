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

    public static boolean useFlightItemParticle;
    public static boolean specialDice;
    public static boolean flightItemDisable;
    public static boolean craftingTables;
    public static boolean doSpecialWorldGen;
    public static int torcherRange;
    public static int torcherFrequency;
    public static int sapDurability;
    public static int maxStaffFlyHeight;
    public static int minPearcelLightning;
    public static int maxPearcelLightning;
    public static int saplingGrowthMultiplier;

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

        useFlightItemParticle = configuration.getBoolean(StatCollector.translateToLocal("config.useFlightItemParticle.title"), Configuration.CATEGORY_GENERAL, true, StatCollector.translateToLocal("config.useFlightItemParticle.desc"));
        specialDice = configuration.getBoolean(StatCollector.translateToLocal("config.specialDice.title"), Configuration.CATEGORY_GENERAL, true, StatCollector.translateToLocal("config.specialDice.desc"));
        flightItemDisable = configuration.getBoolean(StatCollector.translateToLocal("config.flightItemDisable.title"), Configuration.CATEGORY_GENERAL, true, StatCollector.translateToLocal("config.flightItemDisable.desc"));
        craftingTables = configuration.getBoolean(StatCollector.translateToLocal("config.craftingTables.title"), Configuration.CATEGORY_GENERAL, false, StatCollector.translateToLocal("config.craftingTables.desc"));
        doSpecialWorldGen = configuration.getBoolean(StatCollector.translateToLocal("config.doSpecialWorldGen.title"), Configuration.CATEGORY_GENERAL, true, StatCollector.translateToLocal("config.doSpecialWorldGen.desc"));
        torcherRange = configuration.getInt(StatCollector.translateToLocal("config.torcherRange.title"), Configuration.CATEGORY_GENERAL, 25, 1, Integer.MAX_VALUE, StatCollector.translateToLocal("config.torcherRange.desc"));
        torcherFrequency = configuration.getInt(StatCollector.translateToLocal("config.torcherFrequency.title"), Configuration.CATEGORY_GENERAL, 2, 2, Integer.MAX_VALUE, StatCollector.translateToLocal("config.torcherFrequency.desc"));
        sapDurability = configuration.getInt(StatCollector.translateToLocal("config.sapDurability.title"), Configuration.CATEGORY_GENERAL, 32, 1, Integer.MAX_VALUE, StatCollector.translateToLocal("config.sapDurability.desc"));
        maxStaffFlyHeight = configuration.getInt(StatCollector.translateToLocal("config.maxStaffFlyHeight.title"), Configuration.CATEGORY_GENERAL, 150, 1, 256, StatCollector.translateToLocal("config.maxStaffFlyHeight.desc"));
        minPearcelLightning = configuration.getInt(StatCollector.translateToLocal("config.minPearcelLightning.title"), Configuration.CATEGORY_GENERAL, 2, 0, 99, StatCollector.translateToLocal("config.minPearcelLightning.desc"));
        maxPearcelLightning = configuration.getInt(StatCollector.translateToLocal("config.maxPearcelLightning.title"), Configuration.CATEGORY_GENERAL, 5, 1, 100, StatCollector.translateToLocal("config.maxPearcelLightning.desc"));
        saplingGrowthMultiplier = configuration.getInt(StatCollector.translateToLocal("config.saplingGrowthMultiplier.title"), Configuration.CATEGORY_GENERAL, 0, 0, Integer.MAX_VALUE, StatCollector.translateToLocal("config.saplingGrowthMultiplier.desc"));

        if (configuration.hasChanged()){
            configuration.save();
        }

    }
	
}
