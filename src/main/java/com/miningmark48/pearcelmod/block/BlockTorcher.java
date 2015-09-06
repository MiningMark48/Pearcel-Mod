package com.miningmark48.pearcelmod.block;

import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.reference.GUIs;
import com.miningmark48.pearcelmod.reference.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import java.util.Random;

public class BlockTorcher extends BlockPearcelMod{

    public BlockTorcher(){
        super();
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
        if (!player.isSneaking()){
            Random rand = new Random();
            int rangeRand = (rand.nextInt(ConfigurationHandler.torcherRange) + 1) * 2;
            if (world.getBlock(x, y, z).getMaterial().isSolid()){
                world.setBlock(x, y, z, ModBlocks.pearcelTorch);
            }
            for (int i = 1; i <= rangeRand * 10; i++){
                rangeRand = (rand.nextInt(ConfigurationHandler.torcherRange) + 1) * 2;
                int numRand = rand.nextInt(8) + 1;
                if (numRand == 1){
                    int torchX = x + rangeRand;
                    int torchY = y;
                    int torchZ = z + rangeRand;
                    if (world.getBlock(torchX, torchY, torchZ) == Blocks.air && world.getBlock(torchX, torchY - 1, torchZ).getMaterial().isSolid()){
                        world.setBlock(torchX, torchY, torchZ, ModBlocks.pearcelTorch);
                    }
                }else if(numRand == 2){
                    int torchX = x - rangeRand;
                    int torchY = y;
                    int torchZ = z - rangeRand;
                    if (world.getBlock(torchX, torchY, torchZ) == Blocks.air && world.getBlock(torchX, torchY - 1, torchZ).getMaterial().isSolid()){
                        world.setBlock(torchX, torchY, torchZ, ModBlocks.pearcelTorch);
                    }
                }else if(numRand == 3){
                    int torchX = x + rangeRand;
                    int torchY = y;
                    int torchZ = z - rangeRand;
                    if (world.getBlock(torchX, torchY, torchZ) == Blocks.air && world.getBlock(torchX, torchY - 1, torchZ).getMaterial().isSolid()){
                        world.setBlock(torchX, torchY, torchZ, ModBlocks.pearcelTorch);
                    }
                }else if(numRand == 4){
                    int torchX = x - rangeRand;
                    int torchY = y;
                    int torchZ = z + rangeRand;
                    if (world.getBlock(torchX, torchY, torchZ) == Blocks.air && world.getBlock(torchX, torchY - 1, torchZ).getMaterial().isSolid()){
                        world.setBlock(torchX, torchY, torchZ, ModBlocks.pearcelTorch);
                    }
                }else if(numRand == 5){
                    int torchX = x - rangeRand;
                    int torchY = y;
                    int torchZ = z;
                    if (world.getBlock(torchX, torchY, torchZ) == Blocks.air && world.getBlock(torchX, torchY - 1, torchZ).getMaterial().isSolid()){
                        world.setBlock(torchX, torchY, torchZ, ModBlocks.pearcelTorch);
                    }
                }else if(numRand == 6){
                    int torchX = x + rangeRand;
                    int torchY = y;
                    int torchZ = z;
                    if (world.getBlock(torchX, torchY, torchZ) == Blocks.air && world.getBlock(torchX, torchY - 1, torchZ).getMaterial().isSolid()){
                        world.setBlock(torchX, torchY, torchZ, ModBlocks.pearcelTorch);
                    }
                }else if(numRand == 7){
                    int torchX = x;
                    int torchY = y;
                    int torchZ = z - rangeRand;
                    if (world.getBlock(torchX, torchY, torchZ) == Blocks.air && world.getBlock(torchX, torchY - 1, torchZ).getMaterial().isSolid()){
                        world.setBlock(torchX, torchY, torchZ, ModBlocks.pearcelTorch);
                    }
                }else if(numRand == 8){
                    int torchX = x;
                    int torchY = y;
                    int torchZ = z + rangeRand;
                    if (world.getBlock(torchX, torchY, torchZ) == Blocks.air && world.getBlock(torchX, torchY - 1, torchZ).getMaterial().isSolid()){
                        world.setBlock(torchX, torchY, torchZ, ModBlocks.pearcelTorch);
                    }
                }

            }

            player.playSound("random.explode", 1.0F, 0.5F);
            world.spawnParticle("hugeexplosion", x, y, z, 1.0D, 0.0D, 0.0D);

            return true;

        }else{
            return false;
        }
    }

}
