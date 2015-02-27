package com.miningmark48.pearcelmod.block;

import com.miningmark48.pearcelmod.PearcelMod;
import com.miningmark48.pearcelmod.client.gui.Gui;
import com.miningmark48.pearcelmod.utility.LogHelper;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.gui.inventory.GuiCrafting;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeCache;

public class BlockMEWorkbench extends Block
{
    @SideOnly(Side.CLIENT)
    private IIcon field_150035_a;
    @SideOnly(Side.CLIENT)
    private IIcon field_150034_b;
    private static final String __OBFID = "CL_00000221";

    public BlockMEWorkbench()
    {
        super(Material.wood);
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return p_149691_1_ == 1 ? this.field_150035_a : (p_149691_1_ == 0 ? Blocks.planks.getBlockTextureFromSide(p_149691_1_) : (p_149691_1_ != 2 && p_149691_1_ != 4 ? this.blockIcon : this.field_150034_b));
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.blockIcon = p_149651_1_.registerIcon(this.getTextureName() + "_side");
        this.field_150035_a = p_149651_1_.registerIcon(this.getTextureName() + "_top");
        this.field_150034_b = p_149651_1_.registerIcon(this.getTextureName() + "_front");
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float sideX, float sideY, float sideZ)
    {
        if (world.isRemote)
        {
            //LogHelper.info("ME^Workbench clicked. -- Remote");
            return true;
        }
        else
        {
            //player.displayGUIWorkbench(x, y, z);
            player.openGui(PearcelMod.instance, Gui.GUI_ID, world, x, y, z);
            //LogHelper.info("ME^Workbench clicked. -- Not Remote");
            return true;
        }
    }

}