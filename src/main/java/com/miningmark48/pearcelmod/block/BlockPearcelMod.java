package com.miningmark48.pearcelmod.block;

import java.util.List;

import com.miningmark48.pearcelmod.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class BlockPearcelMod extends Block{

	public BlockPearcelMod(Material material){
		
		super(material);
		
	}
	
	public BlockPearcelMod(){
		
		super(Material.rock);
		this.setHardness(2.0F);
	
	}
	
	public boolean isOpaque() {
		return false;
	}
	
}
