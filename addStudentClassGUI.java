package OOPPROJECT;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class addStudentClassGUI extends JFrame{
	    public addStudentClassGUI(Student student, ArrayList<Courses> availableCourses) {
	        setTitle("Add Class");
	        setSize(400, 200);
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        setLocationRelativeTo(null);

	        JPanel panel = new JPanel();
	        panel.setLayout(new GridLayout(3, 2));

	        JLabel courseLabel = new JLabel("Choose a course:");
	        JComboBox<String> courseComboBox = new JComboBox<>();
	        for (Courses course : availableCourses) {
	            courseComboBox.addItem(course.getName());
	        }

	        JLabel infoLabel = new JLabel();

	        JButton addButton = new JButton("Add Class");
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
	                        StudentCourse newcourse=new StudentCourse(selectedCourse.getName(),selectedCourse.getSymbol(),selectedCourse.getCredit());
	                        student.addCourse(newcourse);
	                        infoLabel.setText("Enrolled in " + selectedCourse.getName());
	                    }
	                }
	            }
	        });

	        JButton cancelButton = new JButton("Back");
	        cancelButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                dispose();
	            }
	        });

	        panel.add(courseLabel);
	        panel.add(courseComboBox);
	        panel.add(addButton);
	        panel.add(cancelButton);
	        panel.add(infoLabel);

	        add(panel);
	        setVisible(true);
}
}
