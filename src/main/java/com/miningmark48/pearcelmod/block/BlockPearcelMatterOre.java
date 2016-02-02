package com.miningmark48.pearcelmod.block;

import com.miningmark48.pearcelmod.init.ModItems;
import net.minecraft.item.Item;
import java.util.Random;

public class BlockPearcelMatterOre extends BlockPearcelMod{

    public BlockPearcelMatterOre(){
        setHardness(5.0F);
        setResistance(0.1F);
    }

    @Override
    public Item getItemDropped(int meta, Random random, int fortune) {
        return ModItems.pearcelMatter;
    }

}
