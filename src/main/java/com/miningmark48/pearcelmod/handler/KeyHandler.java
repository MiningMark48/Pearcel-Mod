package com.miningmark48.pearcelmod.handler;

import com.miningmark48.pearcelmod.PearcelMod;
import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.reference.GUIs;
import com.miningmark48.pearcelmod.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

public class KeyHandler {

    public static KeyBinding item_pcp = new KeyBinding("PCP", Keyboard.KEY_C, "key.categories." + Reference.MOD_ID);

    public KeyHandler(){
        ClientRegistry.registerKeyBinding(item_pcp);
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void playerTick(TickEvent.PlayerTickEvent event){
        if (event.side == Side.SERVER){
            return;
        }
        if (event.phase == TickEvent.Phase.START){
            Minecraft mc = Minecraft.getMinecraft();
            if (item_pcp.isPressed()){
                if (mc.thePlayer.inventory.hasItemStack(new ItemStack(ModItems.pcp))){
                    mc.thePlayer.addChatComponentMessage(new TextComponentString("WIP!"));
                    //mc.thePlayer.openGui(PearcelMod.instance, GUIs.gui_id_pcp, mc.theWorld, (int) mc.thePlayer.posX, (int) mc.thePlayer.posY, (int) mc.thePlayer.posZ);
                }
            }
        }
    }


}
