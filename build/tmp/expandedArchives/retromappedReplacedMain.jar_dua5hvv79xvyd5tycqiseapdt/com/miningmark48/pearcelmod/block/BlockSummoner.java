package com.miningmark48.pearcelmod.block;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockSummoner extends BlockPearcelMod{

    public BlockSummoner(){

    }

    public boolean func_180639_a(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ){
        if (!world.field_72995_K) {
            player.func_146105_b(new ChatComponentText(EnumChatFormatting.RED + "Not functional yet!"));
        }
        return false;
    }

}
