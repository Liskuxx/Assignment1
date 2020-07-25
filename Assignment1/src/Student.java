public class Student {
	//Declare variables, will all be public until tested and maybe will be altered to private
	public int id;
	public String firstName;
	public String lastName;
	public AssignmentMarks mathMarks = new AssignmentMarks("", 0, 0, 0);
	public AssignmentMarks englishMarks = new AssignmentMarks("", 0, 0, 0);
	
	//Methods
	
	//Constructor
	public Student(int ID, String FirstName, String LastName) {
		//The variables are capitalized in here to differentiate from the first time they are used above
		id = ID;
		firstName = FirstName;
		lastName = LastName;
	}
	
	//Return full name
	public String getFullName() {
		String fullName = firstName + " " + lastName;
		return fullName;
	}
	
	//Return ID
	public int getID() {
		return id;
	}
}
