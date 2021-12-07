package de.exxcellent.challenge.Reader;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class CSVdataReader implements DataReader {
    private final String dataPath;

    public CSVdataReader(String dataPath) {
        this.dataPath = dataPath;
    }

    public ArrayList<ArrayList<String>> extractDataSetColumns(String... columns) {
        ArrayList<ArrayList<String>> dataSet = new ArrayList<>();
        try {
            CSVReader reader = new CSVReader(new FileReader(dataPath));
            String[] nextLine = reader.readNext();
            int[] columnIndices = getHeaderLocation(nextLine, columns);

            while ((nextLine = reader.readNext()) != null) {
                ArrayList<String> dataLine = new ArrayList<>();
                for (int index : columnIndices) {
                    if (index != -1) {
                        dataLine.add(nextLine[index]);
                    }
                }
                dataSet.add(dataLine);
            }
            reader.close();
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        return dataSet;
    }

    /**
     * Determine column indices for each header in columns.
     * Throws exception if selected column headers (columns...) do not match headers in CSV file.
     *
     * @param headers First line of CSV file which contains column headers
     * @param columns The column headers of interest for which indices are needed
     * @return numeric indices of columns.
     */
    private int[] getHeaderLocation(String[] headers, String... columns) {
        int[] indexes = new int[columns.length];
        int index = 0;
        for (String column : columns) {
            int columnIndex = Arrays.asList(headers).indexOf(column);

            if (columnIndex == -1) {
                throw new IllegalArgumentException("Selected column (" + column + ") was not found in " +
                        "CSV data headers (" + Arrays.toString(headers) + ").");
            }

            indexes[index] = columnIndex;
            index++;
        }
        return indexes;
    }
}

