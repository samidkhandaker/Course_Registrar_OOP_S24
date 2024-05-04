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
	public void setYear(String year) {
		this.year=year;
	}
	public void setCourses(ArrayList<StudentCourse>  courses) {
		this.courses=new ArrayList<StudentCourse>(courses);
	}
	public int getGPA(ArrayList<Courses>  courselist) {
		int totalScore=0;
		int totalCredits=0;
		for(StudentCourse course : courses) {
			for(Courses coursedata:courselist){
			if(course.getName().equals(coursedata.getName())) {
			totalCredits+=coursedata.getCredit();
			if(course.getGrade().equals("A")) {
				totalScore+=(4*coursedata.getCredit());
			}
			else if(course.getGrade().equals("A-")) {
				totalScore+=(3.6666*coursedata.getCredit());
			}
			else if(course.getGrade().equals("B+")) {
				totalScore+=(3.3333*coursedata.getCredit());
			}
			else if(course.getGrade().equals("B")) {
				totalScore+=(3*coursedata.getCredit());
			}
			else if(course.getGrade().equals("B-")) {
				totalScore+=(2.6666*coursedata.getCredit());
			}
			else if(course.getGrade().equals("C+")) {
				totalScore+=(2.3333*coursedata.getCredit());
			}
			else if(course.getGrade().equals("C")) {
				totalScore+=(2*coursedata.getCredit());
			}
			else if(course.getGrade().equals("C-")) {
				totalScore+=(1.6666*coursedata.getCredit());
			}
			else if(course.getGrade().equals("D+")) {
				totalScore+=(1.3333*coursedata.getCredit());
			}
			else if(course.getGrade().equals("D")) {
				totalScore+=(1*coursedata.getCredit());
			}
			else if(course.getGrade().equals("D-")) {
				totalScore+=(0.6666*coursedata.getCredit());
			}
			else if(course.getGrade().equals("F")) {
				totalScore+=0;
			}
			}
			}
		}
		int finalGPA=totalScore/totalCredits;
		return finalGPA;
	}
	String getTranscript(ArrayList<Courses>  courselist) {
		String transcript="";
		for(StudentCourse course : courses) {
			for(Courses coursedata:courselist){
				if(course.getName().equals(coursedata.getName())) {
			String coursetxt=course.getName()+" "+coursedata.getSymbol()+" "+course.getGrade()+"\n";
			transcript+=coursetxt;
				}
			}
		}
		return transcript;
	}
}
