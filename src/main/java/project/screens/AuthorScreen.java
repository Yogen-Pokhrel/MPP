package project.screens;

import project.business.Author;
import project.business.Book;
import project.business.SystemController;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class AuthorScreen extends Routes implements Component {
    private JPanel contentPane;
    private JTable dataTable;

    private static AuthorScreen instance;

    @Override
    public JPanel getMainPanel() {
        return contentPane;
    }

    public static AuthorScreen getInstance() {
//        if(instance == null){
//            instance = new AuthorScreen();
//        }
        instance = new AuthorScreen();
        return instance;
    }

    void paintTableData(){
        String[] columnNames = { "ID", "Author Name", "Phone", "Address" };
        SystemController controller = new SystemController();
        HashMap<String, Author> authors = controller.getAllAuthors();

        Object[][] data = new Object[authors.size()][];
        int index = 0;
        for(Author author: authors.values()){
            data[index++] =(new Object[]{author.getAuthorId(),author.getFirstName() + " " + author.getLastName(), author.getTelephone(), author.getAddress()});
        }

        dataTable = new JTable(data, columnNames);
        dataTable.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 16));

        //dataTable.setBounds(30, 40, 200, 300);
    }

    @Override
    public void render() {
        Dashboard dash = Dashboard.getInstance();
        dash.setPageTitle("Authors List");
        dash.setPageButtonTitle("Add Author");
        dash.setPageButtonVisibility(true);
        dash.repaintButtons(SCREENS.Authors);
        JButton b = dash.getPageButton();
        removeAllActionListenersOfButton(b);
        b.addActionListener(e -> navigateTo(SCREENS.AddAuthor));
        JPanel mainPanel = dash.getInnerPanel();
        mainPanel.removeAll();
        mainPanel.add(getMainPanel());
        paintTableData();
        thread.setContentPane(dash.getMainPanel());
        refresh();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        paintTableData();
        UIDefaults defaults = UIManager.getLookAndFeelDefaults();
        defaults.putIfAbsent("Table.alternateRowColor", Color.LIGHT_GRAY);
    }

}
