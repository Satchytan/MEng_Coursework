import java.util.Arrays;

public class Student{
	
	public String name;
	private int numberOfCourses;
	
	public Student() {
		this("",0);
	}
	
	public Student(String n, int nCourses) {
		this.name = n;
		this.setNumberOfCourses(nCourses);
	}
	
	public int getNumberOfCourses() {
		return this.numberOfCourses;
	}
	
	public void setNumberOfCourses(int nCourses) {
		if(nCourses>0) {
			this.numberOfCourses = nCourses;
		}else {
			this.numberOfCourses = 0;
		}
	}
	
	public String toString() {
		return this.name+"("+this.numberOfCourses+")";
	}
	
	// return type not part of signature
//	public int getTuition() {
//		return (int)(this.numberOfCourses * 10.0);
//	}
	
	public double getTuition() {
		return this.numberOfCourses * 10.0;
	}
	
	public double getTuition(double courseFee) {
		return this.numberOfCourses * courseFee;
	}

	public double getTuition(double courseFee, double rebate) {
		return this.numberOfCourses * courseFee - rebate;
	}
	
	public static void main(String[] args) {
		
		Student[] students = {
				new Student("alice", 0),
				new Student("bob", 0),
				new Student("carol", 0)
		};
		
		System.out.println(Arrays.toString(students));
		
		for(int i=0; i<students.length; i++) {
			students[i].numberOfCourses += 1;
		}
		System.out.println(Arrays.toString(students));
		
		for(Student s: students) {
			s.numberOfCourses +=1;
		}
		System.out.println(Arrays.toString(students));
		
		
		Student student = new Student("carlos", 1);
		System.out.println(student.getTuition());
		System.out.println(student.getTuition(50.0));
		System.out.println(student.getTuition(50.0, 10.0));
		
	}

}
