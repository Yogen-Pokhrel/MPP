package project.screens;

import javax.swing.*;

public class CheckoutBookScreen extends Routes implements Component {

    private static CheckoutBookScreen instance;

    public static CheckoutBookScreen getInstance() {
        if (instance == null) {
            instance = new CheckoutBookScreen();
        }
        return instance;
    }

    private JPanel contentPane;

    private JPanel inner;

    @Override
    public JPanel getMainPanel() {
        return contentPane;
    }

    @Override
    public void render() {
        Dashboard dash = Dashboard.getInstance();
        dash.setPageTitle("Checkout books");
        dash.setPageButtonVisibility(false);
        dash.repaintButtons(SCREENS.CheckoutBook);
        JPanel mainPanel = dash.getInnerPanel();
        mainPanel.removeAll();
        mainPanel.add(getMainPanel());
        thread.setContentPane(dash.getMainPanel());
        refresh();
    }
}
