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
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(95, 31, 18, 16);
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 69, 63, 16);
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(73, 104, 40, 16);
        JLabel yearLabel = new JLabel("Year:");
        yearLabel.setBounds(82, 138, 31, 16);

        idField = new JTextField(15);
        idField.setBounds(128, 26, 190, 26);
        passwordField = new JTextField(15);
        passwordField.setBounds(128, 64, 190, 26);
        nameField = new JTextField(15);
        nameField.setBounds(128, 99, 190, 26);
        String[] years = {"Freshman", "Sophomore", "Junior", "Senior"};
        yearComboBox = new JComboBox<>(years);
        yearComboBox.setBounds(128, 134, 127, 27);

        JButton addButton = new JButton("Add");
        addButton.setBounds(211, 176, 86, 29);
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
        cancelButton.setBounds(113, 176, 86, 29);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the dialog
            }
        });
        panel.setLayout(null);

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

        getContentPane().add(panel);
        setVisible(true);
    }

}
