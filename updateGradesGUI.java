import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class updateGradesGUI extends JFrame {
	private JComboBox<String> studentComboBox;
	private JComboBox<String> courseComboBox;
	private JTextField gradeField;

	public updateGradesGUI(ArrayList<Student> students) {
		setTitle("Grade Entry");
		setSize(372, 230);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();

		JLabel studentLabel = new JLabel("Select Student:");
		studentLabel.setBounds(66, 42, 93, 16);
		JLabel courseLabel = new JLabel("Select Course:");
		courseLabel.setBounds(66, 91, 89, 16);
		JLabel gradeLabel = new JLabel("Enter Grade:");
		gradeLabel.setBounds(80, 119, 76, 16);

		studentComboBox = new JComboBox<>();
		studentComboBox.setBounds(171, 38, 150, 27);
		for (Student student : students) {
			studentComboBox.addItem(student.getName());
		}

		courseComboBox = new JComboBox<>();
		courseComboBox.setBounds(171, 87, 150, 27);
		studentComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedStudent = (String) studentComboBox.getSelectedItem();
				for (Student student : students) {
					if (student.getName().equals(selectedStudent)) {
						courseComboBox.removeAllItems();
						ArrayList<StudentCourse> courses = student.getCourses();
						for (StudentCourse course : courses) {
							courseComboBox.addItem(course.getName());
						}
						break;
					}
				}
			}
		});

		gradeField = new JTextField(10);
		gradeField.setBounds(171, 114, 150, 26);

		JButton saveButton = new JButton("Save");
		saveButton.setBounds(205, 152, 75, 29);
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedStudent = (String) studentComboBox.getSelectedItem();
				String selectedCourse = (String) courseComboBox.getSelectedItem();
				String grade = gradeField.getText();
				for (Student stud : students) {
					if (stud.getName().equals(selectedStudent)) {
						for (StudentCourse course : stud.getCourses()) {
							if (course.getName().equals(selectedCourse)) {
								course.setGrade(grade);
							}
						}
					}
				}

				gradeField.setText("");
			}
		});
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBounds(91, 152, 86, 29);
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel.setLayout(null);

		panel.add(studentLabel);
		panel.add(studentComboBox);
		panel.add(courseLabel);
		panel.add(courseComboBox);
		panel.add(gradeLabel);
		panel.add(gradeField);
		panel.add(saveButton);
		panel.add(cancelButton);

		getContentPane().add(panel);
		setVisible(true);
	}
}
