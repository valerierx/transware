package fr.undev.transware.gui.frame;

import fr.undev.transware.gui.Element;
import fr.undev.transware.gui.component.Component;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;

import java.util.ArrayList;

/*
Each Frame contains components
Each Frame can be extended (shows components) or not
If Frame is extended, each component rendered with Y offset
Left-clicking on Frame drags it (and components if extended)
Right-clicking of Frame toggles if it's extended or not
*/
public class Frame extends Element {
    private final ArrayList<Component> components = new ArrayList<>();

    // Keeps track of position during previous tick, makes moving code cleaner
    protected float prevPosX;
    protected float prevPosY;

    public Frame(String name, float posX, float posY, float width, float height) {
        super(name, posX, posY, width, height);
    }

    public void initialize() {
        this.components.forEach(Component::initialize);
    }

    public void move(float posX, float posY) {
        this.components.forEach(component -> component.move(posX, posY));
    }

    public void render(int mouseX, int mouseY) {
        ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
        if (isDragging()) {
            setPosX(mouseX + getPrevPosX());
            setPosY(mouseY + getPrevPosY());
            getComponents().forEach(component -> component.move(getPosX(), getPosY()));
        }
        if (getPosX() < 0.0F) {
            setPosX(0.0F);
            getComponents().forEach(component -> component.move(getPosX(), getPosY()));
        }
        if (getPosX() + getWidth() > scaledResolution.getScaledWidth()) {
            setPosX(scaledResolution.getScaledWidth() - getWidth());
            getComponents().forEach(component -> component.move(getPosX(), getPosY()));
        }
        if (getPosY() < 0.0F) {
            setPosY(0.0F);
            getComponents().forEach(component -> component.move(getPosX(), getPosY()));
        }
        if (getPosY() + getHeight() > scaledResolution.getScaledHeight()) {
            setPosY(scaledResolution.getScaledHeight() - getHeight());
            getComponents().forEach(component -> component.move(getPosX(), getPosY()));
        }
    }

    public ArrayList<Component> getComponents() {
        return this.components;
    }

    public void onMouseClicked(int mouseX, int mouseY, int mouseButton) {
        if (mouseWithinElement(mouseX, mouseY)) {
            if (mouseButton == 0) {
                setDragging(true);
                setPrevPosX(getPosX() - mouseX);
                setPrevPosY(getPosX() - mouseY);
            } if (mouseButton == 1) {
                setExtended(!isExtended());
            }
        }
    }

    public void onMouseReleased(int mouseX, int mouseY, int mouseButton) {
        if (mouseButton == 0 && isDragging())
            setDragging(false);
        if (isExtended())
            getComponents().forEach(component -> component.onMouseReleased(mouseX, mouseY, mouseButton));
    }

    public float getPrevPosX() {
        return this.prevPosX;
    }

    public void setPrevPosX(float prevPosX) {
        this.prevPosX = prevPosX;
    }

    public float getPrevPosY() {
        return this.prevPosY;
    }

    public void setPrevPosY(float prevPosY) {
        this.prevPosY = prevPosY;
    }
}