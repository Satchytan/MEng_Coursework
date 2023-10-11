/**
 * Computes and stores statistics of a set of grades
 * 
 * @author Satchytan Karalasingham
 * 
 */
public class Stats {

	private int grades[];
	private int count;

	/**
	 * Creates instance of Stats with grades array and initializes count variable
	 */
	public Stats() {
		grades = new int[100];	//initialize grades array setting limit to 100 values max
		count = 0;				//initialize count to zero
	}

	/**
	 * Adds the grade to the array and increments the count
	 * 
	 * @param grade
	 */
	public void add(int grade) {
		grades[count] = grade;	// Add grade to array
		count++;				// Increment count
	}
	
	/**
	 * Calculates and returns the mean of the grades
	 * 
	 * @return mean of grades
	 */
	public double getMean() {
		int sum = 0;
		for (int i=0; i<count; i++) {
			sum += grades[i];
		}
		return (double) sum / count; //casts sum to double for precision
	}
	
	/**
	 * 
	 * Sorts the first count elements of grades array with Bubble sort.
	 * 
	 * Bubble sort adapted
	 * from 5.2 Try-this: Sorting an array 
	 * in Java, a beginner's guide 9th ed 
	 * 
	 */
	public void sort() {
		int a, b, t;
		for(a=1; a<count; a++) {
			for(b=count-1;b>=a;b--) {
				if(grades[b-1]>grades[b]) {
					t = grades[b-1];
					grades[b-1] = grades[b];
					grades[b] = t;
				}
			}
			
		}
	}
	
	/**
	 * Calculates and returns the median of the grades
	 * 
	 * @return median of the grades
	 */
	public double getMedian() {
		sort(); 	//sorts the array from smallest to largest values
		if (count % 2 == 0) {		//if the number of values is even
			int index1 = (count / 2) - 1;	//sets index of middle-left value
			int index2 = (count / 2);		//sets index of middle-right value
			return (grades[index1] + grades[index2]) / 2.0;	//returns the average of 2 middle values
		} else {					//for off number of grades
			return grades[(count/2)];	//returns middle grade
		}
	}
	
	/**
	 * Returns a string representing the sorted grades along with calculated mean and median
	 */
	public String toString() {
		sort();		//sorts the array of grades
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count; i++) {
			sb.append(grades[i] + " ");
		}
		sb.append("\nMean: ").append(getMean());
		sb.append("\nMedian: ").append(getMedian());
		return sb.toString();
	}
	
}
