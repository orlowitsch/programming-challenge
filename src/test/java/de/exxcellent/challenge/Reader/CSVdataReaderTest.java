package de.exxcellent.challenge.Reader;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CSVdataReaderTest {
    private String testCSVpath = "src/test/java/de/exxcellent/challenge/testResources/test.csv";
    String mainResources = "src/main/resources/de/exxcellent/challenge/";
    private String weatherCSVpath = mainResources + "weather.csv";

    @Test
    void testCSVExtractDataSetColumns1(){
        CSVdataReader csvReader = new CSVdataReader(testCSVpath);
        ArrayList<ArrayList<String>> incompleteDataSet
                = csvReader.extractDataSetColumns("Target","Col2");
        assertEquals(4, incompleteDataSet.size());
        assertEquals("A", incompleteDataSet.get(0).get(0));
        assertEquals("D", incompleteDataSet.get(3).get(0));
        assertEquals("10", incompleteDataSet.get(3).get(1));
    }

    @Test
    void weatherCSVExtractDataSetColumnsTest1(){
        CSVdataReader csvReader = new CSVdataReader(weatherCSVpath);
        ArrayList<ArrayList<String>> AvDP
                = csvReader.extractDataSetColumns("AvDP","1HrP TPcpn","R AvSLP");
        assertEquals("53.8", AvDP.get(0).get(0));
        assertEquals("0", AvDP.get(0).get(1));
        assertEquals("1004.5", AvDP.get(0).get(2));

        assertEquals("63.6", AvDP.get(29).get(0));
        assertEquals("0", AvDP.get(29).get(1));
        assertEquals("1022.7", AvDP.get(29).get(2));
    }

}