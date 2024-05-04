package OOPPROJECT;

public class StudentCourse{
	public String name;
	public String symbol;
	public String grade;
	public int credits;
	public StudentCourse(String name, String symbol ,int credits) {
		this.name=name;
		this.symbol=symbol;
		this.credits=credits;
	  }
	public String getName() {
		return this.name;
	}
	public void setSymbol(String symbol) {
		 this.symbol=symbol;
	}
	public String getSymbol() {
		return this.symbol;
	}
	public void setName(String name) {
		 this.name=name;
	}
	public String getGrade() {
		return this.grade;
	}
	public void setGrade(String grade) {
		 this.grade=grade;
	}
	public int getCredits() {
		return this.credits;
	}
	public void setCredits(int credits) {
		 this.credits=credits;
	}
	
}
