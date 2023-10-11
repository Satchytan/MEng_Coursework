abstract class Student{
	String fullName;
	String id;
	int taHours;
	double taHourlyPay;
	double scholarship;
	
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
	
	public abstract double calculateTuition() {
		return -(scholarship + taHours * taHourlyPay);
	}
}

class UndergraduateStudent extends Student {
	int numberOfCourses;
	double courseFee;
	double scholarship;

	UndergraduateStudent(String fullName, String id, int numberOfCourses, double courseFee) {
		super(fullName, id);
		this.numberOfCourses = numberOfCourses;
		this.courseFee = courseFee;
		this.taHours = taHours;
		this.taHourlyPay = taHourlyPay;
		this.scholarship = scholarship;
	}

	@Override
	public double calculateTuition() {
		return numberOfCourses * courseFee - scholarship;
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
		return this.programFee + super.calculateTuition;
	}
}
public class CodeRefactor {

	public static void main(String[] args) {
		UndergraduateStudent alice = new UndergraduateStudent("alice", "12", 1, 20);
		alice.setScholarship(10);
		System.out.println("alice: "+alice.calculateTuition());
		
		GraduateStudent bob = new GraduateStudent("bob", "34", 50);
		bob.setTA(10, 10);
		bob.setScholarship(10);
		System.out.println("bob: "+bob.calculateTuition());

	}

}
