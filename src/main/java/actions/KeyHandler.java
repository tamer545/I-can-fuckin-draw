package actions;

import gui.Draw;
import gui.Gui;
import gui.SaveFileView;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

/**
 * KeyHandler for the main GUI
 */
public class KeyHandler extends Component implements KeyListener {
    private int colorChooser = ThreadLocalRandom.current().nextInt(0, 6);
    public static boolean ovalMode = false;
    public static boolean rectMode = false;
    private String fileName;
    private File filePath;

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
            case KeyEvent.VK_2 -> Draw.pensize = 6;
            case KeyEvent.VK_3 -> Draw.pensize = 10;
            case KeyEvent.VK_4 -> Draw.pensize = 14;
            case KeyEvent.VK_5 -> Draw.pensize = 18;
            case KeyEvent.VK_6 -> Draw.pensize = 22;
            case KeyEvent.VK_7 -> Draw.pensize = 26;
            case KeyEvent.VK_8 -> Draw.pensize = 30;
            case KeyEvent.VK_9 -> Draw.pensize = 34;
            case KeyEvent.VK_0 -> Draw.pensize = 68;

            case KeyEvent.VK_O -> {
                rectMode = false;
                ovalMode = true;
            }
            case KeyEvent.VK_R -> {
                ovalMode = false;
                rectMode = true;
            }
            case KeyEvent.VK_S -> {
                Draw.color = Color.BLACK;
                ovalMode = false;
                rectMode = false;
            }
            case KeyEvent.VK_P -> new SaveFileView(this);
            case KeyEvent.VK_E -> Draw.color = Color.GRAY;

            case KeyEvent.VK_NUMPAD0 -> Draw.color = Color.BLACK;
            case KeyEvent.VK_NUMPAD1 -> Draw.color = Color.RED;
            case KeyEvent.VK_NUMPAD2 -> Draw.color = Color.ORANGE;
            case KeyEvent.VK_NUMPAD3 -> Draw.color = Color.WHITE;
            case KeyEvent.VK_NUMPAD4 -> Draw.color = Color.DARK_GRAY;
            case KeyEvent.VK_NUMPAD5 -> Draw.color = Color.GREEN;
            case KeyEvent.VK_NUMPAD6 -> Draw.color = Color.PINK;
            case KeyEvent.VK_NUMPAD7 -> Draw.color = Color.BLUE;


        }
    }

    public void makeScreenshot() {
        BufferedImage screencapture;
        Gui.jf.requestFocus();

        try {
            screencapture = new Robot().createScreenCapture(
                    new Rectangle(Gui.x + 230, Gui.y + 140, Gui.width - 240, Gui.height - 160));

            File file = new File(filePath + "\\" + fileName + ".png");
            ImageIO.write(screencapture, "png", file);

        } catch (IOException | AWTException exception) {
            exception.printStackTrace();
        }

        System.out.println("Picture successfully saved");


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFilePath(File filePath) {
        this.filePath = filePath;
    }


}
