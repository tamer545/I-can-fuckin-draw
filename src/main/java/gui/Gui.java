package gui;

import actions.KeyHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

/**
 * Creates the GUI
 */
public class Gui {
    public static JFrame jf;
    private Draw draw;
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
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

        JPanel drawPanel = new JPanel();
        drawPanel.setBackground(new Color(211, 211, 211));
        drawPanel.setLocation(200, 0);
        drawPanel.setSize(screenSize.width - 200, screenSize.height);
        drawPanel.setVisible(true);

        //createButtons();

        jf.add(drawPanel);
        jf.add(draw);
        jf.requestFocus();
        jf.setVisible(true);

        x = jf.getX();
        y = jf.getY();
        height = jf.getHeight();
        width = jf.getWidth();


    }

    public void createButtons() {
        JButton redButton = new JButton();
        redButton.setBackground(Color.RED);
        redButton.setLocation(200, 25);
        redButton.setSize(50, 25);
        redButton.setVisible(true);

        JButton orangeButton = new JButton();
        orangeButton.setBackground(Color.ORANGE);
        orangeButton.setLocation(200, 60);
        orangeButton.setSize(50, 25);
        orangeButton.setVisible(true);

        JButton yellowButton = new JButton();
        yellowButton.setBackground(Color.YELLOW);
        yellowButton.setLocation(265, 25);
        yellowButton.setSize(50, 25);
        yellowButton.setVisible(true);

        JButton pinkButton = new JButton();
        pinkButton.setBackground(Color.PINK);
        pinkButton.setLocation(265, 60);
        pinkButton.setSize(50, 25);
        pinkButton.setVisible(true);

        JButton greenButton = new JButton();
        greenButton.setBackground(Color.GREEN);
        greenButton.setLocation(330, 25);
        greenButton.setSize(50, 25);
        greenButton.setVisible(true);

        JButton rectModeButton = new JButton();
        greenButton.setBackground(Color.GRAY);
        greenButton.setText("Rect Mode");
        greenButton.setLocation(1350, 25);
        greenButton.setSize(50, 25);
        greenButton.setVisible(true);

        redButton.addActionListener(e -> Draw.color = Color.RED);
        orangeButton.addActionListener(e -> Draw.color = Color.ORANGE);
        yellowButton.addActionListener(e -> Draw.color = Color.YELLOW);
        pinkButton.addActionListener(e -> Draw.color = Color.PINK);
        greenButton.addActionListener(e -> Draw.color = Color.GREEN);
        rectModeButton.addActionListener(e -> KeyHandler.rectMode = true);

        jf.add(redButton);
        jf.add(orangeButton);
        jf.add(yellowButton);
        jf.add(pinkButton);
        jf.add(greenButton);
    }
}
