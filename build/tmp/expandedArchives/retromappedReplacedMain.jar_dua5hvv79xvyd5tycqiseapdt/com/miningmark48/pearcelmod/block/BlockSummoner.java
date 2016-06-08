package com.miningmark48.pearcelmod.block;

import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.init.ModItems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.world.World;

import java.util.Random;

public class BlockSummoner extends BlockPearcelMod{

    public BlockSummoner(){

    }

    public boolean func_180639_a(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ){

        Random rand = new Random();
        int spawnRand = rand.nextInt(5) + 1;
        int negRand = rand.nextInt(2) + 1;
        
        int x = pos.func_177958_n();
        int y = pos.func_177956_o();
        int z = pos.func_177952_p();
        
        if (negRand == 1) {
            spawnRand = -spawnRand;
        }

        EntitySheep sheep = new EntitySheep(world);
        sheep.func_70107_b(x + spawnRand, y + 2, z + spawnRand);
        EntityEnderman enderman = new EntityEnderman(world);
        enderman.func_70107_b(x + spawnRand, y + 2, z + spawnRand);
        EntityBlaze blaze = new EntityBlaze(world);
        blaze.func_70107_b(x + spawnRand, y + 2, z + spawnRand);
        EntityGhast ghast = new EntityGhast(world);
        ghast.func_70107_b(x + spawnRand, y + 5, z + spawnRand);
        EntitySkeleton skeleton = new EntitySkeleton(world);
        skeleton.func_70107_b(x + spawnRand, y + 2, z + spawnRand);
        EntityCreeper creeper = new EntityCreeper(world);
        creeper.func_70107_b(x + spawnRand, y + 2, z + spawnRand);
        EntityEnderCrystal endcrystal = new EntityEnderCrystal(world);
        endcrystal.func_70107_b(x + spawnRand, y + 2, z + spawnRand);
        EntityHorse horse = new EntityHorse(world);
        horse.func_70107_b(x + spawnRand, y + 2, z + spawnRand);
        EntityIronGolem iron_golem = new EntityIronGolem(world);
        iron_golem.func_70107_b(x + spawnRand, y + 2, z + spawnRand);
        EntityVillager villager = new EntityVillager(world);
        villager.func_70107_b(x + spawnRand, y + 2, z + spawnRand);

        if(player.func_70694_bm() != null){
            if (!player.func_70093_af() && player.func_70694_bm().func_77973_b() == ModItems.sap) {
                if (!world.field_72995_K) {
                    //Missing Block
                    if (world.func_180495_p(pos.func_177984_a()).func_177230_c() == Blocks.field_150350_a) {
                        player.func_146105_b(new ChatComponentTranslation(EnumChatFormatting.DARK_RED + StatCollector.func_74838_a("summoner.error.missingBlock")));
                        if (world.field_72995_K) {
                            world.func_72838_d(new EntityLightningBolt(world, player.field_70165_t, player.field_70163_u, player.field_70161_v));
                        }
                    }
                    //Sheep
                    else if (world.func_180495_p(pos.func_177984_a()).func_177230_c() == Blocks.field_150325_L) {
                        world.func_175656_a(pos.func_177984_a(), ModBlocks.tainted_pearcel.func_176223_P());
                        world.func_72838_d(sheep);
                        player.func_146105_b(new ChatComponentTranslation(EnumChatFormatting.GOLD + StatCollector.func_74838_a("summoner.mob_summon.sheep") + " " + StatCollector.func_74838_a("summoner.summoned")));
                    }
                    //Enderman
                    else if (world.func_180495_p(pos.func_177984_a()).func_177230_c() == Blocks.field_150377_bs) {
                        world.func_175656_a(pos.func_177984_a(), ModBlocks.tainted_pearcel.func_176223_P());
                        world.func_72838_d(enderman);
                        player.func_146105_b(new ChatComponentTranslation(EnumChatFormatting.GOLD + StatCollector.func_74838_a("summoner.mob_summon.enderman") + " " + StatCollector.func_74838_a("summoner.summoned")));
                    }
                    //Blaze
                    else if (world.func_180495_p(pos.func_177984_a()).func_177230_c() == Blocks.field_150480_ab) {
                        world.func_175656_a(pos.func_177984_a(), ModBlocks.tainted_pearcel.func_176223_P());
                        world.func_72838_d(blaze);
                        player.func_146105_b(new ChatComponentTranslation(EnumChatFormatting.GOLD + StatCollector.func_74838_a("summoner.mob_summon.blaze") + " " + StatCollector.func_74838_a("summoner.summoned")));
                    }
                    //Ghast
                    else if (world.func_180495_p(pos.func_177984_a()).func_177230_c() == Blocks.field_150347_e) {
                        world.func_175656_a(pos.func_177984_a(), ModBlocks.tainted_pearcel.func_176223_P());
                        world.func_72838_d(ghast);
                        player.func_146105_b(new ChatComponentTranslation(EnumChatFormatting.GOLD + StatCollector.func_74838_a("summoner.mob_summon.ghast") + " " + StatCollector.func_74838_a("summoner.summoned")));
                    }
                    //Skeleton
                    else if (world.func_180495_p(pos.func_177984_a()).func_177230_c() == Blocks.field_150344_f) {
                        world.func_175656_a(pos.func_177984_a(), ModBlocks.tainted_pearcel.func_176223_P());
                        world.func_72838_d(skeleton);
                        player.func_146105_b(new ChatComponentTranslation(EnumChatFormatting.GOLD + StatCollector.func_74838_a("summoner.mob_summon.skeleton") + " " + StatCollector.func_74838_a("summoner.summoned")));
                    }
                    //Creeper
                    else if (world.func_180495_p(pos.func_177984_a()).func_177230_c() == Blocks.field_150335_W) {
                        world.func_175656_a(pos.func_177984_a(), ModBlocks.tainted_pearcel.func_176223_P());
                        world.func_72838_d(creeper);
                        player.func_146105_b(new ChatComponentTranslation(EnumChatFormatting.GOLD + StatCollector.func_74838_a("summoner.mob_summon.creeper") + " " + StatCollector.func_74838_a("summoner.summoned")));
                    }
                    //Horse
                    else if (world.func_180495_p(pos.func_177984_a()).func_177230_c() == Blocks.field_150407_cf) {
                        world.func_175656_a(pos.func_177984_a(), ModBlocks.tainted_pearcel.func_176223_P());
                        world.func_72838_d(horse);
                        player.func_146105_b(new ChatComponentTranslation(EnumChatFormatting.GOLD + StatCollector.func_74838_a("summoner.mob_summon.horse") + " " + StatCollector.func_74838_a("summoner.summoned")));
                    }
                    //Iron Golem
                    else if (world.func_180495_p(pos.func_177984_a()).func_177230_c() == Blocks.field_150339_S) {
                        world.func_175656_a(pos.func_177984_a(), ModBlocks.tainted_pearcel.func_176223_P());
                        world.func_72838_d(iron_golem);
                        player.func_146105_b(new ChatComponentTranslation(EnumChatFormatting.GOLD + StatCollector.func_74838_a("summoner.mob_summon.iron_golem") + " " + StatCollector.func_74838_a("summoner.summoned")));
                    }
                    //Villager
                    else if (world.func_180495_p(pos.func_177984_a()).func_177230_c() == Blocks.field_150475_bE) {
                        world.func_175656_a(pos.func_177984_a(), ModBlocks.tainted_pearcel.func_176223_P());
                        world.func_72838_d(villager);
                        player.func_146105_b(new ChatComponentTranslation(EnumChatFormatting.GOLD + StatCollector.func_74838_a("summoner.mob_summon.villager") + " " + StatCollector.func_74838_a("summoner.summoned")));
                    }else {
                        if (!world.field_72995_K) {
                            world.func_175656_a(pos.func_177984_a(), ModBlocks.tainted_pearcel.func_176223_P());
                            player.func_146105_b(new ChatComponentTranslation(EnumChatFormatting.DARK_RED + StatCollector.func_74838_a("summoner.error.incorrectBlock")));
                        }
                        if (world.field_72995_K) {
                            world.func_72838_d(new EntityLightningBolt(world, player.field_70165_t, player.field_70163_u, player.field_70161_v));
                        }
                    }
                }
                player.func_85030_a("random.explode", 1.0F, 0.5F);
                world.func_175688_a(EnumParticleTypes.EXPLOSION_HUGE, x, y, z, 1.0D, 0.0D, 0.0D);
                player.func_70694_bm().func_77972_a(1, player);
            } else {
                if (!world.field_72995_K) {
                    player.func_146105_b(new ChatComponentTranslation(EnumChatFormatting.DARK_RED + StatCollector.func_74838_a("summoner.error.incorrectItem")));
                }
            }
        }
        return true;
    }

}
