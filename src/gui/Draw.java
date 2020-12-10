package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class Draw extends JPanel {
    public static Color COLOR;
    public static int PENSIZE = 2;
    private MyMouseHandler mouseHandler;
    private Graphics2D g2d;

    public Draw() {


        mouseHandler = new MyMouseHandler();

        this.addMouseListener(mouseHandler);
        this.addMouseMotionListener(mouseHandler);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g2d = (Graphics2D) g;

    }

    private void setUpDrawingGraphics() {
        g2d = (Graphics2D) getGraphics();
    }

    public void clear() {
        PENSIZE = 3000;
        COLOR = Color.WHITE;
        g2d.fillRect(0, 0, getWidth(), getHeight());
        COLOR = Color.BLACK;
        PENSIZE = 2;
    }


    private class MyMouseHandler extends MouseAdapter {
        int x1, x2, y1, y2;

        @Override
        public void mousePressed(MouseEvent e) {
            x1 = e.getX();
            y1 = e.getY();

            setUpDrawingGraphics();
            x2 = x1;
            y2 = y1;
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            x1 = e.getX();
            y1 = e.getY();

            g2d.setStroke(new BasicStroke(PENSIZE));
            g2d.setColor(COLOR);
            g2d.drawLine(x1, y1, x2, y2);

            x2 = x1;
            y2 = y1;


        }
    }


}
