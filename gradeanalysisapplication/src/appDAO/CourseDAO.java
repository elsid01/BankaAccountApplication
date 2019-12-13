package appDAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.Course;

public class CourseDAO {
	public static List<Course> getAllCourses(){
		ArrayList<Course> courseList = new ArrayList<Course>();

		try {
			File file = new File("C:\\Users\\perscholas_student\\gradeanalysisapplication\\src\\Model\\MathematicsGrades.cvs.rtf");
			Scanner type = new Scanner(file);
			//ArrayList<String[]> data = new ArrayList<String[]>();
			while(type.hasNext()) {
				Course course = new Course();
				String[] readString = type.nextLine().split(",");

				course.setCourseId(Integer.parseInt(readString[0]));
				course.setCourseName(readString[1]);
				course.setCourseGrade(readString[2]);
				courseList.add(course);
			}
			//close scanner
			type.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found!!?!");
			e.printStackTrace();
		}
		return courseList;
	}
}
