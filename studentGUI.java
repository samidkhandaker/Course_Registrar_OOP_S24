package OOPPROJECT;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class studentGUI extends JFrame{
	    public studentGUI(Student student, ArrayList<Courses> courses) {
	        setTitle("Student Panel");
	        setSize(400, 200);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);

	        JPanel panel = new JPanel();
	        panel.setLayout(new GridLayout(5, 1));

	        JLabel nameLabel = new JLabel("Name: " + student.getName());

	        JButton addClassButton = new JButton("Add Class");
	        addClassButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	new addStudentClassGUI(student, courses);
	            }
	        });

	        JButton dropClassButton = new JButton("Drop Class");
	        dropClassButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	new dropClassGUI(student);
	            }
	        });

	        JButton viewGradesButton = new JButton("View Grades");
	        viewGradesButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                new viewGradesGUI(student);
	            }
	        });

	        JButton editProfileButton = new JButton("Edit Profile");
	        editProfileButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	editDialog editDialog = new editDialog(studentGUI.this);
                    String newName = editDialog.getEditedName();
                    String newPassword = editDialog.getEditedPassword();
                           if(!newName.isEmpty()) {
                               student.setName(newName);
				nameLabel.setText("Name: " + student.getName());
                        }
                           if(!newPassword.isEmpty()) {
                               student.setPassword(newPassword);
                           }
	            }
	        });

	        panel.add(nameLabel);
	        panel.add(addClassButton);
	        panel.add(dropClassButton);
	        panel.add(viewGradesButton);
	        panel.add(editProfileButton);

	        add(panel);
	        setVisible(true);
	    }
}
