package fr.undev.linuxhacks;

import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;

import java.time.Instant;
import java.util.Objects;

import static net.arikia.dev.drpc.DiscordRPC.discordInitialize;
import static net.minecraftforge.fml.common.network.FMLNetworkEvent.*;

public class LinuxRPC {
    public static void initRPC() {
        DiscordEventHandlers handlers = new DiscordEventHandlers.Builder().setReadyEventHandler((user) -> {
            System.out.println("Welcome " + user.username + "#" + user.discriminator + ".");
        }).build();
        discordInitialize("714465951701008434", handlers, true);
        DiscordRPC.discordRegister("714465951701008434", "");
        DiscordRichPresence rich = new DiscordRichPresence.Builder("main menu").setDetails("valve software sorce engine").setStartTimestamps(Instant.now().getEpochSecond()).setBigImage("arch", "twans wights!").build();
        DiscordRPC.discordUpdatePresence(rich);
    }

    @SubscribeEvent
    public void onJoin(ClientConnectedToServerEvent event) {
        DiscordRichPresence rich = new DiscordRichPresence.Builder("gaeming on " + Minecraft.getMinecraft().getCurrentServerData().serverIP).setStartTimestamps(Instant.now().getEpochSecond()).setBigImage("arch", "twans wights!").setDetails("we are turok!").build();
        DiscordRPC.discordUpdatePresence(rich);
    }

    @SubscribeEvent
    public void onLeave(ClientDisconnectionFromServerEvent event) {
        DiscordRichPresence rich = new DiscordRichPresence.Builder("main menu").setStartTimestamps(Instant.now().getEpochSecond()).setDetails("who dranked all the gender fluid").setBigImage("arch", "twans wights!").build();
        DiscordRPC.discordUpdatePresence(rich);
    }
}