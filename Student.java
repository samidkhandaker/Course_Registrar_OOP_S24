package OOPPROJECT;
import java.util.ArrayList;

public class Student extends UniversityPersonnel{
	public String year;
	public ArrayList<StudentCourse> courses;
	Student(String id, String password, String year,ArrayList<StudentCourse> courses){
		super(id, password);
		this.year=year;
		this.courses=courses;
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
		this.courses=courses;
	}
	public int getGPA() {
		int totalScore=0;
		int totalCredits=0;
		for(StudentCourse course : courses) {
			totalCredits+=course.getCredit();
			if(course.getGrade().equals("A")) {
				totalScore+=(4*course.getCredit());
			}
			else if(course.getGrade().equals("A-")) {
				totalScore+=3.6666;
			}
			else if(course.getGrade().equals("B+")) {
				totalScore+=3.3333;
			}
			else if(course.getGrade().equals("B")) {
				totalScore+=3;
			}
			else if(course.getGrade().equals("B-")) {
				totalScore+=2.6666;
			}
			else if(course.getGrade().equals("C+")) {
				totalScore+=2.3333;
			}
			else if(course.getGrade().equals("C")) {
				totalScore+=2;
			}
			else if(course.getGrade().equals("C-")) {
				totalScore+=1.6666;
			}
			else if(course.getGrade().equals("D+")) {
				totalScore+=1.3333;
			}
			else if(course.getGrade().equals("D")) {
				totalScore+=1;
			}
			else if(course.getGrade().equals("D-")) {
				totalScore+=0.6666;
			}
			else if(course.getGrade().equals("F")) {
				totalScore+=0;
			}
		}
		int finalGPA=totalScore/totalCredits;
		return finalGPA;
	}
}
