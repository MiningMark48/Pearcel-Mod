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
    public static boolean useFlightItemParticle;
    public static boolean specialDice;
    public static boolean useMEMatter;
    public static int torcherRange;
    public static int torcherFrequency;
    public static int summonerRange;
    public static int sapDurability;

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
        addFlightItem = configuration.getBoolean("Add Flight Item?", Configuration.CATEGORY_GENERAL, true, "Should the Flight Item be added to the game?");
        useFlightItemParticle = configuration.getBoolean("Use Flight Item Particles?", Configuration.CATEGORY_GENERAL, true, "Should the particles of the Flight Item be added to the game?");
        specialDice = configuration.getBoolean("Have special dice rolls?", Configuration.CATEGORY_GENERAL, true, "Add Special dice rolls?");
        useMEMatter = configuration.getBoolean("ME^Matter Recipes", Configuration.CATEGORY_GENERAL, true, "Should ME^Matter recipes be added?");
        torcherRange = configuration.getInt("Torcher Range", Configuration.CATEGORY_GENERAL, 25, 1, 500, "What is the range of torches that can be placed by the torcher block?");
        torcherFrequency = configuration.getInt("Torcher Frequency", Configuration.CATEGORY_GENERAL, 2, 50, 2, "What is the frequency of torches that can be placed by the torcher block?");
        summonerRange = configuration.getInt("Range for Summoner", Configuration.CATEGORY_GENERAL, 3, 1, 25, "What is the range in which something may be summoned?");
        sapDurability = configuration.getInt("Durability for Summoner's Activation Pearcel", Configuration.CATEGORY_GENERAL, 20, 1, 100, "What is the durability of the summoner's activation pearcel?");

        if (configuration.hasChanged()){

            configuration.save();

        }

    }
	
}
