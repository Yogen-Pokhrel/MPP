package project.screens;

import javax.swing.*;

public class AddBook extends JFrame implements Component{
    private JPanel contentPane;
    private static AddBook instance;
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
    private JPanel inner;

    private AddBook() {
    }

    @Override
    public JPanel getMainPanel() {
        return contentPane;
}

    public static AddBook getInstance() {
        if(instance == null){
            instance = new AddBook();
        }
        return instance;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
