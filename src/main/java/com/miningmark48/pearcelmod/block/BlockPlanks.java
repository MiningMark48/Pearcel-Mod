package com.miningmark48.pearcelmod.block;

import net.minecraft.block.material.Material;

public class BlockPlanks extends BlockPearcelMod{

    public BlockPlanks(){
        super(Material.wood);
        this.setHardness(2.0F);
        this.setResistance(5.0F);
        this.setHarvestLevel("axe", 0);
    }

}
