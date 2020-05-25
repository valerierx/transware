package fr.undev.linuxhacks.module.movement;

import fr.undev.linuxhacks.module.Module;
import fr.undev.linuxhacks.util.ChatUtils;
import net.minecraft.util.Timer;
import net.minecraftforge.fml.common.gameevent.TickEvent;


public class TimerSwitchModule  extends Module{
    private int tickWait = 0;

    public TimerSwitchModule(String name) {
        super(name);
        this.getSettings().put("speed", "4.2");
        this.getSettings().put("fastSpeed", "10");
        this.getSettings().put("tickToFast", "4");
        this.getSettings().put("tickToDisableFast", "7");
    }

    @Override
    public void onEnable() {
        ChatUtils.printMessage(ChatUtils.coloredString("TimerSwitch ON " + this.getSettings().get("text"), "green"));
    }

    @Override
    public void onDisable()  throws NoSuchFieldException, SecurityException {
        ChatUtils.printMessage(ChatUtils.coloredString("TimerSwitch OFF", "red"));
        mc.timer.tickLength = 50;
    }


    @Override
    public void onTick(TickEvent.ClientTickEvent event) {
        if (tickWait == Float.parseFloat(this.getSettings().get("tickToFast"))) {
            mc.timer.tickLength = 50.0f / Float.parseFloat(this.getSettings().get("fastSpeed"));
        }
        if (tickWait >= Float.parseFloat(this.getSettings().get("tickToDisableFast"))) {
            tickWait = 0;
            mc.timer.tickLength = 50.0f / Float.parseFloat(this.getSettings().get("fastSpeed"));
        }
        tickWait++;
    }
}