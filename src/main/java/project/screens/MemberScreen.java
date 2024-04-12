package project.screens;

import project.business.Author;
import project.business.LibraryMember;
import project.business.SystemController;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class MemberScreen extends Routes implements Component{
    private JButton button1;

    private static MemberScreen instance;
    private JPanel contentPane;
    private JTable dataTable;

    private MemberScreen() {
    }
    public static MemberScreen getInstance() {
//        if(instance == null){
//            instance = new MemberScreen();
//        }
        instance = new MemberScreen();
        return instance;
    }

    @Override
    public JPanel getMainPanel() {
        return contentPane;
    }

    void paintTableData(){
        String[] columnNames = { "ID", "Name", "Phone", "Address" };
        SystemController controller = new SystemController();
        HashMap<String, LibraryMember> members = controller.getAllLibraryMembers();

        Object[][] data = new Object[members.size()][];
        int index = 0;
        for(LibraryMember member: members.values()){
            data[index++] =(new Object[]{member.getMemberId(),member.getFirstName() + " " + member.getLastName(), member.getTelephone(), member.getAddress()});
        }

        dataTable = new JTable(data, columnNames);
        dataTable.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 16));
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
