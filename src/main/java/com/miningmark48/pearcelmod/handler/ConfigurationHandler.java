package com.miningmark48.pearcelmod.handler;

import com.miningmark48.pearcelmod.reference.Reference;
import net.minecraft.util.text.TextComponentString;
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

        if (event.getModID().equalsIgnoreCase(Reference.MOD_ID)){
            loadConfiguration();
        }

    }

    private static void loadConfiguration(){

        doWorldGen = configuration.getBoolean(new TextComponentString("config.doWorldGen.title").toString(), Configuration.CATEGORY_GENERAL, true, new TextComponentString("config.doWorldGen.desc").toString());
        doSpecialWorldGen = configuration.getBoolean(new TextComponentString("config.doSpecialWorldGen.title").toString(), Configuration.CATEGORY_GENERAL, true, new TextComponentString("config.doSpecialWorldGen.desc").toString());
        torcherRange = configuration.getInt(new TextComponentString("config.torcherRange.title").toString(), Configuration.CATEGORY_GENERAL, 25, 1, Integer.MAX_VALUE, new TextComponentString("config.torcherRange.desc").toString());
        torcherFrequency = configuration.getInt(new TextComponentString("config.torcherFrequency.title").toString(), Configuration.CATEGORY_GENERAL, 2, 2, Integer.MAX_VALUE, new TextComponentString("config.torcherFrequency.desc").toString());
        sapDurability = configuration.getInt(new TextComponentString("config.sapDurability.title").toString(), Configuration.CATEGORY_GENERAL, 32, 1, Integer.MAX_VALUE, new TextComponentString("config.sapDurability.desc").toString());
        maxStaffFlyHeight = configuration.getInt(new TextComponentString("config.maxStaffFlyHeight.title").toString(), Configuration.CATEGORY_GENERAL, 150, 1, 256, new TextComponentString("config.maxStaffFlyHeight.desc").toString());

        if (configuration.hasChanged()){
            configuration.save();
        }

    }

}
