package fr.undev.linuxhacks.module.test;

import fr.undev.linuxhacks.module.Module;
import fr.undev.linuxhacks.util.ChatUtils;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;


public class TestModule extends Module {
    public TestModule(String name) {
        super(name);
    }
    private int tickWait = 0;

    @Override
    public void onEnable() {
    	ChatUtils.printMessage(ChatUtils.coloredString("test module", "red"));
    }

    @Override
    public void onDisable() {
        ChatUtils.printMessage(ChatUtils.coloredString("you are turok", "red"));
    }

	@Override
	public void onTick(ClientTickEvent event) {
        // do nothing lel
	}
}


