package gui;

import actions.KeyHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class Draw extends JPanel {
    public static Color color;
    public static int pensize = 2;
    private MyMouseHandler mouseHandler;
    private Graphics2D g2d;

    public Draw() {

        mouseHandler = new MyMouseHandler();

        this.addMouseListener(mouseHandler);
        this.addMouseMotionListener(mouseHandler);


    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int wordChooser = ThreadLocalRandom.current().nextInt(0, 7);
        String[] words = {"Tree", "Car", "Cow", "House", "Tamer", "Horse", "Dog", "Herblingen"};
        g2d = (Graphics2D) g;

        g2d.setFont(new Font("Arial", Font.HANGING_BASELINE, 12));

        g2d.drawString("Numpad 0: BLACK", 1750, 25);
        g2d.drawString("Numpad 1: RED", 1750, 75);
        g2d.drawString("Numpad 2: ORANGE", 1750, 125);
        g2d.drawString("Numpad 3: WHITE", 1750, 175);
        g2d.drawString("Numpad 4: GRAY", 1750, 225);
        g2d.drawString("Numpad 5: GREEN", 1750, 275);
        g2d.drawString("Numpad 6: PINK", 1750, 325);
        g2d.drawString("Numpad 7: BLUE", 1750, 375);

        g2d.drawString("O: Oval Mode", 1750, 525);
        g2d.drawString("R: Rect Mode", 1750, 575);

        g2d.setFont(new Font("Arial", Font.HANGING_BASELINE, 36));
        g2d.drawString(words[wordChooser], 900, 75);

    }

    private void setUpDrawingGraphics() {
        g2d = (Graphics2D) getGraphics();
    }


    private class MyMouseHandler extends MouseAdapter {
        int x1, x2, y1, y2;

        @Override
        public void mousePressed(MouseEvent e) {
            x1 = e.getX();
            y1 = e.getY();

            x2 = x1;
            y2 = y1;

            setUpDrawingGraphics();

            draw();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            x1 = e.getX();
            y1 = e.getY();

            draw();


        }

        public void draw() {
            g2d.setStroke(new BasicStroke(pensize));
            g2d.setColor(color);
            if (KeyHandler.ovalMode) {
                g2d.drawOval(x1, y1, x2, y2);
            } else if (KeyHandler.rectMode) {
                g2d.drawRect(x1, y1, x2, y2);
            } else {
                g2d.drawLine(x1, y1, x2, y2);
            }

            x2 = x1;
            y2 = y1;
        }
    }


}
