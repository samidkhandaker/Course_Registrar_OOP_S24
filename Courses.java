package OOPPROJECT;

import java.util.ArrayList;

public class Courses {
	public String name;
	public String symbol;
	public int credit;
	public int capacity;
	public String time;
	public ArrayList<Courses> prerequisites;
	public Courses(String name, String symbol, int credit,  int capacity,String time, ArrayList<Courses> prerequisites) {
		  this.name=name;
		  this.symbol=symbol;
		  this.credit=credit;
		  this.capacity=capacity;
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
	public void setCapcity(int capacity) {
		  this.capacity=capacity;
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
	public int getCapcity() {
		  return this.capacity;
	  }
	public String getTime() {
		  return this.time;
	  }
	public ArrayList<Courses> getPrerequisites() {
		  return this.prerequisites;
	  }
}
