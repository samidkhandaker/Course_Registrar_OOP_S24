import java.util.*;

public class UniversityPersonnel {
	public String id;
	public String password;

	public UniversityPersonnel(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public void setID(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getID() {
		return this.id;
	}

	public String getPassword() {
		return this.password;
	}
}
