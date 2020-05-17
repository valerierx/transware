package fr.undev.linuxhacks.events;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import fr.undev.linuxhacks.hud.HUD;
public class HUDHandler {
    @SubscribeEvent
    public void onRenderGui(RenderGameOverlayEvent.Post event) {
        if (event.getType() != RenderGameOverlayEvent.ElementType.EXPERIENCE) { return; }
        new HUD(Minecraft.getMinecraft());
    }
}
