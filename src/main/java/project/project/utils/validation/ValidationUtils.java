package project.project.utils.validation;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtils {
     private static boolean isValidPhoneNumber(String phoneNumber) {
        String regex = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
        return validateRegex(regex, phoneNumber);
    }

    private static boolean isValidZipCode(String zipCode){
        String regex = "\\d{5}(-\\d{4})?";
        return validateRegex(regex, zipCode);
    }

    static boolean validateRegex(String regex, String input){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static String validateField(JTextField textField, JLabel label){
        if (textField.getText().isEmpty()) {
            textField.requestFocusInWindow();
            return label.getText().trim() + " is empty\n";
        }
        return null;
    }

    public static String validatePhoneNumber(JTextField textField, JLabel label){
        if(textField.getText().isEmpty()) return null;
        if (isValidPhoneNumber(textField.getText())) {
            return null;
        }
        textField.requestFocusInWindow();
        return "Enter a valid " + label.getText().trim() + "\n";
    }

    public static String validateZipCode(JTextField textField, JLabel label){
        if(textField.getText().isEmpty()) return null;
        if (isValidZipCode(textField.getText())) {
            return null;
        }
        textField.requestFocusInWindow();
        return "Enter a valid " + label.getText().trim() + "\n";
    }
}
