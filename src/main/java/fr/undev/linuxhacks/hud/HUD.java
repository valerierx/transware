package fr.undev.linuxhacks.hud;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;

public class HUD {
    public HUD(Minecraft mc) {
        ScaledResolution scaled = new ScaledResolution(mc);
        int width = scaled.getScaledWidth();
        int height = scaled.getScaledHeight();

        Minecraft.getMinecraft().fontRenderer.drawString("linux.hacks v0.1", 2, 40, Integer.parseInt("C2185B", 16));
        Minecraft.getMinecraft().fontRenderer.drawString("Welcome " + Minecraft.getMinecraft().getSession().getUsername(), 2, 50, Integer.parseInt("1DE9B6", 16));
    }
}
