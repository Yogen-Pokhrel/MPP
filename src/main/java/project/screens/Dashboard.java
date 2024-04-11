package project.screens;

import javax.swing.*;
import java.awt.*;
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
    private JButton allAuthors;

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
        allAuthors.addActionListener(e -> navigateTo(SCREENS.Authors));
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

    public void setPageButtonVisibility(boolean visibility){
        this.pageButton.setVisible(visibility);
    }

    public JButton[] getAsideButtons(){
        return new JButton[]{allBooksButton, allMembersButton, checkoutBooksButton, allAuthors};
    }

    public void repaintButtons(SCREENS screen){
        clearSidebarSelectedDesign();
        JButton activeButton = null;
        switch (screen){
            case Books: activeButton = allBooksButton; break;
            case AddBook: activeButton = allBooksButton; break;
            case AddMember: activeButton = allMembersButton; break;
            case Members: activeButton = allMembersButton; break;
            case AddAuthor:
            case Authors: activeButton = allAuthors; break;
        }
        if(activeButton != null){
            markAsSelected(activeButton);
        }
    }

    public static Dashboard getInstance() {
        if(instance == null){
            instance = new Dashboard();
        }
        return instance;
    }

    void clearSidebarSelectedDesign(){
        for(JButton btn : getAsideButtons()){
            btn.setBackground(Color.getColor("#EBEBEB"));
            btn.setForeground(Color.black);
//            btn.setOpaque(false);
//            btn.setBorderPainted(false);
        }
    }

    void markAsSelected(JButton btn){
        if(btn == null) return;
        //41 53 158
        btn.setBackground(Color.decode("#29359E"));
        btn.setForeground(Color.white);
//        btn.setOpaque(true);
//        btn.setBorderPainted(false);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
