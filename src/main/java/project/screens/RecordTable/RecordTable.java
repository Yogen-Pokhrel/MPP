package project.screens.RecordTable;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class RecordTable extends JTable {

    public RecordTable(Object[][] rowData, Object[] columnNames) {
        super(new TableModel(rowData, columnNames));
        getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 16));
    }

    public void addActionListener(int _col, String text, TableAction action) {
        getColumnModel().getColumn(_col).setCellRenderer(new ButtonRenderer(text));

        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = rowAtPoint(evt.getPoint());
                int col = columnAtPoint(evt.getPoint());
                if (row >= 0 && col == _col) {
                    Object obj = getValueAt(row, col);
                    action.performAction(obj);
                }
            }
        });
    }

    public class ButtonRenderer extends JButton implements TableCellRenderer {

        private String text;
        public ButtonRenderer(String text) {
            this.text = text;
            setOpaque(true);
        }

        @Override
        public java.awt.Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                boolean hasFocus,
                int row, int column) {
            setText(text);
            return this;
        }

    }
}
