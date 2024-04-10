package project.screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Book extends JFrame implements Component{
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
    }

    @Override
    public JPanel getMainPanel() {
        return contentPane;
}

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
