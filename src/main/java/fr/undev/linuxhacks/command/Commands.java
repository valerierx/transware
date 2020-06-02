/*
 * Decompiled with CFR 0.149.
 */
package fr.undev.linuxhacks.command;

import fr.undev.linuxhacks.command.Command;
import fr.undev.linuxhacks.command.CommandFriend;
import fr.undev.linuxhacks.command.CommandHelp;
import fr.undev.linuxhacks.command.CommandTest;
import java.util.LinkedHashMap;

public class Commands {
    private static LinkedHashMap<String, Command> registered = new LinkedHashMap();
    private static String prefix = "-";

    public static void init() {
        Commands.register("help", new CommandHelp());
        Commands.register("friend", new CommandFriend());
        Commands.register("toggle", new CommandTest());
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

