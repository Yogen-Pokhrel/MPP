package project.screens;

import project.business.Person;
import project.librarysystem.LibrarySystem;

import javax.swing.*;
import java.awt.*;
import java.awt.Component;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            Routes.thread.setTitle("Sample Library Application");
            Routes.thread.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Routes.thread.init();
            Routes.thread.setSize(900,800);
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
