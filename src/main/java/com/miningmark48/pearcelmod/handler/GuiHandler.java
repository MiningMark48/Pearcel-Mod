package com.miningmark48.pearcelmod.handler;

import com.miningmark48.pearcelmod.container.*;
import com.miningmark48.pearcelmod.gui.*;
import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.init.ModTileEntities;
import com.miningmark48.pearcelmod.inventory.InventoryBindle;
import com.miningmark48.pearcelmod.inventory.InventoryCharmBag;
import com.miningmark48.pearcelmod.inventory.InventoryEnlargedPearcelBackpack;
import com.miningmark48.pearcelmod.inventory.InventoryPearcelBackpack;
import com.miningmark48.pearcelmod.reference.GUIs;
import com.miningmark48.pearcelmod.tileentity.TileEntityPearcelFurnace;
import com.miningmark48.pearcelmod.tileentity.TileEntityPearcelGenerator;
import com.miningmark48.pearcelmod.tileentity.TileEntityPearcelStorageCrate;
import com.miningmark48.pearcelmod.tileentity.TileEntityPearcelWorkbench;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        if (ID == GUIs.gui_id_pearcel_workbench){
            return ID == GUIs.gui_id_pearcel_workbench && world.getBlockState(new BlockPos(x, y, z)).getBlock() == ModBlocks.pearcel_workbench ? new ContainerPearcelWorkbench(player.inventory, world, x, y, z, (TileEntityPearcelWorkbench) world.getTileEntity(pos)) : null;
        }
        if (ID == GUIs.gui_id_pcp){
            return new ContainerPCP(player.inventory, world, x, y, z);
        }
        if (ID == GUIs.gui_id_pearcel_backpack){
            return new ContainerPearcelBackpack(player, player.inventory, new InventoryPearcelBackpack(player.getHeldItem(EnumHand.MAIN_HAND)));
        }
        if (ID == GUIs.gui_id_enlarged_pearcel_backpack){
            return new ContainerEnlargedPearcelBackpack(player, player.inventory, new InventoryEnlargedPearcelBackpack(player.getHeldItem(EnumHand.MAIN_HAND)));
        }
        if (ID == GUIs.gui_id_bindle){
            return new ContainerBindle(player, player.inventory, new InventoryBindle(player.getHeldItem(EnumHand.MAIN_HAND)));
        }
        if (ID == GUIs.gui_id_pearcel_storage_crate){
            return new ContainerPearcelStorageCrate(player.inventory, (TileEntityPearcelStorageCrate) world.getTileEntity(pos), player);
        }
        if (ID == GUIs.gui_id_charm_bag){
            return new ContainerCharmBag(player, player.inventory, new InventoryCharmBag(player.getHeldItem(EnumHand.MAIN_HAND)));
        }
        if (ID == GUIs.gui_id_pearcel_furnace){
            return new ContainerPearcelFurnace(player.inventory, (TileEntityPearcelFurnace) world.getTileEntity(pos));
        }
        if (ID == GUIs.gui_id_pearcel_generator){
            return new ContainerPearcelGenerator(player.inventory, (TileEntityPearcelGenerator) world.getTileEntity(pos));
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        if (ID == GUIs.gui_id_pearcel_workbench){
            return ID == GUIs.gui_id_pearcel_workbench && world.getBlockState(new BlockPos(x, y, z)).getBlock() == ModBlocks.pearcel_workbench ? new GuiPearcelWorkbench(player.inventory, world, x, y, z, (TileEntityPearcelWorkbench) world.getTileEntity(pos)) : null;
        }
        if (ID == GUIs.gui_id_pcp){
            return new GuiPCP(player.inventory, world, x, y, z);
        }
        if (ID == GUIs.gui_id_pearcel_backpack){
            return new GuiPearcelBackpack((ContainerPearcelBackpack) new ContainerPearcelBackpack(player, player.inventory, new InventoryPearcelBackpack(player.getHeldItem(EnumHand.MAIN_HAND))));
        }
        if (ID == GUIs.gui_id_enlarged_pearcel_backpack){
            return new GuiEnlargedPearcelBackpack((ContainerEnlargedPearcelBackpack) new ContainerEnlargedPearcelBackpack(player, player.inventory, new InventoryEnlargedPearcelBackpack(player.getHeldItem(EnumHand.MAIN_HAND))));
        }
        if (ID == GUIs.gui_id_bindle){
            return new GuiBindle((ContainerBindle) new ContainerBindle(player, player.inventory, new InventoryBindle(player.getHeldItem(EnumHand.MAIN_HAND))));
        }
        if (ID == GUIs.gui_id_pearcel_storage_crate){
            return new GuiPearcelStorageCrate(player.inventory, (TileEntityPearcelStorageCrate) world.getTileEntity(pos), player);
        }
        if (ID == GUIs.gui_id_charm_bag){
            return new GuiCharmBag((ContainerCharmBag) new ContainerCharmBag(player, player.inventory, new InventoryCharmBag(player.getHeldItem(EnumHand.MAIN_HAND))));
        }
        if (ID == GUIs.gui_id_pearcel_furnace){
            return new GuiPearcelFurnace(player.inventory, (TileEntityPearcelFurnace) world.getTileEntity(pos));
        }
        if (ID == GUIs.gui_id_pearcel_generator){
            return new GuiPearcelGenerator(player.inventory, (TileEntityPearcelGenerator) world.getTileEntity(pos));
        }
        return null;
    }

}
