package project.utils;

import javax.swing.JOptionPane;

public class DialogUtils {

    public static void showValidationMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Validation Error", JOptionPane.WARNING_MESSAGE);
    }

    public static void showSuccessMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.PLAIN_MESSAGE);
    }

    public static void showMessage(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
    }
}