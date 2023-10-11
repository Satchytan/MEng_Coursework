import java.util.Arrays;

public class StudentStaticRef {
	public String name; //if static, we would only have one copy
	public int numberOfCourses; //if static, we would only have one copy
	
	public StudentStaticRef(String name, int nCourses){
		this.name = name;
		this.numberOfCourses = nCourses;
	}
	
	public String toString() {
		return name + "("+this.numberOfCourses+")";
	}

	public static double getTuition(int nCourses, double courseFee) {
		return nCourses * courseFee;
	}
	
	
	public static void main(String[] args) {
		StudentStaticRef[] students = {
				new StudentStaticRef("alice", 5),
				new StudentStaticRef("bob", 2),
				new StudentStaticRef("carol", 1)
		};
	
		System.out.println(Arrays.toString(students));

		students[2].numberOfCourses -= 2;
		
		double courseFee = 50.0;
		double sum = 0.0;
		for(StudentStaticRef s: students) {
			// works, but less clear 
			//sum += s.getTuition(s.numberOfCourses, courseFee);
			//preferred: Using class name
			sum += StudentStaticRef.getTuition(s.numberOfCourses, courseFee);
		}
		System.out.println("Total course fees: "+ sum);
	}

}
