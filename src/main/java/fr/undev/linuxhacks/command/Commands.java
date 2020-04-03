package fr.undev.linuxhacks.command;

import java.util.LinkedHashMap;

import fr.undev.linuxhacks.command.Command;
import fr.undev.linuxhacks.command.CommandBind;
import fr.undev.linuxhacks.command.CommandHelp;

public class Commands {
    private static LinkedHashMap<String, Command> registered = new LinkedHashMap();
    private static String prefix = "*";

    public static void init() {
        Commands.register("help", new CommandHelp());
        Commands.register("crash", new CommandBind());
    }

    public static void register(String id, Command command) {
        registered.put(id, command);
    }

    public static LinkedHashMap<String, Command> getRegistered() {
        return registered;
    }

    public static String getPrefix() {
        return prefix;
    }

    public static void setPrefix(String prefix) {
        Commands.prefix = prefix;
    }
}

