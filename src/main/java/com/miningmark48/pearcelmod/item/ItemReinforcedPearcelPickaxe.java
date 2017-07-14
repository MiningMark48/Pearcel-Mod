package com.miningmark48.pearcelmod.item;

import com.miningmark48.mininglib.utility.KeyChecker;
import com.miningmark48.mininglib.utility.ModTranslate;
import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import com.miningmark48.pearcelmod.init.ModItems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemReinforcedPearcelPickaxe extends ItemPickaxe {
    public ItemReinforcedPearcelPickaxe(ToolMaterial material) {
        super(material);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World playerIn, List<String> par3List, ITooltipFlag advanced) {
        if (KeyChecker.isHoldingShift()) {
            par3List.add(ModTranslate.toLocal("tooltip.item.reinforced_pearcel_pickaxe.line1"));
            par3List.add(ModTranslate.toLocal("tooltip.item.reinforced_pearcel_pickaxe.line2"));
        }else{
            par3List.add(ModTranslate.toLocal("tooltip.item.hold") + " " + TextFormatting.AQUA + TextFormatting.ITALIC + ModTranslate.toLocal("tooltip.item.shift"));
        }
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving)
    {
        if ((double)state.getBlockHardness(worldIn, pos) != 0.0D)
        {
            stack.damageItem(1, entityLiving);

            if(state.getBlockHardness(worldIn, pos) >= ConfigurationHandler.rifPPickBaseHardness){
                state.getBlock().dropBlockAsItem(worldIn, pos, state, 10);
                worldIn.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, pos.getX(), pos.getY() + 1, pos.getZ(), 0.0D, 0.0125D, 0.0D);
            }

        }

        return true;
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
