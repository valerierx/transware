/*
 * Decompiled with CFR 0.149.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package fr.undev.linuxhacks.module;

import java.util.HashMap;
import java.util.LinkedHashMap;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public abstract class Module {
    private final String displayName;
    private final LinkedHashMap<String, Boolean> settings;
    private String id;

    public final Minecraft mc = Minecraft.getMinecraft();

    public Module(String name) {
        this.displayName = name;
        this.settings = new LinkedHashMap();
    }

    public abstract void onEnable();

    public abstract void onDisable();

    public abstract void onTick(TickEvent.ClientTickEvent var1);

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

