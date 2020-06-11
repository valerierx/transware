package fr.undev.linuxhacks.events;

import me.zero.alpine.event.type.Cancellable;
import net.minecraft.client.Minecraft;

/*
 * sorry i had to paste it to em
 * Created by 086 on 16/11/2017.
 */

public class LinuxEvent extends Cancellable {
    public Era era = Era.PRE;
    private final float partialTicks;

    public LinuxEvent() {
        partialTicks = Minecraft.getMinecraft().getRenderPartialTicks();
    }

    public Era getEra() {
        return era;
    }

    public float getPartialTicks() {
        return partialTicks;
    }

    public enum Era {
        PRE, PERI, POST
    }
}
