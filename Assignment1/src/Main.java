import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class Main {

	public static void main(String[] args) {
		

	}
	
	//Methods
	
	//Read file	
	public  static  boolean  readFile(String filename) { File file =
			new File(filename);
	
	 		try { 
	 			Scanner scanner = new Scanner(file);
	 			while(scanner.hasNextLine()){
	 				String[] words = scanner.nextLine().split(","); 	 
	 
	 				addStudent(id,firstName,lastName,mathMark1,mathMark2,mathMark3,englishMark1,englishMark2,englishMark3);
	 			} 
	 			scanner.close(); 
	 			} catch (FileNotFoundException e) { 
	 				System.out.println("Failed to read file"); 
	 				} return true; 
				}	
	
	
	//Add a student
	public static void addStudent(int id, String firstName, String lastName, int mathsMark1, int mathsMark2, int mathsMark3, int englishMark1, int englishMark2, int englishMark3) {
		Student student = new Student(id, firstName, lastName);
		student.mathMarks.setCourseName("Math");
		student.mathMarks.setMark(1, mathsMark1);
		student.mathMarks.setMark(2, mathsMark2);
		student.mathMarks.setMark(3, mathsMark3);
		student.englishMarks.setCourseName("English");
		student.englishMarks.setMark(1, englishMark1);
		student.englishMarks.setMark(2, englishMark2);
		student.englishMarks.setMark(3, englishMark3);
	}
}
