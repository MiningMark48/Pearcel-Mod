package com.miningmark48.pearcelmod.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
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
        par3List.add("Right click for to roll.");
    }

    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player)
    {
        Random rand = new Random();
        int diceRand = rand.nextInt(6) + 1;
        if (!world.isRemote){
            player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.DARK_GREEN + "You rolled a " + diceRand + "."));
        }
        return item;
    }

}
