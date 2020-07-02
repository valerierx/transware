package fr.undev.transware.handlers;

import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.time.Instant;

import static net.arikia.dev.drpc.DiscordRPC.discordInitialize;
import static net.minecraftforge.fml.common.network.FMLNetworkEvent.*;

public class RPCHandler {
    private static String getSmallImage() {
        switch(Minecraft.getMinecraft().getSession().getUsername()) {
            case "lindseyontop_":
                return "lindsey";
            case "iusearchbtw_":
                return "linux";
            case "whollow":
                return "ingrosware";
            case "_ph":
                return "_ph";
            case "NekoPvP":
                return "nekopvp";
            case "PointZero_":
                return "xivman";
            case "1zb":
                return "chardnolet";
            case "XplodingFace":
                return "xplodingface";
            case "iZeroTwo_":
                return "nekopvp";
            case "molfernus":
                return "molfernus";
            case "ICHARDNOL99":
                return "chardnolet";
            case "Weaknessfag":
                return "_ph";
            case "cchard":
                return "peeman42";
        }
        return "nn";
    }
    public static void initRPC() {
        DiscordEventHandlers handlers = new DiscordEventHandlers.Builder().setReadyEventHandler((user) -> {
            System.out.println("Welcome " + user.username + "#" + user.discriminator + ".");
        }).build();
        discordInitialize("714465951701008434", handlers, true);
        DiscordRPC.discordRegister("714465951701008434", "");
        DiscordRichPresence rich = new DiscordRichPresence.Builder("main menu").setDetails("valve software sorce engine").setStartTimestamps(Instant.now().getEpochSecond()).setSmallImage(getSmallImage(), Minecraft.getMinecraft().getSession().getUsername()).setBigImage("arch", "twans wights!").build();
        DiscordRPC.discordUpdatePresence(rich);
    }

    @SubscribeEvent
    public void onJoin(ClientConnectedToServerEvent event) {
        DiscordRichPresence rich = new DiscordRichPresence.Builder("gaeming on " + Minecraft.getMinecraft().getCurrentServerData().serverIP).setStartTimestamps(Instant.now().getEpochSecond()).setSmallImage(getSmallImage(), Minecraft.getMinecraft().getSession().getUsername()).setBigImage("arch", "twans wights!").setDetails("we are turok!").build();
        DiscordRPC.discordUpdatePresence(rich);
    }

    @SubscribeEvent
    public void onLeave(ClientDisconnectionFromServerEvent event) {
        DiscordRichPresence rich = new DiscordRichPresence.Builder("main menu").setSmallImage(getSmallImage(), Minecraft.getMinecraft().getSession().getUsername()).setStartTimestamps(Instant.now().getEpochSecond()).setDetails("i use arch btw").setBigImage("arch", "twans wights!").build();
        DiscordRPC.discordUpdatePresence(rich);
    }

}
