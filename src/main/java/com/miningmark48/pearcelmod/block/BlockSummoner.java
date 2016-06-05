package com.miningmark48.pearcelmod.block;

import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.init.ModItems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.world.World;

import java.util.Random;

public class BlockSummoner extends BlockPearcelMod{

    public BlockSummoner(){

    }

    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ){

        Random rand = new Random();
        int spawnRand = rand.nextInt(5) + 1;
        int negRand = rand.nextInt(2) + 1;
        
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        
        if (negRand == 1) {
            spawnRand = -spawnRand;
        }

        EntitySheep sheep = new EntitySheep(world);
        sheep.setPosition(x + spawnRand, y + 2, z + spawnRand);
        EntityEnderman enderman = new EntityEnderman(world);
        enderman.setPosition(x + spawnRand, y + 2, z + spawnRand);
        EntityBlaze blaze = new EntityBlaze(world);
        blaze.setPosition(x + spawnRand, y + 2, z + spawnRand);
        EntityGhast ghast = new EntityGhast(world);
        ghast.setPosition(x + spawnRand, y + 5, z + spawnRand);
        EntitySkeleton skeleton = new EntitySkeleton(world);
        skeleton.setPosition(x + spawnRand, y + 2, z + spawnRand);
        EntityCreeper creeper = new EntityCreeper(world);
        creeper.setPosition(x + spawnRand, y + 2, z + spawnRand);
        EntityEnderCrystal endcrystal = new EntityEnderCrystal(world);
        endcrystal.setPosition(x + spawnRand, y + 2, z + spawnRand);
        EntityHorse horse = new EntityHorse(world);
        horse.setPosition(x + spawnRand, y + 2, z + spawnRand);
        EntityIronGolem iron_golem = new EntityIronGolem(world);
        iron_golem.setPosition(x + spawnRand, y + 2, z + spawnRand);
        EntityVillager villager = new EntityVillager(world);
        villager.setPosition(x + spawnRand, y + 2, z + spawnRand);

        if(player.getHeldItem() != null){
            if (!player.isSneaking() && player.getHeldItem().getItem() == ModItems.sap) {
                if (!world.isRemote) {
                    //Missing Block
                    if (world.getBlockState(pos.up()).getBlock() == Blocks.air) {
                        player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.DARK_RED + StatCollector.translateToLocal("summoner.error.missingBlock")));
                        if (world.isRemote) {
                            world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX, player.posY, player.posZ));
                        }
                    }
                    //Sheep
                    else if (world.getBlockState(pos.up()).getBlock() == Blocks.wool) {
                        world.setBlockState(pos.up(), ModBlocks.tainted_pearcel.getDefaultState());
                        world.spawnEntityInWorld(sheep);
                        player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + StatCollector.translateToLocal("summoner.mob_summon.sheep") + " " + StatCollector.translateToLocal("summoner.summoned")));
                    }
                    //Enderman
                    else if (world.getBlockState(pos.up()).getBlock() == Blocks.end_stone) {
                        world.setBlockState(pos.up(), ModBlocks.tainted_pearcel.getDefaultState());
                        world.spawnEntityInWorld(enderman);
                        player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + StatCollector.translateToLocal("summoner.mob_summon.enderman") + " " + StatCollector.translateToLocal("summoner.summoned")));
                    }
                    //Blaze
                    else if (world.getBlockState(pos.up()).getBlock() == Blocks.fire) {
                        world.setBlockState(pos.up(), ModBlocks.tainted_pearcel.getDefaultState());
                        world.spawnEntityInWorld(blaze);
                        player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + StatCollector.translateToLocal("summoner.mob_summon.blaze") + " " + StatCollector.translateToLocal("summoner.summoned")));
                    }
                    //Ghast
                    else if (world.getBlockState(pos.up()).getBlock() == Blocks.cobblestone) {
                        world.setBlockState(pos.up(), ModBlocks.tainted_pearcel.getDefaultState());
                        world.spawnEntityInWorld(ghast);
                        player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + StatCollector.translateToLocal("summoner.mob_summon.ghast") + " " + StatCollector.translateToLocal("summoner.summoned")));
                    }
                    //Skeleton
                    else if (world.getBlockState(pos.up()).getBlock() == Blocks.planks) {
                        world.setBlockState(pos.up(), ModBlocks.tainted_pearcel.getDefaultState());
                        world.spawnEntityInWorld(skeleton);
                        player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + StatCollector.translateToLocal("summoner.mob_summon.skeleton") + " " + StatCollector.translateToLocal("summoner.summoned")));
                    }
                    //Creeper
                    else if (world.getBlockState(pos.up()).getBlock() == Blocks.tnt) {
                        world.setBlockState(pos.up(), ModBlocks.tainted_pearcel.getDefaultState());
                        world.spawnEntityInWorld(creeper);
                        player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + StatCollector.translateToLocal("summoner.mob_summon.creeper") + " " + StatCollector.translateToLocal("summoner.summoned")));
                    }
                    //Horse
                    else if (world.getBlockState(pos.up()).getBlock() == Blocks.hay_block) {
                        world.setBlockState(pos.up(), ModBlocks.tainted_pearcel.getDefaultState());
                        world.spawnEntityInWorld(horse);
                        player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + StatCollector.translateToLocal("summoner.mob_summon.horse") + " " + StatCollector.translateToLocal("summoner.summoned")));
                    }
                    //Iron Golem
                    else if (world.getBlockState(pos.up()).getBlock() == Blocks.iron_block) {
                        world.setBlockState(pos.up(), ModBlocks.tainted_pearcel.getDefaultState());
                        world.spawnEntityInWorld(iron_golem);
                        player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + StatCollector.translateToLocal("summoner.mob_summon.iron_golem") + " " + StatCollector.translateToLocal("summoner.summoned")));
                    }
                    //Villager
                    else if (world.getBlockState(pos.up()).getBlock() == Blocks.emerald_block) {
                        world.setBlockState(pos.up(), ModBlocks.tainted_pearcel.getDefaultState());
                        world.spawnEntityInWorld(villager);
                        player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + StatCollector.translateToLocal("summoner.mob_summon.villager") + " " + StatCollector.translateToLocal("summoner.summoned")));
                    }else {
                        if (!world.isRemote) {
                            world.setBlockState(pos.up(), ModBlocks.tainted_pearcel.getDefaultState());
                            player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.DARK_RED + StatCollector.translateToLocal("summoner.error.incorrectBlock")));
                        }
                        if (world.isRemote) {
                            world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX, player.posY, player.posZ));
                        }
                    }
                }
                player.playSound("random.explode", 1.0F, 0.5F);
                world.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, x, y, z, 1.0D, 0.0D, 0.0D);
                player.getHeldItem().damageItem(1, player);
            } else {
                if (!world.isRemote) {
                    player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.DARK_RED + StatCollector.translateToLocal("summoner.error.incorrectItem")));
                }
            }
        }
        return true;
    }

}
