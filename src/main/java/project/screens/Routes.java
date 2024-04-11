package project.screens;

import javax.swing.*;

public class Routes extends JFrame {
    public static Routes thread = new Routes();

    Routes(){
        //override default margin and paddings
    }
    enum SCREENS {
        Login,
        Books,
        Members
    }

    void init(){
        navigateTo(SCREENS.Login);
    }

    void navigateTo(SCREENS screen){
        switch (screen){
            case Login -> loginNavigator();
            case Books -> booksNavigator();
            case Members -> membersNavigator();
            default -> loginNavigator();
        }
    }

    private void loginNavigator(){
        thread.setContentPane(Login.getInstance().getMainPanel());
    }

    private void booksNavigator(){
        Dashboard dash = Dashboard.getInstance();
        JPanel mainPanel = dash.getInnerPanel();
        AddBook book = AddBook.getInstance();
        mainPanel.removeAll();
        mainPanel.add(book.getMainPanel());
        thread.setContentPane(dash.getMainPanel());
        thread.revalidate();
        thread.repaint();
    }

    private void membersNavigator(){
        Dashboard dash = Dashboard.getInstance();
        JPanel mainPanel = dash.getInnerPanel();
        mainPanel.removeAll();
        Member member = Member.getInstance();
        mainPanel.add(member.getMainPanel());
        thread.setContentPane(dash.getMainPanel());
        thread.revalidate();
        thread.repaint();
    }

}
