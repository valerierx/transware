package fr.undev.transware.module.chat;

import fr.undev.transware.module.Module;
import java.util.concurrent.ThreadLocalRandom;

import net.minecraft.client.Minecraft;
import net.minecraft.network.play.client.CPacketChatMessage;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class AnnouncerModule extends Module {
    public AnnouncerModule(String name) {
        super(name);
        this.getSettings().put("delay", "5");
        this.getSettings().put("prefix", "#TwansWights");
    }
    long startTime = 0;

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

        if (startTime + (Integer.parseInt(this.getSettings().get("delay")) * 1000) <= System.currentTimeMillis()) {
            startTime = System.currentTimeMillis();
            switch(randomAction){
                case 1 :
                    Minecraft.getMinecraft().getConnection().sendPacket(new CPacketChatMessage(this.getSettings().get("prefix") + " I just walked " + randomNum + " meters!"));
                    break;
                case 2 :
                    Minecraft.getMinecraft().getConnection().sendPacket(new CPacketChatMessage(this.getSettings().get("prefix") + " I just placed " + randomNum + " blocks!"));
                    break;
            }
        }

    }
}
