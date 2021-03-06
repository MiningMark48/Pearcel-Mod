package com.miningmark48.pearcelmod.item;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import com.miningmark48.mininglib.utility.KeyChecker;
import com.miningmark48.mininglib.utility.ModTranslate;
import com.miningmark48.pearcelmod.inventory.InventoryCharmBag;
import com.miningmark48.pearcelmod.reference.GUIs;
import com.miningmark48.pearcelmod.reference.Reference;
import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
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

import javax.annotation.Nullable;
import java.util.List;

public class ItemCharmBag extends ItemPearcelMod implements IBauble{

    public ItemCharmBag(){
        setMaxStackSize(1);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World playerIn, List<String> list, ITooltipFlag advanced) {
        if (KeyChecker.isHoldingShift()) {
            list.add(ModTranslate.toLocal("tooltip.item.charm_bag.line1"));
        }else{
            list.add(ModTranslate.toLocal("tooltip.item.hold") + " " + TextFormatting.AQUA + TextFormatting.ITALIC + ModTranslate.toLocal("tooltip.item.shift"));
        }

    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 1;
    }

    @Override
    public ActionResult onItemRightClick(World world, EntityPlayer player, EnumHand hand){
        ItemStack stack = player.getHeldItem(hand);
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
                ItemStack charmStack = new ItemStack(item);

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
                    player.sendMessage(new TextComponentString(ChatFormatting.RED + ModTranslate.toLocal("chat.item.charmed_pearcel.deactivated")));
                    stack.getTagCompound().setBoolean("active", false);
                } else {
                    player.sendMessage(new TextComponentString(ChatFormatting.GREEN + ModTranslate.toLocal("chat.item.charmed_pearcel.activated")));
                    stack.getTagCompound().setBoolean("active", true);
                }
            }
        }

        return new ActionResult(EnumActionResult.SUCCESS, stack);

    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        doUpdate(stack, entityIn);
    }

    private static void doUpdate(ItemStack stack, Entity entityIn){
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
                    if (new ItemStack(item).getTagCompound().getBoolean("active")) {
                        ItemCharmedPearcel.doEffects(player, new ItemStack(item));
                    }
                }

            }


        }
    }

    //Baubles

    @Override
    public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
        if (player instanceof EntityPlayer) {
            doUpdate(itemstack, player);
        }
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemstack) {
        return BaubleType.BODY;
    }


}
