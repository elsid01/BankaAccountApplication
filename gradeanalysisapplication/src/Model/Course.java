package Model;

public class Course {
private int courseId;
private String courseName;
private String courseGrade;


public Course() {
	super();

}

public int getCourseId() {
	return courseId;
}

public void setCourseId(int courseId) {
	this.courseId = courseId;
}

public String getCourseName() {
	return courseName;
}

public void setCourseName(String courseName) {
	this.courseName = courseName;
}

public String getCourseGrade() {
	return courseGrade;
}

public void setCourseGrade(String courseGrade) {
	this.courseGrade = courseGrade;
}

public Course(int courseId, String courseName, String courseGrade) {
	super();
	this.courseId = courseId;
	this.courseName = courseName;
	this.courseGrade = courseGrade;
}


}
