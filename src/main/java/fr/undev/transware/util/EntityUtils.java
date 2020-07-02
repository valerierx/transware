package fr.undev.transware.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public class EntityUtils {
    public static boolean isLiving(Entity e) {
        return e instanceof EntityLivingBase;
    }
}
