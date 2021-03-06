package com.miningmark48.pearcelmod.event;

import com.miningmark48.pearcelmod.init.ModItems;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

public class EventOnPlayerAttack {

    @SubscribeEvent
    public void onPlayerAttack(LivingHurtEvent e){
        if (e.getEntityLiving() instanceof FakePlayer) {
            return;
        }
        if (e.getSource().getSourceOfDamage() instanceof EntityPlayer){
            EntityPlayer player = (EntityPlayer) e.getSource().getSourceOfDamage();
            if (!player.isCreative()) {
                    if (e.getEntityLiving().getHealth() - e.getAmount() <= 0) {
                        if (player.getHeldItemMainhand() != null && player.getHeldItemMainhand().getItem() == ModItems.pearcel_blood_dagger) {
                            ItemStack stack = player.getHeldItemMainhand();
                            if (!stack.hasTagCompound()) {
                                stack.setTagCompound(new NBTTagCompound());
                                stack.getTagCompound().setInteger("level", 1);
                            } else {
                                if (stack.getTagCompound().getInteger("level") <= 8) {
                                    stack.getTagCompound().setInteger("level", stack.getTagCompound().getInteger("level") + 1);
                                } else {
                                    stack.getTagCompound().setInteger("level", 0);
                                    EntityItem item = new EntityItem(player.getEntityWorld(), player.posX, player.posY + 0.5, player.posZ);
                                    item.setEntityItemStack(new ItemStack(ModItems.blood_drop));
                                    Random rand = new Random();
                                    int num = rand.nextInt(2) + 1;
                                    for (int i = 0; i <= num; i++) {
                                        player.getEntityWorld().spawnEntity(item);
                                    }
                                }
                            }
                        }
                    }
            }
        }
    }

}
