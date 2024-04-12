package project.screens.BookTable;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import project.business.Book;
import project.business.SystemController;
import project.dataaccess.Auth;
import project.dataaccess.DataAccess;
import project.dataaccess.DataAccessFacade;
import project.screens.BookScreen;

public class BookTable extends JTable {

    public BookTable(Object[][] rowData, Object[] columnNames) {

        super(new TableModel(rowData, columnNames));
        getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 16));

        TableColumnModel columnModel = getColumnModel();

        columnModel.getColumn(0).setPreferredWidth(30);
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(2).setPreferredWidth(10);
        columnModel.getColumn(3).setPreferredWidth(10);
        columnModel.getColumn(4).setPreferredWidth(150);

        if (SystemController.currentAuth != Auth.LIBRARIAN) {
            columnModel.getColumn(4).setCellRenderer(new ButtonRenderer());
        }

        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = rowAtPoint(evt.getPoint());
                int col = columnAtPoint(evt.getPoint());
                if (row >= 0 && col == 4) {
                    Book book = (Book) getValueAt(row, col);
                    book.addCopy();
                    DataAccess da = new DataAccessFacade();
                    da.saveNewBook(book);
                    BookScreen.getInstance().render();
                }
            }
        });
    }

    public class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
        }

        @Override
        public java.awt.Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                boolean hasFocus,
                int row, int column) {
            setText("Add Copy");
            return this;
        }

    }
}
