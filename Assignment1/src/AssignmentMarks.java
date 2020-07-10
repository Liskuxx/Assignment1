public class AssignmentMarks {
	//Variable declaration
	private String courseName;
	private int assignment1;
	private int assignment2;
	private int assignment3;
	
	
	//Constructor
	public AssignmentMarks(String name, int mark1, int mark2, int mark3) {
		courseName = name;
		assignment1 = mark1;
		assignment2 = mark2;
		assignment3 = mark3;
	}
	
	//Methods
	
	//Set values for assignments
	public void setMark(int assignmentNumber, int mark) {
		switch(assignmentNumber) {
		case 1:
			assignment1 = mark;
			break;
		case 2:
			assignment2 = mark;
			break;
		case 3: 
			assignment3 = mark;
			break;
		default:
			//Error, mostly for debugging, shouldn't run in final version
			System.out.println("Attempt to add marks to an assignment that doesn't exist.");
			break;
		}
	}
	
	//Set value for course name
	public void setCourseName(String name) {
		courseName = name;
	}
	
	//Return values for assignments
	public int getMark(int assignmentNumber) {
		switch(assignmentNumber) {
		case 1:
			return assignment1;
		case 2:
			return assignment2;
		case 3: 
			return assignment3;
		default:
			//Error, mostly for debugging, shouldn't run in final version
			System.out.println("Attempt to return marks to an assignment that doesn't exist.");
			return 0;//Maybe change this to return something better
		}
	}
	
	//Return value of courseName
	public String getCourseName() {
		return courseName;
	}
	
	//Return average value of all assignments
	public int getAverageMark() {
		return (assignment1 + assignment2 + assignment3) / 3;
	}
	
	//Calculate grade based on marks
	public String markToGrade(int mark) {
		if (mark < 0 || mark > 100) {
			//Error, making sure information has been entered into the system correctly before calculating grades.
			System.out.println("Invalid mark has been used");
			return "error";
		} else if (mark <= 40) {
			return "D";
		} else if (mark <= 49) {
			return "C-";
		} else if (mark <= 59) {
			return "C";
		} else if (mark <= 69) {
			return "C+";
		} else if (mark <= 74) {
			return "B-";
		} else if (mark <= 79) {
			return "B";
		} else if (mark <= 84) {
			return "B+";
		} else if (mark <= 89) {
			return "A-";
		} else if (mark <= 94) {
			return "A";
		} else if (mark >= 95 && mark <= 100) {
			return "A+";
		} 
		return "";//This is to stop the program thinking there's a chance nothing will be returned. Figure out how to remove this error
	}
	
	//Return grade of assignment
	public String getGrade(int assignmentNumber) {
		//Mark will = the mark for whatever assignment is requested. This allows the calculation for the grade to only have to be written once.
		int mark;
		switch(assignmentNumber) {		
		case 1:
			mark = assignment1;
			break;
		case 2:
			mark = assignment2;
			break;
		case 3: 
			mark = assignment3;
			break;
		default:
			//Error, mostly for debugging, shouldn't run in final version
			System.out.println("Attempt to get a grade for an assignment that doesn't exist.");
			return "Error";//Maybe change this to return something better
		}
		return markToGrade(mark);
	}
	
	//Return average grade from all assignments
	public String getAverageGrade() {
		int averageMark = getAverageMark();
		return markToGrade(averageMark);
	}
	
	
}
