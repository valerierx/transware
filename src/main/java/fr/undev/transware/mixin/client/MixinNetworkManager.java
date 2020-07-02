package fr.undev.transware.mixin.client;

import fr.undev.transware.event.PacketRecieved;
import fr.undev.transware.event.PacketSent;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Created by linux!!
 *
 * @since 02/07/2020
 **/

@Mixin(NetworkManager.class)
public class MixinNetworkManager {
    @Inject(method = "sendPacket(Lnet/minecraft/network/Packet;)V", at = @At("HEAD"), cancellable = true)
    private void onSendPacket(Packet<?> packet, CallbackInfo callbackInfo)
    {
        PacketSent event = new PacketSent(packet);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled() && callbackInfo.isCancellable())
        {
            callbackInfo.cancel();
        }
        packet = event.getPacket();
    }

    @Inject(method = "channelRead0", at = @At("HEAD"), cancellable = true)
    private void onChannelRead(ChannelHandlerContext context, Packet<?> packet, CallbackInfo callbackInfo)
    {
        PacketRecieved event = new PacketRecieved(packet);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled() && callbackInfo.isCancellable())
        {
            callbackInfo.cancel();
        }
        packet = event.getPacket();
    }
}
