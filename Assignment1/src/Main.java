import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class Main {

	public static void main(String[] args) {
		readFile("C:\\Users\\lelea\\Desktop\\Course\\Programming 1/test.txt");

	}
	
	//Methods
	
	//Read file	
	public  static  boolean  readFile(String filename) {
			File file = new File(filename);
			int i = 0;
			boolean space = false;
	 		try { 
	 			Scanner scanner = new Scanner(file);
	 			while(scanner.hasNextLine()){	 				
	 				String[] words = scanner.nextLine().split(","); 
	 				//Add check for spaces
	 				for(int x = 0; x <= 8; x++) { if(words[x] == " ") { space = true; System.out.println("We found a space!"); i--;} }
	 				if (space == false) {
	 				int id = Integer.parseInt(words[i]);
	 				String firstName = words[i+1];
	 				String lastName = words[i+2];
	 				int mathMark1 = Integer.parseInt(words[i+3]);
	 				int mathMark2 = Integer.parseInt(words[i+4]);
	 				int mathMark3 = Integer.parseInt(words[i+5]);
	 				int englishMark1 = Integer.parseInt(words[i+6]);
	 				int englishMark2 = Integer.parseInt(words[i+7]);
	 				int englishMark3 = Integer.parseInt(words[i+8]);	 				
	 				addStudent(id,firstName,lastName,mathMark1,mathMark2,mathMark3,englishMark1,englishMark2,englishMark3);	 				 				
	 				}
	 				i++;	
	 				space = false;
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
