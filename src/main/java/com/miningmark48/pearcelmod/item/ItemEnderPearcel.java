package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.entity.EntityEnderPearcel;
import com.miningmark48.pearcelmod.utility.Translate;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

import java.util.List;

public class ItemEnderPearcel extends ItemPearcelMod{

    public ItemEnderPearcel(){
        setMaxDamage(128);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {

        list.add(Translate.toLocal("tooltip.item.pearcelPearl.line1"));

    }

    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
        stack.damageItem(1, player);
        world.playSound(player, player.getPosition(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 0.5F, 0.4F);
        if (!world.isRemote) {
            EntityEnderPearcel pearl = new EntityEnderPearcel(world, player);
            pearl.motionX *= 2;
            pearl.motionY *= 2;
            pearl.motionZ *= 2;
            world.spawnEntityInWorld(pearl);
        }
        return stack;
    }

}
