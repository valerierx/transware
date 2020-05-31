/*
 * Decompiled with CFR 0.149.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package fr.undev.linuxhacks.module.test;

import fr.undev.linuxhacks.module.Module;
import fr.undev.linuxhacks.util.ChatUtils;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class TestModule
extends Module {
    private int tickWait = 0;

    public TestModule(String name) {
        super(name);
    }

    @Override
    public void onEnable() {
        ChatUtils.printMessage(ChatUtils.coloredString("test module", "red"));
    }

    @Override
    public void onDisable() {
        ChatUtils.printMessage(ChatUtils.coloredString("you are turok", "red"));
    }

    @Override
    public void onTick(TickEvent.ClientTickEvent event) {
    }
}

