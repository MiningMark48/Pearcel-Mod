package com.miningmark48.pearcelmod.handler;

import java.io.File;

import com.miningmark48.pearcelmod.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

public class ConfigurationHandler {

    public static Configuration configuration;

    public static boolean testValueBoolean;
    public static int testValueInt;
    public static String testValueString;

    public static boolean addPearcelStaff;

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

        testValueBoolean = configuration.getBoolean("Boolean Value", Configuration.CATEGORY_GENERAL, false, "This is a boolean config value");
        testValueInt = configuration.getInt("Integer Value", Configuration.CATEGORY_GENERAL, 1, 1, 10, "This is an integer config value");
        testValueString = configuration.getString("String Value", Configuration.CATEGORY_GENERAL, "MiningMark48", "This is a string config value");

        addPearcelStaff = configuration.getBoolean("Add Pearcel Staff?", Configuration.CATEGORY_GENERAL, true, "Should the Pearcel Staff be added into the game? (Requires restart)");

        if (configuration.hasChanged()){

            configuration.save();

        }

    }
	
}
