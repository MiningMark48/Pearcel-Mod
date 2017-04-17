package com.miningmark48.pearcelmod.entity;

import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.World;

public class EntityPearcelBoss extends EntityMob{

    private final BossInfoServer bossInfo = (BossInfoServer)(new BossInfoServer(this.getDisplayName(), BossInfo.Color.GREEN, BossInfo.Overlay.PROGRESS)).setDarkenSky(true);

    public static ResourceLocation loot_table = new ResourceLocation(Reference.MOD_ID, "loot_tables/pearcel_boss.json");

    public EntityPearcelBoss(World world) {
        super(world);
        setSize(0.6F, 3.0F);
        this.isCreatureType(EnumCreatureType.MONSTER, true);
        this.initEntityAI();
    }

    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier)
    {
        EntityItem entityitem = this.dropItem(ModItems.pearcel_star, 1);

        if (entityitem != null)
        {
            entityitem.setNoDespawn();
        }

        if (!this.world.isRemote)
        {
            for (EntityPlayer entityplayer : this.world.getEntitiesWithinAABB(EntityPlayer.class, this.getEntityBoundingBox().expand(50.0D, 100.0D, 50.0D)))
            {
                //entityplayer.addStat(AchievementList.KILL_WITHER);
            }
        }
    }

    @Override
    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.5D, true));
        this.tasks.addTask(3, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 15.0F));
        this.tasks.addTask(9, new EntityAILookIdle(this));
        this.applyEntityAI();
    }

    protected void applyEntityAI()
    {
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityEnderman.class, true));
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
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(500.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.35D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(50.0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.125D);
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn)
    {
        float f = (float)this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue();
        int i = 0;

        if (entityIn instanceof EntityLivingBase)
        {
            f += EnchantmentHelper.getModifierForCreature(this.getHeldItemMainhand(), ((EntityLivingBase)entityIn).getCreatureAttribute());
            i += EnchantmentHelper.getKnockbackModifier(this);
        }

        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), f);

        if (flag)
        {
            if (i > 0 && entityIn instanceof EntityLivingBase)
            {
                ((EntityLivingBase)entityIn).knockBack(this, (float)i * 0.5F, (double) MathHelper.sin(this.rotationYaw * 0.017453292F), (double)(-MathHelper.cos(this.rotationYaw * 0.017453292F)));
                this.motionX *= 0.6D;
                this.motionZ *= 0.6D;
            }

            int j = EnchantmentHelper.getFireAspectModifier(this);

            if (j > 0)
            {
                entityIn.setFire(j * 4);
            }

            if (entityIn instanceof EntityPlayer)
            {
                EntityPlayer entityplayer = (EntityPlayer)entityIn;
                ItemStack itemstack = this.getHeldItemMainhand();
                ItemStack itemstack1 = entityplayer.isHandActive() ? entityplayer.getActiveItemStack() : null;

                if (itemstack != null && itemstack1 != null && itemstack.getItem() instanceof ItemAxe && itemstack1.getItem() == Items.SHIELD)
                {
                    float f1 = 0.25F + (float) EnchantmentHelper.getEfficiencyModifier(this) * 0.05F;

                    if (this.rand.nextFloat() < f1)
                    {
                        entityplayer.getCooldownTracker().setCooldown(Items.SHIELD, 100);
                        this.world.setEntityState(entityplayer, (byte)30);
                    }
                }

                entityplayer.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 40, 1, false, true));
                entityplayer.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 60, 0, false, true));
                entityplayer.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 40, 0, false, true));
                entityplayer.addPotionEffect(new PotionEffect(MobEffects.WITHER, 200, 1, false, true));
                entityplayer.addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, 100, 0, false, true));

            }

            this.applyEnchantments(this, entityIn);
        }

        return flag;
    }

//    @Override
//    protected ResourceLocation getLootTable()
//    {
//        return loot_tabel;
//    }

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
