package project.screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Book extends JFrame {
    private JPanel contentPane;
    private JTextField titleTextField;
    private JLabel addBookLabel;
    private JLabel titleLabel;
    private JLabel isbnNumLabel;
    private JTextField isbnNumTextField;
    private JLabel borrowTimeLabel;
    private JComboBox borrowTimeDropdown;
    private JLabel authorLabel;
    private JComboBox authorDropdown;
    private JButton addAuthorButton;
    private JList selectedAuthorList;

    public Book() {
        setContentPane(contentPane);
        setVisible(true);
    }

    public static void main(String[] args) {
        Book dialog = new Book();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
