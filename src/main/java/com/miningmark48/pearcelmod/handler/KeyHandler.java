package com.miningmark48.pearcelmod.handler;

import com.miningmark48.mininglib.utility.ModTranslate;
import com.miningmark48.pearcelmod.gui.manual.GuiManual;
import com.miningmark48.pearcelmod.init.ModItems;
import com.miningmark48.pearcelmod.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

public class KeyHandler{

    public static KeyBinding item_pcp = new KeyBinding(ModTranslate.toLocal("key.item.pcp.1"), Keyboard.CHAR_NONE, "key.categories." + Reference.MOD_ID);
    public static KeyBinding item_pepc = new KeyBinding(ModTranslate.toLocal("key.item.pepc.1"), Keyboard.CHAR_NONE, "key.categories." + Reference.MOD_ID);
    public static KeyBinding gui_manual = new KeyBinding(ModTranslate.toLocal("key.gui.manual.1"), Keyboard.KEY_B, "key.categories." + Reference.MOD_ID);

    public KeyHandler(){
        ClientRegistry.registerKeyBinding(item_pcp);
        ClientRegistry.registerKeyBinding(item_pepc);
        ClientRegistry.registerKeyBinding(gui_manual);
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
                    player.sendMessage(new TextComponentString("This is a WIP, Coming Soon™!"));
                    //player.openGui(PearcelMod.instance, GUIs.gui_id_pcp, world, x, y, z);

                }
            }
            //PEPC GUI
            if (item_pepc.isPressed()){
                if (player.inventory.hasItemStack(new ItemStack(ModItems.pepc))) {
                    player.sendMessage(new TextComponentString("This is a WIP, Coming Soon™!"));
                    //player.displayGUIChest(player.getInventoryEnderChest());
                }
            }
            //Manual Gui
            if (gui_manual.isPressed()){
                if (player.inventory.hasItemStack(new ItemStack(ModItems.pearcel_manual))) {
                    Minecraft.getMinecraft().displayGuiScreen(new GuiManual(0));
                }
            }
        }
    }

}
