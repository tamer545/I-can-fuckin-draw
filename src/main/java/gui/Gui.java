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
    public static int x, y, width, height;

    public void create() {

        ComponentListener componentListener = new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {

            }

            @Override
            public void componentMoved(ComponentEvent e) {
                jf.setLocationRelativeTo(null);

            }

            @Override
            public void componentShown(ComponentEvent e) {

            }

            @Override
            public void componentHidden(ComponentEvent e) {

            }
        };

        jf = new JFrame("Draw");
        jf.setSize(screenSize.width, screenSize.height);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);
        jf.addComponentListener(componentListener);
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
