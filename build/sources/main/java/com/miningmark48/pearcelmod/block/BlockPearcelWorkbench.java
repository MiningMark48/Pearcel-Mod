package com.miningmark48.pearcelmod.block;

import com.miningmark48.pearcelmod.reference.GUIs;
import com.miningmark48.pearcelmod.reference.Reference;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockPearcelWorkbench extends BlockPearcelModWood{

    public BlockPearcelWorkbench()
    {
        super();
    }

    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ){
        if (!player.isSneaking()){
            player.openGui(Reference.MOD_ID, GUIs.gui_id_pearcel_workbench, world, pos.getX(), pos.getY(), pos.getZ());
            return true;
        }else{
            return false;
        }
    }

}
