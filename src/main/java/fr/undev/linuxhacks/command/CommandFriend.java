/*
 * Decompiled with CFR 0.149.
 */
package fr.undev.linuxhacks.command;

import fr.undev.linuxhacks.command.Command;

public class CommandFriend
extends Command {
    @Override
    public boolean onCommand(String command, String[] args) {
        if(args[0].equalsIgnoreCase("add")) {


        }
        return false;
    }

    @Override
    public String getUsage() {
        return "friend add|del <Username>";
    }

    @Override
    public String getDescription() {
        return "Whitelist people from CrystalAura, KillAura, etc.";
    }
}

