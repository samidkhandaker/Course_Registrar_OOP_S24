package OOPPROJECT;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class adminGUI extends JFrame{
	public adminGUI(ArrayList<Courses> course) {
        setTitle("Admin Panel");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JButton addClassButton = new JButton("Add Class");
        JButton updateGradesButton = new JButton("Update Grades");
        JButton addStudentButton = new JButton("Add Student");

        addClassButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open Add Class GUI
            	addClassGUI ad=new addClassGUI(course);
                course.add(ad.newcourse);
            }
        });

        updateGradesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open Update Grades GUI
               // new UpdateGradesGUI();
            }
        });

        addStudentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open Add Student GUI
               // new AddStudentGUI();
            }
        });

        panel.add(addClassButton);
        panel.add(updateGradesButton);
        panel.add(addStudentButton);

        add(panel);
        setVisible(true);
}
}
