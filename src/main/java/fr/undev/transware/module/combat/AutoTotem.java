package fr.undev.transware.module.combat;

import fr.undev.transware.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.gameevent.TickEvent;

/*
 *
 */
public class AutoTotem extends Module {
    int totems;
    boolean moving = false;
    boolean returnI = false;

    public AutoTotem(String name) {
        super(name);
        this.getSettings().put("soft", "true");
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    @Override
    public void onTick(TickEvent.ClientTickEvent var1) {
        if (Minecraft.getMinecraft().currentScreen instanceof GuiContainer) return;
        if (returnI) {
            int t = -1;
            for (int i = 0; i < 45; i++)
                if (Minecraft.getMinecraft().player.inventory.getStackInSlot(i).isEmpty) {
                    t = i;
                    break;
                }
            if (t == -1) return;
            Minecraft.getMinecraft().playerController.windowClick(0, t < 9 ? t + 36 : t, 0, ClickType.PICKUP, Minecraft.getMinecraft().player);
            returnI = false;
        }
        totems = Minecraft.getMinecraft().player.inventory.mainInventory.stream().filter(itemStack -> itemStack.getItem() == Items.TOTEM_OF_UNDYING).mapToInt(ItemStack::getCount).sum();
        if (Minecraft.getMinecraft().player.getHeldItemOffhand().getItem() == Items.TOTEM_OF_UNDYING) totems++;
        else {
            if (Boolean.parseBoolean(this.getSettings().get("soft")) && !Minecraft.getMinecraft().player.getHeldItemOffhand().isEmpty) return;
            if (moving) {
                Minecraft.getMinecraft().playerController.windowClick(0, 45, 0, ClickType.PICKUP, Minecraft.getMinecraft().player);
                moving = false;
                if (!Minecraft.getMinecraft().player.inventory.itemStack.isEmpty()) returnI = true;
                return;
            }
            if (Minecraft.getMinecraft().player.inventory.itemStack.isEmpty()) {
                if (totems == 0) return;
                int t = -1;
                for (int i = 0; i < 45; i++)
                    if (Minecraft.getMinecraft().player.inventory.getStackInSlot(i).getItem() == Items.TOTEM_OF_UNDYING) {
                        t = i;
                        break;
                    }
                if (t == -1) return;
                Minecraft.getMinecraft().playerController.windowClick(0, t < 9 ? t + 36 : t, 0, ClickType.PICKUP, Minecraft.getMinecraft().player);
                moving = true;
            } else if (!Boolean.parseBoolean(this.getSettings().get("soft"))) {
                int t = -1;
                for (int i = 0; i < 45; i++)
                    if (Minecraft.getMinecraft().player.inventory.getStackInSlot(i).isEmpty) {
                        t = i;
                        break;
                    }
                if (t == -1) return;
                Minecraft.getMinecraft().playerController.windowClick(0, t < 9 ? t + 36 : t, 0, ClickType.PICKUP, Minecraft.getMinecraft().player);
            }
        }

    }
}
