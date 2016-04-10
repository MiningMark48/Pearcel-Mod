package com.miningmark48.pearcelmod.block;

import com.miningmark48.pearcelmod.init.ModFluids;
import com.miningmark48.pearcelmod.init.ModMaterials;
import com.miningmark48.pearcelmod.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraftforge.fluids.BlockFluidClassic;

import java.sql.Ref;

public class BlockPearcelFluid extends BlockFluidClassic{

    @SideOnly(Side.CLIENT)
    protected IIcon stillIcon;
    @SideOnly(Side.CLIENT)
    protected IIcon flowingIcon;

    public BlockPearcelFluid(){
        super(ModFluids.fluidPearcel, ModMaterials.materialFluidPearcel);
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return (side == 0 || side == 1)? stillIcon : flowingIcon;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register) {
        stillIcon = register.registerIcon(Reference.MOD_ID + ":pearcelFluid");
        flowingIcon = register.registerIcon(Reference.MOD_ID + ":pearcelFluid");
    }

}
