package OOPPROJECT;

public class Administrator extends UniversityPersonnel{
	public String name;
	public Administrator(String name, String id, String password){
		super(id, password);
		this.name=name;
	}
	public void setGrade(Student stu, String courseName, String grade ) {
		for(StudentCourse course: stu.courses) {
			if(course.getName().equals(courseName)) {
				course.grade=grade;
				return;
			}
		}
	}
}
