package com.miningmark48.pearcelmod.block;

import com.miningmark48.pearcelmod.mob.EntityPearcelMob;
import com.miningmark48.pearcelmod.reference.Reference;
import com.miningmark48.pearcelmod.tileentity.TileEntityPearcelPainting;
import com.miningmark48.pearcelmod.tileentity.TileEntityPearcelPlush;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class BlockPearcelPlush extends BlockContainer{

    public BlockPearcelPlush(Material material){
        super(material);
    }

    public int getRenderType(){
        return -1;
    }

    public boolean isOpaqueCube(){
        return false;
    }

    public boolean renderAsNormalBlock(){
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World par1, int par2) {
        return new TileEntityPearcelPlush();
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister){
        this.blockIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(5));
    }

    @Override
    public void onBlockDestroyedByExplosion(World world, int x, int y, int z, Explosion explosion) {
        EntityPearcelMob pearcelmob = new EntityPearcelMob(world);
        pearcelmob.setPosition(x, y + 1, z);
        if (!world.isRemote){
            world.spawnEntityInWorld(pearcelmob);
        }
    }

}
