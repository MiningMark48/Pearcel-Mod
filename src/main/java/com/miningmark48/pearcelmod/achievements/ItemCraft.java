package com.miningmark48.pearcelmod.achievements;

import com.miningmark48.pearcelmod.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class ItemCraft {

    @SubscribeEvent
    public void onItemCraft(PlayerEvent.ItemCraftedEvent e){
        ItemStack stack = e.crafting;
        EntityPlayer player = e.player;

        if(stack.isItemEqual(new ItemStack(ModItems.pearcel_ingot))){
            player.addStat(Achievements.achievement_craft_pearcel_ingot);
        }
        if(stack.isItemEqual(new ItemStack(ModItems.tier_1_crafting_component))){
            player.addStat(Achievements.achievement_craft_tier1_cc);
        }
        if(stack.isItemEqual(new ItemStack(ModItems.tier_2_crafting_component))){
            player.addStat(Achievements.achievement_craft_tier2_cc);
        }
        if(stack.isItemEqual(new ItemStack(ModItems.tier_3_crafting_component))){
            player.addStat(Achievements.achievement_craft_tier3_cc);
        }
        if(stack.isItemEqual(new ItemStack(ModItems.tier_4_crafting_component))){
            player.addStat(Achievements.achievement_craft_tier4_cc);
        }
        if(stack.isItemEqual(new ItemStack(ModItems.pcp))){
            player.addStat(Achievements.achievement_craft_pcp);
        }
        if(stack.isItemEqual(new ItemStack(ModItems.pearcel_sword))){
            player.addStat(Achievements.achievement_craft_pearcel_tools);
        }
        if(stack.isItemEqual(new ItemStack(ModItems.pearcel_pickaxe))){
            player.addStat(Achievements.achievement_craft_pearcel_tools);
        }
        if(stack.isItemEqual(new ItemStack(ModItems.pearcel_axe))){
            player.addStat(Achievements.achievement_craft_pearcel_tools);
        }
        if(stack.isItemEqual(new ItemStack(ModItems.pearcel_shovel))){
            player.addStat(Achievements.achievement_craft_pearcel_tools);
        }
        if(stack.isItemEqual(new ItemStack(ModItems.pearcel_hoe))){
            player.addStat(Achievements.achievement_craft_pearcel_tools);
        }
        if(stack.isItemEqual(new ItemStack(ModItems.pearcel_shears))){
            player.addStat(Achievements.achievement_craft_pearcel_tools);
        }
        if(stack.isItemEqual(new ItemStack(ModItems.pearcel_bow))){
            player.addStat(Achievements.achievement_craft_pearcel_tools);
        }
        if(stack.isItemEqual(new ItemStack(ModItems.pearcel_arrow))){
            player.addStat(Achievements.achievement_craft_pearcel_tools);
        }
        if(stack.isItemEqual(new ItemStack(ModItems.armor_plating))){
            player.addStat(Achievements.achievement_craft_pearcel_armor_plating);
        }
        if(stack.isItemEqual(new ItemStack(ModItems.pearcel_helmet))){
            player.addStat(Achievements.achievement_craft_pearcel_armor);
        }
        if(stack.isItemEqual(new ItemStack(ModItems.pearcel_chestplate))){
            player.addStat(Achievements.achievement_craft_pearcel_armor);
        }
        if(stack.isItemEqual(new ItemStack(ModItems.pearcel_leggings))){
            player.addStat(Achievements.achievement_craft_pearcel_armor);
        }
        if(stack.isItemEqual(new ItemStack(ModItems.pearcel_boots))){
            player.addStat(Achievements.achievement_craft_pearcel_armor);
        }
        if(stack.isItemEqual(new ItemStack(ModItems.pearcel_bread))){
            player.addStat(Achievements.achievement_craft_pearcel_bread);
        }
        if(stack.isItemEqual(new ItemStack(ModItems.ender_pearcel))){
            player.addStat(Achievements.achievement_craft_ender_pearcel);
        }

    }

}
