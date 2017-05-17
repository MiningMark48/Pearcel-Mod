package com.miningmark48.pearcelmod.tileentity;

import com.miningmark48.pearcelmod.block.BlockPearcelBeacon;
import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import com.miningmark48.pearcelmod.init.ModBlocks;
import com.mojang.authlib.GameProfile;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.util.FakePlayerFactory;

import java.util.List;
import java.util.Random;
import java.util.UUID;

public class TileEntityPearcelBeacon extends TileEntity implements ITickable{

    FakePlayer fakePlayer;

    @Override
    public void update() {
        Random rand = new Random();
        World world = getWorld();
        BlockPos pos = getPos();
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        int range = ConfigurationHandler.pearcelBeaconRange;
        float damage = ConfigurationHandler.pearcelBeaconDamage;

        BlockPearcelBeacon beacon = (BlockPearcelBeacon) world.getBlockState(pos).getBlock();

        if (!world.isBlockPowered(pos)) {

            beacon.isActive = true;

            int num = rand.nextInt(2);
            switch (num) {
                default:
                    break;
                case 0:
                    world.spawnParticle(EnumParticleTypes.SPELL_MOB, x + 0.5, y + 1.875, z + 0.5, 4.47368D, 1.0D, 0.0D);
                    break;
            }


            List<EntityPlayer> players = world.getEntitiesWithinAABB(EntityPlayer.class, new AxisAlignedBB(x - range, y - range, z - range, x + range, y + range, z + range));
            List<EntityCreature> mobs = world.getEntitiesWithinAABB(EntityCreature.class, new AxisAlignedBB(x - range, y - range, z - range, x + range, y + range, z + range));

            for (EntityPlayer e : players) {
                e.addPotionEffect(new PotionEffect(MobEffects.SPEED, 200, 0, true, false));
                e.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 200, 0, true, false));
                e.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 200, 0, true, false));
                e.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 200, 0, true, false));
            }

            for (EntityCreature e : mobs) {
                if (e.isCreatureType(EnumCreatureType.MONSTER, false)) {
                    int num2 = rand.nextInt(10);
                    if (num2 == 0) {
                        if (fakePlayer == null) {
                            if (!world.isRemote) {
                                fakePlayer = FakePlayerFactory.get((WorldServer) world, new GameProfile(UUID.randomUUID(), ModBlocks.pearcel_beacon.getLocalizedName()));
                            }
                        }
                        if (e.getMaxHealth() >= 100) {
                            e.attackEntityFrom(DamageSource.causePlayerDamage(fakePlayer), damage * 15);
                        } else {
                            e.attackEntityFrom(DamageSource.causePlayerDamage(fakePlayer), damage);
                        }
                    }
                    world.spawnParticle(EnumParticleTypes.SPELL_MOB, e.posX, e.posY + 0.5, e.posZ, 1.0D, 0.0D, 0.0D);
                }

            }

        }else{
            beacon.isActive = false;
        }

    }


}
