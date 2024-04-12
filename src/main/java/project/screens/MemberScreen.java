package project.screens;

import project.business.*;
import project.dataaccess.DataAccess;
import project.dataaccess.DataAccessFacade;
import project.project.utils.validation.DialogUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
        String[] columnNames = { "ID", "Name", "Phone", "Address", "Action" };
        SystemController controller = new SystemController();
        HashMap<String, LibraryMember> members = controller.getAllLibraryMembers();

        Object[][] data = new Object[members.size()][];
        int index = 0;
        for(LibraryMember member: members.values()){
            data[index++] =(new Object[]{member.getMemberId(),member.getFirstName() + " " + member.getLastName(), member.getTelephone(), member.getAddress(), "View Checkout Record"});
        }

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        dataTable.setModel(model);
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
        dataTable = new JTable();
        dataTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = dataTable.rowAtPoint(evt.getPoint());
                int col = dataTable.columnAtPoint(evt.getPoint());
                if (row >= 0 && col == 4) {
                    String memberId = (String) dataTable.getValueAt(row, 0);
                    displayCheckoutBooks(memberId);
                }
            }
        });
        paintTableData();
        UIDefaults defaults = UIManager.getLookAndFeelDefaults();
        defaults.putIfAbsent("Table.alternateRowColor", Color.LIGHT_GRAY);
    }

    void displayCheckoutBooks(String memberId){
        SystemController controller = new SystemController();
        CheckoutRecord checkoutRecord = controller.getCheckoutRecordByMemberId(memberId);
        if(checkoutRecord == null){
            DialogUtils.showMessage("Member ID: " + memberId +"\nThis member has not checked out any books", "Checked out record");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for(CheckoutEntry checkoutEntry : checkoutRecord.getCheckoutEntry()){
            sb.append(checkoutEntry.getBook().getIsbn()).append(" - ").append(checkoutEntry.getBook().getTitle()).append(", Copy:").append(checkoutEntry.getBookCopy().getCopyNum()).append("\n");
        }
        DialogUtils.showMessage("Member ID: " + memberId + "\n" + sb.toString(), "Checked out record");
    }
}
