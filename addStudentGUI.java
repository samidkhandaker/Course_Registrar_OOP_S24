package OOPPROJECT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addStudentGUI extends JFrame {
    private JTextField idField, nameField, passwordField;
    private JComboBox<String> yearComboBox;
    public Student stud; 

    public addStudentGUI() {
        setTitle("Add Student");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel idLabel = new JLabel("ID:");
        JLabel passwordLabel = new JLabel("Password:");
        JLabel nameLabel = new JLabel("Name:");
        JLabel yearLabel = new JLabel("Year:");

        idField = new JTextField(15);
        passwordField = new JTextField(15);
        nameField = new JTextField(15);
        String[] years = {"Freshman", "Sophomore", "Junior", "Senior"};
        yearComboBox = new JComboBox<>(years);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String password = passwordField.getText();
                String name = nameField.getText();
                String year = (String) yearComboBox.getSelectedItem();
                stud=new Student(id, password, name, year);
               
                dispose();
            }
        });
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the dialog
            }
        });

        panel.add(idLabel);
        panel.add(idField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(yearLabel);
        panel.add(yearComboBox);
        panel.add(cancelButton); // empty label for spacing
        panel.add(addButton);

        add(panel);
        setVisible(true);
    }

}
