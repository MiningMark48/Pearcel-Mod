package com.miningmark48.pearcelmod.handler;

import com.miningmark48.mininglib.utility.ModTranslate;
import com.miningmark48.pearcelmod.reference.Reference;
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
    public static boolean enableStructure1;
    public static boolean enableStructure2;
    public static boolean enableStructure3;
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
    public static int structureRarity1;
    public static int structureRarity2;
    public static int structureRarity3;
    public static float pearcelBeaconDamage;
    public static float pearcelMagnetPullSpeed;
    public static float enderPearcelVelocity;
    public static float rifPPickBaseHardness;
    public static int pearcelFurnace_speedMultiplier;
    public static int pearcelFurnace_efficiency;

    public static boolean rfUseEnabled_charmedPearcel;
    public static int rfStorage_charmedPearcel;
    public static int rfTransferPerTick_charmedPeacel;
    public static int rfPerTick_charmedPearcel_fire;
    public static int rfPerTick_charmedPearcel_water;
    public static int rfPerTick_charmedPearcel_saturation;
    public static int rfPerTick_charmedPearcel_stepAssist;
    public static int rfPerTick_charmedPearcel_gravity;
    public static int rfPerTick_charmedPearcel_adrenaline;
    public static int rfPerTick_charmedPearcel_cloaking;
    public static int rfPerTick_charmedPearcel_hearty;
    public static int rfPerTick_charmedPearcel_repair;
    public static int rfPerTick_charmedPearcel_physco;
    public static int rfPerTick_charmedPearcel_thirdEye;
    public static int rfPerTick_charmedPearcel_fall;
    public static boolean rfUseEnabled_magnet;
    public static int rfStorage_magnet;
    public static int rfTransferPerTick_magnet;
    public static int rfPerTick_magnet;
    public static boolean rfUseEnabled_livingMagnet;
    public static int rfStorage_livingMagnet;
    public static int rfTransferPerTick_livingMagnet;
    public static int rfPerTick_livingMagnet;
    public static boolean rfUseEnabled_enderPearcel;
    public static int rfStorage_enderPearcel;
    public static int rfTransferPerTick_enderPearcel;
    public static int rfPerUse_enderPearcel;
    public static boolean rfUseEnabled_pbp;
    public static int rfStorage_pbp;
    public static int rfTransferPerTick_pbp;
    public static int rfPerUse_pbp;

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

        configuration.addCustomCategoryComment(ModTranslate.toLocal("config.category.enderPearcel.title"), ModTranslate.toLocal("config.category.enderPearcel.desc"));
        configuration.addCustomCategoryComment(ModTranslate.toLocal("config.category.torcher.title"), ModTranslate.toLocal("config.category.torcher.desc"));
        configuration.addCustomCategoryComment(ModTranslate.toLocal("config.category.worldGen.title"), ModTranslate.toLocal("config.category.worldGen.desc"));
        configuration.addCustomCategoryComment(ModTranslate.toLocal("config.category.pearcelMagnet.title"), ModTranslate.toLocal("config.category.pearcelMagnet.desc"));
        configuration.addCustomCategoryComment(ModTranslate.toLocal("config.category.pearcelBeacon.title"), ModTranslate.toLocal("config.category.pearcelBeacon.desc"));
        configuration.addCustomCategoryComment(ModTranslate.toLocal("config.category.structures.title"), ModTranslate.toLocal("config.category.structures.desc"));
        configuration.addCustomCategoryComment(ModTranslate.toLocal("config.category.powerUsage.title"), ModTranslate.toLocal("config.category.powerUsage.desc"));
        configuration.setCategoryRequiresWorldRestart(ModTranslate.toLocal("config.category.structures.title"), true);


        maxStaffFlyHeight = configuration.getInt(ModTranslate.toLocal("config.maxStaffFlyHeight.title"), Configuration.CATEGORY_GENERAL, 150, 1, 256, ModTranslate.toLocal("config.maxStaffFlyHeight.desc"));
        pearcelDropChance = configuration.getInt(ModTranslate.toLocal("config.pearcelDropChance.title"), Configuration.CATEGORY_GENERAL, 20, 1, 100, ModTranslate.toLocal("config.pearcelDropChance.desc"));
        matterFabricatorMPAmount = configuration.getInt(ModTranslate.toLocal("config.matterFabricatorMPAmount.title"), Configuration.CATEGORY_GENERAL, 128, 1, Integer.MAX_VALUE, ModTranslate.toLocal("config.matterFabricatorMPAmount.desc"));
        stimulationPearcelTickAmount = configuration.getInt(ModTranslate.toLocal("config.stimulationPearcelTickAmount.title"), Configuration.CATEGORY_GENERAL, 25, 1, Integer.MAX_VALUE, ModTranslate.toLocal("config.stimulationPearcelTickAmount.desc"));
        glowingPearcelRange = configuration.getInt(ModTranslate.toLocal("config.glowingPearcelRange.title"), Configuration.CATEGORY_GENERAL, 35, 1, Integer.MAX_VALUE, ModTranslate.toLocal("config.glowingPearcelRange.desc"));
        doRIFArmorFlight = configuration.getBoolean(ModTranslate.toLocal("config.doRIFArmorFlight.title"), Configuration.CATEGORY_GENERAL, true, ModTranslate.toLocal("config.doRIFArmorFlight.desc"));
        creativeTabSearchBar = configuration.getBoolean(ModTranslate.toLocal("config.creativeTabSearchBar.title"), Configuration.CATEGORY_GENERAL, false, ModTranslate.toLocal("config.creativeTabSearchBar.desc"));
        pearcelFurnace_speedMultiplier = configuration.getInt(ModTranslate.toLocal("config.pearcelFurnace_speedMultiplier.title"), Configuration.CATEGORY_GENERAL, 3, 0, Integer.MAX_VALUE, ModTranslate.toLocal("config.pearcelFurnace_speedMultiplier.desc"));
        pearcelFurnace_efficiency = configuration.getInt(ModTranslate.toLocal("config.pearcelFurnace_efficiency.title"), Configuration.CATEGORY_GENERAL, 2, 0, Integer.MAX_VALUE, ModTranslate.toLocal("config.pearcelFurnace_efficiency.desc"));

        //Ender Pearcel
        enderPearcelVelocity = configuration.getFloat(ModTranslate.toLocal("config.enderPearcelVelocity.title"), ModTranslate.toLocal("config.category.enderPearcel.title"), 3.0F, 1, Float.MAX_VALUE, ModTranslate.toLocal("config.enderPearcelVelocity.desc"));
        doEnderPearcelCooldown = configuration.getBoolean(ModTranslate.toLocal("config.doEnderPearcelCooldown.title"), ModTranslate.toLocal("config.category.enderPearcel.title"), true, ModTranslate.toLocal("config.doEnderPearcelCooldown.desc"));
        enderPearcelCooldownTime = configuration.getInt(ModTranslate.toLocal("config.enderPearcelCooldownTime.title"), ModTranslate.toLocal("config.category.enderPearcel.title"), 1, 1, Integer.MAX_VALUE, ModTranslate.toLocal("config.enderPearcelCooldownTime.desc"));

        //Torcher
        torcherRange = configuration.getInt(ModTranslate.toLocal("config.torcherRange.title"), ModTranslate.toLocal("config.category.torcher.title"), 25, 1, Integer.MAX_VALUE, ModTranslate.toLocal("config.torcherRange.desc"));
        torcherFrequency = configuration.getInt(ModTranslate.toLocal("config.torcherFrequency.title"), ModTranslate.toLocal("config.category.torcher.title"), 2, 2, Integer.MAX_VALUE, ModTranslate.toLocal("config.torcherFrequency.desc"));

        //World Gen
        doWorldGen = configuration.getBoolean(ModTranslate.toLocal("config.doWorldGen.title"), ModTranslate.toLocal("config.category.worldGen.title"), true, ModTranslate.toLocal("config.doWorldGen.desc"));
        doSpecialWorldGen = configuration.getBoolean(ModTranslate.toLocal("config.doSpecialWorldGen.title"), ModTranslate.toLocal("config.category.worldGen.title"), true, ModTranslate.toLocal("config.doSpecialWorldGen.desc"));

        //RIF Pearcel Pickaxe
        rifPPickBaseHardness = configuration.getFloat(ModTranslate.toLocal("config.rifPPickBaseHardness.title"), ModTranslate.toLocal("config.category.rifPearcelPickaxe.title"), 50.0F, 0.25F, Float.MAX_VALUE, ModTranslate.toLocal("config.rifPPickBaseHardness.desc"));

        //Pearcel Magnet
        pearcelMagnetRange = configuration.getInt(ModTranslate.toLocal("config.pearcelMagnetRange.title"), ModTranslate.toLocal("config.category.pearcelMagnet.title"), 9, 1, Integer.MAX_VALUE, ModTranslate.toLocal("config.pearcelMagnetRange.desc"));
        pearcelMagnetPullSpeed = configuration.getFloat(ModTranslate.toLocal("config.pearcelMagnetPullSpeed.title"), ModTranslate.toLocal("config.category.pearcelMagnet.title"), 0.035F, 0, Float.MAX_VALUE, ModTranslate.toLocal("config.pearcelMagnetPullSpeed.desc"));
        pearcelMagnetParticles = configuration.getBoolean(ModTranslate.toLocal("config.pearcelMagnetParticles.title"), ModTranslate.toLocal("config.category.pearcelMagnet.title"), true, ModTranslate.toLocal("config.pearcelMagnetParticles.desc"));

        //Pearcel Beacon
        pearcelBeaconRange = configuration.getInt(ModTranslate.toLocal("config.pearcelBeaconRange.title"), ModTranslate.toLocal("config.category.pearcelBeacon.title"), 55, 1, Integer.MAX_VALUE, ModTranslate.toLocal("config.pearcelBeaconRange.desc"));
        pearcelBeaconDamage = configuration.getFloat(ModTranslate.toLocal("config.pearcelBeaconDamage.title"), ModTranslate.toLocal("config.category.pearcelBeacon.title"), 2.0F, 0.0F, Float.MAX_VALUE, ModTranslate.toLocal("config.pearcelBeaconDamage.desc"));

        //Structures
        structureRarity1 = configuration.getInt(ModTranslate.toLocal("config.structureRarity1.title"), ModTranslate.toLocal("config.category.structures.title"), 500, 50, Integer.MAX_VALUE, ModTranslate.toLocal("config.structureRarity1.desc"));
        structureRarity2 = configuration.getInt(ModTranslate.toLocal("config.structureRarity2.title"), ModTranslate.toLocal("config.category.structures.title"), 1400, 50, Integer.MAX_VALUE, ModTranslate.toLocal("config.structureRarity2.desc"));
        structureRarity3 = configuration.getInt(ModTranslate.toLocal("config.structureRarity3.title"), ModTranslate.toLocal("config.category.structures.title"), 1000, 50, Integer.MAX_VALUE, ModTranslate.toLocal("config.structureRarity3.desc"));
        enableStructure1 = configuration.getBoolean(ModTranslate.toLocal("config.enableStructure1.title"), ModTranslate.toLocal("config.category.structures.title"), true, ModTranslate.toLocal("config.enableStructure1.desc"));
        enableStructure2 = configuration.getBoolean(ModTranslate.toLocal("config.enableStructure2.title"), ModTranslate.toLocal("config.category.structures.title"), true, ModTranslate.toLocal("config.enableStructure2.desc"));
        enableStructure3 = configuration.getBoolean(ModTranslate.toLocal("config.enableStructure3.title"), ModTranslate.toLocal("config.category.structures.title"), true, ModTranslate.toLocal("config.enableStructure3.desc"));

        //Power Usage
        rfUseEnabled_charmedPearcel = configuration.getBoolean(ModTranslate.toLocal("config.rfUseEnabled_charmedPearcel.title"), ModTranslate.toLocal("config.category.powerUsage.title"), true, ModTranslate.toLocal("config.rfUseEnabled.desc"));
        rfStorage_charmedPearcel = configuration.getInt(ModTranslate.toLocal("config.rfStorage_charmedPearcel.title"), ModTranslate.toLocal("config.category.powerUsage.title"), 2500000, 0, Integer.MAX_VALUE, ModTranslate.toLocal("config.rfStorage.desc"));
        rfTransferPerTick_charmedPeacel = configuration.getInt(ModTranslate.toLocal("config.rfTransferPerTick_charmedPearcel.title"), ModTranslate.toLocal("config.category.powerUsage.title"), 1000, 0, Integer.MAX_VALUE, ModTranslate.toLocal("config.rfTransferPerTick.desc"));
        rfPerTick_charmedPearcel_fire = configuration.getInt(ModTranslate.toLocal("config.rfPerTick_charmedPearcel_fire.title"), ModTranslate.toLocal("config.category.powerUsage.title"), 50, 0, Integer.MAX_VALUE, ModTranslate.toLocal("config.rfPerTick.desc"));
        rfPerTick_charmedPearcel_water = configuration.getInt(ModTranslate.toLocal("config.rfPerTick_charmedPearcel_water.title"), ModTranslate.toLocal("config.category.powerUsage.title"), 50, 0, Integer.MAX_VALUE, ModTranslate.toLocal("config.rfPerTick.desc"));
        rfPerTick_charmedPearcel_saturation = configuration.getInt(ModTranslate.toLocal("config.rfPerTick_charmedPearcel_saturation.title"), ModTranslate.toLocal("config.category.powerUsage.title"), 100, 0, Integer.MAX_VALUE, ModTranslate.toLocal("config.rfPerTick.desc"));
        rfPerTick_charmedPearcel_stepAssist = configuration.getInt(ModTranslate.toLocal("config.rfPerTick_charmedPearcel_stepAssist.title"), ModTranslate.toLocal("config.category.powerUsage.title"), 5, 0, Integer.MAX_VALUE, ModTranslate.toLocal("config.rfPerTick.desc"));
        rfPerTick_charmedPearcel_gravity = configuration.getInt(ModTranslate.toLocal("config.rfPerTick_charmedPearcel_gravity.title"), ModTranslate.toLocal("config.category.powerUsage.title"), 10, 0, Integer.MAX_VALUE, ModTranslate.toLocal("config.rfPerTick.desc"));
        rfPerTick_charmedPearcel_adrenaline = configuration.getInt(ModTranslate.toLocal("config.rfPerTick_charmedPearcel_adrenaline.title"), ModTranslate.toLocal("config.category.powerUsage.title"), 150, 0, Integer.MAX_VALUE, ModTranslate.toLocal("config.rfPerTick.desc"));
        rfPerTick_charmedPearcel_cloaking = configuration.getInt(ModTranslate.toLocal("config.rfPerTick_charmedPearcel_cloaking.title"), ModTranslate.toLocal("config.category.powerUsage.title"), 300, 0, Integer.MAX_VALUE, ModTranslate.toLocal("config.rfPerTick.desc"));
        rfPerTick_charmedPearcel_hearty = configuration.getInt(ModTranslate.toLocal("config.rfPerTick_charmedPearcel_hearty.title"), ModTranslate.toLocal("config.category.powerUsage.title"), 500, 0, Integer.MAX_VALUE, ModTranslate.toLocal("config.rfPerTick.desc"));
        rfPerTick_charmedPearcel_repair = configuration.getInt(ModTranslate.toLocal("config.rfPerTick_charmedPearcel_repair.title"), ModTranslate.toLocal("config.category.powerUsage.title"), 500, 0, Integer.MAX_VALUE, ModTranslate.toLocal("config.rfPerTick.desc"));
        rfPerTick_charmedPearcel_physco = configuration.getInt(ModTranslate.toLocal("config.rfPerTick_charmedPearcel_physco.title"), ModTranslate.toLocal("config.category.powerUsage.title"), 300, 0, Integer.MAX_VALUE, ModTranslate.toLocal("config.rfPerTick.desc"));
        rfPerTick_charmedPearcel_thirdEye = configuration.getInt(ModTranslate.toLocal("config.rfPerTick_charmedPearcel_thirdEye.title"), ModTranslate.toLocal("config.category.powerUsage.title"), 200, 0, Integer.MAX_VALUE, ModTranslate.toLocal("config.rfPerTick.desc"));
        rfPerTick_charmedPearcel_fall = configuration.getInt(ModTranslate.toLocal("config.rfPerTick_charmedPearcel_fall.title"), ModTranslate.toLocal("config.category.powerUsage.title"), 20, 1, Integer.MAX_VALUE, ModTranslate.toLocal("config.rfPerTick.desc"));
        rfUseEnabled_magnet = configuration.getBoolean(ModTranslate.toLocal("config.rfUseEnabled_magnet.title"), ModTranslate.toLocal("config.category.powerUsage.title"), true, ModTranslate.toLocal("config.rfUseEnabled.desc"));
        rfStorage_magnet = configuration.getInt(ModTranslate.toLocal("config.rfStorage_magnet.title"), ModTranslate.toLocal("config.category.powerUsage.title"), 100000, 1, Integer.MAX_VALUE, ModTranslate.toLocal("config.rfPerTick.desc"));
        rfTransferPerTick_magnet = configuration.getInt(ModTranslate.toLocal("config.rfTransferPerTick_magnet.title"), ModTranslate.toLocal("config.category.powerUsage.title"), 1000, 1, Integer.MAX_VALUE, ModTranslate.toLocal("config.rfPerTick.desc"));
        rfPerTick_magnet = configuration.getInt(ModTranslate.toLocal("config.rfPerTick_magnet.title"), ModTranslate.toLocal("config.category.powerUsage.title"), 25, 1, Integer.MAX_VALUE, ModTranslate.toLocal("config.rfPerTick.desc"));
        rfUseEnabled_livingMagnet = configuration.getBoolean(ModTranslate.toLocal("config.rfUseEnabled_livingMagnet.title"), ModTranslate.toLocal("config.category.powerUsage.title"), true, ModTranslate.toLocal("config.rfUseEnabled.desc"));
        rfStorage_livingMagnet = configuration.getInt(ModTranslate.toLocal("config.rfStorage_livingMagnet.title"), ModTranslate.toLocal("config.category.powerUsage.title"), 100000, 1, Integer.MAX_VALUE, ModTranslate.toLocal("config.rfPerTick.desc"));
        rfTransferPerTick_livingMagnet = configuration.getInt(ModTranslate.toLocal("config.rfTransferPerTick_livingMagnet.title"), ModTranslate.toLocal("config.category.powerUsage.title"), 1000, 1, Integer.MAX_VALUE, ModTranslate.toLocal("config.rfPerTick.desc"));
        rfPerTick_livingMagnet = configuration.getInt(ModTranslate.toLocal("config.rfPerTick_livingMagnet.title"), ModTranslate.toLocal("config.category.powerUsage.title"), 100, 1, Integer.MAX_VALUE, ModTranslate.toLocal("config.rfPerTick.desc"));
        rfUseEnabled_enderPearcel = configuration.getBoolean(ModTranslate.toLocal("config.rfUseEnabled_enderPearcel.title"), ModTranslate.toLocal("config.category.powerUsage.title"), true, ModTranslate.toLocal("config.rfUseEnabled.desc"));
        rfStorage_enderPearcel = configuration.getInt(ModTranslate.toLocal("config.rfStorage_enderPearcel.title"), ModTranslate.toLocal("config.category.powerUsage.title"), 100000, 1, Integer.MAX_VALUE, ModTranslate.toLocal("config.rfPerTick.desc"));
        rfTransferPerTick_enderPearcel = configuration.getInt(ModTranslate.toLocal("config.rfTransferPerTick_enderPearcel.title"), ModTranslate.toLocal("config.category.powerUsage.title"), 1000, 1, Integer.MAX_VALUE, ModTranslate.toLocal("config.rfPerTick.desc"));
        rfPerUse_enderPearcel = configuration.getInt(ModTranslate.toLocal("config.rfPerUse_enderPearcel.title"), ModTranslate.toLocal("config.category.powerUsage.title"), 100, 1, Integer.MAX_VALUE, ModTranslate.toLocal("config.rfPerUse.desc"));
        rfUseEnabled_pbp = configuration.getBoolean(ModTranslate.toLocal("config.rfUseEnabled_pbp.title"), ModTranslate.toLocal("config.category.powerUsage.title"), true, ModTranslate.toLocal("config.rfUseEnabled.desc"));
        rfStorage_pbp = configuration.getInt(ModTranslate.toLocal("config.rfStorage_pbp.title"), ModTranslate.toLocal("config.category.powerUsage.title"), 10000, 1, Integer.MAX_VALUE, ModTranslate.toLocal("config.rfPerTick.desc"));
        rfTransferPerTick_pbp = configuration.getInt(ModTranslate.toLocal("config.rfTransferPerTick_pbp.title"), ModTranslate.toLocal("config.category.powerUsage.title"), 100, 1, Integer.MAX_VALUE, ModTranslate.toLocal("config.rfPerTick.desc"));
        rfPerUse_pbp = configuration.getInt(ModTranslate.toLocal("config.rfPerUse_pbp.title"), ModTranslate.toLocal("config.category.powerUsage.title"), 10, 1, Integer.MAX_VALUE, ModTranslate.toLocal("config.rfPerUse.desc"));
        if (configuration.hasChanged()){
            configuration.save();
        }

    }

}
