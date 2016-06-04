package com.miningmark48.pearcelmod.container;

import com.miningmark48.pearcelmod.init.ModBlocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class ContainerPearcelWorkbench extends Container {

    public InventoryCrafting craftMatrix;
    public IInventory craftResult;
    private World worldObj;
    private int posX;
    private int posY;
    private int posZ;

    public ContainerPearcelWorkbench(InventoryPlayer player, World world, int x, int y, int z){
        craftMatrix = new InventoryCrafting(this, 3, 3);
        craftResult = new InventoryCraftResult();
        worldObj = world;
        this.posX = x;
        this.posY = y;
        this.posZ = z;

        this.func_75146_a(new SlotCrafting(player.field_70458_d, craftMatrix, craftResult, 0, 124, 35));

        for (int i = 0; i < 3; i++){
            for (int k = 0; k < 3; k++){
                this.func_75146_a(new Slot(craftMatrix, k + i * 3, 30 + k * 18, 17 + i * 18));
            }
        }

        for (int i = 0; i < 3; i++){
            for (int k = 0; k < 9; k++){
                this.func_75146_a(new Slot(player, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
            }
        }

        for (int i = 0; i < 9; i++){
            this.func_75146_a(new Slot(player, i, 8 + i * 18, 142));
        }

        this.func_75130_a(this.craftMatrix);
    }

    public void func_75130_a(IInventory player)
    {
        this.craftResult.func_70299_a(0, CraftingManager.func_77594_a().func_82787_a(this.craftMatrix, this.worldObj));
    }

    @Override
    public boolean func_75145_c(EntityPlayer player){
        if (worldObj.func_180495_p(new BlockPos(posX, posY, posZ)).func_177230_c() != ModBlocks.pearcel_workbench){
            return false;
        }else{
            return player.func_70092_e((double)posX + 0.5D, (double)posY + 0.5D, (double)posZ + 0.5D) <= 64.0D;
        }
    }

    public void func_75134_a(EntityPlayer player)
    {
        super.func_75134_a(player);

        if (!this.worldObj.field_72995_K)
        {
            for (int i = 0; i < 9; ++i)
            {
                ItemStack itemstack = this.craftMatrix.func_70301_a(i);

                if (itemstack != null)
                {
                    player.func_71019_a(itemstack, false);
                }
            }
        }
    }

    public ItemStack func_82846_b(EntityPlayer p_82846_1_, int p_82846_2_)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.field_75151_b.get(p_82846_2_);

        if (slot != null && slot.func_75216_d())
        {
            ItemStack itemstack1 = slot.func_75211_c();
            itemstack = itemstack1.func_77946_l();

            if (p_82846_2_ == 0)
            {
                if (!this.func_75135_a(itemstack1, 10, 46, true))
                {
                    return null;
                }

                slot.func_75220_a(itemstack1, itemstack);
            }
            else if (p_82846_2_ >= 10 && p_82846_2_ < 37)
            {
                if (!this.func_75135_a(itemstack1, 37, 46, false))
                {
                    return null;
                }
            }
            else if (p_82846_2_ >= 37 && p_82846_2_ < 46)
            {
                if (!this.func_75135_a(itemstack1, 10, 37, false))
                {
                    return null;
                }
            }
            else if (!this.func_75135_a(itemstack1, 10, 46, false))
            {
                return null;
            }

            if (itemstack1.field_77994_a == 0)
            {
                slot.func_75215_d((ItemStack)null);
            }
            else
            {
                slot.func_75218_e();
            }

            if (itemstack1.field_77994_a == itemstack.field_77994_a)
            {
                return null;
            }

            slot.func_82870_a(p_82846_1_, itemstack1);
        }

        return itemstack;
    }

}
