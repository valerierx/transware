package fr.undev.transware.hud;

import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

// List.

// Draw,
import fr.undev.transware.util.TDraw;

/**
 *
 * Created byyy Rina :))!!!
 *
 * @since 07/06/2020.
 *
 **/
public class HUD {
	private String name;
	private String tag;

	private int x;
	private int y;

	private int width;
	private int height;

	private boolean event_mouse_pass;
	private boolean event_mouse_click;

	private boolean state;

	public HUD(String name, String tag, int x, int y) {
		this.name = name;
		this.tag  = tag;

		this.x = x;
		this.y = y;

		this.width  = 0;
		this.height = 0;

		this.state = false;
	}

	public void verify(String string, int x, int y) {
		if (x + get_font_width(string) >= get_x() + get_width()) {
			set_width(x + get_font_width(string) + 2);
		}

		if (y + get_font_height(string) >= get_y() + get_height()) {
			set_height(y + get_font_height(string) + 2);
		}
	}

	public void set_state(boolean value) {
		this.state = value;
	}

	public void set_x(int value) {
		this.x = value;
	}

	public void set_y(int value) {
		this.y = value;
	}

	public void set_width(int value) {
		this.width = value;
	}

	public void set_height(int value) {
		this.height = value;
	}

	public String get_name() {
		return this.name;
	}

	public String get_tag() {
		return this.tag;
	}

	// :((
	public boolean event_mouse(String type) {
		if (type.equalsIgnoreCase("pass")) {
			return this.event_mouse_pass;
		} else if (type.equalsIgnoreCase("click")) {
			return this.event_mouse_click;
		} else {
			return false;
		}
	}

	// :))).
	public boolean is(String type) {
		if (type.equalsIgnoreCase("open")) {
			return this.state;
		}

		return false;
	}

	public int get_x() {
		return this.x;
	}

	public int get_y() {
		return this.y;
	}

	public int get_width() {
		return this.width;
	}

	public int get_height() {
		return this.height;
	}

	public boolean passing(int mx, int my) {
		if (mx >= get_x() && my >= get_y() && mx <= get_x() + get_width() && my <= get_y() + get_height()) {
			return true;
		}

		return false;
	}

	public void click(int mx, int my) {}
	public void release(int mx, int my) {}

	// GUI.
	public void render(int mx, int my) {
		if (passing(mx, my) && is("open")) {
			this.event_mouse_pass = true;
		} else if (is("open")) {
			this.event_mouse_pass = false;
		}

		if (event_mouse("pass") && is("open")) {
			create(0, 0, get_width(), get_height(), 255, 255, 255, 10);
		}

		if (is("open")) {
			render();

			GL11.glPushMatrix();

			GL11.glEnable(GL11.GL_TEXTURE_2D);
			GL11.glEnable(GL11.GL_BLEND);

			GlStateManager.enableBlend();

			GL11.glPopMatrix();
		}
	}

	// Override.
	public void render() {}

	// Functions.
	protected void create(int x, int y, int width, int height, int r, int g, int b, int a) {
		TDraw.draw_rect(get_x() + x, get_y() + y, get_x() + width, get_y() + height, r, g, b, a);
	}

	protected void create(String string, boolean shadow, int x, int y, int r, int g, int b) {
		TDraw.draw_string(string, shadow, get_x() + y, get_x() + y, r, g, b);

		verify(string, x, y);
	}

	protected void create(String string, int x, int y, int r, int g, int b) {
		TDraw.draw_string(string, false, get_x() + y, get_x() + y, r, g, b);

		verify(string, x, y);
	}

	protected int get_font_width(String string) {
		return TDraw.get_font_width(string, 1); // 1.0 == font size.
	}

	protected int get_font_height(String string) {
		return TDraw.get_font_height(string, 1);
	}
}