package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.utility.Translate;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ItemTPPearcel extends ItemPearcelMod{

    double tpX = 0;
    double tpY = 0;
    double tpZ = 0;
    int dim = 0;

    public ItemTPPearcel(){
        setMaxStackSize(1);
        setMaxDamage(128);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {

        list.add(Translate.toLocal("tooltip.item.tpPearcel.line1"));
        list.add("");

        if (stack.hasTagCompound()) {
            if (stack.getTagCompound().getDouble("tpX") == 0D && stack.getTagCompound().getDouble("tpY") == 0D && stack.getTagCompound().getDouble("tpZ") == 0D) {
                list.add(TextFormatting.RED + (Translate.toLocal("tooltip.item.tpPearcel.line2.notBound")));
            }else{
                list.add(TextFormatting.GREEN + (Translate.toLocal("tooltip.item.tpPearcel.line2.bound") + " " + TextFormatting.AQUA + Math.round(stack.getTagCompound().getDouble("tpX")) + " " + Math.round(stack.getTagCompound().getDouble("tpY")) + " " + Math.round(stack.getTagCompound().getDouble("tpZ"))));
            }
        }else{
            list.add(TextFormatting.RED + (Translate.toLocal("tooltip.item.tpPearcel.line2.notBound")));
        }

    }

    @Override
    public ActionResult onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand)
    {
        if (!stack.hasTagCompound()){
            stack.setTagCompound(new NBTTagCompound());
            stack.getTagCompound().setDouble("tpX", 0D);
            stack.getTagCompound().setDouble("tpY", 0D);
            stack.getTagCompound().setDouble("tpZ", 0D);
            stack.getTagCompound().setInteger("dim", 0);
            stack.getTagCompound().setBoolean("set", false);
        }
        if (player.isSneaking()) {
            stack.getTagCompound().setDouble("tpX", player.posX);
            stack.getTagCompound().setDouble("tpY", player.posY);
            stack.getTagCompound().setDouble("tpZ", player.posZ);
            stack.getTagCompound().setInteger("dim", player.dimension);
            stack.getTagCompound().setBoolean("set", true);
            if(!world.isRemote) {
                player.addChatComponentMessage(new TextComponentTranslation(TextFormatting.DARK_GREEN + (Translate.toLocal("chat.tpPearcel.location.set"))));
            }
        }else{
            tpX = stack.getTagCompound().getDouble("tpX");
            tpY = stack.getTagCompound().getDouble("tpY");
            tpZ = stack.getTagCompound().getDouble("tpZ");
            dim = stack.getTagCompound().getInteger("dim");
            if (tpX == 0D && tpY == 0D && tpZ == 0D) {
                if (!world.isRemote) {
                    player.addChatComponentMessage(new TextComponentTranslation(TextFormatting.RED + (Translate.toLocal("chat.tpPearcel.location.notSet"))));
                }
            } else {
                if (player.dimension == dim) {
                    player.setPositionAndUpdate(tpX, tpY, tpZ);
                    if (!world.isRemote) {
                        player.addChatComponentMessage(new TextComponentTranslation(TextFormatting.GOLD + (Translate.toLocal("chat.tpPearcel.tp"))));
                    }
                    if (!player.capabilities.isCreativeMode) {
                        if (player.inventory.hasItemStack(new ItemStack(ModItems.pearcel_item))) {
                            player.inventory.deleteStack(new ItemStack(ModItems.pearcel_item, 1));
                        } else {
                            stack.damageItem(1, player);
                        }
                    }
                }else{
                    if(!world.isRemote){
                        player.addChatComponentMessage(new TextComponentTranslation(TextFormatting.RED + (Translate.toLocal("chat.tpPearcel.wrongDim"))));
                    }
                }
            }
        }
        return new ActionResult(EnumActionResult.PASS, stack);
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        if (stack.hasTagCompound()){
            if (stack.getTagCompound().getBoolean("set")){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

}
