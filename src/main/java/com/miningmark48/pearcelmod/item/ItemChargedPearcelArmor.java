package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemChargedPearcelArmor extends ItemArmor{

    public ItemChargedPearcelArmor(ArmorMaterial material, int type) {
        super(material, 0, type);
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack){
        return true;
    }

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
        if (stack.getItem() == ModItems.chargedPearcelHelmet || stack.getItem() == ModItems.chargedPearcelChestplate || stack.getItem() == ModItems.chargedPearcelBoots){
            return Reference.MOD_ID + ":textures/armor/chargedPearcelArmor1.png";
        }else if (stack.getItem() == ModItems.chargedPearcelLeggings){
            return Reference.MOD_ID + ":textures/armor/chargedPearcelArmor2.png";
        }else{
            return null;
        }
    }

}
