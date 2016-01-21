package com.miningmark48.pearcelmod.init;

import com.miningmark48.pearcelmod.creativetab.CreativeTabPearcelMod;
import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import com.miningmark48.pearcelmod.reference.Reference;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import com.miningmark48.pearcelmod.item.*;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemSeeds;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems {

    //Material
    public static ItemArmor.ArmorMaterial matPearcel = EnumHelper.addArmorMaterial("PearcelArmor", 25, new int[]{3, 6, 5, 2}, 10);
    public static ItemArmor.ArmorMaterial matChargePearcel = EnumHelper.addArmorMaterial("ChargedPearcelArmor", 50, new int[]{4, 8, 6, 3}, 30);

    //Food
	public static final Item pearcel = new ItemModFood(9, 1.5F, false).setUnlocalizedName("pearcelItem").setTextureName(Reference.MOD_ID + ":pearcelItem").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelPie = new ItemModFood(8, 0.3F, false).setUnlocalizedName("pearcelPie").setTextureName(Reference.MOD_ID + ":pearcelPie").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelBread = new ItemModFood(6, 0.6F, false).setUnlocalizedName("pearcelBread").setTextureName(Reference.MOD_ID + ":pearcelBread").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelSandwich = new ItemModFood(10, 1.3F, true).setUnlocalizedName("pearcelSandwich").setTextureName(Reference.MOD_ID + ":pearcelSandwich").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelBeef = new ItemModFood(1, 0.1F, true).setUnlocalizedName("pearcelBeef").setTextureName(Reference.MOD_ID + ":pearcelBeef").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelSteak = new ItemModFood(7, 0.8F, true).setUnlocalizedName("pearcelSteak").setTextureName(Reference.MOD_ID + ":pearcelSteak").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelCookie = new ItemModFood(1, 0.5F, false).setUnlocalizedName("pearcelCookie").setTextureName(Reference.MOD_ID + ":pearcelCookie").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);

    //Plants
    public static final Item pearcelSeeds = new ItemSeeds(ModBlocks.pearcelPlant, Blocks.farmland).setUnlocalizedName("pearcelSeeds").setTextureName(Reference.MOD_ID + ":pearcelSeeds").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);

    //Tools and Weapons
    public static final Item pearcelSword = new ItemPearcelSword(ToolMaterial.IRON).setUnlocalizedName("pearcelSword").setTextureName(Reference.MOD_ID + ":pearcelSword").setMaxStackSize(1).setMaxDamage(1024).setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelPickaxe = new ItemPearcelPickaxe(ToolMaterial.EMERALD).setUnlocalizedName("pearcelPickaxe").setTextureName(Reference.MOD_ID + ":pearcelPickaxe").setMaxStackSize(1).setMaxDamage(1024).setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelAxe = new ItemPearcelAxe(ToolMaterial.EMERALD).setUnlocalizedName("pearcelAxe").setTextureName(Reference.MOD_ID + ":pearcelAxe").setMaxStackSize(1).setMaxDamage(1024).setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelShovel = new ItemPearcelShovel(ToolMaterial.EMERALD).setUnlocalizedName("pearcelShovel").setTextureName(Reference.MOD_ID + ":pearcelShovel").setMaxStackSize(1).setMaxDamage(1024).setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelHoe = new ItemPearcelHoe(ToolMaterial.EMERALD).setUnlocalizedName("pearcelHoe").setTextureName(Reference.MOD_ID + ":pearcelHoe").setMaxStackSize(1).setMaxDamage(1024).setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelShears = new ItemPearcelShears().setUnlocalizedName("pearcelShears").setTextureName(Reference.MOD_ID + ":pearcelShears").setMaxStackSize(1).setMaxDamage(1024).setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelBow = new ItemPearcelBow().setUnlocalizedName("pearcelBow").setTextureName(Reference.MOD_ID + ":pearcelBow").setMaxStackSize(1).setMaxDamage(100).setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pcp = new ItemPCP().setUnlocalizedName("pcp").setTextureName(Reference.MOD_ID + ":pcp").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setMaxStackSize(1);
    public static final Item pearcelStaff = new ItemPearcelStaff(ToolMaterial.GOLD).setTextureName(Reference.MOD_ID + ":pearcelStaff").setUnlocalizedName("pearcelStaff").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setMaxStackSize(1).setMaxDamage(1000);
    public static final Item flightItem = new ItemFlight().setTextureName(Reference.MOD_ID + ":flightItem").setUnlocalizedName("flightItem").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setMaxStackSize(1);
    public static final Item sap = new ItemSAP().setTextureName(Reference.MOD_ID + ":sap").setUnlocalizedName("sap").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setMaxStackSize(1).setMaxDamage(ConfigurationHandler.sapDurability);
    public static final Item chargedPearcelSword = new ItemChargedPearcelSword(ToolMaterial.EMERALD).setUnlocalizedName("chargedPearcelSword").setTextureName(Reference.MOD_ID + ":chargedPearcelSword").setMaxStackSize(1).setMaxDamage(512).setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);

    //Armor
    public static Item pearcelHelmet = new ItemPearcelArmor(matPearcel, 0).setUnlocalizedName("pearcelHelmet").setTextureName(Reference.MOD_ID + ":pearcelHelmet").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static Item pearcelChestplate = new ItemPearcelArmor(matPearcel, 1).setUnlocalizedName("pearcelChestplate").setTextureName(Reference.MOD_ID + ":pearcelChestplate").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static Item pearcelLeggings = new ItemPearcelArmor(matPearcel, 2).setUnlocalizedName("pearcelLeggings").setTextureName(Reference.MOD_ID + ":pearcelLeggings").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static Item pearcelBoots = new ItemPearcelArmor(matPearcel, 3).setUnlocalizedName("pearcelBoots").setTextureName(Reference.MOD_ID + ":pearcelBoots").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static Item chargedPearcelHelmet = new ItemChargedPearcelArmor(matChargePearcel, 0).setUnlocalizedName("chargedPearcelHelmet").setTextureName(Reference.MOD_ID + ":chargedPearcelHelmet").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static Item chargedPearcelChestplate = new ItemChargedPearcelArmor(matChargePearcel, 1).setUnlocalizedName("chargedPearcelChestplate").setTextureName(Reference.MOD_ID + ":chargedPearcelChestplate").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static Item chargedPearcelLeggings = new ItemChargedPearcelArmor(matChargePearcel, 2).setUnlocalizedName("chargedPearcelLeggings").setTextureName(Reference.MOD_ID + ":chargedPearcelLeggings").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static Item chargedPearcelBoots = new ItemChargedPearcelArmor(matChargePearcel, 3).setUnlocalizedName("chargedPearcelBoots").setTextureName(Reference.MOD_ID + ":chargedPearcelBoots").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);


    //General Items
    public static final Item pearcelNugget = new ItemPearcelNugget().setUnlocalizedName("pearcelNugget").setTextureName(Reference.MOD_ID + ":pearcelNugget").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setMaxStackSize(16);
    public static final Item pearcelStick = new ItemPearcelStick().setUnlocalizedName("pearcelStick").setTextureName(Reference.MOD_ID + ":pearcelStick").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelFlour = new ItemPearcelFlour().setUnlocalizedName("pearcelFlour").setTextureName(Reference.MOD_ID + ":pearcelFlour").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelArrow = new ItemPearcelArrow().setUnlocalizedName("pearcelArrow").setTextureName(Reference.MOD_ID + ":pearcelArrow").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelMatter = new ItemPearcelMatter().setUnlocalizedName("pearcelMatter").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setTextureName(Reference.MOD_ID + ":pearcelMatter");
    public static final Item pearcelMatterNeutral = new ItemPearcelMatterNeutral().setUnlocalizedName("pearcelMatterNeutral").setTextureName(Reference.MOD_ID + ":pearcelMatterNeutral").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelJuice = new ItemPearcelJuice().setUnlocalizedName("pearcelJuice").setTextureName(Reference.MOD_ID + ":pearcelJuice").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setMaxStackSize(1).setContainerItem(Items.bucket);
    public static final Item pearcelCharcoal = new ItemPearcelFuel().setUnlocalizedName("pearcelCharcoal").setTextureName(Reference.MOD_ID + ":pearcelCharcoal").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item tier1Craft = new ItemCraftComponent().setUnlocalizedName("tier1Craft").setTextureName(Reference.MOD_ID + ":tier1Craft").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item tier2Craft = new ItemCraftComponent().setUnlocalizedName("tier2Craft").setTextureName(Reference.MOD_ID + ":tier2Craft").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item tier3Craft = new ItemCraftComponent().setUnlocalizedName("tier3Craft").setTextureName(Reference.MOD_ID + ":tier3Craft").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item tier4Craft = new ItemCraftComponent().setUnlocalizedName("tier4Craft").setTextureName(Reference.MOD_ID + ":tier4Craft").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item armorPlating = new ItemArmorPlating().setUnlocalizedName("armorPlating").setTextureName(Reference.MOD_ID + ":armorPlating").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelIngot = new ItemIngot().setUnlocalizedName("pearcelIngot").setTextureName(Reference.MOD_ID + ":pearcelIngot").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);


	public static void init(){
        //Food
        GameRegistry.registerItem(pearcel, "pearcelItem");
        GameRegistry.registerItem(pearcelPie, "pearcelPie");
        GameRegistry.registerItem(pearcelBread, "pearcelBread");
        GameRegistry.registerItem(pearcelJuice, "pearcelJuice");
        GameRegistry.registerItem(pearcelSandwich, "pearcelSandwich");
        GameRegistry.registerItem(pearcelBeef, "pearcelBeef");
        GameRegistry.registerItem(pearcelSteak, "pearcelSteak");
        //Plants
        GameRegistry.registerItem(pearcelSeeds, "pearcelSeeds");
        //Tools and Weapons
        GameRegistry.registerItem(pearcelSword, "pearcelSword");
        GameRegistry.registerItem(pearcelPickaxe, "pearcelPickaxe");
        GameRegistry.registerItem(pearcelAxe, "pearcelAxe");
        GameRegistry.registerItem(pearcelShovel, "pearcelShovel");
        GameRegistry.registerItem(pearcelHoe, "pearcelHoe");
        GameRegistry.registerItem(pearcelShears, "pearcelShears");
        GameRegistry.registerItem(pearcelBow, "pearcelBow");
        GameRegistry.registerItem(pcp, "pcp");
        GameRegistry.registerItem(pearcelStaff, "pearcelStaff");
        GameRegistry.registerItem(flightItem, "flightItem");
        GameRegistry.registerItem(sap, "sap");
        GameRegistry.registerItem(chargedPearcelSword, "chargedPearcelSword");

        //Armor
        GameRegistry.registerItem(pearcelHelmet, "pearcelHelmet");
        GameRegistry.registerItem(pearcelChestplate, "pearcelChestplate");
        GameRegistry.registerItem(pearcelLeggings, "pearcelLeggings");
        GameRegistry.registerItem(pearcelBoots, "pearcelBoots");
        GameRegistry.registerItem(chargedPearcelHelmet, "chargedPearcelHelmet");
        GameRegistry.registerItem(chargedPearcelChestplate, "chargedPearcelChestplate");
        GameRegistry.registerItem(chargedPearcelLeggings, "chargedPearcelLeggings");
        GameRegistry.registerItem(chargedPearcelBoots, "chargedPearcelBoots");
        //General Items
        GameRegistry.registerItem(pearcelNugget, "pearcelNugget");
        GameRegistry.registerItem(pearcelStick, "pearcelStick");
        GameRegistry.registerItem(pearcelFlour, "pearcelFlour");
        GameRegistry.registerItem(pearcelArrow, "pearcelArrow");
        GameRegistry.registerItem(pearcelMatter, "pearcelMatter");
        GameRegistry.registerItem(pearcelMatterNeutral, "pearcelMatterNeutral");
        GameRegistry.registerItem(pearcelCookie, "pearcelCookie");
        GameRegistry.registerItem(pearcelCharcoal, "pearcelCharcoal");
		GameRegistry.registerItem(tier1Craft, "tier1Craft");
        GameRegistry.registerItem(tier2Craft, "tier2Craft");
        GameRegistry.registerItem(tier3Craft, "tier3Craft");
        GameRegistry.registerItem(tier4Craft, "tier4Craft");
        GameRegistry.registerItem(armorPlating, "armorPlating");
        GameRegistry.registerItem(pearcelIngot, "pearcelIngot");
	}
	
}
