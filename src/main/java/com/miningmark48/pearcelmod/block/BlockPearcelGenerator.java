package com.miningmark48.pearcelmod.block;

import com.miningmark48.pearcelmod.PearcelMod;
import com.miningmark48.pearcelmod.reference.GUIs;
import com.miningmark48.pearcelmod.tileentity.TileEntityPearcelGenerator;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockPearcelGenerator extends BlockContainer{

    public BlockPearcelGenerator() {
        super(Material.ROCK);
    }

    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote){
            if (playerIn != null) {
                playerIn.openGui(PearcelMod.instance, GUIs.gui_id_pearcel_generator, worldIn, pos.getX(), pos.getY(), pos.getZ());
            }
        }
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityPearcelGenerator();
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        TileEntityPearcelGenerator te = (TileEntityPearcelGenerator) worldIn.getTileEntity(pos);
        InventoryHelper.dropInventoryItems(worldIn, pos, te);
        super.breakBlock(worldIn, pos, state);
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        if (stack.hasDisplayName()){
            ((TileEntityPearcelGenerator) worldIn.getTileEntity(pos)).setCustomName(stack.getDisplayName());
        }
    }
}
