package project.screens;

import project.business.*;
import project.project.utils.validation.DialogUtils;
import project.project.utils.validation.ValidationUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CheckoutBookScreen extends Routes implements Component {

    private static CheckoutBookScreen instance;
    private JPanel contentPane;

    private JPanel innerPanel;
    private JButton submitButton;
    private JButton clearButton;
    private JTextField memberId;
    private JTextField isbn;
    private JTable dataTable;
    private JScrollPane dataTableWrapper;
    private JLabel isbnLabel;
    private JLabel memberLabel;
    private StringBuilder validationMessage;


    public CheckoutBookScreen() {
        validationMessage= new StringBuilder();

        submitButton.addActionListener(e -> {
            validationMessage.setLength(0);
            validateInput();
            if(!validationMessage.isEmpty()){
                DialogUtils.showValidationMessage(validationMessage.toString());
                return;
            }

            SystemController controller = new SystemController();
            String memberId = this.memberId.getText().trim();
            String isbn = ValidationUtils.formatISBN(this.isbn.getText().trim());
//            String isbn = this.isbn.getText().trim();
            LibraryMember libraryMember = null;
            Book book = null;




             try{
                 libraryMember = controller.getMemberByID(memberId);
                 book = controller.getBookByISBN(isbn);
             }catch (NullPointerException nullPointerException){
                 DialogUtils.showValidationMessage(nullPointerException.getMessage());
                 return;
             }
             BookCopy bookCopy = book.getNextAvailableCopy();
             if(bookCopy == null){
                 DialogUtils.showValidationMessage("No copies of this book is available");
                 return;
             }

            CheckoutRecord checkoutRecord = controller.getCheckoutRecordByMemberId(memberId);
             if(checkoutRecord == null){
                 checkoutRecord = new CheckoutRecord(
                         libraryMember,
                         new CheckoutEntry(book, bookCopy)
                 );
             }else{
                 checkoutRecord.getCheckoutEntry().add(new CheckoutEntry(book, bookCopy));
             }

             controller.addNewCheckoutRecord(checkoutRecord);
             controller.addNewBook(book);
            paintTableData(memberId);
        });
        clearButton.addActionListener(e -> {
            memberId.setText("");
            isbn.setText("");
            paintTableData("");
        });
    }

    public static CheckoutBookScreen getInstance() {
        instance = new CheckoutBookScreen();
        return instance;
    }

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


    void paintTableData(String memberId){
        String[] columnNames = { "Copy Num", "ISBN", "Book Name", "Checkout Date", "Due Date" };
        SystemController controller = new SystemController();
        CheckoutRecord checkoutRecord = controller.getCheckoutRecordByMemberId(memberId);
        if(checkoutRecord == null) {
            DefaultTableModel model = new DefaultTableModel();
            dataTable.setModel(model);
            return;
        };

        Object[][] data = new Object[checkoutRecord.getCheckoutEntry().size()][];
        int index = 0;
        for(CheckoutEntry checkoutEntry: checkoutRecord.getCheckoutEntry()){
            data[index++] =(new Object[]{checkoutEntry.getBookCopy().getCopyNum(), checkoutEntry.getBook().getIsbn(), checkoutEntry.getBook().getTitle(), checkoutEntry.getCheckoutDate(), checkoutEntry.getDueDate(), });
        }

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        dataTable.setModel(model);
        dataTable.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 16));
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        dataTable = new JTable();
        paintTableData("1001");
        UIDefaults defaults = UIManager.getLookAndFeelDefaults();
        defaults.putIfAbsent("Table.alternateRowColor", Color.LIGHT_GRAY);
    }

    void  validateInput(){
        validateEmptyFields();
        ValidationUtils.validateISBN(isbn, isbnLabel, validationMessage);
    }

    void validateEmptyFields(){
        ValidationUtils.validateField(memberId, memberLabel, validationMessage);
        ValidationUtils.validateField(isbn, isbnLabel, validationMessage);
    }
}
