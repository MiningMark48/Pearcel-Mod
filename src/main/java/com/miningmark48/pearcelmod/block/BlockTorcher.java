package com.miningmark48.pearcelmod.block;

import com.miningmark48.pearcelmod.achievements.Achievements;
import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import com.miningmark48.pearcelmod.init.ModBlocks;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.Random;

public class BlockTorcher extends BlockPearcelMod{

    public BlockTorcher(){
        super();
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
        if (!player.isSneaking()){

            player.addStat(Achievements.achievementTorcher, 1);

            Random rand = new Random();
            int rangeRand = (rand.nextInt(ConfigurationHandler.torcherRange) + 1) * 2;

            if (world.getBlock(x, y-1, z).getMaterial().isSolid()){
                world.setBlock(x, y, z, Blocks.torch);
            }
            for (int i = 1; i <= rangeRand * ConfigurationHandler.torcherFrequency; i++){
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
                if (world.getBlock(torchX, torchY, torchZ) == Blocks.air || world.getBlock(torchX, torchY, torchZ) == Blocks.tallgrass){
                    if (world.getBlock(torchX, torchY - 1, torchZ).getMaterial().isSolid()){
                        world.setBlock(torchX, torchY, torchZ, Blocks.torch);
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

}
