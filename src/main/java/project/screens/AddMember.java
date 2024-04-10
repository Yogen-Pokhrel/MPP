package project.screens;

import project.librarysystem.LibrarySystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddMember implements Component{
    private JButton button1;
    private JPanel contentPane;

    public AddMember() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    @Override
    public JPanel getMainPanel() {
        return contentPane;
    }
}
