package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.PearcelMod;
import com.miningmark48.pearcelmod.reference.GUIs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public class ItemPCP extends ItemPearcelMod{

    public ItemPCP(){
        super();
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        par3List.add(StatCollector.translateToLocal("tooltip.item.pcp.line1"));
    }

    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player)
    {
        if (!player.isSneaking()){
            player.openGui(PearcelMod.instance, GUIs.guiIDPCP, player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ);
            return item;
        }else{
            return item;
        }
    }

}
