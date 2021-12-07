package de.exxcellent.challenge.Reader;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CSVdataReaderTest {
    // Note: In a real case, it could be a bad idea to use this data for testing
    String mainResources = "src/main/resources/de/exxcellent/challenge/";
    private final String testCSVpath = "src/test/java/de/exxcellent/challenge/testResources/test.csv";
    private final String weatherCSVpath = mainResources + "weather.csv";
    private final String footballCSVpath = mainResources + "football.csv";

    // Extract 2 rows from test.csv
    @Test
    void testCSVExtractDataSetColumns1() {
        CSVdataReader csvReader = new CSVdataReader(testCSVpath);
        ArrayList<ArrayList<String>> incompleteDataSet
                = csvReader.extractDataSetColumns("Target", "Col2");
        assertEquals(4, incompleteDataSet.size());
        assertEquals("A", incompleteDataSet.get(0).get(0));
        assertEquals("D", incompleteDataSet.get(3).get(0));
        assertEquals("10", incompleteDataSet.get(3).get(1));
    }


    // Extract multiple rows from weather.csv
    @Test
    void weatherCSVExtractDataSetColumnsTest1() {
        CSVdataReader csvReader = new CSVdataReader(weatherCSVpath);
        ArrayList<ArrayList<String>> AvDP
                = csvReader.extractDataSetColumns("AvDP", "1HrP TPcpn", "R AvSLP");
        assertEquals("53.8", AvDP.get(0).get(0));
        assertEquals("0", AvDP.get(0).get(1));
        assertEquals("1004.5", AvDP.get(0).get(2));

        assertEquals("63.6", AvDP.get(29).get(0));
        assertEquals("0", AvDP.get(29).get(1));
        assertEquals("1022.7", AvDP.get(29).get(2));
    }

    // Extract a single row from football.csv
    @Test
    void footballCSVExtractDataSetColumnsTest1() {
        CSVdataReader csvReader = new CSVdataReader(footballCSVpath);
        ArrayList<ArrayList<String>> teams = csvReader.extractDataSetColumns("Team");
        assertEquals("Arsenal", teams.get(0).get(0));
        assertEquals("Liverpool", teams.get(1).get(0));
        assertEquals("Manchester United", teams.get(2).get(0));
        assertEquals("Leicester", teams.get(19).get(0));
    }

    // Selecting a column label that does not exist
    @Test
    void testMissingHeaderException() {
        CSVdataReader csVdataReader = new CSVdataReader(testCSVpath);
        assertThrows(IllegalArgumentException.class,
                () -> csVdataReader.extractDataSetColumns("Label that does not exist"));
    }
}