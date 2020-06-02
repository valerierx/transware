/*
 * Decompiled with CFR 0.149.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package fr.undev.linuxhacks.module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import fr.undev.linuxhacks.setting.Setting;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public abstract class Module {
    private final String displayName;
    private final ArrayList<Setting> settings;
    private String id;

    public Module(String name) {
        this.displayName = name;
        this.settings = new ArrayList();
    }

    public abstract void onEnable();

    public abstract void onDisable();

    public abstract void onTick(TickEvent.ClientTickEvent var1);

    public String getDisplayName() {
        return this.displayName;
    }

    public ArrayList<Setting> getSettings() {
        return this.settings;
    }

    public Setting getSettingFromName(String name) {
        for (Setting setting : this.getSettings()) {
            if (setting.getName().equals(name)) {
                return setting;
            }
        }
        return null;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

