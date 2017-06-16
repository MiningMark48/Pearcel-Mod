package com.miningmark48.pearcelmod.init;

import com.miningmark48.pearcelmod.creativetabs.CreativeTabPearcelMod;
import com.miningmark48.pearcelmod.item.*;
import com.miningmark48.pearcelmod.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {

    public static Item.ToolMaterial matToolPearcel = EnumHelper.addToolMaterial("PearcelTools", 3, 1048, 15.0F, 10.0F, 20).setRepairItem(new ItemStack(ModItems.pearcel_ingot));
    public static Item.ToolMaterial matToolPearcelReinforced = EnumHelper.addToolMaterial("RIFPearcelTools", 3, 4096, 20.0F, 10.0F, 15).setRepairItem(new ItemStack(ModItems.pearcel_ingot));
    public static Item.ToolMaterial matToolPearcelStaff = EnumHelper.addToolMaterial("PearcelStaff", 3, 1500, 15.0F, 15.0F, 30).setRepairItem(new ItemStack(ModItems.pearcel_ingot));
    public static Item.ToolMaterial matToolGuardianPearcelStaff = EnumHelper.addToolMaterial("GuardianPearcelStaff", 3, 1500, 15.0F, 30.0F, 30).setRepairItem(new ItemStack(ModItems.pearcel_ingot));
    public static ItemArmor.ArmorMaterial matPearcel = EnumHelper.addArmorMaterial("pearcel", Reference.MOD_ID + ":" + "pearcel_armor", 100, new int[]{4, 7, 6, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 10);
    public static ItemArmor.ArmorMaterial matRIFPearcel = EnumHelper.addArmorMaterial("riPearcel", Reference.MOD_ID + ":" + "rif_pearcel_armor", 150, new int[]{5, 8, 7, 4}, 12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 12);

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
    public static Item pearcel_matter;
    public static Item neutral_pearcel_matter;
    public static Item pearcel_arrow;
    public static Item pearcel_star;
    public static Item blood_drop;

    //Food
    public static Item pearcel_item;
    public static Item pearcel_bread;
    public static Item pearcel_pie;
    public static Item pearcel_beef;
    public static Item pearcel_steak;
    public static Item pearcel_cookie;
    public static Item pearcel_sandwich;
    public static Item pearcel_juice_bottle;
    public static Item pearcel_infinifood;
    public static Item golden_pearcel;
    public static Item jeweled_pearcel;
    public static Item glowing_pearcel;
    public static Item guardian_food;

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
    public static Item guardian_pearcel_staff;
    public static Item pcp;
    public static Item ender_pearcel;
    public static Item pearcel_bow;
    public static Item pearcel_stone_placer;
    public static Item reinforced_pearcel_pickaxe;
    public static Item reinforced_pearcel_shovel;
    public static Item pearcel_crook;
    public static Item matter_fabricator;
    public static Item stimulation_pearcel;
    public static Item rif_pearcel_helmet;
    public static Item rif_pearcel_chestplate;
    public static Item rif_pearcel_leggings;
    public static Item rif_pearcel_boots;
    public static Item pearcel_backpack;
    public static Item enlarged_pearcel_backpack;
    public static Item bindle;
    public static Item nullification_pearcel;
    public static Item pearcel_magnet;
    public static Item living_magnet;
    public static Item sacrificial_pearcel;
    public static Item pearcel_blood_dagger;
    public static Item pearcel_manual;
    public static Item charmed_pearcel;
    public static Item charm_bag;
    public static Item slimey_pearcel;
    public static Item throw_pearcel_explosive;
    public static Item throw_pearcel_entity_tp;
    public static Item throw_pearcel_entity_firework;
    public static Item throw_pearcel_entity_mount;

    public static void init(){
        //General Items
        pearcel_ingot = new ItemPearcelMod().setUnlocalizedName("pearcel_ingot").setRegistryName("pearcel_ingot").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        tier_1_crafting_component = new ItemPearcelMod().setUnlocalizedName("tier_1_crafting_component").setRegistryName("tier_1_crafting_component").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        tier_2_crafting_component = new ItemPearcelMod().setUnlocalizedName("tier_2_crafting_component").setRegistryName("tier_2_crafting_component").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        tier_3_crafting_component = new ItemPearcelMod().setUnlocalizedName("tier_3_crafting_component").setRegistryName("tier_3_crafting_component").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        tier_4_crafting_component = new ItemPearcelModEffect().setUnlocalizedName("tier_4_crafting_component").setRegistryName("tier_4_crafting_component").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        armor_plating = new ItemPearcelMod().setUnlocalizedName("armor_plating").setRegistryName("armor_plating").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_flour = new ItemPearcelMod().setUnlocalizedName("pearcel_flour").setRegistryName("pearcel_flour").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_stick = new ItemPearcelMod().setUnlocalizedName("pearcel_stick").setRegistryName("pearcel_stick").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_charcoal = new ItemPearcelFuel().setUnlocalizedName("pearcel_charcoal").setRegistryName("pearcel_charcoal").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_matter = new ItemPearcelModEffect().setUnlocalizedName("pearcel_matter").setRegistryName("pearcel_matter").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        neutral_pearcel_matter = new ItemPearcelMod().setUnlocalizedName("neutral_pearcel_matter").setRegistryName("neutral_pearcel_matter").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_arrow = new ItemPearcelArrow().setUnlocalizedName("pearcel_arrow").setRegistryName("pearcel_arrow").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_star = new ItemPearcelModEffect().setUnlocalizedName("pearcel_star").setRegistryName("pearcel_star").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        blood_drop = new ItemPearcelMod().setUnlocalizedName("blood_drop").setRegistryName("blood_drop").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);

        //Food
        pearcel_item = new ItemPearcelFood(4, 0.5F, false).setUnlocalizedName("pearcel_item").setRegistryName("pearcel_item").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_bread = new ItemPearcelFood(8, 0.8F, false).setUnlocalizedName("pearcel_bread").setRegistryName("pearcel_bread").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_pie = new ItemPearcelFood(6, 0.3F, false).setUnlocalizedName("pearcel_pie").setRegistryName("pearcel_pie").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_beef = new ItemPearcelFood(1, 0.7F, true).setUnlocalizedName("pearcel_beef").setRegistryName("pearcel_beef").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_steak = new ItemPearcelFood(9, 1.5F, true).setUnlocalizedName("pearcel_steak").setRegistryName("pearcel_steak").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_cookie = new ItemPearcelFood(2, 0.1F, true).setUnlocalizedName("pearcel_cookie").setRegistryName("pearcel_cookie").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_sandwich = new ItemPearcelFood(9, 1.1F, true).setUnlocalizedName("pearcel_sandwich").setRegistryName("pearcel_sandwich").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_juice_bottle = new ItemPearcelJuiceBottle().setUnlocalizedName("pearcel_juice_bottle").setRegistryName("pearcel_juice_bottle").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_infinifood = new ItemPearcelFoodInfinite(10, 10.0F, false).setUnlocalizedName("pearcel_infinifood").setRegistryName("pearcel_infinifood").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        golden_pearcel = new ItemGoldenPearcel().setUnlocalizedName("golden_pearcel").setRegistryName("golden_pearcel").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        jeweled_pearcel = new ItemJeweledPearcel().setUnlocalizedName("jeweled_pearcel").setRegistryName("jeweled_pearcel").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        glowing_pearcel = new ItemGlowingPearcel().setUnlocalizedName("glowing_pearcel").setRegistryName("glowing_pearcel").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        guardian_food = new ItemGuardianFood().setUnlocalizedName("guardian_food").setRegistryName("guardian_food").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);

        //Tools and Armor
        pearcel_sword = new ItemPearcelSword(matToolPearcel).setUnlocalizedName("pearcel_sword").setRegistryName("pearcel_sword").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_pickaxe = new ItemPearcelPickaxe(matToolPearcel).setUnlocalizedName("pearcel_pickaxe").setRegistryName("pearcel_pickaxe").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_axe = new ItemPearcelAxe(Item.ToolMaterial.DIAMOND).setUnlocalizedName("pearcel_axe").setRegistryName("pearcel_axe").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_shovel = new ItemPearcelShovel(matToolPearcel).setUnlocalizedName("pearcel_shovel").setRegistryName("pearcel_shovel").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_hoe = new ItemPearcelHoe(matToolPearcel).setUnlocalizedName("pearcel_hoe").setRegistryName("pearcel_hoe").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_shears = new ItemPearcelShears().setUnlocalizedName("pearcel_shears").setRegistryName("pearcel_shears").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        experience_pearcel = new ItemExperiencePearcel().setUnlocalizedName("experience_pearcel").setRegistryName("experience_pearcel").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        tp_pearcel = new ItemTPPearcel(false).setUnlocalizedName("tp_pearcel").setRegistryName("tp_pearcel").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        sap = new ItemSAP().setUnlocalizedName("sap").setRegistryName("sap").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pepc = new ItemPEPC().setUnlocalizedName("pepc").setRegistryName("pepc").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_helmet = new ItemPearcelArmor(matPearcel, EntityEquipmentSlot.HEAD).setUnlocalizedName("pearcel_helmet").setRegistryName("pearcel_helmet").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_chestplate = new ItemPearcelArmor(matPearcel, EntityEquipmentSlot.CHEST).setUnlocalizedName("pearcel_chestplate").setRegistryName("pearcel_chestplate").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_leggings = new ItemPearcelArmor(matPearcel, EntityEquipmentSlot.LEGS).setUnlocalizedName("pearcel_leggings").setRegistryName("pearcel_leggings").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_boots = new ItemPearcelArmor(matPearcel, EntityEquipmentSlot.FEET).setUnlocalizedName("pearcel_boots").setRegistryName("pearcel_boots").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_staff = new ItemPearcelStaff(matToolPearcelStaff).setUnlocalizedName("pearcel_staff").setRegistryName("pearcel_staff").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        guardian_pearcel_staff = new ItemDragonPearcelStaff(matToolGuardianPearcelStaff).setUnlocalizedName("dragon_pearcel_staff").setRegistryName("dragon_pearcel_staff").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pcp = new ItemPCP().setUnlocalizedName("pcp").setRegistryName("pcp").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        ender_pearcel = new ItemEnderPearcel().setUnlocalizedName("ender_pearcel").setRegistryName("ender_pearcel").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_bow = new ItemPearcelBow().setUnlocalizedName("pearcel_bow").setRegistryName("pearcel_bow").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_stone_placer = new ItemPearcelBlockPlacer().setUnlocalizedName("pearcel_stone_placer").setRegistryName("pearcel_stone_placer").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        reinforced_pearcel_pickaxe = new ItemReinforcedPearcelPickaxe(matToolPearcelReinforced).setUnlocalizedName("reinforced_pearcel_pickaxe").setRegistryName("reinforced_pearcel_pickaxe").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        reinforced_pearcel_shovel = new ItemReinforcedPearcelShovel(matToolPearcelReinforced).setUnlocalizedName("reinforced_pearcel_shovel").setRegistryName("reinforced_pearcel_shovel").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_crook = new ItemPearcelCrook(Item.ToolMaterial.WOOD).setUnlocalizedName("pearcel_crook").setRegistryName("pearcel_crook").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        matter_fabricator = new ItemMatterFabricator(matToolPearcel).setUnlocalizedName("matter_fabricator").setRegistryName("matter_fabricator").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        stimulation_pearcel = new ItemStimulationPearcel().setUnlocalizedName("stimulation_pearcel").setRegistryName("stimulation_pearcel").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        rif_pearcel_helmet = new ItemRIFPearcelArmor(matRIFPearcel, EntityEquipmentSlot.HEAD).setUnlocalizedName("rif_pearcel_helmet").setRegistryName("rif_pearcel_helmet").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        rif_pearcel_chestplate = new ItemRIFPearcelArmor(matRIFPearcel, EntityEquipmentSlot.CHEST).setUnlocalizedName("rif_pearcel_chestplate").setRegistryName("rif_pearcel_chestplate").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        rif_pearcel_leggings = new ItemRIFPearcelArmor(matRIFPearcel, EntityEquipmentSlot.LEGS).setUnlocalizedName("rif_pearcel_leggings").setRegistryName("rif_pearcel_leggings").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        rif_pearcel_boots = new ItemRIFPearcelArmor(matRIFPearcel, EntityEquipmentSlot.FEET).setUnlocalizedName("rif_pearcel_boots").setRegistryName("rif_pearcel_boots").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_backpack = new ItemPearcelBackpack().setUnlocalizedName("pearcel_backpack").setRegistryName("pearcel_backpack").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        enlarged_pearcel_backpack = new ItemEnlargedPearcelBackpack().setUnlocalizedName("enlarged_pearcel_backpack").setRegistryName("enlarged_pearcel_backpack").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        bindle = new ItemBindle().setUnlocalizedName("bindle").setRegistryName("bindle").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        nullification_pearcel = new ItemNullificationPearcel().setUnlocalizedName("nullification_pearcel").setRegistryName("nullification_pearcel").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_magnet = new ItemPearcelMagnet().setUnlocalizedName("pearcel_magnet").setRegistryName("pearcel_magnet").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        living_magnet = new ItemLivingMagnet().setUnlocalizedName("living_magnet").setRegistryName("living_magnet").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        sacrificial_pearcel = new ItemPearcelMod().setUnlocalizedName("sacrificial_pearcel").setRegistryName("sacrificial_pearcel").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setMaxStackSize(1);
        pearcel_blood_dagger = new ItemBloodSword(matToolPearcel).setUnlocalizedName("pearcel_blood_dagger").setRegistryName("pearcel_blood_dagger").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        pearcel_manual = new ItemManual().setUnlocalizedName("pearcel_manual").setRegistryName("pearcel_manual").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        charmed_pearcel = new ItemCharmedPearcel().setUnlocalizedName("charmed_pearcel").setRegistryName("charmed_pearcel").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        charm_bag = new ItemCharmBag().setUnlocalizedName("charm_bag").setRegistryName("charm_bag").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        slimey_pearcel = new ItemSlimeyPearcel().setUnlocalizedName("slimey_pearcel").setRegistryName("slimey_pearcel").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        throw_pearcel_explosive = new ItemThrowPearcel(ItemThrowPearcel.TYPE.EXPLOSIVE, 32).setUnlocalizedName("throw_pearcel_explosive").setRegistryName("throw_pearcel_explosive").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        throw_pearcel_entity_tp = new ItemThrowPearcel(ItemThrowPearcel.TYPE.ENTITY_TP, 32).setUnlocalizedName("throw_pearcel_entity_tp").setRegistryName("throw_pearcel_entity_tp").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        throw_pearcel_entity_firework = new ItemThrowPearcel(ItemThrowPearcel.TYPE.ENTITY_LAUNCH, 32).setUnlocalizedName("throw_pearcel_entity_firework").setRegistryName("throw_pearcel_entity_firework").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
        throw_pearcel_entity_mount = new ItemThrowPearcel(ItemThrowPearcel.TYPE.ENTITY_MOUNT, 32).setUnlocalizedName("throw_pearcel_entity_mount").setRegistryName("throw_pearcel_entity_mount").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);

    }

    public static void register(){
        GameRegistry.register(pearcel_manual);
        GameRegistry.register(pearcel_item);
        GameRegistry.register(pearcel_ingot);
        GameRegistry.register(tier_1_crafting_component);
        GameRegistry.register(tier_2_crafting_component);
        GameRegistry.register(tier_3_crafting_component);
        GameRegistry.register(tier_4_crafting_component);
        GameRegistry.register(armor_plating);
        GameRegistry.register(pearcel_flour);
        GameRegistry.register(pearcel_stick);
        GameRegistry.register(pearcel_charcoal);
        GameRegistry.register(pearcel_matter);
        GameRegistry.register(neutral_pearcel_matter);
        GameRegistry.register(pearcel_arrow);
        GameRegistry.register(pearcel_star);
        GameRegistry.register(blood_drop);

        GameRegistry.register(pearcel_bread);
        GameRegistry.register(pearcel_pie);
        GameRegistry.register(pearcel_beef);
        GameRegistry.register(pearcel_steak);
        GameRegistry.register(pearcel_cookie);
        GameRegistry.register(pearcel_sandwich);
        GameRegistry.register(pearcel_juice_bottle);
        GameRegistry.register(pearcel_infinifood);
        GameRegistry.register(golden_pearcel);
        GameRegistry.register(jeweled_pearcel);
        GameRegistry.register(glowing_pearcel);
        GameRegistry.register(guardian_food);

        GameRegistry.register(pearcel_sword);
        GameRegistry.register(pearcel_pickaxe);
        GameRegistry.register(pearcel_axe);
        GameRegistry.register(pearcel_shovel);
        GameRegistry.register(pearcel_hoe);
        GameRegistry.register(pearcel_shears);
        GameRegistry.register(experience_pearcel);
        GameRegistry.register(tp_pearcel);
        GameRegistry.register(sap);
        GameRegistry.register(pepc);
        GameRegistry.register(pearcel_helmet);
        GameRegistry.register(pearcel_chestplate);
        GameRegistry.register(pearcel_leggings);
        GameRegistry.register(pearcel_boots);
        GameRegistry.register(pearcel_staff);
        GameRegistry.register(guardian_pearcel_staff);
        GameRegistry.register(pcp);
        GameRegistry.register(ender_pearcel);
        GameRegistry.register(pearcel_bow);
        GameRegistry.register(pearcel_stone_placer);
        GameRegistry.register(reinforced_pearcel_pickaxe);
        GameRegistry.register(reinforced_pearcel_shovel);
        GameRegistry.register(pearcel_crook);
        GameRegistry.register(matter_fabricator);
        GameRegistry.register(stimulation_pearcel);
        GameRegistry.register(rif_pearcel_helmet);
        GameRegistry.register(rif_pearcel_chestplate);
        GameRegistry.register(rif_pearcel_leggings);
        GameRegistry.register(rif_pearcel_boots);
        GameRegistry.register(pearcel_backpack);
        GameRegistry.register(enlarged_pearcel_backpack);
        GameRegistry.register(bindle);
        GameRegistry.register(nullification_pearcel);
        GameRegistry.register(pearcel_magnet);
        GameRegistry.register(living_magnet);
        GameRegistry.register(sacrificial_pearcel);
        GameRegistry.register(pearcel_blood_dagger);
        GameRegistry.register(charmed_pearcel);
        GameRegistry.register(charm_bag);
        GameRegistry.register(slimey_pearcel);
        GameRegistry.register(throw_pearcel_explosive);
        GameRegistry.register(throw_pearcel_entity_tp);
        GameRegistry.register(throw_pearcel_entity_firework);
        GameRegistry.register(throw_pearcel_entity_mount);

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
        registerRender(pearcel_matter);
        registerRender(neutral_pearcel_matter);
        registerRender(pearcel_arrow);
        registerRender(pearcel_star);
        registerRender(blood_drop);

        //Food
        registerRender(pearcel_item);
        registerRender(pearcel_bread);
        registerRender(pearcel_pie);
        registerRender(pearcel_beef);
        registerRender(pearcel_steak);
        registerRender(pearcel_cookie);
        registerRender(pearcel_sandwich);
        registerRender(pearcel_juice_bottle);
        registerRender(pearcel_infinifood);
        registerRender(golden_pearcel);
        registerRender(jeweled_pearcel);
        registerRender(glowing_pearcel);
        registerRender(guardian_food);

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
        registerRender(pcp);
        registerRender(ender_pearcel);
        registerRender(pearcel_bow);
        registerRender(pearcel_bow, 1, "pearcel_bow_pulling_1");
        registerRender(pearcel_bow, 2, "pearcel_bow_pulling_2");
        registerRender(pearcel_bow, 3, "pearcel_bow_pulling_3");
        registerRender(pearcel_stone_placer);
        registerRender(reinforced_pearcel_pickaxe);
        registerRender(reinforced_pearcel_shovel);
        registerRender(pearcel_crook);
        registerRender(matter_fabricator);
        registerRender(stimulation_pearcel);
        registerRender(rif_pearcel_helmet);
        registerRender(rif_pearcel_chestplate);
        registerRender(rif_pearcel_leggings);
        registerRender(rif_pearcel_boots);
        registerRender(pearcel_backpack);
        registerRender(enlarged_pearcel_backpack);
        registerRender(bindle);
        registerRender(nullification_pearcel);
        registerRender(pearcel_magnet);
        registerRender(living_magnet);
        registerRender(sacrificial_pearcel);
        registerRender(pearcel_blood_dagger);
        registerRender(pearcel_manual);
        registerRender(charmed_pearcel);
        registerRender(charm_bag);
        registerRender(slimey_pearcel);
        registerRender(throw_pearcel_explosive);
        registerRender(throw_pearcel_entity_tp);
        registerRender(throw_pearcel_entity_firework);
        registerRender(throw_pearcel_entity_mount);

        //ModelBakery.registerItemVariants(pearcel_bow, new ResourceLocation[]{new ModelResourceLocation(Reference.MOD_ID + ":pearcel_bow", "inventory"), new ModelResourceLocation(Reference.MOD_ID + ":pearcel_bow_pulling_1", "inventory"), new ModelResourceLocation(Reference.MOD_ID + ":pearcel_bow_pulling_2", "inventory"), new ModelResourceLocation(Reference.MOD_ID + ":pearcel_bow_pulling_3", "inventory")});
    }


    public static void registerRender(Item item){
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }

    public static void registerRender(Item item, int meta, String name){
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(Reference.MOD_ID + ":" + name, "inventory"));
    }


}