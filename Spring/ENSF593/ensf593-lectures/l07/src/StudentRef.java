import java.util.Arrays;

public class StudentRef {
	public static final double COURSE_FEE = 10.0;
	
	public String name;
	public int numberOfCourses;
	
	public StudentRef(String name, int nCourses){
		this.name = name;
		this.numberOfCourses = nCourses;
	}
	
	public String toString() {
		return name + "("+this.numberOfCourses+")";
	}

	public double getTuition() {
		return this.numberOfCourses * StudentRef.COURSE_FEE;
	}
	
	public double getTuition(double courseFee) {
		return this.numberOfCourses * courseFee;
	}
	
	public double getTuition(double courseFee, double rebate) {
		return this.numberOfCourses * courseFee - rebate;
	}
	
	public static void main(String[] args) {
		StudentRef[] students = {
				new StudentRef("alice", 0),
				new StudentRef("bob", 0),
				new StudentRef("carol", 0)
		};
		
		for(StudentRef s: students) {
			s.numberOfCourses +=1;
		}
		
		System.out.println(Arrays.toString(students));
		
		StudentRef s = new StudentRef("carlos", 1);
		System.out.println(s+" default "+s.getTuition());
		System.out.println(s+" 50.0 "+s.getTuition(50.0));
		System.out.println(s+" 50.0, 15.0 "+s.getTuition(50.0, 15.0));
	}

}
