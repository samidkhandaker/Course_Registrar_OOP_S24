package OOPPROJECT;

import java.util.ArrayList;

public class Courses {
	public String name;
	public String symbol;
	public int credit;
	public int capacity;
	public int enrollment;
	public String location;
	public String time;
	public ArrayList<Courses> prerequisites=new ArrayList<Courses>();
	public Courses(String name, String symbol, int credit,  String location,String time, ArrayList<Courses> prerequisites) {
		  this.name=name;
		  this.symbol=symbol;
		  this.credit=credit;
		  this.location=location;
		  setCapacity(location);
		  this.enrollment=0;
		  this.time=time;
		  if(prerequisites!=null) {
		  this.prerequisites=new ArrayList<Courses>(prerequisites);
		  }
	  }
	public void setName(String name) {
		  this.name=name;
	  }
	public void setSymbol(String symbol) {
		  this.symbol=symbol;
	  }
	public void setCredit(int credit) {
		  this.credit=credit;
	  }
	public void setlocation(String location) {
		  this.location=location;
	  }
	public void setTime(String time) {
		  this.time=time;
	  }
	public void setprerequisites(ArrayList<Courses> prerequisites) {
		  this.prerequisites=prerequisites;
	  }
	public String getName() {
		  return this.name;
	  }
	public String getSymbol() {
		  return this.symbol;
	  }
	public int getCredit() {
		  return this.credit;
	  }
	public String getLocation() {
		  return this.location;
	  }
	public String getTime() {
		  return this.time;
	  }
	public ArrayList<Courses> getPrerequisites() {
		  return this.prerequisites;
	  }
	public boolean enroll() {
		if(enrollment<capacity) {
			enrollment++;
			return true;
		}
		return false;
	}
	public void deenroll() {
		enrollment--;
	}
	public boolean meetRequirments(Student stud) {
		if(prerequisites==null || prerequisites.isEmpty()) {
			return true;
		}
		ArrayList<StudentCourse> transcript=stud.getCourses();
		boolean check=false;
		for(Courses course:prerequisites) {
			for(StudentCourse studcourse:transcript) {
				if(course.getName().equals(studcourse.getName())) {
					check=true;
					break;
				}
			}
			if(!check) {
				return false;
			}
			check=false;
		}
		return true;
	}
	private void setCapacity(String location) {
		if(location.equals("Bobst")) {
			this.capacity=20;
		}
		else if(location.equals("Silver")) {
			this.capacity=60;
		}
		else if(location.equals("Cantor")) {
			this.capacity=100;
		}
		else if(location.equals("Paulson")) {
			this.capacity=25;
		}
	}
}
