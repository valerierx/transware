package fr.undev.transware.mixin.client;

import fr.undev.transware.Main;
import fr.undev.transware.event.FireOverlayEvent;
import fr.undev.transware.event.RenderArmEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.client.renderer.ItemRenderer;

@Mixin(ItemRenderer.class)
public abstract class MixinItemRenderer { /*

    @Inject(method = "renderFireInFirstPerson", at = @At("HEAD"), cancellable = true)
    public void onFirstPersonRenderFire(CallbackInfo ci) {
        FireOverlayEvent event = new FireOverlayEvent();
        Main.getInstance().postInit event
        if (event.isCancelled()) ci.cancel();
    }

    @Inject(method = "renderArmFirstPerson", at = @At("HEAD"), cancellable = true)
    public void onArmFirstPerson(CallbackInfo ci) {
        RenderArmEvent event = new RenderArmEvent();
        IngrosWare.INSTANCE.bus.fireEvent(event);
        if (event.isCancelled()) ci.cancel();
    } */
// how
}