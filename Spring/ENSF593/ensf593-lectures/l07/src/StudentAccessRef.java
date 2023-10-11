import java.util.Arrays;

public class StudentAccessRef {
	public static final double COURSE_FEE = 10.0;
	
	public String name;
	private int numberOfCourses;
	
	public StudentAccessRef(String name, int nCourses){
		this.name = name;
		this.setNumberOfCourses(nCourses);
	}
	
	public String toString() {
		return name + "("+this.numberOfCourses+")";
	}

	public int getNumberOfCourses() {
		return this.numberOfCourses;
	}
	public void setNumberOfCourses(int nCourses) {
		if(nCourses>0)this.numberOfCourses = nCourses;
		else this.numberOfCourses = 0;
	}
	
	public double getTuition(double courseFee) {
		return this.numberOfCourses * courseFee;
	}
}
