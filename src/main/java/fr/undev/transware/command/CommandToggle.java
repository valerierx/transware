/*
 * Decompiled with CFR 0.149.
 */
package fr.undev.transware.command;

import fr.undev.transware.module.Module;
import fr.undev.transware.module.Modules;
import fr.undev.transware.util.ChatUtils;

public class CommandToggle
extends Command {
    @Override
    public boolean onCommand(String command, String[] args) {
        String module = "null";

        if (args.length > 1) {
            module = args[1];
        }

        if (args.length > 2) {
            ChatUtils.printMessage(ChatUtils.coloredString("Modules: " + Modules.getRegistered().keySet(), "white"));
            return true;
        }

        if (module.equals("null")) {
            ChatUtils.printMessage(ChatUtils.coloredString("Modules: " + Modules.getRegistered().keySet(), "white"));
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

