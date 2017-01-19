package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.inventory.InventoryBindle;
import com.miningmark48.pearcelmod.inventory.InventoryCharmBag;
import com.miningmark48.pearcelmod.reference.GUIs;
import com.miningmark48.pearcelmod.reference.Reference;
import com.miningmark48.pearcelmod.utility.KeyCheck;
import com.miningmark48.pearcelmod.utility.Translate;
import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

import java.util.List;

public class ItemCharmBag extends ItemPearcelMod{

    public ItemCharmBag(){
        setMaxStackSize(1);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        if (KeyCheck.isHoldingShift()) {
            list.add(Translate.toLocal("tooltip.item.charm_bag.line1"));
        }else{
            list.add(Translate.toLocal("tooltip.item.hold") + " " + TextFormatting.AQUA + TextFormatting.ITALIC + Translate.toLocal("tooltip.item.shift"));
        }

    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 1;
    }

    @Override
    public ActionResult onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand){
        if (!player.isSneaking()) {
            if (!world.isRemote) {
                if (!player.isSneaking() && hand == EnumHand.MAIN_HAND) {
                    player.openGui(Reference.MOD_ID, GUIs.gui_id_charm_bag, world, 0, 0, 0);
                }
            }
        }else{

            if (!stack.hasTagCompound()) {
                stack.setTagCompound(new NBTTagCompound());
                stack.getTagCompound().setBoolean("active", true);
            }

            NBTTagCompound compound = stack.getTagCompound();

            NBTTagList items = compound.getTagList("ItemInventory", Constants.NBT.TAG_COMPOUND);
            for (int i = 0; i < items.tagCount(); i++) {
                NBTTagCompound item = (NBTTagCompound) items.getCompoundTagAt(i);
                int slot = item.getInteger("Slot");
                ItemStack charmStack = ItemStack.loadItemStackFromNBT(item);

                if (slot >= 0 && slot < InventoryCharmBag.INV_SIZE) {
                    if (!stack.getTagCompound().getBoolean("active")) {
                        charmStack.getTagCompound().setBoolean("active", true);
                    }else{
                        charmStack.getTagCompound().setBoolean("active", false);
                    }
                }
            }

            if (!world.isRemote) {
                if (stack.getTagCompound().getBoolean("active")) {
                    player.addChatComponentMessage(new TextComponentString(ChatFormatting.RED + Translate.toLocal("chat.item.charmed_pearcel.deactivated")));
                    stack.getTagCompound().setBoolean("active", false);
                } else {
                    player.addChatComponentMessage(new TextComponentString(ChatFormatting.GREEN + Translate.toLocal("chat.item.charmed_pearcel.activated")));
                    stack.getTagCompound().setBoolean("active", true);
                }
            }
        }

        return new ActionResult(EnumActionResult.SUCCESS, stack);

    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (entityIn instanceof EntityPlayer){
            EntityPlayer player = (EntityPlayer) entityIn;

            if (!stack.hasTagCompound()){
                stack.setTagCompound(new NBTTagCompound());
            }

            NBTTagCompound compound = stack.getTagCompound();

            NBTTagList items = compound.getTagList("ItemInventory", Constants.NBT.TAG_COMPOUND);
            for (int i = 0; i < items.tagCount(); i++){
                NBTTagCompound item = (NBTTagCompound) items.getCompoundTagAt(i);
                int slot = item.getInteger("Slot");

                if (slot >= 0 && slot < InventoryCharmBag.INV_SIZE){
                    if (ItemStack.loadItemStackFromNBT(item).getTagCompound().getBoolean("active")) {
                        ItemCharmedPearcel.doEffects(player, ItemStack.loadItemStackFromNBT(item));
                    }
                }

            }


        }
    }
}
