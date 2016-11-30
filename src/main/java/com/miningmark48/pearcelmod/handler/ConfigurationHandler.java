package com.miningmark48.pearcelmod.handler;

import com.miningmark48.pearcelmod.reference.Reference;
import com.miningmark48.pearcelmod.utility.Translate;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

public class ConfigurationHandler {

    public static Configuration configuration;

    public static boolean doWorldGen;
    public static boolean doSpecialWorldGen;
    public static boolean doEnderPearcelCooldown;
    public static boolean doRIFArmorFlight;
    public static boolean pearcelMagnetParticles;
    public static boolean creativeTabSearchBar;
    public static int torcherRange;
    public static int torcherFrequency;
    public static int maxStaffFlyHeight;
    public static int enderPearcelCooldownTime;
    public static int pearcelDropChance;
    public static int matterFabricatorMPAmount;
    public static int stimulationPearcelTickAmount;
    public static int pearcelMagnetRange;
    public static int glowingPearcelRange;
    public static int pearcelBeaconRange;
    public static float pearcelBeaconDamage;
    public static float pearcelMagnetPullSpeed;
    public static float enderPearcelVelocity;
    public static float rifPPickBaseHardness;

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
        configuration.addCustomCategoryComment(Translate.toLocal("config.category.pearcelMagnet.title"), Translate.toLocal("config.category.pearcelMagnet.desc"));
        configuration.addCustomCategoryComment(Translate.toLocal("config.category.pearcelBeacon.title"), Translate.toLocal("config.categoty.pearcelBeacon.desc"));;

        maxStaffFlyHeight = configuration.getInt(Translate.toLocal("config.maxStaffFlyHeight.title"), Configuration.CATEGORY_GENERAL, 150, 1, 256, Translate.toLocal("config.maxStaffFlyHeight.desc"));
        pearcelDropChance = configuration.getInt(Translate.toLocal("config.pearcelDropChance.title"), Configuration.CATEGORY_GENERAL, 20, 1, 100, Translate.toLocal("config.pearcelDropChance.desc"));
        matterFabricatorMPAmount = configuration.getInt(Translate.toLocal("config.matterFabricatorMPAmount.title"), Configuration.CATEGORY_GENERAL, 128, 1, Integer.MAX_VALUE, Translate.toLocal("config.matterFabricatorMPAmount.desc"));
        stimulationPearcelTickAmount = configuration.getInt(Translate.toLocal("config.stimulationPearcelTickAmount.title"), Configuration.CATEGORY_GENERAL, 25, 1, Integer.MAX_VALUE, Translate.toLocal("config.stimulationPearcelTickAmount.desc"));
        glowingPearcelRange = configuration.getInt(Translate.toLocal("config.glowingPearcelRange.title"), Configuration.CATEGORY_GENERAL, 35, 1, Integer.MAX_VALUE, Translate.toLocal("config.glowingPearcelRange.desc"));
        doRIFArmorFlight = configuration.getBoolean(Translate.toLocal("config.doRIFArmorFlight.title"), Configuration.CATEGORY_GENERAL, true, Translate.toLocal("config.doRIFArmorFlight.desc"));
        creativeTabSearchBar = configuration.getBoolean(Translate.toLocal("config.creativeTabSearchBar.title"), Configuration.CATEGORY_GENERAL, false, Translate.toLocal("config.creativeTabSearchBar.desc"));

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

        //RIF Pearcel Pickaxe
        rifPPickBaseHardness = configuration.getFloat(Translate.toLocal("config.rifPPickBaseHardness.title"), Translate.toLocal("config.category.rifPearcelPickaxe.title"), 50.0F, 0.25F, Float.MAX_VALUE, Translate.toLocal("config.rifPPickBaseHardness.desc"));

        //Pearcel Magnet
        pearcelMagnetRange = configuration.getInt(Translate.toLocal("config.pearcelMagnetRange.title"), Translate.toLocal("config.category.pearcelMagnet.title"), 9, 1, Integer.MAX_VALUE, Translate.toLocal("config.pearcelMagnetRange.desc"));
        pearcelMagnetPullSpeed = configuration.getFloat(Translate.toLocal("config.pearcelMagnetPullSpeed.title"), Translate.toLocal("config.category.pearcelMagnet.title"), 0.035F, 0, Float.MAX_VALUE, Translate.toLocal("config.pearcelMagnetPullSpeed.desc"));
        pearcelMagnetParticles = configuration.getBoolean(Translate.toLocal("config.pearcelMagnetParticles.title"), Translate.toLocal("config.category.pearcelMagnet.title"), true, Translate.toLocal("config.pearcelMagnetParticles.desc"));

        //Pearcel Beacon
        pearcelBeaconRange = configuration.getInt(Translate.toLocal("config.pearcelBeaconRange.title"), Translate.toLocal("config.category.pearcelBeacon.title"), 55, 1, Integer.MAX_VALUE, Translate.toLocal("config.pearcelBeaconRange.desc"));
        pearcelBeaconDamage = configuration.getFloat(Translate.toLocal("config.pearcelBeaconDamage.title"), Translate.toLocal("config.category.pearcelBeacon.title"), 2.0F, 0.0F, Float.MAX_VALUE, Translate.toLocal("config.pearcelBeaconDamage.desc"));


        if (configuration.hasChanged()){
            configuration.save();
        }

    }

}
