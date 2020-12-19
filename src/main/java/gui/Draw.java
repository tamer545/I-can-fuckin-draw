package gui;

import actions.KeyHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Draws everything
 */
public class Draw extends JPanel {
    public static Color color;
    public static int pensize = 2;
    private Graphics2D g2d;
    private boolean drawWord = true;

    public Draw() {

        MyMouseHandler mouseHandler = new MyMouseHandler();

        this.addMouseListener(mouseHandler);
        this.addMouseMotionListener(mouseHandler);


    }

    /**
     * Paints the GUI
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2d = (Graphics2D) g;

        drawText();
    }

    public void drawText() {
        int xoff = 20;

        g2d.setColor(Color.BLACK);

        g2d.setFont(new Font("Arial", Font.ITALIC, 12));

        g2d.drawString("Numpad 0: BLACK", xoff, 25);
        g2d.drawString("Numpad 1: RED", xoff, 75);
        g2d.drawString("Numpad 2: ORANGE", xoff, 125);
        g2d.drawString("Numpad 3: WHITE", xoff, 175);
        g2d.drawString("Numpad 4: GRAY", xoff, 225);
        g2d.drawString("Numpad 5: GREEN", xoff, 275);
        g2d.drawString("Numpad 6: PINK", xoff, 325);
        g2d.drawString("Numpad 7: BLUE", xoff, 375);

        g2d.drawString("O: Oval Mode", xoff, 525);
        g2d.drawString("R: Rect Mode", xoff, 575);
        g2d.drawString("E: Erase Mode", xoff, 625);
        g2d.drawString("S: Standard Mode", xoff, 675);

    }

    public void setDrawWord(boolean drawWord) {
        this.drawWord = drawWord;
    }

    private void setUpDrawingGraphics() {
        g2d = (Graphics2D) getGraphics();
    }


    /**
     * Checks the Mouse-Pointer coordinates and draws there
     */
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
            drawText();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            x1 = e.getX();
            y1 = e.getY();

            draw();
            drawText();

        }

        public void draw() {
            g2d.setStroke(new BasicStroke(pensize));
            g2d.setColor(color);
            if (x1 > 200) {
                if (KeyHandler.ovalMode) {
                    g2d.drawOval(x1, y1, x2, y2);
                } else if (KeyHandler.rectMode) {
                    g2d.drawRect(x1, y1, x2, y2);
                } else {
                    g2d.drawLine(x1, y1, x2, y2);
                }
            }
            x2 = x1;
            y2 = y1;
        }
    }


}
