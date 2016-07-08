package com.miningmark48.pearcelmod.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemPEPC extends ItemPearcelMod{

    public ItemPEPC(){
        setMaxStackSize(1);
    }

    @Override
    public ActionResult onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand)
    {
        if (!player.isSneaking()){
            player.displayGUIChest(player.getInventoryEnderChest());
            player.playSound(SoundEvents.BLOCK_CHEST_OPEN, 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
            return new ActionResult(EnumActionResult.PASS, stack);
        }else{
            return new ActionResult(EnumActionResult.PASS, stack);
        }
    }

}
