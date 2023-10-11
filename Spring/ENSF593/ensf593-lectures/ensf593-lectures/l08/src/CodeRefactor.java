abstract class Student{
	String fullName;
	String id;
	
	public abstract double calculateTuition();
}

class UndergraduateStudent extends Student{
	
	int numberOfCourses;
	double courseFee;
	double scholarship;

	UndergraduateStudent(String fullName, String id, int numberOfCourses, double courseFee, double scholarship) {
		this.fullName = fullName;
		this.id = id;
		this.numberOfCourses = numberOfCourses;
		this.courseFee = courseFee;
		this.scholarship = scholarship;
	}

	public double calculateTuition() {
		return numberOfCourses * courseFee - scholarship;
	}
}
class GraduateStudent extends Student{

	double programFee;
	int taHours;
	double taHourlyPay;

	GraduateStudent(String fullName, String id, double programFee, int taHours, double taHourlyPay) {
		this.fullName = fullName;
		this.id = id;
		this.programFee = programFee;
		this.taHours = taHours;
		this.taHourlyPay = taHourlyPay;
	}

	public double calculateTuition() {
		return this.programFee - (this.taHours*this.taHourlyPay);
	}
}
public class CodeRefactor {
	
	public static double sumTuition(Student[] students) {
		double sum = 0.0;
		for(Student s: students) {
			sum += s.calculateTuition();
		}
		return sum;
	}

	public static void main(String[] args) {
		UndergraduateStudent alice = new UndergraduateStudent("alice", "12", 1, 20, 10);
		System.out.println("alice: "+alice.calculateTuition());
		
		GraduateStudent bob = new GraduateStudent("bob", "34", 50, 2, 10);
		System.out.println("bob: "+bob.calculateTuition());
		
		Student[] students = {alice, bob};
		System.out.println(sumTuition(students));

	}

}
