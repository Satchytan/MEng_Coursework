import java.util.Arrays;

public class TotalTuitionAccess {

	public static void main(String[] args) {
		StudentAccess[] students = {
				new StudentAccess("alice", 5),
				new StudentAccess("bob", 2),
				new StudentAccess("carol", 1)
		};
	
		System.out.println(Arrays.toString(students));

		students[2].numberOfCourses -= 2;
		
		double courseFee = 50.0;
		double sum = 0.0;
		for(StudentAccess s: students) {
			sum += s.getTuition(courseFee);
		}
		System.out.println("Total course fees: "+ sum);
	}


}
