/*
 * Decompiled with CFR 0.149.
 */
package fr.undev.linuxhacks.command;

import net.minecraft.client.Minecraft;

public abstract class Command {

    public abstract boolean onCommand(String var1, String[] var2);

    public String getDescription() {
        return "No description";
    }

    public abstract String getUsage();
}

