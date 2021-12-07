package de.exxcellent.challenge.DataAnalysis;

import de.exxcellent.challenge.Reader.DataReader;
import de.exxcellent.challenge.Reader.DataReaderFactory;

import java.util.ArrayList;

/**
 * Class for data science tasks.
 */
public class DataAnalyzer {

    private final DataReader dataReader;

    public DataAnalyzer(String data) {
        DataReaderFactory dataReaderFactory = new DataReaderFactory();
        this.dataReader = dataReaderFactory.getDataReader(data);
    }

    /**
     * Returns target value for lines that have the smallest discrepancy between col1 and col2
     * in the entire data set
     *
     * @param targetName Label of the target column
     * @param col1       Label of first column
     * @param col2       Label of second column
     * @return Value(s) of target column. Can return multiple values if multiple
     * lines have the same minimum spread between col1 and col2.
     */
    public String getTargetWithSmallestSpread(String targetName, String col1, String col2) {
        // Extract relevant data set. Outer list = lines ; inner list = columns
        ArrayList<ArrayList<String>> dataSet = dataReader.extractDataSetColumns(targetName, col1, col2);

        // Initialize variables
        ArrayList<String> smallestSpreadRows = new ArrayList<>();
        double spreadMin = getSpread(dataSet.get(0).get(1), dataSet.get(0).get(2));

        // Find dataset with smallest spread between col1 and col2
        for (ArrayList<String> dataRow : dataSet) {
            double spread = getSpread(dataRow.get(1), dataRow.get(2));
            if (spread < spreadMin) {
                spreadMin = spread;
                smallestSpreadRows.clear();
                smallestSpreadRows.add(dataRow.get(0));
            } else if (spread == spreadMin) {
                // If multiple lines have the same min-spread, save all their target values
                smallestSpreadRows.add(dataRow.get(0));
            }
        }

        return removeBrackets(smallestSpreadRows.toString());
    }

    /**
     * Returns spread between two numerical values in String format
     *
     * @param first  value 1 (max)
     * @param second value 2 (min)
     * @return Spread between both values
     */
    private double getSpread(String first, String second) {
        double firstNumber = Double.parseDouble(first);
        double secondNumber = Double.parseDouble(second);

        return Math.abs(firstNumber - secondNumber);
    }

    /**
     * Removes surrounding brackets from a string for a cleaner output
     *
     * @param output String with surrounding brackets (e.g. "[A, B, C]")
     * @return e.g. "A, B, C"
     */
    private String removeBrackets(String output) {
        return output.replace("[", "").replace("]", "");
    }

}