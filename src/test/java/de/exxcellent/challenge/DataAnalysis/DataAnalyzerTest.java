package de.exxcellent.challenge.DataAnalysis;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataAnalyzerTest {

    private String testCSVpath = "src/test/java/de/exxcellent/challenge/testResources/test.csv";

    // Note: In a real case, it could be a bad idea to use this data for testing
    String mainResources = "src/main/resources/de/exxcellent/challenge/";
    private String weatherCSVpath = mainResources + "weather.csv";
    private String footballCSVpath = mainResources + "football.csv";


    @Test
    void minimalSpreadTest1(){
        DataAnalyzer testAnalyzer = new DataAnalyzer(testCSVpath);
        String smallestSpread = testAnalyzer
                .getTargetWithSmallestSpread("Target", "Col1", "Col2");

        assertEquals("C", smallestSpread);
    }

    @Test
    void weatherMinimalSpreadTest1(){
        DataAnalyzer weatherAnalyzer = new DataAnalyzer(weatherCSVpath);
        String smallestSpread = weatherAnalyzer
                .getTargetWithSmallestSpread("Day", "MxT", "MnT");

        assertEquals("14", smallestSpread);
    }

    @Test
    void weatherMinimalSpreadTest2(){
        DataAnalyzer weatherAnalyzer = new DataAnalyzer(weatherCSVpath);
        String smallestSpread = weatherAnalyzer
                .getTargetWithSmallestSpread("R AvSLP", "1HrP TPcpn", "R AvSLP");

        assertEquals("1004.5, 1004.5", smallestSpread);
    }


    @Test
    void footballMinimalSpreadTest1(){
        DataAnalyzer footballAnalyzer = new DataAnalyzer(footballCSVpath);
        String smallestSpread = footballAnalyzer
                .getTargetWithSmallestSpread("Team", "Goals", "Goals Allowed");

        assertEquals("Aston_Villa", smallestSpread);
    }

}