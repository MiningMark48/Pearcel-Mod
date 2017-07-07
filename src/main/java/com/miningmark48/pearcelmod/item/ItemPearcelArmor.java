package com.miningmark48.pearcelmod.item;

import com.miningmark48.mininglib.utility.ModLogger;
import com.miningmark48.pearcelmod.init.ModItems;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemPearcelArmor extends ItemArmor{

    public ItemPearcelArmor(ItemArmor.ArmorMaterial material, EntityEquipmentSlot type){
        super(material, 0, type);
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.isItemEqual(new ItemStack(ModItems.armor_plating)) || super.getIsRepairable(toRepair, repair);
    }

}
