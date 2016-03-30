package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.entity.EntityPearcelPearl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public class ItemPearcelPearl extends ItemPearcelMod{

    public ItemPearcelPearl(){

    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {

        list.add(StatCollector.translateToLocal("tooltip.item.pearcelPearl.line1"));

    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
        stack.damageItem(1, player);
        world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F);
        if (!world.isRemote) {
            EntityPearcelPearl pearl = new EntityPearcelPearl(world, player);
            pearl.motionX *= 2;
            pearl.motionY *= 2;
            pearl.motionZ *= 2;
            world.spawnEntityInWorld(pearl);
        }
        return stack;
    }

}
