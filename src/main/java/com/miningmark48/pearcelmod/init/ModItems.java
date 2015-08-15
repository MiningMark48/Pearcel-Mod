package com.miningmark48.pearcelmod.init;

import com.miningmark48.pearcelmod.creativetab.CreativeTabPearcelMod;
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
    public static ItemArmor.ArmorMaterial matPearcel = EnumHelper.addArmorMaterial("PearcelArmor", 40, new int[]{3, 8, 6, 3}, 30);

    //Food
	public static final Item pearcel = new ItemModFood(9, 1.5F, false).setUnlocalizedName("pearcelItem").setTextureName(Reference.MOD_ID + ":pearcelItem").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelPie = new ItemModFood(8, 0.3F, false).setUnlocalizedName("pearcelPie").setTextureName(Reference.MOD_ID + ":pearcelPie").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelBread = new ItemModFood(6, 0.6F, false).setUnlocalizedName("pearcelBread").setTextureName(Reference.MOD_ID + ":pearcelBread").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item angelDust = new ItemAngelDust(1, 0.5F, true).setUnlocalizedName("angelDust").setTextureName(Reference.MOD_ID + ":angelDust").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelMelon = new ItemPearcelMelon(4, 1.0F, false).setUnlocalizedName("pearcelMelon").setTextureName(Reference.MOD_ID + ":pearcelMelon").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelSandwich = new ItemModFood(10, 1.3F, true).setUnlocalizedName("pearcelSandwich").setTextureName(Reference.MOD_ID + ":pearcelSandwich").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item melonSandwich = new ItemModFood(11, 1.4F, true).setUnlocalizedName("melonSandwich").setTextureName(Reference.MOD_ID + ":melonSandwich").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelBeef = new ItemModFood(1, 0.1F, true).setUnlocalizedName("pearcelBeef").setTextureName(Reference.MOD_ID + ":pearcelBeef").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelSteak = new ItemModFood(7, 0.8F, true).setUnlocalizedName("pearcelSteak").setTextureName(Reference.MOD_ID + ":pearcelSteak").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelCookie = new ItemModFood(1, 0.5F, false).setUnlocalizedName("pearcelCookie").setTextureName(Reference.MOD_ID + ":pearcelCookie").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelCookie2 = new ItemModFood(2, 1.0F, false).setUnlocalizedName("pearcelCookie2").setTextureName(Reference.MOD_ID + ":pearcelCookie2").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelCookie3 = new ItemModFood(3, 1.5F, false).setUnlocalizedName("pearcelCookie3").setTextureName(Reference.MOD_ID + ":pearcelCookie3").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelCookie4 = new ItemModFood(4, 2.0F, false).setUnlocalizedName("pearcelCookie4").setTextureName(Reference.MOD_ID + ":pearcelCookie4").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelCookie5 = new ItemModFood(5, 2.5F, false).setUnlocalizedName("pearcelCookie5").setTextureName(Reference.MOD_ID + ":pearcelCookie5").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelCookie6 = new ItemModFood(6, 3.0F, false).setUnlocalizedName("pearcelCookie6").setTextureName(Reference.MOD_ID + ":pearcelCookie6").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelCookie7 = new ItemModFood(7, 3.5F, false).setUnlocalizedName("pearcelCookie7").setTextureName(Reference.MOD_ID + ":pearcelCookie7").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelCookie8 = new ItemModFood(8, 4.0F, false).setUnlocalizedName("pearcelCookie8").setTextureName(Reference.MOD_ID + ":pearcelCookie8").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelCookie9 = new ItemModFood(9, 10.0F, false).setUnlocalizedName("pearcelCookie9").setTextureName(Reference.MOD_ID + ":pearcelCookie9").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);

    //Plants
    public static final Item pearcelSeeds = new ItemSeeds(ModBlocks.pearcelPlant, Blocks.farmland).setUnlocalizedName("pearcelSeeds").setTextureName(Reference.MOD_ID + ":pearcelSeeds").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);

    //Tools and Weapons
    public static final Item pearcelSword = new ItemPearcelSword(ToolMaterial.IRON).setUnlocalizedName("pearcelSword").setTextureName(Reference.MOD_ID + ":pearcelSword").setMaxStackSize(1).setMaxDamage(2048).setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelPickaxe = new ItemPearcelPickaxe(ToolMaterial.EMERALD).setUnlocalizedName("pearcelPickaxe").setTextureName(Reference.MOD_ID + ":pearcelPickaxe").setMaxStackSize(1).setMaxDamage(2048).setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelAxe = new ItemPearcelAxe(ToolMaterial.EMERALD).setUnlocalizedName("pearcelAxe").setTextureName(Reference.MOD_ID + ":pearcelAxe").setMaxStackSize(1).setMaxDamage(2048).setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelShovel = new ItemPearcelShovel(ToolMaterial.EMERALD).setUnlocalizedName("pearcelShovel").setTextureName(Reference.MOD_ID + ":pearcelShovel").setMaxStackSize(1).setMaxDamage(2048).setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelHoe = new ItemPearcelHoe(ToolMaterial.EMERALD).setUnlocalizedName("pearcelHoe").setTextureName(Reference.MOD_ID + ":pearcelHoe").setMaxStackSize(1).setMaxDamage(2048).setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelShears = new ItemPearcelShears().setUnlocalizedName("pearcelShears").setTextureName(Reference.MOD_ID + ":pearcelShears").setMaxStackSize(1).setMaxDamage(1024).setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelBow = new ItemPearcelBow().setUnlocalizedName("pearcelBow").setTextureName(Reference.MOD_ID + ":pearcelBow").setMaxStackSize(1).setMaxDamage(100).setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pcp = new ItemPCP().setUnlocalizedName("pcp").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setMaxStackSize(1);
    public static final Item pearcelStaff = new ItemPearcelStaff(ToolMaterial.EMERALD).setTextureName(Reference.MOD_ID + ":pearcelStaff").setUnlocalizedName("pearcelStaff").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setMaxStackSize(1).setMaxDamage(1000);

    //Armor
    public static Item pearcelHelmet = new PearcelArmor(matPearcel, 0).setUnlocalizedName("pearcelHelmet").setTextureName(Reference.MOD_ID + ":pearcelHelmet").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static Item pearcelChestplate = new PearcelArmor(matPearcel, 1).setUnlocalizedName("pearcelChestplate").setTextureName(Reference.MOD_ID + ":pearcelChestplate").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static Item pearcelLeggings = new PearcelArmor(matPearcel, 2).setUnlocalizedName("pearcelLeggings").setTextureName(Reference.MOD_ID + ":pearcelLeggings").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static Item pearcelBoots = new PearcelArmor(matPearcel, 3).setUnlocalizedName("pearcelBoots").setTextureName(Reference.MOD_ID + ":pearcelBoots").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);


    //General Items
    public static final Item pearcelNugget = new ItemPearcelNugget().setUnlocalizedName("pearcelNugget").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setMaxStackSize(16);
    public static final Item pearcelStick = new ItemPearcelStick().setUnlocalizedName("pearcelStick").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelFlour = new ItemPearcelFlour().setUnlocalizedName("pearcelFlour").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelArrow = new ItemPearcelArrow().setUnlocalizedName("pearcelArrow").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item meMatter = new ItemMEMatter().setUnlocalizedName("meMatter").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item meMatterNeutral = new ItemMEMatterNeutral().setUnlocalizedName("meMatterNeutral").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item redMatter = new ItemRedMatter().setUnlocalizedName("redMatter").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item greenMatter = new ItemGreenMatter().setUnlocalizedName("greenMatter").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelJar = new ItemPearcelJar().setUnlocalizedName("pearcelJar").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelJelly = new ItemPearcelJelly().setUnlocalizedName("pearcelJelly").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item melonJelly = new ItemMelonJelly().setUnlocalizedName("melonJelly").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelJuice = new ItemPearcelJuice().setUnlocalizedName("pearcelJuice").setTextureName(Reference.MOD_ID + ":pearcelJuice").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setMaxStackSize(1).setContainerItem(Items.bucket);
    public static final Item pearcelCharcoal = new ItemPearcelFuel().setUnlocalizedName("pearcelCharcoal").setTextureName(Reference.MOD_ID + ":pearcelCharcoal").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item dice = new ItemDice().setUnlocalizedName("dice").setTextureName(Reference.MOD_ID + ":dice").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item tier1Craft = new ItemCraftComponent().setUnlocalizedName("tier1Craft").setTextureName(Reference.MOD_ID + ":tier1Craft").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item tier2Craft = new ItemCraftComponent().setUnlocalizedName("tier2Craft").setTextureName(Reference.MOD_ID + ":tier2Craft").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item tier3Craft = new ItemCraftComponent().setUnlocalizedName("tier3Craft").setTextureName(Reference.MOD_ID + ":tier3Craft").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item tier4Craft = new ItemCraftComponent().setUnlocalizedName("tier4Craft").setTextureName(Reference.MOD_ID + ":tier4Craft").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item armorPlating = new ItemArmorPlating().setUnlocalizedName("armorPlating").setTextureName(Reference.MOD_ID + "armorPlating").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);

	public static void init(){
        //Food
        GameRegistry.registerItem(pearcel, "pearcelItem");
        GameRegistry.registerItem(pearcelPie, "pearcelPie");
        GameRegistry.registerItem(pearcelBread, "pearcelBread");
        GameRegistry.registerItem(pearcelJuice, "pearcelJuice");
        GameRegistry.registerItem(angelDust, "angelDust");
        GameRegistry.registerItem(pearcelMelon, "pearcelMelon");
        GameRegistry.registerItem(pearcelSandwich, "pearcelSandwich");
        GameRegistry.registerItem(melonSandwich, "melonSandwich");
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
        //Armor
        GameRegistry.registerItem(pearcelHelmet, "pearcelHelmet");
        GameRegistry.registerItem(pearcelChestplate, "pearcelChestplate");
        GameRegistry.registerItem(pearcelLeggings, "pearcelLeggings");
        GameRegistry.registerItem(pearcelBoots, "pearcelBoots");
        //General Items
        GameRegistry.registerItem(pearcelNugget, "pearcelNugget");
        GameRegistry.registerItem(pearcelStick, "pearcelStick");
        GameRegistry.registerItem(pearcelFlour, "pearcelFlour");
        GameRegistry.registerItem(pearcelArrow, "pearcelArrow");
        GameRegistry.registerItem(meMatter, "meMatter");
        GameRegistry.registerItem(meMatterNeutral, "meMatterNeutral");
        GameRegistry.registerItem(redMatter, "redMatter");
        GameRegistry.registerItem(greenMatter, "greenMatter");
        GameRegistry.registerItem(pearcelJar, "pearcelJar");
        GameRegistry.registerItem(pearcelJelly, "pearcelJelly");
        GameRegistry.registerItem(melonJelly, "melonJelly");
        GameRegistry.registerItem(pearcelCookie, "pearcelCookie");
        GameRegistry.registerItem(pearcelCookie2, "pearcelCookie2");
        GameRegistry.registerItem(pearcelCookie3, "pearcelCookie3");
        GameRegistry.registerItem(pearcelCookie4, "pearcelCookie4");
        GameRegistry.registerItem(pearcelCookie5, "pearcelCookie5");
        GameRegistry.registerItem(pearcelCookie6, "pearcelCookie6");
        GameRegistry.registerItem(pearcelCookie7, "pearcelCookie7");
        GameRegistry.registerItem(pearcelCookie8, "pearcelCookie8");
        GameRegistry.registerItem(pearcelCookie9, "pearcelCookie9");
        GameRegistry.registerItem(pearcelCharcoal, "pearcelCharcoal");
        GameRegistry.registerItem(dice, "dice");
		GameRegistry.registerItem(tier1Craft, "tier1Craft");
        GameRegistry.registerItem(tier2Craft, "tier2Craft");
        GameRegistry.registerItem(tier3Craft, "tier3Craft");
        GameRegistry.registerItem(tier4Craft, "tier4Craft");
        GameRegistry.registerItem(armorPlating, "armorPlating");

	}
	
}
