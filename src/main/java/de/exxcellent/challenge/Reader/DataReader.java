package de.exxcellent.challenge.Reader;

import java.util.ArrayList;

public interface DataReader {
    /**
     * Extract columns of data set into nested lists.
     * @param columns Column labels to extract
     * @return Nested lists of String. Outer list = line ; inner list = column
     */
    ArrayList<ArrayList<String>> extractDataSetColumns(String... columns);
}
