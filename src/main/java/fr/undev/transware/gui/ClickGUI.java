package fr.undev.transware.gui;

import fr.undev.transware.gui.frame.Frame;
import net.minecraft.client.gui.GuiScreen;

import java.io.IOException;
import java.util.ArrayList;

public class ClickGUI extends GuiScreen {
    private final ArrayList<Frame> frames = new ArrayList<>();

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        getFrames().forEach(frame -> frame.render(mouseX, mouseY));
    }

    public ArrayList<Frame> getFrames() {
        return this.frames;
    }

    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        super.mouseClicked(mouseX, mouseY, mouseButton);
        getFrames().forEach(frame -> frame.onMouseClicked(mouseX, mouseY, mouseButton));
    }

    protected void mouseReleased(int mouseX, int mouseY, int mouseButton) {
        super.mouseReleased(mouseX, mouseY, mouseButton);
        getFrames().forEach(frame -> frame.onMouseReleased(mouseX, mouseY, mouseButton));
    }
}