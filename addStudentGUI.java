import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addStudentGUI extends JDialog {
	private JTextField idField, nameField, passwordField;
	private JComboBox<String> yearComboBox;
	public Student stud;

	public addStudentGUI(JFrame parent) {
		super(parent, "Add Student", true);
		setSize(400, 200);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(parent);
		
		JPanel panel = new JPanel();
		JLabel idLabel = new JLabel("ID:");
		idLabel.setBounds(120, 15, 18, 16);
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(75, 43, 63, 16);
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setBounds(98, 69, 40, 16);
		JLabel yearLabel = new JLabel("Year:");
		yearLabel.setBounds(107, 97, 31, 16);
		
		idField = new JTextField(15);
		idField.setBounds(157, 10, 190, 26);
		passwordField = new JTextField(15);
		passwordField.setBounds(157, 38, 190, 26);
		nameField = new JTextField(15);
		nameField.setBounds(157, 64, 190, 26);
		
		String[] years = { "Freshman", "Sophomore", "Junior", "Senior" };
		yearComboBox = new JComboBox<>(years);
		yearComboBox.setBounds(157, 93, 127, 27);
		
		JButton addButton = new JButton("Add");
		addButton.setBounds(209, 126, 75, 29);
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = idField.getText();
				String password = passwordField.getText();
				String name = nameField.getText();
				String year = (String) yearComboBox.getSelectedItem();
				stud = new Student(id, password, name, year);
				dispose();
			}
		});
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBounds(113, 126, 86, 29);
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
		panel.add(cancelButton);
		panel.add(addButton);

		getContentPane().add(panel);
		setVisible(true);
	}

}
