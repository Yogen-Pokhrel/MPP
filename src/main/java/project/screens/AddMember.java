package project.screens;

import project.business.Address;
import project.business.Book;
import project.business.LibraryMember;
import project.dataaccess.DataAccess;
import project.dataaccess.DataAccessFacade;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddMember extends Routes implements Component{
    private JPanel contentPane;
    private JPanel inner;
    private JButton saveButton;
    private JTextField fName;
    private JTextField lName;
    private JTextField phone;
    private JTextField bio;
    private JTextField street;
    private JTextField city;
    private JTextField state;
    private JTextField zipCode;
    private static AddMember instance;

    private AddMember() {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        saveButton.addActionListener(e -> {
            LibraryMember libraryMember = new LibraryMember(
                    ("M-" + java.lang.System.currentTimeMillis()),
                    fName.getText(),
                    lName.getText(),
                    phone.getText(),
                    new Address(street.getText(), city.getText(), state.getText(), zipCode.getText())
            );
            DataAccess da = new DataAccessFacade();
            da.saveNewMember(libraryMember);
        });
    }

    @Override
    public JPanel getMainPanel() {
        return contentPane;
}

    @Override
    public void render() {
        Dashboard dash = Dashboard.getInstance();
        dash.setPageTitle("Add a Member");
        dash.setPageButtonVisibility(false);
        dash.repaintButtons(SCREENS.Members);
        JPanel mainPanel = dash.getInnerPanel();
        mainPanel.removeAll();
        mainPanel.add(getMainPanel());
        thread.setContentPane(dash.getMainPanel());
        refresh();
    }

    public static AddMember getInstance() {
//        if(instance == null){
//            instance = new AddMember();
//        }
        instance = new AddMember();
        return instance;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
