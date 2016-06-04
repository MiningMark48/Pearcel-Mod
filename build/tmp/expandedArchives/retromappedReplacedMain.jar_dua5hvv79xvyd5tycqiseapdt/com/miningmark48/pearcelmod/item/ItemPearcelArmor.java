package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.reference.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import net.minecraft.item.ItemArmor.ArmorMaterial;
public class ItemPearcelArmor extends ItemArmor{

    public ItemPearcelArmor(ArmorMaterial material, int type) {
        super(material, 0, type);
    }

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
        if (stack.func_77973_b() == ModItems.pearcel_helmet || stack.func_77973_b() == ModItems.pearcel_chestplate || stack.func_77973_b() == ModItems.pearcel_boots){
            return Reference.MOD_ID + ":textures/model/armor/pearcel_layer_1.png";
        }else if (stack.func_77973_b() == ModItems.pearcel_leggings){
            return Reference.MOD_ID + ":textures/model/armor/pearcel_layer_2.png";
        }else{
            return null;
        }
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack stack){
        /*
            3 = Helmet
            2 = Chestplate
            1 = Leggings
            0 = Boots
        */
        if(player.func_82169_q(3) != null && player.func_82169_q(2) != null && player.func_82169_q(1) != null && player.func_82169_q(0) != null){
            ItemStack helmet = player.func_82169_q(3);
            ItemStack chestplate = player.func_82169_q(2);
            ItemStack leggings = player.func_82169_q(1);
            ItemStack boots = player.func_82169_q(0);
            if (helmet.func_77973_b() == ModItems.pearcel_helmet && chestplate.func_77973_b() == ModItems.pearcel_chestplate && leggings.func_77973_b() == ModItems.pearcel_leggings && boots.func_77973_b() == ModItems.pearcel_boots ){
                player.func_70690_d(new PotionEffect(Potion.field_76420_g.func_76396_c(), 20));
            }
        }
    }

}
