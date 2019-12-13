package appDAO;

import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Model.Student;

public class StudentDAO {

	public static ArrayList<Student> getStudent(){
		
		ArrayList<Student> studentList= new ArrayList<Student>();
		
		try {
			File file = new File("C:\\Users\\perscholas_student\\gradeanalysisapplication\\src\\Model\\mathematics.cvs.rtf");
			Scanner type = new Scanner(file);
			while(type.hasNext()) {
				Student student = new Student();
				
				String[] readString = type.nextLine().split(",");

				student.setStudentId(Integer.parseInt(readString[0]));
				student.setStudentName(readString[1]);
				student.setStudentEmail(readString[2]);
				studentList.add(student);
			}
			//close scanner
			type.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found!!?!");
			e.printStackTrace();
		}
		return studentList;
	}
}
