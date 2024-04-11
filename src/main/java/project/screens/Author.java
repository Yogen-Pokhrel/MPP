package project.screens;

import javax.swing.*;
import java.awt.*;

public class Author extends Routes implements Component {
    private JPanel contentPane;
    private JTable dataTable;

    private static Author instance;

    @Override
    public JPanel getMainPanel() {
        return contentPane;
    }

    public static Author getInstance() {
        if(instance == null){
            instance = new Author();
        }
        return instance;
    }

    void paintTableData(){
        String[] columnNames = { "ID", "Author Name" };
        String[][] data = {
                { "20", "Saurab" },
                { "30", "Abraham", }
        };

        dataTable = new JTable(data, columnNames);
        dataTable.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 16));

        //dataTable.setBounds(30, 40, 200, 300);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        paintTableData();
        UIDefaults defaults = UIManager.getLookAndFeelDefaults();
        defaults.putIfAbsent("Table.alternateRowColor", Color.LIGHT_GRAY);
    }

}
