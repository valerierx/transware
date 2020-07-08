package fr.undev.transware.gui.component;

import fr.undev.transware.gui.Element;

public class Component extends Element {
    private float offset;

    public Component(String label, float posX, float posY, float offset, float width, float height) {
        super(label, posX, posY+offset, width, height);
        this.offset = offset;
    }

    public void initialize() {
    }

    public void move(float posX, float posY) {
        setPosX(posX);
        setPosY(posY+offset);
    }

    private float getOffset() {
        return this.offset;
    }
}