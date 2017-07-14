package com.miningmark48.pearcelmod.item;

import com.miningmark48.mininglib.utility.KeyChecker;
import com.miningmark48.mininglib.utility.ModTranslate;
import com.miningmark48.pearcelmod.entity.EntityPearcelBoss;
import com.miningmark48.pearcelmod.init.ModSoundEvents;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class ItemGuardianFood extends ItemPearcelFood{

    public ItemGuardianFood() {
        super(6, 1.0F, false);
        setAlwaysEdible();
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World playerIn, List<String> par3List, ITooltipFlag advanced) {
        if (KeyChecker.isHoldingShift()) {
            par3List.add(ModTranslate.toLocal("tooltip.item.guardian_food.line1"));
        }else{
            par3List.add(ModTranslate.toLocal("tooltip.item.hold") + " " + TextFormatting.AQUA + TextFormatting.ITALIC + ModTranslate.toLocal("tooltip.item.shift"));
        }
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
        BlockPos pos = player.getPosition();
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        Random rand = new Random();
        int num = rand.nextInt(5) + 10;
        int range = 25;

        List<EntityPlayer> players = world.getEntitiesWithinAABB(EntityPlayer.class, new AxisAlignedBB(x - range, y - range, z - range, x + range, y + range, z + range));

        if (!world.isRemote) {
            EntityPearcelBoss pb = new EntityPearcelBoss(world);
            pb.setPosition(x, y + num, z);
            world.spawnEntity(new EntityLightningBolt(world, x, y, z, true));
            world.spawnEntity(pb);

            for (EntityPlayer e : players) {
                e.sendMessage(new TextComponentString(TextFormatting.GREEN + ModTranslate.toLocal("chat.item.guardian_food.summoned")));
            }
        }

        world.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, x + 0.5, y + num + 0.5, z + 0.5, 1.0D, 0.0D, 0.0D);
        for (EntityPlayer e : players) {
            e.playSound(ModSoundEvents.MOB_PEARCEL_BOSS_LAUGH, 5.0F, 1.0F);
        }

    }
}
