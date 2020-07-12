import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.LinkedList;

public class Main {
	//Variables
	public static LinkedList<Student> students = new LinkedList<Student>();
	public static Scanner scanner = new Scanner(System.in);

	//Main method
	public static void main(String[] args) {
		readFile("C:\\Users\\lelea\\Desktop\\Course\\Programming 1/test.txt");
		displayMenu();
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
	 				int id = Integer.parseInt(words[0]);
	 				String firstName = words[1];
	 				String lastName = words[2];
	 				int mathMark1 = Integer.parseInt(words[3]);
	 				int mathMark2 = Integer.parseInt(words[4]);
	 				int mathMark3 = Integer.parseInt(words[5]);
	 				int englishMark1 = Integer.parseInt(words[6]);
	 				int englishMark2 = Integer.parseInt(words[7]);
	 				int englishMark3 = Integer.parseInt(words[8]);	 				
	 				addStudent(id,firstName,lastName,mathMark1,mathMark2,mathMark3,englishMark1,englishMark2,englishMark3);		 				
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
		students.addLast(student);
	}
	
	//GUI
	
	//Display information
		private static void displayReport(String type) {
			//Header
			System.out.println("Name\t\t\tMaths\tA1\tA2\tA3\t\tEnglish\tA1\tA2\tA3");
			for(int x = 0; x < 110; x++) { System.out.print("-"); }
			System.out.println("-");
			//Display student information
			int i = 0;
			switch(type) {
			case "marks":				
				for (int x = 0; x < students.size(); x++) {
				//Counter		
				Student currentStudentInfo = students.get(i);
				System.out.print(currentStudentInfo.getFullName());
				//Print full name and stop in correct position
				for(int y = 0; y < (32-currentStudentInfo.getFullName().length()); y++) { System.out.print(" "); }
				//Show math marks
				System.out.print(currentStudentInfo.mathMarks.getMark(1) + "\t" + currentStudentInfo.mathMarks.getMark(2) + "\t" + currentStudentInfo.mathMarks.getMark(3));
				//Show english marks
				System.out.print("\t\t\t" + currentStudentInfo.englishMarks.getMark(1) + "\t" + currentStudentInfo.englishMarks.getMark(2) + "\t" + currentStudentInfo.englishMarks.getMark(3));
				System.out.println("");
				i++;
				}
				break;
			case "grade":				
				for (int x = 0; x < students.size(); x++) {
				//Counter		
				Student currentStudentInfo = students.get(i);
				System.out.print(currentStudentInfo.getFullName());
				//Print full name and stop in correct position
				for(int y = 0; y < (32-currentStudentInfo.getFullName().length()); y++) { System.out.print(" "); }
				//Show math marks
				System.out.print(currentStudentInfo.mathMarks.getGrade(1) + "\t" + currentStudentInfo.mathMarks.getGrade(2) + "\t" + currentStudentInfo.mathMarks.getGrade(3));
				//Show english marks
				System.out.print("\t\t\t" + currentStudentInfo.englishMarks.getGrade(1) + "\t" + currentStudentInfo.englishMarks.getGrade(2) + "\t" + currentStudentInfo.englishMarks.getGrade(3));
				System.out.println("");
				i++;
				}
				break;
			}
			
		}
		
		//Menu
		
		//Display menu
		private static void displayMenu() {
			System.out.println("Student Report System");
			for(int x = 0; x <= 20; x++) { System.out.print("-"); }
			System.out.println("-");
			System.out.println("1) Display student marks");
			System.out.println("2) Display student grades");
			System.out.println("3) Add new student");
			System.out.println("4) Remove student");
			System.out.println("5) Exit");
		}
		
		//User input
		private static int selectMenuOption() {
			String userInput = scanner.nextLine();
			try {				
				if(Integer.parseInt(userInput) <= 5 && Integer.parseInt(userInput) >= 1) { return Integer.parseInt(userInput); } else {
					System.out.println("Invalid option, please enter a value from 1 to 5.");					
				}
			} catch(NumberFormatException e) {
				System.out.println("Invalid option, please enter a value from 1 to 5.");
			}
			//Stops error, change this in future
			return 0;
		}
		
		 
}
