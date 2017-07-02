package com.miningmark48.pearcelmod.item;

import com.miningmark48.mininglib.utility.KeyChecker;
import com.miningmark48.mininglib.utility.ModTranslate;
import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
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
        setMaxDamage(4096); //TODO: Make Config
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        if (KeyChecker.isHoldingShift()) {
            par3List.add(ModTranslate.toLocal("tooltip.item.stimulation_pearcel.line1"));
        }else{
            par3List.add(ModTranslate.toLocal("tooltip.item.hold") + " " + TextFormatting.AQUA + TextFormatting.ITALIC + ModTranslate.toLocal("tooltip.item.shift"));
        }
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {

        ItemStack stack = player.getHeldItem(hand);

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
