/*
 * Decompiled with CFR 0.149.
 */
package fr.undev.linuxhacks.command;

import fr.undev.linuxhacks.command.Command;
import fr.undev.linuxhacks.module.Module;
import fr.undev.linuxhacks.module.Modules;
import fr.undev.linuxhacks.util.ChatUtils;

import fr.undev.linuxhacks.Main;
import net.minecraft.client.Minecraft;

public class CommandHUD
extends Command {
    @Override
    public boolean onCommand(String command, String[] args) {
        if (args.length > 1) {
            return true;
        }

        Minecraft.getMinecraft().displayGuiScreen(Main.click_hud);

        return false;
    }

    @Override
    public String getUsage() {
        return "hud";
    }

    @Override
    public String getDescription() {
        return "Enable hud editor";
    }
}

