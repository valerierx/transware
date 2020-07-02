/*
 * Decompiled with CFR 0.149.
 */
package fr.undev.linuxhacks.command;

import fr.undev.linuxhacks.command.*;
import java.util.LinkedHashMap;

public class Commands {
    private static LinkedHashMap<String, Command> registered = new LinkedHashMap();
    private static String prefix = "-";

    public static void init() {
        Commands.register("help", new CommandHelp());
        Commands.register("friend", new CommandFriend());
        Commands.register("toggle", new CommandToggle());
        Commands.register("hud", new CommandHUD());
        Commands.register("set", new CommandSet());
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

