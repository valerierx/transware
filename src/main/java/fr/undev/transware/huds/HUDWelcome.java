package fr.undev.transware.huds;

// HUD.
import fr.undev.transware.hud.HUD;
import net.minecraft.client.Minecraft;

/**
 *
 * Created byyy Rina :))!!!
 *
 * @since 07/06/2020.
 *
 **/
public class HUDWelcome extends HUD {
	public HUDWelcome() {
		super("Welcome", "Welcome", 10, 10);

		set_state(true);
	}

	@Override
	public void render() {
		String huh = "hii :^) welcome uwu" + Minecraft.getMinecraft().getSession().getUsername(); //uwufied it

		create(huh, 10, 10, 255, 255, 255);
	}
}
