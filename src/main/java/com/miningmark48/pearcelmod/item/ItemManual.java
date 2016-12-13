package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.PearcelMod;
import com.miningmark48.pearcelmod.achievements.Achievements;
import com.miningmark48.pearcelmod.gui.GuiManual;
import com.miningmark48.pearcelmod.reference.GUIs;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
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
            if (!world.isRemote){
                PearcelMod.proxy.openMyGuiClient(new GuiManual());
                Minecraft.getMinecraft().mouseHelper.ungrabMouseCursor();
                //player.openGui(PearcelMod.instance, GUIs.gui_id_manual, playerIn.worldObj, (int) playerIn.posX, (int) playerIn.posY, (int) playerIn.posZ);
            }
        }

        return new ActionResult(EnumActionResult.SUCCESS, stack);
    }

}
