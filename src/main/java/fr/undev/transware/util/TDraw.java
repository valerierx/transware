package fr.undev.transware.util;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

import java.awt.*;

/**
 *
 * Created byyy Rina :))!!!
 *
 * @since 07/06/2020.
 *
 **/
public class TDraw {
	private static FontRenderer font_renderer = Minecraft.getMinecraft().fontRenderer;

	public static void draw_rect(int x, int y, int width, int height, int r, int g, int b, int a) {
		Gui.drawRect(x, y, width, height, new TurokColor(r, g, b, a).hex());
	}

	public static void draw_string(String string, boolean shadow, int x, int y, int r, int g, int b) {
		if (shadow) {
			font_renderer.drawStringWithShadow(string, x, y, new TurokColor(r, g, b).hex());
		} else {
			font_renderer.drawString(string, x, y, new TurokColor(r, g, b).hex());	
		}
	}

	public static int get_font_width(String string, int size) {
		FontRenderer fontRenderer = font_renderer;

		return (int) (fontRenderer.getStringWidth(string) * size);
	}

	public static int get_font_height(String string, int size) {
		FontRenderer fontRenderer = font_renderer;

		return (int) (fontRenderer.FONT_HEIGHT * size);
	}

	public static class TurokColor extends Color {
		public TurokColor(int r, int g, int b, int a) {
			super(r, g, b, a);
		}

		public TurokColor(int r, int g, int b) {
			super(r, g, b);
		}

		public int hex() {
			return getRGB();
		}
	}
}