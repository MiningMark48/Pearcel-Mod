package com.miningmark48.pearcelmod.event;

import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Arrays;

public class EventOnBreakMF {

    public static Block[] special = new Block[]{Blocks.GOLD_ORE, Blocks.COAL_ORE, Blocks.DIAMOND_ORE, Blocks.IRON_ORE, Blocks.REDSTONE_ORE, Blocks.EMERALD_ORE, Blocks.QUARTZ_ORE, Blocks.LAPIS_ORE, ModBlocks.pearcel_matter_block};
    public static Block[] trash = new Block[]{Blocks.NETHERRACK, Blocks.SANDSTONE, Blocks.SAND, Blocks.SANDSTONE_STAIRS, Blocks.GLASS, Blocks.DIRT, Blocks.COBBLESTONE, Blocks.STONE, Blocks.GRAVEL, Blocks.PLANKS, Blocks.LOG, ModBlocks.pearcel_stone};

    @SubscribeEvent
    public void onBreak(BlockEvent.HarvestDropsEvent e) {

        if (e.getHarvester() instanceof EntityPlayer) {

            Block block = e.getState().getBlock();
            EntityPlayer player = e.getHarvester();
            ItemStack helditem = player.getHeldItemMainhand();

            if (helditem != null) {
                if (helditem.getItem() == ModItems.matter_fabricator) {
                    if (!helditem.hasTagCompound()) {
                        helditem.setTagCompound(new NBTTagCompound());
                        helditem.getTagCompound().setInteger("mode", 1);
                        helditem.getTagCompound().setInteger("mp", 0);
                    }

                    if (helditem.getTagCompound().getInteger("mode") == 1) {
                        if (Arrays.asList(trash).contains(block)) {
                            e.getDrops().clear();
                            helditem.getTagCompound().setInteger("mp", helditem.getTagCompound().getInteger("mp") + 1);
                        }
                    } else {
                        if (Arrays.asList(special).contains(block)) {
                            helditem.getTagCompound().setInteger("mp", helditem.getTagCompound().getInteger("mp") + 8);
                        } else {
                            helditem.getTagCompound().setInteger("mp", helditem.getTagCompound().getInteger("mp") + 1);
                        }
                        e.getDrops().clear();
                    }

                    if (helditem.getTagCompound().getInteger("mp") >= ConfigurationHandler.matterFabricatorMPAmount) {
                        player.inventory.addItemStackToInventory(new ItemStack(ModItems.neutral_pearcel_matter));
                        helditem.getTagCompound().setInteger("mp", 0);
                    }

                }
            }
        }
    }

}
