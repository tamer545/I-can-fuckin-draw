package gui;

import actions.KeyHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

public class SaveFileView extends JFrame {
    private JTextField enterFileNameField;
    private JButton saveButton;
    private JButton cancelButton;
    private JPanel mainPanel;
    private JButton choosePathButton;
    private JLabel pathLabel;
    private File filepath;
    private JFileChooser fc;

    public SaveFileView(KeyHandler handler) {
        super("Save File");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setVisible(true);

        cancelButton.addActionListener(e -> dispose());
        saveButton.addActionListener(e -> {
            setVisible(false);
            handler.setFileName(enterFileNameField.getText());
            handler.setFilePath(filepath);
            dispose();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            handler.makeScreenshot();


        });
        choosePathButton.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            fc.setVisible(true);
            fc.setCurrentDirectory(new File("C:\\Users")); // start at application current directory
            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int returnVal = fc.showSaveDialog(mainPanel);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                filepath = fc.getSelectedFile();
            }
            pathLabel.setText(filepath.toString());
        });

        enterFileNameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    saveButton.doClick();
                }
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    cancelButton.doClick();
                }
            }
        });

    }
}
