package project.screens;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Member implements Component{
    private JButton button1;

    private static Member instance;
    private JPanel contentPane;
    private JLabel heading;

    private Member() {
    }
    public static Member getInstance() {
        if(instance == null){
            instance = new Member();
        }
        return instance;
    }

    @Override
    public JPanel getMainPanel() {
        return contentPane;
    }
}
