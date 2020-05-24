package fr.undev.linuxhacks;

import fr.undev.linuxhacks.command.Commands;
import fr.undev.linuxhacks.events.HUDHandler;
import fr.undev.linuxhacks.friends.Friends;
import fr.undev.linuxhacks.listeners.ClientChatListener;
import fr.undev.linuxhacks.module.Modules;
import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.IOException;

@Mod(modid="linux.hacks", name="linux.hacks", version="0.1", acceptedMinecraftVersions="[1.12.2]")
@SideOnly(value=Side.CLIENT)
	public class Main {
	    public static final String MODID = "linux.hacks";
	    public static final String NAME = "linux.hacks";
	    public static final String VERSION = "0.1";
	    @Mod.EventHandler
	    public void init(FMLInitializationEvent event) {
			MinecraftForge.EVENT_BUS.register(ClientChatListener.class);
			MinecraftForge.EVENT_BUS.register(new HUDHandler());
			Commands.init();
			//Friends.init(); broken atm
			Modules.init();

		}
		
		@Mod.EventHandler
		public void postInit(FMLPostInitializationEvent event) {
			DiscordEventHandlers handlers = new DiscordEventHandlers.Builder().setReadyEventHandler((user) -> {
				System.out.println("Welcome " + user.username + "#" + user.discriminator + ".");
			}).build();
			DiscordRPC.discordInitialize("soon", handlers, true);
	    }
	}
	
