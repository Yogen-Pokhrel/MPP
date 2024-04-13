package project.utils;

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

    private static boolean isValidISBN(String isbn){
        String regex = "\\d{2}(-?\\d{5})";
        return validateRegex(regex, isbn);
    }

    static boolean validateRegex(String regex, String input){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static void validateField(JTextField textField, JLabel label, StringBuilder stringBuilder){
        if (textField.getText().trim().isEmpty()) {
            textField.requestFocusInWindow();
            stringBuilder.append(label.getText().trim() + " is empty\n");
        }
    }

    public static void validatePhoneNumber(JTextField textField, JLabel label, StringBuilder stringBuilder){
        if(textField.getText().trim().isEmpty()) return;
        if (isValidPhoneNumber(textField.getText())) {
            return;
        }
        textField.requestFocusInWindow();
        stringBuilder.append("Enter a valid " + label.getText().trim() + "\n");
    }

    public static void validateZipCode(JTextField textField, JLabel label,StringBuilder stringBuilder){
        if(textField.getText().trim().isEmpty()) return ;
        if (isValidZipCode(textField.getText())) {
            return;
        }
        textField.requestFocusInWindow();
        stringBuilder.append("Enter a valid " + label.getText().trim() + "\n");
    }

    public static void validateISBN(JTextField textField, JLabel label,StringBuilder stringBuilder){
        if(textField.getText().trim().isEmpty()) return ;
        if (isValidISBN(textField.getText().trim())) {
            return;
        }
        textField.requestFocusInWindow();
        stringBuilder.append("Enter a valid " + label.getText().trim() + "\n");
    }

    public static String formatISBN(String input) {
        if (input.matches("\\d{2}-\\d{5}")) {
            // Input is already in the correct format
            return input;
        } else if (input.matches("\\d{7}")) {
            // Input is in the second format, convert it to the first format
            return input.substring(0, 2) + "-" + input.substring(2);
        } else {
            // Input has invalid format, handle accordingly
            return "Invalid input format";
        }
    }
}
