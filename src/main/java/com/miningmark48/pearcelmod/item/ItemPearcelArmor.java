package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.reference.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemPearcelArmor extends ItemArmor{

    public ItemPearcelArmor(ArmorMaterial material, EntityEquipmentSlot type) {
        super(material, 0, type);
    }

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
        if (stack.getItem() == ModItems.pearcel_helmet || stack.getItem() == ModItems.pearcel_chestplate || stack.getItem() == ModItems.pearcel_boots){
            return Reference.MOD_ID + ":textures/model/armor/pearcel_layer_1.png";
        }else if (stack.getItem() == ModItems.pearcel_leggings){
            return Reference.MOD_ID + ":textures/model/armor/pearcel_layer_2.png";
        }else{
            return null;
        }
    }

}
