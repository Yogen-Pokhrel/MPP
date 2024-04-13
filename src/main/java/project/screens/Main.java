package project.screens;

import javax.swing.*;
import java.awt.*;
import java.awt.Component;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Routes.thread.setTitle("Library Application");
            Routes.thread.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Routes.thread.init();
            Routes.thread.setSize(1200, 800);
            Routes.thread.setResizable(false);
            centerFrameOnDesktop(Routes.thread);
            Routes.thread.setVisible(true);
        });
    }

    public static void centerFrameOnDesktop(Component f) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int height = toolkit.getScreenSize().height;
        int width = toolkit.getScreenSize().width;
        int frameHeight = f.getSize().height;
        int frameWidth = f.getSize().width;
        f.setLocation(((width - frameWidth) / 2), (height - frameHeight) / 3);
    }
}
