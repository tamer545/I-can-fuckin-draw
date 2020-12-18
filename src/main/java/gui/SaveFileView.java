package gui;

import actions.KeyHandler;

import javax.swing.*;
import java.io.IOException;

public class SaveFileView extends JFrame {
    private JTextField enterFileNameField;
    private JButton saveButton;
    private JButton cancelButton;
    private JPanel mainPanel;
    private JTextField filePathField;

    public SaveFileView(KeyHandler handler) throws IOException {
        super("Save File");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setVisible(true);

        handler.openExplorer();

        cancelButton.addActionListener(e -> dispose());
        saveButton.addActionListener(e -> {
            setVisible(false);
            handler.setFileName(enterFileNameField.getText());
            handler.setFilePath(filePathField.getText());
            dispose();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            handler.makeScreenshot();

        });
    }
}
