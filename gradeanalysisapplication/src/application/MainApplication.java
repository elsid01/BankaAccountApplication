package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import Model.Course;
import Model.Student;
import appDAO.CourseDAO;
import appDAO.StudentDAO;



public class MainApplication {

	public static void main(String[] args) {
    Scanner scanner =new Scanner(System.in);
    
    System.out.println("[1] Create Course");
    System.out.println("[2] Enter students'grade per course");
    System.out.println("[3] Show course average grade");
    System.out.println("[1] Show course's minimum and maximum grades");
    
    int answer = scanner.nextInt();
    if(answer == 1){
       CourseDAO courseDAO = new CourseDAO();
       List<Course> courseList =  courseDAO.getAllCourses();
       System.out.println("Enter course name:");
       Course course =new Course();
       course.setCourseName(scanner.nextLine());
       
       
       StudentDAO studentDAO =new StudentDAO();
       ArrayList<Student> StudentList = studentDAO.getStudent();
       Student student = new Student();
       
       System.out.println("Enter students'id:");
       student.setStudentId(scanner.nextInt());
       
       System.out.println("Enter students'name:");
       student.setStudentName(scanner.nextLine()); 
       
       System.out.println("Enter students'name:");
       student.setStudentEmail(scanner.nextLine());
//		System.out.println("Enter course name:");
//		Course course = new Course();
//		course.setCourseName("Math");
//		course.getCourseName();

	}

}
}