package fr.undev.linuxhacks.module.render;

import fr.undev.linuxhacks.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Fullbright extends Module {
    public Fullbright(String name) {
        super(name);
    }

    @Override
    public void onEnable() {
        Minecraft.getMinecraft().gameSettings.gammaSetting = 10000f;

    }

    @Override
    public void onDisable() {
        Minecraft.getMinecraft().gameSettings.gammaSetting = 1.0f;

    }

    @Override
    public void onTick(TickEvent.ClientTickEvent var1) {

    }
}
