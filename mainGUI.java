package OOPPROJECT;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
public class mainGUI extends JFrame implements Serializable{
	protected String id;
	protected String password;
	private JTextField idField;
	private JTextField passwordField;
	private JLabel idLabel, passwordLabel;
	public ArrayList<Administrator> admins=new ArrayList<Administrator>();
	public ArrayList<Student> students=new ArrayList<Student>();
	public ArrayList<Courses> courses=new ArrayList<Courses>();
	public mainGUI(){
		//Runtime.getRuntime().addShutdownHook(new Thread(() -> saveData()));
		Administrator superadmin=new Administrator("superadmin","0","123");
		admins.add(superadmin);
		Student stud1=new Student("1","1","HAPPYA","Freshaman");
		Student stud2=new Student("2","11","HAPPYFAKE","Senior");
		students.add(stud1);
		students.add(stud2);
		StudentCourse orgo=new StudentCourse("orgo","CHEM-UA-125",5);
		StudentCourse cs=new StudentCourse("basic","CSCI-310",4);
		StudentCourse orgo2=new StudentCourse("orgo2","CHEM-UA-126",5);
		Courses newchem=new Courses("orgo", "CHEM-UA-125", 5,  "Bobst","Mon 5:00PM-6:15PM", null);
		courses.add(newchem);
		Courses newchem1=new Courses("orgo2", "CHEM-UA-126", 5,  "Bobst","Mon 8:00AM-9:15AM", courses);
		courses.add(newchem1);
		Courses newcs=new Courses("basic", "CSCI-310", 4,  "Silver","Tue 5:00PM-6:15PM", null);
		courses.add(newcs);
		orgo.setGrade("A");
		cs.setGrade("B+");
		orgo2.setGrade("C-");
		ArrayList<StudentCourse> stucourses=new ArrayList<StudentCourse>();
		stucourses.add(cs);
		stud1.setCourses(stucourses);
		stucourses.add(orgo);
		stud2.setCourses(stucourses);
		stucourses.add(orgo2);
		setTitle("Login");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        idLabel = new JLabel("ID:");
        passwordLabel = new JLabel("Password:");

        idField = new JTextField(15);
        passwordField = new JPasswordField(15);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> {
        	boolean isadmin=false;
        	boolean isstudent=false;
        	this.id=idField.getText();
        	this.password=passwordField.getText();
            String id = idField.getText();
            String password = passwordField.getText();
            for(Administrator admin: admins) {
            	if(admin.getID().equals(id)) {
            		if(admin.getPassword().equals(password)) {
            			isadmin=true;
            			this.dispose();
            			adminGUI ad=new adminGUI(id, admins, students, courses);
            			for(Courses newcourse:ad.newcourses) {
            				courses.add(newcourse);
            			}
            			for(Student newstudent:ad.newstudents) {
            				students.add(newstudent);
            			}
            			//ad.show();
            		}
            	}
            }
            if(!isadmin) {
            	for(Student stud: students) {
                	if(stud.getID().equals(id)) {
                		if(stud.getPassword().equals(password)) {
                			isstudent=true;
                			this.dispose();
                			new studentGUI(stud,courses);
                		}
                	
            }
            	}
            }
            if(!isadmin && !isstudent) {
            	idField.setText("");
            	passwordField.setText("");
            }
            
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(idLabel);
        panel.add(idField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel()); // empty label for spacing
        panel.add(loginButton);

        add(panel);

        setVisible(true); 
       
    }
	/*
	 * public void saveData() { try (ObjectOutputStream outputStream = new
	 * ObjectOutputStream(new FileOutputStream(
	 * "C:\\Users\\saeed\\eclipse-workspace\\Hello\\src\\OOPPROJECT\\database.bin"))
	 * ) { outputStream.writeObject(admins); outputStream.writeObject(students);
	 * outputStream.writeObject(courses); //
	 * System.out.println("Data saved successfully."); } catch (IOException e) {
	 * //System.err.println("Error saving data: " + e.getMessage()); } } public void
	 * loadData() { try (ObjectInputStream inputStream = new ObjectInputStream(new
	 * FileInputStream(
	 * "C:\\Users\\saeed\\eclipse-workspace\\Hello\\src\\OOPPROJECT\\database.bin"))
	 * ) { admins = (ArrayList<Administrator>) inputStream.readObject(); students =
	 * (ArrayList<Student>) inputStream.readObject(); courses = (ArrayList<Courses>)
	 * inputStream.readObject(); // System.out.println("Data loaded successfully.");
	 * } catch (IOException | ClassNotFoundException e) { //
	 * System.err.println("Error loading data: " + e.getMessage()); } }
	 */
}
