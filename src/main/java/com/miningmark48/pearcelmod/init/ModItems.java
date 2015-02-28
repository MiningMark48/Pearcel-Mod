package com.miningmark48.pearcelmod.init;

import com.miningmark48.pearcelmod.creativetab.CreativeTabPearcelMod;
import com.miningmark48.pearcelmod.reference.Reference;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;

import com.miningmark48.pearcelmod.item.*;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemSeeds;

public class ModItems {

    //Food
	public static final Item pearcel = new ItemModFood(10, 1.5F, false).setUnlocalizedName("pearcelItem").setTextureName(Reference.MOD_ID + ":pearcelItem").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelPie = new ItemModFood(8, 0.3F, false).setUnlocalizedName("pearcelPie").setTextureName(Reference.MOD_ID + ":pearcelPie").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item sugarCookie = new ItemSugarCookie(1, 0.5F, true).setUnlocalizedName("sugarCookie").setTextureName(Reference.MOD_ID + ":sugarCookie").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelBread = new ItemModFood(6, 0.6F, false).setUnlocalizedName("pearcelBread").setTextureName(Reference.MOD_ID + ":pearcelBread").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);

    //Plants
    public static final Item pearcelSeeds = new ItemSeeds(ModBlocks.pearcelPlant, Blocks.farmland).setUnlocalizedName("pearcelSeeds").setTextureName(Reference.MOD_ID + ":pearcelSeeds").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);

    //Tools and Weapons
    public static final Item pearcelSword = new ItemPearcelSword(ToolMaterial.IRON).setUnlocalizedName("pearcelSword").setTextureName(Reference.MOD_ID + ":pearcelSword").setMaxStackSize(1).setMaxDamage(2048).setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelPickaxe = new ItemPearcelPickaxe(ToolMaterial.EMERALD).setUnlocalizedName("pearcelPickaxe").setTextureName(Reference.MOD_ID + ":pearcelPickaxe").setMaxStackSize(1).setMaxDamage(2048).setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelAxe = new ItemPearcelAxe(ToolMaterial.IRON).setUnlocalizedName("pearcelAxe").setTextureName(Reference.MOD_ID + ":pearcelAxe").setMaxStackSize(1).setMaxDamage(2048).setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelShovel = new ItemPearcelAxe(ToolMaterial.IRON).setUnlocalizedName("pearcelShovel").setTextureName(Reference.MOD_ID + ":pearcelShovel").setMaxStackSize(1).setMaxDamage(2048).setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);

    //General Items
    public static final Item pearcelNugget = new ItemPearcelNugget().setUnlocalizedName("pearcelNugget").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB).setMaxStackSize(16);
    public static final Item pearcelStick = new ItemPearcelStick().setUnlocalizedName("pearcelStick").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item pearcelFlour = new ItemPearcelFlour().setUnlocalizedName("pearcelFlour").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);

    //Compressed Items
    public static final Item compressedSugarCaneItem = new ItemCompressedSugarCaneItem().setUnlocalizedName("compressedSugarCaneItem").setTextureName(Reference.MOD_ID + ":compressedSugarCaneItem").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item compressedSugarCaneItem2 = new ItemCompressedSugarCaneItem().setUnlocalizedName("compressedSugarCaneItem2").setTextureName(Reference.MOD_ID + ":compressedSugarCaneItem2").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item compressedSugarCaneItem3 = new ItemCompressedSugarCaneItem().setUnlocalizedName("compressedSugarCaneItem3").setTextureName(Reference.MOD_ID + ":compressedSugarCaneItem3").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item compressedSugarCaneItem4 = new ItemCompressedSugarCaneItem().setUnlocalizedName("compressedSugarCaneItem4").setTextureName(Reference.MOD_ID + ":compressedSugarCaneItem4").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item compressedSugarCaneItem5 = new ItemCompressedSugarCaneItem().setUnlocalizedName("compressedSugarCaneItem5").setTextureName(Reference.MOD_ID + ":compressedSugarCaneItem5").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item compressedSugarCaneItem6 = new ItemCompressedSugarCaneItem().setUnlocalizedName("compressedSugarCaneItem6").setTextureName(Reference.MOD_ID + ":compressedSugarCaneItem6").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item compressedSugarCaneItem7 = new ItemCompressedSugarCaneItem().setUnlocalizedName("compressedSugarCaneItem7").setTextureName(Reference.MOD_ID + ":compressedSugarCaneItem7").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);
    public static final Item compressedSugarCaneItem8 = new ItemCompressedSugarCaneItem().setUnlocalizedName("compressedSugarCaneItem8").setTextureName(Reference.MOD_ID + ":compressedSugarCaneItem8").setCreativeTab(CreativeTabPearcelMod.PearcelMod_TAB);

	
	public static void init(){
		
		GameRegistry.registerItem(pearcel, "pearcelItem");
        GameRegistry.registerItem(pearcelSeeds, "pearcelSeeds");
        GameRegistry.registerItem(sugarCookie, "sugarCookie");
        GameRegistry.registerItem(pearcelPie, "pearcelPie");
        GameRegistry.registerItem(pearcelBread, "pearcelBread");
		GameRegistry.registerItem(pearcelSword, "pearcelSword");
        GameRegistry.registerItem(pearcelPickaxe, "pearcelPickaxe");
        GameRegistry.registerItem(pearcelAxe, "pearcelAxe");
        GameRegistry.registerItem(pearcelShovel, "pearcelShovel");
		GameRegistry.registerItem(pearcelNugget, "pearcelNugget");
        GameRegistry.registerItem(pearcelStick, "pearcelStick");
        GameRegistry.registerItem(pearcelFlour, "pearcelFlour");
        GameRegistry.registerItem(compressedSugarCaneItem, "compressedSugarCaneItem");
        GameRegistry.registerItem(compressedSugarCaneItem2, "compressedSugarCaneItem2");
        GameRegistry.registerItem(compressedSugarCaneItem3, "compressedSugarCaneItem3");
        GameRegistry.registerItem(compressedSugarCaneItem4, "compressedSugarCaneItem4");
        GameRegistry.registerItem(compressedSugarCaneItem5, "compressedSugarCaneItem5");
        GameRegistry.registerItem(compressedSugarCaneItem6, "compressedSugarCaneItem6");
        GameRegistry.registerItem(compressedSugarCaneItem7, "compressedSugarCaneItem7");
        GameRegistry.registerItem(compressedSugarCaneItem8, "compressedSugarCaneItem8");
		
	}
	
}
