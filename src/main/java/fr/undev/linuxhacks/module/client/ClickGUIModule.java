package fr.undev.linuxhacks.module.client;

import fr.undev.linuxhacks.module.Module;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class ClickGUIModule extends Module {
    public ClickGUIModule(String name) {
        super(name);
        // Customizable Theme for ClickGUI
        this.getSettings().put("red", "255");
        this.getSettings().put("green", "0");
        this.getSettings().put("blue", "0");
        this.getSettings().put("opacity", "255");
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    @Override
    public void onTick(TickEvent.ClientTickEvent event) {

    }
}
