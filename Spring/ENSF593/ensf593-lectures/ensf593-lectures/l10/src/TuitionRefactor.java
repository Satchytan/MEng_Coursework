
//TODO: add UndergraduateTuition
class UndergraduateTuition implements Tuition{
	private int numberOfCourses;
	private double courseFee;
	
	public UndergraduateTuition(int numberOfCourses, double courseFee){
		this.numberOfCourses = numberOfCourses;
		this.courseFee = courseFee;
	}
	
	@Override
	public double getTuition() {
		return this.numberOfCourses * this.courseFee;
	}
}

//TODO: add GraduateTuition

public class TuitionRefactor {

	public static void main(String[] args) {
		UndergraduateTuition tuition = new UndergraduateTuition(1, 20);
		
		Student alice = new Student("alice", "12", tuition);
		
		System.out.println("alice: "+alice.calculateTuition());
	}

}
