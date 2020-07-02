package fr.undev.linuxhacks.command;

import fr.undev.linuxhacks.module.Module;
import fr.undev.linuxhacks.module.Modules;
import fr.undev.linuxhacks.util.ChatUtils;
import net.minecraft.util.text.TextFormatting;

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
