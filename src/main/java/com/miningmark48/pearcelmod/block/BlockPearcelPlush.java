package com.miningmark48.pearcelmod.block;

import com.miningmark48.pearcelmod.tileentity.TileEntityPearcelPlush;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockPearcelPlush extends BlockContainer{

    public BlockPearcelPlush(Material material){
        super(material);
        this.setBlockBounds(0.125F, 0.0F, 0.1875F, 0.8125F, 1.25F, 0.875F);
    }

    public int getRenderType(){
        return -1;
    }

    public boolean isOpaqueCube(){
        return false;
    }

    public boolean renderAsNormalBlock(){
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World par1, int par2) {
        return new TileEntityPearcelPlush();
    }

}
