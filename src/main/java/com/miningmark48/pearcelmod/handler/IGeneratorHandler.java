package com.miningmark48.pearcelmod.handler;

import net.minecraft.item.ItemStack;

public interface IGeneratorHandler {

    int getCooldownTime(ItemStack fuel);
    int getRFPetTick(ItemStack fuel);

}
