package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

import java.util.List;

public class ItemPearcelBow extends ItemBow{
    public static final String[] bowPullIconNameArray = new String[] {"pulling_0", "pulling_1", "pulling_2"};

    public ItemPearcelBow(){
        setMaxDamage(-1);
    }

    @Override
    public ModelResourceLocation getModel(ItemStack stack, EntityPlayer player, int useRemaining)
    {
        ModelResourceLocation modelresourcelocation = new ModelResourceLocation(Reference.MOD_ID + ":pearcel_bow", "inventory");

        if(stack.getItem() == this && player.getItemInUse() != null)
        {
            if(useRemaining >= 18)
            {
                modelresourcelocation = new ModelResourceLocation(Reference.MOD_ID + ":pearcel_bow_pulling_2", "inventory");
            }
            else if(useRemaining > 13)
            {
                modelresourcelocation = new ModelResourceLocation(Reference.MOD_ID + ":pearcel_bow_pulling_1", "inventory");
            }
            else if(useRemaining > 0)
            {
                modelresourcelocation = new ModelResourceLocation(Reference.MOD_ID + ":pearcel_bow_pulling_0", "inventory");
            }
        }
        return modelresourcelocation;
    }

    public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int timeLeft)
    {
        int i = getInventorySlotContainItem(ModItems.pearcel_arrow, player);
        if (player.inventory.getStackInSlot(i).hasTagCompound()) {
            if (player.inventory.getStackInSlot(i).getTagCompound().getBoolean("zoom")) {
                zoomOut();
            }
        }
        int j = this.getMaxItemUseDuration(stack) - timeLeft;

        ArrowLooseEvent event = new ArrowLooseEvent(player, stack, j);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
        {
            return;
        }
        j = event.charge;

        boolean flag = player.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, stack) > 0;

        if (flag || (player.inventory.hasItem(ModItems.pearcel_arrow) || player.inventory.hasItem(Items.arrow)))
        {
            float f = (float)j / 20.0F;
            f = (f * f + f * 2.0F) / 3.0F;

            if ((double)f < 0.1D)
            {
                return;
            }

            if (f > 1.0F)
            {
                f = 1.0F;
            }

            EntityArrow entityarrow = new EntityArrow(world, player, f * 2.0F);

            if (f == 1.0F)
            {
                entityarrow.setIsCritical(true);
            }

            int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, stack);

            if (k > 0)
            {
                entityarrow.setDamage(entityarrow.getDamage() + (double)k * 0.5D + 0.5D);
            }

            int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, stack);

            if (l > 0)
            {
                entityarrow.setKnockbackStrength(l);
            }

            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, stack) > 0)
            {
                entityarrow.setFire(100);
            }

            stack.damageItem(1, player);
            world.playSoundAtEntity(player, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

            if (flag)
            {
                entityarrow.canBePickedUp = 2;
            }
            else
            {
                if (player.inventory.hasItem(ModItems.pearcel_arrow)){
                    if (player.inventory.getStackInSlot(i).hasTagCompound()) {
                        if (!player.inventory.getStackInSlot(i).getTagCompound().getBoolean("inf")) {
                            player.inventory.getStackInSlot(i).damageItem(1, player);
                            if (player.inventory.getStackInSlot(i).getItemDamage() == 0) {
                                player.inventory.removeStackFromSlot(i);
                            }
                        }
                        if (player.inventory.getStackInSlot(i).getTagCompound().getBoolean("pow")){
                            entityarrow.setDamage(entityarrow.getDamage() + 2.0D);
                        }
                        if (player.inventory.getStackInSlot(i).getTagCompound().getBoolean("knock")){
                            entityarrow.setKnockbackStrength(2);
                        }
                    }else{
                        player.inventory.getStackInSlot(i).damageItem(1, player);
                        if (player.inventory.getStackInSlot(i).getItemDamage() == 0) {
                            player.inventory.removeStackFromSlot(i);
                        }
                    }
                    entityarrow.canBePickedUp = 2;
                }else{
                    player.inventory.consumeInventoryItem(Items.arrow);
                }

            }

            if (!world.isRemote)
            {
                world.spawnEntityInWorld(entityarrow);
            }
        }

    }

    public int getInventorySlotContainItem(Item itemIn, EntityPlayer player)
    {
        for (int i = 0; i < player.inventory.mainInventory.length; ++i)
        {
            if (player.inventory.mainInventory[i] != null && player.inventory.mainInventory[i].getItem() == itemIn)
            {
                return i;
            }
        }

        return -1;
    }

    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityPlayer player)
    {
        return stack;
    }

    public int getMaxItemUseDuration(ItemStack p_77626_1_)
    {
        return 72000;
    }

    public EnumAction getItemUseAction(ItemStack p_77661_1_)
    {
        return EnumAction.BOW;
    }

    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {

        int i = getInventorySlotContainItem(ModItems.pearcel_arrow, player);
        if (player.inventory.getStackInSlot(i).hasTagCompound()) {
            if (player.inventory.getStackInSlot(i).getTagCompound().getBoolean("zoom")) {
                zoomIn();
            }
        }

        ArrowNockEvent event = new ArrowNockEvent(player, stack);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
        {
            return event.result;
        }

        if (player.capabilities.isCreativeMode || (player.inventory.hasItem(ModItems.pearcel_arrow) || player.inventory.hasItem(Items.arrow)))
        {
            player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
        }

        return stack;

    }


    public int getItemEnchantability()
    {
        return 1;
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {

    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5){
        super.onUpdate(stack, world, entity, par4, par5);
        {
            EntityPlayer player = (EntityPlayer) entity;
            ItemStack equipped = player.getCurrentEquippedItem();
            if (equipped == stack){
                //TODO
            }
        }
    }

    private static void zoomIn(){
        Minecraft.getMinecraft().gameSettings.fovSetting = 25F;
    }

    private static void zoomOut(){
        Minecraft.getMinecraft().gameSettings.fovSetting = 70F;
    }

}
