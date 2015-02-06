package com.miningmark48.pearcelmod.achievements;

import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.utility.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class Achievements {

    public static Achievement achievementPearcelSword;
    public static Achievement achievementSugarCookie;
    public static Achievement achievementPearcelOre;

    public static void init(){
        //Creates a new achievement
        achievementPearcelSword = new Achievement("achievement.craftPearcelSword", "craftPearcelSword", 0, 0, new ItemStack(ModItems.pearcelSword), (Achievement)null).initIndependentStat().registerStat();
        achievementSugarCookie = new Achievement("achievement.craftSugarCookie", "craftSugarCookie", 0, 2, new ItemStack(ModItems.sugarCookie), (Achievement)null).initIndependentStat().registerStat();
        achievementPearcelOre = new Achievement("achievement.findPearcelOre", "findPearcelOre", 2, 0, new ItemStack(ModBlocks.pearcelOre), (Achievement)null).initIndependentStat().registerStat();

        //Creates Achievement Page
        AchievementPage.registerAchievementPage(new AchievementPage("Pearcel Mod", new Achievement[]{achievementPearcelSword, achievementSugarCookie, achievementPearcelOre}));

        //Register Achievements
        FMLCommonHandler.instance().bus().register(new CraftPearcelSword());
        FMLCommonHandler.instance().bus().register(new CraftSugarCookie());
        FMLCommonHandler.instance().bus().register(new FindPearcelOre());

        LogHelper.info("Achievements loaded!");
    }

}
