package project.screens;

import javax.swing.*;

public class AddMember extends JFrame implements Component{
    private JPanel contentPane;
    private static AddMember instance;
    private JTextField titleTextField;
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

    private AddMember() {
    }

    @Override
    public JPanel getMainPanel() {
        return contentPane;
}

    public static AddMember getInstance() {
        if(instance == null){
            instance = new AddMember();
        }
        return instance;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
