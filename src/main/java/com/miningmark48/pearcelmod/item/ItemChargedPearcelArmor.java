package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemChargedPearcelArmor extends ItemArmor{

    public ItemChargedPearcelArmor(ArmorMaterial material, int type) {
        super(material, 0, type);
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack){
        return true;
    }

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
        if (stack.getItem() == ModItems.chargedPearcelHelmet || stack.getItem() == ModItems.chargedPearcelChestplate || stack.getItem() == ModItems.chargedPearcelBoots){
            return Reference.MOD_ID + ":textures/armor/chargedPearcelArmor1.png";
        }else if (stack.getItem() == ModItems.chargedPearcelLeggings){
            return Reference.MOD_ID + ":textures/armor/chargedPearcelArmor2.png";
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
        if(player.getCurrentArmor(3) != null && player.getCurrentArmor(2) != null && player.getCurrentArmor(1) != null && player.getCurrentArmor(0) != null){
            ItemStack helmet = player.getCurrentArmor(3);
            ItemStack chestplate = player.getCurrentArmor(2);
            ItemStack leggings = player.getCurrentArmor(1);
            ItemStack boots = player.getCurrentArmor(0);
            if (helmet.getItem() == ModItems.chargedPearcelHelmet && chestplate.getItem() == ModItems.chargedPearcelChestplate && leggings.getItem() == ModItems.chargedPearcelLeggings && boots.getItem() == ModItems.chargedPearcelBoots ){
                player.addPotionEffect(new PotionEffect(Potion.damageBoost.getId(), 20, 1));
                player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 20, 2));
            }
        }
    }

}
