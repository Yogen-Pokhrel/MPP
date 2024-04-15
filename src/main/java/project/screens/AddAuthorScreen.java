package project.screens;

import project.business.Address;
import project.business.Author;
import project.business.SystemController;
import project.utils.DialogUtils;
import project.utils.ValidationUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAuthorScreen extends Routes implements Component {

    private static AddAuthorScreen instance;

    public static AddAuthorScreen getInstance() {
        if(instance == null){
            instance = new AddAuthorScreen();
        }
        return instance;
    }

    private JPanel contentPane;
    private JPanel inner;
    private JCheckBox hasCredentials;
    private JButton saveButton;
    private JLabel fNameLabel;
    private JTextField fNameTextField;
    private JLabel lNameLabel;
    private JTextField lNameTextField;
    private JLabel phoneNumLabel;
    private JTextField phoneNumTextField;
    private JLabel bioLabel;
    private JTextField bioTextField;
    private JLabel addressLabel;
    private JLabel streetLabel;
    private JTextField streetTextField;
    private JLabel cityLabel;
    private JTextField cityTextField;
    private JLabel stateLabel;
    private JTextField stateTextField;

    private JLabel zipLabel;

    private JTextField zipTextField;
    private JButton cancelButton;

    private StringBuilder validationMessage;

    private SCREENS redirection;

    public AddAuthorScreen() {
        validationMessage = new StringBuilder();
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validationMessage.setLength(0);
                validateInput();
                if (!validationMessage.isEmpty()) {
                    DialogUtils.showValidationMessage(validationMessage.toString());
                    return;
                }
                Author author = new Author(
                        fNameTextField.getText().trim(),
                        lNameTextField.getText().trim(),
                        phoneNumTextField.getText().trim(),
                        new Address(
                                streetTextField.getText().trim(),
                                cityTextField.getText().trim(),
                                stateTextField.getText().trim(),
                                zipTextField.getText().trim()),
                        bioTextField.getText().trim(),
                        hasCredentials.isSelected());
                SystemController systemController = new SystemController();
                systemController.addNewAuthor(author);
                DialogUtils.showSuccessMessage("Author " + fNameTextField.getText().trim() + " "
                        + lNameTextField.getText().trim() + " created successfully!");
                resetForm();
                if(redirection == null){
                    navigateTo(SCREENS.Authors);
                }else {
                    SCREENS temp = redirection;
                    redirection = null;
                    navigateTo(temp);
                }
            }
        });
        cancelButton.addActionListener(e ->{
            resetForm();
            if(redirection == null){
                navigateTo(SCREENS.Authors);
            }else {
                SCREENS temp = redirection;
                redirection = null;
                navigateTo(temp);
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
        dash.setPageTitle("Add author");
        dash.setPageButtonVisibility(false);
        dash.repaintButtons(SCREENS.Authors);
        JPanel mainPanel = dash.getInnerPanel();
        mainPanel.removeAll();
        mainPanel.add(getMainPanel());
        thread.setContentPane(dash.getMainPanel());
        refresh();
    }

    public void render(SCREENS navigateTo) {
        redirection = navigateTo;
        render();
    }

    void validateInput() {
        validateEmptyFields();
        ValidationUtils.validatePhoneNumber(phoneNumTextField, phoneNumLabel, validationMessage);
        ValidationUtils.validateZipCode(zipTextField, zipLabel, validationMessage);
    }

    void validateEmptyFields() {
        ValidationUtils.validateField(fNameTextField, fNameLabel, validationMessage);
        ValidationUtils.validateField(lNameTextField, lNameLabel, validationMessage);
        ValidationUtils.validateField(phoneNumTextField, phoneNumLabel, validationMessage);
        ValidationUtils.validateField(bioTextField, bioLabel, validationMessage);
        ValidationUtils.validateField(streetTextField, streetLabel, validationMessage);
        ValidationUtils.validateField(cityTextField, cityLabel, validationMessage);
        ValidationUtils.validateField(stateTextField, stateLabel, validationMessage);
        ValidationUtils.validateField(zipTextField, zipLabel, validationMessage);
    }

    private void createUIComponents() {
    }

    void resetForm(){
        fNameTextField.setText("");
        lNameTextField.setText("");
        phoneNumTextField.setText("");
        bioTextField.setText("");
        streetTextField.setText("");
        cityTextField.setText("");
        stateTextField.setText("");
        zipTextField.setText("");
    }
}
