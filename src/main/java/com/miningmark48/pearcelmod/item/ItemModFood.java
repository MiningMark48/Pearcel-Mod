package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.init.ModItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public class ItemModFood extends ItemFood{

	public ItemModFood(int healAmount, float saturationModifier, boolean isWolfFood)
    {
		super(healAmount, saturationModifier, isWolfFood);
	}

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean isHeld) {
        list.add(EnumChatFormatting.GRAY + StatCollector.translateToLocal("tooltip." + getUnlocalizedName() + ".line1"));
    }
	
}
