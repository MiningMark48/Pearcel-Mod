package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import com.miningmark48.pearcelmod.utility.KeyCheck;
import com.miningmark48.pearcelmod.utility.Translate;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class ItemStimulationPearcel extends ItemPearcelMod{

    private Random random = new Random();

    public ItemStimulationPearcel(){
        setMaxStackSize(1);
        setMaxDamage(2048);
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        if (KeyCheck.isHoldingShift()) {
            par3List.add(Translate.toLocal("tooltip.item.stimulation_pearcel.line1"));
        }else{
            par3List.add(Translate.toLocal("tooltip.item.hold") + " " + TextFormatting.AQUA + TextFormatting.ITALIC + Translate.toLocal("tooltip.item.shift"));
        }
    }

    @Override
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {

        if(!world.isRemote){
            IBlockState state = world.getBlockState(pos);
            Block block = state.getBlock();
            TileEntity te = world.getTileEntity(pos);


            for (int i = 0; i < ConfigurationHandler.stimulationPearcelTickAmount / (te == null ? 5 : 1); i++) {
                if (te == null) {
                    block.updateTick(world, pos, state, this.random);
                } else if ((te instanceof ITickable)) {
                    ((ITickable)te).update();
                }
            }
            if( te instanceof ITickable){
                ((ITickable)te).update();
            }

            stack.damageItem(1, player);

        }

        return EnumActionResult.SUCCESS;
    }

}
