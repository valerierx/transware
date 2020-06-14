package fr.undev.linuxhacks.module.chat;

import fr.undev.linuxhacks.module.Module;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import net.minecraft.client.Minecraft;
import net.minecraft.network.play.client.CPacketChatMessage;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class AnnouncerModule extends Module {
    public AnnouncerModule(String name) {
        super(name);
        this.getSettings().put("delay", "5");
        this.getSettings().put("prefix", "#TransRights");
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    @Override
    public void onTick(TickEvent.ClientTickEvent penis) {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 25 + 1);
        int randomAction = ThreadLocalRandom.current().nextInt(1, 2 + 1);
        switch(randomAction){
            case 1 :
                Minecraft.getMinecraft().getConnection().sendPacket(new CPacketChatMessage(this.getSettings().get("prefix") + " I just walked " + randomNum + " meters!"));
                break;
            case 2 :
                Minecraft.getMinecraft().getConnection().sendPacket(new CPacketChatMessage(this.getSettings().get("prefix") + " I just placed " + randomNum + " blocks!"));
                break;
        }
        try {
            Thread.sleep(Long.parseLong(this.getSettings().get("delay")));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
