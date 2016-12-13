package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.PearcelMod;
import com.miningmark48.pearcelmod.achievements.Achievements;
import com.miningmark48.pearcelmod.gui.GuiManual;
import com.miningmark48.pearcelmod.reference.GUIs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemManual extends ItemPearcelMod{

    public ItemManual(){
        setMaxStackSize(1);
    }

    @Override
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

        if (!playerIn.isSneaking()){
            if (!worldIn.isRemote){
//                PearcelMod.proxy.openMyGuiClient(new GuiManual());
                playerIn.openGui(PearcelMod.instance, GUIs.gui_id_manual, playerIn.worldObj, (int) playerIn.posX, (int) playerIn.posY, (int) playerIn.posZ);
            }
        }

        return EnumActionResult.SUCCESS;
    }
}
