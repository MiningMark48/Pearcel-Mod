package com.miningmark48.pearcelmod.block;

import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.mob.EntityPearcelCow;
import com.miningmark48.pearcelmod.mob.EntityPearcelMob;
import com.miningmark48.pearcelmod.mob.EntityPearcelSquid;
import com.miningmark48.pearcelmod.mob.EntityPearson;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class BlockSummoner extends BlockPearcelMod{

    public BlockSummoner(){
        super();
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {

        int chargeXP = 10;
        int playerXP = player.experienceLevel;

        EntityPearcelMob pearcelmob = new EntityPearcelMob(world);
        pearcelmob.setPosition(x, y+2, z);
        EntityPearson pearson = new EntityPearson(world);
        pearson.setPosition(x, y+2, z);
        EntityPearcelSquid pearcelsquid = new EntityPearcelSquid(world);
        pearcelsquid.setPosition(x, y+2, z);
        EntityDragon dragon = new EntityDragon(world);
        dragon.setPosition(x, y+10, z);
        EntityWither wither = new EntityWither(world);
        wither.setPosition(x, y+5, z);
        EntitySheep sheep = new EntitySheep(world);
        sheep.setPosition(x, y+2, z);
        EntityPearcelCow pearcelcow = new EntityPearcelCow(world);
        pearcelcow.setPosition(x, y+2, z);
        EntityEnderman enderman = new EntityEnderman(world);
        enderman.setPosition(x, y+2, z);
        EntityBlaze blaze = new EntityBlaze(world);
        blaze.setPosition(x, y+2, z);
        EntityGhast ghast = new EntityGhast(world);
        ghast.setPosition(x, y+2, z);
        EntitySkeleton skeleton = new EntitySkeleton(world);
        skeleton.setPosition(x, y+2, z);
        EntityCreeper creeper = new EntityCreeper(world);
        creeper.setPosition(x, y+2, z);

        if(!player.isSneaking() && player.getHeldItem().isItemEqual(new ItemStack(ModItems.sap))){
            if(playerXP >= chargeXP){
                if (!world.isRemote) {
                    //Pearcel Mob
                    if (world.getBlock(x, y + 1, z) == ModBlocks.pearcelBlock) {
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
                    else if (world.getBlock(x, y+1, z) == Blocks.soul_sand && world.getBlock(x+2, y, z+2) == Blocks.soul_sand && world.getBlock(x-2, y, z-2) == Blocks.soul_sand && world.getBlock(x+2, y, z-2) == Blocks.soul_sand && world.getBlock(x-2, y, z+2) == Blocks.soul_sand){
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
                    else{
                        if (!world.isRemote){
                            player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.DARK_RED + "Incorrect Summoner Block"));
                            world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX, player.posY, player.posZ));
                        }
                    }
                }
                player.playSound("random.explode", 1.0F, 0.5F);
                world.spawnParticle("hugeexplosion", x, y, z, 1.0D, 0.0D, 0.0D);
                player.experienceLevel = playerXP - chargeXP;
            }
            }else{
                player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.DARK_RED + "You need " + chargeXP + " levels of experience to perform the summon."));
            }


        return true;
    }

}
