package com.miningmark48.pearcelmod.tileentity;

import cofh.api.energy.IEnergyProvider;
import com.miningmark48.pearcelmod.init.ModBlocks;
import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.utility.LogHelper;
import com.miningmark48.pearcelmod.utility.Translate;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import sun.rmi.runtime.Log;

import javax.annotation.Nullable;

public class TileEntityPearcelGenerator extends TileEntity implements IInventory, IEnergyProvider, ITickable{

    private int increase_per_tick = 20;

    private int maxRF = 100000;
    private int current_RF;
    private int cooldown;

    private ItemStack[] inventory;
    private String customName;

    public TileEntityPearcelGenerator(){
        this.inventory = new ItemStack[this.getSizeInventory()];
    }

    public String getCustomName(){
        return customName;
    }

    public void setCustomName(String customName){
        this.customName = customName;
    }

    @Nullable
    @Override
    public ITextComponent getDisplayName() {
        return this.hasCustomName() ? new TextComponentString(this.customName) : new TextComponentString(ModBlocks.pearcel_generator.getLocalizedName());
    }

    @Override
    public int extractEnergy(EnumFacing from, int maxExtract, boolean simulate) {
        current_RF -= maxExtract;
        return maxExtract;
    }

    @Override
    public int getEnergyStored(EnumFacing from) {
        return this.current_RF;
    }

    @Override
    public int getMaxEnergyStored(EnumFacing from) {
        return this.maxRF;
    }

    @Override
    public boolean canConnectEnergy(EnumFacing from) {
        return true;
    }

    @Override
    public int getSizeInventory() {
        return 1;
    }

    @Nullable
    @Override
    public ItemStack getStackInSlot(int index) {
        if (index < 0 || index >= this.getSizeInventory()){
            return null;
        }
        return this.inventory[index];

    }

    @Nullable
    @Override
    public ItemStack decrStackSize(int index, int count) {
        if (this.getStackInSlot(index) != null){
            ItemStack itemStack;

            if (this.getStackInSlot(index).stackSize <= count){
                itemStack = this.getStackInSlot(index);
                this.setInventorySlotContents(index, null);
                this.markDirty();
                return itemStack;
            }else{
                itemStack = this.getStackInSlot(index).splitStack(count);

                if (this.getStackInSlot(index).stackSize <= 0){
                    this.setInventorySlotContents(index, null);
                }else{
                    this.setInventorySlotContents(index, this.getStackInSlot(index));
                }

                this.markDirty();
                return itemStack;

            }
        }else{
            return null;
        }
    }

    @Nullable
    @Override
    public ItemStack removeStackFromSlot(int index) {
        ItemStack stack = this.getStackInSlot(index);
        this.setInventorySlotContents(index, null);
        return stack;
    }

    @Override
    public void setInventorySlotContents(int index, @Nullable ItemStack stack) {
        if (index < 0 || index >= this.getSizeInventory()){
            return;
        }

        if (stack != null && stack.stackSize > this.getInventoryStackLimit()){
            stack.stackSize = this.getInventoryStackLimit();
        }

        if (stack != null && stack.stackSize == 0){
            stack = null;
        }

        this.inventory[index] = stack;
        this.markDirty();

    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer player) {
        return this.world.getTileEntity(this.getPos()) == this && player.getDistanceSq(this.pos.add(0.5, 0.5, 0.5)) <= 64;
    }

    @Override
    public void openInventory(EntityPlayer player) {

    }

    @Override
    public void closeInventory(EntityPlayer player) {

    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return stack.getItem() == ModItems.pearcel_item || this.current_RF < this.maxRF;
    }

    @Override
    public int getField(int id) {
        switch (id){
            case 0:
                return this.current_RF;
            case 1:
                return this.maxRF;
            case 2:
                return this.cooldown;
            case 3:
                return this.increase_per_tick;
        }
        return 0;
    }

    @Override
    public void setField(int id, int value) {
        switch(id) {
            case 0:
                this.current_RF = value;
            case 1:
                this.maxRF = value;
            case 2:
                this.cooldown = value;
            case 3:
                this.increase_per_tick = value;
        }
    }

    @Override
    public int getFieldCount() {
        return 4;
    }

    @Override
    public void clear() {
        for (int i = 0; i < this.getSizeInventory(); i++){
            this.setInventorySlotContents(i, null);
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {

        super.writeToNBT(compound);

        NBTTagList list = new NBTTagList();

        for (int i = 0; i < this.getSizeInventory(); i++){
            if (this.getStackInSlot(i) != null){
                NBTTagCompound stackTag = new NBTTagCompound();
                stackTag.setByte("Slot", (byte) i);
                this.getStackInSlot(i).writeToNBT(stackTag);
                list.appendTag(stackTag);
            }
        }

        compound.setTag("Items", list);
        compound.setInteger("currentRF", this.current_RF);
        compound.setInteger("cooldown", this.cooldown);
        compound.setInteger("ipt", this.increase_per_tick);

        if (this.hasCustomName()){
            compound.setString("CustomName", this.getCustomName());
        }

        return compound;

    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        NBTTagList list = compound.getTagList("Items", 10);
        for (int i = 0; i < list.tagCount(); i++) {
            NBTTagCompound stackTag = list.getCompoundTagAt(i);
            int slot = stackTag.getByte("Slot") & 255;
            this.setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(stackTag));
        }
        this.current_RF = compound.getInteger("currentRF");
        this.cooldown = compound.getInteger("cooldown");
        this.increase_per_tick = compound.getInteger("ipt");

        if (compound.hasKey("CustomName", 8)) {
            this.setCustomName(compound.getString("CustomName"));
        }
    }

    @Override
    public void update() {

        if(this.world != null) { //changed this
            if(canUse()) {
                if(this.cooldown <= 0) {
                    if(this.inventory[0].getItem() == ModItems.pearcel_item) {
                        this.cooldown = 70;
                        this.increase_per_tick = 200;
                    } else {
                        this.cooldown = 600;
                        this.increase_per_tick = 50;
                    }
                    this.inventory[0].stackSize -= 1;
                    if(this.inventory[0].stackSize == 0) {
                        this.inventory[0] = null;
                    }
                }
            }
            if(this.cooldown > 0) {
                this.cooldown--;
                if(this.current_RF < this.maxRF) {
                    this.current_RF += this.increase_per_tick;
                    LogHelper.info("Current RF: " + this.current_RF);
                }
            }
            this.markDirty();
        }

    }

    private boolean canUse() {
        if(this.inventory[0] == null) {
            return false;
        }
        else {
            if(this.inventory[0].getItem() == ModItems.pearcel_item) {
                if(this.current_RF < this.maxRF) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String getName() {
        return customName;
    }

    @Override
    public boolean hasCustomName() {
        return this.customName != null && !this.customName.equals("");
    }

    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        NBTTagCompound compound = new NBTTagCompound();
        this.writeToNBT(compound);
        return new SPacketUpdateTileEntity(this.getPos(), 1, compound);
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
        this.readFromNBT(pkt.getNbtCompound());
    }




}
