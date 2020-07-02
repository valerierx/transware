package fr.undev.transware.module.chat;

import fr.undev.transware.module.Module;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Welcomer extends Module {
    public Welcomer(String name) {
        super(name);
    }

    @Override
    public void onEnable() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void onDisable() {
        MinecraftForge.EVENT_BUS.unregister(this);
    }

    @Override
    public void onTick(TickEvent.ClientTickEvent var1) {

    }
    @SubscribeEvent
    public void onPlayerJoin(EntityJoinWorldEvent event) {
        System.out.println(event.getEntity().getDisplayName().getFormattedText());
        //Minecraft.getMinecraft().getConnection().sendPacket(new CPacketChatMessage(event.getEntity().getDisplayName().getFormattedText()));
    }
}
