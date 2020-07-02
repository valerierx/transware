/*
 * Decompiled with CFR 0.149.
 */
package fr.undev.transware.command;

public class CommandFriend
extends Command {
    @Override
    public boolean onCommand(String command, String[] args) {


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

