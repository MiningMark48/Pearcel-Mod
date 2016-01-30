package com.miningmark48.pearcelmod.item;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemPearcelSword extends ItemSword{

	public ItemPearcelSword(ToolMaterial material)
    {
		super(material);
	}

    @Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
            par3List.add(StatCollector.translateToLocal("tooltip.item.pearcelSword.line1"));
    }
}
