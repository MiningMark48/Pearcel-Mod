package com.miningmark48.pearcelmod.handler;

import com.miningmark48.pearcelmod.PearcelMod;
import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.reference.GUIs;
import com.miningmark48.pearcelmod.reference.Reference;
import com.miningmark48.pearcelmod.utility.Translate;
import com.sun.xml.internal.ws.client.dispatch.PacketDispatch;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import javax.swing.plaf.basic.BasicSplitPaneUI;

public class KeyHandler{

    public static KeyBinding item_pcp = new KeyBinding(Translate.toLocal("key.item.pcp.1"), Keyboard.CHAR_NONE, "key.categories." + Reference.MOD_ID);
    public static KeyBinding item_pepc = new KeyBinding(Translate.toLocal("key.item.pepc.1"), Keyboard.CHAR_NONE, "key.categories." + Reference.MOD_ID);

    public KeyHandler(){
        ClientRegistry.registerKeyBinding(item_pcp);
        ClientRegistry.registerKeyBinding(item_pepc);
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onEvent(TickEvent.PlayerTickEvent event){

        if (event.side == Side.SERVER){
            return;
        }
        if (event.phase == TickEvent.Phase.START){
            Minecraft mc = Minecraft.getMinecraft();
            EntityPlayer player = event.player;
            World world = player.getEntityWorld();
            int x = (int) event.player.posX;
            int y = (int) event.player.posY;
            int z = (int) event.player.posZ;

            //PCP GUI
            if (item_pcp.isPressed()){
                if (player.inventory.hasItemStack(new ItemStack(ModItems.pcp))){
                    player.addChatComponentMessage(new TextComponentString("This is a WIP, Coming Soon™!"));
                    //player.openGui(PearcelMod.instance, GUIs.gui_id_pcp, world, x, y, z);

                }
            }
            //PEPC GUI
            if (item_pepc.isPressed()){
                if (player.inventory.hasItemStack(new ItemStack(ModItems.pepc))) {
                    player.addChatComponentMessage(new TextComponentString("This is a WIP, Coming Soon™!"));
                    //player.displayGUIChest(player.getInventoryEnderChest());
                }
            }
        }
    }

}
