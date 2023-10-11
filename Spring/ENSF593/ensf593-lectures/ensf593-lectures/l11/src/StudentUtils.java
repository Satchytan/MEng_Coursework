interface Tuition{
	public double getTuition();
}

//TODO: Add Income interface


//TODO: Add income to student class
class Student{
	private String fullName;
	private String id;
	private Tuition tuition;
	
	public Student(String f, String i, Tuition t){
		fullName = f;
		id = i;
		tuition = t;
		//TODO: Initialize income to null
	}
	
	//TODO: add a setter for income
	
	public double calculateTuition() {
		//TODO: add income, it is optional
		return tuition.getTuition();
	}
}
public class StudentUtils{}
