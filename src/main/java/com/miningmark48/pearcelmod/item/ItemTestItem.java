package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.utility.LogHelper;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemTestItem extends ItemPearcelMod{

    public ItemTestItem(){
        super();
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5){
        super.onUpdate(stack, world, entity, par4, par5);

        double boundXMin = entity.boundingBox.minX;
        double boundYMin = entity.boundingBox.minY;
        double boundZMin = entity.boundingBox.minZ;
        double boundXMax = entity.boundingBox.maxX;
        double boundYMax = boundYMin / 2;
        double boundZMax = entity.boundingBox.maxZ;
        double entityPosX = entity.posX;
        double entityPosY = entity.posY;
        double entityPosZ = entity.posZ;

        if (entity.isSneaking()){
            LogHelper.info("1: " + entity.boundingBox.maxY);
            entity.boundingBox.setBounds(boundXMin, boundYMin, boundZMin, boundXMax, boundYMax, boundZMax);
            LogHelper.info("2: " + entity.boundingBox.maxY);
        }
    }
}
