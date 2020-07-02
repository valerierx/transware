package fr.undev.transware.command;

import fr.undev.transware.module.Module;
import fr.undev.transware.module.Modules;
import fr.undev.transware.util.ChatUtils;

public class CommandSet extends Command {
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
            ChatUtils.printMessage(ChatUtils.coloredString("No such module", "red"));
            return true;
        }

        Module mod = Modules.getById(module);
        if(args[2].length() < 1) {
            ChatUtils.printMessage(ChatUtils.coloredString("Settings: " + mod.getSettings().keySet(), "white"));
            return true;
        }
        mod.getSettings().put(args[2], args[3]);
        return false;
    }

    @Override
    public String getUsage() {
        return "set <Module> <Setting> <Argument>";
    }
    @Override

    public String getDescription() {
        return "Edit settings";
    }
}
