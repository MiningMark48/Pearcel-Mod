package com.miningmark48.pearcelmod.achievements;

import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.utility.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class Achievements {

    public static Achievement achievementPearcelSword;
    public static Achievement achievementPearcelOre;
    public static Achievement achievementPearcelMelon;
    public static Achievement achievementMelonSandwich;
    public static Achievement achievementPearcelCookie9;
    public static Achievement achievementMEMatter;
    public static Achievement achievementPearcelStaff;

    public static void init(){
        //Creates a new achievement
        achievementPearcelSword = new Achievement("achievement.craftPearcelSword", "craftPearcelSword", 0, 0, new ItemStack(ModItems.pearcelSword), (Achievement)null).initIndependentStat().registerStat();
        achievementPearcelOre = new Achievement("achievement.findPearcelOre", "findPearcelOre", 2, 0, new ItemStack(ModBlocks.pearcelOre), (Achievement)null).initIndependentStat().registerStat();
        achievementPearcelMelon = new Achievement("achievement.craftPearcelMelon", "craftPearcelMelon", 0, 2, new ItemStack(ModItems.pearcelMelon), (Achievement)null).initIndependentStat().registerStat();
        achievementMelonSandwich = new Achievement("achievement.craftMelonSandwich", "craftMelonSandwich", 2, 2, new ItemStack(ModItems.melonSandwich), (Achievement)null).initIndependentStat().registerStat();
        achievementPearcelCookie9 = new Achievement("achievement.craftPearcelCookie9", "craftPearcelCookie9", 2, 4, new ItemStack(ModItems.pearcelCookie9), (Achievement)null).initIndependentStat().registerStat();
        achievementMEMatter = new Achievement("achievement.craftMEMatter", "craftMEMatter", 4, 2, new ItemStack(ModItems.meMatter), (Achievement)null).initIndependentStat().registerStat();
        achievementPearcelStaff = new Achievement("achievement.craftPearcelStaff", "craftPearcelStaff", 4, 0, new ItemStack(ModItems.pearcelStaff), achievementMEMatter).registerStat();

        //Creates Achievement Page
        AchievementPage.registerAchievementPage(new AchievementPage("Pearcel Mod", new Achievement[]{achievementPearcelSword, achievementPearcelOre, achievementPearcelMelon, achievementMelonSandwich, achievementPearcelCookie9, achievementMEMatter, achievementPearcelStaff}));

        //Register Achievements
        FMLCommonHandler.instance().bus().register(new CraftPearcelSword());
        FMLCommonHandler.instance().bus().register(new FindPearcelOre());
        FMLCommonHandler.instance().bus().register(new CraftPearcelMelon());
        FMLCommonHandler.instance().bus().register(new CraftMelonSandwich());
        FMLCommonHandler.instance().bus().register(new CraftPearcelCookie9());
        FMLCommonHandler.instance().bus().register(new CraftMEMatter());
        FMLCommonHandler.instance().bus().register(new CraftPearcelStaff());

        LogHelper.info("Achievements loaded!");
    }

}
