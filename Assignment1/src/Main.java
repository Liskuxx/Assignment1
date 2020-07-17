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
		
		boolean runMainLoop = true;
		while(runMainLoop) {
				displayMenu("main");
				int choice = selectMenuOption();
				switch (choice) {
				case 1:
					displayReport("marks");
					break;
				case 2:
					displayReport("grade");
					break;
				case 3:
					addNewStudent();
					break;
				case 4:
					removeStudent();
					break;
				case 5:
					runMainLoop = false;
					break;
				}
		}
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
	
	//Modifications to list
	
	//Add new student
	private static void addNewStudent() {		
		boolean finished = false;
		while(!finished) {
		//No menu being drawn as it is going to be kind of dynamic and requires logic that makes more sense to just keep it all together
		System.out.println("Student Report System");
		for(int x = 0; x <= 20; x++) { System.out.print("-"); }
		System.out.println("-");
		System.out.print("Please enter the students ID here: ");
		int ID = scanner.nextInt();
		System.out.print("Please enter the students first name here: ");
		String fName = scanner.next();
		System.out.print("Please enter the students last name here: ");
		String lName = scanner.next();		
		System.out.print("Please enter the students grade for maths assignment 1 here: ");
		int math1 = scanner.nextInt();
		System.out.print("Please enter the students grade for maths assignment 2 here: ");
		int math2 = scanner.nextInt();
		System.out.print("Please enter the students grade for maths assignment 3 here: ");
		int math3 = scanner.nextInt();
		System.out.print("Please enter the students grade for English assignment 1 here: ");
		int english1 = scanner.nextInt();
		System.out.print("Please enter the students grade for English assignment 2 here: ");
		int english2 = scanner.nextInt();
		System.out.print("Please enter the students grade for English assignment 3 here: ");
		int english3 = scanner.nextInt();
		
		//Validation of data
		
		//Make sure ID is unique
		for (int x = 0; x < students.size(); x++) {
			//Counter
			int i = 0;
			Student currentIdCheck = students.get(i);
			int currentId = currentIdCheck.getID();
			if (currentId != ID) { 
				//Create student object
				Student newStudent = new Student(ID, fName, lName); 
				newStudent.mathMarks.setMark(1, math1);
				newStudent.mathMarks.setMark(2, math2);
				newStudent.mathMarks.setMark(3, math3);
				newStudent.englishMarks.setMark(1,  english1);
				newStudent.englishMarks.setMark(2,  english2);
				newStudent.englishMarks.setMark(3,  english3);
				
				//Add to the list
				students.add(newStudent);
				finished = true;
			} else {
				System.out.println("Id already in use, please pick another"); 
			}
			i++;
		}
		
		}
		
	}
	
	//Delete student from list
	private static void removeStudent() {
		int idToRemove;
		System.out.println("Please enter the ID of the student you would like to remove");
		idToRemove = scanner.nextInt();
		
		student studentToRemove;
		
		//Counter
		int z = 0;
		
		while(z<students.size()) {
			student currentStudentCheck = students.get(z);
			if (currentStudentCheck.getId() == idToRemove) [
				students.remove(z);
				z = students.size() + 1;		
			}
			z++;	
		}
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
			System.out.println("\nEnter any letter and press enter to return to the main menu..");
			scanner.nextLine();
			
		}
		
		//Menu
		
		//Display menu
		private static void displayMenu(String Menu) {
			System.out.println("Student Report System");
			for(int x = 0; x <= 20; x++) { System.out.print("-"); }
			System.out.println("-");
			switch (Menu) {
			case "main":				
				System.out.println("1) Display student marks");
				System.out.println("2) Display student grades");
				System.out.println("3) Add new student");
				System.out.println("4) Remove student");
				System.out.println("5) Exit");
				break;
			case "removeStudent":
				System.out.print("Please enter the students ID of which you wish to remove: ");
				break;
			}			
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
