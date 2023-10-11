/**
 * @author Satchytan Karalasingham
 *
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DataFrame {
    private String[] headerNames;
    private double[][] dataRows;
    private int numOfRows;
    private int numOfCols;

    /**
     * Constructs a DataFrame by reading data from a CSV file.
     *
     * @param fileName The name of the CSV file.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    public DataFrame(String fileName) throws IOException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);

        // Read header row
        String headerRow = scanner.nextLine();
        headerNames = headerRow.split(",");

        // Initialize data rows array
        dataRows = new double[100][headerNames.length];

        // Read data rows
        numOfRows = 0;
        while (scanner.hasNextLine()) {
            String dataRow = scanner.nextLine();
            String[] values = dataRow.split(",");
            for (int i = 0; i < headerNames.length; i++) {
                dataRows[numOfRows][i] = Double.parseDouble(values[i]);
            }
            numOfRows++;
        }

        numOfCols = headerNames.length;
        scanner.close();
    }

    /**
     * Gets the header names of the DataFrame.
     *
     * @return An array of header names.
     */
    public String[] getHeaderNames() {
        return headerNames;
    }

    /**
     * Gets the number of rows in the DataFrame.
     *
     * @return The number of rows.
     */
    public int getNumOfRows() {
        return numOfRows;
    }

    /**
     * Gets the number of columns in the DataFrame.
     *
     * @return The number of columns.
     */
    public int getNumOfCols() {
        return numOfCols;
    }

    /**
     * Gets a specific column of the DataFrame by index.
     *
     * @param columnIndex The index of the column.
     * @return A DataSeries object representing the column.
     */
    public DataSeries getColumnByIndex(int columnIndex) {
        DataSeries columnSeries = new DataSeries(headerNames[columnIndex]);
        for (int i = 0; i < numOfRows; i++) {
            double value = dataRows[i][columnIndex];
            columnSeries.add(value);
        }
        return columnSeries;
    }

    /**
     * Returns a string representation of the DataFrame.
     *
     * @return A string representation of the DataFrame.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.join(", ", headerNames)).append("\n");
        int limit = Math.min(numOfRows, 10);
        for (int i = 0; i < limit; i++) {
            for (int j = 0; j < numOfCols; j++) {
                sb.append(dataRows[i][j]);
                if (j < numOfCols - 1) {
                    sb.append(", ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
