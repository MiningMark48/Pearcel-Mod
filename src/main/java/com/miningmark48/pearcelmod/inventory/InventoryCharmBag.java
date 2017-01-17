package com.miningmark48.pearcelmod.inventory;

import com.miningmark48.pearcelmod.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.common.util.Constants;

import javax.annotation.Nullable;

public class InventoryCharmBag implements IInventory{

    private String name = "Bindle";
    private final ItemStack invItem;
    public static final int INV_SIZE = 9;
    private ItemStack[] inventory = new ItemStack[INV_SIZE];

    public InventoryCharmBag(ItemStack stack){

        invItem = stack;

        if(!stack.hasTagCompound()){
            stack.setTagCompound(new NBTTagCompound());
        }

        readFromNBT(stack.getTagCompound());

    }

    @Override
    public int getSizeInventory() {
        return inventory.length;
    }

    @Nullable
    @Override
    public ItemStack getStackInSlot(int index) {
        return inventory[index];
    }

    @Nullable
    @Override
    public ItemStack decrStackSize(int index, int count) {

        ItemStack stack = getStackInSlot(index);
        if(stack != null){
            if(stack.stackSize > count){
                stack = stack.splitStack(count);
                markDirty();
            }else{
                setInventorySlotContents(index, null);
            }
        }

        return stack;
    }

    @Nullable
    @Override
    public ItemStack removeStackFromSlot(int index) {
        ItemStack stack = getStackInSlot(index);
        setInventorySlotContents(index, null);
        return stack;
    }

    @Override
    public void setInventorySlotContents(int index, @Nullable ItemStack stack) {
        inventory[index] = stack;

        if(stack != null && stack.stackSize > getInventoryStackLimit()){
            stack.stackSize = getInventoryStackLimit();
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
            if(getStackInSlot(i) != null && getStackInSlot(i).stackSize == 0){
                inventory[i] = null;
            }
        }

        writeToNBT(invItem.getTagCompound());
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
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
        if (stack.getItem() == ModItems.charmed_pearcel){
            return true;
        }else{
            return false;
        }
    }

    public void readFromNBT(NBTTagCompound compound){
        NBTTagList items = compound.getTagList("ItemInventory", Constants.NBT.TAG_COMPOUND);

        for (int i = 0; i < items.tagCount(); i++){
            NBTTagCompound item = (NBTTagCompound) items.getCompoundTagAt(i);
            int slot = item.getInteger("Slot");

            if(slot >= 0 && slot < getSizeInventory()){
                inventory[slot] = ItemStack.loadItemStackFromNBT(item);
            }

        }
    }

    public void writeToNBT(NBTTagCompound compound){
        NBTTagList items = new NBTTagList();

        for(int i = 0; i < getSizeInventory(); i++){
            if(getStackInSlot(i) != null){
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
