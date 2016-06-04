package com.miningmark48.pearcelmod.block;

import com.google.common.base.Predicate;
import com.miningmark48.pearcelmod.init.ModBlocks;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockPearcelTorch extends BlockPearcelMod {
    private static final String __OBFID = "CL_00000325";

    public BlockPearcelTorch()
    {
        super();
        this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(FACING, EnumFacing.UP));
        this.func_149675_a(true);
        func_149711_c(0.0F);
        func_149715_a(0.85F);
    }

    public void onBlockHarvested(World world, int par2, int par3, int par4, int par5, EntityPlayer player) {
        if (!player.field_71075_bZ.field_75098_d) {
            player.field_71071_by.func_70441_a(new ItemStack(ModBlocks.pearcel_torch));
        }
    }

    public static final PropertyDirection FACING = PropertyDirection.func_177712_a("facing", new Predicate<EnumFacing>()
    {
        public boolean apply(EnumFacing p_apply_1_)
        {
            return p_apply_1_ != EnumFacing.DOWN;
        }
    });

    public AxisAlignedBB func_180640_a(World worldIn, BlockPos pos, IBlockState state)
    {
        return null;
    }

    public boolean func_149662_c()
    {
        return false;
    }

    public boolean func_149686_d()
    {
        return false;
    }

    private boolean canPlaceOn(World worldIn, BlockPos pos)
    {
        if (World.func_175683_a(worldIn, pos))
        {
            return true;
        }
        else
        {
            Block block = worldIn.func_180495_p(pos).func_177230_c();
            return block.canPlaceTorchOnTop(worldIn, pos);
        }
    }

    public boolean func_176196_c(World worldIn, BlockPos pos)
    {
        for (EnumFacing enumfacing : FACING.func_177700_c())
        {
            if (this.canPlaceAt(worldIn, pos, enumfacing))
            {
                return true;
            }
        }

        return false;
    }

    private boolean canPlaceAt(World worldIn, BlockPos pos, EnumFacing facing)
    {
        BlockPos blockpos = pos.func_177972_a(facing.func_176734_d());
        boolean flag = facing.func_176740_k().func_176722_c();
        return flag && worldIn.isSideSolid(blockpos, facing, true) || facing.equals(EnumFacing.UP) && this.canPlaceOn(worldIn, blockpos);
    }

    public IBlockState func_180642_a(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        if (this.canPlaceAt(worldIn, pos, facing))
        {
            return this.func_176223_P().func_177226_a(FACING, facing);
        }
        else
        {
            for (EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL)
            {
                if (worldIn.isSideSolid(pos.func_177972_a(enumfacing.func_176734_d()), enumfacing, true))
                {
                    return this.func_176223_P().func_177226_a(FACING, enumfacing);
                }
            }

            return this.func_176223_P();
        }
    }

    public void func_176213_c(World worldIn, BlockPos pos, IBlockState state)
    {
        this.checkForDrop(worldIn, pos, state);
    }

    public void func_176204_a(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
    {
        this.onNeighborChangeInternal(worldIn, pos, state);
    }

    protected boolean onNeighborChangeInternal(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!this.checkForDrop(worldIn, pos, state))
        {
            return true;
        }
        else
        {
            EnumFacing enumfacing = (EnumFacing)state.func_177229_b(FACING);
            EnumFacing.Axis enumfacing$axis = enumfacing.func_176740_k();
            EnumFacing enumfacing1 = enumfacing.func_176734_d();
            boolean flag = false;

            if (enumfacing$axis.func_176722_c() && !worldIn.isSideSolid(pos.func_177972_a(enumfacing1), enumfacing, true))
            {
                flag = true;
            }
            else if (enumfacing$axis.func_176720_b() && !this.canPlaceOn(worldIn, pos.func_177972_a(enumfacing1)))
            {
                flag = true;
            }

            if (flag)
            {
                this.func_176226_b(worldIn, pos, state, 0);
                worldIn.func_175698_g(pos);
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    protected boolean checkForDrop(World worldIn, BlockPos pos, IBlockState state)
    {
        if (state.func_177230_c() == this && this.canPlaceAt(worldIn, pos, (EnumFacing)state.func_177229_b(FACING)))
        {
            return true;
        }
        else
        {
            if (worldIn.func_180495_p(pos).func_177230_c() == this)
            {
                this.func_176226_b(worldIn, pos, state, 0);
                worldIn.func_175698_g(pos);
            }

            return false;
        }
    }

    public MovingObjectPosition func_180636_a(World worldIn, BlockPos pos, Vec3 start, Vec3 end)
    {
        EnumFacing enumfacing = (EnumFacing)worldIn.func_180495_p(pos).func_177229_b(FACING);
        float f = 0.15F;

        if (enumfacing == EnumFacing.EAST)
        {
            this.func_149676_a(0.0F, 0.2F, 0.5F - f, f * 2.0F, 0.8F, 0.5F + f);
        }
        else if (enumfacing == EnumFacing.WEST)
        {
            this.func_149676_a(1.0F - f * 2.0F, 0.2F, 0.5F - f, 1.0F, 0.8F, 0.5F + f);
        }
        else if (enumfacing == EnumFacing.SOUTH)
        {
            this.func_149676_a(0.5F - f, 0.2F, 0.0F, 0.5F + f, 0.8F, f * 2.0F);
        }
        else if (enumfacing == EnumFacing.NORTH)
        {
            this.func_149676_a(0.5F - f, 0.2F, 1.0F - f * 2.0F, 0.5F + f, 0.8F, 1.0F);
        }
        else
        {
            f = 0.1F;
            this.func_149676_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.6F, 0.5F + f);
        }

        return super.func_180636_a(worldIn, pos, start, end);
    }

    public IBlockState func_176203_a(int meta)
    {
        IBlockState iblockstate = this.func_176223_P();

        switch (meta)
        {
            case 1:
                iblockstate = iblockstate.func_177226_a(FACING, EnumFacing.EAST);
                break;
            case 2:
                iblockstate = iblockstate.func_177226_a(FACING, EnumFacing.WEST);
                break;
            case 3:
                iblockstate = iblockstate.func_177226_a(FACING, EnumFacing.SOUTH);
                break;
            case 4:
                iblockstate = iblockstate.func_177226_a(FACING, EnumFacing.NORTH);
                break;
            case 5:
            default:
                iblockstate = iblockstate.func_177226_a(FACING, EnumFacing.UP);
        }

        return iblockstate;
    }

    @SideOnly(Side.CLIENT)
    public void func_180655_c(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        EnumFacing enumfacing = (EnumFacing)state.func_177229_b(FACING);
        double d0 = (double)pos.func_177958_n() + 0.5D;
        double d1 = (double)pos.func_177956_o() + 0.7D;
        double d2 = (double)pos.func_177952_p() + 0.5D;
        double d3 = 0.22D;
        double d4 = 0.27D;

        if (enumfacing.func_176740_k().func_176722_c())
        {
            EnumFacing enumfacing1 = enumfacing.func_176734_d();
            worldIn.func_175688_a(EnumParticleTypes.SMOKE_NORMAL, d0 + d4 * (double)enumfacing1.func_82601_c(), d1 + d3, d2 + d4 * (double)enumfacing1.func_82599_e(), 0.0D, 0.0D, 0.0D, new int[0]);
            worldIn.func_175688_a(EnumParticleTypes.FLAME, d0 + d4 * (double)enumfacing1.func_82601_c(), d1 + d3, d2 + d4 * (double)enumfacing1.func_82599_e(), 0.0D, 0.0D, 0.0D, new int[0]);
        }
        else
        {
            worldIn.func_175688_a(EnumParticleTypes.SMOKE_NORMAL, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
            worldIn.func_175688_a(EnumParticleTypes.FLAME, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
        }
    }

    public int func_176201_c(IBlockState state)
    {
        int i = 0;

        switch ((EnumFacing)state.func_177229_b(FACING))
        {
            case EAST:
                i = i | 1;
                break;
            case WEST:
                i = i | 2;
                break;
            case SOUTH:
                i = i | 3;
                break;
            case NORTH:
                i = i | 4;
                break;
            case DOWN:
            case UP:
            default:
                i = i | 5;
        }

        return i;
    }

    @SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer func_180664_k()
    {
        return EnumWorldBlockLayer.CUTOUT;
    }

    protected BlockState func_180661_e()
    {
        return new BlockState(this, new IProperty[] {FACING});
    }
}