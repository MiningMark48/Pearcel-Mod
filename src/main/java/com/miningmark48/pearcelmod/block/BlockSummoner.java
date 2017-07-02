package com.miningmark48.pearcelmod.block;

import com.miningmark48.mininglib.utility.ModTranslate;
import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.init.ModSoundEvents;
import net.minecraft.block.Block;
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
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class BlockSummoner extends BlockPearcelMod {

    private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0.375D, 0.0D, 0.375D, 0.625D, 1.0D, 0.625D);

    public BlockSummoner(){

    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return BOUNDING_BOX;
    }

    @Override
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean p_185477_7_) {
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
                        player.sendMessage(new TextComponentString(TextFormatting.DARK_RED + ModTranslate.toLocal("summoner.error.missingBlock")));
                        if (world.isRemote) {
                            world.spawnEntity(new EntityLightningBolt(world, player.posX, player.posY, player.posZ, true));
                        }
                    }//Dragon
                    else if (isCorrectSetup(pos, world, Blocks.DRAGON_EGG, Blocks.DIAMOND_BLOCK)) {
                        if(player.dimension == 1) {
                            setTainted(pos, world);
                            world.spawnEntity(dragon);
                            player.sendMessage(new TextComponentString(TextFormatting.GOLD + ModTranslate.toLocal("summoner.mob_summon.dragon") + " " + ModTranslate.toLocal("summoner.summoned")));
                        }else{
                            player.sendMessage(new TextComponentString(TextFormatting.DARK_RED + ModTranslate.toLocal("summoner.error.wrongDimension")));
                        }
                    }//Wither
                    else if (isCorrectSetup(pos, world, Blocks.SKULL, Blocks.DIAMOND_BLOCK)) {
                        setTainted(pos, world);
                        world.spawnEntity(wither);
                        player.sendMessage(new TextComponentString(TextFormatting.GOLD + ModTranslate.toLocal("summoner.mob_summon.wither") + " " + ModTranslate.toLocal("summoner.summoned")));
                    }
                    //Sheep
                    else if (isCorrectSetup(pos, world, Blocks.WOOL, Blocks.WOOL)) {
                        setTainted(pos, world);
                        world.spawnEntity(sheep);
                        player.sendMessage(new TextComponentString(TextFormatting.GOLD + ModTranslate.toLocal("summoner.mob_summon.sheep") + " " + ModTranslate.toLocal("summoner.summoned")));
                    }
                    //Enderman
                    else if (isCorrectSetup(pos, world, Blocks.END_STONE, Blocks.END_STONE)) {
                        setTainted(pos, world);
                        world.spawnEntity(enderman);
                        player.sendMessage(new TextComponentString(TextFormatting.GOLD + ModTranslate.toLocal("summoner.mob_summon.enderman") + " " + ModTranslate.toLocal("summoner.summoned")));
                    }
                    //Blaze
                    else if (isCorrectSetup(pos, world, Blocks.GRAVEL, Blocks.NETHERRACK)) {
                        setTainted(pos, world);
                        world.spawnEntity(blaze);
                        player.sendMessage(new TextComponentString(TextFormatting.GOLD + ModTranslate.toLocal("summoner.mob_summon.blaze") + " " + ModTranslate.toLocal("summoner.summoned")));
                    }
                    //Ghast
                    else if (isCorrectSetup(pos, world, Blocks.COBBLESTONE, Blocks.SOUL_SAND)) {
                        setTainted(pos, world);
                        world.spawnEntity(ghast);
                        player.sendMessage(new TextComponentString(TextFormatting.GOLD + ModTranslate.toLocal("summoner.mob_summon.ghast") + " " + ModTranslate.toLocal("summoner.summoned")));
                    }
                    //Skeleton
                    else if (isCorrectSetup(pos, world, Blocks.PLANKS, Blocks.SAND)) {
                        setTainted(pos, world);
                        world.spawnEntity(skeleton);
                        player.sendMessage(new TextComponentString(TextFormatting.GOLD + ModTranslate.toLocal("summoner.mob_summon.skeleton") + " " + ModTranslate.toLocal("summoner.summoned")));
                    }
                    //Creeper
                    else if (isCorrectSetup(pos, world, Blocks.TNT, Blocks.TNT)) {
                        setTainted(pos, world);
                        world.spawnEntity(creeper);
                        player.sendMessage(new TextComponentString(TextFormatting.GOLD + ModTranslate.toLocal("summoner.mob_summon.creeper") + " " + ModTranslate.toLocal("summoner.summoned")));
                    }
                    //Horse
                    else if (isCorrectSetup(pos, world, Blocks.HAY_BLOCK, Blocks.HAY_BLOCK)) {
                        setTainted(pos, world);
                        world.spawnEntity(horse);
                        player.sendMessage(new TextComponentString(TextFormatting.GOLD + ModTranslate.toLocal("summoner.mob_summon.horse") + " " + ModTranslate.toLocal("summoner.summoned")));
                    }
                    //Iron Golem
                    else if (isCorrectSetup(pos, world, Blocks.IRON_BLOCK, Blocks.IRON_BLOCK)) {
                        setTainted(pos, world);
                        world.spawnEntity(iron_golem);
                        player.sendMessage(new TextComponentString(TextFormatting.GOLD + ModTranslate.toLocal("summoner.mob_summon.iron_golem") + " " +ModTranslate.toLocal("summoner.summoned")));
                    }
                    //Villager
                    else if (isCorrectSetup(pos, world, Blocks.EMERALD_BLOCK, Blocks.SKULL)) {
                        setTainted(pos, world);
                        world.spawnEntity(villager);
                        player.sendMessage(new TextComponentString(TextFormatting.GOLD + ModTranslate.toLocal("summoner.mob_summon.villager") + " " + ModTranslate.toLocal("summoner.summoned")));
                    }else {
                        if (!world.isRemote) {
                            setTainted(pos, world);
                            player.sendMessage(new TextComponentString(TextFormatting.DARK_RED + ModTranslate.toLocal("summoner.error.incorrectBlock")));
                        }
                        if (world.isRemote) {
                            world.spawnEntity(new EntityLightningBolt(world, player.posX, player.posY, player.posZ, true));
                        }
                    }
                }
                player.playSound(ModSoundEvents.BLOCK_SUMMONER_LAUGH, 5.0F, 1.0F);
                world.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, x, y, z, 1.0D, 0.0D, 0.0D);
                if (!player.isCreative()){
                    player.getHeldItem(EnumHand.MAIN_HAND).damageItem(1, player);
                    player.attackEntityFrom(DamageSource.OUT_OF_WORLD, 10.0F);
                }

            } else {
                if (!world.isRemote) {
                    player.sendMessage(new TextComponentString(TextFormatting.DARK_RED + ModTranslate.toLocal("summoner.error.incorrectItem")));
                }
            }
        }
        return true;
    }

    private static boolean isCorrectSetup(BlockPos basePos, World world, Block block1, Block block2){

        if(world.getBlockState(basePos).getBlock() == ModBlocks.summoner){
            if(world.getBlockState(basePos.up()).getBlock() == block1){
                if(world.getBlockState(basePos.add(3, 0, 0)).getBlock() == ModBlocks.pedestal && world.getBlockState(basePos.add(3, 1, 0)).getBlock() == block2){
                    if(world.getBlockState(basePos.add(-3, 0, 0)).getBlock() == ModBlocks.pedestal && world.getBlockState(basePos.add(-3, 1, 0)).getBlock() == block2){
                        if(world.getBlockState(basePos.add(0, 0, 3)).getBlock() == ModBlocks.pedestal && world.getBlockState(basePos.add(0, 1, 3)).getBlock() == block2){
                            if(world.getBlockState(basePos.add(0, 0, -3)).getBlock() == ModBlocks.pedestal && world.getBlockState(basePos.add(0, 1, -3)).getBlock() == block2){
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private static void setTainted(BlockPos basePos, World world){
        world.setBlockState(basePos.up(1), ModBlocks.tainted_pearcel.getDefaultState());
        world.setBlockState(basePos.add(3, 1, 0), ModBlocks.tainted_pearcel.getDefaultState());
        world.setBlockState(basePos.add(-3, 1, 0), ModBlocks.tainted_pearcel.getDefaultState());
        world.setBlockState(basePos.add(0, 1, 3), ModBlocks.tainted_pearcel.getDefaultState());
        world.setBlockState(basePos.add(0, 1, -3), ModBlocks.tainted_pearcel.getDefaultState());
    }

}
