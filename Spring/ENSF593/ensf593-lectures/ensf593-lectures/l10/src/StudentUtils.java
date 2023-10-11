//TODO: add Tuition interface
interface Tuition{
	public double getTuition();
}

//TODO: add Student class
class Student {
	private String fullName;
	private String id;
	private Tuition tuition;
	
	public Student(String fullName, String id, Tuition tuition) {
		this.fullName = fullName;
		this.id = id;
		this.tuition = tuition;
	}
	
	public double calculateTuition() {
		return this.tuition.getTuition();
	}
}

public class StudentUtils{}