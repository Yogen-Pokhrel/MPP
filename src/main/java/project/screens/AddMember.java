package project.screens;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddMember extends Routes implements Component{
    private JPanel contentPane;
    private JPanel inner;
    private JButton saveButton;
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

    private AddMember() {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    @Override
    public JPanel getMainPanel() {
        return contentPane;
}

    @Override
    public void render() {
        Dashboard dash = Dashboard.getInstance();
        dash.setPageTitle("Add a Member");
        dash.setPageButtonVisibility(false);
        dash.repaintButtons(SCREENS.Members);
        JPanel mainPanel = dash.getInnerPanel();
        mainPanel.removeAll();
        mainPanel.add(getMainPanel());
        thread.setContentPane(dash.getMainPanel());
        refresh();
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
