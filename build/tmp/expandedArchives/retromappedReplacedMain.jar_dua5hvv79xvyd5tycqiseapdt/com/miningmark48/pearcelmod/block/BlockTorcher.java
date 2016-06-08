package com.miningmark48.pearcelmod.block;

import com.google.common.base.Predicate;
import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import com.miningmark48.pearcelmod.init.ModBlocks;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BlockTorcher extends BlockPearcelMod{

    int torcherFreq;

    public BlockTorcher(){
        func_149711_c(0.5F);
        func_149752_b(2.5F);
        func_149715_a(1.0F);
        func_149676_a(0.375F, 0.0F, 0.375F, 0.625F, 1.0F, 0.625F);
    }

    public static final PropertyDirection FACING = PropertyDirection.func_177712_a("facing", new Predicate<EnumFacing>()
    {
        public boolean apply(EnumFacing p_apply_1_)
        {
            return p_apply_1_ != EnumFacing.DOWN;
        }
    });

    @Override
    public boolean func_149662_c(){
        return false;
    }

    @SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer func_180664_k()
    {
        return EnumWorldBlockLayer.CUTOUT;
    }

    public boolean func_180639_a(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ){
        if (!player.func_70093_af()){

            //player.addStat(Achievements.achievementTorcher, 1);

            Random rand = new Random();
            int rangeRand = (rand.nextInt(ConfigurationHandler.torcherRange) + 1) * 2;
            if (world.func_180495_p(new BlockPos(pos.func_177958_n(), pos.func_177956_o() - 1, pos.func_177952_p())).func_177230_c().func_149688_o().func_76220_a()){
                world.func_175656_a(pos, ModBlocks.pearcel_torch.func_176223_P());
            }else{
                world.func_175698_g(pos);
            }

            if (ConfigurationHandler.torcherFrequency > 1){
                torcherFreq = ConfigurationHandler.torcherFrequency;
            }else{
                torcherFreq = 2;
            }

            for (int i = 1; i <= rangeRand * torcherFreq; i++){
                rangeRand = (rand.nextInt(50) + 1) * 2;
                int numRand = rand.nextInt(8) + 1;
                int torchX = pos.func_177958_n();
                int torchY = pos.func_177956_o();
                int torchZ = pos.func_177952_p();
                if (numRand == 1){
                    torchX = pos.func_177958_n() + rangeRand;
                    torchY = pos.func_177956_o();
                    torchZ = pos.func_177952_p() + rangeRand;
                }else if(numRand == 2){
                    torchX = pos.func_177958_n() - rangeRand;
                    torchY = pos.func_177956_o();
                    torchZ = pos.func_177952_p() - rangeRand;
                }else if(numRand == 3){
                    torchX = pos.func_177958_n() + rangeRand;
                    torchY = pos.func_177956_o();
                    torchZ = pos.func_177952_p() - rangeRand;
                }else if(numRand == 4){
                    torchX = pos.func_177958_n() - rangeRand;
                    torchY = pos.func_177956_o();
                    torchZ = pos.func_177952_p() + rangeRand;
                }else if(numRand == 5){
                    torchX = pos.func_177958_n() - rangeRand;
                    torchY = pos.func_177956_o();
                    torchZ = pos.func_177952_p();
                }else if(numRand == 6){
                    torchX = pos.func_177958_n() + rangeRand;
                    torchY = pos.func_177956_o();
                    torchZ = pos.func_177952_p();
                }else if(numRand == 7){
                    torchX = pos.func_177958_n();
                    torchY = pos.func_177956_o();
                    torchZ = pos.func_177952_p() - rangeRand;
                }else if(numRand == 8){
                    torchX = pos.func_177958_n();
                    torchY = pos.func_177956_o();
                    torchZ = pos.func_177952_p() + rangeRand;
                }
                if (world.func_180495_p(new BlockPos(torchX, torchY, torchZ)).func_177230_c().func_176200_f(world, new BlockPos(torchX, torchY, torchZ))){
                    if (world.func_180495_p(new BlockPos(torchX, torchY - 1, torchZ)).func_177230_c().func_149688_o().func_76220_a()){
                        world.func_175656_a(new BlockPos(torchX, torchY, torchZ), ModBlocks.pearcel_torch.func_176223_P());
                    }
                }
            }
            player.func_85030_a("random.explode", 1.0F, 0.5F);
            world.func_175688_a(EnumParticleTypes.EXPLOSION_HUGE, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p(), 1.0D, 0.0D, 0.0D);
            world.func_72838_d(new EntityLightningBolt(world, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p()));
            if (!world.field_72995_K){
                player.func_146105_b(new ChatComponentTranslation(EnumChatFormatting.GOLD + StatCollector.func_74838_a("chat.torcher.lit")));
            }

            return true;

        }else{
            return false;
        }
    }

    @SideOnly(Side.CLIENT)
    public void func_180655_c(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        EnumFacing enumfacing = EnumFacing.DOWN;
        double d0 = (double)pos.func_177958_n() + 0.5D;
        double d1 = (double)pos.func_177956_o() + 1.1D;
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

}
