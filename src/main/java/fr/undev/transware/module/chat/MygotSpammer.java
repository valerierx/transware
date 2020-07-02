package fr.undev.transware.module.chat;

import fr.undev.transware.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.client.CPacketChatMessage;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.concurrent.ThreadLocalRandom;

/*
 * myg0t.gg owns you
 * royalhack.net best tf2 hack
 */
public class MygotSpammer extends Module {
    public MygotSpammer(String name) {
        super(name);
        this.getSettings().put("delay", "5");

    }

    private static long startTime = 0;

    @Override
    public void onEnable() {
    }

    @Override
    public void onDisable() {

    }


    @Override
    public void onTick(TickEvent.ClientTickEvent var1) {
        if (startTime + (Integer.parseInt(this.getSettings().get("delay")) * 1000) <= System.currentTimeMillis()) {
            startTime = System.currentTimeMillis();
            Minecraft.getMinecraft().getConnection().sendPacket(new CPacketChatMessage(getRandomMessage()));
        }
    }
    private String getRandomMessage() {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 3 + 1);
        switch(randomNum) {
            case 1:
                return "> myg0t.gg owns YOU!";
            case 2:
                return "> Join the Harrasment Authority NOW at myg0t.gg!";
            case 3:
                return "> OG BADGER OWNS ME AND ALL !";
        }
        return "> unreachable statement lol";
    }
}
