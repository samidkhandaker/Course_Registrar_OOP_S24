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
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 400, 222);

        JLabel studentLabel = new JLabel("Select Student:");
        studentLabel.setBounds(70, 35, 93, 16);
        JLabel courseLabel = new JLabel("Select Course:");
        courseLabel.setBounds(74, 93, 89, 16);
        JLabel gradeLabel = new JLabel("Enter Grade:");
        gradeLabel.setBounds(87, 133, 76, 16);

        studentComboBox = new JComboBox<>();
        studentComboBox.setBounds(182, 31, 166, 27);
        for (Student student : students) {
            studentComboBox.addItem(student.getName());
        }

        courseComboBox = new JComboBox<>();
        courseComboBox.setBounds(182, 89, 166, 27);
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
        gradeField.setBounds(182, 128, 166, 26);

        JButton saveButton = new JButton("Save");
        saveButton.setBounds(218, 171, 86, 29);
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
        cancelButton.setBounds(108, 171, 86, 29);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        getContentPane().setLayout(null);
        panel.setLayout(null);

        panel.add(studentLabel);
        panel.add(studentComboBox);
        panel.add(courseLabel);
        panel.add(courseComboBox);
        panel.add(gradeLabel);
        panel.add(gradeField);
        JLabel label = new JLabel();
        label.setBounds(182, 51, 0, 0);
        panel.add(label); 
        panel.add(saveButton);
        panel.add(cancelButton);

        getContentPane().add(panel);
        setVisible(true);
    }
}
