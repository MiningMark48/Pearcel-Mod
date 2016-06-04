package com.miningmark48.pearcelmod.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class ItemExperiencePearcel extends ItemPearcelMod{

    public ItemExperiencePearcel(){
        func_77625_d(1);
    }

    Random rand = new Random();

    @Override
    public void func_77624_a(ItemStack stack, EntityPlayer player, List list, boolean par4) {

        list.add(StatCollector.func_74838_a("tooltip.item.experiencePearcel.line1"));
        list.add("");

        if (stack.func_77942_o()) {
            if (stack.func_77978_p().func_74762_e("playerXP") == 0) {
                list.add(EnumChatFormatting.RED + StatCollector.func_74838_a("tooltip.item.experiencePearcel.line2.noXP"));
            }else{
                list.add(EnumChatFormatting.GOLD + StatCollector.func_74838_a("tooltip.item.experiencePearcel.line2.XP") + " " + EnumChatFormatting.AQUA + stack.func_77978_p().func_74762_e("playerXP"));
            }
        }else{
            list.add(EnumChatFormatting.RED + StatCollector.func_74838_a("tooltip.item.experiencePearcel.line2.noXP"));
        }

    }

    @Override
    public ItemStack func_77659_a(ItemStack item, World world, EntityPlayer player)
    {
        if(!item.func_77942_o()){
            item.func_77982_d(new NBTTagCompound());
            item.func_77978_p().func_74768_a("playerXP", 0);
        }
        if (!player.func_70093_af()){
            int xpToGather = player.field_71068_ca + item.func_77978_p().func_74762_e("playerXP");
            player.field_71068_ca = xpToGather;
            item.func_77978_p().func_74768_a("playerXP", 0);
            player.func_85030_a("random.orb", 0.2F, rand.nextFloat() * 2.5F);
            return item;
        }else{
            int xpToStore = player.field_71068_ca + item.func_77978_p().func_74762_e("playerXP");
            item.func_77978_p().func_74768_a("playerXP", xpToStore);
            player.field_71068_ca = 0;
            player.func_85030_a("random.orb", 0.2F, rand.nextFloat() * 2.5F);
            return item;
        }
    }

}
