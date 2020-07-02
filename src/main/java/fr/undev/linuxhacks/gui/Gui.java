package fr.undev.linuxhacks.gui;

import com.onkiup.minedroid.R;
import com.onkiup.minedroid.Context;
import com.onkiup.minedroid.gui.Overlay;
import com.onkiup.minedroid.gui.events.MouseEvent;
import com.onkiup.minedroid.gui.views.View;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side; // just added stuff here so i could commit lmfao
import net.minecraftforge.fml.relauncher.SideOnly; // more stuff so i can commit again

@SideOnly(Side.CLIENT)
public class Gui extends Overlay {

    private View.OnClick onDismissClick = new View.OnClick() {
        @Override
        public void handle(MouseEvent event) {
            dismiss();
        }
    };

    public Gui(Context context) {
        super(context);
    }

    @Override
    protected ResourceLocation getContentLayout() {
        return R.layout.minedroid_test;
    }

    @Override
    protected void fill(View content) {
    }

    @Override
    protected void onStart() {

    }

    @Override
    protected void onStop() {

    }

}
