package com.miningmark48.pearcelmod.block;

import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.reference.GUIs;
import com.miningmark48.pearcelmod.reference.Reference;
import com.miningmark48.pearcelmod.tileentity.TileEntityPearcelStorageCrate;
import com.miningmark48.pearcelmod.tileentity.TileEntityPearcelWorkbench;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeChunkManager;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class BlockPearcelWorkbench extends BlockContainer implements IWailaDataProvider{

    public BlockPearcelWorkbench(){
        super(Material.WOOD);
        setResistance(1.25F);
        setHardness(1.0F);
    }

    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }

    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ){
        if (!player.isSneaking()){
            player.openGui(Reference.MOD_ID, GUIs.gui_id_pearcel_workbench, world, pos.getX(), pos.getY(), pos.getZ());
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        TileEntity tileentity = worldIn.getTileEntity(pos);

        if (tileentity instanceof IInventory)
        {
            InventoryHelper.dropInventoryItems(worldIn, pos, (IInventory)tileentity);
            worldIn.updateComparatorOutputLevel(pos, this);
        }

        super.breakBlock(worldIn, pos, state);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityPearcelWorkbench();
    }

    @Nullable
    @Override
    public ItemStack getWailaStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
        return new ItemStack(ModBlocks.pearcel_workbench);
    }

    @Nonnull
    @Override
    public List<String> getWailaHead(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
        return currenttip;
    }

    @Nonnull
    @Override
    public List<String> getWailaBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
        if (accessor.getWorld().getTileEntity(accessor.getPosition()) != null && accessor.getWorld().getTileEntity(accessor.getPosition()) instanceof TileEntityPearcelWorkbench){
            TileEntityPearcelWorkbench workbench = (TileEntityPearcelWorkbench) accessor.getWorld().getTileEntity(accessor.getPosition());
            int j = 0;
            int k = 0;
            int l = 0;
            for (int i = 0; i <= workbench.getSizeInventory(); i++){
                if (workbench.getStackInSlot(i) != null){
                    if (j <= 2) {
                        j++;
                        currenttip.add(workbench.getStackInSlot(i).getDisplayName() + " x" + workbench.getStackInSlot(i).stackSize);
                    }else{
                        k++;
                        l += workbench.getStackInSlot(i).stackSize;
                    }
                }
            }
            if (k != 0 && l != 0) {
                currenttip.add("Plus " + (k) + " more stacks (" + (l) + " items)");
            }else{
                currenttip.add("Empty.");
            }
        }
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
