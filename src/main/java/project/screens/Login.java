package project.screens;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login implements Component {
    private JPanel contentPane;
    private JPanel loginLeftContainer;
    private JPanel loginRightContainer;
    private JTextField enterUsernameTextField;
    private JPanel rightSidebarContainerInner;
    private JButton loginButton;
    private JLabel loginSidebarTitle;
    private JPasswordField enterPasswordPasswordField;

    public Login() {
//        setContentPane(contentPane);
//        setTitle("Login - Library System");
//        setVisible(false);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    @Override
    public JPanel getMainPanel() {
        return contentPane;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}


