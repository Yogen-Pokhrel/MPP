package project.screens;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends Routes implements Component {
    private JPanel contentPanel;
    private static Dashboard instance;
    private JButton allBooksButton;
    private JButton allMembersButton;
    private JButton checkoutBooksButton;
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

    private Dashboard() {
        allBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigateTo(Routes.SCREENS.Books);
            }
        });

        allMembersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigateTo(SCREENS.Members);
            }
        });
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigateTo(SCREENS.Login);
            }
        });
    }

    @Override
    public JPanel getMainPanel() {
        return contentPanel;
    }

    public JPanel getInnerPanel() {
        return main;
    }

    public JButton getPageButton(){
        return pageButton;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle.setText(pageTitle);
    }

    public void setPageButtonTitle(String buttonTitle) {
        this.pageButton.setText(buttonTitle);
    }

    public JButton[] getAsideButtons(){
        return new JButton[]{allBooksButton, allMembersButton, checkoutBooksButton};
    }

    public static Dashboard getInstance() {
        if(instance == null){
            instance = new Dashboard();
        }
        return instance;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
