package com.miningmark48.pearcelmod.block;

import com.miningmark48.mininglib.utility.ModTranslate;
import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import com.miningmark48.pearcelmod.init.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class BlockTorcher extends BlockPearcelMod{

    int torcherFreq;

    private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0.375D, 0.0D, 0.375D, 0.625D, 1.0D, 0.625D);

    public BlockTorcher(){
        setHardness(0.5F);
        setResistance(2.5F);
        setLightLevel(1.25F);
    }

    @Override
    @SuppressWarnings("deprecation")
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return BOUNDING_BOX;
    }

    @Override
    @SuppressWarnings("deprecation")
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean p_185477_7_) {
        super.addCollisionBoxToList(pos, entityBox, collidingBoxes, BOUNDING_BOX);
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isFullCube(IBlockState state){
        return false;
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isOpaqueCube(IBlockState state){
        return false;
    }

    @Override
    public BlockRenderLayer getBlockLayer(){
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
        if (!player.isSneaking()){

            Random rand = new Random();
            int rangeRand = (rand.nextInt(ConfigurationHandler.torcherRange) + 1) * 2;
            if (blockState.getBlock().getMaterial(world.getBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ()))).isSolid()){
                world.setBlockState(pos, ModBlocks.pearcel_torch.getDefaultState());
            }else{
                world.setBlockToAir(pos);
            }

            if (ConfigurationHandler.torcherFrequency > 1){
                torcherFreq = ConfigurationHandler.torcherFrequency;
            }else{
                torcherFreq = 2;
            }

            for (int i = 1; i <= rangeRand * torcherFreq; i++){
                rangeRand = (rand.nextInt(50) + 1) * 2;
                int numRand = rand.nextInt(8) + 1;
                int torchX;
                int torchY;
                int torchZ;
                switch (numRand){
                    default:
                    case 1:
                        torchX = pos.getX() + rangeRand;
                        torchY = pos.getY();
                        torchZ = pos.getZ() + rangeRand;
                        break;
                    case 2:
                        torchX = pos.getX() - rangeRand;
                        torchY = pos.getY();
                        torchZ = pos.getZ() - rangeRand;
                        break;
                    case 3:
                        torchX = pos.getX() + rangeRand;
                        torchY = pos.getY();
                        torchZ = pos.getZ() - rangeRand;
                        break;
                    case 4:
                        torchX = pos.getX() - rangeRand;
                        torchY = pos.getY();
                        torchZ = pos.getZ() + rangeRand;
                        break;
                    case 5:
                        torchX = pos.getX() - rangeRand;
                        torchY = pos.getY();
                        torchZ = pos.getZ();
                        break;
                    case 6:
                        torchX = pos.getX() + rangeRand;
                        torchY = pos.getY();
                        torchZ = pos.getZ();
                        break;
                    case 7:
                        torchX = pos.getX();
                        torchY = pos.getY();
                        torchZ = pos.getZ() - rangeRand;
                        break;
                    case 8:
                        torchX = pos.getX();
                        torchY = pos.getY();
                        torchZ = pos.getZ() + rangeRand;
                        break;
                }
                if (world.getBlockState(new BlockPos(torchX, torchY, torchZ)).getBlock().isReplaceable(world, new BlockPos(torchX, torchY, torchZ))){
                    if (blockState.getBlock().getMaterial(world.getBlockState(new BlockPos(torchX, torchY - 1, torchZ))).isSolid()){
                        world.setBlockState(new BlockPos(torchX, torchY, torchZ), ModBlocks.pearcel_torch.getDefaultState());
                    }
                }
            }
            player.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 1.0F, 0.5F);
            world.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, pos.getX(), pos.getY(), pos.getZ(), 1.0D, 0.0D, 0.0D);
            world.spawnEntity(new EntityLightningBolt(world, pos.getX(), pos.getY(), pos.getZ(), true));
            if (!world.isRemote){
                player.sendMessage(new TextComponentString(TextFormatting.GOLD + ModTranslate.toLocal("chat.torcher.lit")));
            }

            return true;

        }else{
            return false;
        }
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
    {
        EnumFacing enumfacing = EnumFacing.DOWN;
        double d0 = (double)pos.getX() + 0.5D;
        double d1 = (double)pos.getY() + 1.125D;
        double d2 = (double)pos.getZ() + 0.5D;
        double d3 = 0.22D;
        double d4 = 0.27D;

        if (enumfacing.getAxis().isHorizontal())
        {
            EnumFacing enumfacing1 = enumfacing.getOpposite();
            worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 + d4 * (double)enumfacing1.getFrontOffsetX(), d1 + d3, d2 + d4 * (double)enumfacing1.getFrontOffsetZ(), 0.0D, 0.0D, 0.0D, new int[0]);
            worldIn.spawnParticle(EnumParticleTypes.FLAME, d0 + d4 * (double)enumfacing1.getFrontOffsetX(), d1 + d3, d2 + d4 * (double)enumfacing1.getFrontOffsetZ(), 0.0D, 0.0D, 0.0D, new int[0]);
        }
        else
        {
            worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
            worldIn.spawnParticle(EnumParticleTypes.FLAME, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
        }
    }

}
