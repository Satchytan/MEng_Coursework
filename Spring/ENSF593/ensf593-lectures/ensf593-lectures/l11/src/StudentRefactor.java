class UndergraduateTuition implements Tuition{
	private int numberOfCourses;
	private double courseFee;
	
	public UndergraduateTuition(int nCourses, double fee) {
		this.numberOfCourses = nCourses;
		this.courseFee = fee;
	}
	
	@Override
	public double getTuition() {
		return numberOfCourses*courseFee;
	}
}

//TODO: add scholarship class


public class StudentRefactor {

	public static void main(String[] args) {
		UndergraduateTuition tuition = new UndergraduateTuition(1, 20);
		
		Student alice = new Student("alice", "12", tuition);

		System.out.println("alice: "+alice.calculateTuition());

		//TODO: create a scholarship and add to alice, print
	}

}
