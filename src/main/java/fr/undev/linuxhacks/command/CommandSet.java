package fr.undev.linuxhacks.command;

import fr.undev.linuxhacks.command.Command;
import fr.undev.linuxhacks.module.Module;
import fr.undev.linuxhacks.module.Modules;
import fr.undev.linuxhacks.util.ChatUtils;
import fr.undev.linuxhacks.util.ConfigUtils;

public class CommandSet
extends Command {
    @Override
    public boolean onCommand(String command, String[] args) {
		
        
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

