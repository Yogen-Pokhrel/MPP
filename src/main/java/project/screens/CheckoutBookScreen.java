package project.screens;

import project.business.*;
import project.dataaccess.DataAccess;
import project.dataaccess.DataAccessFacade;
import project.project.utils.validation.DialogUtils;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class CheckoutBookScreen extends Routes implements Component {

    private static CheckoutBookScreen instance;
    private JPanel contentPane;

    private JPanel inner;
    private JButton submitButton;
    private JButton clearButton;
    private JTextField memberId;
    private JTextField isbn;
    private JTable dataTable;
    private JScrollPane dataTableWrapper;

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
                 return;
             }
             BookCopy bookCopy = null;
             try{
                 bookCopy = book.getNextAvailableCopy();
             }catch (NullPointerException nullPointerException){
                 DialogUtils.showValidationMessage(nullPointerException.getMessage());
                 return;
             }

            CheckoutRecord checkoutRecord = new CheckoutRecord(
                    libraryMember,
                    new CheckoutEntry(book, bookCopy)
            );

            DataAccess da = new DataAccessFacade();
            da.saveNewCheckoutRecord(checkoutRecord);
//            paintTableData(memberId);
        });
        clearButton.addActionListener(e -> {

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
        CheckoutRecord checkoutRecord;
        try{
             checkoutRecord = controller.getCheckoutRecordByMemberId(memberId);
            System.out.println("Record Length " + checkoutRecord.getCheckoutEntry().size());
            for(CheckoutEntry ch: checkoutRecord.getCheckoutEntry()){
                System.out.println("Check out record" + ch.getBook().getIsbn());
            }
        }catch (NullPointerException nullPointerException){
            return;
        }

        Object[][] data = new Object[checkoutRecord.getCheckoutEntry().size()][];
        int index = 0;
        for(CheckoutEntry checkoutEntry: checkoutRecord.getCheckoutEntry()){
            data[index++] =(new Object[]{checkoutEntry.getBookCopy().getCopyNum(), checkoutEntry.getBook().getIsbn(), checkoutEntry.getCheckoutDate(), checkoutEntry.getDueDate() });
        }

        dataTable = new JTable(data, columnNames);
        dataTable.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 16));
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        paintTableData("1001");
        UIDefaults defaults = UIManager.getLookAndFeelDefaults();
        defaults.putIfAbsent("Table.alternateRowColor", Color.LIGHT_GRAY);
    }
}
