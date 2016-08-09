package com.miningmark48.pearcelmod.block;

import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.utility.Translate;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
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
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class BlockSummoner extends BlockPearcelMod{

    private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0.375D, 0.0D, 0.375D, 0.625D, 1.0D, 0.625D);

    public BlockSummoner(){

    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return BOUNDING_BOX;
    }

    @Override
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn) {
        super.addCollisionBoxToList(pos, entityBox, collidingBoxes, BOUNDING_BOX);
    }

    @Override
    public boolean isFullCube(IBlockState state){
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state){
        return false;
    }

    @Override
    public BlockRenderLayer getBlockLayer(){
        return BlockRenderLayer.CUTOUT;
    }

    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ){

        Random rand = new Random();
        int spawnRand = rand.nextInt(5) + 1;
        int negRand = rand.nextInt(2) + 1;
        
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        
        if (negRand == 1) {
            spawnRand = -spawnRand;
        }

        EntitySheep sheep = new EntitySheep(world);
        sheep.setPosition(x + spawnRand, y + 2, z + spawnRand);
        EntityEnderman enderman = new EntityEnderman(world);
        enderman.setPosition(x + spawnRand, y + 2, z + spawnRand);
        EntityBlaze blaze = new EntityBlaze(world);
        blaze.setPosition(x + spawnRand, y + 2, z + spawnRand);
        EntityGhast ghast = new EntityGhast(world);
        ghast.setPosition(x + spawnRand, y + 5, z + spawnRand);
        EntitySkeleton skeleton = new EntitySkeleton(world);
        skeleton.setPosition(x + spawnRand, y + 2, z + spawnRand);
        EntityCreeper creeper = new EntityCreeper(world);
        creeper.setPosition(x + spawnRand, y + 2, z + spawnRand);
        EntityEnderCrystal endcrystal = new EntityEnderCrystal(world);
        endcrystal.setPosition(x + spawnRand, y + 2, z + spawnRand);
        EntityHorse horse = new EntityHorse(world);
        horse.setPosition(x + spawnRand, y + 2, z + spawnRand);
        EntityIronGolem iron_golem = new EntityIronGolem(world);
        iron_golem.setPosition(x + spawnRand, y + 2, z + spawnRand);
        EntityVillager villager = new EntityVillager(world);
        villager.setPosition(x + spawnRand, y + 2, z + spawnRand);

        EntityDragon dragon = new EntityDragon(world);
        dragon.setPosition(x + spawnRand, y + 2, z + spawnRand);
        EntityWither wither = new EntityWither(world);
        wither.setPosition(x + spawnRand, y + 2, z + spawnRand);

        if(player.getHeldItem(EnumHand.MAIN_HAND) != null){
            if (!player.isSneaking() && player.getHeldItem(EnumHand.MAIN_HAND).getItem() == ModItems.sap) {
                if (!world.isRemote) {
                    //Missing Block
                    if (world.getBlockState(pos.up()).getBlock() == Blocks.AIR) {
                        player.addChatComponentMessage(new TextComponentString(TextFormatting.DARK_RED + Translate.toLocal("summoner.error.missingBlock")));
                        if (world.isRemote) {
                            world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX, player.posY, player.posZ, true));
                        }
                    }//Dragon
                    else if (world.getBlockState(pos.up()).getBlock() == Blocks.DRAGON_EGG) {
                        world.setBlockState(pos.up(), ModBlocks.tainted_pearcel.getDefaultState());
                        world.spawnEntityInWorld(dragon);
                        player.addChatComponentMessage(new TextComponentString(TextFormatting.GOLD + Translate.toLocal("summoner.mob_summon.dragon") + " " + Translate.toLocal("summoner.summoned")));
                    }//Wither
                    else if (world.getBlockState(pos.up()).getBlock() == Blocks.SKULL) {
                        world.setBlockState(pos.up(), ModBlocks.tainted_pearcel.getDefaultState());
                        world.spawnEntityInWorld(wither);
                        player.addChatComponentMessage(new TextComponentString(TextFormatting.GOLD + Translate.toLocal("summoner.mob_summon.wither") + " " + Translate.toLocal("summoner.summoned")));
                    }
                    //Sheep
                    else if (world.getBlockState(pos.up()).getBlock() == Blocks.WOOL) {
                        world.setBlockState(pos.up(), ModBlocks.tainted_pearcel.getDefaultState());
                        world.spawnEntityInWorld(sheep);
                        player.addChatComponentMessage(new TextComponentString(TextFormatting.GOLD + Translate.toLocal("summoner.mob_summon.sheep") + " " + Translate.toLocal("summoner.summoned")));
                    }
                    //Enderman
                    else if (world.getBlockState(pos.up()).getBlock() == Blocks.END_STONE) {
                        world.setBlockState(pos.up(), ModBlocks.tainted_pearcel.getDefaultState());
                        world.spawnEntityInWorld(enderman);
                        player.addChatComponentMessage(new TextComponentString(TextFormatting.GOLD + Translate.toLocal("summoner.mob_summon.enderman") + " " + Translate.toLocal("summoner.summoned")));
                    }
                    //Blaze
                    else if (world.getBlockState(pos.up()).getBlock() == Blocks.FIRE) {
                        world.setBlockState(pos.up(), ModBlocks.tainted_pearcel.getDefaultState());
                        world.spawnEntityInWorld(blaze);
                        player.addChatComponentMessage(new TextComponentString(TextFormatting.GOLD + Translate.toLocal("summoner.mob_summon.blaze") + " " + Translate.toLocal("summoner.summoned")));
                    }
                    //Ghast
                    else if (world.getBlockState(pos.up()).getBlock() == Blocks.COBBLESTONE) {
                        world.setBlockState(pos.up(), ModBlocks.tainted_pearcel.getDefaultState());
                        world.spawnEntityInWorld(ghast);
                        player.addChatComponentMessage(new TextComponentString(TextFormatting.GOLD + Translate.toLocal("summoner.mob_summon.ghast") + " " + Translate.toLocal("summoner.summoned")));
                    }
                    //Skeleton
                    else if (world.getBlockState(pos.up()).getBlock() == Blocks.PLANKS) {
                        world.setBlockState(pos.up(), ModBlocks.tainted_pearcel.getDefaultState());
                        world.spawnEntityInWorld(skeleton);
                        player.addChatComponentMessage(new TextComponentString(TextFormatting.GOLD + Translate.toLocal("summoner.mob_summon.skeleton") + " " + Translate.toLocal("summoner.summoned")));
                    }
                    //Creeper
                    else if (world.getBlockState(pos.up()).getBlock() == Blocks.TNT) {
                        world.setBlockState(pos.up(), ModBlocks.tainted_pearcel.getDefaultState());
                        world.spawnEntityInWorld(creeper);
                        player.addChatComponentMessage(new TextComponentString(TextFormatting.GOLD + Translate.toLocal("summoner.mob_summon.creeper") + " " + Translate.toLocal("summoner.summoned")));
                    }
                    //Horse
                    else if (world.getBlockState(pos.up()).getBlock() == Blocks.HAY_BLOCK) {
                        world.setBlockState(pos.up(), ModBlocks.tainted_pearcel.getDefaultState());
                        world.spawnEntityInWorld(horse);
                        player.addChatComponentMessage(new TextComponentString(TextFormatting.GOLD + Translate.toLocal("summoner.mob_summon.horse") + " " + Translate.toLocal("summoner.summoned")));
                    }
                    //Iron Golem
                    else if (world.getBlockState(pos.up()).getBlock() == Blocks.IRON_BLOCK) {
                        world.setBlockState(pos.up(), ModBlocks.tainted_pearcel.getDefaultState());
                        world.spawnEntityInWorld(iron_golem);
                        player.addChatComponentMessage(new TextComponentString(TextFormatting.GOLD + Translate.toLocal("summoner.mob_summon.iron_golem") + " " +Translate.toLocal("summoner.summoned")));
                    }
                    //Villager
                    else if (world.getBlockState(pos.up()).getBlock() == Blocks.EMERALD_BLOCK) {
                        world.setBlockState(pos.up(), ModBlocks.tainted_pearcel.getDefaultState());
                        world.spawnEntityInWorld(villager);
                        player.addChatComponentMessage(new TextComponentString(TextFormatting.GOLD + Translate.toLocal("summoner.mob_summon.villager") + " " + Translate.toLocal("summoner.summoned")));
                    }else {
                        if (!world.isRemote) {
                            world.setBlockState(pos.up(), ModBlocks.tainted_pearcel.getDefaultState());
                            player.addChatComponentMessage(new TextComponentString(TextFormatting.DARK_RED + Translate.toLocal("summoner.error.incorrectBlock")));
                        }
                        if (world.isRemote) {
                            world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX, player.posY, player.posZ, true));
                        }
                    }
                }
                player.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 1.0F, 0.5F);
                world.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, x, y, z, 1.0D, 0.0D, 0.0D);
                if (!player.isCreative()){
                    player.getHeldItem(EnumHand.MAIN_HAND).damageItem(1, player);
                    player.attackEntityFrom(DamageSource.outOfWorld, 10.0F);
                }
            } else {
                if (!world.isRemote) {
                    player.addChatComponentMessage(new TextComponentString(TextFormatting.DARK_RED + Translate.toLocal("summoner.error.incorrectItem")));
                }
            }
        }
        return true;
    }

}
