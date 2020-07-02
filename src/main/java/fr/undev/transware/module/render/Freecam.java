package fr.undev.transware.module.render;

import fr.undev.transware.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.PlayerSPPushOutOfBlocksEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Freecam extends Module {
    private double posX, posY, posZ;
    private float pitch, yaw;

    private EntityOtherPlayerMP clonedPlayer;

    private boolean isRidingEntity;
    private Entity ridingEntity;

    public Freecam(String name) {
        super(name);
        this.getSettings().put("speed", "5");
    }


    @Override
    public void onEnable() {
        MinecraftForge.EVENT_BUS.register(this);
        if (Minecraft.getMinecraft().player != null) {
            isRidingEntity = Minecraft.getMinecraft().player.getRidingEntity() != null;

            if (Minecraft.getMinecraft().player.getRidingEntity() == null) {
                posX = Minecraft.getMinecraft().player.posX;
                posY = Minecraft.getMinecraft().player.posY;
                posZ = Minecraft.getMinecraft().player.posZ;
            } else {
                ridingEntity = Minecraft.getMinecraft().player.getRidingEntity();
                Minecraft.getMinecraft().player.dismountRidingEntity();
            }

            pitch = Minecraft.getMinecraft().player.rotationPitch;
            yaw = Minecraft.getMinecraft().player.rotationYaw;

            clonedPlayer = new EntityOtherPlayerMP(Minecraft.getMinecraft().world, Minecraft.getMinecraft().getSession().getProfile());
            clonedPlayer.copyLocationAndAnglesFrom(Minecraft.getMinecraft().player);
            clonedPlayer.rotationYawHead = Minecraft.getMinecraft().player.rotationYawHead;
            Minecraft.getMinecraft().world.addEntityToWorld(-100, clonedPlayer);
            Minecraft.getMinecraft().player.capabilities.isFlying = true;
            Minecraft.getMinecraft().player.capabilities.setFlySpeed(Float.parseFloat(this.getSettings().get("speed")) / 100f);
            Minecraft.getMinecraft().player.noClip = true;
        }
    }

    @Override
    public void onDisable() {
        EntityPlayer localPlayer = Minecraft.getMinecraft().player;
        if (localPlayer != null) {
            Minecraft.getMinecraft().player.setPositionAndRotation(posX, posY, posZ, yaw, pitch);
            Minecraft.getMinecraft().world.removeEntityFromWorld(-100);
            clonedPlayer = null;
            posX = posY = posZ = 0.D;
            pitch = yaw = 0.f;
            Minecraft.getMinecraft().player.capabilities.isFlying = false; //getModManager().getMod("ElytraFlight").isEnabled();
            Minecraft.getMinecraft().player.capabilities.setFlySpeed(0.05f);
            Minecraft.getMinecraft().player.noClip = false;
            Minecraft.getMinecraft().player.motionX = Minecraft.getMinecraft().player.motionY = Minecraft.getMinecraft().player.motionZ = 0.f;

            if (isRidingEntity) {
                Minecraft.getMinecraft().player.startRiding(ridingEntity, true);
            }
        }
        MinecraftForge.EVENT_BUS.unregister(this);
    }

    @Override
    public void onTick(TickEvent.ClientTickEvent var1) {
        Minecraft.getMinecraft().player.capabilities.isFlying = true;
        Minecraft.getMinecraft().player.capabilities.setFlySpeed(Float.parseFloat(this.getSettings().get("speed")) / 100f);
        Minecraft.getMinecraft().player.noClip = true;
        Minecraft.getMinecraft().player.onGround = false;
        Minecraft.getMinecraft().player.fallDistance = 0;
    }

    @SubscribeEvent
    public void onPlayerSPPushOutOfBlocks(PlayerSPPushOutOfBlocksEvent event) {
        event.setCanceled(true);
    }
}
