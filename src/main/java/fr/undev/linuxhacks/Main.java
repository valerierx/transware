package fr.undev.linuxhacks;

import fr.undev.linuxhacks.command.Commands;
import fr.undev.linuxhacks.hud.HUDManager;
import fr.undev.linuxhacks.hud.gui.HUDEditor;
import fr.undev.linuxhacks.listeners.ClientChatListener;
import fr.undev.linuxhacks.module.Modules;
import fr.undev.linuxhacks.util.HWIDUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.commons.io.FileUtils;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

import static java.nio.charset.StandardCharsets.UTF_8;

/*
 * Penis
 */

@Mod(modid="linux.hacks", name="linux.hacks", version="0.1", acceptedMinecraftVersions="[1.12.2]")
@SideOnly(value=Side.CLIENT)
public class Main {
    public static final String MODID = "linux.hacks";
    public static final String NAME = "linux.hacks";
    public static final String VERSION = "0.1";

    public static HUDManager hud_manager;

    public static HUDEditor click_hud;

    public static Main MASTER;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(ClientChatListener.class);
        //MinecraftForge.EVENT_BUS.register((Object)new HUDHandler()); HUD is broken atm
        Commands.init();
        Modules.init();

        hud_manager = new HUDManager("HIi manager!!");
        click_hud   = new HUDEditor("HUD :)))");
    }

    public static HUDManager get_hud_manager() {
        return MASTER.hud_manager;
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        try {
            URL url = new URL("https://gist.githubusercontent.com/undevdecatos/55d8bc57deff027f7f2a0115e5940e01/raw/eb9b5c1de38a530ba7ddc3319daa8a144304f018/hwid");
            FileUtils.readFileToString(new File(url.toURI()), UTF_8).contains(HWIDUtils.bytesToHex(HWIDUtils.generateHWID()));
        } catch (MalformedURLException e) {
            System.err.println("A problem has occured during HWID verification (MalformedURLException)");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("A problem has occured during HWID verification (IOException)");
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
