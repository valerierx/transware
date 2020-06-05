/*
 * Decompiled with CFR 0.149.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  org.ini4j.InvalidFileFormatException
 *  org.ini4j.Wini
 */
package fr.undev.linuxhacks.util;

import java.io.File;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import org.ini4j.Wini;

public class ConfigUtils {
    private String configPath;

    public ConfigUtils() {
        this.configPath = Minecraft.getMinecraft().mcDataDir.getPath() + "/linuxdothacks.ini";
    }

    public String getSetting(String module, String setting) {
        Wini ini = null;
        try {
            ini = new Wini(new File(this.configPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ini.get((Object)module, (Object)setting);
    }
    public void writeSetting(String module, String setting, String data) {
        Wini ini = null;
        try {
            ini = new Wini(new File(this.configPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ini.put(module, setting, (Object)data);
    }
}

