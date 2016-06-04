package com.miningmark48.pearcelmod.gui;

import com.miningmark48.pearcelmod.container.ContainerPearcelWorkbench;
import com.miningmark48.pearcelmod.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class GuiPearcelWorkbench extends GuiContainer{

    private ResourceLocation texture = new ResourceLocation(Reference.MOD_ID + ":textures/gui/gui_pearcel_workbench.png");
    public static final int GUI_ID = 153;

    public GuiPearcelWorkbench(InventoryPlayer player, World world, int x, int y, int z){
        super(new ContainerPearcelWorkbench(player, world, x, y, z));

        this.field_146999_f = 176;
        this.field_147000_g = 166;
    }

    public void func_146281_b(){
        super.func_146281_b();
    }

    protected void func_146979_b(int i, int j){
        this.field_146289_q.func_78276_b(StatCollector.func_74838_a("gui.pearcel_workbench.name"), 40, 5, 0x404040);
    }

    @Override
    protected void func_146976_a(float var1, int var2, int var3) {

        GL11.glColor4f(1F, 1F, 1F, 1F);
        Minecraft.func_71410_x().func_110434_K().func_110577_a(texture);

        func_73729_b(field_147003_i, field_147009_r, 0, 0, field_146999_f, field_147000_g);

    }

}
