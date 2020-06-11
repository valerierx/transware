package fr.undev.linuxhacks.module.chat;

import fr.undev.linuxhacks.events.PacketEvent;
import fr.undev.linuxhacks.module.Module;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.network.play.client.CPacketChatMessage;
import net.minecraftforge.fml.common.gameevent.TickEvent;

/*
 * this is a fortnite sex squad clan reference
 */
public class EDITME extends Module {
    public EDITME(String name) {
        super(name);
    }


    @EventHandler
    public Listener<PacketEvent.Send> listener = new Listener<>(event -> {
        if (event.getPacket() instanceof CPacketChatMessage) {
            String msg = ((CPacketChatMessage) event.getPacket()).getMessage();
            if (msg.length() >= 256) msg = msg.substring(0, 256);
            ((CPacketChatMessage) event.getPacket()).message = msg;
        }
    });
    
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
