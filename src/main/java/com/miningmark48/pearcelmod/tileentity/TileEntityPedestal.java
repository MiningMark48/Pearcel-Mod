package com.miningmark48.pearcelmod.tileentity;

import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import com.miningmark48.pearcelmod.init.ModBlocks;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class TileEntityPedestal extends TileEntity implements ITickable{

    @Override
    public void update() {
        World world = getWorld();
        BlockPos pos = getPos();
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        int range = ConfigurationHandler.pearcelMagnetRange;
        float pullSpeed = ConfigurationHandler.pearcelMagnetPullSpeed;

        if(world.getBlockState(pos.up()).getBlock().equals(ModBlocks.ender_pearcel_block)) {
            List<EntityItem> items = world.getEntitiesWithinAABB(EntityItem.class, new AxisAlignedBB(x - range, y - range, z - range, x + range, y + range, z + range));
            List<EntityXPOrb> xp = world.getEntitiesWithinAABB(EntityXPOrb.class, new AxisAlignedBB(x - range, y - range, z - range, x + range, y + range, z + range));
            for (EntityItem e : items) {
                e.addVelocity((x - e.posX + 0.5) * pullSpeed, (y - e.posY + 0.5) * pullSpeed, (z - e.posZ + 0.5) * pullSpeed); //Attracts
                if (ConfigurationHandler.pearcelMagnetParticles) {
                    world.spawnParticle(EnumParticleTypes.SPELL_INSTANT, e.posX, e.posY + 0.3, e.posZ, 0.0D, 0.0D, 0.0D);
                }

            }
            for (EntityXPOrb e : xp) {
                e.addVelocity((x - e.posX + 0.5) * pullSpeed, (y - e.posY + 0.5) * pullSpeed, (z - e.posZ + 0.5) * pullSpeed); //Attracts
            }
        }

    }
}
