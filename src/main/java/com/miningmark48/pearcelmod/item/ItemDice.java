package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.achievements.Achievements;
import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class ItemDice extends ItemPearcelMod{

    public ItemDice(){
        super();
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        par3List.add(StatCollector.translateToLocal("tooltip.item.dice.line1"));

        if (ConfigurationHandler.specialDice){
            par3List.add(StatCollector.translateToLocal("tooltip.item.dice.line2"));
        }

    }

    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player)
    {
        Random rand = new Random();
        int diceRand = rand.nextInt(6) + 1;

        int playerX = (int) player.posX;
        int playerY = (int) player.posY;
        int playerZ = (int) player.posZ;

        if (!world.isRemote){
            if (player.isSneaking() && ConfigurationHandler.specialDice){
                if (diceRand == 1){
                    player.addExperience(100);
                }else if(diceRand == 2){
                    player.addPotionEffect(new PotionEffect(Potion.confusion.id, 1000, 1));
                }else if(diceRand == 3){
                    world.setBlock(playerX, playerY + 2, playerZ, Blocks.diamond_block);
                }else if(diceRand == 4){
                    player.addChatComponentMessage(new ChatComponentTranslation(StatCollector.translateToLocal("chat.dice.anvilFall")));

                    world.setBlock(playerX, playerY + 20, playerZ, Blocks.anvil);
                    world.setBlock(playerX + 1, playerY + 20, playerZ, Blocks.anvil);
                    world.setBlock(playerX - 1, playerY + 20, playerZ, Blocks.anvil);
                    world.setBlock(playerX, playerY + 20, playerZ + 1, Blocks.anvil);
                    world.setBlock(playerX, playerY + 20, playerZ - 1, Blocks.anvil);
                    world.setBlock(playerX + 1, playerY + 20, playerZ + 1, Blocks.anvil);
                    world.setBlock(playerX - 1, playerY + 20, playerZ - 1, Blocks.anvil);
                    world.setBlock(playerX + 1, playerY + 20, playerZ - 1, Blocks.anvil);
                    world.setBlock(playerX - 1, playerY + 20, playerZ + 1, Blocks.anvil);
                }else if(diceRand == 5){
                    player.addPotionEffect(new PotionEffect(Potion.wither.id, 1000, 1));
                }else if(diceRand == 6){

                    player.addStat(Achievements.achievementFreeBeacon, 1);

                    world.setBlock(playerX, playerY + 2, playerZ, Blocks.iron_block);
                    world.setBlock(playerX + 1, playerY + 2, playerZ, Blocks.iron_block);
                    world.setBlock(playerX - 1, playerY + 2, playerZ, Blocks.iron_block);
                    world.setBlock(playerX, playerY + 2, playerZ + 1, Blocks.iron_block);
                    world.setBlock(playerX, playerY + 2, playerZ - 1, Blocks.iron_block);
                    world.setBlock(playerX + 1, playerY + 2, playerZ + 1, Blocks.iron_block);
                    world.setBlock(playerX - 1, playerY + 2, playerZ - 1, Blocks.iron_block);
                    world.setBlock(playerX + 1, playerY + 2, playerZ - 1, Blocks.iron_block);
                    world.setBlock(playerX - 1, playerY + 2, playerZ + 1, Blocks.iron_block);

                    world.setBlock(playerX, playerY + 3, playerZ, Blocks.beacon);
                }

                player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.GOLD + StatCollector.translateToLocal("dice.roll.special") + " " + diceRand + "."));
            }else{
                player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.DARK_GREEN + StatCollector.translateToLocal("dice.roll.normal") + " " + diceRand + "."));
            }
        }

        return item;
    }

}
