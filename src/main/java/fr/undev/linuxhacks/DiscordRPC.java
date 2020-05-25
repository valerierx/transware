package fr.undev.linuxhacks;

import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRichPresence;
import net.minecraft.client.Minecraft;

import java.util.Objects;

import static net.arikia.dev.drpc.DiscordRPC.discordInitialize;

public class DiscordRPC {
    public static void initRPC() {
        DiscordEventHandlers handlers = new DiscordEventHandlers.Builder().setReadyEventHandler((user) -> {
            System.out.println("Welcome " + user.username + "#" + user.discriminator + ".");
        }).build();
        discordInitialize("714465951701008434", handlers, true);
    }
    public static void setStatus() {
        String ip = Minecraft.getMinecraft().getCurrentServerData().serverIP;

        if(Minecraft.getMinecraft().isIntegratedServerRunning()) {
            DiscordRichPresence rich = new DiscordRichPresence.Builder("Singleplayer").setDetails("i use linux.hacks btw").build();
        } else if (Minecraft.getMinecraft().getCurrentServerData() != null) {
            DiscordRichPresence rich = new DiscordRichPresence.Builder("Playing " + ip).setDetails("i use linux.hacks btw").build();
        } else {
            DiscordRichPresence rich = new DiscordRichPresence.Builder("chilling in main menu").setDetails("i use linux.hacks btw").build();
        }
    }
}
