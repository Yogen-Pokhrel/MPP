package project.screens;

import project.business.Person;

import javax.swing.*;
import java.awt.*;

public class Routes extends JFrame {
    private Person loggedinUser;
    private boolean isLoggedIn = false;

    private Component activeScreen = new Login();
    public static Routes thread = new Routes();

    Routes(){
        //override default margin and paddings
    }
    enum screens {
        Login,
        ListBooks,
        ListMembers
    }

    void init(){
        thread.setContentPane(activeScreen.getMainPanel());
    }


}
