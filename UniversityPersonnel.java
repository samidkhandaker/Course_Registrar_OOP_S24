package OOPPROJECT;
import java.util.*;
public class UniversityPersonnel {
	public String id;
	public String password;
	public UniversityPersonnel(String id, String password) {
		  this.id=id;
		  this.password=password;
	  }
	 public void setID(String id) {
		  this.id=id;
	  }
	 public void setPassword(String password) {
		  this.password=password;
	  }
	 public String getID() {
		  return this.id;
	  }
	 public String getPassword() {
		  return this.password;
	  }
		/*
		 * private String createPassword() { String lower =
		 * "abcdefghijklmnopqrstuvwxyz"; String upper= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		 * String numbers = "0123456789"; String special = "!@#$%^&*()_+{}[]<>?"; String
		 * all = lower + upper + numbers + special; Random random = new Random(); int
		 * length = random.nextInt(11) + 10; char[] array = new char[length]; for(int
		 * i=0; i<length;i++) { int rand=random.nextInt(all.length());
		 * array[i]=all.charAt(rand); } return new String(array);
		 * 
		 * }
		 */
}
