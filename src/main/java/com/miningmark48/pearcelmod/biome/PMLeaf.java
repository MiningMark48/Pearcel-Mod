package com.miningmark48.pearcelmod.biome;

import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.init.ModItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockLeaves;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class PMLeaf extends BlockLeaves{

    public static final String[][] leafTypes = new String[][] {{"leafPearcel", "leafME"}, {"leafPearcelOpaque", "leafMEOpaque"}};
    public static final String[] leaves = new String[] {"pearcel", "me"};

    protected void func_150124_c(World world, int x, int y, int z, int side, int meta)
    {
        if (world.rand.nextInt(meta) == 0) //(side & 3) == 1 &&
        {
            this.dropBlockAsItem(world, x, y, z, new ItemStack(ModItems.pearcel, 1, 0));
        }
    }

    public int damageDropped(int p_149692_1_)
    {
        return super.damageDropped(p_149692_1_);
    }

    public int getDamageValue(World world, int x, int y, int z)
    {
        return world.getBlockMetadata(x, y, z) & 3;
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List list)
    {
        for (int i = 0; i < leaves.length; i++){
            list.add(new ItemStack(item, 1, i));
        }
    }

    @Override
    public Item getItemDropped(int par1, Random random, int par2) {
        return Item.getItemFromBlock(ModBlocks.blockSapling);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        for (int i = 0; i < leafTypes.length; ++i)
        {
            this.field_150129_M[i] = new IIcon[leafTypes[i].length];

            for (int j = 0; j < leafTypes[i].length; ++j)
            {
                this.field_150129_M[i][j] = iconRegister.registerIcon(this.getTextureName() +  "_" + leafTypes[i][j]);
            }
        }
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return (meta & 3) == 1 ? this.field_150129_M[this.field_150127_b][1] : this.field_150129_M[this.field_150127_b][0];
    }

    @Override
    public String[] func_150125_e() {
        return leaves;
    }

    @Override
    public boolean renderAsNormalBlock(){
        return false;
    }

    @Override
    public boolean isOpaqueCube(){
        return false;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess blockaccess, int x, int y, int z, int side){
        return true;
    }
}
