package actions;

import gui.Draw;
import gui.Gui;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class KeyHandler implements KeyListener {
    private int colorChooser = ThreadLocalRandom.current().nextInt(0, 6);
    private Draw draw = new Draw();
    private Graphics g;
    private int i = 1;
    private Gui gui;

    public KeyHandler(Gui gui) {
        this.gui = gui;
    }


    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT -> {
                switch (colorChooser) {
                    case 0 -> {
                        Draw.COLOR = Color.BLACK;
                        System.out.println("Color: BLACK");
                    }
                    case 1 -> {
                        Draw.COLOR = Color.RED;
                        System.out.println("Color: RED");
                    }
                    case 2 -> {
                        Draw.COLOR = Color.GRAY;
                        System.out.println("Color: GRAY");
                    }
                    case 3 -> {
                        Draw.COLOR = Color.GREEN;
                        System.out.println("Color: GREEN");
                    }
                    case 4 -> {
                        Draw.COLOR = Color.YELLOW;
                        System.out.println("Color: YELLOW");
                    }
                    case 5 -> {
                        Draw.COLOR = Color.BLUE;
                        System.out.println("Color: BLUE");
                    }
                }
                draw.paintComponents(g);
                colorChooser = ThreadLocalRandom.current().nextInt(0, 5);
            }
            case KeyEvent.VK_1 -> Draw.PENSIZE = 2;
            case KeyEvent.VK_2 -> Draw.PENSIZE = 4;
            case KeyEvent.VK_3 -> Draw.PENSIZE = 6;
            case KeyEvent.VK_4 -> Draw.PENSIZE = 8;
            case KeyEvent.VK_5 -> Draw.PENSIZE = 10;
            case KeyEvent.VK_6 -> Draw.PENSIZE = 12;
            case KeyEvent.VK_7 -> Draw.PENSIZE = 14;
            case KeyEvent.VK_8 -> Draw.PENSIZE = 16;
            case KeyEvent.VK_9 -> Draw.PENSIZE = 18;
            case KeyEvent.VK_0 -> {
                draw.clear();


            }
            case KeyEvent.VK_P -> {
                BufferedImage screencapture = null;
                try {

                    screencapture = new Robot().createScreenCapture(
                            new Rectangle(Gui.X + 20, Gui.Y + 5, Gui.WIDTH - 50, Gui.HEIGHT));


                    File file = new File("C:\\Users\\timoa\\OneDrive\\Desktop\\Skribbl.io Saves\\screencapture" + i + ".png");
                    ImageIO.write(screencapture, "png", file);

                } catch (AWTException awtException) {
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }


}
