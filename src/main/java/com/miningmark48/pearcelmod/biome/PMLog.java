package com.miningmark48.pearcelmod.biome;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class PMLog extends BlockLog{

    public static final String[] logs = new String[] {"pearcel"};

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tabs, List list){
        for (int i = 0; i < logs.length; i++){
            list.add(new ItemStack(item, 1, i));
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister){
        this.field_150167_a = new IIcon[logs.length];
        this.field_150166_b = new IIcon[logs.length];

        for (int i = 0; i < this.field_150167_a.length; i++){
            this.field_150167_a[i] = iconRegister.registerIcon(this.getTextureName() + "_" + logs[i]);
            this.field_150166_b[i] = iconRegister.registerIcon(this.getTextureName() + "_" + logs[i] + "_top");
        }
    }

}
