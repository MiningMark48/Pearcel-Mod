package com.miningmark48.pearcelmod.tileentity;

import com.miningmark48.pearcelmod.init.ModBlocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;

import javax.annotation.Nullable;

public class TileEntityPearcelStorageCrate extends TileEntity implements IInventory{

    private ItemStack[] inventory;
    private String custom_name;

    public static int INV_SIZE = 36;

    public TileEntityPearcelStorageCrate(){
        this.inventory = new ItemStack[this.getSizeInventory()];
    }

    public void setCustomName(String custom_name){
        this.custom_name = custom_name;
    }

    @Override
    public String getName(){
        return this.hasCustomName() ? this.custom_name : "tile.pearcel_storage_crate";
    }

    @Override
    public boolean hasCustomName(){
        return this.custom_name != null && !this.custom_name.equals("");
    }

    @Nullable
    @Override
    public ITextComponent getDisplayName() {
        return new TextComponentString(ModBlocks.pearcel_storage_crate.getLocalizedName());
    }

    @Override
    public int getSizeInventory(){
        return INV_SIZE;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        if (index < 0 || index >= this.getSizeInventory()){
            return null;
        }
        return this.inventory[index];
    }

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
                }

                this.markDirty();
                return itemStack;
            }
        }else {
            return null;
        }
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        ItemStack stack = getStackInSlot(index);
        setInventorySlotContents(index, null);
        return stack;
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack){
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
    public boolean isUseableByPlayer(EntityPlayer player){
        return this.worldObj.getTileEntity(this.getPos()) == this && player.getDistanceSq(this.pos.add(0.5, 0.5, 0.5)) <= 64;
    }

    @Override
    public void openInventory(EntityPlayer player) {

    }

    @Override
    public void closeInventory(EntityPlayer player) {

    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return true;
    }

    @Override
    public int getField(int id) {
        return 0;
    }

    @Override
    public void setField(int id, int value){

    }

    @Override
    public int getFieldCount(){
        return 0;
    }

    @Override
    public void clear(){
        for (int i = 0; i < this.getSizeInventory(); i++){
            this.setInventorySlotContents(i, null);
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt){
        super.writeToNBT(nbt);

        NBTTagList list = new NBTTagList();
        for (int i = 0; i < this.getSizeInventory(); i++){
            if (this.getStackInSlot(i) != null){
                NBTTagCompound stackTag = new NBTTagCompound();
                stackTag.setByte("Slot", (byte) i);
                this.getStackInSlot(i).writeToNBT(stackTag);
                list.appendTag(stackTag);
            }
        }

        nbt.setTag("Items", list);

        if (this.hasCustomName()){
            nbt.setString("CustomName", this.getDisplayName().toString());
        }

        return nbt;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);

        NBTTagList list = nbt.getTagList("Items", 10);
        for (int i = 0; i < list.tagCount(); i++) {
            NBTTagCompound stackTag = list.getCompoundTagAt(i);
            int slot = stackTag.getByte("Slot") & 255;
            this.setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(stackTag));
        }

        if (nbt.hasKey("CustomName", 8)) {
            this.setCustomName(nbt.getString("CustomName"));
        }

    }

}
