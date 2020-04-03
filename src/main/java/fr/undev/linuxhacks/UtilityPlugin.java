package fr.undev.linuxhacks;

import java.util.Map;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

public class UtilityPlugin
implements IFMLLoadingPlugin {
    public String[] getASMTransformerClass() {
        return new String[0];
    }

    public String getModContainerClass() {
        return null;
    }

    public String getSetupClass() {
        return null;
    }

    public void injectData(Map<String, Object> data) {
    }

    public String getAccessTransformerClass() {
        return null;
    }
}

