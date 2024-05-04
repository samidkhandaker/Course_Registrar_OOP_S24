package OOPPROJECT;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
//import java.util.Collections;
public class updateGradesGUI extends JFrame{
	private JComboBox<String> studentComboBox;
    private JComboBox<String> courseComboBox;
    private JTextField gradeField;

    public updateGradesGUI(ArrayList<Student> students) {
        setTitle("Grade Entry");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel studentLabel = new JLabel("Select Student:");
        JLabel courseLabel = new JLabel("Select Course:");
        JLabel gradeLabel = new JLabel("Enter Grade:");

        studentComboBox = new JComboBox<>();
        for (Student student : students) {
            studentComboBox.addItem(student.getName());
        }

        courseComboBox = new JComboBox<>();
        studentComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedStudent = (String) studentComboBox.getSelectedItem();
                for (Student student : students) {
                    if (student.getName().equals(selectedStudent)) {
                        courseComboBox.removeAllItems();
                        ArrayList<StudentCourse> courses = student.getCourses();
                      //  Collections.sort(courses); // Sort courses alphabetically
                        for (StudentCourse course : courses) {
                            courseComboBox.addItem(course.getName());
                        }
                        break;
                    }
                }
            }
        });

        gradeField = new JTextField(10);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedStudent = (String) studentComboBox.getSelectedItem();
                String selectedCourse = (String) courseComboBox.getSelectedItem();
                String grade = gradeField.getText();
                for(Student stud:students) {
                	if(stud.getName().equals(selectedStudent)) {
                		for(StudentCourse course:stud.getCourses()) {
                			if(course.getName().equals(selectedCourse)) {
                				course.setGrade(grade);
                			}
                		}
                	}
                }

                gradeField.setText("");
            }
        });
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        panel.add(studentLabel);
        panel.add(studentComboBox);
        panel.add(courseLabel);
        panel.add(courseComboBox);
        panel.add(gradeLabel);
        panel.add(gradeField);
        panel.add(new JLabel()); 
        panel.add(saveButton);
        panel.add(cancelButton);

        add(panel);
        setVisible(true);
    }
}
