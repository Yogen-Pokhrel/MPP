package project.screens;

import project.business.Address;
import project.business.AuthException;
import project.business.LibraryMember;
import project.business.SystemController;
import project.utils.DialogUtils;
import project.utils.ValidationUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddMember extends Routes implements Component {
    private JPanel contentPane;
    private JPanel inner;
    private JButton saveButton;
    private JTextField fName;
    private JTextField lName;
    private JTextField phone;
    private JTextField street;
    private JTextField city;
    private JTextField state;
    private JTextField zipCode;
    private JLabel fNameLabel;
    private JLabel lNameLabel;
    private JLabel phoneNumberLabel;
    private JLabel addressLabel;
    private JLabel streetLabel;
    private JLabel cityLabel;
    private JLabel stateLabel;
    private JLabel zipCodeLabel;
    private StringBuilder validationMessage;

    private static AddMember instance;

    private AddMember() {
        validationMessage = new StringBuilder();

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        saveButton.addActionListener(e -> {
            validationMessage.setLength(0);
            validateInput();
            if (!validationMessage.isEmpty()) {
                DialogUtils.showValidationMessage(validationMessage.toString());
                return;
            }
            LibraryMember libraryMember = new LibraryMember(
                    ("M-" + java.lang.System.currentTimeMillis()),
                    fName.getText().trim(),
                    lName.getText().trim(),
                    phone.getText().trim(),
                    new Address(street.getText().trim(), city.getText().trim(), state.getText().trim(),
                            zipCode.getText().trim()));
            SystemController systemController = new SystemController();
            try{
                systemController.addNewMember(libraryMember);
                DialogUtils.showSuccessMessage(
                        "Member " + fName.getText().trim() + " " + lName.getText().trim() + " created successfully!");
                navigateTo(SCREENS.Members);
            }catch (AuthException authException){
                DialogUtils.showMessage(authException.getMessage(), "Error");
            }
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
        instance = new AddMember();
        return instance;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    void validateInput() {
        validateEmptyFields();
        ValidationUtils.validatePhoneNumber(phone, phoneNumberLabel, validationMessage);
        ValidationUtils.validateZipCode(zipCode, zipCodeLabel, validationMessage);
    }

    void validateEmptyFields() {
        ValidationUtils.validateField(fName, fNameLabel, validationMessage);
        ValidationUtils.validateField(lName, lNameLabel, validationMessage);
        ValidationUtils.validateField(phone, phoneNumberLabel, validationMessage);
        ValidationUtils.validateField(street, streetLabel, validationMessage);
        ValidationUtils.validateField(city, cityLabel, validationMessage);
        ValidationUtils.validateField(state, stateLabel, validationMessage);
        ValidationUtils.validateField(zipCode, zipCodeLabel, validationMessage);
    }
}
