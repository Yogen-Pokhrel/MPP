package project.screens;

import javax.swing.*;

public class CheckoutBook extends Routes implements Component {

    private static CheckoutBook instance;

    public static CheckoutBook getInstance() {
        if (instance == null) {
            instance = new CheckoutBook();
        }
        return instance;
    }

    private JPanel contentPane;

    private JPanel inner;

    @Override
    public JPanel getMainPanel() {
        return contentPane;
    }
}
