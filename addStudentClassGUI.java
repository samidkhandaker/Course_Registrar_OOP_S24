import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class addStudentClassGUI extends JFrame {
	public addStudentClassGUI(Student student, ArrayList<Courses> availableCourses) {
		setTitle("Add Class");
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();

		JLabel courseLabel = new JLabel("Choose a course:");
		courseLabel.setBounds(36, 56, 108, 16);
		JComboBox<String> courseComboBox = new JComboBox<>();
		courseComboBox.setBounds(167, 52, 194, 27);
		for (Courses course : availableCourses) {
			courseComboBox.addItem(course.getName());
		}

		JLabel infoLabel = new JLabel();
		infoLabel.setBounds(381, 19, 0, 0);

		JButton addButton = new JButton("Add Class");
		addButton.setBounds(192, 125, 107, 29);
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedCourseName = (String) courseComboBox.getSelectedItem();
				Courses selectedCourse = null;
				for (Courses course : availableCourses) {
					if (course.getName().equals(selectedCourseName)) {
						selectedCourse = course;
						break;
					}
				}

				if (selectedCourse != null) {
					if (student.isEnrolled(selectedCourse.getName())) {
						infoLabel.setText("You are already enrolled in " + selectedCourse.getName());
					} else if (!selectedCourse.meetRequirments(student)) {
						infoLabel.setText("You don't meet the prerequisites.");
					} else if (!selectedCourse.enroll()) {
						infoLabel.setText("No more room in this course.");
					} else {
						StudentCourse newcourse = new StudentCourse(selectedCourse.getName(),
								selectedCourse.getSymbol(), selectedCourse.getCredit());
						student.addCourse(newcourse);
						infoLabel.setText("Enrolled in " + selectedCourse.getName());
					}
				}
			}
		});

		JButton cancelButton = new JButton("Back");
		cancelButton.setBounds(109, 125, 75, 29);
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel.setLayout(null);

		panel.add(courseLabel);
		panel.add(courseComboBox);
		panel.add(addButton);
		panel.add(cancelButton);
		panel.add(infoLabel);

		getContentPane().add(panel);
		setVisible(true);
	}
}
