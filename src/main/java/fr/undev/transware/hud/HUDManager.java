package fr.undev.transware.hud;

// Util.
import java.util.*;

// HUD.
import fr.undev.transware.huds.*;

// Main.


/**
 *
 * Created byyy Rina :))!!!
 *
 * @since 07/06/2020.
 *
 **/
public class HUDManager {
	private String tag;

	private ArrayList<HUD> array_hud;

	public HUDManager(String tag) {
		this.tag       = tag;
		this.array_hud = new ArrayList<>();

		add_hud_component(new HUDWelcome());
	}

	public void add_hud_component(HUD hud) {
		array_hud.add(hud);
	}

	public ArrayList<HUD> get_array_huds() {
		return this.array_hud;
	}

	public void render() {
		for (HUD huds : get_array_huds()) {
			if (huds.is("open")) {
				huds.render();
			}
		}
	}

	public HUD get_hud_with_tag(String tag) {
		HUD hud_requested = null;

		for (HUD huds : get_array_huds()) {
			if (huds.get_tag().equalsIgnoreCase(tag)) {
				hud_requested = huds;
			}
		}

		return hud_requested;
	}

	public String get_tag() {
		return this.tag;
	}
}
