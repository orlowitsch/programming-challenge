package de.exxcellent.challenge.Reader;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class CSVdataReader implements DataReader {
    private String dataPath;

    public CSVdataReader(String dataPath) {
        this.dataPath = dataPath;
    }

    public ArrayList<ArrayList<String>> extractDataSetColumns(String... columns) {
        ArrayList<ArrayList<String>> dataSet = new ArrayList<>();
        try {
            CSVReader reader = new CSVReader(new FileReader(dataPath));
            String [] nextLine = reader.readNext();
            int[] columnIndices = getHeaderLocation(nextLine, columns);

            while ((nextLine = reader.readNext()) != null) {
                ArrayList<String> dataLine = new ArrayList<>();
                for(int index : columnIndices) {
                    if (index != -1){
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
     * Determine column indices for each header in columns
     * @param headers First line of CSV file which contains column headers
     * @param columns The column headers of interest for which indices are needed
     * @return numeric indices of columns. Returns -1 for column labels not contained in headers.
     * */
    private int[] getHeaderLocation(String[] headers, String... columns) {
        int[] indexes = new int[columns.length];
        int index = 0;
        for(String column : columns){
            indexes[index] = Arrays.asList(headers).indexOf(column);
            index++;
        }
        return indexes;
    }
}

