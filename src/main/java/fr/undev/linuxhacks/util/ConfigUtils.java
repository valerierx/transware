package fr.undev.linuxhacks.util;

import java.io.File;
import java.io.IOException;
import org.ini4j.*;
import net.minecraft.client.Minecraft;

public class ConfigUtils {
	//Made by linux, big thanks to the folks at ini4j!
	
	private String configPath = Minecraft.getMinecraft().mcDataDir.getPath() + "/linuxdothacks.ini";
	
	public String getSetting(String module, String setting) throws InvalidFileFormatException, IOException {
		 Wini ini = new Wini(new File(configPath));
	     return ini.get(module, setting);
	}

	
	public void writeStringSetting(String module, String setting, String data) throws InvalidFileFormatException, IOException {
		Wini ini = new Wini(new File(configPath));
		ini.put(module, setting, data);
	}
	public void writeBooleanSetting(String module, String setting, Boolean data) throws InvalidFileFormatException, IOException {
		Wini ini = new Wini(new File(configPath));
		ini.put(module, setting, data);
	}
	public void writeIntSetting(String module, String setting, Integer data) throws InvalidFileFormatException, IOException {
		Wini ini = new Wini(new File(configPath));
		ini.put(module, setting, data);
	}
	
}