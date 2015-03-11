package com.miningmark48.pearcelmod.block;

import net.minecraft.block.BlockEnchantmentTable;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntityEnchantmentTable;
import net.minecraft.world.World;

public class BlockMEMagicTable extends BlockEnchantmentTable{

    public BlockMEMagicTable()
    {
        super();
    }

    @Override
    public boolean onBlockActivated(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        if (p_149727_1_.isRemote) {
            return true;
        } else {
            TileEntityEnchantmentTable tileentityenchantmenttable = (TileEntityEnchantmentTable) p_149727_1_.getTileEntity(p_149727_2_, p_149727_3_, p_149727_4_);
            p_149727_5_.displayGUIEnchantment(p_149727_2_, p_149727_3_, p_149727_4_, tileentityenchantmenttable.func_145921_b() ? tileentityenchantmenttable.func_145919_a() : null);
            return true;
        }

    }
}
