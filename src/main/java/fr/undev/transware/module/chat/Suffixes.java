package fr.undev.transware.module.chat;

import fr.undev.transware.command.Commands;
import fr.undev.transware.event.PacketSent;
import fr.undev.transware.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.client.CPacketChatMessage;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

/*
 * EDIT ME
 * this is a fortnite sex squad clan reference
 */
public class Suffixes extends Module {
    public Suffixes(String name) {
        super(name);
    }
    @Override
    public void onEnable() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void onDisable() {
        MinecraftForge.EVENT_BUS.unregister(this);
    }

    @Override
    public void onTick(TickEvent.ClientTickEvent event) {
    }

    @SubscribeEvent
    public void onPacketSent(PacketSent event) {
        if (event.getPacket() instanceof CPacketChatMessage) {
            String message = ((CPacketChatMessage) event.getPacket()).getMessage();
            if(!message.startsWith(Commands.getPrefix()) && !message.startsWith("/")){
                message += " | ᴛʀᴀɴꜱᴡᴀʀᴇ";
                if (message.length() >= 256) message = message.substring(0,256);
                ((CPacketChatMessage) event.getPacket()).message = message;

            }
        }
    }
}
