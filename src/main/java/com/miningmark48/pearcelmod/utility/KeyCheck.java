package com.miningmark48.pearcelmod.utility;

import org.lwjgl.input.Keyboard;

public class KeyCheck {

    public static boolean isHoldingShift(){
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)){
            return true;
        }else{
            return false;
        }
    }

}
