package com.miningmark48.pearcelmod.handler;

import net.minecraft.item.ItemStack;

public interface IGeneratorFuelHandler {

    int getCooldownTime(ItemStack fuel);
    int getRFPerTick(ItemStack fuel);

}
