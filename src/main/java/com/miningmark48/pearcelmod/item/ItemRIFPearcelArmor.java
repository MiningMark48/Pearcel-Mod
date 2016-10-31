package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.utility.KeyCheck;
import com.miningmark48.pearcelmod.utility.LogHelper;
import com.miningmark48.pearcelmod.utility.Translate;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemRIFPearcelArmor extends ItemArmor{

    ItemStack helmet;
    ItemStack chestplate;
    ItemStack leggings;
    ItemStack boots;

    Item flyHelmet = ModItems.rif_pearcel_helmet;
    Item flyChestplate = ModItems.rif_pearcel_chestplate;
    Item flyLeggings = ModItems.rif_pearcel_leggings;
    Item flyBoots = ModItems.rif_pearcel_boots;

    public ItemRIFPearcelArmor(ArmorMaterial material, EntityEquipmentSlot type){
        super(material, 0, type);
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        if (KeyCheck.isHoldingShift()) {
            par3List.add(Translate.toLocal("tooltip.item.rif_pearcel_armor.line1"));
        }else{
            par3List.add(Translate.toLocal("tooltip.item.hold") + " " + TextFormatting.AQUA + TextFormatting.ITALIC + Translate.toLocal("tooltip.item.shift"));
        }
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack stack){
        //TODO: Add config setting to disable
        if (!player.isCreative()) {
            if (player.getItemStackFromSlot(EntityEquipmentSlot.HEAD) != null && player.getItemStackFromSlot(EntityEquipmentSlot.CHEST) != null && player.getItemStackFromSlot(EntityEquipmentSlot.LEGS) != null && player.getItemStackFromSlot(EntityEquipmentSlot.FEET) != null) {

                helmet = player.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
                chestplate = player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
                leggings = player.getItemStackFromSlot(EntityEquipmentSlot.LEGS);
                boots = player.getItemStackFromSlot(EntityEquipmentSlot.FEET);

                if(player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() instanceof ItemRIFPearcelArmor && player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() instanceof ItemRIFPearcelArmor && player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() instanceof ItemRIFPearcelArmor && player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() instanceof ItemRIFPearcelArmor) {
                    player.capabilities.allowFlying = true;
                    player.capabilities.setFlySpeed(0.065F);
                }
            } else {
                player.capabilities.allowFlying = false;
                player.capabilities.isFlying = false;
                player.capabilities.setFlySpeed(0.05F);
            }
        }
    }

}
