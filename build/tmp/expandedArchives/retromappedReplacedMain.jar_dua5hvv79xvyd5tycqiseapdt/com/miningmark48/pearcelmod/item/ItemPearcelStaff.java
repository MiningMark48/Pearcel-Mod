package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import net.minecraft.item.Item.ToolMaterial;
public class ItemPearcelStaff extends ItemPearcelSword{

    public ItemPearcelStaff(ToolMaterial material) {
        super(material);
    }

    @Override
    public void func_77663_a(ItemStack stack, World world, Entity entity, int par4, boolean par5){
        super.func_77663_a(stack, world, entity, par4, par5);
        {
            EntityPlayer player = (EntityPlayer) entity;
            ItemStack equipped = player.func_71045_bC();
            if (equipped == stack){
                player.func_70690_d(new PotionEffect(Potion.field_76424_c.func_76396_c(), 20, 2));
            }
        }
    }

    public ItemStack func_77659_a(ItemStack item, World world, EntityPlayer player)
    {
        if (player.func_70093_af()){
            player.func_70690_d(new PotionEffect(Potion.field_76428_l.field_76415_H, 5000, 1));
            item.func_77972_a(50, player);
            return item;
        }else{
            if (player.field_70163_u <= ConfigurationHandler.maxStaffFlyHeight || player.field_71075_bZ.field_75098_d){
                player.func_70024_g(0, 0.5, 0);
            }else{
                if (!world.field_72995_K) {
                    player.func_146105_b(new ChatComponentTranslation(EnumChatFormatting.DARK_RED + StatCollector.func_74838_a("chat.pearcel_staff.weaken")));
                    item.func_77972_a(10, player);
                }
            }
            item.func_77972_a(1, player);
            return item;
        }
    }

    @Override
    public boolean func_77644_a(ItemStack stack, EntityLivingBase hitEntity, EntityLivingBase attackEntity){
        hitEntity.func_70690_d(new PotionEffect(Potion.field_76437_t.field_76415_H, 2000, 2));
        hitEntity.func_70690_d(new PotionEffect(Potion.field_76421_d.field_76415_H, 5000, 2));
        return true;
    }
}
