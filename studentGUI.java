import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class studentGUI extends JFrame{
	    public studentGUI(Student student, ArrayList<Courses> courses) {
	        setTitle("Student Panel");
	        setSize(369, 240);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);

	        JPanel panel = new JPanel();

	        JLabel nameLabel = new JLabel("Name: " + student.getName());
	        nameLabel.setBounds(26, 22, 310, 16);

	        JButton addClassButton = new JButton("Add Class");
	        addClassButton.setBounds(216, 56, 120, 29);
	        addClassButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	new addStudentClassGUI(student, courses);
	            }
	        });

	        JButton dropClassButton = new JButton("Drop Class");
	        dropClassButton.setBounds(216, 151, 120, 29);
	        dropClassButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	new dropClassGUI(student);
	            }
	        });

	        JButton viewGradesButton = new JButton("View Grades");
	        viewGradesButton.setBounds(216, 105, 120, 29);
	        viewGradesButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                new viewGradesGUI(student);
	            }
	        });

	        JButton editProfileButton = new JButton("Edit Profile");
	        editProfileButton.setBounds(26, 56, 112, 29);
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
	        JButton exitButton = new JButton("Exit");
	        exitButton.setBounds(26, 151, 75, 29);
	        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
                dispose(); 
            }
        });
	        panel.setLayout(null);

	        panel.add(nameLabel);
	        panel.add(addClassButton);
	        panel.add(dropClassButton);
	        panel.add(viewGradesButton);
	        panel.add(editProfileButton);
	        panel.add(exitButton);
	        getContentPane().add(panel);
	        setVisible(true);
	    }
}
