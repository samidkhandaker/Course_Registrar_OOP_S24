package OOPPROJECT;
import java.util.ArrayList;

public class Student extends UniversityPersonnel{
	public String name;
	public String year;
	public ArrayList<StudentCourse> courses=new ArrayList<StudentCourse>();
	public Student(String id, String password, String name, String year){
		super(id, password);
		this.name=name;
		this.year=year;
}
	public String getID() {
		return this.id;
	}
	public String getPassword() {
		return this.password;
	}
	public String getName() {
		return this.name;
	}
	public String getYear() {
		return this.year;
	}
	public ArrayList<StudentCourse> getCourses() {
		return this.courses;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setYear(String year) {
		this.year=year;
	}
	public void setCourses(ArrayList<StudentCourse>  courses) {
		this.courses=new ArrayList<StudentCourse>(courses);
	}
	public void addCourse(StudentCourse course) {
		this.courses.add(course);
	}
	public void removeCourse(String coursename) {
		for(StudentCourse course:courses) {
			if(course.getName().equals(coursename)) {
				courses.remove(course);
				return;
			}
		}
	}
	public float getGPA() {
		float totalScore=0;
		float totalCredits=0;
		for(StudentCourse course : courses) {
			if(course.getGrade()==null) {
				continue;
			}
			else if(course.getGrade().equals("A")) {
				totalScore+=(4*course.getCredits());
			}
			else if(course.getGrade().equals("A-")) {
				totalScore+=(3.6666*course.getCredits());
			}
			else if(course.getGrade().equals("B+")) {
				totalScore+=(3.3333*course.getCredits());
			}
			else if(course.getGrade().equals("B")) {
				totalScore+=(3*course.getCredits());
			}
			else if(course.getGrade().equals("B-")) {
				totalScore+=(2.6666*course.getCredits());
			}
			else if(course.getGrade().equals("C+")) {
				totalScore+=(2.3333*course.getCredits());
			}
			else if(course.getGrade().equals("C")) {
				totalScore+=(2*course.getCredits());
			}
			else if(course.getGrade().equals("C-")) {
				totalScore+=(1.6666*course.getCredits());
			}
			else if(course.getGrade().equals("D+")) {
				totalScore+=(1.3333*course.getCredits());
			}
			else if(course.getGrade().equals("D")) {
				totalScore+=(1*course.getCredits());
			}
			else if(course.getGrade().equals("D-")) {
				totalScore+=(0.6666*course.getCredits());
			}
			else if(course.getGrade().equals("F")) {
				totalScore+=0;
			}
			totalCredits+=course.getCredits();
			}
		float finalGPA=totalScore/totalCredits;
		return finalGPA;
	}
	public String getTranscript() {
		String transcript="";
		for(StudentCourse course : courses) {
			String coursetxt=course.getName()+" "+course.getSymbol()+" "+course.getGrade()+"\n";
			transcript+=coursetxt;
				}
		return transcript;
	}
	public boolean isEnrolled(String name) {
		for(StudentCourse stud:courses) {
			if(stud.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
}
