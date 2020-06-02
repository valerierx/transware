package fr.undev.linuxhacks.module.client;

import fr.undev.linuxhacks.module.Module;
import fr.undev.linuxhacks.setting.Setting;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class ClickGUIModule extends Module {
    public ClickGUIModule(String name) {
        super(name);
        // Customizable Theme for ClickGUI
        this.getSettings().add(new Setting("red", "255", "0", "255"));
        this.getSettings().add(new Setting("green", "255", "0", "255"));
        this.getSettings().add(new Setting("blue", "0", "0", "255"));
        this.getSettings().add(new Setting("opacity", "255", "0", "255"));
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
