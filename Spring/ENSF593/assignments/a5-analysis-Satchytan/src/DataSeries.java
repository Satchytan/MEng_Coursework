
/**
 * @author Satchytan Karalasingham
 *
 */

public class DataSeries implements IBasicStats {
    private String label;
    private double[] data;
    private int count;

    /**
     * Constructs a DataSeries object with a label.
     *
     * @param label The label for the DataSeries.
     */
    public DataSeries(String label) {
        this.label = label;
        this.data = new double[100];
        this.count = 0;
    }

    /**
     * Adds a value to the DataSeries.
     *
     * @param value The value to be added.
     */
    public void add(double value) {
        data[count] = value;
        count++;
    }

    /**
     * Gets the number of elements in the DataSeries.
     *
     * @return The size of the DataSeries.
     */
    public int size() {
        return count;
    }

    @Override
    public double getMin() {
        if (count == 0) {
            return 0.0;
        }
        double min = data[0];
        for (int i = 1; i < count; i++) {
            if (data[i] < min) {
                min = data[i];
            }
        }
        return min;
    }

    @Override
    public double getMax() {
        if (count == 0) {
            return 0.0;
        }
        double max = data[0];
        for (int i = 1; i < count; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }
        return max;
    }

    @Override
    public double getSum() {
        double sum = 0.0;
        for (int i = 0; i < count; i++) {
            sum += data[i];
        }
        return sum;
    }

    @Override
    public double getMean() {
        if (count == 0) {
            return 0.0;
        }
        double sum = getSum();
        return sum / count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(label).append(": ");
        for (int i = 0; i < Math.min(count, 10); i++) {
            sb.append(data[i]);
            if (i < count - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
