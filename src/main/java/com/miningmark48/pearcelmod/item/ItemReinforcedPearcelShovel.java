package com.miningmark48.pearcelmod.item;

import com.miningmark48.mininglib.utility.KeyChecker;
import com.miningmark48.mininglib.utility.ModTranslate;
import com.miningmark48.pearcelmod.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ItemReinforcedPearcelShovel extends ItemSpade{

    public ItemReinforcedPearcelShovel(Item.ToolMaterial material) {
        super(material);
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        if (KeyChecker.isHoldingShift()) {
            par3List.add(ModTranslate.toLocal("tooltip.item.reinforced_pearcel_shovel.line1"));
        }else{
            par3List.add(ModTranslate.toLocal("tooltip.item.hold") + " " + TextFormatting.AQUA + TextFormatting.ITALIC + ModTranslate.toLocal("tooltip.item.shift"));
        }

        if(!par1ItemStack.isItemEnchanted()) {
            par1ItemStack.addEnchantment(Enchantments.SILK_TOUCH, 1);
        }

    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        return false;
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
        if (repair.isItemEqual(new ItemStack(ModItems.pearcel_ingot))){
            return true;
        }
        return false;
    }


}
