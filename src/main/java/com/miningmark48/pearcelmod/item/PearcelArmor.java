package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.reference.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;


public class PearcelArmor extends ItemArmor {

    public PearcelArmor(ArmorMaterial material, int type) {
        super(material, 0, type);
    }

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
        if (stack.getItem() == ModItems.pearcelHelmet || stack.getItem() == ModItems.pearcelChestplate || stack.getItem() == ModItems.pearcelBoots){
            return Reference.MOD_ID + ":textures/armor/pearcelArmor1.png";
        }else if (stack.getItem() == ModItems.pearcelLeggings){
            return Reference.MOD_ID + ":textures/armor/pearcelArmor2.png";
        }else{
            return null;
        }
    }
}