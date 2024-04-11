package project.screens;

import project.screens.Component;

import javax.swing.*;
import java.awt.*;

public class Book extends Routes implements Component {
    private JButton button1;

    private static Book instance;
    private JPanel contentPane;
    private JTable dataTable;

    private Book() {
    }
    public static Book getInstance() {
        if(instance == null){
            instance = new Book();
        }
        return instance;
    }

    @Override
    public JPanel getMainPanel() {
        return contentPane;
    }

    void paintTableData(){
        String[] columnNames = { "ID", "Book Name", "Author" };
        String[][] data = {
                { "20","Java 2", "Saurab" },
                { "30","Machine Learning", "Abraham", }
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
