package project.screens;

import project.business.LoginException;
import project.business.SystemController;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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
    private JLabel loginHero;

    private LoginScreen() {
        username.requestFocusInWindow();
        loginButton.addActionListener(e -> {
            SystemController controller = new SystemController();
            String uName = username.getText();
            String pass = String.valueOf(password.getPassword());
            errorMessage.setText("");
            try {
                controller.login(uName, pass);
                username.setText("Enter user id");
                password.setText("Enter password");
                navigateTo(SCREENS.Books);
            } catch (LoginException loginException) {
                errorMessage.setText("Invalid user id or password");
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
        loginHero = new JLabel();
        loginHero.setHorizontalAlignment(JLabel.CENTER);
        loginHero.setVerticalAlignment(JLabel.CENTER);

        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("src/main/java/project/resources/hero.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (img != null) {
            ImageIcon imageIcon = new ImageIcon(img);
            Image image = imageIcon.getImage();
            Image scaledImage = image.getScaledInstance(600, 800,
                    Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(scaledImage);
            loginHero.setIcon(imageIcon);
        }
    }

    public static LoginScreen getInstance() {
        instance = new LoginScreen();
        return instance;
    }
}
