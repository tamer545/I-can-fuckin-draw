package actions;

import com.github.weisj.darklaf.LafManager;
import com.github.weisj.darklaf.theme.DarculaTheme;
import gui.Gui;

public class MainDraw {

    public static void main(String[] args) {
        LafManager.install(new DarculaTheme());
        Gui gui = new Gui();
        gui.create();
    }
}
