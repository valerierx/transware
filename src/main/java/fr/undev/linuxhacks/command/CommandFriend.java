package fr.undev.linuxhacks.command;

import fr.undev.linuxhacks.command.Command;
import fr.undev.linuxhacks.module.Module;
import fr.undev.linuxhacks.module.Modules;
import fr.undev.linuxhacks.util.ChatUtils;
import fr.undev.linuxhacks.util.ConfigUtils;
import fr.undev.linuxhacks.friends.Friends;
import fr.undev.linuxhacks.util.UUIDUtils;

import java.io.IOException;

import static fr.undev.linuxhacks.friends.Friends.read;

public class CommandFriend
extends Command {
    @Override
    public boolean onCommand(String command, String[] args) {
		if (args[0].equals("add")) {
            try {
                if(UUIDUtils.getUUID(args[1].equals(UUIDUtils.getUUID(args[1]))))
                    ChatUtils.printMessage(ChatUtils.coloredString("WARNING: " + args[1] + " is already in the friend list!", "red"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
    }

    @Override
    public String getUsage() {
        return "set <Module> <Parameter> <Value>";
    }

    @Override
    public String getDescription() {
        return "Set different parameters of a module";
    }
}

