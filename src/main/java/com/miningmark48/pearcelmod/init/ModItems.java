package com.miningmark48.pearcelmod.init;

import com.miningmark48.pearcelmod.creativetabs.CreativeTabPearcelMod;
import com.miningmark48.pearcelmod.item.*;
import com.miningmark48.pearcelmod.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {

    public static Item.ToolMaterial matToolPearcel = EnumHelper.addToolMaterial("PearcelTools", 3, 1000, 15.0F, 5.0F, 20);
    public static Item.ToolMaterial matToolPearcelStaff = EnumHelper.addToolMaterial("PearcelStaff", 3, 1500, 15.0F, 10.0F, 30);
    public static ItemArmor.ArmorMaterial matPearcel = EnumHelper.addArmorMaterial("PearcelArmor", Reference.MOD_ID + ":" + "pearcel", 100, new int[]{3, 6, 5, 2}, 10);

    //General Items
    public static Item pearcel_ingot;
    public static Item tier_1_crafting_component;
    public static Item tier_2_crafting_component;
    public static Item tier_3_crafting_component;
    public static Item tier_4_crafting_component;
    public static Item armor_plating;
    public static Item pearcel_flour;
    public static Item pearcel_stick;
    public static Item pearcel_charcoal;
    public static Item pearcel_seeds;
    public static Item pearcel_matter;
    public static Item neutral_pearcel_matter;

    //Food
    public static Item pearcel_item;
    public static Item pearcel_bread;
    public static Item pearcel_pie;
    public static Item pearcel_beef;
    public static Item pearcel_steak;
    public static Item pearcel_cookie;
    public static Item pearcel_sandwich;

    //Tools and Armor
    public static Item pearcel_sword;
    public static Item pearcel_pickaxe;
    public static Item pearcel_axe;
    public static Item pearcel_shovel;
    public static Item pearcel_hoe;
    public static Item pearcel_shears;
    public static Item experience_pearcel;
    public static Item tp_pearcel;
    public static Item sap;
    public static Item pepc;
    public static Item pearcel_helmet;
    public static Item pearcel_chestplate;
    public static Item pearcel_leggings;
    public static Item pearcel_boots;
    public static Item pearcel_staff;
    public static Item dragon_pearcel_staff;

    public static void init(){
        //General Items
        pearcel_ingot = new ItemPearcelMod().setUnlocalizedName("pearcel_ingot").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        tier_1_crafting_component = new ItemPearcelMod().setUnlocalizedName("tier_1_crafting_component").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        tier_2_crafting_component = new ItemPearcelMod().setUnlocalizedName("tier_2_crafting_component").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        tier_3_crafting_component = new ItemPearcelMod().setUnlocalizedName("tier_3_crafting_component").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        tier_4_crafting_component = new ItemPearcelMod().setUnlocalizedName("tier_4_crafting_component").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        armor_plating = new ItemPearcelMod().setUnlocalizedName("armor_plating").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_flour = new ItemPearcelMod().setUnlocalizedName("pearcel_flour").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_stick = new ItemPearcelMod().setUnlocalizedName("pearcel_stick").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_charcoal = new ItemPearcelFuel().setUnlocalizedName("pearcel_charcoal").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_seeds = new ItemPearcelSeeds(ModBlocks.pearcel_crops, Blocks.farmland).setUnlocalizedName("pearcel_seeds").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_matter = new ItemPearcelMod().setUnlocalizedName("pearcel_matter").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        neutral_pearcel_matter = new ItemPearcelMod().setUnlocalizedName("neutral_pearcel_matter").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);

        //Food
        pearcel_item = new ItemPearcelFood(4, 0.5F, false).setUnlocalizedName("pearcel_item").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_bread = new ItemPearcelFood(8, 0.8F, false).setUnlocalizedName("pearcel_bread").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_pie = new ItemPearcelFood(6, 0.3F, false).setUnlocalizedName("pearcel_pie").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_beef = new ItemPearcelFood(1, 0.7F, true).setUnlocalizedName("pearcel_beef").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_steak = new ItemPearcelFood(9, 1.5F, true).setUnlocalizedName("pearcel_steak").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_cookie = new ItemPearcelFood(2, 0.1F, true).setUnlocalizedName("pearcel_cookie").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_sandwich = new ItemPearcelFood(9, 1.1F, true).setUnlocalizedName("pearcel_sandwich").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);


        //Tools and Armor
        pearcel_sword = new ItemPearcelSword(matToolPearcel).setUnlocalizedName("pearcel_sword").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_pickaxe = new ItemPearcelPickaxe(matToolPearcel).setUnlocalizedName("pearcel_pickaxe").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_axe = new ItemPearcelAxe(matToolPearcel).setUnlocalizedName("pearcel_axe").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_shovel = new ItemPearcelShovel(matToolPearcel).setUnlocalizedName("pearcel_shovel").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_hoe = new ItemPearcelHoe(matToolPearcel).setUnlocalizedName("pearcel_hoe").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_shears = new ItemPearcelShears().setUnlocalizedName("pearcel_shears").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        experience_pearcel = new ItemExperiencePearcel().setUnlocalizedName("experience_pearcel").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        tp_pearcel = new ItemTPPearcel().setUnlocalizedName("tp_pearcel").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        sap = new ItemSAP().setUnlocalizedName("sap").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pepc = new ItemPEPC().setUnlocalizedName("pepc").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_helmet = new ItemPearcelArmor(matPearcel, 0).setUnlocalizedName("pearcel_helmet").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_chestplate = new ItemPearcelArmor(matPearcel, 1).setUnlocalizedName("pearcel_chestplate").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_leggings = new ItemPearcelArmor(matPearcel, 2).setUnlocalizedName("pearcel_leggings").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_boots = new ItemPearcelArmor(matPearcel, 3).setUnlocalizedName("pearcel_boots").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_staff = new ItemPearcelStaff(matToolPearcelStaff).setUnlocalizedName("pearcel_staff").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        dragon_pearcel_staff = new ItemDragonPearcelStaff(matToolPearcelStaff).setUnlocalizedName("dragon_pearcel_staff").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    }

    public static void register(){
        //General Items
        GameRegistry.registerItem(pearcel_ingot, pearcel_ingot.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(tier_1_crafting_component, tier_1_crafting_component.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(tier_2_crafting_component, tier_2_crafting_component.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(tier_3_crafting_component, tier_3_crafting_component.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(tier_4_crafting_component, tier_4_crafting_component.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(armor_plating, armor_plating.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(pearcel_flour, pearcel_flour.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(pearcel_stick, pearcel_stick.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(pearcel_charcoal, pearcel_charcoal.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(pearcel_seeds, pearcel_seeds.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(pearcel_matter, pearcel_matter.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(neutral_pearcel_matter, neutral_pearcel_matter.getUnlocalizedName().substring(5));

        //Food
        GameRegistry.registerItem(pearcel_item, pearcel_item.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(pearcel_bread, pearcel_bread.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(pearcel_pie, pearcel_pie.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(pearcel_beef, pearcel_beef.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(pearcel_steak, pearcel_steak.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(pearcel_cookie, pearcel_cookie.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(pearcel_sandwich, pearcel_sandwich.getUnlocalizedName().substring(5));

        //Tools and Armor
        GameRegistry.registerItem(pearcel_sword, pearcel_sword.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(pearcel_pickaxe, pearcel_pickaxe.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(pearcel_axe, pearcel_axe.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(pearcel_shovel, pearcel_shovel.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(pearcel_hoe, pearcel_hoe.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(pearcel_shears, pearcel_shears.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(experience_pearcel, experience_pearcel.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(tp_pearcel, tp_pearcel.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(sap, sap.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(pepc, pepc.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(pearcel_helmet, pearcel_helmet.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(pearcel_chestplate, pearcel_chestplate.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(pearcel_leggings, pearcel_leggings.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(pearcel_boots, pearcel_boots.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(pearcel_staff, pearcel_staff.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(dragon_pearcel_staff, dragon_pearcel_staff.getUnlocalizedName().substring(5));
    }

    public static void registerRenders(){
        //General Items
        registerRender(pearcel_ingot);
        registerRender(tier_1_crafting_component);
        registerRender(tier_2_crafting_component);
        registerRender(tier_3_crafting_component);
        registerRender(tier_4_crafting_component);
        registerRender(armor_plating);
        registerRender(pearcel_flour);
        registerRender(pearcel_stick);
        registerRender(pearcel_charcoal);
        registerRender(pearcel_seeds);
        registerRender(pearcel_matter);
        registerRender(neutral_pearcel_matter);

        //Food
        registerRender(pearcel_item);
        registerRender(pearcel_bread);
        registerRender(pearcel_pie);
        registerRender(pearcel_beef);
        registerRender(pearcel_steak);
        registerRender(pearcel_cookie);
        registerRender(pearcel_sandwich);

        //Tools and Armor
        registerRender(pearcel_sword);
        registerRender(pearcel_pickaxe);
        registerRender(pearcel_axe);
        registerRender(pearcel_shovel);
        registerRender(pearcel_hoe);
        registerRender(pearcel_shears);
        registerRender(experience_pearcel);
        registerRender(tp_pearcel);
        registerRender(sap);
        registerRender(pepc);
        registerRender(pearcel_helmet);
        registerRender(pearcel_chestplate);
        registerRender(pearcel_leggings);
        registerRender(pearcel_boots);
        registerRender(pearcel_staff);
        registerRender(dragon_pearcel_staff);
    }

    public static void registerRender(Item item){
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }

}
