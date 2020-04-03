package fr.undev.linuxhacks.command;

import fr.undev.linuxhacks.command.Command;
import fr.undev.linuxhacks.module.Module;
import fr.undev.linuxhacks.module.Modules;
import fr.undev.linuxhacks.util.ChatUtils;
import fr.undev.linuxhacks.util.ConfigUtils;

public class CommandBind
extends Command {
    @Override
    public boolean onCommand(String command, String[] args) {
		
        
   }

    @Override
    public String getUsage() {
        return "bind";
    }

    @Override
    public String getDescription() {
        return "Bind modules to a key";
    }
}

