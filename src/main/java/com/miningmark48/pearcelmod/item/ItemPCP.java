package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.PearcelMod;
import com.miningmark48.pearcelmod.handler.KeyHandler;
import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.reference.GUIs;
import com.miningmark48.pearcelmod.utility.KeyCheck;
import com.miningmark48.pearcelmod.utility.Translate;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemPCP extends ItemPearcelMod{

    public ItemPCP(){
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        if (KeyCheck.isHoldingShift()) {
            par3List.add(Translate.toLocal("tooltip.item.pcp.line1"));
        }else{
            par3List.add(Translate.toLocal("tooltip.item.hold") + " " + TextFormatting.AQUA + TextFormatting.ITALIC + Translate.toLocal("tooltip.item.shift"));
        }
    }

    @Override
    public ActionResult onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
        ItemStack stack = player.getHeldItem(hand);
        if (!player.isSneaking()){
            player.openGui(PearcelMod.instance, GUIs.gui_id_pcp, player.world, (int) player.posX, (int) player.posY, (int) player.posZ);
            return new ActionResult(EnumActionResult.PASS, stack);
        }else{
            return new ActionResult(EnumActionResult.PASS, stack);
        }
    }

}
