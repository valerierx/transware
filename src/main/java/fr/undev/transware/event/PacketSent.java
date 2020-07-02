package fr.undev.transware.event;

import net.minecraft.network.Packet;
import net.minecraftforge.fml.common.eventhandler.Event;

/**
 * Created by linux!!
 *
 * @since 02/07/2020
 **/

public class PacketSent extends Event {
    private Packet<?> packet;

    public PacketSent(Packet<?> packet) {
        this.packet = packet;
    }

    public final Packet<?> getPacket() {
        return this.packet;
    }


    public final Packet<?> setPacket(Packet<?> packet) {
        return this.packet = packet;
    }
}
