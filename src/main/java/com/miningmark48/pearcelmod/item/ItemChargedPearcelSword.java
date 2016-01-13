package com.miningmark48.pearcelmod.item;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class ItemChargedPearcelSword extends ItemSword{

    public ItemChargedPearcelSword(ToolMaterial material)
    {
        super(material);
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        par3List.add(StatCollector.translateToLocal("tooltip.item.chargedPearcelSword.line1"));
        par3List.add("");
        par3List.add(StatCollector.translateToLocal("tooltip.item.chargedPearcelSword.line2"));
        par3List.add(StatCollector.translateToLocal("tooltip.item.chargedPearcelSword.line3"));
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5){
        super.onUpdate(stack, world, entity, par4, par5);
        {
            EntityPlayer player = (EntityPlayer) entity;
            ItemStack equipped = player.getCurrentEquippedItem();
            if (equipped == stack){
                player.addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 20, 0));
            }
        }
    }

    @Override
    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player){
        Random rand = new Random();
        int x = Minecraft.getMinecraft().objectMouseOver.blockX;
        int y = Minecraft.getMinecraft().objectMouseOver.blockY;
        int z = Minecraft.getMinecraft().objectMouseOver.blockZ;
        int damageDue = 1;
        int multiplier = 10;
        int lightningRangeMin = 2;
        int lightningRangeMax = 5;
        float exhaustionAmount = 1.0F;

        if (!world.getBlock(x, y, z).isAir(world, x, y, z)) {
            if (!player.isSneaking()) {
                world.spawnEntityInWorld(new EntityLightningBolt(world, x, y, z));
                player.getHeldItem().damageItem(damageDue, player);
                player.addExhaustion(exhaustionAmount);
            }else{
                for (int i = 0; i < rand.nextInt(lightningRangeMax) + lightningRangeMin; i++) {
                    world.spawnEntityInWorld(new EntityLightningBolt(world, x, y, z));
                    if (rand.nextInt(lightningRangeMax) % 2 == 0){
                        world.spawnEntityInWorld(new EntityLightningBolt(world, x + i, y, z));
                        world.spawnEntityInWorld(new EntityLightningBolt(world, x - i, y, z));
                        world.spawnEntityInWorld(new EntityLightningBolt(world, x, y, z + i));
                        world.spawnEntityInWorld(new EntityLightningBolt(world, x, y, z - i));
                    }else{
                        world.spawnEntityInWorld(new EntityLightningBolt(world, x + i, y, z + i));
                        world.spawnEntityInWorld(new EntityLightningBolt(world, x - i, y, z - i));
                        world.spawnEntityInWorld(new EntityLightningBolt(world, x + i, y, z - i));
                        world.spawnEntityInWorld(new EntityLightningBolt(world, x - i, y, z + i));
                    }
                }
                player.getHeldItem().damageItem(damageDue * multiplier, player);
                player.addExhaustion(exhaustionAmount * multiplier);
            }
        }

        return item;
    }

}
