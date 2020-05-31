/*
 * Decompiled with CFR 0.149.
 */
package fr.undev.linuxhacks.command;

import fr.undev.linuxhacks.command.Command;
import fr.undev.linuxhacks.module.Module;
import fr.undev.linuxhacks.module.Modules;
import fr.undev.linuxhacks.util.ChatUtils;

public class CommandTest
extends Command {
    @Override
    public boolean onCommand(String command, String[] args) {
        Module mod = Modules.getById("test");
        Modules.toggle(mod.getId());
        ChatUtils.printMessage(ChatUtils.toggledMsg(mod));
        return false;
    }

    @Override
    public String getUsage() {
        return "toggle <module>";
    }

    @Override
    public String getDescription() {
        return "Toggles a module";
    }
}

