package com.miningmark48.pearcelmod.item;

import java.util.List;

import com.miningmark48.pearcelmod.PearcelMod;
import com.miningmark48.pearcelmod.creativetab.CreativeTabPearcelMod;

import com.miningmark48.pearcelmod.reference.GUIs;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;

public class ItemPearcelStaff extends ItemSword{

    public ItemPearcelStaff(ToolMaterial material)
    {
        super(material);
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        par3List.add("Right Click = Jump Boost");
        par3List.add("Shift + Right Click = Regen (-20 Durability)");
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5){
        super.onUpdate(stack, world, entity, par4, par5);
        {
            EntityPlayer player = (EntityPlayer) entity;
            ItemStack equipped = player.getCurrentEquippedItem();
            if (equipped == stack){
                player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 20, 2));
            }
        }
    }

    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player)
    {
        if (player.isSneaking()){
            player.addPotionEffect(new PotionEffect(Potion.regeneration.getId(), 200, 1));
            item.damageItem(20, player);
            return item;
        }else{
            player.addPotionEffect(new PotionEffect(Potion.jump.getId(), 100, 2));
            return item;
        }
    }
}
