package project.screens;

import project.business.Author;
import project.business.Book;
import project.business.SystemController;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AddBook extends JFrame implements Component{
    private JPanel contentPane;
    private static AddBook instance;
    private JTextField titleTextField;
    private JLabel addBookLabel;
    private JLabel titleLabel;
    private JLabel isbnNumLabel;
    private JTextField isbnNumTextField;
    private JLabel borrowTimeLabel;
    private JComboBox borrowTimeDropdown;
    private JLabel authorLabel;
    private JComboBox authorDropdown;
    private JButton addAuthorButton;
    private JList<String> selectedAuthorList;
    private DefaultListModel<String> selectedAuthorModel;
    private JPanel inner;
    private JButton saveButton;
    private JComboBox comboBox1;

    private void printListContents(JList<String> list) {
        ListModel<String> model = list.getModel(); // Get the model associated with the JList
        int size = model.getSize(); // Get the size of the model

        System.out.println("Contents of the list:");

        // Iterate over the elements of the model and print them
        for (int i = 0; i < size; i++) {
            String element = model.getElementAt(i);
            System.out.println(element);
        }
    }

    private AddBook() {
        authorDropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem = (String) authorDropdown.getSelectedItem();
                DefaultListModel<String> model = (DefaultListModel) selectedAuthorList.getModel(); // Get the model associated with the JList
                if(model.contains(selectedItem)){
                    model.removeElement(selectedItem);
                } else{
                    model.addElement(selectedItem);
                }
                if(model.isEmpty()){
                    authorDropdown.setSelectedIndex(-1);
                }
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Author> authorList = new ArrayList<>();
                int borrowTime = (int) borrowTimeDropdown.getSelectedItem();
                Book book = new Book(
                        isbnNumTextField.getText(),
                        titleTextField.getText(),
                        borrowTime,
                        authorList
                );

                SystemController controller = new SystemController();
            }
        });
    }

    @Override
    public JPanel getMainPanel() {
        return contentPane;
}

    public static AddBook getInstance() {
        if(instance == null){
            instance = new AddBook();
        }
        return instance;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
