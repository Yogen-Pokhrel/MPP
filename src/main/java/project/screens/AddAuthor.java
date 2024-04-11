package project.screens;

import project.business.Address;
import project.business.Author;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAuthor  extends Routes implements Component {

    private JPanel contentPane;
    private JPanel inner;
    private JCheckBox hasCredentials;
    private JButton saveButton;
    private JLabel fNameLabel;
    private JTextField fNameTextField;
    private JLabel lNameLabel;
    private JTextField lNameTextField;
    private JLabel phoneNumLabel;
    private JTextField phoneNumTextField;
    private JLabel bioLabel;
    private JTextField bioTextField;
    private JLabel addressLabel;
    private JLabel streetLabel;
    private JTextField streetTextField;
    private JLabel cityLabel;
    private JTextField cityTextField;
    private JLabel stateLabel;
    private JTextField stateTextField;
    private JLabel zipLabel;
    private JTextField zipTextField;

    private static AddAuthor instance;

    public AddAuthor() {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Author author = new Author(
                      fNameTextField.getText(),
                      lNameTextField.getText(),
                        phoneNumTextField.getText(),
                        new Address(
                                streetTextField.getText(),
                                cityTextField.getText(),
                                stateTextField.getText(),
                                zipTextField.getText()
                        ),
                        bioTextField.getText()
                );
            }
        });
    }

    public static AddAuthor getInstance() {
        if(instance == null){
            instance = new AddAuthor();
        }
        return instance;
    }

    @Override
    public JPanel getMainPanel() {
        return contentPane;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
