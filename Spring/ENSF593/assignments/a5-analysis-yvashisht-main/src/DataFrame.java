import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author Yajur Vashisht
 * DataFrame reads the number of rows and columns in a csv and provides the min, max, sum, and mean of the 
 * data available in the column
 */

public class DataFrame {
	
	public String[] headerNames;
	private double[][] data;
	public int numOfRows;
	public int numOfCols;
	
    public DataFrame(String fileName) throws FileNotFoundException {
        File file = new File(fileName); //new file object
        Scanner scanner = new Scanner(file); //new scanner object

        String headerRow = scanner.nextLine(); //read Header of csv
        headerNames = headerRow.split(",");

        numOfCols = headerNames.length;

        data = new double[100][numOfCols];

        numOfRows = 0;
        while (scanner.hasNextLine()) { //continues reading while a value is avaliable
            String dataRow = scanner.nextLine();
            String[] values = dataRow.split(",");
            for (int i = 0; i < numOfCols; i++) {
                if (i < values.length) {
                    data[numOfRows][i] = Double.parseDouble(values[i]);
                } else {
                    data[numOfRows][i] = 0.0;
                }
            }
            numOfRows++;
        }
        scanner.close();
    }
	
	public String[] getHeaderNames() { //returns header names
		return headerNames;
	}
	
	public DataSeries getColumnByIndex(int index) { //If the index is >0 and < the number of columns to get the column data
		if (index >= 0 && index < numOfCols) {
			String label = headerNames[index];
			double[] columnData = new double[numOfRows];
			for (int i = 0; i < numOfRows; i++) {
				columnData[i] = data[i][index];
			}
			return new DataSeries(label, columnData);
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	public int getNumOfCols() {
		return numOfCols;
	}
	
	public int getNumOfRows() {
		return numOfRows;
	}
	
	@Override
    public String toString() { //displays the number of rows and columns
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.min(numOfRows, 10); i++) {
            for (int j = 0; j < numOfCols; j++) {
                sb.append(data[i][j]).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
