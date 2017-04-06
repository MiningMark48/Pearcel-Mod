package com.miningmark48.pearcelmod.item;
import com.miningmark48.pearcelmod.init.ModItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemPearcelShears extends ItemShears{

    public ItemPearcelShears(){
        setMaxDamage(4096);
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
