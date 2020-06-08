/*
 * Decompiled with CFR 0.149.
 */
package fr.undev.linuxhacks.command;

import fr.undev.linuxhacks.command.Command;
import fr.undev.linuxhacks.module.Module;
import fr.undev.linuxhacks.module.Modules;
import fr.undev.linuxhacks.util.ChatUtils;

public class CommandToggle
extends Command {
    @Override
    public boolean onCommand(String command, String[] args) {
        String module = "null";

        if (args.length > 1) {
            module = args[1];
        }

        if (args.length > 2) {
            return true;
        }

        if (module.equals("null")) {
            return true;
        }

        Module mod = Modules.getById(module);
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

