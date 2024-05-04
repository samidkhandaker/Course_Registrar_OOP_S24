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
        setSize(467, 300);
        setLocationRelativeTo(parent);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 467, 272);

        JLabel nameLabel = new JLabel("New Name:");
        nameLabel.setBounds(74, 93, 71, 16);
        JLabel passwordLabel = new JLabel("New Password:");
        passwordLabel.setBounds(51, 163, 94, 16);
        JLabel infoLabel = new JLabel("Leave the field empty to keep the current name or password");
        infoLabel.setBounds(39, 36, 377, 16);
	    
        nameField = new JTextField(15);
        nameField.setBounds(157, 88, 259, 26);
        passwordField = new JTextField(15);
        passwordField.setBounds(157, 158, 259, 26);

        JButton saveButton = new JButton("Save");
        saveButton.setBounds(242, 222, 86, 29);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name = nameField.getText();
                password = passwordField.getText();
                dispose(); // Close the dialog
            }
        });
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(129, 222, 86, 29);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the dialog
            }
        });
        getContentPane().setLayout(null);
        panel.setLayout(null);

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(infoLabel); // Info label for instructions
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

