/*
 * Decompiled with CFR 0.149.
 */
package fr.undev.linuxhacks.module;

import fr.undev.linuxhacks.module.chat.*;
import fr.undev.linuxhacks.module.combat.Aura;
import fr.undev.linuxhacks.module.combat.AutoTotem;
import fr.undev.linuxhacks.module.render.Fullbright;
import fr.undev.linuxhacks.module.test.TestModule;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;

public class Modules {
    private static LinkedHashMap<String, Module> registered = new LinkedHashMap();
    private static Collection<String> enabled = new ArrayList<String>();
    private static Collection<String> settings = new ArrayList<String>();
    private static Collection<String> toggleQueue = new ArrayList<String>();

    public static Collection<String> getToggleQueue() {
        return toggleQueue;
    }

    public static void init() {
        Modules.register("announcer", new AnnouncerModule("announcer"));
        Modules.register("spamfiles", new Spamfiles("Spamfiles"));
        Modules.register("mygotspam", new MygotSpammer("myg0tSpammer"));
        Modules.register("suffixes", new Suffixes("Suffixes"));
        Modules.register("welcomer", new Welcomer("Welcomer"));
        Modules.register("aura", new Aura("Aura"));
        Modules.register("test", new TestModule("Test"));
        Modules.register("fullbright", new Fullbright("Fullbright"));
        Modules.register("autototem", new AutoTotem("AutoTotem"));
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

