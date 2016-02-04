package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.mob.EntityPearcelCow;
import com.miningmark48.pearcelmod.mob.EntityPearcelMob;
import com.miningmark48.pearcelmod.mob.EntityPearcelSquid;
import com.miningmark48.pearcelmod.mob.EntityPearson;
import net.minecraft.client.Minecraft;
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
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class ItemSAP extends ItemPearcelMod{

    public ItemSAP(){
        super();
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        int itemDurability = par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage();

        par3List.add(EnumChatFormatting.GOLD + StatCollector.translateToLocal("tooltip.item.sap.line1") + " " + EnumChatFormatting.AQUA + itemDurability);
        par3List.add(StatCollector.translateToLocal("tooltip.item.sap.line2"));
        par3List.add(StatCollector.translateToLocal("tooltip.item.sap.line3"));
        par3List.add(StatCollector.translateToLocal("tooltip.item.sap.line4"));
        par3List.add(StatCollector.translateToLocal("tooltip.item.sap.line5"));
    }

    @Override
    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player){
        int x = Minecraft.getMinecraft().objectMouseOver.blockX;
        int y = Minecraft.getMinecraft().objectMouseOver.blockY;
        int z = Minecraft.getMinecraft().objectMouseOver.blockZ;

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

        if(!player.isSneaking() && player.getHeldItem().getItem() == ModItems.sap) {
            if (player.getHeldItem().getItem() != null && player.getHeldItem().getItem() == ModItems.sap) {
                if (!world.isRemote) {
                    //Missing Block
                    if (world.getBlock(x, y + 1, z) == Blocks.air) {
                        player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.DARK_RED + StatCollector.translateToLocal("summoner.error.missingBlock")));
                        world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX, player.posY, player.posZ));
                    }
                    //Pearcel Mob
                    else if (world.getBlock(x, y + 1, z) == ModBlocks.pearcelPlush) {
                        world.setBlock(x, y + 1, z, ModBlocks.corruptedPearcelBlock);
                        world.spawnEntityInWorld(pearcelmob);
                        player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + StatCollector.translateToLocal("summoner.mobSummon.pearcelmob") + " " + StatCollector.translateToLocal("summoner.summoned")));
                    }
                    //Pearson
                    else if (world.getBlock(x, y + 1, z) == ModBlocks.pearcelGlass) { //TODO: Change this to something else
                        world.setBlock(x, y + 1, z, ModBlocks.corruptedPearcelBlock);
                        world.spawnEntityInWorld(pearson);
                        player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + StatCollector.translateToLocal("summoner.mobSummon.pearson") + " " + StatCollector.translateToLocal("summoner.summoned")));
                    }
                    //Pearcel Squid
                    else if (world.getBlock(x, y + 1, z) == Blocks.lapis_block) {
                        world.setBlock(x, y + 1, z, ModBlocks.corruptedPearcelBlock);
                        world.spawnEntityInWorld(pearcelsquid);
                        player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + StatCollector.translateToLocal("summoner.mobSummon.pearcelsquid") + " " + StatCollector.translateToLocal("summoner.summoned")));
                    }
                    //Ender dragon
                    else if (world.getBlock(x, y + 1, z) == ModBlocks.dragonInfusedPearcel && world.getBlock(x + 2, y, z + 2) == ModBlocks.enderInfusedPearcel && world.getBlock(x - 2, y, z - 2) == ModBlocks.enderInfusedPearcel && world.getBlock(x + 2, y, z - 2) == ModBlocks.enderInfusedPearcel && world.getBlock(x - 2, y, z + 2) == ModBlocks.enderInfusedPearcel) {
                        world.setBlock(x, y + 1, z, ModBlocks.corruptedPearcelBlock);
                        world.setBlock(x + 2, y, z, ModBlocks.corruptedPearcelBlock);
                        world.setBlock(x - 2, y, z - 2, ModBlocks.corruptedPearcelBlock);
                        world.spawnEntityInWorld(dragon);
                        world.spawnEntityInWorld(new EntityLightningBolt(world, x, y, z));
                        player.getHeldItem().damageItem(1, player);
                        player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + StatCollector.translateToLocal("summoner.mobSummon.enderdragon") + " " + StatCollector.translateToLocal("summoner.summoned")));
                    }
                    //Wither
                    else if (world.getBlock(x, y + 1, z) == ModBlocks.witherInfusedPearcel && world.getBlock(x + 2, y, z + 2) == ModBlocks.netherInfusedPearcel && world.getBlock(x - 2, y, z - 2) == ModBlocks.netherInfusedPearcel && world.getBlock(x + 2, y, z - 2) == ModBlocks.netherInfusedPearcel && world.getBlock(x - 2, y, z + 2) == ModBlocks.netherInfusedPearcel) {
                        world.setBlock(x, y + 1, z, ModBlocks.corruptedPearcelBlock);
                        world.setBlock(x + 2, y, z, ModBlocks.corruptedPearcelBlock);
                        world.setBlock(x - 2, y, z - 2, ModBlocks.corruptedPearcelBlock);
                        world.spawnEntityInWorld(wither);
                        world.spawnEntityInWorld(new EntityLightningBolt(world, x, y, z));
                        player.getHeldItem().damageItem(1, player);
                        player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + StatCollector.translateToLocal("summoner.mobSummon.wither") + " " + StatCollector.translateToLocal("summoner.summoned")));
                    }
                    //Sheep
                    else if (world.getBlock(x, y + 1, z) == Blocks.wool) {
                        world.setBlock(x, y + 1, z, ModBlocks.corruptedPearcelBlock);
                        world.spawnEntityInWorld(sheep);
                        player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + StatCollector.translateToLocal("summoner.mobSummon.sheep") + " " + StatCollector.translateToLocal("summoner.summoned")));
                    }
                    //Pearcel Cow
                    else if (world.getBlock(x, y + 1, z) == Blocks.hardened_clay) {
                        world.setBlock(x, y + 1, z, ModBlocks.corruptedPearcelBlock);
                        world.spawnEntityInWorld(pearcelcow);
                        player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + StatCollector.translateToLocal("summoner.mobSummon.pearcelcow") + " " + StatCollector.translateToLocal("summoner.summoned")));
                    }
                    //Enderman
                    else if (world.getBlock(x, y + 1, z) == Blocks.end_stone) {
                        world.setBlock(x, y + 1, z, ModBlocks.corruptedPearcelBlock);
                        world.spawnEntityInWorld(enderman);
                        player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + StatCollector.translateToLocal("summoner.mobSummon.enderman") + " " + StatCollector.translateToLocal("summoner.summoned")));
                    }
                    //Blaze
                    else if (world.getBlock(x, y + 1, z) == Blocks.fire) {
                        world.setBlock(x, y + 1, z, ModBlocks.corruptedPearcelBlock);
                        world.spawnEntityInWorld(blaze);
                        player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + StatCollector.translateToLocal("summoner.mobSummon.blaze") + " " + StatCollector.translateToLocal("summoner.summoned")));
                    }
                    //Ghast
                    else if (world.getBlock(x, y + 1, z) == Blocks.cobblestone) {
                        world.setBlock(x, y + 1, z, ModBlocks.corruptedPearcelBlock);
                        world.spawnEntityInWorld(ghast);
                        player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + StatCollector.translateToLocal("summoner.mobSummon.ghast") + " " + StatCollector.translateToLocal("summoner.summoned")));
                    }
                    //Skeleton
                    else if (world.getBlock(x, y + 1, z) == Blocks.planks) {
                        world.setBlock(x, y + 1, z, ModBlocks.corruptedPearcelBlock);
                        world.spawnEntityInWorld(skeleton);
                        player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + StatCollector.translateToLocal("summoner.mobSummon.skeleton") + " " + StatCollector.translateToLocal("summoner.summoned")));
                    }
                    //Creeper
                    else if (world.getBlock(x, y + 1, z) == Blocks.tnt) {
                        world.setBlock(x, y + 1, z, ModBlocks.corruptedPearcelBlock);
                        world.spawnEntityInWorld(creeper);
                        player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + StatCollector.translateToLocal("summoner.mobSummon.creeper") + " " + StatCollector.translateToLocal("summoner.summoned")));
                        //Charged Creeper
                        if (world.getBlock(x, y + 2, z) == Blocks.tnt){
                            world.setBlock(x, y + 2, z, ModBlocks.corruptedPearcelBlock);
                            world.spawnEntityInWorld(new EntityLightningBolt(world, x+spawnRand, y, z+spawnRand));
                            player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + StatCollector.translateToLocal("summoner.mobSummon.creeper.charged")));
                        }
                    }
                    //Ender Crystal
                    else if (world.getBlock(x, y + 1, z) == ModBlocks.pearcelEndStone) {
                        world.setBlock(x, y + 1, z, ModBlocks.corruptedPearcelBlock);
                        world.spawnEntityInWorld(endcrystal);
                        player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + StatCollector.translateToLocal("summoner.mobSummon.endercrystal") + " " + StatCollector.translateToLocal("summoner.summoned")));
                    }
                    //Horse
                    else if (world.getBlock(x, y + 1, z) == Blocks.hay_block) {
                        world.setBlock(x, y + 1, z, ModBlocks.corruptedPearcelBlock);
                        world.spawnEntityInWorld(horse);
                        player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + StatCollector.translateToLocal("summoner.mobSummon.horse") + " " + StatCollector.translateToLocal("summoner.summoned")));
                    } else {
                        if (!world.isRemote) {
                            world.setBlock(x, y + 1, z, ModBlocks.corruptedPearcelBlock);
                            player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.DARK_RED + StatCollector.translateToLocal("summoner.error.incorrectBlock")));
                            world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX, player.posY, player.posZ));
                        }
                    }
                }
                player.playSound("random.explode", 1.0F, 0.5F);
                world.spawnParticle("hugeexplosion", x, y, z, 1.0D, 0.0D, 0.0D);
                player.getHeldItem().damageItem(1, player);
            }else{
                if (!world.isRemote){
                    player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.DARK_RED + StatCollector.translateToLocal("summoner.error.incorrectItem")));
                }
            }
        }

        return item;
    }

}
