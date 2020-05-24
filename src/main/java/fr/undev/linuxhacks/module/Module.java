package fr.undev.linuxhacks.module;

import java.util.HashMap;
import java.util.LinkedHashMap;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;

public abstract class Module {
	private final String displayName;
	private final LinkedHashMap<String, String> settings;
	private String id;
	protected static final Minecraft mc = Minecraft.getMinecraft();
	
	public Module(String name) {
		this.displayName = name;
		this.settings = new LinkedHashMap<>();
	}
	
	public abstract void onEnable();
	
	public abstract void onDisable();
	
	public abstract void onTick(ClientTickEvent event);

	public String getDisplayName() {
		return displayName;
	}

	public HashMap<String, String> getSettings() {
		return settings;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}

