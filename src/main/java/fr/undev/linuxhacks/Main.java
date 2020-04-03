package fr.undev.linuxhacks;

import fr.undev.linuxhacks.command.Commands;
import fr.undev.linuxhacks.listeners.ClientChatListener;
import fr.undev.linuxhacks.module.Modules;
import fr.undev.linuxhacks.util.ConfigUtils;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid="linux.hacks", name="linux.hacks", version="0.1", acceptedMinecraftVersions="[1.12.2]")
@SideOnly(value=Side.CLIENT)
	public class Main {
	    public static final String MODID = "linux.hacks";
	    public static final String NAME = "linux.hacks";
	    public static final String VERSION = "0.1";
	    @Mod.EventHandler
	    public void init(FMLInitializationEvent event) {
	        MinecraftForge.EVENT_BUS.register(ClientChatListener.class);
	        Commands.init();
	        
	        Modules.init();
	    }
	}

