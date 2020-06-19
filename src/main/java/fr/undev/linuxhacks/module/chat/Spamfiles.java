package fr.undev.linuxhacks.module.chat;

import fr.undev.linuxhacks.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.client.CPacketChatMessage;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Spamfiles extends Module {
    public Spamfiles(String name) {
        super(name);
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    @Override
    public void onTick(TickEvent.ClientTickEvent var1) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(Minecraft.getMinecraft().mcDataDir.getAbsolutePath() + "/Spamfile.txt"));
            String line = reader.readLine();
            while (line != null) {
                Minecraft.getMinecraft().getConnection().sendPacket(new CPacketChatMessage(line));
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
