package project.screens;

import project.business.Address;
import project.business.Author;
import project.business.SystemController;
import project.dataaccess.DataAccess;
import project.dataaccess.DataAccessFacade;
import project.project.utils.validation.DialogUtils;
import project.project.utils.validation.ValidationUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAuthorScreen extends Routes implements Component {

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

    private StringBuilder validationMessage;

    private static AddAuthorScreen instance;

    public AddAuthorScreen() {
        validationMessage= new StringBuilder();
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validationMessage.setLength(0);
                validateInput();
                if(!validationMessage.isEmpty()){
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
                                zipTextField.getText().trim()
                        ),
                        bioTextField.getText().trim()
                );
                SystemController systemController = new SystemController();
                systemController.addNewAuthor(author);
            }
        });
    }

    public static AddAuthorScreen getInstance() {
//        if(instance == null){
//            instance = new AddAuthorScreen();
//        }
        instance = new AddAuthorScreen();
        return instance;
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

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
    void  validateInput(){
        validateEmptyFields();
        ValidationUtils.validatePhoneNumber(phoneNumTextField, phoneNumLabel, validationMessage);
        ValidationUtils.validateZipCode(zipTextField, zipLabel, validationMessage);
    }

    void validateEmptyFields(){
        ValidationUtils.validateField(fNameTextField, fNameLabel, validationMessage);
        ValidationUtils.validateField(lNameTextField, lNameLabel, validationMessage);
        ValidationUtils.validateField(phoneNumTextField, phoneNumLabel, validationMessage);
        ValidationUtils.validateField(bioTextField, bioLabel, validationMessage);
        ValidationUtils.validateField(streetTextField, streetLabel, validationMessage);
        ValidationUtils.validateField(cityTextField, cityLabel, validationMessage);
        ValidationUtils.validateField(stateTextField, stateLabel, validationMessage);
        ValidationUtils.validateField(zipTextField, zipLabel, validationMessage);
    }
}
