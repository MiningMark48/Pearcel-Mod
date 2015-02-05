package com.miningmark48.pearcelmod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

import java.util.List;

/**
 * Created by Chris on 2/4/2015.
 */
public class BlockCompressedSugarCaneBlock extends Block
{
    public BlockCompressedSugarCaneBlock()
    {
        super(Material.wood);
        setStepSound(soundTypeWood);
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean isHeld) {
        list.add(EnumChatFormatting.GRAY + StatCollector.translateToLocal("tooltip.pearcel." + getUnlocalizedName().substring(9) + ".desc.0"));
    }
}
