package project.screens;

import project.business.Address;
import project.business.Book;
import project.business.LibraryMember;
import project.business.SystemController;
import project.dataaccess.DataAccess;
import project.dataaccess.DataAccessFacade;
import project.project.utils.validation.DialogUtils;
import project.project.utils.validation.ValidationUtils;

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
    private JLabel fNameLabel;
    private JLabel lNameLabel;
    private JLabel phoneNumberLabel;
    private JLabel bioLabel;
    private JLabel addressLabel;
    private JLabel streetLabel;
    private JLabel cityLabel;
    private JLabel stateLabel;
    private JLabel zipCodeLabel;
    private StringBuilder validationMessage;

    private static AddMember instance;

    private AddMember() {
        validationMessage= new StringBuilder();

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        saveButton.addActionListener(e -> {
            validationMessage.setLength(0);
            validateInput();
            if(!validationMessage.isEmpty()){
                DialogUtils.showValidationMessage(validationMessage.toString());
                return;
            }
            LibraryMember libraryMember = new LibraryMember(
                    ("M-" + java.lang.System.currentTimeMillis()),
                    fName.getText().trim(),
                    lName.getText().trim(),
                    phone.getText().trim(),
                    new Address(street.getText().trim(), city.getText().trim(), state.getText().trim(), zipCode.getText().trim())
            );
            SystemController systemController = new SystemController();
            systemController.addNewMember(libraryMember);
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

    void  validateInput(){
        validateEmptyFields();
        ValidationUtils.validatePhoneNumber(phone, phoneNumberLabel, validationMessage);
        ValidationUtils.validateZipCode(zipCode, zipCodeLabel, validationMessage);
    }

    void validateEmptyFields(){
        ValidationUtils.validateField(fName, fNameLabel, validationMessage);
        ValidationUtils.validateField(lName, lNameLabel, validationMessage);
        ValidationUtils.validateField(phone, phoneNumberLabel, validationMessage);
        ValidationUtils.validateField(bio, bioLabel, validationMessage);
        ValidationUtils.validateField(street, streetLabel, validationMessage);
        ValidationUtils.validateField(city, cityLabel, validationMessage);
        ValidationUtils.validateField(state, stateLabel, validationMessage);
        ValidationUtils.validateField(zipCode, zipCodeLabel, validationMessage);
    }
}
