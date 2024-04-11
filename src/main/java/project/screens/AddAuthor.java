package project.screens;

import javax.swing.*;

public class AddAuthor  extends Routes implements Component {

    private JPanel contentPane;
    private JPanel inner;

    private static AddAuthor instance;

    public static AddAuthor getInstance() {
        if(instance == null){
            instance = new AddAuthor();
        }
        return instance;
    }

    @Override
    public JPanel getMainPanel() {
        return contentPane;
    }
}
