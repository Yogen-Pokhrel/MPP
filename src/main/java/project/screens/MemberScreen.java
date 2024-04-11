package project.screens;

import javax.swing.*;
import java.awt.*;

public class MemberScreen extends Routes implements Component{
    private JButton button1;

    private static MemberScreen instance;
    private JPanel contentPane;
    private JTable dataTable;

    private MemberScreen() {
    }
    public static MemberScreen getInstance() {
        if(instance == null){
            instance = new MemberScreen();
        }
        return instance;
    }

    @Override
    public JPanel getMainPanel() {
        return contentPane;
    }

    void paintTableData(){
        String[] columnNames = { "ID", "Name", "Address" };
        String[][] data = {
                { "20","Kundan Kumar Jha", "Fairfield 4031" },
                { "30","Anand Jha", "Ottomwa 6014", }
        };

        dataTable = new JTable(data, columnNames);
        dataTable.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 16));

        //dataTable.setBounds(30, 40, 200, 300);
    }

    @Override
    public void render() {
        Dashboard dash = Dashboard.getInstance();
        dash.setPageTitle("Members List");
        dash.setPageButtonTitle("Add Member");
        dash.setPageButtonVisibility(true);
        dash.repaintButtons(Routes.SCREENS.Members);
        JButton pageButton = dash.getPageButton();
        removeAllActionListenersOfButton(pageButton);
        pageButton.addActionListener(e -> navigateTo(Routes.SCREENS.AddMember));
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
