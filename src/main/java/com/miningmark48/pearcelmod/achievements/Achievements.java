package com.miningmark48.pearcelmod.achievements;

import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.utility.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class Achievements {

    public static Achievement achievementPearcelSword;
    public static Achievement achievementPearcelOre;
    public static Achievement achievementPearcelMatter;
    public static Achievement achievementPearcelStaff;
    public static Achievement achievementArmorPlating;
    public static Achievement achievementFreeBeacon;
    public static Achievement achievementTorcher;
    public static Achievement achievementFlight;
    public static Achievement achievementSummon;

    public static void init(){
        //Creates a new achievement
        achievementPearcelSword = new Achievement("achievement.craftPearcelSword", "craftPearcelSword", 0, 0, new ItemStack(ModItems.pearcelSword), (Achievement)null).initIndependentStat().registerStat();
        achievementPearcelOre = new Achievement("achievement.findPearcelOre", "findPearcelOre", 2, 0, new ItemStack(ModBlocks.pearcelOre), (Achievement)null).initIndependentStat().registerStat();
        achievementPearcelMatter = new Achievement("achievement.craftPearcelMatter", "craftPearcelMatter", 4, 0, new ItemStack(ModItems.pearcelMatter), (Achievement)null).initIndependentStat().registerStat();
        achievementPearcelStaff = new Achievement("achievement.craftPearcelStaff", "craftPearcelStaff", 4, 2, new ItemStack(ModItems.pearcelStaff), achievementPearcelMatter).registerStat();
        achievementArmorPlating = new Achievement("achievement.craftArmorPlating", "craftArmorPlating", 0, 4, new ItemStack(ModItems.armorPlating), (Achievement)null).initIndependentStat().registerStat();
        achievementTorcher = new Achievement("achievement.useTorcher", "useTorcher", 0, 2, new ItemStack(ModBlocks.torcher), (Achievement)null).initIndependentStat().registerStat();
        achievementFlight = new Achievement("achievement.useFlightItem", "useFlightItem", 6, 0, new ItemStack(ModItems.flightItem), achievementPearcelMatter).registerStat();
        achievementSummon = new Achievement("achievement.summon", "summon", 2, 2, new ItemStack(ModBlocks.summoner), (Achievement)null).initIndependentStat().registerStat();

        //Creates Achievement Page
        AchievementPage.registerAchievementPage(new AchievementPage("Pearcel Mod", new Achievement[]{achievementPearcelSword, achievementPearcelOre, achievementPearcelMatter, achievementPearcelStaff, achievementArmorPlating, achievementTorcher, achievementFlight, achievementSummon}));

        //Register Achievements
        FMLCommonHandler.instance().bus().register(new CraftPearcelSword());
        FMLCommonHandler.instance().bus().register(new FindPearcelOre());
        FMLCommonHandler.instance().bus().register(new CraftPearcelMatter());
        FMLCommonHandler.instance().bus().register(new CraftPearcelStaff());
        FMLCommonHandler.instance().bus().register(new CraftArmorPlating());

        LogHelper.info("Achievements loaded!");
    }

}
