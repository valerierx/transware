package fr.undev.transware.module.combat;


import fr.undev.transware.module.Module;
import fr.undev.transware.util.EntityUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.Iterator;

import static java.lang.Float.parseFloat;

public class Aura extends Module {
    public Aura(String name) {
        super(name);
        this.getSettings().put("range", "4.5");
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    @Override
    public void onTick(TickEvent.ClientTickEvent var1) {
        if (Minecraft.getMinecraft().player.isDead) {
            return;
        }

        if (Minecraft.getMinecraft().player.ticksExisted % 2 != 0) {
            return;
        }

        Iterator<Entity> entityIterator = Minecraft.getMinecraft().world.loadedEntityList.iterator();
        while (entityIterator.hasNext()) {
            Entity target = entityIterator.next();
            if (!EntityUtils.isLiving(target)) {
                continue;
            }
            if (target == Minecraft.getMinecraft().player) {
                continue;
            }
            if (Minecraft.getMinecraft().player.getDistance(target) > parseFloat(this.getSettings().get("range"))) {
                continue;
            }
            if (((EntityLivingBase) target).getHealth() <= 0) {
                continue;
            }
            if (((EntityLivingBase) target).hurtTime != 0) {
                continue;
            }
            if ((!Minecraft.getMinecraft().player.canEntityBeSeen(target) && !canEntityFeetBeSeen(target))) {
                continue;
            }
            if (target instanceof EntityPlayer) {
                attack(target);
                return;
            }
        }

    }


    private void attack(Entity e) {
        int newslot = -1;
        for (int i = 0; i < 9; i++) {
            ItemStack stack = Minecraft.getMinecraft().player.inventory.getStackInSlot(i);
            if (stack == ItemStack.EMPTY) {
                continue;
            }

            if (newslot != -1) {
                Minecraft.getMinecraft().player.inventory.currentItem = newslot;
            }

        }
        Minecraft.getMinecraft().playerController.attackEntity(Minecraft.getMinecraft().player, e);
        Minecraft.getMinecraft().player.swingArm(EnumHand.MAIN_HAND);

    }

    private boolean canEntityFeetBeSeen(Entity entityIn) {
        return Minecraft.getMinecraft().world.rayTraceBlocks(new Vec3d(Minecraft.getMinecraft().player.posX, Minecraft.getMinecraft().player.posY + Minecraft.getMinecraft().player.getEyeHeight(), Minecraft.getMinecraft().player.posZ), new Vec3d(entityIn.posX, entityIn.posY, entityIn.posZ), false, true, false) == null;
    }
}

