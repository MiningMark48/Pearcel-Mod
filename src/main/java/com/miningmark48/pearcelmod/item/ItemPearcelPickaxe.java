package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.entity.EntityPTNT;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.List;

public class ItemPearcelPickaxe extends ItemPickaxe{

    public ItemPearcelPickaxe (ToolMaterial material){
        super(material);
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        par3List.add(StatCollector.translateToLocal("tooltip.item.pearcelPickaxe.line1"));
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5){
        super.onUpdate(stack, world, entity, par4, par5);
        {
            EntityPlayer player = (EntityPlayer) entity;
            ItemStack equipped = player.getCurrentEquippedItem();
            if (equipped == stack){
                player.addPotionEffect(new PotionEffect(Potion.digSpeed.getId(), 20, 0));
            }
        }
    }

    /*public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        EntityTNTPrimed tnt = new EntityPTNT(world);
        MovingObjectPosition movingobjectposition = entityplayer.rayTrace(70D, 1.0F);
        if (movingobjectposition == null)
        {
            return itemstack;
        }
        Vec3 vec3d = movingobjectposition.hitVec;
        double d = vec3d.xCoord;
        double d1 = vec3d.yCoord;
        double d2 = vec3d.zCoord;
        int i = MathHelper.floor_double(d);
        int j = MathHelper.floor_double(d1);
        int k = MathHelper.floor_double(d2);
        tnt.setPosition(i, j, k);
        tnt.setInvisible(true);
        world.spawnEntityInWorld(tnt);

        return itemstack;
    }*/

}
