package com.miningmark48.pearcelmod.client.settings;

import com.miningmark48.pearcelmod.reference.Names;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

public class Keybindings {

    public static KeyBinding regen = new KeyBinding(Names.Keys.REGEN, Keyboard.KEY_R, Names.Keys.CATEGORY);
    public static KeyBinding effects_clear = new KeyBinding(Names.Keys.EFFECTS_CLEAR, Keyboard.KEY_C, Names.Keys.CATEGORY);

}