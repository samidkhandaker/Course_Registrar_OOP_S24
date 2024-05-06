import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class editDialog extends JDialog {
	private JTextField nameField;
	private JTextField passwordField;
	private String name = "";
	private String password = "";

	public editDialog(JFrame parent) {
		super(parent, "Edit Profile", true); // true for modal dialog
		setSize(474, 259);
		setLocationRelativeTo(parent);

		JPanel panel = new JPanel();

		JLabel nameLabel = new JLabel("New Name:");
		nameLabel.setBounds(84, 85, 71, 16);
		JLabel passwordLabel = new JLabel("New Password:");
		passwordLabel.setBounds(61, 127, 94, 16);
		JLabel infoLabel = new JLabel("Leave the field empty to keep the current name or password");
		infoLabel.setBounds(49, 34, 377, 16);

		nameField = new JTextField(15);
		nameField.setBounds(183, 80, 212, 26);
		passwordField = new JTextField(15);
		passwordField.setBounds(183, 122, 212, 26);

		JButton saveButton = new JButton("Save");
		saveButton.setBounds(244, 188, 75, 29);
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				name = nameField.getText();
				password = passwordField.getText();
				dispose(); // Close the dialog
			}
		});
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBounds(129, 188, 86, 29);
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose(); // Close the dialog
			}
		});
		panel.setLayout(null);

		panel.add(nameLabel);
		panel.add(nameField);
		panel.add(passwordLabel);
		panel.add(passwordField);
		panel.add(infoLabel); // Info label for instructions
		JLabel label = new JLabel();
		label.setBounds(455, 50, 0, 0);
		panel.add(label); // Empty label for spacing
		// panel.add(new JLabel()); // Empty label for spacing
		panel.add(cancelButton);
		panel.add(saveButton);

		getContentPane().add(panel);
		setVisible(true);
	}

	public String getEditedName() {
		return name;
	}

	public String getEditedPassword() {
		return password;
	}
}
