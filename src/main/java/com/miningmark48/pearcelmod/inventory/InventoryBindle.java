package com.miningmark48.pearcelmod.inventory;

import com.miningmark48.pearcelmod.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.common.util.Constants;

import javax.annotation.Nullable;

public class InventoryBindle implements IInventory{

    private String name = "Bindle";
    private final ItemStack invItem;
    public static final int INV_SIZE = 9;
    //private ItemStack[] inventory = new ItemStack[INV_SIZE];
    private NonNullList<ItemStack> inventory = NonNullList.withSize(INV_SIZE, ItemStack.EMPTY);

    public InventoryBindle(ItemStack stack){

        invItem = stack;

        if(!stack.hasTagCompound()){
            stack.setTagCompound(new NBTTagCompound());
        }

        readFromNBT(stack.getTagCompound());

    }

    public NonNullList<ItemStack> getInventory(){
        return this.inventory;
    }

    @Override
    public int getSizeInventory() {
        return inventory.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Nullable
    @Override
    public ItemStack getStackInSlot(int index) {
        return (ItemStack) inventory.get(index);
    }

    @Nullable
    @Override
    public ItemStack decrStackSize(int index, int count) {

        ItemStack stack = getStackInSlot(index);
        if(stack != ItemStack.EMPTY){
            if(stack.getCount() > count){
                stack = stack.splitStack(count);
                markDirty();
            }else{
                setInventorySlotContents(index, ItemStack.EMPTY);
            }
        }

        return stack;
    }

    @Nullable
    @Override
    public ItemStack removeStackFromSlot(int index) {
        ItemStack stack = getStackInSlot(index);
        setInventorySlotContents(index, ItemStack.EMPTY);
        return stack;
    }

    @Override
    public void setInventorySlotContents(int index, @Nullable ItemStack stack) {
        inventory.set(index, stack);

        if(stack != ItemStack.EMPTY && stack.getCount() > getInventoryStackLimit()){
            stack.setCount(getInventoryStackLimit());
        }

        markDirty();
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public void markDirty() {
        for(int i = 0; i < getSizeInventory(); i++){
            if(getStackInSlot(i) != ItemStack.EMPTY && getStackInSlot(i).getCount() == 0){
                inventory.set(i, ItemStack.EMPTY);
            }
        }

        writeToNBT(invItem.getTagCompound());
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer player) {
        return true;
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

    public void readFromNBT(NBTTagCompound compound){
        NBTTagList items = compound.getTagList("ItemInventory", Constants.NBT.TAG_COMPOUND);

        for (int i = 0; i < items.tagCount(); i++){
            NBTTagCompound item = (NBTTagCompound) items.getCompoundTagAt(i);
            int slot = item.getInteger("Slot");

            if(slot >= 0 && slot < getSizeInventory()){
                inventory.set(slot, new ItemStack(item));
            }

        }
    }

    public void writeToNBT(NBTTagCompound compound){
        NBTTagList items = new NBTTagList();

        for(int i = 0; i < getSizeInventory(); i++){
            if(getStackInSlot(i) != ItemStack.EMPTY){
                NBTTagCompound item = new NBTTagCompound();
                item.setInteger("Slot", i);
                getStackInSlot(i).writeToNBT(item);
                items.appendTag(item);
            }
        }

        compound.setTag("ItemInventory", items);
    }

    @Override
    public int getField(int id) {
        return 0;
    }

    @Override
    public void setField(int id, int value) {

    }

    @Override
    public int getFieldCount() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean hasCustomName() {
        return false;
    }

    @Override
    public ITextComponent getDisplayName() {
        return null;
    }

}
