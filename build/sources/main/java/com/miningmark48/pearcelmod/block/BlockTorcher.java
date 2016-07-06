package com.miningmark48.pearcelmod.block;

import com.google.common.base.Predicate;
import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.utility.Translate;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
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
        setLightLevel(1.0F);
        //setBlockBounds(0.375F, 0.0F, 0.375F, 0.625F, 1.0F, 0.625F);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return BOUNDING_BOX;
    }

    @Override
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn) {
        super.addCollisionBoxToList(pos, entityBox, collidingBoxes, BOUNDING_BOX);
    }

    public static final PropertyDirection FACING = PropertyDirection.create("facing", new Predicate<EnumFacing>()
    {
        public boolean apply(EnumFacing p_apply_1_)
        {
            return p_apply_1_ != EnumFacing.DOWN;
        }
    });

    @Override
    public boolean isFullCube(IBlockState state){
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state){
        return false;
    }

    @Override
    public BlockRenderLayer getBlockLayer(){
        return BlockRenderLayer.CUTOUT;
    }

    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ){
        if (!player.isSneaking()){

            //player.addStat(Achievements.achievementTorcher, 1);

            Random rand = new Random();
            int rangeRand = (rand.nextInt(ConfigurationHandler.torcherRange) + 1) * 2;
            if (world.getBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ())).getBlock().isBlockSolid(world, pos, null)){
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
                int torchX = pos.getX();
                int torchY = pos.getY();
                int torchZ = pos.getZ();
                if (numRand == 1){
                    torchX = pos.getX() + rangeRand;
                    torchY = pos.getY();
                    torchZ = pos.getZ() + rangeRand;
                }else if(numRand == 2){
                    torchX = pos.getX() - rangeRand;
                    torchY = pos.getY();
                    torchZ = pos.getZ() - rangeRand;
                }else if(numRand == 3){
                    torchX = pos.getX() + rangeRand;
                    torchY = pos.getY();
                    torchZ = pos.getZ() - rangeRand;
                }else if(numRand == 4){
                    torchX = pos.getX() - rangeRand;
                    torchY = pos.getY();
                    torchZ = pos.getZ() + rangeRand;
                }else if(numRand == 5){
                    torchX = pos.getX() - rangeRand;
                    torchY = pos.getY();
                    torchZ = pos.getZ();
                }else if(numRand == 6){
                    torchX = pos.getX() + rangeRand;
                    torchY = pos.getY();
                    torchZ = pos.getZ();
                }else if(numRand == 7){
                    torchX = pos.getX();
                    torchY = pos.getY();
                    torchZ = pos.getZ() - rangeRand;
                }else if(numRand == 8){
                    torchX = pos.getX();
                    torchY = pos.getY();
                    torchZ = pos.getZ() + rangeRand;
                }
                if (world.getBlockState(new BlockPos(torchX, torchY, torchZ)).getBlock().isReplaceable(world, new BlockPos(torchX, torchY, torchZ))){
                    if (world.getBlockState(new BlockPos(torchX, torchY - 1, torchZ)).getBlock().isBlockSolid(world, pos, null)){
                        world.setBlockState(new BlockPos(torchX, torchY, torchZ), ModBlocks.pearcel_torch.getDefaultState());
                    }
                }
            }
            player.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 1.0F, 0.5F);
            world.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, pos.getX(), pos.getY(), pos.getZ(), 1.0D, 0.0D, 0.0D);
            world.spawnEntityInWorld(new EntityLightningBolt(world, pos.getX(), pos.getY(), pos.getZ(), true));
            if (!world.isRemote){
                player.addChatComponentMessage(new TextComponentString(TextFormatting.GOLD + Translate.toLocal("chat.torcher.lit")));
            }

            return true;

        }else{
            return false;
        }
    }

    @SideOnly(Side.CLIENT)
    public void randomTick(World worldIn, BlockPos pos, IBlockState state, Random random)
    {
        EnumFacing enumfacing = EnumFacing.DOWN;
        double d0 = (double)pos.getX() + 0.5D;
        double d1 = (double)pos.getY() + 1.1D;
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
