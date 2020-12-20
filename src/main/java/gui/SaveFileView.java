package gui;

import actions.KeyHandler;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

/**
 * @Autor C357375
 * Creates the GUI if you want to save the File
 */
public class SaveFileView extends JFrame {
    private JTextField enterFileNameField;
    private JButton saveButton;
    private JButton cancelButton;
    private JPanel mainPanel;
    private JButton choosePathButton;
    private JLabel pathLabel;
    private File filepath;

    public SaveFileView(KeyHandler handler) {
        super("Save File");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        setSize(500, 200);
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
            fc.setCurrentDirectory(new File(System.getProperty("user.home"))); // start at application current directory
            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int returnVal = fc.showSaveDialog(mainPanel);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                filepath = fc.getSelectedFile();
            }
            if (filepath != null) {
                pathLabel.setText(filepath.toString());
            }

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
