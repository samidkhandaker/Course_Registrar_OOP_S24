import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.io.*;

public class adminGUI extends JFrame {

	private int index = 0;

	public adminGUI(String id, ArrayList<Administrator> admins, ArrayList<Student> students,
			ArrayList<Courses> course) {

		setTitle("Admin Panel");
		setSize(375, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();

		JButton addClassButton = new JButton("Add Course");
		addClassButton.setBounds(186, 66, 164, 39);
		JButton updateGradesButton = new JButton("Update Grades");
		updateGradesButton.setBounds(186, 117, 164, 39);
		JButton addStudentButton = new JButton("Add Student");
		addStudentButton.setBounds(186, 168, 164, 39);
		JButton editProfileButton = new JButton("Edit Profile");
		editProfileButton.setBounds(26, 66, 112, 39);
		JButton exitButton = new JButton("Exit");
		exitButton.setSize(65, 34);
		exitButton.setLocation(26, 173);

		int cur = 0;
		for (Administrator admin : admins) {
			if (admin.getID().equals(id)) {
				index = cur;
				break;
			}
			cur++;
		}

		JLabel nameLabel = new JLabel("Admin Name: " + admins.get(index).getName());
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setBounds(16, 16, 334, 29);

		addClassButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addClassGUI ad = new addClassGUI(adminGUI.this, course);
				course.add(ad.newcourse);
			}
		});

		updateGradesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new updateGradesGUI(students);
			}
		});

		addStudentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addStudentGUI addStud = new addStudentGUI(adminGUI.this);
				students.add(addStud.stud);
			}
		});
		editProfileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editDialog editDialog = new editDialog(adminGUI.this);
				String newName = editDialog.getEditedName();
				String newPassword = editDialog.getEditedPassword();
				for (Administrator admin : admins) {
					if (admin.getID().equals(id)) {
						if (!newName.isEmpty()) {
							admin.setName(newName);
							nameLabel.setText("Admin Name: " + admins.get(index).getName());
						}
						if (!newPassword.isEmpty()) {
							admin.setPassword(newPassword);
						}
						break;
					}
				}
			}
		});
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});
		panel.setLayout(null);
		panel.add(addClassButton);
		panel.add(updateGradesButton);
		panel.add(addStudentButton);
		panel.add(editProfileButton);
		panel.add(nameLabel);

		panel.add(exitButton);
		getContentPane().add(panel);
		setVisible(true);

	}

}
