package com.miningmark48.pearcelmod.client.handler;

import com.miningmark48.pearcelmod.client.settings.Keybindings;
import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.item.ItemPearcelStaff;
import com.miningmark48.pearcelmod.reference.Key;
import com.miningmark48.pearcelmod.utility.LogHelper;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class KeyInputEventHandler {

    private static Key getPressedKeybinding(){

        if (Keybindings.regen.isPressed()){
            return Key.REGEN;
        }else if(Keybindings.clear.isPressed()){
            return Key.CLEAR;
        }

        return Key.UNKNOWN;

    }

    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void handlerKeyInputEvent(InputEvent.KeyInputEvent event){

        LogHelper.info(getPressedKeybinding());

        EntityPlayer entityPlayer = FMLClientHandler.instance().getClientPlayerEntity();
        ItemStack currentEquippedStack = entityPlayer.getCurrentEquippedItem();
        if (currentEquippedStack  != null) {
            if (entityPlayer.worldObj.isRemote) {
                Item currentEquipped = currentEquippedStack.getItem();

                if (currentEquipped == ModItems.pearcelStaff){
                    if (Keybindings.regen.isPressed()) {
                        entityPlayer.addPotionEffect(new PotionEffect(Potion.regeneration.getId(), 200, 1));
                        currentEquippedStack.damageItem(10, entityPlayer);
                        LogHelper.info("REGENERATION");
                    }else if (Keybindings.clear.isPressed()){
                        entityPlayer.clearActivePotions();
                        currentEquippedStack.damageItem(5, entityPlayer);
                        LogHelper.info("CLEAR EFFECTS");
                    }

                }
            }
        }


    }

}
