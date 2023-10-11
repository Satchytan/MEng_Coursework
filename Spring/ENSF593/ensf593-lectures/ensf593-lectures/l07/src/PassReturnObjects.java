import java.util.Arrays;

public class PassReturnObjects {

	public static void setCoursesToZero(int nCourses) {
		nCourses=0;
	}
	
	public static void setCoursesToZero(Student s) {
		s.setNumberOfCourses(0);
	}
	
	public static Student setCoursesToZeroCopy(Student s) {
		Student newStudent = new Student(s.name, 0);
		return newStudent;
	}
	
	public static void main(String[] args) {
		Student[] students = {
				new Student("alice", 5),
				new Student("bob", 5),
				new Student("carol", 5)
		};
		
		Student[] updated = new Student[3];
		
		System.out.println("*** before:");
		System.out.println(Arrays.toString(students));
		System.out.println(Arrays.toString(updated));

		for(Student s: students) {
			//leaves objects unchanged (primitive type passed by value)
//			setCoursesToZero(s.getNumberOfCourses());
			//changes objects (objects passed by reference)
//			setCoursesToZero(s);
		}
		
		//copy objects leaves original unchanged
		for(int i=0; i<students.length;i++) {
			updated[i] = setCoursesToZeroCopy(students[i]);
		}
		
		System.out.println("\n*** after:");
		
		System.out.println(Arrays.toString(students));
		System.out.println(Arrays.toString(updated));

	}

}
