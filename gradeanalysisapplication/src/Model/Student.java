package Model;

public class Student {
 String studentName;
 int studentId;
 String studentEmail;
public Student() {
	super();
	
}
public String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}
public int getStudentId() {
	return studentId;
}
public void setStudentId(int studentId) {
	this.studentId = studentId;
}
public String getStudentEmail() {
	return studentEmail;
}
public void setStudentEmail(String studentEmail) {
	this.studentEmail = studentEmail;
}
public Student(String studentName, int studentId, String studentEmail) {
	super();
	this.studentName = studentName;
	this.studentId = studentId;
	this.studentEmail = studentEmail;
}
}
