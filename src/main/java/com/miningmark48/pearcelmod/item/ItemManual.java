package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.PearcelMod;
import com.miningmark48.pearcelmod.gui.manual.GuiManual;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemManual extends ItemPearcelMod{

    public ItemManual(){
        setMaxStackSize(1);
    }

    @Override
    public ActionResult onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand)
    {
        if (!player.isSneaking()){
            if (world.isRemote){
                PearcelMod.proxy.openMyGuiClient(new GuiManual());
            }
        }

        return new ActionResult(EnumActionResult.SUCCESS, stack);
    }

}
