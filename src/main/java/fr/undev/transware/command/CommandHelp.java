/*
 * Decompiled with CFR 0.149.
 */
package fr.undev.transware.command;

import fr.undev.transware.util.ChatUtils;
import java.util.Map;

public class CommandHelp
extends Command {
    @Override
    public boolean onCommand(String command, String[] args) {
        if (args.length == 1) {
            ChatUtils.printMessage(ChatUtils.coloredString("linux.hacks commands:", "red"));
            for (Map.Entry<String, Command> entry : Commands.getRegistered().entrySet()) {
                ChatUtils.printMessage(ChatUtils.coloredString(Commands.getPrefix() + entry.getValue().getUsage(), "red"));
            }
        } else if (Commands.getRegistered().containsKey(args[1])) {
            Command cmd = Commands.getRegistered().get(args[1]);
            ChatUtils.printMessage(ChatUtils.coloredString("Usage: " + cmd.getUsage() + "\nDescription: " + cmd.getDescription(), "red"));
        }
        return false;
    }

    @Override
    public String getUsage() {
        return "help [command]";
    }

    @Override
    public String getDescription() {
        return "Prints a list of commands";
    }
}

