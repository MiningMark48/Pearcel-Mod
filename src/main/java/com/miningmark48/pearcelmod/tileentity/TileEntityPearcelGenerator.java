package com.miningmark48.pearcelmod.tileentity;

import cofh.redstoneflux.api.IEnergyProvider;
import com.miningmark48.pearcelmod.handler.IGeneratorFuelHandler;
import com.miningmark48.pearcelmod.init.GeneratorRegistry;
import com.miningmark48.pearcelmod.init.ModBlocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.energy.*;

import javax.annotation.Nullable;

public class TileEntityPearcelGenerator extends TileEntity implements IInventory, IEnergyStorage, ITickable, IEnergyProvider {

    private int increase_per_tick;

    private int maxRF = 250000;
    private int current_RF;
    private int cooldown;
    private int maxExtract = 10000;

    //public ItemStack[] inventory;
    public NonNullList<ItemStack> inventory;
    private String customName;

    public TileEntityPearcelGenerator(){
        this.inventory = NonNullList.withSize(1, ItemStack.EMPTY);
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
    public int getSizeInventory() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack itemstack : this.inventory)
        {
            if (!itemstack.isEmpty())
            {
                return false;
            }
        }

        return true;
    }

    @Nullable
    @Override
    public ItemStack getStackInSlot(int index) {
        if (index < 0 || index >= this.getSizeInventory()){
            return ItemStack.EMPTY;
        }
        return this.inventory.get(index);

    }

    @Nullable
    @Override
    public ItemStack decrStackSize(int index, int count) {
        if (this.getStackInSlot(index) != ItemStack.EMPTY){
            ItemStack itemStack;

            if (this.getStackInSlot(index).getCount() <= count){
                itemStack = this.getStackInSlot(index);
                this.setInventorySlotContents(index, ItemStack.EMPTY);
                this.markDirty();
                return itemStack;
            }else{
                itemStack = this.getStackInSlot(index).splitStack(count);

                if (this.getStackInSlot(index).getCount() <= 0){
                    this.setInventorySlotContents(index, ItemStack.EMPTY);
                }else{
                    this.setInventorySlotContents(index, this.getStackInSlot(index));
                }

                this.markDirty();
                return itemStack;

            }
        }else{
            return ItemStack.EMPTY;
        }
    }

    @Nullable
    @Override
    public ItemStack removeStackFromSlot(int index) {
        ItemStack stack = this.getStackInSlot(index);
        this.setInventorySlotContents(index, ItemStack.EMPTY);
        return stack;
    }

    @Override
    public void setInventorySlotContents(int index, @Nullable ItemStack stack) {
        if (index < 0 || index >= this.getSizeInventory()){
            return;
        }

        if (stack != ItemStack.EMPTY && stack.getCount() > this.getInventoryStackLimit()){
            stack.setCount(this.getInventoryStackLimit());
        }

        if (stack != ItemStack.EMPTY && stack.isEmpty()){
            stack = ItemStack.EMPTY;
        }

        this.inventory.set(index, stack);
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
        return stack.getItem() instanceof IGeneratorFuelHandler;
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
                break;
            case 2:
                this.cooldown = value;
            case 3:
                break;
        }
    }

    @Override
    public int getFieldCount() {
        return 4;
    }

    @Override
    public void clear() {
        for (int i = 0; i < this.getSizeInventory(); i++){
            this.setInventorySlotContents(i, ItemStack.EMPTY);
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {

        super.writeToNBT(compound);

        NBTTagList list = new NBTTagList();

        for (int i = 0; i < this.getSizeInventory(); i++){
            if (this.getStackInSlot(i) != ItemStack.EMPTY && this.getStackInSlot(i) != null){
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
            this.setInventorySlotContents(slot, new ItemStack(stackTag));
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

        if(this.world != null) {
            if(canUse()) {
                if(this.cooldown <= 0) {
                    this.cooldown = getCooldownTime(this.inventory.get(0));
                    this.increase_per_tick = getRFPerTick(this.inventory.get(0));

                    this.inventory.get(0).shrink(1);
                    if(this.inventory.get(0).isEmpty()) {
                        this.inventory.set(0, ItemStack.EMPTY);
                    }
                }
            }
            if(this.cooldown > 0) {
                this.cooldown--;
                if(this.current_RF < this.maxRF) {
                    this.current_RF += this.getField(3);
                }
            }

            if (this.getEnergyStored() > 0){
                for (EnumFacing facing : EnumFacing.values()){
                    TileEntity tile = world.getTileEntity(pos.offset(facing));
                    if (tile != null) {
                        if (tile.hasCapability(CapabilityEnergy.ENERGY, facing.getOpposite())) {
                            tile.getCapability(CapabilityEnergy.ENERGY, facing.getOpposite()).receiveEnergy(this.extractEnergy(this.maxExtract, false), false);
                        }
                    }
                }
            }

            this.markDirty();
        }

    }

    private boolean canUse() {
        if(this.inventory.get(0) != ItemStack.EMPTY) {
            if(this.inventory.get(0).getItem() instanceof IGeneratorFuelHandler) {
                if(this.current_RF < this.maxRF) {
                    return true;
                }
            }
            return false;
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

    public static int getCooldownTime(ItemStack stack){
        return GeneratorRegistry.getCooldownTime(stack);
    }

    public static int getRFPerTick(ItemStack stack){
        return GeneratorRegistry.getRFPerTick(stack);
    }

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
        return 0;
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        if (!canExtract()){
            return 0;
        }

        int energyExtracted = Math.min(this.current_RF, Math.min(this.maxExtract, maxExtract));
        if (!simulate){
            this.current_RF -= energyExtracted;
        }

        return energyExtracted;
    }

    @Override
    public int getEnergyStored() {
        if (this.current_RF >= this.getMaxEnergyStored()){
            this.current_RF = this.getMaxEnergyStored();
        }
        return current_RF;
    }

    @Override
    public int getMaxEnergyStored() {
        return maxRF;
    }

    @Override
    public boolean canExtract() {
        return true;
    }

    @Override
    public boolean canReceive() {
        return false;
    }

    //COFH

    @Override
    public int getEnergyStored(EnumFacing from) {
        return this.getEnergyStored();
    }

    @Override
    public int getMaxEnergyStored(EnumFacing from) {
        return this.getMaxEnergyStored();
    }

    @Override
    public boolean canConnectEnergy(EnumFacing from) {
        return true;
    }

    @Override
    public int extractEnergy(EnumFacing from, int maxExtract, boolean simulate) {
        if (!canExtract()){
            return 0;
        }

        int energyExtracted = Math.min(this.current_RF, Math.min(this.maxExtract, maxExtract));
        if (!simulate){
            this.current_RF -= energyExtracted;
        }

        return energyExtracted;
    }

}
