import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class addClassGUI extends JDialog {
	private JTextField nameField, symbolField, timeField;
	private JComboBox<String> locationComboBox;
	private JSpinner creditsSpinner;
	private ArrayList<String> prerequisitesname = new ArrayList<String>();
	private ArrayList<Courses> prerequisites = new ArrayList<Courses>();
	public Courses newcourse;

	public addClassGUI(JFrame parent, ArrayList<Courses> courses) {
		super(parent, "Add Class", true);
		setSize(400, 300);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(parent);

		JPanel panel = new JPanel();

		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setBounds(78, 28, 40, 16);
		JLabel symbolLabel = new JLabel("Symbol:");
		symbolLabel.setBounds(68, 56, 50, 16);
		JLabel creditsLabel = new JLabel("Credits:");
		creditsLabel.setBounds(69, 84, 49, 16);
		JLabel locationLabel = new JLabel("Location:");
		locationLabel.setBounds(60, 112, 58, 16);
		JLabel timeLabel = new JLabel("Time:");
		timeLabel.setBounds(83, 140, 35, 16);
		JLabel prerequisitesLabel = new JLabel("Prerequisites:");
		prerequisitesLabel.setBounds(33, 168, 85, 16);

		nameField = new JTextField(15);
		nameField.setBounds(130, 23, 190, 26);
		symbolField = new JTextField(15);
		symbolField.setBounds(130, 51, 190, 26);
		creditsSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 6, 1));
		creditsSpinner.setBounds(130, 79, 37, 26);
		String[] locations = { "Bobst", "Silver", "Cantor", "Paulson" };
		locationComboBox = new JComboBox<>(locations);
		locationComboBox.setBounds(130, 108, 105, 27);
		timeField = new JTextField(15);
		timeField.setBounds(130, 135, 190, 26);

		JButton addPrerequisiteButton = new JButton("Add Prerequisite");
		addPrerequisiteButton.setBounds(150, 163, 147, 29);
		addPrerequisiteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String prerequisite = JOptionPane.showInputDialog(null, "Enter Prerequisite Class:");
				if (prerequisite != null && !prerequisite.isEmpty()) {
					prerequisitesname.add(prerequisite);
				}
			}
		});

		JButton saveButton = new JButton("Save");
		saveButton.setBounds(208, 217, 75, 29);
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String symbol = symbolField.getText();
				int credits = (int) creditsSpinner.getValue();
				String location = (String) locationComboBox.getSelectedItem();
				String time = timeField.getText();
				if (!prerequisitesname.isEmpty()) {
					for (String coursename : prerequisitesname) {
						for (Courses precourse : courses) {
							if (precourse.getName().equals(coursename)) {
								prerequisites.add(precourse);
							}
						}
					}
				}
				newcourse = new Courses(name, symbol, credits, location, time, prerequisites);
				dispose();

			}
		});
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBounds(107, 217, 86, 29);
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose(); // Close the dialog
			}
		});
		panel.setLayout(null);

		panel.add(nameLabel);
		panel.add(nameField);
		panel.add(symbolLabel);
		panel.add(symbolField);
		panel.add(creditsLabel);
		panel.add(creditsSpinner);
		panel.add(locationLabel);
		panel.add(locationComboBox);
		panel.add(timeLabel);
		panel.add(timeField);
		panel.add(prerequisitesLabel);
		panel.add(addPrerequisiteButton);
		panel.add(cancelButton);
		panel.add(saveButton);

		getContentPane().add(panel);
		setVisible(true);
	}

}
