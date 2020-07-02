/*
 * Decompiled with CFR 0.149.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.util.text.ChatType
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.ITextComponent$Serializer
 */
package fr.undev.linuxhacks.util;

import fr.undev.linuxhacks.module.Module;
import fr.undev.linuxhacks.module.Modules;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.ITextComponent;

public class ChatUtils {
    public static void printMessage(ChatType type, ITextComponent message) {
        Minecraft.getMinecraft().ingameGUI.addChatMessage(type, message);
    }

    public static void printMessage(ITextComponent message) {
        ChatUtils.printMessage(ChatType.SYSTEM, message);
    }

    public static ITextComponent coloredString(String message, String color) {
        return ITextComponent.Serializer.jsonToComponent((String)("{\"text\":\"" + message + "\",\"color\":\"" + color + "\"}"));
    }

    public static ITextComponent toggledMsg(Module module) {
        return ChatUtils.coloredString(module.getDisplayName() + " has been " + (Modules.isEnabled(module.getId()) ? "enabled" : "disabled"), "red");
    }
}

