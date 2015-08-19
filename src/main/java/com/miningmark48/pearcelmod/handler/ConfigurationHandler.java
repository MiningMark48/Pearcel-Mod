package com.miningmark48.pearcelmod.handler;

import java.io.File;

import com.miningmark48.pearcelmod.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

public class ConfigurationHandler {

    public static Configuration configuration;

    public static boolean addPearcelStaff;
    public static boolean addFlightItem;
    public static boolean specialDice;

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

        addPearcelStaff = configuration.getBoolean("Add Pearcel Staff?", Configuration.CATEGORY_GENERAL, true, "Should the Pearcel Staff be added to the game?");
        addFlightItem = configuration.getBoolean("Add Flight Item?", Configuration.CATEGORY_GENERAL, false, "Should the Flight Item be added to the game?");
        specialDice = configuration.getBoolean("Have special dice rolls?", Configuration.CATEGORY_GENERAL, true, "Add Special dice rolls?");

        if (configuration.hasChanged()){

            configuration.save();

        }

    }
	
}
