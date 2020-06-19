package fr.undev.linuxhacks.module.chat;

import fr.undev.linuxhacks.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.client.CPacketChatMessage;
import net.minecraftforge.fml.common.gameevent.TickEvent;

/*
 * myg0t.gg owns you
 * royalhack.net best tf2 hack
 */
public class MygotSpammer extends Module {
    public MygotSpammer(String name) {
        super(name);
        this.getSettings().put("delay", "5");
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    @Override
    public void onTick(TickEvent.ClientTickEvent var1) {
        Minecraft.getMinecraft().getConnection().sendPacket(new CPacketChatMessage("> myg0t.gg owns YOU!"));
        try {
            Thread.sleep(Long.parseLong(this.getSettings().get("delay")));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Minecraft.getMinecraft().getConnection().sendPacket(new CPacketChatMessage("> Join the Harrasment Authority NOW at myg0t.gg!"));
        try {
            Thread.sleep(Long.parseLong(this.getSettings().get("delay")));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Minecraft.getMinecraft().getConnection().sendPacket(new CPacketChatMessage("> OG BADGER OWNS ME AND ALL"));
    }
}
