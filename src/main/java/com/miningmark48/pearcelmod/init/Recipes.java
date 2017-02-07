package com.miningmark48.pearcelmod.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.capability.templates.FluidHandlerItemStackSimple;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class Recipes {
    
    public static void init(){
        //Items
        GameRegistry.addSmelting(new ItemStack(ModBlocks.ender_pearcel_ore), new ItemStack(ModItems.pearcel_ingot, 4), 15f);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.nether_pearcel_ore), new ItemStack(ModItems.pearcel_ingot, 2), 10f);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.pearcel_ore), new ItemStack(ModItems.pearcel_ingot, 1), 5f);
        GameRegistry.addSmelting(new ItemStack(ModItems.pearcel_beef), new ItemStack(ModItems.pearcel_steak), 10f);
        GameRegistry.addSmelting(new ItemStack(ModItems.pearcel_flour), new ItemStack(ModItems.pearcel_bread), 10f);
        GameRegistry.addSmelting(new ItemStack(ModItems.pearcel_item), new ItemStack(ModItems.pearcel_charcoal), 10f);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.pearcel_block), new ItemStack(ModBlocks.pearcel_charcoal_block, 1), 5f);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.pearcel_matter_ore), new ItemStack(ModItems.neutral_pearcel_matter, 1), 50F);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.dense_pearcel_ore), new ItemStack(ModItems.pearcel_ingot, 4), 20F);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.dense_pearcel_matter_ore), new ItemStack(ModItems.neutral_pearcel_matter, 4), 100F);
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel_pie), new ItemStack(ModItems.pearcel_flour), new ItemStack(ModItems.pearcel_item), new ItemStack(Items.EGG));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel_sandwich), new ItemStack(ModItems.pearcel_item), new ItemStack(ModItems.pearcel_bread), new ItemStack(Items.SUGAR));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel_item, 9), new ItemStack(ModBlocks.pearcel_block));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel_juice_bottle), new ItemStack(Items.GLASS_BOTTLE), new ItemStack(ModItems.pearcel_item), new ItemStack(Items.SUGAR));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel_cookie, 12), new ItemStack(Items.EGG), new ItemStack(ModItems.pearcel_flour), new ItemStack(Items.SUGAR), new ItemStack(Items.MILK_BUCKET));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel_beef, 2), new ItemStack(ModItems.pearcel_item), new ItemStack(Items.BEEF));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel_ingot), new ItemStack(ModItems.pearcel_item), new ItemStack(Items.IRON_INGOT));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel_ingot, 9), new ItemStack(ModBlocks.pearcel_ingot_block));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel_flour), new ItemStack(ModItems.pearcel_item));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ender_pearcel, 2), new ItemStack(ModBlocks.ender_pearcel_block));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel_star), new ItemStack(Items.NETHER_STAR), new ItemStack(ModItems.pearcel_item), new ItemStack(ModItems.pearcel_matter), new ItemStack(ModItems.pearcel_ingot));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel_manual), new ItemStack(Items.BOOK), new ItemStack(ModItems.pearcel_item));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel_manual), new ItemStack(Items.BOOK), new ItemStack(ModItems.pearcel_ingot));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_stick, 6), "x", "x", 'x', new ItemStack(ModItems.pearcel_item));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_stick, 4), "x", "x", 'x', new ItemStack(ModBlocks.pearcel_planks));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_cookie, 4), " x ", "xyx", " x ", 'x', new ItemStack(ModItems.pearcel_item), 'y', new ItemStack(Items.COOKIE));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_infinifood), "xax", "yzy", "xbx", 'x', new ItemStack(ModItems.pearcel_matter), 'y', new ItemStack(ModItems.pearcel_item), 'z', new ItemStack(ModItems.tier_3_crafting_component), 'a', new ItemStack(ModItems.pearcel_bread), 'b', new ItemStack(ModItems.golden_pearcel));
        GameRegistry.addRecipe(new ItemStack(ModItems.golden_pearcel), "xzx", "xyx", "xzx", 'x', new ItemStack(Items.GOLD_INGOT), 'y', new ItemStack(ModItems.pearcel_item), 'z', new ItemStack(Blocks.GOLD_BLOCK));
        GameRegistry.addRecipe(new ItemStack(ModItems.glowing_pearcel), " x ", "xyx", " x ", 'x', new ItemStack(Items.GLOWSTONE_DUST), 'y', new ItemStack(ModItems.pearcel_item));
        GameRegistry.addRecipe(new ItemStack(ModItems.armor_plating, 8), "xyx", "yzy", "xyx", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(Items.IRON_INGOT), 'z', new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.tier_1_crafting_component, 2), "xyx", "yzy", "xyx", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(Items.STICK), 'z', new ItemStack(ModItems.pearcel_item));
        GameRegistry.addRecipe(new ItemStack(ModItems.tier_2_crafting_component, 4), "xyx", "yzy", "xyx", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(Items.IRON_INGOT), 'z', new ItemStack(ModItems.tier_1_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.tier_3_crafting_component, 6), "xyx", "yzy", "xyx", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(Items.DIAMOND), 'z', new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.tier_4_crafting_component, 8), "xyx", "yzy", "xyx", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(ModItems.pearcel_star), 'z', new ItemStack(ModItems.tier_3_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.tier_2_crafting_component, 1), "xyx", "zzz", "xzx", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(Items.REDSTONE), 'z', new ItemStack(ModItems.tier_1_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.tier_3_crafting_component, 2), "xyx", "zzz", "xzx", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(Items.DIAMOND), 'z', new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.tier_4_crafting_component, 3), "xyx", "zzz", "xzx", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(ModItems.pearcel_star), 'z', new ItemStack(ModItems.tier_3_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.neutral_pearcel_matter, 4), "xyx", "yzy", "xyx", 'x', new ItemStack(Items.DIAMOND), 'y', new ItemStack(ModItems.pearcel_ingot), 'z', new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.neutral_pearcel_matter, 8), "xyx", "yzy", "xyx", 'x', new ItemStack(Items.DIAMOND), 'y', new ItemStack(ModItems.pearcel_ingot), 'z', new ItemStack(ModItems.tier_3_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.neutral_pearcel_matter, 16), "xyx", "yzy", "xyx", 'x', new ItemStack(Items.DIAMOND), 'y', new ItemStack(ModItems.pearcel_ingot), 'z', new ItemStack(ModItems.tier_4_crafting_component));

        //Tools and Weapons, Armor
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_sword), "x", "z", "y", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(ModItems.pearcel_stick), 'z', new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_pickaxe), "xzx", " y ", " y ", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(ModItems.pearcel_stick), 'z', new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_axe), "zx", "xy", " y", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(ModItems.pearcel_stick), 'z', new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_shovel), "x", "y", "z", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(ModItems.pearcel_stick), 'z', new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_hoe), "xz", " y", " y", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(ModItems.pearcel_stick), 'z', new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_shears), "  x", "yx ", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_bow), " xy", "z y", " xy", 'x', new ItemStack(ModItems.pearcel_stick), 'y', new ItemStack(Items.STRING), 'z', new ItemStack(ModItems.tier_3_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_arrow), "x", "y", "z", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(ModItems.pearcel_stick), 'z', new ItemStack(ModItems.tier_3_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.pcp), "zxa", "xyx", "axz", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(ModBlocks.pearcel_workbench), 'z', new ItemStack(ModItems.tier_1_crafting_component), 'a', new ItemStack(ModItems.pearcel_item));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_staff), "  x", "zy ", "bz ", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(ModItems.pearcel_stick), 'z', new ItemStack(ModItems.pearcel_matter), 'b', new ItemStack(ModItems.tier_3_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_helmet), "xyx", "y y", 'x', new ItemStack(ModItems.armor_plating), 'y', new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_chestplate), "y y", "xyx", "xxx", 'x', new ItemStack(ModItems.armor_plating), 'y', new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_leggings), "xyx", "x x", "y y", 'x', new ItemStack(ModItems.armor_plating), 'y', new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_boots), "y y", "xyx", 'x', new ItemStack(ModItems.armor_plating), 'y', new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.sap), "xab", "yzy", "bax", 'x', new ItemStack(Items.DIAMOND), 'y', new ItemStack(Items.EMERALD), 'z', new ItemStack(ModItems.tier_3_crafting_component), 'a', new ItemStack(Items.GOLD_INGOT), 'b', new ItemStack(ModItems.pearcel_item));
        GameRegistry.addRecipe(new ItemStack(ModItems.ender_pearcel), "xyx", "aza", "xyx", 'x', new ItemStack(ModItems.pearcel_item), 'y', new ItemStack(Items.ENDER_PEARL), 'z', new ItemStack(ModItems.tier_3_crafting_component), 'a', new ItemStack(ModItems.pearcel_ingot));
        GameRegistry.addRecipe(new ItemStack(ModItems.tp_pearcel), "xyx", "yzy", "xyx", 'x', new ItemStack(ModItems.pearcel_item), 'y', new ItemStack(Items.DIAMOND), 'z', new ItemStack(ModItems.ender_pearcel));
        GameRegistry.addRecipe(new ItemStack(ModItems.dragon_pearcel_staff), "xbx", "xyx", "zaz", 'x', new ItemStack(ModItems.tier_4_crafting_component), 'y', new ItemStack(ModItems.pearcel_staff), 'z', new ItemStack(ModItems.tier_3_crafting_component), 'a', new ItemStack(ModItems.pearcel_star), 'b', new ItemStack(ModBlocks.tainted_pearcel));
        GameRegistry.addRecipe(new ItemStack(ModItems.pepc), "xyx", "aza", "yby", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(ModItems.tier_3_crafting_component), 'z', new ItemStack(Blocks.ENDER_CHEST), 'a', new ItemStack(ModItems.pearcel_item), 'b', new ItemStack(ModItems.ender_pearcel));
        GameRegistry.addRecipe(new ItemStack(ModItems.experience_pearcel), "xyx", "aba", "xzx", 'x', new ItemStack(ModItems.pearcel_ingot), 'y', new ItemStack(ModItems.tier_3_crafting_component), 'z', new ItemStack(Items.EMERALD), 'a', new ItemStack(Items.DIAMOND), 'b', new ItemStack(ModItems.pearcel_item));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_stone_placer), "xyx", "acb", "xzx", 'x', new ItemStack(ModItems.pearcel_item), 'y', new ItemStack(ModBlocks.pearcel_stone), 'z', new ItemStack(ModBlocks.pearcel_cobblestone), 'a', new ItemStack(Items.LAVA_BUCKET), 'b', new ItemStack(Items.WATER_BUCKET), 'c', new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.reinforced_pearcel_pickaxe), "xyx", " z ", " a ", 'x', new ItemStack(Items.DIAMOND), 'y', new ItemStack(ModItems.tier_3_crafting_component), 'z', new ItemStack(ModItems.pearcel_pickaxe), 'a', new ItemStack(ModItems.pearcel_stick));
        GameRegistry.addRecipe(new ItemStack(ModItems.reinforced_pearcel_shovel), " x ", " y ", " z ", 'x', new ItemStack(Items.DIAMOND), 'y', new ItemStack(ModItems.tier_3_crafting_component), 'z', new ItemStack(ModItems.pearcel_shovel));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_crook), "xx", " x", " x", 'x', new ItemStack(ModItems.pearcel_stick));
        GameRegistry.addRecipe(new ItemStack(ModItems.matter_fabricator), "ayx", " z ", " z ", 'x', new ItemStack(ModBlocks.pearcel_block), 'y', new ItemStack(ModItems.pearcel_pickaxe), 'z', new ItemStack(ModItems.pearcel_stick), 'a', new ItemStack(ModItems.tier_3_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.stimulation_pearcel), "xyx", "yzy", "xyx", 'x', new ItemStack(ModItems.pearcel_item), 'y', new ItemStack(ModItems.tier_3_crafting_component), 'z', new ItemStack(Items.CLOCK));
        GameRegistry.addRecipe(new ItemStack(ModItems.rif_pearcel_helmet), "aza", "zyz", "xzx", 'x', new ItemStack(ModItems.tier_3_crafting_component), 'y', new ItemStack(ModItems.pearcel_helmet), 'z', new ItemStack(ModItems.armor_plating), 'a', new ItemStack(ModItems.pearcel_matter));
        GameRegistry.addRecipe(new ItemStack(ModItems.rif_pearcel_chestplate), "aza", "zyz", "xzx", 'x', new ItemStack(ModItems.tier_3_crafting_component), 'y', new ItemStack(ModItems.pearcel_chestplate), 'z', new ItemStack(ModItems.armor_plating), 'a', new ItemStack(ModItems.pearcel_matter));
        GameRegistry.addRecipe(new ItemStack(ModItems.rif_pearcel_leggings), "aza", "zyz", "xzx", 'x', new ItemStack(ModItems.tier_3_crafting_component), 'y', new ItemStack(ModItems.pearcel_leggings), 'z', new ItemStack(ModItems.armor_plating), 'a', new ItemStack(ModItems.pearcel_matter));
        GameRegistry.addRecipe(new ItemStack(ModItems.rif_pearcel_boots), "aza", "zyz", "xzx", 'x', new ItemStack(ModItems.tier_3_crafting_component), 'y', new ItemStack(ModItems.pearcel_boots), 'z', new ItemStack(ModItems.armor_plating), 'a', new ItemStack(ModItems.pearcel_matter));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_backpack), "xax", "zyz", "axa", 'x', new ItemStack(ModItems.pearcel_item), 'y', new ItemStack(ModItems.tier_2_crafting_component), 'z', new ItemStack(Blocks.CHEST), 'a', new ItemStack(Blocks.WOOL));
        GameRegistry.addRecipe(new ItemStack(ModItems.enlarged_pearcel_backpack), "xax", "z z", "axa", 'x', new ItemStack(ModItems.pearcel_item), 'z', new ItemStack(ModItems.pearcel_backpack), 'a', new ItemStack(Blocks.WOOL));
        GameRegistry.addRecipe(new ItemStack(ModItems.bindle), " xy", " ax", "z  ", 'x', new ItemStack(Blocks.WOOL), 'y', new ItemStack(ModItems.pearcel_item), 'z', new ItemStack(ModItems.pearcel_stick), 'a', new ItemStack(Items.STRING));
        GameRegistry.addRecipe(new ItemStack(ModItems.nullification_pearcel), "xyx", "y y", "zyz", 'x', new ItemStack(ModItems.tier_1_crafting_component), 'y', new ItemStack(ModItems.pearcel_item), 'z', new ItemStack(Blocks.COBBLESTONE));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_magnet), "aya", "yzy", "xyx", 'x', new ItemStack(ModItems.tier_2_crafting_component), 'y', new ItemStack(ModItems.pearcel_item), 'z', new ItemStack(Items.COMPASS), 'a', new ItemStack(Items.ENDER_PEARL));
        GameRegistry.addRecipe(new ItemStack(ModItems.living_magnet), "xax", "byb", "xax", 'x', new ItemStack(ModItems.tier_3_crafting_component), 'y', new ItemStack(ModItems.pearcel_magnet), 'a', new ItemStack(Items.FEATHER), 'b', new ItemStack(Items.LEATHER));
        GameRegistry.addRecipe(new ItemStack(ModItems.guardian_food), "xyx", "xzx", "xax", 'x', new ItemStack(ModItems.pearcel_item), 'y', new ItemStack(ModItems.tier_1_crafting_component), 'z', new ItemStack(ModItems.tier_2_crafting_component), 'a', new ItemStack(ModItems.tier_3_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.guardian_food), "xax", "xzx", "xyx", 'x', new ItemStack(ModItems.pearcel_item), 'y', new ItemStack(ModItems.tier_1_crafting_component), 'z', new ItemStack(ModItems.tier_2_crafting_component), 'a', new ItemStack(ModItems.tier_3_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.sacrificial_pearcel), "xzx", "zyz", "xzx", 'x', new ItemStack(ModItems.pearcel_item), 'y', new ItemStack(ModItems.tier_3_crafting_component), 'z', new ItemStack(ModItems.blood_drop));
        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_blood_dagger), " zz", "axz", "ya ", 'x', new ItemStack(ModItems.pearcel_sword), 'y', new ItemStack(ModItems.tier_3_crafting_component), 'z', new ItemStack(ModItems.pearcel_ingot), 'a', new ItemStack(ModItems.pearcel_item));
        GameRegistry.addRecipe(new ItemStack(ModItems.charm_bag), "xxx", "xyx", "xzx", 'x', new ItemStack(Blocks.WOOL, 1, OreDictionary.WILDCARD_VALUE), 'y', new ItemStack(ModItems.pearcel_item), 'z', new ItemStack(Blocks.CHEST));
        GameRegistry.addRecipe(new ItemStack(ModItems.slimey_pearcel), "zxz", "xyx", "zxz", 'x', new ItemStack(Items.SLIME_BALL), 'y', new ItemStack(ModItems.pearcel_item), 'z', new ItemStack(ModItems.tier_1_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModItems.throw_pearcel_explosive, 4), " y ", "xxx", "xzx", 'y', new ItemStack(Items.SNOWBALL), 'x', new ItemStack(ModItems.pearcel_item), 'z', new ItemStack(Items.GUNPOWDER));
        GameRegistry.addRecipe(new ItemStack(ModItems.throw_pearcel_entity_tp, 4), " y ", "xxx", "xzx", 'y', new ItemStack(Items.SNOWBALL), 'x', new ItemStack(ModItems.pearcel_item), 'z', new ItemStack(Items.ENDER_PEARL));
        GameRegistry.addRecipe(new ItemStack(ModItems.throw_pearcel_entity_firework, 4), " y ", "xxx", "xzx", 'y', new ItemStack(Items.SNOWBALL), 'x', new ItemStack(ModItems.pearcel_item), 'z', new ItemStack(Items.FIREWORKS));
        GameRegistry.addRecipe(new ItemStack(ModItems.throw_pearcel_entity_mount, 4), " y ", "xxx", "xzx", 'y', new ItemStack(Items.SNOWBALL), 'x', new ItemStack(ModItems.pearcel_item), 'z', new ItemStack(Items.SADDLE));

        //Charmed Pearcel
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.charmed_pearcel), new ItemStack(ModItems.pearcel_item), new ItemStack(ModItems.tier_4_crafting_component), new ItemStack(ModItems.blood_drop), new ItemStack(ModItems.pearcel_matter));
            //Setup
        ItemStack charmed_pearcel_fire = new ItemStack(ModItems.charmed_pearcel);
        ItemStack charmed_pearcel_water = new ItemStack(ModItems.charmed_pearcel);
        ItemStack charmed_pearcel_saturation = new ItemStack(ModItems.charmed_pearcel);
        ItemStack charmed_pearcel_step_assist = new ItemStack(ModItems.charmed_pearcel);
        ItemStack charmed_pearcel_fall = new ItemStack(ModItems.charmed_pearcel);
        ItemStack charmed_pearcel_gravity = new ItemStack(ModItems.charmed_pearcel);
        ItemStack charmed_pearcel_adrenaline = new ItemStack(ModItems.charmed_pearcel);
        ItemStack charmed_pearcel_cloaking = new ItemStack(ModItems.charmed_pearcel);
        ItemStack charmed_pearcel_repair = new ItemStack(ModItems.charmed_pearcel);
        ItemStack charmed_pearcel_physco = new ItemStack(ModItems.charmed_pearcel);
        ItemStack charmed_pearcel_third_eye = new ItemStack(ModItems.charmed_pearcel);

        if (!charmed_pearcel_fire.hasTagCompound())charmed_pearcel_fire.setTagCompound(new NBTTagCompound());
        if (!charmed_pearcel_water.hasTagCompound())charmed_pearcel_water.setTagCompound(new NBTTagCompound());
        if (!charmed_pearcel_saturation.hasTagCompound()) charmed_pearcel_saturation.setTagCompound(new NBTTagCompound());
        if (!charmed_pearcel_step_assist.hasTagCompound())charmed_pearcel_step_assist.setTagCompound(new NBTTagCompound());
        if (!charmed_pearcel_fall.hasTagCompound()) charmed_pearcel_fall.setTagCompound(new NBTTagCompound());
        if (!charmed_pearcel_gravity.hasTagCompound()) charmed_pearcel_gravity.setTagCompound(new NBTTagCompound());
        if (!charmed_pearcel_adrenaline.hasTagCompound()) charmed_pearcel_adrenaline.setTagCompound(new NBTTagCompound());
        if (!charmed_pearcel_cloaking.hasTagCompound()) charmed_pearcel_cloaking.setTagCompound(new NBTTagCompound());
        if (!charmed_pearcel_repair.hasTagCompound()) charmed_pearcel_repair.setTagCompound(new NBTTagCompound());
        if (!charmed_pearcel_physco.hasTagCompound()) charmed_pearcel_physco.setTagCompound(new NBTTagCompound());
        if (!charmed_pearcel_third_eye.hasTagCompound()) charmed_pearcel_third_eye.setTagCompound(new NBTTagCompound());

        charmed_pearcel_fire.getTagCompound().setString("type", "fire");
        charmed_pearcel_water.getTagCompound().setString("type", "water");
        charmed_pearcel_saturation.getTagCompound().setString("type", "saturation");
        charmed_pearcel_step_assist.getTagCompound().setString("type", "step_assist");
        charmed_pearcel_fall.getTagCompound().setString("type", "fall");
        charmed_pearcel_gravity.getTagCompound().setString("type", "gravity");
        charmed_pearcel_adrenaline.getTagCompound().setString("type", "adrenaline");
        charmed_pearcel_cloaking.getTagCompound().setString("type", "cloaking");
        charmed_pearcel_repair.getTagCompound().setString("type", "repair");
        charmed_pearcel_physco.getTagCompound().setString("type", "physco");
        charmed_pearcel_third_eye.getTagCompound().setString("type", "third_eye");

        GameRegistry.addShapelessRecipe(charmed_pearcel_fire, new ItemStack(ModItems.charmed_pearcel), new ItemStack(ModItems.pearcel_matter), new ItemStack(Items.MAGMA_CREAM));
        GameRegistry.addShapelessRecipe(charmed_pearcel_water, new ItemStack(ModItems.charmed_pearcel), new ItemStack(ModItems.pearcel_matter), new ItemStack(Items.WATER_BUCKET));
        GameRegistry.addShapelessRecipe(charmed_pearcel_saturation, new ItemStack(ModItems.charmed_pearcel), new ItemStack(ModItems.pearcel_matter), new ItemStack(ModItems.pearcel_infinifood));
        GameRegistry.addShapelessRecipe(charmed_pearcel_step_assist, new ItemStack(ModItems.charmed_pearcel), new ItemStack(ModItems.pearcel_matter), new ItemStack(Items.RABBIT_FOOT));
        GameRegistry.addShapelessRecipe(charmed_pearcel_fall, new ItemStack(ModItems.charmed_pearcel), new ItemStack(ModItems.pearcel_matter), new ItemStack(Items.FEATHER));
        GameRegistry.addShapelessRecipe(charmed_pearcel_gravity, new ItemStack(ModItems.charmed_pearcel), new ItemStack(ModItems.pearcel_matter), new ItemStack(Items.CHORUS_FRUIT));
        GameRegistry.addShapelessRecipe(charmed_pearcel_adrenaline, new ItemStack(ModItems.charmed_pearcel), new ItemStack(ModItems.pearcel_matter), new ItemStack(Items.SUGAR), new ItemStack(ModItems.pearcel_pickaxe), new ItemStack(Items.RABBIT_FOOT));
        GameRegistry.addShapelessRecipe(charmed_pearcel_cloaking, new ItemStack(ModItems.charmed_pearcel), new ItemStack(ModItems.pearcel_matter), new ItemStack(Items.ENDER_PEARL), new ItemStack(Items.GOLDEN_CARROT));
        GameRegistry.addShapelessRecipe(charmed_pearcel_repair, new ItemStack(ModItems.charmed_pearcel), new ItemStack(ModItems.pearcel_matter), new ItemStack(Blocks.ANVIL));
        GameRegistry.addShapelessRecipe(charmed_pearcel_physco, new ItemStack(ModItems.charmed_pearcel), new ItemStack(ModItems.pearcel_matter), new ItemStack(Items.SKULL, 1, OreDictionary.WILDCARD_VALUE));
        GameRegistry.addShapelessRecipe(charmed_pearcel_third_eye, new ItemStack(ModItems.charmed_pearcel), new ItemStack(ModItems.pearcel_matter), new ItemStack(Items.ENDER_EYE, 3));

        //Blocks
        GameRegistry.addSmelting(new ItemStack(ModBlocks.pearcel_sand), new ItemStack(ModBlocks.pearcel_glass), 5F);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.pearcel_cobblestone), new ItemStack(ModBlocks.pearcel_stone), 2f);
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.distressed_pearcel_stone), new ItemStack(ModBlocks.pearcel_stone));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel_charcoal, 9), new ItemStack(ModBlocks.pearcel_charcoal_block));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcel_torch, 4), "x", "y", 'x', new ItemStack(ModItems.pearcel_charcoal), 'y', new ItemStack(ModItems.pearcel_stick));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcel_block), "xxx", "xxx", "xxx", 'x', new ItemStack(ModItems.pearcel_item));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcel_workbench), "xx", "xx", 'x', new ItemStack(ModBlocks.pearcel_planks));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.torcher, 4), "xyx", "yzy", "xyx", 'x', new ItemStack(Blocks.TNT), 'y', new ItemStack(Blocks.TORCH), 'z', new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.torcher, 4), "xyx", "yzy", "xyx", 'y', new ItemStack(Blocks.TNT), 'x', new ItemStack(Blocks.TORCH), 'z', new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.summoner), "xyx", "yzy", "aba", 'x', new ItemStack(Items.DIAMOND), 'y', new ItemStack(Items.EMERALD), 'z', new ItemStack(ModItems.tier_3_crafting_component), 'a', new ItemStack(Items.GOLD_INGOT), 'b', new ItemStack(ModItems.pearcel_ingot));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcel_stonebricks, 4), "xx", "xx", 'x', new ItemStack(ModBlocks.polished_pearcel_stone));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcel_glass_pane, 16), "xxx", "xxx", 'x', new ItemStack(ModBlocks.pearcel_glass));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.polished_pearcel_stone, 8), "xx", "xx", 'x', new ItemStack(ModBlocks.pearcel_stone));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.packed_pearcel_bricks, 4), "xx", "xx", 'x', new ItemStack(ModBlocks.pearcel_stonebricks));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcel_bricks, 16), "xx", "xx", 'x', new ItemStack(ModBlocks.pearcel_block));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.irradiated_pearcel_block, 8), " x ", "xyx", " x ", 'x', new ItemStack(Items.GLOWSTONE_DUST), 'y', new ItemStack(ModBlocks.pearcel_block));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.tainted_pearcel, 32), "zxz", "xyx", "zxz", 'x', new ItemStack(Items.NETHER_WART), 'y', new ItemStack(ModBlocks.pearcel_stone), 'z', new ItemStack(Items.SPIDER_EYE));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcel_planks, 8), "xxx", "xyx", "xxx", 'x', new ItemStack(Blocks.PLANKS, 1, OreDictionary.WILDCARD_VALUE), 'y', new ItemStack(ModItems.pearcel_item));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcel_sand), " x ", "xyx", " x ", 'x', new ItemStack(Blocks.SAND, 4), 'y', new ItemStack(ModItems.pearcel_item));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcel_sandstone, 4), "xx", "xx", 'x', new ItemStack(ModBlocks.pearcel_sand));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcel_ladder, 3), "xxx", " x ", "xxx", 'x', new ItemStack(ModItems.pearcel_stick));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcel_lamp, 8), "xyx", "yzy", "xyx", 'x', new ItemStack(ModItems.pearcel_item), 'y', new ItemStack(ModBlocks.irradiated_pearcel_block), 'z', new ItemStack(ModItems.tier_1_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pedestal, 2), "xyx", " z ", " x ", 'x', new ItemStack(ModBlocks.pearcel_planks), 'y', new ItemStack(ModItems.tier_2_crafting_component), 'z', new ItemStack(ModItems.pearcel_stick));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.ender_pearcel_block, 2), "xx ", "xx ", 'x', new ItemStack(ModItems.ender_pearcel));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcel_charcoal_block), "xxx", "xxx", "xxx", 'x', new ItemStack(ModItems.pearcel_charcoal));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcel_beacon), "zxz", "aya", "xzx", 'x', new ItemStack(ModBlocks.polished_pearcel_stone), 'y', new ItemStack(ModItems.pearcel_star), 'z', new ItemStack(ModBlocks.ender_pearcel_block), 'a', new ItemStack(ModItems.tier_3_crafting_component));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcel_storage_crate), " x ", "xyx", " x ", 'x', new ItemStack(ModItems.pearcel_item), 'y', new ItemStack(Blocks.CHEST, 1, OreDictionary.WILDCARD_VALUE));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcel_ingot_block), "xxx", "xxx", "xxx", 'x', new ItemStack(ModItems.pearcel_ingot));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcel_plush, 2), " z ", " x ", "yxy", 'x', new ItemStack(ModBlocks.pearcel_block), 'y', new ItemStack(ModItems.pearcel_item), 'z', new ItemStack(Items.STICK));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcel_fence, 6), "xyx", "xyx", 'x', new ItemStack(ModBlocks.pearcel_planks), 'y', new ItemStack(ModItems.pearcel_stick));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcel_fence2, 6), "xyx", "xyx", 'x', new ItemStack(ModBlocks.pearcel_block), 'y', new ItemStack(ModItems.pearcel_stick));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcel_pressure_plate), "xx", 'x', new ItemStack(ModBlocks.pearcel_stone));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcel_spike, 4), "xxx", "yay", "zbz", 'x', new ItemStack(ModItems.pearcel_stick), 'y', new ItemStack(ModBlocks.pearcel_block), 'z', new ItemStack(ModBlocks.pearcel_planks), 'a', new ItemStack(ModItems.tier_2_crafting_component), 'b', new ItemStack(ModBlocks.pearcel_ingot_block));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcel_spike_guardian, 16), "xxx", "yay", "zbz", 'x', new ItemStack(ModBlocks.pearcel_spike), 'y', new ItemStack(ModBlocks.pearcel_block), 'z', new ItemStack(ModBlocks.tainted_pearcel), 'a', new ItemStack(ModItems.tier_4_crafting_component), 'b', new ItemStack(ModBlocks.pearcel_ingot_block));

        //Pearcel Matter Recipes
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel_matter, 2), new ItemStack(ModItems.neutral_pearcel_matter), new ItemStack(ModItems.tier_1_crafting_component));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel_matter, 4), new ItemStack(ModItems.neutral_pearcel_matter), new ItemStack(ModItems.tier_2_crafting_component));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel_matter, 8), new ItemStack(ModItems.neutral_pearcel_matter), new ItemStack(ModItems.tier_3_crafting_component));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel_matter, 16), new ItemStack(ModItems.neutral_pearcel_matter), new ItemStack(ModItems.tier_4_crafting_component));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.pearcel_matter, 9), new ItemStack(ModBlocks.pearcel_matter_block));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.pearcel_matter_block), "xxx", "xxx", "xxx", 'x', new ItemStack(ModItems.pearcel_matter));

        GameRegistry.addRecipe(new ItemStack(Items.NETHER_STAR), " x ", "xyx", " x ", 'x', new ItemStack(ModItems.pearcel_matter), 'y', new ItemStack(ModBlocks.pearcel_matter_block));
        GameRegistry.addRecipe(new ItemStack(Items.COAL, 16), "x  ", " x ", " x ", 'x', new ItemStack(ModItems.pearcel_matter));
        GameRegistry.addRecipe(new ItemStack(Items.IRON_INGOT, 12), " x ", "x  ", "x  ", 'x', new ItemStack(ModItems.pearcel_matter));
        GameRegistry.addRecipe(new ItemStack(Items.GOLD_INGOT, 8), "x  ", "x  ", "  x", 'x', new ItemStack(ModItems.pearcel_matter));
        GameRegistry.addRecipe(new ItemStack(Items.DIAMOND, 4), "x  ", "x x", 'x', new ItemStack(ModItems.pearcel_matter));
        GameRegistry.addRecipe(new ItemStack(Items.EMERALD, 2), " xx", " x ", 'x', new ItemStack(ModItems.pearcel_matter));
        GameRegistry.addRecipe(new ItemStack(Items.REDSTONE, 16), "x x", "x x", 'x', new ItemStack(ModItems.pearcel_matter));
        GameRegistry.addRecipe(new ItemStack(Items.QUARTZ, 32), "x x", "x x", " x ", 'x', new ItemStack(ModItems.pearcel_matter));
        GameRegistry.addRecipe(new ItemStack(Items.BLAZE_ROD, 10), "x  ", " x ", "  x", 'x', new ItemStack(ModItems.pearcel_matter));
        GameRegistry.addRecipe(new ItemStack(Items.SLIME_BALL, 16), " x ", "x x", " x ", 'x', new ItemStack(ModItems.pearcel_matter));
        GameRegistry.addRecipe(new ItemStack(Items.EXPERIENCE_BOTTLE, 16), "xx ", "x  ", 'x', new ItemStack(ModItems.pearcel_matter));
        GameRegistry.addRecipe(new ItemStack(Items.GLOWSTONE_DUST, 16), "xx ", "  x", 'x', new ItemStack(ModItems.pearcel_matter));
        GameRegistry.addRecipe(new ItemStack(Items.LEATHER, 18), "x x", "  x", 'x', new ItemStack(ModItems.pearcel_matter));
        GameRegistry.addRecipe(new ItemStack(Items.REEDS, 48), "xx ", "   ", "x  ", 'x', new ItemStack(ModItems.pearcel_matter));
        GameRegistry.addRecipe(new ItemStack(Items.GHAST_TEAR, 4), "x x", " x ", " x ", 'x', new ItemStack(ModItems.pearcel_matter));
        GameRegistry.addRecipe(new ItemStack(Items.PRISMARINE_SHARD, 4), "x  ", " x ", 'x', new ItemStack(ModItems.pearcel_matter));

        GameRegistry.addRecipe(new ItemStack(Blocks.OBSIDIAN, 48), "xxx", "x x", "xxx", 'x', new ItemStack(ModItems.pearcel_matter));
        GameRegistry.addRecipe(new ItemStack(Blocks.DRAGON_EGG), "xxx", "xyx", "xxx", 'x', new ItemStack(ModBlocks.pearcel_matter_block), 'y', new ItemStack(Items.END_CRYSTAL));

        GameRegistry.addRecipe(new ItemStack(ModItems.pearcel_star), "xxx", "xyx", "xxx", 'x', new ItemStack(ModItems.pearcel_matter), 'y', new ItemStack(ModBlocks.pearcel_matter_block));

        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.COAL_ORE, 8), new ItemStack(ModItems.pearcel_matter), new ItemStack(Items.SLIME_BALL), new ItemStack(Blocks.COAL_BLOCK));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.IRON_ORE, 8), new ItemStack(ModItems.pearcel_matter), new ItemStack(Items.SLIME_BALL), new ItemStack(Blocks.IRON_BLOCK));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.GOLD_ORE, 8), new ItemStack(ModItems.pearcel_matter), new ItemStack(Items.SLIME_BALL), new ItemStack(Blocks.GOLD_BLOCK));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.DIAMOND_ORE, 8), new ItemStack(ModItems.pearcel_matter), new ItemStack(Items.SLIME_BALL), new ItemStack(Blocks.DIAMOND_BLOCK));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.REDSTONE_ORE, 8), new ItemStack(ModItems.pearcel_matter), new ItemStack(Items.SLIME_BALL), new ItemStack(Blocks.REDSTONE_BLOCK));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.STONE, 64), new ItemStack(ModItems.pearcel_matter), new ItemStack(Blocks.COBBLESTONE));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.STONEBRICK, 64), new ItemStack(ModItems.pearcel_matter), new ItemStack(Blocks.STONE));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.COBBLESTONE, 111), new ItemStack(ModItems.pearcel_matter), new ItemStack(Items.WATER_BUCKET), new ItemStack(Items.LAVA_BUCKET), new ItemStack(Blocks.COBBLESTONE));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.SOUL_SAND, 48), new ItemStack(ModItems.pearcel_matter), new ItemStack(Items.GHAST_TEAR), new ItemStack(Blocks.NETHERRACK));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.SADDLE), new ItemStack(ModItems.pearcel_matter), new ItemStack(Items.LEATHER), new ItemStack(Items.LEATHER), new ItemStack(Items.IRON_INGOT));
    }
    
}
