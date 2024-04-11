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
        AddBook,
        AddMember,
        Authors,
        AddAuthor
    }

    void init(){
        navigateTo(SCREENS.Books);
    }

    void navigateTo(SCREENS screen){
        switch (screen){
            case Login -> loginNavigator();
            case Books -> booksNavigator();
            case AddBook -> addBooksNavigator();
            case Members -> membersNavigator();
            case AddMember -> addMembersNavigator();
            case Authors -> authorsNavigator();
            case AddAuthor -> addAuthorsNavigator();
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
        dash.setPageButtonVisibility(true);
        dash.repaintButtons(SCREENS.Books);
        JButton b = dash.getPageButton();
        removeAllActionListenersOfButton(b);
        b.addActionListener(e -> navigateTo(SCREENS.AddBook));
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
        dash.setPageTitle("Add a book");
        dash.setPageButtonVisibility(false);
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
        dash.setPageButtonVisibility(true);
        dash.repaintButtons(SCREENS.Members);
        JButton b = dash.getPageButton();
        removeAllActionListenersOfButton(b);
        b.addActionListener(e -> navigateTo(SCREENS.AddMember));
        JPanel mainPanel = dash.getInnerPanel();
        mainPanel.removeAll();
        Member member = Member.getInstance();
        mainPanel.add(member.getMainPanel());
        member.paintTableData();
        thread.setContentPane(dash.getMainPanel());
        thread.revalidate();
        thread.repaint();
    }

    private void authorsNavigator(){
        Dashboard dash = Dashboard.getInstance();
        dash.setPageTitle("Authors List");
        dash.setPageButtonTitle("Add Author");
        dash.setPageButtonVisibility(true);
        dash.repaintButtons(SCREENS.Authors);
        JButton b = dash.getPageButton();
        removeAllActionListenersOfButton(b);
        b.addActionListener(e -> navigateTo(SCREENS.AddAuthor));
        JPanel mainPanel = dash.getInnerPanel();
        mainPanel.removeAll();
        Author member = Author.getInstance();
        mainPanel.add(member.getMainPanel());
        member.paintTableData();
        thread.setContentPane(dash.getMainPanel());
        thread.revalidate();
        thread.repaint();
    }

    private void addMembersNavigator(){
        Dashboard dash = Dashboard.getInstance();
        dash.setPageTitle("Add a Member");
        dash.setPageButtonVisibility(false);
        dash.repaintButtons(SCREENS.Members);
        JButton b = dash.getPageButton();
        removeAllActionListenersOfButton(b);
        JPanel mainPanel = dash.getInnerPanel();
        mainPanel.removeAll();
        AddMember member = AddMember.getInstance();
        mainPanel.add(member.getMainPanel());
        thread.setContentPane(dash.getMainPanel());
        thread.revalidate();
        thread.repaint();
    }

    private void addAuthorsNavigator(){
        Dashboard dash = Dashboard.getInstance();
        dash.setPageTitle("Add author");
        dash.setPageButtonVisibility(false);
        dash.repaintButtons(SCREENS.Authors);
        JButton b = dash.getPageButton();
        removeAllActionListenersOfButton(b);
        JPanel mainPanel = dash.getInnerPanel();
        mainPanel.removeAll();
        AddAuthor member = AddAuthor.getInstance();
        mainPanel.add(member.getMainPanel());
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
