import java.util.Arrays;

public class TotalTuition {

	public static void main(String[] args) {
		Student[] students = {
				new Student("alice", 5),
				new Student("bob", 2),
				new Student("carol", -1)
		};
	
		
		System.out.println(Arrays.toString(students));

		students[2].setNumberOfCourses(students[2].getNumberOfCourses() - 2);
		
		double courseFee = 50.0;
		double sum = 0.0;
		for(Student s: students) {
			sum += s.getTuition(courseFee);
		}
		System.out.println("Total course fees: "+ sum);
		
	}

}
