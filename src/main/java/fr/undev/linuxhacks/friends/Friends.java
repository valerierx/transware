package fr.undev.linuxhacks.friends;

import net.minecraft.client.Minecraft;
import fr.undev.linuxhacks.util.UUIDUtils;
import java.io.*;
/*
 * Created by linux
 */
public class Friends {
    private static final String friends = Minecraft.getMinecraft().mcDataDir.getPath() + "/linuxfriends.txt";

    public static void init() throws IOException {
        File file = new File(friends);
         if(file.exists()) {
             FileReader in = new FileReader(friends);
         } else {
             file.createNewFile();
         }
    }

    public static void write(String username) throws IOException {
        FileWriter fw = new FileWriter(friends);
        String UUID = UUIDUtils.getUUID(username);
        fw.write(UUID);
        fw.close();
    }
    public static String read(String uuid) throws IOException {
        FileReader in = new FileReader(friends);
        String name = UUIDUtils.getName(uuid);
        return name;
    }
}
