import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class dropClassGUI extends JFrame {
	public dropClassGUI(Student student) {
		setTitle("Delete Class");
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();

		JLabel courseLabel = new JLabel("Choose a class to drop:");
		courseLabel.setBounds(29, 65, 148, 16);
		JComboBox<String> courseComboBox = new JComboBox<>();
		courseComboBox.setBounds(188, 61, 176, 27);
		for (StudentCourse course : student.getCourses()) {
			courseComboBox.addItem(course.getName());
		}

		JLabel infoLabel = new JLabel();
		infoLabel.setBounds(240, 53, 0, 0);

		JButton deleteButton = new JButton("Delete Class");
		deleteButton.setBounds(187, 124, 122, 29);
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedClassName = (String) courseComboBox.getSelectedItem();
				student.removeCourse(selectedClassName);
				infoLabel.setText("Dropped class: " + selectedClassName);
			}
		});

		JButton goBackButton = new JButton("Back");
		goBackButton.setBounds(92, 124, 75, 29);
		goBackButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel.setLayout(null);

		panel.add(courseLabel);
		panel.add(courseComboBox);
		panel.add(deleteButton);
		panel.add(goBackButton);
		panel.add(infoLabel);

		getContentPane().add(panel);
		setVisible(true);
	}
}
