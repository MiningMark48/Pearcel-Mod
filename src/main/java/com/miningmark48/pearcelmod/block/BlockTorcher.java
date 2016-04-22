package com.miningmark48.pearcelmod.block;

import com.miningmark48.pearcelmod.achievements.Achievements;
import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.tileentity.TileEntityIVET;
import com.miningmark48.pearcelmod.tileentity.TileEntityTorcher;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class BlockTorcher extends BlockContainer{

    int torcherFreq;

    public BlockTorcher(Material material){
        super(material);
        this.setBlockBounds(0.375F, 0.0F, 0.375F, 0.625F, 1.0F, 0.625F);
    }

    public int getRenderType(){
        return -1;
    }

    public boolean isOpaqueCube(){
        return false;
    }

    public boolean renderAsNormalBlock(){
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World par1, int par2) {
        return new TileEntityTorcher();
    }

    public boolean canPlaceBlockAt(World world, int x, int y, int z){
        if (world.getBlock(x, y-1, z).getMaterial().isSolid() == true){
            return true;
        }else{
            return false;
        }
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
        if (!player.isSneaking()){

            player.addStat(Achievements.achievementTorcher, 1);

            Random rand = new Random();
            int rangeRand = (rand.nextInt(ConfigurationHandler.torcherRange) + 1) * 2;

            if (world.getBlock(x, y-1, z).getMaterial().isSolid()){
                world.setBlock(x, y, z, ModBlocks.pearcelTorch);
            }else{
                world.setBlock(x, y, z, Blocks.air);
            }
            if (ConfigurationHandler.torcherFrequency > 1){
                torcherFreq = ConfigurationHandler.torcherFrequency;
            }else{
                torcherFreq = 2;
            }
            for (int i = 1; i <= rangeRand * torcherFreq; i++){
                rangeRand = (rand.nextInt(ConfigurationHandler.torcherRange) + 1) * 2;
                int numRand = rand.nextInt(8) + 1;
                int torchX = x;
                int torchY = y;
                int torchZ = z;
                if (numRand == 1){
                    torchX = x + rangeRand;
                    torchY = y;
                    torchZ = z + rangeRand;
                }else if(numRand == 2){
                    torchX = x - rangeRand;
                    torchY = y;
                    torchZ = z - rangeRand;
                }else if(numRand == 3){
                    torchX = x + rangeRand;
                    torchY = y;
                    torchZ = z - rangeRand;
                }else if(numRand == 4){
                    torchX = x - rangeRand;
                    torchY = y;
                    torchZ = z + rangeRand;
                }else if(numRand == 5){
                    torchX = x - rangeRand;
                    torchY = y;
                    torchZ = z;
                }else if(numRand == 6){
                    torchX = x + rangeRand;
                    torchY = y;
                    torchZ = z;
                }else if(numRand == 7){
                    torchX = x;
                    torchY = y;
                    torchZ = z - rangeRand;
                }else if(numRand == 8){
                    torchX = x;
                    torchY = y;
                    torchZ = z + rangeRand;
                }
                if (world.getBlock(torchX, torchY, torchZ).isReplaceable(world, torchX, torchY, torchZ)){
                    if (world.getBlock(torchX, torchY - 1, torchZ).getMaterial().isSolid()){
                        world.setBlock(torchX, torchY, torchZ, ModBlocks.pearcelTorch);
                    }
                }
            }
            player.playSound("random.explode", 1.0F, 0.5F);
            world.spawnParticle("hugeexplosion", x, y, z, 1.0D, 0.0D, 0.0D);
            world.spawnEntityInWorld(new EntityLightningBolt(world, x, y, z));
            if (!world.isRemote){
                player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + StatCollector.translateToLocal("chat.torcher.lit")));
            }

            return true;

        }else{
            return false;
        }
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_)
    {
        int l = p_149734_1_.getBlockMetadata(p_149734_2_, p_149734_3_, p_149734_4_);
        double d0 = (double)((float)p_149734_2_ + 0.5F);
        double d1 = (double)((float)p_149734_3_ + 1.125F);
        double d2 = (double)((float)p_149734_4_ + 0.5F);
        double d3 = 0.2199999988079071D;
        double d4 = 0.27000001072883606D;

        if (l == 1)
        {
            p_149734_1_.spawnParticle("smoke", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
            p_149734_1_.spawnParticle("flame", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
        }
        else if (l == 2)
        {
            p_149734_1_.spawnParticle("smoke", d0 + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
            p_149734_1_.spawnParticle("flame", d0 + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
        }
        else if (l == 3)
        {
            p_149734_1_.spawnParticle("smoke", d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
            p_149734_1_.spawnParticle("flame", d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
        }
        else if (l == 4)
        {
            p_149734_1_.spawnParticle("smoke", d0, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
            p_149734_1_.spawnParticle("flame", d0, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
        }
        else
        {
            p_149734_1_.spawnParticle("smoke", d0, d1, d2, 0.0D, 0.0D, 0.0D);
            p_149734_1_.spawnParticle("flame", d0, d1, d2, 0.0D, 0.0D, 0.0D);
        }
    }

}
