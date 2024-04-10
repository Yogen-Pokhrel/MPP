package project.screens;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class Main {
    enum screens {
        Login,
        ListBooks,
        ListMembers


    }
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            AddMember form = new AddMember();
            form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            form.setTitle("I am add Member form");
            form.pack();
            form.setVisible(true);
        });
    }
}
