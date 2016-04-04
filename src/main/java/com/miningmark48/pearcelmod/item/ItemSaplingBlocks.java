package com.miningmark48.pearcelmod.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemSaplingBlocks extends ItemBlockWithMetadata{

    public static final String[] saplings = new String[] {"pearcel"};
    private IIcon[] saplingIcons;

    public ItemSaplingBlocks(Block block) {
        super(block, block);
        this.setHasSubtypes(true);
        block.setStepSound(Block.soundTypeGrass);
    }

    public String getUnlocalizedName(ItemStack itemstack){
        int i = itemstack.getItemDamage();
        if (i < 0 || i >= saplings.length){
            i = 0;
        }

        return super.getUnlocalizedName() + "." + saplings[i];
    }

    public int getMetadata(int meta){
        return  meta;
    }

}
