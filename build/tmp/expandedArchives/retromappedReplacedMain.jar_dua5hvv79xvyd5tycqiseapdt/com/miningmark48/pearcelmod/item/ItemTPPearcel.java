package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public class ItemTPPearcel extends ItemPearcelMod{

    double tpX = 0;
    double tpY = 0;
    double tpZ = 0;
    int dim = 0;

    public ItemTPPearcel(){
        func_77625_d(1);
        func_77656_e(128);
    }

    @Override
    public void func_77624_a(ItemStack stack, EntityPlayer player, List list, boolean par4) {

        list.add(StatCollector.func_74838_a("tooltip.item.tpPearcel.line1"));
        list.add("");

        if (stack.func_77942_o()) {
            if (stack.func_77978_p().func_74769_h("tpX") == 0D && stack.func_77978_p().func_74769_h("tpY") == 0D && stack.func_77978_p().func_74769_h("tpZ") == 0D) {
                list.add(EnumChatFormatting.RED + StatCollector.func_74838_a("tooltip.item.tpPearcel.line2.notBound"));
            }else{
                list.add(EnumChatFormatting.GREEN + StatCollector.func_74838_a("tooltip.item.tpPearcel.line2.bound") + " " + EnumChatFormatting.AQUA + Math.round(stack.func_77978_p().func_74769_h("tpX")) + " " + Math.round(stack.func_77978_p().func_74769_h("tpY")) + " " + Math.round(stack.func_77978_p().func_74769_h("tpZ")));
            }
        }else{
            list.add(EnumChatFormatting.RED + StatCollector.func_74838_a("tooltip.item.tpPearcel.line2.notBound"));
        }

    }

    @Override
    public ItemStack func_77659_a(ItemStack stack, World world, EntityPlayer player)
    {
        if (!stack.func_77942_o()){
            stack.func_77982_d(new NBTTagCompound());
            stack.func_77978_p().func_74780_a("tpX", 0D);
            stack.func_77978_p().func_74780_a("tpY", 0D);
            stack.func_77978_p().func_74780_a("tpZ", 0D);
            stack.func_77978_p().func_74768_a("dim", 0);
        }
        if (player.func_70093_af()) {
            stack.func_77978_p().func_74780_a("tpX", player.field_70165_t);
            stack.func_77978_p().func_74780_a("tpY", player.field_70163_u);
            stack.func_77978_p().func_74780_a("tpZ", player.field_70161_v);
            stack.func_77978_p().func_74768_a("dim", player.field_71093_bK);
            if(!world.field_72995_K) {
                player.func_146105_b(new ChatComponentTranslation(EnumChatFormatting.DARK_GREEN + StatCollector.func_74838_a("chat.tpPearcel.location.set")));
            }
        }else{
            tpX = stack.func_77978_p().func_74769_h("tpX");
            tpY = stack.func_77978_p().func_74769_h("tpY");
            tpZ = stack.func_77978_p().func_74769_h("tpZ");
            dim = stack.func_77978_p().func_74762_e("dim");
            if (tpX == 0D && tpY == 0D && tpZ == 0D) {
                if (!world.field_72995_K) {
                    player.func_146105_b(new ChatComponentTranslation(EnumChatFormatting.RED + StatCollector.func_74838_a("chat.tpPearcel.location.notSet")));
                }
            } else {
                if (player.field_71093_bK == dim) {
                    player.func_70634_a(tpX, tpY, tpZ);
                    if (!world.field_72995_K) {
                        player.func_146105_b(new ChatComponentTranslation(EnumChatFormatting.GOLD + StatCollector.func_74838_a("chat.tpPearcel.tp")));
                    }
                    if (!player.field_71075_bZ.field_75098_d) {
                        if (player.field_71071_by.func_70431_c(new ItemStack(ModItems.pearcel_item))) {
                            player.field_71071_by.func_146026_a(ModItems.pearcel_item);
                        } else {
                            stack.func_77972_a(1, player);
                        }
                    }
                }else{
                    if(!world.field_72995_K){
                        player.func_146105_b(new ChatComponentTranslation(EnumChatFormatting.RED + StatCollector.func_74838_a("chat.tpPearcel.wrongDim")));
                    }
                }
            }
        }
        return stack;
    }

}
