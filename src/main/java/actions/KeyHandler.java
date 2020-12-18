package actions;

import gui.Draw;
import gui.Gui;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class KeyHandler implements KeyListener {
    private int colorChooser = ThreadLocalRandom.current().nextInt(0, 6);
    private Draw draw = new Draw();
    public static boolean ovalMode = false;
    public static boolean rectMode = false;


    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT -> {
                switch (colorChooser) {
                    case 0 -> {
                        Draw.color = Color.BLACK;
                        System.out.println("Color: BLACK");
                    }
                    case 1 -> {
                        Draw.color = Color.RED;
                        System.out.println("Color: RED");
                    }
                    case 2 -> {
                        Draw.color = Color.GRAY;
                        System.out.println("Color: GRAY");
                    }
                    case 3 -> {
                        Draw.color = Color.GREEN;
                        System.out.println("Color: GREEN");
                    }
                    case 4 -> {
                        Draw.color = Color.YELLOW;
                        System.out.println("Color: YELLOW");
                    }
                    case 5 -> {
                        Draw.color = Color.BLUE;
                        System.out.println("Color: BLUE");
                    }
                }
                colorChooser = ThreadLocalRandom.current().nextInt(0, 6);
            }
            case KeyEvent.VK_1 -> Draw.pensize = 2;
            case KeyEvent.VK_2 -> Draw.pensize = 4;
            case KeyEvent.VK_3 -> Draw.pensize = 6;
            case KeyEvent.VK_4 -> Draw.pensize = 8;
            case KeyEvent.VK_5 -> Draw.pensize = 10;
            case KeyEvent.VK_6 -> Draw.pensize = 12;
            case KeyEvent.VK_7 -> Draw.pensize = 14;
            case KeyEvent.VK_8 -> Draw.pensize = 16;
            case KeyEvent.VK_9 -> Draw.pensize = 18;
            case KeyEvent.VK_0 -> Draw.pensize = 36;
            case KeyEvent.VK_O -> {
                rectMode = false;
                ovalMode = true;
            }
            case KeyEvent.VK_R -> {
                ovalMode = false;
                rectMode = true;
            }
            case KeyEvent.VK_S -> {
                ovalMode = false;
                rectMode = false;
            }
            case KeyEvent.VK_P -> {
                BufferedImage screencapture;
                try {

                    screencapture = new Robot().createScreenCapture(
                            new Rectangle(Gui.x + 230, Gui.y + 140, Gui.width - 240, Gui.height - 160));


                    File file = new File((System.getProperty("user.home")), "Desktop\\Screencapture by Tamer.png");
                    ImageIO.write(screencapture, "png", file);

                } catch (AWTException awtException) {
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                System.out.println("Picture succesfully saved");

            }
            case KeyEvent.VK_E -> Draw.color = Color.GRAY;
            case KeyEvent.VK_NUMPAD0 -> Draw.color = Color.BLACK;
            case KeyEvent.VK_NUMPAD1 -> Draw.color = Color.RED;
            case KeyEvent.VK_NUMPAD2 -> Draw.color = Color.ORANGE;
            case KeyEvent.VK_NUMPAD3 -> Draw.color = Color.WHITE;
            case KeyEvent.VK_NUMPAD4 -> Draw.color = Color.GRAY;
            case KeyEvent.VK_NUMPAD5 -> Draw.color = Color.GREEN;
            case KeyEvent.VK_NUMPAD6 -> Draw.color = Color.PINK;
            case KeyEvent.VK_NUMPAD7 -> Draw.color = Color.BLUE;



        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }


}
