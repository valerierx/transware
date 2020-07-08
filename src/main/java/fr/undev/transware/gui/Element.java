package fr.undev.transware.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.ResourceLocation;

public class Element {
    protected final String name;

    protected float posX;

    protected float posY;

    protected final float width;

    protected final float height;

    protected boolean dragging;

    protected boolean extended;

    public final FontRenderer fontRenderer = new FontRenderer(Minecraft.getMinecraft().gameSettings, new ResourceLocation("textures/font/ascii.png"), Minecraft.getMinecraft().renderEngine, false);

    public Element(String name, float posX, float posY, float width, float height) {
        this.name = name;
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
    }

    public void render(int mouseX, int mouseY) {
    }

    public void onMouseClicked(int mouseX, int mouseY, int mouseButton) {
    }

    public void onMouseReleased(int mouseX, int mouseY, int mouseButton) {
    }

    public void move(float posX, float posY) {
    }

    public String getName() {
        return this.name;
    }

    public float getWidth() {
        return this.width;
    }

    public float getHeight() {
        return this.height;
    }

    public float getPosX() {
        return this.posX;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public float getPosY() {
        return this.posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }

    public boolean isDragging() {
        return this.dragging;
    }

    public void setDragging(boolean dragging) {
        this.dragging = dragging;
    }

    public boolean isExtended() {
        return this.extended;
    }

    public void setExtended(boolean extended) {
        this.extended = extended;
    }

    public boolean mouseWithinElement(int mouseX, int mouseY) {
        return (mouseX >= this.getPosX() && mouseX <= this.getPosX() + this.getWidth() && mouseY >= this.getPosY() && mouseY <= this.getPosY() + this.getHeight());
    }
}