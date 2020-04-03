package fr.undev.linuxhacks.module;

import java.util.HashMap;
import java.util.LinkedHashMap;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public abstract class Module {
    private final String displayName;
    private final LinkedHashMap<String, Boolean> settings;
    private String id;

    public Module(String name) {
        this.displayName = name;
        this.settings = new LinkedHashMap();
    }

    public abstract void onEnable();

    public abstract void onDisable();


    public String getDisplayName() {
        return this.displayName;
    }

    public HashMap<String, Boolean> getSettings() {
        return this.settings;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

