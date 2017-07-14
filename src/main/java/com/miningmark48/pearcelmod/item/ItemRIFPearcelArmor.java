package com.miningmark48.pearcelmod.item;

import com.miningmark48.mininglib.utility.KeyChecker;
import com.miningmark48.mininglib.utility.ModTranslate;
import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import com.miningmark48.pearcelmod.init.ModItems;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemRIFPearcelArmor extends ItemArmor{

    ItemStack helmet;
    ItemStack chestplate;
    ItemStack leggings;
    ItemStack boots;

    public ItemRIFPearcelArmor(ArmorMaterial material, EntityEquipmentSlot type){
        super(material, 0, type);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World playerIn, List<String> par3List, ITooltipFlag advanced) {
        if (KeyChecker.isHoldingShift()) {
            par3List.add(ModTranslate.toLocal("tooltip.item.rif_pearcel_armor.line1"));
        }else{
            par3List.add(ModTranslate.toLocal("tooltip.item.hold") + " " + TextFormatting.AQUA + TextFormatting.ITALIC + ModTranslate.toLocal("tooltip.item.shift"));
        }
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack stack){
        if (ConfigurationHandler.doRIFArmorFlight) {
            if (!player.isCreative()) {
                if (player.getItemStackFromSlot(EntityEquipmentSlot.HEAD) != null && player.getItemStackFromSlot(EntityEquipmentSlot.CHEST) != null && player.getItemStackFromSlot(EntityEquipmentSlot.LEGS) != null && player.getItemStackFromSlot(EntityEquipmentSlot.FEET) != null) {

                    helmet = player.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
                    chestplate = player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
                    leggings = player.getItemStackFromSlot(EntityEquipmentSlot.LEGS);
                    boots = player.getItemStackFromSlot(EntityEquipmentSlot.FEET);

                    if (player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() instanceof ItemRIFPearcelArmor && player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() instanceof ItemRIFPearcelArmor && player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() instanceof ItemRIFPearcelArmor && player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() instanceof ItemRIFPearcelArmor) {
                        player.capabilities.allowFlying = true;
                    }
                } else {
                    player.capabilities.allowFlying = false;
                    player.capabilities.isFlying = false;
                }
            }
        }else{
            player.capabilities.allowFlying = false;
            player.capabilities.isFlying = false;
        }
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.isItemEqual(new ItemStack(ModItems.armor_plating)) || super.getIsRepairable(toRepair, repair);
    }

}
