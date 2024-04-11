package project.screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Routes extends JFrame {
    public static Routes thread = new Routes();

    Routes(){
        //override default margin and paddings
    }
    enum SCREENS {
        Login,
        Books,
        Members,
        AddBooks,
        AddMembers
    }

    void init(){
        navigateTo(SCREENS.Members);
    }

    void navigateTo(SCREENS screen){
        switch (screen){
            case Login -> loginNavigator();
            case Books -> booksNavigator();
            case AddBooks -> addBooksNavigator();
            case Members -> membersNavigator();
            default -> loginNavigator();
        }
    }

    private void loginNavigator(){
        thread.setContentPane(Login.getInstance().getMainPanel());
        thread.revalidate();
        thread.repaint();
    }

    private void booksNavigator(){
        Dashboard dash = Dashboard.getInstance();
        dash.setPageTitle("Books List");
        dash.setPageButtonTitle("Add Book");
        dash.repaintButtons(SCREENS.Books);
        JButton b = dash.getPageButton();
        removeAllActionListenersOfButton(b);
        b.addActionListener(e -> navigateTo(SCREENS.AddBooks));
        JPanel mainPanel = dash.getInnerPanel();
        Book book = Book.getInstance();
        book.paintTableData();
        mainPanel.removeAll();
        mainPanel.add(book.getMainPanel());
        thread.setContentPane(dash.getMainPanel());
        thread.revalidate();
        thread.repaint();
    }

    private void addBooksNavigator(){
        Dashboard dash = Dashboard.getInstance();
        dash.setPageTitle("Books List");
        dash.setPageButtonTitle("Add Book");
        dash.repaintButtons(SCREENS.Books);
        JButton b = dash.getPageButton();
        removeAllActionListenersOfButton(b);
        b.addActionListener(e -> navigateTo(SCREENS.Members));
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
        dash.setPageTitle("Members List");
        dash.setPageButtonTitle("Add Member");
        dash.repaintButtons(SCREENS.Members);
        JButton b = dash.getPageButton();
        removeAllActionListenersOfButton(b);
        b.addActionListener(e -> navigateTo(SCREENS.Books));
        JPanel mainPanel = dash.getInnerPanel();
        mainPanel.removeAll();
        Member member = Member.getInstance();
        mainPanel.add(member.getMainPanel());
        member.paintTableData();
        thread.setContentPane(dash.getMainPanel());
        thread.revalidate();
        thread.repaint();
    }

    void removeAllActionListenersOfButton(JButton button){
        ActionListener[] listeners = button.getActionListeners();
        for( ActionListener al : listeners ) {
            button.removeActionListener( al );
        }
    }
}
