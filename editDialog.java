package OOPPROJECT;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class editDialog extends JDialog{
	private JTextField nameField;
    private JTextField passwordField;
    private String name = "";
    private String password = "";

    public editDialog(JFrame parent) {
    	super(parent, "Edit Profile", true); // true for modal dialog
        setSize(700, 300);
        setLocationRelativeTo(parent);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel nameLabel = new JLabel("New Name:");
        JLabel passwordLabel = new JLabel("New Password:");
        JLabel infoLabel = new JLabel("Leave the field empty to keep the current name or password");

        nameField = new JTextField(15);
        passwordField = new JTextField(15);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name = nameField.getText();
                password = passwordField.getText();
                dispose(); // Close the dialog
            }
        });

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(infoLabel); // Info label for instructions
        panel.add(new JLabel()); // Empty label for spacing
        panel.add(new JLabel()); // Empty label for spacing
        panel.add(saveButton);

        add(panel);
        setVisible(true);
    }

    public String getEditedName() {
        return name;
    }

    public String getEditedPassword() {
        return password;
    }
}

