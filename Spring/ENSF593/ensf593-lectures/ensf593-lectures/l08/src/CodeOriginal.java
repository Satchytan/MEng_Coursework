class UndergraduateStudent1 {
	String fullName;
	String id;
	int numberOfCourses;
	double courseFee;
	double scholarship;

	UndergraduateStudent1(String fullName, String id, int numberOfCourses, double courseFee, double scholarship) {
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
class GraduateStudent1 {
	String fullName;
	String id;
	double programFee;
	int taHours;
	double taHourlyPay;

	GraduateStudent1(String fullName, String id, double programFee, int taHours, double taHourlyPay) {
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
public class CodeOriginal {

	public static void main(String[] args) {
		UndergraduateStudent1 alice = new UndergraduateStudent1("alice", "12", 1, 20, 10);
		System.out.println("alice: "+alice.calculateTuition());
		
		GraduateStudent1 bob = new GraduateStudent1("bob", "34", 50, 2, 10);
		System.out.println("bob: "+bob.calculateTuition());

	}

}
