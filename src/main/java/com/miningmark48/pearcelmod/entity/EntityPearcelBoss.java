package com.miningmark48.pearcelmod.entity;

import com.miningmark48.pearcelmod.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.World;

public class EntityPearcelBoss extends EntityMob{

    private final BossInfoServer bossInfo = (BossInfoServer)(new BossInfoServer(this.getDisplayName(), BossInfo.Color.GREEN, BossInfo.Overlay.PROGRESS)).setDarkenSky(true);

    public static ResourceLocation loot_tabel = new ResourceLocation(Reference.MOD_ID+ ":loot_tables/pearcel_boss.json");

    public EntityPearcelBoss(World world) {
        super(world);
        setSize(0.6F, 2.0F);
        //this.isCreatureType(EnumCreatureType.MONSTER, true);
        this.initEntityAI();
        this.setNoAI(false);
    }

    @Override
    public boolean isAIDisabled() {
        return false;
    }

    @Override
    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 15.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.applyEntityAI();
    }

    protected void applyEntityAI()
    {
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPig.class, true));
    }

    @Override
    public void damageEntity(DamageSource source, float amount)
    {
        if (this.getHealth() - amount <= 0)
        {
            this.setHealth(0);
            this.bossInfo.setPercent(0);

            if (source.getEntity() instanceof EntityPlayer)
            {
                //TODO
            }
        }
        else
        {
            super.damageEntity(source, amount);
            this.bossInfo.setPercent(getHealth() / getMaxHealth());
        }
    }

    @Override
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEAD;
    }

    @Override
    protected boolean canDespawn() {
        return false;
    }

    @Override
    public void setDead(){
        super.setDead();
        this.setHealth(0.0F);
        this.bossInfo.setVisible(false);
    }

    @Override
    public void addTrackingPlayer(EntityPlayerMP player){
        super.addTrackingPlayer(player);
        bossInfo.addPlayer(player);
    }

    @Override
    public void removeTrackingPlayer(EntityPlayerMP player){
        super.removeTrackingPlayer(player);
        bossInfo.removePlayer(player);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
    }

    @Override
    public boolean attackEntityAsMob(Entity entityTarget)
    {
        return true;
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return loot_tabel;
    }

    protected void playStepSound(BlockPos pos, Block blockIn)
    {
        this.playSound(SoundEvents.ENTITY_COW_STEP, 0.15F, 1.0F);
    }

    @Override
    public boolean isNonBoss() {
        return false;
    }

    @Override
    protected boolean canDropLoot()
    {
        return true;
    }
}
