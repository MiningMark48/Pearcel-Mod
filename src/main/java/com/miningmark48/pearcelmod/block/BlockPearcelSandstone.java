package com.miningmark48.pearcelmod.block;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockPearcelSandstone extends BlockPearcelMod{

    public BlockPearcelSandstone(){
        super();
    }

    public IIcon[] icons = new IIcon[6];

    @Override
    public void registerBlockIcons(IIconRegister reg){
        for (int i = 0; i < 6; i++){
            if (i == 1){
                this.icons[i] = reg.registerIcon(this.textureName + "_top");
            }else if(i == 0) {
                this.icons[i] = reg.registerIcon(this.textureName + "_bottom");
            }else{
                this.icons[i] = reg.registerIcon(this.textureName + "_side");
            }

        }
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return this.icons[side];
    }

}
