package gui;

import actions.KeyHandler;

import javax.swing.*;
import java.awt.*;

public class Gui {
    private JFrame jf;
    private Draw draw;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static int x, y, width, height;

    public void create() {

        jf = new JFrame("Draw");
        jf.setSize(screenSize.width, screenSize.height);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);
        jf.setLayout(null);
        jf.addKeyListener(new KeyHandler());

        draw = new Draw();
        draw.setBounds(0, 0, jf.getWidth(), jf.getHeight());
        draw.setVisible(true);

        jf.add(draw);
        jf.requestFocus();
        jf.setVisible(true);

        x = jf.getX();
        y = jf.getY();
        height = jf.getHeight();
        width = jf.getWidth();


    }

}
