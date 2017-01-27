package com.miningmark48.pearcelmod.block;

import net.minecraft.block.BlockBasePressurePlate;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class BlockPearcelPressurePlate extends BlockBasePressurePlate{

    public static final PropertyBool POWERED = PropertyBool.create("powered");
    public static final PropertyBool MODE_PLAYERS = PropertyBool.create("mode_players");
    public static final PropertyBool MODE_ITEMS = PropertyBool.create("mode_items");

    private final Item mode_items_item = Items.ARROW;

    public BlockPearcelPressurePlate()
    {
        super(Material.PISTON);
        this.setDefaultState(this.blockState.getBaseState().withProperty(POWERED, false).withProperty(MODE_PLAYERS, true).withProperty(MODE_ITEMS, false));
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (heldItem != null){
            if (heldItem.getItem().equals(mode_items_item) && !worldIn.getBlockState(pos).getValue(MODE_ITEMS)){
                worldIn.setBlockState(pos, getDefaultState().withProperty(POWERED, false).withProperty(MODE_PLAYERS, false).withProperty(MODE_ITEMS, true));
                if (!playerIn.isCreative() && !worldIn.isRemote){
                    if (heldItem.stackSize > 0){
                        --heldItem.stackSize;
                    }
                }
            }
        }else{
            if (worldIn.getBlockState(pos).getValue(MODE_ITEMS)){
                worldIn.setBlockState(pos, getDefaultState().withProperty(POWERED, false).withProperty(MODE_PLAYERS, true).withProperty(MODE_ITEMS, false));
                if (!playerIn.isCreative() && !worldIn.isRemote){
                    EntityItem entityItem = new EntityItem(worldIn);
                    entityItem.setEntityItemStack(new ItemStack(mode_items_item));
                    entityItem.setPosition(playerIn.posX + 0.5D, playerIn.posY + 0.5D, playerIn.posZ + 0.5D);
                    worldIn.spawnEntityInWorld(entityItem);
                }
            }
        }

        worldIn.spawnParticle(EnumParticleTypes.CLOUD, pos.getX() + 0.5, pos.getY() + 0.5D, pos.getZ() + 0.5, 0.0125D, 0.125D, 0.0125D);

        return true;
    }

//    @Override
//    public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
//        if (state.getValue(MODE_ITEMS)){
//            EntityItem mode_entity = new EntityItem(worldIn);
//            mode_entity.setEntityItemStack(new ItemStack(mode_items_item));
//            mode_entity.setPosition(pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D);
//            if (!worldIn.isRemote) {
//                worldIn.spawnEntityInWorld(mode_entity);
//            }
//        }
//    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
        if (!player.isCreative()) {
            if (state.getValue(MODE_ITEMS)) {
                EntityItem mode_entity = new EntityItem(worldIn);
                mode_entity.setEntityItemStack(new ItemStack(mode_items_item));
                mode_entity.setPosition(pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D);
                if (!worldIn.isRemote) {
                    worldIn.spawnEntityInWorld(mode_entity);
                }
            }
        }
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        worldIn.setBlockState(pos, getDefaultState().withProperty(POWERED, false).withProperty(MODE_PLAYERS, true).withProperty(MODE_ITEMS, false));
    }

    protected int getRedstoneStrength(IBlockState state)
    {
        return (Boolean) state.getValue(POWERED) ? 15 : 0;
    }

    protected IBlockState setRedstoneStrength(IBlockState state, int strength)
    {
        return state.withProperty(POWERED, strength > 0);
    }

    protected void playClickOnSound(World worldIn, BlockPos color)
    {
        worldIn.playSound((EntityPlayer)null, color, SoundEvents.BLOCK_STONE_PRESSPLATE_CLICK_ON, SoundCategory.BLOCKS, 0.3F, 0.6F);
    }

    protected void playClickOffSound(World worldIn, BlockPos pos)
    {
        worldIn.playSound((EntityPlayer)null, pos, SoundEvents.BLOCK_STONE_PRESSPLATE_CLICK_OFF, SoundCategory.BLOCKS, 0.3F, 0.5F);
    }

    protected int computeRedstoneStrength(World worldIn, BlockPos pos)
    {
        AxisAlignedBB axisalignedbb = PRESSURE_AABB.offset(pos);
        List<? extends Entity > list;

        if (worldIn.getBlockState(pos).getValue(MODE_PLAYERS)){
            list = worldIn.<EntityPlayer>getEntitiesWithinAABB(EntityPlayer.class, axisalignedbb);
        }else if (worldIn.getBlockState(pos).getValue(MODE_ITEMS)){
            list = worldIn.<EntityItem>getEntitiesWithinAABB(EntityItem.class, axisalignedbb);
        }else{
            return 0;
        }

        if (!list.isEmpty())
        {
            for (Entity entity : list)
            {
                if (!entity.doesEntityNotTriggerPressurePlate())
                {
                    return 15;
                }
            }
        }

        return 0;
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    @SuppressWarnings("deprecation")
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(POWERED, meta == 6 || meta == 8).withProperty(MODE_PLAYERS, meta == 5 || meta == 6).withProperty(MODE_ITEMS, meta == 7 || meta == 8);
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        return ((Boolean) state.getValue(POWERED) ? 1 : 0) + (state.getValue(MODE_PLAYERS) ? 5 : 0) + (state.getValue(MODE_ITEMS) ? 7 : 0);
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, POWERED, MODE_PLAYERS, MODE_ITEMS);
    }

}
