package com.miningmark48.pearcelmod.event;

import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.inventory.InventoryCharmBag;
import com.miningmark48.pearcelmod.item.ItemCharmedPearcel;
import com.miningmark48.pearcelmod.utility.LogHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventCharms {

    @SubscribeEvent
    public void onPlayerHurt(LivingHurtEvent e){
        if (e.getEntity() instanceof EntityPlayer){
            EntityPlayer player = (EntityPlayer) e.getEntity();
            if (e.getSource() == DamageSource.fall){
                if (player.inventory.hasItemStack(new ItemStack(ModItems.charmed_pearcel)) || player.inventory.hasItemStack(new ItemStack(ModItems.charm_bag))){
                    for (int i = 0; i <= player.inventory.getSizeInventory(); i++){
                        if (player.inventory.getStackInSlot(i) != null){
                            if (player.inventory.getStackInSlot(i).getItem() == ModItems.charmed_pearcel) {
                                if (player.inventory.getStackInSlot(i).hasTagCompound()) {
                                    if (player.inventory.getStackInSlot(i).getTagCompound().getString("type").equalsIgnoreCase("fall")) {
                                        e.setCanceled(true);
                                    }
                                }
                            }
                            if(player.inventory.getStackInSlot(i).getItem() == ModItems.charm_bag){
                                if (player.inventory.getStackInSlot(i).hasTagCompound()) {
                                    NBTTagCompound compound = player.inventory.getStackInSlot(i).getTagCompound();

                                    NBTTagList items = compound.getTagList("ItemInventory", Constants.NBT.TAG_COMPOUND);
                                    for (int j = 0; j < items.tagCount(); j++){
                                        NBTTagCompound item = (NBTTagCompound) items.getCompoundTagAt(j);
                                        int slot = item.getInteger("Slot");
                                        if(slot >= 0 && slot < InventoryCharmBag.INV_SIZE){
                                            if (ItemStack.loadItemStackFromNBT(item).hasTagCompound()){
                                                if (ItemStack.loadItemStackFromNBT(item).getTagCompound().getString("type").equalsIgnoreCase("fall")){
                                                    e.setCanceled(true);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
