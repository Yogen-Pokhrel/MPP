package project.screens;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.Locale;

public class Login extends JDialog {
    private JPanel contentPane;
    private JPanel loginLeftContainer;
    private JPanel loginRightContainer;
    private JTextField enterUsernameTextField;
    private JPanel rightSidebarContainerInner;
    private JButton loginButton;
    private JLabel loginSidebarTitle;
    private JPasswordField enterPasswordPasswordField;

    public Login() {
        setContentPane(contentPane);
        setModal(true);
        setTitle("Welcome to library");
    }

    public static void main(String[] args) {
        Login dialog = new Login();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}


