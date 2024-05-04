package OOPPROJECT;

import java.util.ArrayList;

public class Courses {
	public String name;
	public String symbol;
	public int credit;
	public String location;
	public String time;
	public ArrayList<Courses> prerequisites;
	public Courses(String name, String symbol, int credit,  String location,String time, ArrayList<Courses> prerequisites) {
		  this.name=name;
		  this.symbol=symbol;
		  this.credit=credit;
		  this.location=location;
		  this.time=time;
		  this.prerequisites=prerequisites;
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
}
