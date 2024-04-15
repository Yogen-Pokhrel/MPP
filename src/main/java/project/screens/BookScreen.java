package project.screens;

import project.business.*;
import project.dataaccess.Auth;
import project.screens.RecordTable.RecordTable;
import project.utils.DialogUtils;
import project.utils.ValidationUtils;

import javax.swing.*;
import javax.swing.table.TableColumnModel;

import java.awt.*;
import java.util.HashMap;

public class BookScreen extends Routes implements Component {
    private JButton button1;

    private static BookScreen instance;
    private JPanel contentPane;
    private JTable dataTable;

    private BookScreen() {
    }

    public static BookScreen getInstance() {
        instance = new BookScreen();
        return instance;
    }

    @Override
    public JPanel getMainPanel() {
        return contentPane;
    }

    @Override
    public void render() {
        Dashboard dash = Dashboard.getInstance();
        dash.setPageTitle("Books List");
        dash.setPageButtonTitle("Add Book");
        dash.setPageButtonVisibility(true);
        dash.repaintButtons(SCREENS.Books);
        JButton pageButton = dash.getPageButton();
        removeAllActionListenersOfButton(pageButton);
        pageButton.addActionListener(e -> navigateTo(SCREENS.AddBook));
        JPanel mainPanel = dash.getInnerPanel();
        paintTableData();
        mainPanel.removeAll();
        mainPanel.add(getMainPanel());
        thread.setContentPane(dash.getMainPanel());
        refresh();
    }

    public void paintTableData() {
        String[] columnNames = new String[] { "ISBN", "Book Name", "Copies", "Available", "Author Name", "Action" };

        SystemController controller = new SystemController();
        HashMap<String, Book> books = controller.getAllBooks();
        Object[][] data = new Object[books.size()][];
        int index = 0;
        for (Book book : books.values()) {
            java.util.List<Author> authors = book.getAuthors();
            StringBuilder authorNames = new StringBuilder();
            if (!authors.isEmpty()) {
                for (int i = 0; i < authors.size() - 1; i++) {
                    Author author = authors.get(i);
                    authorNames.append(author.getFirstName()).append(" ").append(author.getLastName()).append(", ");
                }
                Author author = authors.get(authors.size() - 1);
                authorNames.append(author.getFirstName()).append(" ").append(author.getLastName());
            }
            int availableCopies = 0;
            for (BookCopy bookCopy : book.getCopies()) {
                if (bookCopy.isAvailable()) {
                    availableCopies++;
                }
            }
            data[index++] = (new Object[] { book.getIsbn(), book.getTitle(), book.getNumCopies(), availableCopies,
                    authorNames.toString(), book });
        }

        dataTable = new RecordTable(data, columnNames);

        TableColumnModel columnModel = dataTable.getColumnModel();

        columnModel.getColumn(0).setPreferredWidth(30);
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(2).setPreferredWidth(10);
        columnModel.getColumn(3).setPreferredWidth(10);
        columnModel.getColumn(4).setPreferredWidth(150);
        columnModel.getColumn(5).setPreferredWidth(10);

        if (SystemController.currentAuth == Auth.LIBRARIAN) {
            dataTable.getColumnModel().removeColumn(dataTable.getColumnModel().getColumn(5));
        }
        else {
            ((RecordTable) dataTable).addActionListener(5, "Add Copy", (Object obj) -> {
                String inputValue = JOptionPane.showInputDialog(this, "Enter number of copies:", "Add Copies", JOptionPane.PLAIN_MESSAGE);
                boolean isValid = ValidationUtils.isValidCopyNum(inputValue);
                if(!isValid) {
                    DialogUtils.showValidationMessage("Copy Number is invalid!");
                    return;
                }
                try{
                    Book book = (Book) obj;
                    book.addCopy(Integer.parseInt(inputValue));
                    controller.updateBook(book);
                    BookScreen.getInstance().render();
                }catch (AuthException authException){
                    DialogUtils.showMessage(authException.getMessage(), "Error");
                }
            });
        }

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        paintTableData();
        UIDefaults defaults = UIManager.getLookAndFeelDefaults();
        defaults.putIfAbsent("Table.alternateRowColor", Color.LIGHT_GRAY);
    }
}
