package com.miningmark48.pearcelmod.block;

import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.mob.EntityPearcelCow;
import com.miningmark48.pearcelmod.mob.EntityPearcelMob;
import com.miningmark48.pearcelmod.mob.EntityPearcelSquid;
import com.miningmark48.pearcelmod.mob.EntityPearson;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.Random;

public class BlockSummoner extends BlockPearcelMod{

    public BlockSummoner(){
        super();
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {

        int chargeXP = ConfigurationHandler.summonerXP;
        int playerXP = player.experienceLevel;

        Random rand = new Random();
        int spawnRand = rand.nextInt(ConfigurationHandler.summonerRange) + 1;
        int negRand = rand.nextInt(2) + 1;
        if (negRand == 1){
            spawnRand = -spawnRand;
        }

        EntityPearcelMob pearcelmob = new EntityPearcelMob(world);
        pearcelmob.setPosition(x+spawnRand, y+2, z+spawnRand);
        EntityPearson pearson = new EntityPearson(world);
        pearson.setPosition(x+spawnRand, y+2, z+spawnRand);
        EntityPearcelSquid pearcelsquid = new EntityPearcelSquid(world);
        pearcelsquid.setPosition(x+spawnRand, y+2, z+spawnRand);
        EntityDragon dragon = new EntityDragon(world);
        dragon.setPosition(x+spawnRand, y+10, z+spawnRand);
        EntityWither wither = new EntityWither(world);
        wither.setPosition(x+spawnRand, y+5, z+spawnRand);
        EntitySheep sheep = new EntitySheep(world);
        sheep.setPosition(x+spawnRand, y+2, z+spawnRand);
        EntityPearcelCow pearcelcow = new EntityPearcelCow(world);
        pearcelcow.setPosition(x+spawnRand, y+2, z+spawnRand);
        EntityEnderman enderman = new EntityEnderman(world);
        enderman.setPosition(x+spawnRand, y+2, z+spawnRand);
        EntityBlaze blaze = new EntityBlaze(world);
        blaze.setPosition(x+spawnRand, y+2, z+spawnRand);
        EntityGhast ghast = new EntityGhast(world);
        ghast.setPosition(x+spawnRand, y+5, z+spawnRand);
        EntitySkeleton skeleton = new EntitySkeleton(world);
        skeleton.setPosition(x+spawnRand, y+2, z+spawnRand);
        EntityCreeper creeper = new EntityCreeper(world);
        creeper.setPosition(x+spawnRand, y+2, z+spawnRand);
        EntityEnderCrystal endcrystal = new EntityEnderCrystal(world);
        endcrystal.setPosition(x+spawnRand, y+2, z+spawnRand);
        EntityHorse horse = new EntityHorse(world);
        horse.setPosition(x+spawnRand, y+2, z+spawnRand);

        if(!player.isSneaking() && player.getHeldItem().isItemEqual(new ItemStack(ModItems.sap))){
            if(playerXP >= chargeXP || player.capabilities.isCreativeMode){
                if (!world.isRemote) {
                    //Missing Block
                    if (world.getBlock(x, y+1, z) == Blocks.air){
                        player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.DARK_RED + "Missing Summoner Block."));
                        world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX, player.posY, player.posZ));
                    }
                    //Pearcel Mob
                    else if (world.getBlock(x, y + 1, z) == ModBlocks.pearcelBlock) {
                        world.setBlock(x, y + 1, z, ModBlocks.corruptedPearcelBlock);
                        world.spawnEntityInWorld(pearcelmob);
                        player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + "Pearcel Mob summoned."));
                    }
                    //Pearson
                    else if (world.getBlock(x, y + 1, z) == ModBlocks.meBlock) {
                        world.setBlock(x, y + 1, z, ModBlocks.corruptedPearcelBlock);
                        world.spawnEntityInWorld(pearson);
                        player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + "Pearson summoned."));
                    }
                    //Pearcel Squid
                    else if (world.getBlock(x, y + 1, z) == Blocks.lapis_block) {
                        world.setBlock(x, y + 1, z, ModBlocks.corruptedPearcelBlock);
                        world.spawnEntityInWorld(pearcelsquid);
                        player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + "Pearcel Squid summoned."));
                    }
                    //Ender dragon
                    else if (world.getBlock(x, y+1, z) == ModBlocks.dragonInfusedPearcel && world.getBlock(x+2, y, z+2) == ModBlocks.enderInfusedPearcel && world.getBlock(x-2, y, z-2) == ModBlocks.enderInfusedPearcel && world.getBlock(x+2, y, z-2) == ModBlocks.enderInfusedPearcel && world.getBlock(x-2, y, z+2) == ModBlocks.enderInfusedPearcel){
                        world.setBlock(x, y + 1, z, ModBlocks.corruptedPearcelBlock);
                        world.setBlock(x + 2, y, z, ModBlocks.corruptedPearcelBlock);
                        world.setBlock(x - 2, y, z - 2, ModBlocks.corruptedPearcelBlock);
                        world.spawnEntityInWorld(dragon);
                        world.spawnEntityInWorld(new EntityLightningBolt(world, x, y, z));
                        player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + "Ender Dragon summoned."));
                    }
                    //Wither
                    else if (world.getBlock(x, y+1, z) == ModBlocks.witherInfusedPearcel && world.getBlock(x+2, y, z+2) == ModBlocks.netherInfusedPearcel && world.getBlock(x-2, y, z-2) == ModBlocks.netherInfusedPearcel && world.getBlock(x+2, y, z-2) == ModBlocks.netherInfusedPearcel && world.getBlock(x-2, y, z+2) == ModBlocks.netherInfusedPearcel){
                        world.setBlock(x, y + 1, z, ModBlocks.corruptedPearcelBlock);
                        world.setBlock(x + 2, y, z, ModBlocks.corruptedPearcelBlock);
                        world.setBlock(x - 2, y, z - 2, ModBlocks.corruptedPearcelBlock);
                        world.spawnEntityInWorld(wither);
                        world.spawnEntityInWorld(new EntityLightningBolt(world, x, y, z));
                        player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + "Wither summoned."));
                    }
                    //Sheep
                    else if (world.getBlock(x, y+1, z) == Blocks.wool){
                        world.setBlock(x, y + 1, z, ModBlocks.corruptedPearcelBlock);
                        world.spawnEntityInWorld(sheep);
                        player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + "Sheep summoned."));
                    }
                    //Pearcel Cow
                    else if(world.getBlock(x, y+1, z) == Blocks.hardened_clay){
                        world.setBlock(x, y + 1, z, ModBlocks.corruptedPearcelBlock);
                        world.spawnEntityInWorld(pearcelcow);
                        player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + "Pearcel Cow summoned."));
                    }
                    //Enderman
                    else if(world.getBlock(x, y+1, z) == Blocks.end_stone){
                        world.setBlock(x, y + 1, z, ModBlocks.corruptedPearcelBlock);
                        world.spawnEntityInWorld(enderman);
                        player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + "Enderman summoned."));
                    }
                    //Blaze
                    else if(world.getBlock(x, y+1, z) == Blocks.fire){
                        world.setBlock(x, y + 1, z, ModBlocks.corruptedPearcelBlock);
                        world.spawnEntityInWorld(blaze);
                        player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + "Blaze summoned."));
                    }
                    //Ghast
                    else if(world.getBlock(x, y+1, z) == Blocks.cobblestone){
                        world.setBlock(x, y + 1, z, ModBlocks.corruptedPearcelBlock);
                        world.spawnEntityInWorld(ghast);
                        player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + "Ghast summoned."));
                    }
                    //Skeleton
                    else if(world.getBlock(x, y+1, z) == Blocks.planks){
                            world.setBlock(x, y + 1, z, ModBlocks.corruptedPearcelBlock);
                        world.spawnEntityInWorld(skeleton);
                        player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + "Skeleton summoned."));
                    }
                    //Creeper
                    else if(world.getBlock(x, y+1, z) == Blocks.tnt){
                        world.setBlock(x, y + 1, z, ModBlocks.corruptedPearcelBlock);
                        world.spawnEntityInWorld(creeper);
                        player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + "Creeper summoned."));
                    }
                    //Ender Crystal
                    else if(world.getBlock(x, y+1, z) == ModBlocks.pearcelEndStone){
                        world.setBlock(x, y + 1, z, ModBlocks.corruptedPearcelBlock);
                        world.spawnEntityInWorld(endcrystal);
                        player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + "Ender crystal summoned."));
                    }
                    //Horse
                    else if(world.getBlock(x, y+1, z) == Blocks.hay_block){
                        world.setBlock(x, y + 1, z, ModBlocks.corruptedPearcelBlock);
                        world.spawnEntityInWorld(horse);
                        player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + "Horse summoned."));
                    }
                    else{
                        if (!world.isRemote){
                            player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.DARK_RED + "Incorrect Summoner Block."));
                            world.setBlock(x, y + 1, z, ModBlocks.corruptedPearcelBlock);
                            player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.DARK_RED + "The block was corrupted."));
                            world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX, player.posY, player.posZ));
                        }
                    }
                }
                player.playSound("random.explode", 1.0F, 0.5F);
                world.spawnParticle("hugeexplosion", x, y, z, 1.0D, 0.0D, 0.0D);
                player.experienceLevel = playerXP - chargeXP;
                if (!player.capabilities.isCreativeMode){
                    player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + "Your player's " + EnumChatFormatting.AQUA + chargeXP + EnumChatFormatting.GOLD + " levels infuse into the summoning."));
                }else{
                    player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + "Your creative mode powers infuse into the summoning."));
                }
            }
            }else{
                player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.DARK_RED + "You need " + EnumChatFormatting.AQUA + chargeXP + EnumChatFormatting.DARK_RED + " levels of experience to perform the summon."));
            }


        return true;
    }

}
