package com.miningmark48.pearcelmod.block;

import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.reference.GUIs;
import com.miningmark48.pearcelmod.reference.Reference;
import com.miningmark48.pearcelmod.tileentity.TileEntityIVET;
import com.miningmark48.pearcelmod.tileentity.TileEntityPearcelPlush;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

public class BlockIVET extends BlockContainer{
    @SideOnly(Side.CLIENT)
    private IIcon field_150035_a;
    @SideOnly(Side.CLIENT)
    private IIcon field_150034_b;
    private static final String __OBFID = "CL_00000221";

    public BlockIVET(Material material){
        super(material);
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
        return new TileEntityIVET();
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    /*@SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return p_149691_1_ == 1 ? this.field_150035_a : (p_149691_1_ == 0 ? ModBlocks.pearcelBlock.getBlockTextureFromSide(p_149691_1_) : (p_149691_1_ != 2 && p_149691_1_ != 4 ? this.blockIcon : this.field_150034_b));
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.blockIcon = p_149651_1_.registerIcon(this.getTextureName() + "_side");
        this.field_150035_a = p_149651_1_.registerIcon(this.getTextureName() + "_top");
        this.field_150034_b = p_149651_1_.registerIcon(this.getTextureName() + "_front");
    }*/

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_)
    {
        super.randomDisplayTick(p_149734_1_, p_149734_2_, p_149734_3_, p_149734_4_, p_149734_5_);

        for (int l = p_149734_2_ - 2; l <= p_149734_2_ + 2; ++l)
        {
            for (int i1 = p_149734_4_ - 2; i1 <= p_149734_4_ + 2; ++i1)
            {
                if (l > p_149734_2_ - 2 && l < p_149734_2_ + 2 && i1 == p_149734_4_ - 1)
                {
                    i1 = p_149734_4_ + 2;
                }

                if (p_149734_5_.nextInt(16) == 0)
                {
                    for (int j1 = p_149734_3_; j1 <= p_149734_3_ + 1; ++j1)
                    {
                        if (p_149734_1_.getBlock(l, j1, i1) == Blocks.air)
                        {
                            if (!p_149734_1_.isAirBlock((l - p_149734_2_) / 2 + p_149734_2_, j1, (i1 - p_149734_4_) / 2 + p_149734_4_))
                            {
                                break;
                            }

                            p_149734_1_.spawnParticle("enchantmenttable", (double)p_149734_2_ + 0.5D, (double)p_149734_3_ + 2.0D, (double)p_149734_4_ + 0.5D, (double)((float)(l - p_149734_2_) + p_149734_5_.nextFloat()) - 0.5D, (double)((float)(j1 - p_149734_3_) - p_149734_5_.nextFloat() - 1.0F), (double)((float)(i1 - p_149734_4_) + p_149734_5_.nextFloat()) - 0.5D);
                        }
                    }
                }
            }
        }
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
        if (!player.isSneaking()){
            player.openGui(Reference.MOD_ID, GUIs.guiIDIVET, world, x, y, z);
            return true;
        }else{
            return false;
        }
    }
}