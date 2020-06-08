package fr.undev.linuxhacks.hud.gui;

import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import java.util.*;
import java.io.*;

// HUD.
import fr.undev.linuxhacks.hud.HUD;

// Main.
import fr.undev.linuxhacks.Main;

	/*  Bla 07/06/2020. By Rina bla bla...
	* Bla  b
Bla 	*/
public class HUDEditor extends GuiScreen {
	public HUDEditor(String tag) {}

	@Override
	protected void mouseClicked(int mx, int my, int mouse) {
		for (HUD huds : Main.get_hud_manager().get_array_huds()) {
			if (huds.is("open")) {
				huds.click(mx, my);
			}
		}
	}

	@Override
	protected void mouseReleased(int mx, int my, int state) {
		for (HUD huds : Main.get_hud_manager().get_array_huds()) {
			if (huds.is("open")) {
				huds.release(mx, my);
			}
		}
	}

	@Override
	public void drawScreen(int mx, int my, float tick) {
		// For draw backscreen.
		this.drawDefaultBackground();

		// To render frames.
		for (HUD huds : Main.get_hud_manager().get_array_huds()) {
			if (huds.is("open")) {
				huds.render(mx, my);
			}
		}
	}
}