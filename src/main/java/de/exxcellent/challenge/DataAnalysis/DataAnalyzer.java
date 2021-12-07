package de.exxcellent.challenge.DataAnalysis;

import de.exxcellent.challenge.Reader.DataReader;
import de.exxcellent.challenge.Reader.DataReaderFactory;

import java.util.ArrayList;
import java.util.Arrays;

public class DataAnalyzer {

    private DataReader dataReader;

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
     * @return Value(s) of target column. Can return multiple values if the discrepancy
     * between col1 and col2 is equal for all of them
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

        return Arrays.toString(smallestSpreadRows.toArray()).replace("[", "").replace("]", "");
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

}