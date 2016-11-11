package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.inventory.InventoryBindle;
import com.miningmark48.pearcelmod.reference.GUIs;
import com.miningmark48.pearcelmod.reference.Reference;
import com.miningmark48.pearcelmod.utility.KeyCheck;
import com.miningmark48.pearcelmod.utility.Translate;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemBindle extends ItemPearcelMod{

    public ItemBindle(){
        setMaxStackSize(1);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        if (KeyCheck.isHoldingShift()) {
            list.add(InventoryBindle.INV_SIZE + " " + Translate.toLocal("tooltip.item.pearcel_backpack.line1"));
        }else{
            list.add(Translate.toLocal("tooltip.item.hold") + " " + TextFormatting.AQUA + TextFormatting.ITALIC + Translate.toLocal("tooltip.item.shift"));
        }

    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 1;
    }

    @Override
    public ActionResult onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand){
        if(!world.isRemote){
            if(!player.isSneaking() && hand == EnumHand.MAIN_HAND){
                player.openGui(Reference.MOD_ID, GUIs.gui_id_bindle, world, 0, 0, 0);
            }
        }

        return new ActionResult(EnumActionResult.SUCCESS, stack);

    }

}
