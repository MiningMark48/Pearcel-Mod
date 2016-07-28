package com.miningmark48.pearcelmod.achievements;

import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.reference.Reference;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.MinecraftForge;

public class Achievements {

    public static Achievement achievement_get_pearcel;
    public static Achievement achievement_craft_pearcel_ingot;
    public static Achievement achievement_craft_tier1_cc;
    public static Achievement achievement_craft_tier2_cc;
    public static Achievement achievement_craft_tier3_cc;
    public static Achievement achievement_craft_tier4_cc;
    public static Achievement achievement_craft_pcp;
    public static Achievement achievement_craft_pearcel_tools;
    public static Achievement achievement_craft_pearcel_armor_plating;
    public static Achievement achievement_craft_pearcel_armor;
    public static Achievement achievement_craft_pearcel_bread;
    public static Achievement achievement_use_experience_pearcel;
    public static Achievement achievement_craft_ender_pearcel;
    public static Achievement achievement_use_tp_pearcel;
    public static Achievement achievement_use_pepc;

    public static void init(){
        achievement_get_pearcel = new Achievement("achievement.get_pearcel", "get_pearcel", 0, 0, new ItemStack(ModItems.pearcel_item), (Achievement)null).initIndependentStat().registerStat();
        achievement_craft_pearcel_ingot = new Achievement("achievement.craft_pearcel_ingot", "craft_pearcel_ingot", 0, -2, new ItemStack(ModItems.pearcel_ingot), achievement_get_pearcel).registerStat();
        achievement_craft_tier1_cc = new Achievement("achievement.craft_tier1_cc", "craft_tier1_cc", 2, -2, new ItemStack(ModItems.tier_1_crafting_component), achievement_craft_pearcel_ingot).registerStat();
        achievement_craft_tier2_cc = new Achievement("achievement.craft_tier2_cc", "craft_tier2_cc", 4, -2, new ItemStack(ModItems.tier_2_crafting_component), achievement_craft_tier1_cc).registerStat();
        achievement_craft_tier3_cc = new Achievement("achievement.craft_tier3_cc", "craft_tier3_cc", 6, -2, new ItemStack(ModItems.tier_3_crafting_component), achievement_craft_tier2_cc).registerStat();
        achievement_craft_tier4_cc = new Achievement("achievement.craft_tier4_cc", "craft_tier4_cc", 8, -2, new ItemStack(ModItems.tier_4_crafting_component), achievement_craft_tier3_cc).registerStat();
        achievement_craft_pcp = new Achievement("achievement.craft_pcp", "craft_pcp", 2, -4, new ItemStack(ModItems.pcp), achievement_craft_tier1_cc).registerStat();
        achievement_craft_pearcel_tools = new Achievement("achievement.craft_pearcel_tools", "craft_pearcel_tools", 6, -4, new ItemStack(ModItems.pearcel_sword), achievement_craft_tier2_cc).registerStat();
        achievement_craft_pearcel_armor_plating = new Achievement("achievement.craft_pearcel_armor_plating", "craft_pearcel_armor_plating", 4, -6, new ItemStack(ModItems.armor_plating), achievement_craft_tier2_cc).registerStat();
        achievement_craft_pearcel_armor = new Achievement("achievement.craft_pearcel_armor", "craft_pearcel_armor", 2, -6, new ItemStack(ModItems.pearcel_chestplate), achievement_craft_pearcel_armor_plating).registerStat();
        achievement_craft_pearcel_bread = new Achievement("achievement.craft_pearcel_bread", "craft_pearcel_bread", 0, 2, new ItemStack(ModItems.pearcel_bread), achievement_get_pearcel).registerStat();
        achievement_use_experience_pearcel = new Achievement("achievement.use_experience_pearcel", "use_experience_pearcel", 8, -6, new ItemStack(ModItems.experience_pearcel), (Achievement)null).initIndependentStat().registerStat();
        achievement_craft_ender_pearcel = new Achievement("achievement.craft_ender_pearcel", "craft_ender_pearcel", 10, -6, new ItemStack(ModItems.ender_pearcel), (Achievement)null).initIndependentStat().registerStat();
        achievement_use_tp_pearcel = new Achievement("achievement.use_tp_pearcel", "use_tp_pearcel", 10, -4, new ItemStack(ModItems.tp_pearcel), achievement_craft_ender_pearcel).registerStat();
        achievement_use_pepc = new Achievement("achievement.use_pepc", "use_pepc", 12, -6, new ItemStack(ModItems.pepc), (Achievement)null).initIndependentStat().registerStat();

        Achievement[] achievement_list = new Achievement[]{
                achievement_get_pearcel,
                achievement_craft_pearcel_ingot,
                achievement_craft_tier1_cc,
                achievement_craft_tier2_cc,
                achievement_craft_tier3_cc,
                achievement_craft_tier4_cc,
                achievement_craft_pcp,
                achievement_craft_pearcel_tools,
                achievement_craft_pearcel_armor_plating,
                achievement_craft_pearcel_armor,
                achievement_craft_pearcel_bread,
                achievement_use_experience_pearcel,
                achievement_craft_ender_pearcel,
                achievement_use_tp_pearcel,
                achievement_use_pepc
        };

        AchievementPage.registerAchievementPage(new AchievementPage(Reference.MOD_NAME, achievement_list));

        regAchieveEvents();
    }

    public static void regAchieveEvents(){
        MinecraftForge.EVENT_BUS.register(new ItemPickup());
        MinecraftForge.EVENT_BUS.register(new ItemCraft());
    }

}
