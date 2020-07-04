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
public abstract class MixinItemRenderer {

    //TODO linux girl add instanc e stuff to main so i can make mixin and add no render and nohands and otehr coool cstuff like fov changer

}