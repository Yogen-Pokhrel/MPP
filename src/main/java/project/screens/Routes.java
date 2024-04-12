package project.screens;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Routes extends JFrame {
    public static Routes thread = new Routes();

    Routes() {
        // override default margin and paddings
    }

    enum SCREENS {
        Login,
        Books,
        Members,
        AddBook,
        AddMember,
        Authors,
        AddAuthor,
        CheckoutBook
    }

    void init() {
        //other logic can be implemented to redirect the user to the dashboard page if already logged in during application startup
        navigateTo(SCREENS.Books);
    }

    void navigateTo(SCREENS screen) {
        switch (screen) {
            case Login -> LoginScreen.getInstance().render();
            case Books -> BookScreen.getInstance().render();
            case AddBook -> AddBookScreen.getInstance().render();
            case Members -> MemberScreen.getInstance().render();
            case AddMember -> AddMember.getInstance().render();
            case Authors -> AuthorScreen.getInstance().render();
            case AddAuthor -> AddAuthorScreen.getInstance().render();
            case CheckoutBook -> CheckoutBookScreen.getInstance().render();
        }
    }

    public void refresh(){
        thread.revalidate();
        thread.repaint();
    }

    public void removeAllActionListenersOfButton(JButton button) {
        ActionListener[] listeners = button.getActionListeners();
        for (ActionListener al : listeners) {
            button.removeActionListener(al);
        }
    }
}
