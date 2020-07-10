package fr.undev.transware.gui.component.settings;

import fr.undev.transware.gui.component.Component;
import net.minecraft.client.gui.Gui;

import java.awt.*;

public class StringSettingComponent extends Component {
    public StringSettingComponent(String setting, float posX, float posY, float offset, float width, float height) {
        super(setting, posX, posY, offset, width, height);
    }

    public void drawComponent(int mouseX, int mouseY, float partialTicks) {
        super.drawComponent(mouseX, mouseY, partialTicks);
        Gui.drawRect((int) getPosX(), (int) (getPosY()+getOffset()), (int) (getPosX()+getWidth()), (int) (getPosY()+getOffset()+getHeight()), new Color(50, 50, 50, 200).getRGB()); // TODO: make renderutil that uses floats
        fontRenderer.drawStringWithShadow(getName(), (getPosX() + 5.0F), (getPosY() + getHeight() / 2.0F - (fontRenderer.FONT_HEIGHT)), -1);
    }
}
