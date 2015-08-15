package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.achievements.Achievements;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class ItemDice extends ItemPearcelMod{

    public ItemDice(){
        super();
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        par3List.add("Right click for special roll.");
        par3List.add("Sneak + Right click for normal roll.");
    }

    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player)
    {
        Random rand = new Random();
        int diceRand = rand.nextInt(6) + 1;

        int playerX = (int) player.posX;
        int playerY = (int) player.posY;
        int playerZ = (int) player.posZ;

        if (!world.isRemote){
            if (player.isSneaking()){
                player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.DARK_GREEN + "You rolled a " + diceRand + "."));
            }else{
                if (diceRand == 1){
                    player.addExperience(100);
                }else if(diceRand == 2){
                    player.addPotionEffect(new PotionEffect(Potion.confusion.id, 1000, 1));
                }else if(diceRand == 3){
                    world.setBlock(playerX, playerY + 2, playerZ, Blocks.iron_block);
                }else if(diceRand == 4){
                    world.setBlock(playerX, playerY + 10, playerZ, Blocks.anvil);
                }else if(diceRand == 5){
                    player.addPotionEffect(new PotionEffect(Potion.wither.id, 1000, 0));
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

                player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.DARK_GREEN + "You rolled a " + diceRand + "."));
            }
        }

        return item;
    }

}
