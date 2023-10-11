/**
 * @author Yajur Vashisht
 * DataSeries uses IBasicStats to get the min, max, mean, and sum of the provided csv columns.
 * Furthermore, it uses StringBuilder to append the results to label.
 */
public class DataSeries implements IBasicStats{
	
	public String label;
	public double[] data;
	public int count;
	
	// Setting the initial values
	public DataSeries(String label, double[] data) {
		this.label = label;
		this.data = data;
		this.count = data.length;
	}
	
	public void add(double value) {
		data[count++] = value;
	}
	
	int size() {
		return count;
	}
	
	//Calculates the min of the provided data using a loop or tells user that the count is 0
	@Override
	public double getMin() {
		if (count == 0) {
			throw new IllegalStateException("No elements have been added.");
		}
		
		double min = data[0];
		for (int i = 1; i < count; i++) {
			if (data[i] < min) {
				min = data[i];
			}
		}
		return min;
	}
	
	//Calculates the max of the provided data using a loop or tells user that the count is 0
	@Override
	public double getMax() {
		if (count == 0) {
			throw new IllegalStateException("No elements have been added.");
		}
		
		double max = data[0];
		for (int i = 1; i < count; i++) {
			if (data[i] > max) {
				max = data[i];
			}
		}
		return max;
	}
	
	//Calculates the sum of the provided data using a loop
	@Override
	public double getSum() {
		double sum = 0;
		for (int i = 0; i < count; i++) {
			sum += data[i];
		}
		return sum;
	}
	
	//Calculates the mean of the provided data using the getSum() method and count variable
	@Override
	public double getMean() {
		if (count == 0) {
			throw new IllegalStateException("No elements have been added.");
		}
		return getSum()/count;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(label).append(": ");
		for (int i =0; i < count; i++) {
			sb.append(data[i]);
			if (i < count -1 ) {
				sb.append(" ,");
			}
		}
		return sb.toString();
	}
}
