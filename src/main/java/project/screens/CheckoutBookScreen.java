package project.screens;

import project.business.*;
import project.dataaccess.DataAccess;
import project.dataaccess.DataAccessFacade;
import project.project.utils.validation.DialogUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckoutBookScreen extends Routes implements Component {

    private static CheckoutBookScreen instance;

    public CheckoutBookScreen() {
        submitButton.addActionListener(e -> {
            SystemController controller = new SystemController();
             String memberId = this.memberId.getText();
             String isbn = this.isbn.getText();
            LibraryMember libraryMember = null;
            Book book = null;
             try{
                 libraryMember = controller.getMemberByID(memberId);
                 book = controller.getBookByISBN(isbn);
             }catch (NullPointerException nullPointerException){
                 DialogUtils.showValidationMessage(nullPointerException.getMessage());
             }
            CheckoutRecord checkoutRecord = new CheckoutRecord(
                    libraryMember,
                    new CheckoutEntry(book)
            );
            DataAccess da = new DataAccessFacade();
            da.saveNewCheckoutRecord(checkoutRecord);
        });
        clearButton.addActionListener(e -> {

        });
    }

    public static CheckoutBookScreen getInstance() {
//        if (instance == null) {
//            instance = new CheckoutBookScreen();
//        }
        instance = new CheckoutBookScreen();
        return instance;
    }

    private JPanel contentPane;

    private JPanel inner;
    private JButton submitButton;
    private JButton clearButton;
    private JTextField memberId;
    private JTextField isbn;

    @Override
    public JPanel getMainPanel() {
        return contentPane;
    }

    @Override
    public void render() {
        Dashboard dash = Dashboard.getInstance();
        dash.setPageTitle("Checkout books");
        dash.setPageButtonVisibility(false);
        dash.repaintButtons(SCREENS.CheckoutBook);
        JPanel mainPanel = dash.getInnerPanel();
        mainPanel.removeAll();
        mainPanel.add(getMainPanel());
        thread.setContentPane(dash.getMainPanel());
        refresh();
    }
}
