abstract class Student{
	String fullName;
	String id;
	double scholarship;
	int taHours;
	double taHourlyPay;
	
	Student(String f, String i){
		fullName = f;
		id = i;
		scholarship = 0.0;
		taHours = 0;
		taHourlyPay = 0.0;
	}
	
	public void setScholarship(double s) {
		scholarship = s;
	}
	
	public void setTA(int hours, double pay) {
		taHours = hours;
		taHourlyPay = pay;
	}
	
	public double calculateTuition() {
		return -(scholarship + taHours * taHourlyPay);
	}
}

class UndergraduateStudent extends Student {
	int numberOfCourses;
	double courseFee;

	UndergraduateStudent(String fullName, String id, int numberOfCourses, double courseFee) {
		super(fullName, id);
		this.numberOfCourses = numberOfCourses;
		this.courseFee = courseFee;
	}

	@Override
	public double calculateTuition() {
		return numberOfCourses * courseFee + super.calculateTuition();
	}
}
class GraduateStudent extends Student {
	double programFee;

	GraduateStudent(String fullName, String id, double programFee) {
		super(fullName, id);
		this.programFee = programFee;
	}

	@Override
	public double calculateTuition() {
		return this.programFee + super.calculateTuition();
	}
}
public class CodeRefactor {

	public static void main(String[] args) {
		UndergraduateStudent alice = new UndergraduateStudent("alice", "12", 1, 20);
		alice.setScholarship(10);
		System.out.println("alice: "+alice.calculateTuition());
		
		GraduateStudent bob = new GraduateStudent("bob", "34", 50);
		bob.setTA(2, 10);
		System.out.println("bob: "+bob.calculateTuition());

		bob.setScholarship(10);
		System.out.println("bob (with scholarship): "+bob.calculateTuition());
	}

}
