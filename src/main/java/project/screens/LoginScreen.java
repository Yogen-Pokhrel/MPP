package project.screens;

import project.business.LoginException;
import project.business.SystemController;

import javax.swing.*;

public class LoginScreen extends Routes implements Component {
    private JPanel contentPane;
    private static LoginScreen instance;
    private JPanel loginLeftContainer;
    private JPanel loginRightContainer;
    private JTextField username;
    private JPanel rightSidebarContainerInner;
    private JButton loginButton;
    private JLabel loginSidebarTitle;
    private JPasswordField password;
    private JLabel errorMessage;

    private LoginScreen() {
        loginButton.addActionListener(e -> {
            SystemController controller = new SystemController();
            String uName = username.getText();
            String pass = String.valueOf(password.getPassword());
            errorMessage.setText("");
            try{
                controller.login(uName, pass);
                username.setText("Enter user id");
                password.setText("Enter password");
                navigateTo(SCREENS.Books);
            }catch (LoginException loginException){
                errorMessage.setText("Invalid user id or password");
                System.out.println("Invalid User Credentials");
            }
        });
    }

    @Override
    public JPanel getMainPanel() {
        return contentPane;
    }

    @Override
    public void render() {
        thread.setContentPane(getMainPanel());
        refresh();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        errorMessage = new JLabel();
    }

    public static LoginScreen getInstance() {
         if(instance == null){
             instance = new LoginScreen();
         }
        return instance;
    }
}


