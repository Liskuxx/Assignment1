import java.io.Console;
import java.io.File;
import java.util.ArrayList;
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
		readFile("C:\\studentdata.txt");//Unsure where data should be read from as course didn't specify, assuming that student data is put straight into c drive however this can be changed accordingly.
		
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
		//Create needed vars
		boolean finished = false;
		int math1 = 0, math2 = 0, math3 = 0, english1 = 0, english2 = 0, english3 = 0, ID = 0, currentId = 0, i = 0;
		String fName, lName;
		boolean idOkay = false;
		//Loop for error checking
		while(!finished) {		
		System.out.print("Please enter the students ID here: ");
		Scanner idInput = new Scanner(System.in);
        while (!idInput.hasNextInt() ) {
        	//Get ID
        	idInput = new Scanner(System.in);
            System.out.println("Please only enter numbers that haven't been used in past ids.");
            System.out.print("Please enter the students ID here: ");            
        }            
        ID = idInput.nextInt();     
		//Error check ID
		for (int x = 0; x < students.size(); x++) {
			//Counter
			Student currentIdCheck = students.get(x);
			currentId = currentIdCheck.getID();
			if (currentId != ID) {
				idOkay = true;
			} else {
				idOkay = false;
				System.out.println("Please only enter numbers that haven't been used in past ids.");
				addNewStudent();
			}
		}
			if (idOkay) { 	
				//Get names
				System.out.print("Please enter the students first name here: ");		
				fName = scanner.next();
				System.out.print("Please enter the students last name here: ");
				lName = scanner.next();		
				
				//Get grades
				ArrayList<Integer> allGrades = new ArrayList<Integer>();
				
				int counter = 0;

		        while (counter < 6) {
		        	if (counter < 3) {
		        		System.out.println("Please Enter Students Grade for Maths Assisgnment "+(counter + 1));
		        	} else {
		        		System.out.println("Please Enter Students Grade for English Assisgnment "+(counter - 2));
		        	}
		            
		            Scanner gradeInput = new Scanner(System.in);

		            if (!gradeInput.hasNextInt()) {
		                System.out.println("Please Only Enter Numbers.");
		            } else {
		                counter++;
		                allGrades.add(gradeInput.nextInt());
		            }
		        }
			
	        //Assign vars values
	        math1 = allGrades.get(0);
	        math2 = allGrades.get(1);
	        math3 = allGrades.get(2);
	        
	        english1 = allGrades.get(3);
	        english2 = allGrades.get(4);
	        english3 = allGrades.get(5);
	        
			//Finally add the student to the list
			addStudent(ID, fName, lName, math1, math2, math3, english1, english2, english3);				
			finished = true;			
			System.out.println("\nEnter any letter and press enter to return to the main menu..");
			scanner.next();
			break;
			}
			System.out.println("Please only enter numbers that haven't been used in past ids.");
			break;
		}
		}
		
	
	
	//Delete student from list
	private static void removeStudent() {
		int idToRemove;
		System.out.println("Please enter the ID of the student you would like to remove");
		idToRemove = scanner.nextInt();
		Student currentStudentCheck;
		//Counter
		for (int x = 0; x < students.size(); x++) {
			currentStudentCheck = students.get(x);
			if (currentStudentCheck.getID() == idToRemove) {
				students.remove(x);
				System.out.println("Student removed");
				break;
			} else {
				System.out.println("Student ID doesn't exist!");
				break;
			}
				
		}
		System.out.println("\nEnter any letter and press enter to return to the main menu..");
		scanner.next();	
		return;
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
				//Show English marks
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
				//Show English marks
				System.out.print("\t\t\t" + currentStudentInfo.englishMarks.getGrade(1) + "\t" + currentStudentInfo.englishMarks.getGrade(2) + "\t" + currentStudentInfo.englishMarks.getGrade(3));
				System.out.println("");
				i++;
				}
				break;
			}
			System.out.println("\nEnter any letter and press enter to return to the main menu..");
			scanner.next();
			
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
			System.out.println("");
			String userInput = scanner.next();
			try {				
				if(Integer.parseInt(userInput) <= 5 && Integer.parseInt(userInput) >= 1) { return Integer.parseInt(userInput); } else {
					System.out.println("Invalid option, please enter a value from 1 to 5.");					
				}
			} catch(NumberFormatException e) {
				System.out.println("Invalid option, please enter a value from 1 to 5.");
			}			
			//Stops error
			return 0;
		}
		
		 
}
