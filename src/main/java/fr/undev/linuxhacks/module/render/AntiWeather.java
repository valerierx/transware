package fr.undev.linuxhacks.module.render;

import fr.undev.linuxhacks.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class AntiWeather extends Module {
    public AntiWeather(String name) {
        super(name);
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    @Override
    public void onTick(TickEvent.ClientTickEvent var1) {
        if (Minecraft.getMinecraft().world.isRaining()) {
            Minecraft.getMinecraft().world.setRainStrength(0);
        }
    }
}
