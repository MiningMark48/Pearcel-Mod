package com.miningmark48.pearcelmod.block;

import com.miningmark48.pearcelmod.utility.LogHelper;
import cpw.mods.fml.common.eventhandler.Cancelable;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityEnchantmentTable;
import net.minecraft.world.World;
import net.minecraftforge.common.util.BlockSnapshot;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;

import static net.minecraftforge.common.util.ForgeDirection.*;

public class BlockBarrier extends Block {


    public BlockBarrier(){
        super(Material.iron);
        setStepSound(soundTypeMetal);
    }

}
