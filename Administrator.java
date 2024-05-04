package OOPPROJECT;

public class Administrator extends UniversityPersonnel{
	public String name;
	public Administrator(String name, String id, String password){
		super(id, password);
		this.name=name;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name=name;
	}
}
