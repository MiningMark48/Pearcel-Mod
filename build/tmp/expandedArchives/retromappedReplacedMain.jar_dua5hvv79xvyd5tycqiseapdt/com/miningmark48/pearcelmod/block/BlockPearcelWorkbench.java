package com.miningmark48.pearcelmod.block;

import com.miningmark48.pearcelmod.reference.GUIs;
import com.miningmark48.pearcelmod.reference.Reference;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockPearcelWorkbench extends BlockPearcelModWood{

    public BlockPearcelWorkbench()
    {
        super();
    }

    public boolean func_180639_a(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ){
        if (!player.func_70093_af()){
            player.openGui(Reference.MOD_ID, GUIs.gui_id_pearcel_workbench, world, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p());
            return true;
        }else{
            return false;
        }
    }

}
