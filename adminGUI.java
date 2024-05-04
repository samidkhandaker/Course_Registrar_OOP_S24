package OOPPROJECT;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class adminGUI extends JFrame{
	//public String id;
	public ArrayList<Courses> newcourses=new ArrayList<Courses>();
	public ArrayList<Student> newstudents=new ArrayList<Student>();
	public adminGUI(String id, ArrayList<Administrator> admins, ArrayList<Student> students, ArrayList<Courses> course) {
        setTitle("Admin Panel");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JButton addClassButton = new JButton("Add Class");
        JButton updateGradesButton = new JButton("Update Grades");
        JButton addStudentButton = new JButton("Add Student");
        JButton editProfileButton = new JButton("Edit Profile");

        addClassButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	addClassGUI ad=new addClassGUI(course);
                newcourses.add(ad.newcourse);
            }
        });

        updateGradesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new updateGradesGUI(students);
            }
        });

        addStudentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	addStudentGUI addStud=new addStudentGUI();
            	newstudents.add(addStud.stud);
            }
        });
        editProfileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	editDialog editDialog = new editDialog(adminGUI.this);
                String newName = editDialog.getEditedName();
                String newPassword = editDialog.getEditedPassword();
                for(Administrator admin:admins) {
                    if(admin.getID().equals(id)) {
                        if(!newName.isEmpty()) {
                            admin.setName(newName);
                        }
                        if(!newPassword.isEmpty()) {
                            admin.setPassword(newPassword);
                        }
                        break;
                    }
                }
                dispose();
            }
        });


        panel.add(addClassButton);
        panel.add(updateGradesButton);
        panel.add(addStudentButton);
        panel.add(editProfileButton);

        add(panel);
        setVisible(true);
}
}
