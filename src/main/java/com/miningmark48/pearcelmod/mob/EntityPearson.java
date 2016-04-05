package com.miningmark48.pearcelmod.mob;

import com.miningmark48.pearcelmod.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeModContainer;

import java.util.Random;

public class EntityPearson extends EntityMob {

    Random rand = new Random();

    public EntityPearson(World world){
        super(world);
        this.setSize(0.6F, 2.0F);
        this.getNavigator().setBreakDoors(true);
        this.getNavigator().setCanSwim(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(4, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
    }

    public void applyEntityAttributes(){
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50.0F);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(5.0D);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(35.0D);
    }

    public boolean isAIEnabled(){
        return true;
    }

    protected Item getDropItem(){
        int randNum = rand.nextInt(100) + 1;
        if(randNum == 1){
            return ModItems.pearcelStaff;
        }else if (randNum >= 2 && randNum <= 8){
            return ModItems.pearcelPearl;
        }
        return ModItems.pearcel;
    }

    public void func_145780_a(int a, int b, int c, Block block)
    {
        this.playSound("mob.cow.step", 0.15F, 1.0F);
    }

    public void onDeathUpdate(){
        World world = this.worldObj;
        double x = this.posX;
        double y = this.posY;
        double z = this.posZ;

        world.spawnParticle("hugeexplosion", x, y, z, 1.0D, 0.0D, 0.0D);
        this.setDead();
    }

}
