package gui;

import actions.KeyHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class Gui {
    private JFrame jf;
    private Draw draw;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static int X, Y, WIDTH, HEIGHT;

    public void create() {

        jf = new JFrame("Draw");
        jf.setSize(screenSize.width, screenSize.height);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);
        jf.setLayout(null);
        jf.addKeyListener(new KeyHandler(this));

        draw = new Draw();
        draw.setBounds(0, 0, jf.getWidth(), jf.getHeight());
        draw.setVisible(true);

        jf.add(draw);
        jf.requestFocus();
        jf.setVisible(true);

        X = jf.getX();
        Y = jf.getY();
        HEIGHT = jf.getHeight();
        WIDTH = jf.getWidth();


    }

}
