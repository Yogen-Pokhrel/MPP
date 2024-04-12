package project.screens;

import project.business.Author;
import project.business.Book;
import project.business.SystemController;
import project.dataaccess.Auth;
import project.screens.BookTable.BookTable;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class BookScreen extends Routes implements Component {
    private JButton button1;

    private static BookScreen instance;
    private JPanel contentPane;
    private JTable dataTable;

    private BookScreen() {
    }

    public static BookScreen getInstance() {
        // if(instance == null){
        // instance = new BookScreen();
        // }
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
        String[] columnNames = new String[] { "ISBN", "Book Name", "Copies", "Author Name" };
        if (SystemController.currentAuth != Auth.LIBRARIAN) {
            columnNames = new String[] { "ISBN", "Book Name", "Copies", "Author Name", "Action" };
        }

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

            data[index++] = (new Object[] { book.getIsbn(), book.getTitle(), book.getNumCopies(),
                    authorNames.toString(), book });
        }

        dataTable = new BookTable(data, columnNames);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        paintTableData();
        UIDefaults defaults = UIManager.getLookAndFeelDefaults();
        defaults.putIfAbsent("Table.alternateRowColor", Color.LIGHT_GRAY);
    }
}
