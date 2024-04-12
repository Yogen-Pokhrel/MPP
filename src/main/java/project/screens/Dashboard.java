package project.screens;

import project.business.SystemController;
import project.dataaccess.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends Routes implements Component {
    private static Dashboard instance;

    public static Dashboard getInstance() {
        if (instance == null) {
            instance = new Dashboard();
        }
        return instance;
    }

    private JPanel contentPanel;
    private JButton allBooksButton;
    private JButton allMembersButton;
    private JButton CheckoutBookButton;
    private JPanel main;
    private JPanel aside;
    private JPanel mainPanelWrapper;
    private JPanel navBar;
    private JLabel pageTitle;
    private JButton logoutButton;
    private JPanel borderBottom;
    private JPanel asideTitle;
    private JPanel navbarTitleWrapper;
    private JButton pageButton;

    private JButton allAuthors;
    private JLabel loggedUserLabel;

    private Dashboard() {
        allBooksButton.addActionListener(e -> navigateTo(Routes.SCREENS.Books));
        allMembersButton.addActionListener(e -> navigateTo(SCREENS.Members));
        logoutButton.addActionListener(e -> navigateTo(SCREENS.Login));
        allAuthors.addActionListener(e -> navigateTo(SCREENS.Authors));
        CheckoutBookButton.addActionListener(e -> navigateTo(SCREENS.CheckoutBook));
    }

    @Override
    public JPanel getMainPanel() {
        User user = SystemController.loggedInUser;
        if(user != null){
            loggedUserLabel.setText("Hi, " + user.getFirstName());
        }
        return contentPanel;
    }

    public JPanel getInnerPanel() {
        return main;
    }

    public JButton getPageButton() {
        return pageButton;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle.setText(pageTitle);
    }

    public void setPageButtonTitle(String buttonTitle) {
        this.pageButton.setText(buttonTitle);
    }

    public void setPageButtonVisibility(boolean visibility) {
        this.pageButton.setVisible(visibility);
    }

    public JButton[] getAsideButtons() {
        return new JButton[] { allBooksButton, allMembersButton, CheckoutBookButton, allAuthors };
    }

    public void repaintButtons(SCREENS screen) {
        clearSidebarSelectedDesign();
        JButton activeButton = null;
        switch (screen) {
            case Books:
                activeButton = allBooksButton;
                break;
            case AddBook:
                activeButton = allBooksButton;
                break;
            case AddMember:
                activeButton = allMembersButton;
                break;
            case Members:
                activeButton = allMembersButton;
                break;
            case AddAuthor:
            case Authors:
                activeButton = allAuthors;
                break;
        }
        if (activeButton != null) {
            markAsSelected(activeButton);
        }
    }

    void clearSidebarSelectedDesign() {
        for (JButton btn : getAsideButtons()) {
            btn.setBackground(Color.getColor("#EBEBEB"));
            btn.setForeground(Color.black);
            // btn.setOpaque(false);
            // btn.setBorderPainted(false);
        }
    }

    void markAsSelected(JButton btn) {
        if (btn == null)
            return;
        // 41 53 158
        btn.setBackground(Color.decode("#29359E"));
        btn.setForeground(Color.white);
        // btn.setOpaque(true);
        // btn.setBorderPainted(false);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    @Override
    public void render() {
        //we are not rendering the default design, instead it is used as a layout to render other elements
    }
}
