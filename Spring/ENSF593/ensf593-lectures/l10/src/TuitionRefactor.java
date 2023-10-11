
//TODO: add UndergraduateTuition




public class TuitionRefactor {

	public static void main(String[] args) {
		UndergraduateTuition tuition = new UndergraduateTuition(1, 20);
		
		Student alice = new Student("alice", "12", tuition);
		
		System.out.println("alice: "+alice.calculateTuition());
	}

}
