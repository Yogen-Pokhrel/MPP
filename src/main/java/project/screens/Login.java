package project.screens;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends Routes implements Component {
    private JPanel contentPane;
    private static Login instance;
    private JPanel loginLeftContainer;
    private JPanel loginRightContainer;
    private JTextField enterUsernameTextField;
    private JPanel rightSidebarContainerInner;
    private JButton loginButton;
    private JLabel loginSidebarTitle;
    private JPasswordField enterPasswordPasswordField;

     private Login() {
        loginButton.addActionListener(e -> navigateTo(SCREENS.Books));
    }

    @Override
    public JPanel getMainPanel() {
        return contentPane;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public static Login getInstance() {
         if(instance == null){
             instance = new Login();
         }
        return instance;
    }
}


