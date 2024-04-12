package project.project.utils.validation;

import javax.swing.JOptionPane;

public class DialogUtils {

    public static void showValidationMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Validation Error", JOptionPane.WARNING_MESSAGE);
    }
}