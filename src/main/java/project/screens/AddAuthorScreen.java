package project.screens;

import project.business.Address;
import project.business.Author;
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
                      fNameTextField.getText(),
                      lNameTextField.getText(),
                        phoneNumTextField.getText(),
                        new Address(
                                streetTextField.getText(),
                                cityTextField.getText(),
                                stateTextField.getText(),
                                zipTextField.getText()
                        ),
                        bioTextField.getText()
                );
                DataAccess da = new DataAccessFacade();
                da.saveNewAuthor(author);
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
        appendMsg(ValidationUtils.validatePhoneNumber(phoneNumTextField, phoneNumLabel));
        validateZip();
    }

    void validateEmptyFields(){
        appendMsg(ValidationUtils.validateField(fNameTextField, fNameLabel));
        appendMsg(ValidationUtils.validateField(lNameTextField, lNameLabel));
        appendMsg(ValidationUtils.validateField(phoneNumTextField, phoneNumLabel));
        appendMsg(ValidationUtils.validateField(bioTextField, bioLabel));
        appendMsg(ValidationUtils.validateField(streetTextField, streetLabel));
        appendMsg(ValidationUtils.validateField(cityTextField, cityLabel));
        appendMsg(ValidationUtils.validateField(stateTextField, stateLabel));
        appendMsg(ValidationUtils.validateField(zipTextField, zipLabel));
    }

    void appendMsg(String msg){
        if(msg!= null){
            validationMessage.append(msg);
        }
    }

    void validateZip(){
        if(zipTextField.getText().isEmpty()) return;
        if(ValidationUtils.isValidZipCode(zipTextField.getText())) return;
        validationMessage.append("Enter a valid zip code\n");
        zipTextField.requestFocusInWindow();
    }
}
