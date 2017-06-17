package com.miningmark48.pearcelmod.item;

import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class ItemPearcelBow extends ItemBow{
    public static final String[] bowPullIconNameArray = new String[] {"pulling_0", "pulling_1", "pulling_2"};

    public ItemPearcelBow(){
        setMaxDamage(-1);
        this.addPropertyOverride(new ResourceLocation("pull"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                if (entityIn == null)
                {
                    return 0.0F;
                }
                else
                {
                    ItemStack itemstack = entityIn.getActiveItemStack();
                    return itemstack != null && itemstack.getItem() == ModItems.pearcel_bow ? (float)(stack.getMaxItemUseDuration() - entityIn.getItemInUseCount()) / 20.0F : 0.0F;
                }
            }
        });
        this.addPropertyOverride(new ResourceLocation("pulling"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });
    }

    public ModelResourceLocation getModel(ItemStack stack, EntityPlayer player, int useRemaining)
    {
        ModelResourceLocation modelresourcelocation = new ModelResourceLocation(Reference.MOD_ID + ":pearcel_bow", "inventory");

        if(stack.getItem() == this && player.getHeldItem(EnumHand.MAIN_HAND) != null)
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

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World world, EntityLivingBase entityLiving, int timeLeft)
    {
        if (entityLiving instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entityLiving;


            int i = getInventorySlotContainItem(ModItems.pearcel_arrow, player);
            ItemStack itemstack = new ItemStack(ModItems.pearcel_arrow);
            int j = this.getMaxItemUseDuration(stack);

            ArrowLooseEvent event = new ArrowLooseEvent(player, stack, world, j, true);
            MinecraftForge.EVENT_BUS.post(event);
            if (event.isCanceled()) {
                return;
            }
            j = event.getCharge();

            boolean flag = player.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;

            if (flag || (i != -1)) {
                float f = (float) j / 20.0F;
                f = (f * f + f * 2.0F) / 3.0F;

                if ((double) f < 0.1D) {
                    return;
                }

                if (f > 1.0F) {
                    f = 1.0F;
                }
                if (!world.isRemote) {
                    ItemPearcelArrow itemarrow = (ItemPearcelArrow) ((ItemPearcelArrow) (itemstack.getItem() instanceof ItemPearcelArrow ? itemstack.getItem() : ModItems.pearcel_arrow));
                    EntityArrow entityarrow = itemarrow.createArrow(world, itemstack, player);
                    entityarrow.setAim(player, player.rotationPitch, player.rotationYaw, 0.0F, f * 3.0F, 1.0F);

                    if (f == 1.0F) {
                        entityarrow.setIsCritical(true);
                    }

                    int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);

                    if (k > 0) {
                        entityarrow.setDamage(entityarrow.getDamage() + (double) k * 0.5D + 0.5D);
                    }

                    int l = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack);

                    if (l > 0) {
                        entityarrow.setKnockbackStrength(l);
                    }

                    if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack) > 0) {
                        entityarrow.setFire(100);
                    }

                    stack.damageItem(1, player);
                    world.playSound(player, player.getPosition(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

                    if (flag) {
                        entityarrow.pickupStatus = EntityArrow.PickupStatus.CREATIVE_ONLY;
                    } else {
                        if (player.inventory.hasItemStack(new ItemStack(ModItems.pearcel_arrow))) {
                            if (player.inventory.getStackInSlot(i).hasTagCompound()) {
                                if (!player.inventory.getStackInSlot(i).getTagCompound().getBoolean("inf")) {
                                    player.inventory.getStackInSlot(i).damageItem(1, player);
                                    if (player.inventory.getStackInSlot(i).getItemDamage() == 0) {
                                        player.inventory.removeStackFromSlot(i);
                                    }
                                }
                                if (player.inventory.getStackInSlot(i).getTagCompound().getBoolean("pow")) {
                                    entityarrow.setDamage(entityarrow.getDamage() + 2.0D);
                                }
                                if (player.inventory.getStackInSlot(i).getTagCompound().getBoolean("knock")) {
                                    entityarrow.setKnockbackStrength(2);
                                }
                            }else{
                                player.inventory.getStackInSlot(i).damageItem(1, player);

                                if (player.inventory.getStackInSlot(i).getItemDamage() == 0) {
                                    player.inventory.removeStackFromSlot(i);
                                }
                            }
                            entityarrow.pickupStatus = EntityArrow.PickupStatus.DISALLOWED;
                        }

                    }

                    world.spawnEntity(entityarrow);
                    zoomOut();
                    entityarrow.pickupStatus = EntityArrow.PickupStatus.CREATIVE_ONLY;

                }

            }
        }

        return;

    }

    public int getInventorySlotContainItem(Item itemIn, EntityPlayer player)
    {
        for (int i = 0; i < player.inventory.mainInventory.size(); ++i)
        {
            if (player.inventory.mainInventory.get(i) != ItemStack.EMPTY && player.inventory.mainInventory.get(i).getItem() == itemIn)
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

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {

        ItemStack stack = player.getHeldItem(hand);

        if (player.inventory.hasItemStack(new ItemStack(ModItems.pearcel_arrow))) {
            int i = this.getInventorySlotContainItem(ModItems.pearcel_arrow, player);
            if (player.inventory.getStackInSlot(i).hasTagCompound()) {
                if (player.inventory.getStackInSlot(i).getTagCompound().getBoolean("zoom")) {
                    zoomIn();
                }
            }
        }

        boolean flag = this.findAmmo(player) != null;

        ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(stack, world, player, hand, flag);
        if (ret != null) return ret;

        if (!player.capabilities.isCreativeMode && !flag)
        {
            return !flag ? new ActionResult(EnumActionResult.FAIL, stack) : new ActionResult(EnumActionResult.PASS, stack);
        }
        else
        {
            player.setActiveHand(hand);
            return new ActionResult(EnumActionResult.SUCCESS, stack);
        }

    }

    public int getItemEnchantability()
    {
        return 1;
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5){
        super.onUpdate(stack, world, entity, par4, par5);
        {
            EntityPlayer player = (EntityPlayer) entity;
            ItemStack equipped = player.getHeldItem(EnumHand.MAIN_HAND);
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

    private ItemStack findAmmo(EntityPlayer player)
    {
        if (this.isArrow(player.getHeldItem(EnumHand.OFF_HAND)))
        {
            return player.getHeldItem(EnumHand.OFF_HAND);
        }
        else if (this.isArrow(player.getHeldItem(EnumHand.MAIN_HAND)))
        {
            return player.getHeldItem(EnumHand.MAIN_HAND);
        }
        else
        {
            for (int i = 0; i < player.inventory.getSizeInventory(); ++i)
            {
                ItemStack itemstack = player.inventory.getStackInSlot(i);

                if (this.isArrow(itemstack))
                {
                    return itemstack;
                }
            }

            return null;
        }
    }

    protected boolean isArrow(@Nullable ItemStack stack)
    {
        return stack != null && stack.getItem() instanceof ItemPearcelArrow;
    }

}
