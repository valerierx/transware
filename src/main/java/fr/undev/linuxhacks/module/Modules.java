package fr.undev.linuxhacks.module;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;

import fr.undev.linuxhacks.module.client.ClickGUIModule;
import fr.undev.linuxhacks.module.test.TestModule;

public class Modules {
    private static LinkedHashMap<String, Module> registered = new LinkedHashMap<String, Module>();
    private static Collection<String> enabled = new ArrayList<String>();
    private static Collection<String> settings = new ArrayList<String>();
    private static Collection<String> toggleQueue = new ArrayList<String>();

    public static Collection<String> getToggleQueue() {
        return toggleQueue;
    }

    public static void init() {
        Modules.register("test", new TestModule("Test"));
        Modules.register("clickgui", new ClickGUIModule("ClickGUI"));
    }

    public static void register(String id, Module module) {
        module.setId(id);
        registered.put(id, module);
    }

    public static boolean isEnabled(String id) {
        return enabled.contains(id);
    }

    public static boolean toggle(String id) {
        if (Modules.isEnabled(id)) {
            registered.get(id).onDisable();
            enabled.remove(id);
        } else {
            registered.get(id).onEnable();
            enabled.add(id);
        }
        return Modules.isEnabled(id);
    }

    public static boolean queueToggle(String id) {
        if (registered.containsKey(id)) {
            toggleQueue.add(id);
        }
        return !Modules.isEnabled(id);
    }

    public static void forceDisable(String id) {
        if (enabled.contains(id)) {
            enabled.remove(id);
        }
    }

    public static LinkedHashMap<String, Module> getRegistered() {
        return registered;
    }

    public static Collection<String> getEnabled() {
        return enabled;
    }

    public static Module getById(String id) {
        return registered.get(id);
    }
}

