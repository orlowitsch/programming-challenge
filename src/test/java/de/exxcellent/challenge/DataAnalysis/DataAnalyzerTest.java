package de.exxcellent.challenge.DataAnalysis;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataAnalyzerTest {

    private String testCSVpath = "src/test/java/de/exxcellent/challenge/testResources/test.csv";

    // Note: In a real case, it could be a bad idea to use this data for testing
    String mainResources = "src/main/resources/de/exxcellent/challenge/";
    private String weatherCSVpath = mainResources + "weather.csv";


    @Test
    void minimalSpreadTest(){
        DataAnalyzer testAnalyzer = new DataAnalyzer(testCSVpath);
        String smallestSpread = testAnalyzer
                .getTargetWithSmallestSpread("Target", "Col1", "Col2");

        assertEquals("[C]", smallestSpread);
    }

    @Test
    void weatherMinimalSpreadTest(){
        DataAnalyzer weatherAnalyzer = new DataAnalyzer(weatherCSVpath);
        String smallestSpread = weatherAnalyzer
                .getTargetWithSmallestSpread("Day", "MxT", "MnT");

        assertEquals("[14]", smallestSpread);
    }

}