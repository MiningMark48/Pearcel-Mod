package com.miningmark48.pearcelmod.mob;

import com.miningmark48.pearcelmod.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityPearcelCow extends EntityAnimal{

    public EntityPearcelCow(World world){
        super(world);
        this.setSize(0.9F, 1.3F);
        this.getNavigator().setAvoidsWater(false);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.5D));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(3, new EntityAITempt(this, 1.25D, ModItems.pearcel, false));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
    }

    public boolean isAIEnabled(){
        return true;
    }

    protected void applyEntityAttributes(){
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0F);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.20000000298023224D);
    }

    @Override
    public EntityAgeable createChild(EntityAgeable p_90011_1_) {
        return new EntityPearcelCow(this.worldObj);
    }

    protected String getLivingSound()
    {
        return "mob.cow.say";
    }

    protected String getHurtSound()
    {
        return "mob.cow.hurt";
    }

    protected String getDeathSound()
    {
        return "mob.cow.hurt";
    }

    protected void func_145780_a(int a, int b, int c, Block block)
    {
        this.playSound("mob.cow.step", 0.15F, 1.0F);
    }

    protected Item getDropItem(){
        return ModItems.pearcelBeef;
    }

    //To be changed from bucket of milk to bucket of pearcel juice
    public boolean interact(EntityPlayer player)
    {
        ItemStack itemstack = player.inventory.getCurrentItem();

        if (itemstack != null && itemstack.getItem() == Items.bucket && !player.capabilities.isCreativeMode)
        {
            if (itemstack.stackSize-- == 1)
            {
                player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(ModItems.pearcelJuice));
            }
            else if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.pearcelJuice)))
            {
                player.dropPlayerItemWithRandomChoice(new ItemStack(ModItems.pearcelJuice, 1, 0), false);
            }

            return true;
        }
        else
        {
            return super.interact(player);
        }
    }

}
