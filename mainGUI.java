import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.io.*;

public class mainGUI extends JFrame implements Serializable {
	protected String id;
	protected String password;
	private JTextField idField;
	private JTextField passwordField;
	private JLabel idLabel, passwordLabel;
	public ArrayList<Administrator> admins = new ArrayList<Administrator>();
	public ArrayList<Student> students = new ArrayList<Student>();
	public ArrayList<Courses> courses = new ArrayList<Courses>();

	public mainGUI() {
		//Initial login cases to start the program
		Administrator superadmin = new Administrator("superadmin", "0", "123");
		admins.add(superadmin);
		Student stud1 = new Student("1", "1", "HAPPYA", "Freshman");
		students.add(stud1);

		/* Extra instantiation if desired
		 * Student stud1=new Student("1","1","HAPPYA","Freshaman"); Student stud2=new
		 * Student("2","11","HAPPYFAKE","Senior"); students.add(stud1);
		 * students.add(stud2); StudentCourse orgo=new
		 * StudentCourse("orgo","CHEM-UA-125",5); StudentCourse cs=new
		 * StudentCourse("basic","CSCI-310",4); StudentCourse orgo2=new
		 * StudentCourse("orgo2","CHEM-UA-126",5); Courses newchem=new Courses("orgo",
		 * "CHEM-UA-125", 5, "Bobst","Mon 5:00PM-6:15PM", null); courses.add(newchem);
		 * Courses newchem1=new Courses("orgo2", "CHEM-UA-126", 5,
		 * "Bobst","Mon 8:00AM-9:15AM", courses); courses.add(newchem1); Courses
		 * newcs=new Courses("basic", "CSCI-310", 4, "Silver","Tue 5:00PM-6:15PM",
		 * null); courses.add(newcs); orgo.setGrade("A"); cs.setGrade("B+");
		 * orgo2.setGrade("C-"); ArrayList<StudentCourse> stucourses=new
		 * ArrayList<StudentCourse>(); stucourses.add(cs); stud1.setCourses(stucourses);
		 * stucourses.add(orgo); stud2.setCourses(stucourses); stucourses.add(orgo2);
		 * Courses newchem=new Courses("orgo", "CHEM-UA-125", 5,
		 * "Bobst","Mon 5:00PM-6:15PM", null); courses.add(newchem); Courses
		 * newchem1=new Courses("orgo2", "CHEM-UA-126", 5, "Bobst","Mon 8:00AM-9:15AM",
		 * courses); courses.add(newchem1); Courses newcs=new Courses("basic",
		 * "CSCI-310", 4, "Silver","Tue 5:00PM-6:15PM", null); courses.add(newcs);
		 */

		setTitle("Login");
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		idLabel = new JLabel("ID:");
		idLabel.setBounds(101, 41, 18, 16);

		passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(56, 79, 63, 16);

		idField = new JTextField(15);
		idField.setBounds(131, 36, 220, 26);

		passwordField = new JPasswordField(15);
		passwordField.setBounds(131, 74, 220, 26);

		JButton loginButton = new JButton("Login");
		loginButton.setBounds(159, 124, 79, 29);
		loginButton.addActionListener(e -> {
			boolean isadmin = false;
			boolean isstudent = false;
			this.id = idField.getText();
			this.password = passwordField.getText();
			String id = idField.getText();
			String password = passwordField.getText();
			for (Administrator admin : admins) {
				if (admin.getID().equals(id)) {
					if (admin.getPassword().equals(password)) {
						isadmin = true;
						adminGUI ad = new adminGUI(id, admins, students, courses);
					}
				}
			}
			if (!isadmin) {
				for (Student stud : students) {
					if (stud.getID().equals(id)) {
						if (stud.getPassword().equals(password)) {
							isstudent = true;
							new studentGUI(stud, courses);
						}

					}
				}
			}
			if (!isadmin && !isstudent) {
				idField.setText("");
				passwordField.setText("");
			}

		});
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 400, 172);
		panel.setLayout(null);
		panel.add(idLabel);
		panel.add(idField);
		panel.add(passwordLabel);
		panel.add(passwordField);
		panel.add(loginButton);

		getContentPane().add(panel);
		setVisible(true);
	}
}
