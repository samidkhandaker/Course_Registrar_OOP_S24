package OOPPROJECT;

import java.util.ArrayList;

public class StudentCourse extends Courses{
	public String grade;
	public StudentCourse(String name, String symbol, int credit, int capacity,String time, ArrayList<Courses> prerequisites, String grade) {
		super (name, symbol, credit, capacity, time, prerequisites);
		this.grade=grade;
	  }
	public void setGrade(String grade) {
		this.grade=grade;
	}
	public String getGrade() {
		return this.grade;
	}
}
