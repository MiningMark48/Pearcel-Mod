package com.miningmark48.pearcelmod.block;

import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.item.ItemSlimeyPearcel;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class BlockFoolsPearcelOre extends BlockPearcelMod implements IWailaDataProvider{

    public BlockFoolsPearcelOre(){
        super();
    }

    public void onBlockDestroyedByPlayer(World world, BlockPos pos, IBlockState state){
        Random rand = new Random();
        int randNum = rand.nextInt(4) + 1;
        if (!world.isRemote){
            if (randNum == 1) {
                if (world.getBlockState(pos).getBlock() == Blocks.AIR) {
                    world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 3F, true);
                }
            }
        }
    }

    public void onBlockDestroyedByExplosion(World world, BlockPos pos, Explosion explosionIn){
        Random rand = new Random();
        int randNum = rand.nextInt(4) + 1;
        if (!world.isRemote){
            if (randNum == 1) {
                if (world.getBlockState(pos).getBlock() == Blocks.AIR) {
                    world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 3F, true);
                }
            }
        }
    }

    @Nullable
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return new ItemStack(ModBlocks.pearcel_ore).getItem();
    }


    @Nullable
    @Override
    public ItemStack getWailaStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
        return new ItemStack(ModBlocks.pearcel_ore);
    }

    @Nonnull
    @Override
    public List<String> getWailaHead(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
        return currenttip;
    }

    @Nonnull
    @Override
    public List<String> getWailaBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
        return currenttip;
    }

    @Nonnull
    @Override
    public List<String> getWailaTail(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
        return currenttip;
    }

    @Nonnull
    @Override
    public NBTTagCompound getNBTData(EntityPlayerMP player, TileEntity te, NBTTagCompound tag, World world, BlockPos pos) {
        return tag;
    }
}
