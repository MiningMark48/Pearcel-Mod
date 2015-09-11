package com.miningmark48.pearcelmod.block;

import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.mob.EntityPearcelMob;
import com.miningmark48.pearcelmod.mob.EntityPearcelSquid;
import com.miningmark48.pearcelmod.mob.EntityPearson;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class BlockSummoner extends BlockPearcelMod{

    public BlockSummoner(){
        super();
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {

        EntityPearcelMob pearcelmob = new EntityPearcelMob(world);
        pearcelmob.setPosition(x, y+1, z);
        EntityPearson pearson = new EntityPearson(world);
        pearson.setPosition(x, y+1, z);
        EntityPearcelSquid pearcelsquid = new EntityPearcelSquid(world);
        pearcelsquid.setPosition(x, y+1, z);
        EntityDragon dragon = new EntityDragon(world);
        dragon.setPosition(x, y+1, z);

        if(!player.isSneaking()){
            if (!world.isRemote) {
                //Pearcel Mob
                if (world.getBlock(x, y + 1, z) == ModBlocks.pearcelBlock) {
                    world.setBlock(x, y + 1, z, Blocks.air);
                    world.spawnEntityInWorld(pearcelmob);
                }
                //Pearson
                else if (world.getBlock(x, y + 1, z) == ModBlocks.meBlock) {
                    world.setBlock(x, y + 1, z, Blocks.air);
                    world.spawnEntityInWorld(pearson);
                }
                //Pearcel Squid
                else if (world.getBlock(x, y + 1, z) == Blocks.lapis_block) {
                    world.setBlock(x, y + 1, z, Blocks.air);
                    world.spawnEntityInWorld(pearcelsquid);
                }
                //Enderdragon
                else if (world.getBlock(x, y+1, z) == Blocks.obsidian && world.getBlock(x+2, y, z+2) == Blocks.obsidian && world.getBlock(x-2, y, z-2) == Blocks.obsidian && world.getBlock(x+2, y, z-2) == Blocks.obsidian && world.getBlock(x-2, y, z+2) == Blocks.obsidian){
                    world.setBlock(x, y + 1, z, Blocks.air);
                    world.spawnEntityInWorld(dragon);
                    world.spawnEntityInWorld(new EntityLightningBolt(world, x, y, z));
                }else{
                    if (!world.isRemote){
                        player.addChatComponentMessage(new ChatComponentTranslation(EnumChatFormatting.DARK_RED + "Incorrect Summoner Block"));
                        world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX, player.posY, player.posZ));
                    }
                }
            }
            player.playSound("random.explode", 1.0F, 0.5F);
            world.spawnParticle("hugeexplosion", x, y, z, 1.0D, 0.0D, 0.0D);
        }

        return true;
    }

}
